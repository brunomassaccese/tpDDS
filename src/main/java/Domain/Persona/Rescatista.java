package Domain.Persona;

import Domain.Mascota.Mascota;
import java.util.Scanner;

public class Rescatista extends Persona{

    public Rescatista(String nombre,String apellido,String direccion,Contacto contacto){
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.agregarContacto(contacto);
    }

    public Rescatista registrarRescatista(){
        System.out.println("Ingrese un mail");
        Scanner mail = new Scanner(System.in);
        System.out.println("Ingrese un telefono");
        Scanner telefono = new Scanner(System.in);
        Contacto contacto = new Contacto(telefono.nextLine(),mail.nextLine());
        System.out.println("Ingrese un nombre");
        Scanner nombre = new Scanner(System.in);
        System.out.println("Ingrese un apellido");
        Scanner apellido = new Scanner(System.in);
        System.out.println("Ingrese una direccion para ubicarlo");
        Scanner direccion = new Scanner(System.in);
        return new Rescatista(nombre.nextLine(),apellido.nextLine(),direccion.nextLine(),contacto);
    }
    // VER SI ESTO FUNCIONA
    public void notificarMascotaEncontrada(Mascota mascota){
        Rescatista rescatista = this.registrarRescatista();
        mascota.registrar();
        mascota.notificar(rescatista);
    }
}
