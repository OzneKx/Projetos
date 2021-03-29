package ProjetosJava. Ingressos;

public class Camisetas extends Acessorio {
  // Serial Version ID
  private static final long serialVersionUID = -5836922830363868644L;


  // Set de Atributos
  private String tamanho;

  
  // Métodos Construtores
  public Camisetas(String codigoCompra, Double valor, String categoria, String cor, String nome, String tamanho) {
    super(codigoCompra, valor, categoria, cor, nome);
    this.tamanho = tamanho;
  }

  
  // Getter && Setter
  public String getTamanho() {
    return tamanho;
  }

  public void setTamanho(String tamanho) {
    this.tamanho = tamanho;
  }
    
  
  // toString()
  @Override
  public String toString() {
    return super.toString() + 
    "\n  -  Tamanho: " + this.getTamanho() + "\n";
  }
}
