package ProjetosJava. Ingressos;

import javax.swing.JOptionPane;

public class Leitura {
  // Métodos de leitura de valores
  public String[] leValor(String[] dados) {
    String[] dadosOut = new String[dados.length];

    for (int c = 0; c < dados.length; c++) {
      dadosOut[c] = JOptionPane.showInputDialog("Informe " + dados[c] + ": ");
    }

    return dadosOut;
  }

  public Vip leVIP() {
    String[] valores = new String[10];

    String[] nomeValores = { 
      "Codigo da Compra", 
      "Valor do Produto", 
      "Categoria do Produto", 
      "ID do Ingresso", 
      "Data do show", 
      "Genero Musical", 
      "Assento",
      "Tipo do Ingresso", 
      "Drink Especial" 
    };

    valores = leValor(nomeValores);

    Vip vipIngresso = new Vip(
      valores[0], 
      validaDouble(valores[1]),  
      valores[2], 
      valores[3], 
      valores[4], 
      valores[5], 
      valores[6],
      valores[7], 
      valores[8]
    );

    return vipIngresso;
  } 

  public VipPlus leVipPlus() {
    boolean acesso;
    String[] valores = new String[11];

    String[] nomeValores = { 
      "Codigo da Compra", 
      "Valor do Produto", 
      "Categoria do Produto", 
      "ID do Ingresso", 
      "Data do Show", 
      "Genero Musical", 
      "Assento",
      "Tipo", 
      "Drink Especial", 
      "Acesso ao Camarim" 
    };

    valores = leValor(nomeValores);

    int choice = JOptionPane.showConfirmDialog(
      null, 
      "Tem acesso ao camarim?", 
      "Responda:", 
      JOptionPane.YES_NO_OPTION
    );
    
    if (choice == 0) {
      acesso = true;
    } else {
      acesso = false;
    }

    VipPlus vipPlusIngresso = new VipPlus(
      valores[0], 
      validaDouble(valores[1]),  
      valores[2], 
      valores[3], 
      valores[4], 
      valores[5],
      valores[6], 
      valores[7], 
      valores[8], 
      acesso
    );

    return vipPlusIngresso;
  }

  public Camisetas leCamisetas() {
    String[] valores = new String[6];

    String[] nomeValores = { 
      "Codigo da Compra", 
      "Valor do Produto", 
      "Categoria do Produto", 
      "Cor da Camiseta", 
      "Nome do Produto", 
      "Tamanho da Camiseta" 
    };

    valores = leValor(nomeValores);

    Camisetas camiseta = new Camisetas(
      valores[0], 
      validaDouble(valores[1]),  
      valores[2], 
      valores[3], 
      valores[4], 
      valores[5]
    );

    return camiseta;
  }

  public Bone leBone() {
    String[] valores = new String[6];

    String[] nomeValores = { 
      "Codigo da Compra", 
      "Valor do Produto", 
      "Categoria do Produto", 
      "Cor do Bone", 
      "Nome do Produto", 
      "Tipo da Aba do Bone"
    };
    valores = leValor(nomeValores);

    Bone bone = new Bone(
      valores[0], 
      validaDouble(valores[1]), 
      valores[2], 
      valores[3], 
      valores[4], 
      valores[5]
    );

    return bone;
  }

  private double validaDouble(String s) {
    try {
      return Double.parseDouble(s);
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Informe um valor numérico", "ERRO!", JOptionPane.ERROR_MESSAGE);
      String entrada = JOptionPane.showInputDialog("Informe Valor do Produto: ");
      return Double.parseDouble(entrada);
    }
  }
}
