package ProjetosJava. Ingressos;

public abstract class Acessorio extends Produto {
  // Serial Version ID
  private static final long serialVersionUID = 1L;


  // Set de Atributos
  private String cor;
  private String nome;

  
  // Métodos Construtores
  public Acessorio(String codigoCompra, Double valor, String categoria, String cor, String nome) {
    super(codigoCompra, valor, categoria);
    this.cor = cor;
    this.nome = nome;
  }


  // Getter && Setter
  public String getCor() {
    return cor;
  }

  public void setCor(String cor) {
    this.cor = cor;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
  
  
  // toString()
  @Override
  public String toString() {
    return super.toString() + 
    "\n  -  Cor: " + this.getCor() + 
    "\n  -  Nome: " + this.getNome();
  }
}
