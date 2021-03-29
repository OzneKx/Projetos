package ProjetosJava. Ingressos;

public class Ingresso extends Produto {
  // Serial Version ID
  private static final long serialVersionUID = -6510040591708645425L;
  
  
  // Set de Atributos
  private String idIngresso;
  private String data;
  private String genero;
  private String assento;
  private String tipo;

  
  // Métodos Construtores
  public Ingresso(String codigoCompra, Double valor, String categoria, String idIngresso, String data, String genero,
    String assento, String tipo) {
    super(codigoCompra, valor, categoria);
    this.idIngresso = idIngresso;
    this.data = data;
    this.genero = genero;
    this.assento = assento;
    this.tipo = tipo;
  }


  // Getter && Setter
  public String getIdIngresso() {
    return idIngresso;
  }

  public void setIdIngresso(String idIngresso) {
    this.idIngresso = idIngresso;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public String getGenero() {
    return genero;
  }

  public void setGenero(String genero) {
    this.genero = genero;
  }

  public String getAssento() {
    return assento;
  }

  public void setAssento(String assento) {
    this.assento = assento;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  
  // toString()
  @Override
  public String toString() {
    return super.toString() + 
    "\n  -  Assento: " + this.getAssento()  + 
    "\n  -  Data: " + this.getData()  + 
    "\n  -  Gênero: " + this.getGenero()  + 
    "\n  -  ID Ingresso: " + this.getIdIngresso () + 
    "\n  -  Tipo: " + this.getTipo();
  }
}
