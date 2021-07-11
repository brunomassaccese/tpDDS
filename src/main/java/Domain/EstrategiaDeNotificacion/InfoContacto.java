package Domain.EstrategiaDeNotificacion;

public class InfoContacto{
        public String telefono;
        public String email;

        public InfoContacto(String telefono,String mail){
                this.email = mail;
                this.telefono = telefono;
        }

        public boolean verifica(String informacion){
                return (!informacion.equals(""));
        }

        public void mostrarInformacion(String informacion){
                if(this.verifica(informacion)){
                        System.out.println(informacion);
                }
        }

        public void mostrarInfo(){
                this.mostrarInformacion(email);
                this.mostrarInformacion(telefono);
        }

}
