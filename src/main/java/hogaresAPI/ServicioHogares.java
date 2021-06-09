package hogaresAPI;

import hogaresAPI.entities.ListadoHogares;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class ServicioHogares {
    private static ServicioHogares instancia = null;
    //private static int maximaCantidadRegistrosDefault = 200;
    private static final String urlApi = "https://api.refugiosdds.com.ar/api/";
    private Retrofit retrofit;

    private ServicioHogares() { //Constructor
        this.retrofit = new Retrofit.Builder()
                .baseUrl(urlApi)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ServicioHogares instancia(){ //Patron Singleton
        if(instancia== null){
            instancia = new ServicioHogares();
        }
        return instancia;
    }

    public ListadoHogares listadoDeHogares(int offset) throws IOException {
        HogaresService hogaresService = this.retrofit.create(HogaresService.class);
        Call<ListadoHogares> requestHogares = hogaresService.hogares(offset, "Bearer 0BT1grFiCCTFgi3zw2KXokxSTg1WgGkkwaFUDgTUdANRdngCx9u7B6ggeKI8");
        Response<ListadoHogares> responseHogares = requestHogares.execute();//recien aca hace la request, con execute()
        return responseHogares.body();
    }

}