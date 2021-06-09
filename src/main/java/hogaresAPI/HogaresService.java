package hogaresAPI;

import hogaresAPI.entities.ListadoHogares;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface HogaresService {

    @GET("hogares")
    Call<ListadoHogares> hogares(@Query("offset") int offset, @Header("Authorization") String autheader);

}
