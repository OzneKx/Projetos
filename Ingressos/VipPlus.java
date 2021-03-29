package ProjetosJava. Ingressos;

public class VipPlus extends Vip {
  // Serial Version ID
  private static final long serialVersionUID = -7019574969323704787L;
  

  // Set de Atributos
  private boolean acessoCamarim;


  // Métodos Construtores
  public VipPlus(String codigoCompra, Double valor, String categoria, String idIngresso, String data, String genero,
    String assento, String tipo, String drinkEspecial, boolean acessoCamarim) {
    super(codigoCompra, valor, categoria, idIngresso, data, genero, assento, tipo, drinkEspecial);
    this.acessoCamarim = acessoCamarim;
  }


  // Getter && Setter
  public boolean isAcessoCamarim() {
    return acessoCamarim;
  }

  public void setAcessoCamarim(boolean acessoCamarim) {
    this.acessoCamarim = acessoCamarim;
  }

  
  // toString()
  @Override
  public String toString() {
    return super.toString() + 
    "\n  -  Acesso ao Camarim: " + this.isAcessoCamarim() + "\n";
  }
}
