import Domain.entities.Validador.ValidadorDePass;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;


public class TestPass {

    ValidadorDePass validar = new ValidadorDePass();
    @Test
    public void contraseniaSoloLetra() {
    String soloLetra = "hola";
    Assert.assertEquals(false,validar.validarLongitud(soloLetra));
    Assert.assertEquals(true,validar.validarLetras(soloLetra));
    Assert.assertEquals(false,validar.validarDigitos(soloLetra));
    }
    @Test
    public void contraseniaSoloNumero(){
        String soloNumero = "123445678";
        Assert.assertEquals(true,validar.validarLongitud(soloNumero));
        Assert.assertEquals(false,validar.validarLetras(soloNumero));
        Assert.assertEquals(true,validar.validarDigitos(soloNumero));
    }
    @Test
    public void contraseniaBuena(){
        String passBuena = "abc123445678";
        Assert.assertEquals(true,validar.validarLongitud(passBuena));
        Assert.assertEquals(true,validar.validarLetras(passBuena));
        Assert.assertEquals(true,validar.validarDigitos(passBuena));
    }
    @Test
    public  void  contraseniaEnLista() throws IOException {
        String passDentroLista = "hola";
        Assert.assertEquals(true,validar.passEnLista(passDentroLista));
    }

    @Test
    public  void  contraseniaFueraLista() throws IOException {
        String passFueraLista = "hola123479";
        Assert.assertEquals(false,validar.passEnLista(passFueraLista));

    }

    @Test
    public  void  otraContraseniaEnLista() throws IOException {
        String passDentroLista = "dragon";
        Assert.assertEquals(true,validar.passEnLista(passDentroLista));

    }

    @Test
    public  void  otraContraseniaFueraLista() throws IOException {
        String passFueraLista = "SoY123456789";
        Assert.assertEquals(false,validar.passEnLista(passFueraLista));

    }

    @Test
    public  void  validarContraseniaFuerte() throws IOException {
        String passFueraLista = "hola";
        Assert.assertEquals(false,validar.validar(passFueraLista));

    }
    @Test
    public  void  validarContraseniaDebil() throws IOException {
        String passFueraLista = "SoY123456789";
        Assert.assertEquals(true,validar.validar(passFueraLista));

    }

}