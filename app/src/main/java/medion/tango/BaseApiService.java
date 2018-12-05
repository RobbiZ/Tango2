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
                                    @Field("password") String password,
                                    @Field("token") String token);

    @FormUrlEncoded
    @POST("tokenRefresh.php")
    Call<ResponseBody> tokenRefresh(@Field("username") String username,
                                    @Field("token") String token);

    @FormUrlEncoded
    @POST("saveRealisasi.php")
    Call<ResponseBody> saveRealisasi(@Field("vacid") String vacid,
                                     @Field("donumber") String donumber,
                                     @Field("batch") String batch,
                                     @Field("kmstart") String kmstart,
                                     @Field("kmfinish") String kmfinish,
                                     @Field("remark") String remark);


    @GET("readSchedule.php?")
    Call<List<ScheduleModel>> getSchedule(@Query("username") String username);

    @GET("readHistory.php?")
    Call<List<HistoryModel>> getHistory(@Query("username") String username);
}
