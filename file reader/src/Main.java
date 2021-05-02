import java.io.*;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.Scanner;
import java.util.List;

class Main {

    private static String pathSinModificar = "C:\\Users\\Nicolas\\Desktop\\10k-worst-passwords.txt";
    private static String pathModificado = "C:\\Users\\Nicolas\\Desktop\\sorted-10k-worst-passwords.txt";

    //Declaro y defino las variables que uso en el array
    private static int LINES = 10000;
    public static String[] strArray = new String[LINES];

    private static void sortArray (String [] array) {
        strArray = Stream.of(strArray).sorted().toArray(String[]::new);
        // System.out.print("Strings in Sorted Order: " + Arrays.toString(strArray));
    }

    private static void fileToArray (String path) throws IOException {

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
            strArray[i] = linea; //voy cargando el array
            i++;
            //System.out.println(linea);
        }
        if( fr != null ){
            fr.close();
        }
    }

    private static void arrayToFile (String [] array) {

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



    public static void main(String [] arg) throws IOException {

        File archivo;

        archivo = new File (pathModificado);
        if (!archivo.exists()) {
            fileToArray(pathSinModificar);
            sortArray(strArray);
            arrayToFile(strArray);
        }
        else
            fileToArray(pathModificado);

        System.out.println ("Ingrese una clave: ");
        String entradaTeclado = "";
        Scanner entradaEscaner = new Scanner (System.in);
        entradaTeclado = entradaEscaner.nextLine ();

        if (Arrays.binarySearch(strArray, entradaTeclado)>0)
            System.out.println("La clave " + entradaTeclado + " está en el Array");
        else
            System.out.println("La clave " + entradaTeclado + " NO está en el Array");


        ValidadorDePass password = new ValidadorDePass();
        password.validar(entradaTeclado);
    }
}