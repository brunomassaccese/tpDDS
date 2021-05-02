public class ValidadorDePass {

    public Boolean validar(String pass){
        Boolean digito =false;
        Boolean letter=false;
        Boolean longitud = false;
        longitud = validarLongitud(pass);
        digito = validarDigitos(pass);
        letter = validarLetras(pass);
        return digito && letter;
    }

    public Boolean validarLongitud(String pass){
        if (pass.length() <8)
            return false;
        else
            return true;
    }

    public Boolean validarDigitos(String pass){
        for (Integer i=0;i<=pass.length();i++){
            if(Character.isDigit(pass.charAt(i)))
                return true;
        }
        return false;
    }
    //REPITO CODIGO, solo habria que cambiar el isDigit por el isLetter
    public Boolean validarLetras (String pass) {
        for (Integer i = 0; i <= pass.length(); i++) {
            if (Character.isLetter(pass.charAt(i)))
                return true;
        }
        return false;
    }
}