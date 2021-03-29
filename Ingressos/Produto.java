package ProjetosJava. Ingressos;

import java.io.Serializable;

public abstract class Produto implements Serializable {
  // Serial Version ID
  private static final long serialVersionUID = -116400554494219654L;


  // Set de Atributos
  private String codigoCompra;
  private Double valor;
  private String categoria;

  
  // Métodos Construtores
  public Produto(String codigoCompra, Double valor, String categoria) {
    this.codigoCompra = codigoCompra;
    this.valor = valor;
    this.categoria = categoria;
  }

  
  // Getter && Setter
  public String getCodigoCompra() {
    return codigoCompra;
  }

  public void setCodigoCompra(String codigoCompra) {
    this.codigoCompra = codigoCompra;
  }

  public Double getValor() {
    return valor;
  }

  public void setValor(Double valor) {
    this.valor = valor;
  }

  public String getCategoria() {
    return categoria;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }

  
  // toString()
  @Override
  public String toString() {
    return "=-=-=-=-=-=-=-=-=-= " + this.getCategoria() + " =-=-=-=-=-=-=-=-=-=" +
    "\n\n  -  Código da Compra: " + this.getCodigoCompra() + 
    "\n  -  Valor: R$" + String.format("%.2f", this.getValor());
  }
}
