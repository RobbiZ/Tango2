package medion.tango;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit;
    private static final String BASE_URL = "http://192.168.43.195/jadwal-vaksinasi/_mobile/";

    public static Retrofit getClient(String baseUrl) {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static BaseApiService getAPIService(){
        return RetrofitClient.getClient(BASE_URL).create(BaseApiService.class);
    }
}
