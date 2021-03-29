package ProjetosJava. Ingressos;

public class Bone extends Acessorio {
  // Serial Version ID
  private static final long serialVersionUID = 3865861614863277722L;


  // Set de Atributos
  private String tipoDeAba;

  
  // Métodos Construtores
  public Bone(String codigoCompra, Double valor, String categoria, String cor, String nome, String tipoDeAba) {
    super(codigoCompra, valor, categoria, cor, nome);
    this.tipoDeAba = tipoDeAba;
  }

  
  // Getter && Setter
  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  public String getTipoDeAba() {
    return tipoDeAba;
  }

  public void setTipoDeAba(String tipoDeAba) {
    this.tipoDeAba = tipoDeAba;
  }
  

  // toString()
  @Override
  public String toString() {
    return super.toString() + 
    "\n  -  Tipo de Aba: " + this.getTipoDeAba() + "\n";
  }
}
