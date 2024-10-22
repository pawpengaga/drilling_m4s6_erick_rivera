package model;

public class Persona {
  
  private String userName;
  private String contrasenia;
  private String nombreCompleto;
  private String fechaNac;

  public Persona(){

  }

  public Persona(String userName, String contrasenia, String nombreCompleto, String fechaNac) {
    super();
    this.userName = userName;
    this.contrasenia = contrasenia;
    this.nombreCompleto = nombreCompleto;
    this.fechaNac = fechaNac;
  }


  public String getUserName() {
    return userName;
  }


  public String getContrasenia() {
    return contrasenia;
  }


  public String getNombreCompleto() {
    return nombreCompleto;
  }

  public String getFechaNac() {
    return fechaNac;
  }

  public int getAnioNac(){
    String[] dateData = this.fechaNac.split("-");
    return Integer.valueOf(dateData[2]);
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public void setContrasenia(String contrasenia) {
    this.contrasenia = contrasenia;
  }

  public void setNombreCompleto(String nombreCompleto) {
    this.nombreCompleto = nombreCompleto;
  }


  public void setFechaNac(String fechaNac) {
    this.fechaNac = fechaNac;
  }


  @Override
  public String toString() {
    return this.getNombreCompleto();
  }

}
