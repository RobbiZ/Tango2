package medion.tango;

import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface BaseApiService {

    @FormUrlEncoded
    @POST("mobileLogin.php")
    Call<ResponseBody> loginRequest(@Field("username") String username,
                                    @Field("password") String password);

    @GET("readSchedule.php?")
    Call<List<ScheduleModel>> getSchedule(@Query("username") String username);

    @GET("readHistory.php?")
    Call<List<HistoryModel>> getHistory(@Query("username") String username);

    @FormUrlEncoded
    @POST("saveRealisasi.php")
    Call<ResponseBody> saveRealisasi(@Field("do_number") String username,
                                    @Field("batch_number") String password);
}