package ProjetosJava. Ingressos;

public class Vip extends Ingresso {
  // Serial Version ID
  private static final long serialVersionUID = 1L;
  
  
  // Set de Atributos
  private String drinkEspecial;

  
  // Métodos Construtores
  public Vip(String codigoCompra, Double valor, String categoria, String idIngresso, String data, String genero, String assento,
      String tipo, String drinkEspecial) {
    super(codigoCompra, valor, categoria, idIngresso, data, genero, assento, tipo);
    this.drinkEspecial = drinkEspecial;
  }

  
  // Getter && Setter
  public String getDrinkEspecial() {
    return drinkEspecial;
  }

  public void setDrinkEspecial(String drinkEspecial) {
    this.drinkEspecial = drinkEspecial;
  }
  

  // toString()
  @Override
  public String toString() {
    return super.toString() + 
    "\n  -  Drink Especial: " + this.getDrinkEspecial() + "\n";
  }
}
