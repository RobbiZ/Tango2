package medion.tango;

import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Objects;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {

    private static final String TAG = "MyFirebaseIIDService";
    SharedPrefManager sharedPrefManager;

    @Override
    public void onTokenRefresh() {
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);
        storeToken(refreshedToken);

        //String username = LoginActivity.shareuser;
        String username = sharedPrefManager.getSPNama();
        BaseApiService service = RetrofitClient.getAPIService();
        Call<ResponseBody> call = service.tokenRefresh(username, refreshedToken);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                try {
                    try {
                        JSONObject json = new JSONObject(Objects.requireNonNull(response.body()).string());
                        Boolean status = json.getBoolean("status");
                        if (status.equals(true)){
                            Toast.makeText(MyFirebaseInstanceIDService.this, "Token Refreshed" ,Toast.LENGTH_LONG).show();
                        } else if (status.equals(false)){
                            Toast.makeText(MyFirebaseInstanceIDService.this, "Failed To Save Token to Server" ,Toast.LENGTH_LONG).show();
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } catch (IOException e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {
                Toast.makeText(MyFirebaseInstanceIDService.this, "Something went wrong... Failed To Save Token to Server", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void storeToken(String token) {
        //saving the token on shared preferences
        SharedPrefManager.getInstance(getApplicationContext()).saveDeviceToken(token);
    }
}
