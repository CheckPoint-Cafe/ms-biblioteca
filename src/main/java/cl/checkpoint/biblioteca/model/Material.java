package cl.checkpoint.biblioteca.model;

import jakarta.persistence.*;

@Entity
public class Material {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String titulo;
  private String tipo;
  private Boolean disponible;

  public Long getId() {
    return id;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String value) {
    this.titulo = value;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String value) {
    this.tipo = value;
  }

  public Boolean getDisponible() {
    return disponible;
  }

  public void setDisponible(Boolean value) {
    this.disponible = value;
  }
}
