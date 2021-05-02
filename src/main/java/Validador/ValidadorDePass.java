package Validador;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ValidadorDePass {

    //Path para el archivo ordenado
    private static String pathSinModificar = "src/main/java/Validador/10k-worst-passwords.txt";
    private static String pathModificado = "src/main/java/Validador/sorted-10k-worst-passwords.txt";
    //Declaro y defino las variables que uso en el array
    private static int LINES = 10000;
    public static String[] strArray = new String[LINES];

    //Funcion principal validadora de pass
    public Boolean validar(String pass) throws IOException {
        Boolean digito =false;
        Boolean letter=false;
        Boolean longitud = false;
        Boolean enLista = false;
        enLista = passEnLista(pass);
        longitud = validarLongitud(pass);
        digito = validarDigitos(pass);
        letter = validarLetras(pass);
        return digito && letter && longitud && !enLista;
    }


    //INICIO ORDENAR ARCHIVO DADO Y CREAR UN NUEVO ARCHIVO ORDENADO


    private static void fileToArray (String path) throws IOException {//Pasa el archivo a un array ordenado

        File archivo;
        archivo = new File (path);
        FileReader fr = null;
        BufferedReader br;
        fr = new FileReader (archivo);
        br = new BufferedReader(fr);
        int i = 0;

        // Lectura del fichero
        String linea;
        while((linea=br.readLine())!=null) {
           // if(linea.length()>=8)
            strArray[i] = linea; //voy cargando el array

            i++;
            //System.out.println(linea);
        }
        if( fr != null ){
            fr.close();
        }
    }

    private static void arrayToFile (String [] array) {  //Pasa array ordenado a archivo nuevo
        FileWriter fichero = null;
        PrintWriter pw;
        try
        {
            fichero = new FileWriter(pathModificado);
            pw = new PrintWriter(fichero);

            for (int i = 0; i < LINES; i++)
                pw.println(strArray[i]);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para
                // asegurarnos que se cierra el fichero.
                if (null != fichero)
                    fichero.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private static void sortArray (String [] array) { //Ordena el array
        strArray = Stream.of(strArray).sorted().toArray(String[]::new);
        // System.out.print("Strings in Sorted Order: " + Arrays.toString(strArray));
    }

    //FIN DE ORDENAR ARCHIVO DADO Y CREAR UN NUEVO ARCHIVO ORDENADO

    //VALIDAR SI LA PASS ESTA EN EL ARCHIVO ORDENADO
    public static Boolean passEnLista(String pass) throws IOException {

        File archivo;

        archivo = new File (pathModificado);
        if (!archivo.exists()) {
            fileToArray(pathSinModificar);
            sortArray(strArray);
            arrayToFile(strArray);
        }
        else
            fileToArray(pathModificado);


        if (Arrays.binarySearch(strArray, pass)>0)
            return true;
        else
            return false;
    }

    //VALIDAR QUE LA LONGITUD SEA > 8
    public Boolean validarLongitud(String pass){
        if (pass.length() <8)
            return false;
        else
            return true;
    }

    //VALIDAR QUE LA PASS TENGA DIGITOS
    public Boolean validarDigitos(String pass){
        for (Integer i=0;i<=pass.length()-1;i++){
            if(Character.isDigit(pass.charAt(i)))
                return true;
        }
        return false;
        }

    //VALIDAR QUE LA PASS TENGA LETRAS
    public Boolean validarLetras (String pass) {  //REPITO CODIGO, solo habria que cambiar el isDigit por el isLetter
        for (Integer i = 0; i <= pass.length()-1; i++) {
           if (Character.isLetter(pass.charAt(i)))
               return true;
        }
        return false;
        }
}