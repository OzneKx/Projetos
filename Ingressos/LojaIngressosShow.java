package ProjetosJava. Ingressos;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class LojaIngressosShow {
  // Métodos
  private boolean validaNumeroInteiro(String s) {
    try {
      Integer.parseInt(s);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  public void exibeProdutos(String dados) {
    JOptionPane.showMessageDialog(null, "PRODUTO\n*********\n" + dados);
  }

  public void salvaProdutos(ArrayList<Produto> produtos) {
    ObjectOutputStream outputStream = null;
    try {
      outputStream = new ObjectOutputStream(new FileOutputStream("c:\\temp\\lojaIngresso.dat"));
      for (int c = 0; c < produtos.size(); c++) {
        outputStream.writeObject(produtos.get(c));
      }
      JOptionPane.showMessageDialog(null, "Dados SALVOS com sucesso!");
    } catch (FileNotFoundException ex) {
      JOptionPane.showMessageDialog(null, "Nao foi possível criar arquivo!\n" + ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
    } catch (IOException ex) {
      JOptionPane.showMessageDialog(null, "Nao foi possível criar arquivo!\n" + ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
    } finally {
      try {
        if (outputStream != null) {
          outputStream.flush();
          outputStream.close();
        }
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
  }

  @SuppressWarnings("finally")
  public ArrayList<Produto> recuperaProdutos() {
    ArrayList<Produto> produtos = new ArrayList<Produto>();

    ObjectInputStream inputStream = null;

    try {
      inputStream = new ObjectInputStream(new FileInputStream("c:\\temp\\lojaIngresso.dat"));
      Object object = null;
      while ((object = inputStream.readObject()) != null) {
        if (object instanceof Produto) {
          produtos.add((Produto) object);
        }
      }
      JOptionPane.showMessageDialog(null, "Dados RECUPERADOS com sucesso!");
    } catch (EOFException ex) {
      System.out.println("End of file reached");
    } catch (ClassNotFoundException ex) {
      JOptionPane.showMessageDialog(null, "Nao foi possível recuperar arquivo!\n" + ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
    } catch (FileNotFoundException ex) {
      JOptionPane.showMessageDialog(null, "Nao foi possível recuperar arquivo!\n" + ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
    } catch (IOException ex) {
      JOptionPane.showMessageDialog(null, "Nao foi possível recuperar arquivo!\n" + ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
    } finally {
      try {
        if (inputStream != null) {
          inputStream.close();
        }
      } catch (final IOException ex) {
        ex.printStackTrace();
      }
      return produtos;
    }
  }

  public void menu() {
    ArrayList<Produto> produtos = new ArrayList<Produto>();
    Leitura leitura = new Leitura();

    int option1;

    do {
      String menu = 
        "\t\t=-=-=-= Ingressos de Shows =-=-=-=\n\n" + 
        "Opções:\n\n" + 
        "[1]  -  Informar Produtos\n" + 
        "[2]  -  Exibir Produtos\n" + "[3]  -  Limpar Produtos\n" + 
        "[4]  -  Registrar Produtos\n" + "[5]  -  Recuperar Produtos\n" + 
        "[0]  -  SAIR";

      String entrada = JOptionPane.showInputDialog(menu + "\n\n");
      while (!validaNumeroInteiro(entrada)) {
        entrada = JOptionPane.showInputDialog(null, menu + "\n\nEntrada invalida! Insira numeros inteiros");
      }

      option1 = Integer.parseInt(entrada);
      switch (option1) {
        case 1: // (Acessorios ou Ingressos)
          menu = "=-=-=-= Informar Produto =-=-=-=\n\n" + "Escolhas:\n\n" + "[1]  -  Ingressos\n" + "[2]  -  Acessorios";
          entrada = JOptionPane.showInputDialog(menu + "\n\n");
          while (!validaNumeroInteiro(entrada)) {
            entrada = JOptionPane.showInputDialog(null, menu + "\n\nEntrada invalida! Insira numeros inteiros");
          }

          int option2 = Integer.parseInt(entrada);
          switch (option2) {
            case 1: // (Ingressos)
              menu = "=-=-=-= Informar Ingressos =-=-=-=\n\n" + 
                "Escolhas:\n\n" + 
                "[1]  -  VIP\n" + 
                "[2]  -  VIP Plus" + 
                "\n\n\n[3]  -  Voltar";

              entrada = JOptionPane.showInputDialog(menu + "\n\n");
              while (!validaNumeroInteiro(entrada)) {
                entrada = JOptionPane.showInputDialog(null, menu + "\n\nEntrada invalida! Insira numeros inteiros");
              }

              int option3 = Integer.parseInt(entrada);
              switch (option3) {
                case 1:
                  produtos.add((Produto) leitura.leVIP());
                  break;
                case 2:
                  produtos.add((Produto) leitura.leVipPlus());
                  break;
                case 3:
                  break;
                default:
                  JOptionPane.showMessageDialog(null, "Ingresso de entrada nao informado!");
                  break;
              } 
              break;
              
            case 2: // (Acessorios)
              menu = 
                "=-=-=-= Informar Acessorios =-=-=-= \n\n" + 
                "Escolhas:\n\n" + 
                "[1]  -  Camisetas\n" + 
                "[2]  -  Bone" + 
                "\n\n\n[3]  -  Voltar";

              entrada = JOptionPane.showInputDialog(menu + "\n\n");
              while (!validaNumeroInteiro(entrada)) {
                entrada = JOptionPane.showInputDialog(null, menu + "\n\nEntrada invalida! Insira numeros inteiros");
              }

              option3 = Integer.parseInt(entrada);
              switch (option3) {
                case 1:
                  produtos.add((Produto) leitura.leCamisetas());
                  break;
                case 2:
                  produtos.add((Produto) leitura.leBone());
                  break;
                case 3:
                  break;
                default:
                  JOptionPane.showMessageDialog(null, "Acessorio de entrada nao informado!");
                  break;
              }
              break;
            default:
              System.out.println("Informe algum item do menu");
              break;
          }
          break;

        case 2: // (Exibição de Produtos)
          if (produtos.size() == 0) {
            JOptionPane.showMessageDialog(null, "Nao ha dados a serem exibidos");
            break;
          }

          String dados = "";
          for (int c = 0; c < produtos.size(); c++) {
            dados += produtos.get(c).toString() + "\n";
          }

          JOptionPane.showMessageDialog(null, dados);
          break;

        case 3: // (Limpeza de Produtos)
          produtos.clear();
          JOptionPane.showMessageDialog(null, "LIMPEZA de dados concluída com sucesso");
          break;

        case 4: // (Salvar de Produtos)
          if (produtos.size() == 0) {
            JOptionPane.showMessageDialog(null, "Primeiro informe um produto antes de SALVA-LO");
            break;
          }
          salvaProdutos(produtos);
          break;

        case 5: // (Recuperação de Produtos)
          produtos = recuperaProdutos();
          if (produtos.size() == 0) {
            JOptionPane.showMessageDialog(null, "Nao ha dados a serem RECUPERADOS");
            break;
          }
          break;
          
        case 0: // (Sair do Sistema)
          JOptionPane.showMessageDialog(null, "FINALIZADO o sistema de Lojas de Ingressos de Show");
          break;
      }
    } while (option1 != 0);
  }

  // Método main
  public static void main(String[] args) {
    LojaIngressosShow lojaIngressos = new LojaIngressosShow();

    lojaIngressos.menu();
  }
}
