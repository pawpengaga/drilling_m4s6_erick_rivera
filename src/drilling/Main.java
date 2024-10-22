package drilling;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Persona;

public class Main {

  static final String REGEX = "^(?=.*[A-Z].*[A-Z])(?=(.*[^a-zA-Z]){3,}).{11,}$";
  static final int LIST_MAX_SIZE = 10;
  static Scanner myscan = new Scanner(System.in);
  static boolean salir = false;

  public static Persona registrarUsuario(){
    
    System.out.println("REGISTRO DE USUSARIO:");

    System.out.println("Ingrese un nombre de usuario:");
    String usernameInput = myscan.nextLine();
    
    System.out.println("Ingrese una contrasenia:");
    String contraseniaInput = myscan.nextLine();

    while(!esValida(contraseniaInput)){
      System.out.println("La contrasenia que ha ingresado no es valida. Intente nuevamente.");
      System.out.println("Ingrese una contrasenia:");
      contraseniaInput = myscan.nextLine();
    }

    System.out.println("Ingrese el nombre completo del usuario:");
    String nombrecompletoInput = myscan.nextLine();

    System.out.println("Ingrese su fecha de nacimiento (DD-MM-AAAA):");
    String fechanacInput = myscan.nextLine();
    
    Persona persona = new Persona(usernameInput, contraseniaInput, nombrecompletoInput, fechanacInput);
    return persona;
  }

  public static boolean esValida(String pass_input){
    return pass_input.matches(REGEX);
  }

  public static void listarUsuarios(List<Persona> lista_usuarios){
    int cont = 1;
    System.out.println("Lista total de usuarios registrados: ");
    for (Persona persona : lista_usuarios) {
      System.out.println(cont + "- " + persona);
      cont++;
    }
  }

  public static void esMayorDeEdad(Persona persona){
    String approved = "Puede pasar a la zona para mayores de 18 años.";
    String rejected = "Lo sentimos. Posee acceso solo a una parte de la aplicación.";
    String message = (2024 - persona.getAnioNac()) >= 18 ? approved : rejected;
    System.out.println(message);
  }

  public static void main(String[] args) {
    
    // Aqui va el programa
    List<Persona> personas = new ArrayList<>();

    while (!salir) {
      
      Persona persona = registrarUsuario();
      System.out.println();
      personas.add(persona);
      System.out.println();
      System.out.println("Bienvenid@: " + persona.getNombreCompleto());
      esMayorDeEdad(persona);
      System.out.println();
      listarUsuarios(personas);
      System.out.println("--------------------------------\n");
      
      System.out.println();

      if(personas.size() >= LIST_MAX_SIZE){
        System.out.println("No puede seguir agregando mas personas pasado este punto.");
        salir = true;
      }
    }

    System.out.println("FIN DEL PROGRAMA.");
    myscan.close();
  }

}
