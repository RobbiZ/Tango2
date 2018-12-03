package medion.tango;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.ProgressDialog;
import android.content.Intent;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Objects;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    EditText input_username;
    EditText input_password;
    Button button_login;
    ProgressDialog progressDialog;
    public static String shareuser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        input_username = findViewById(R.id.input_username);
        input_password = findViewById(R.id.input_password);
        button_login = findViewById(R.id.button_login);
        button_login.setOnClickListener(this);
    }

    public void loginAction() {
        final String username = input_username.getText().toString().trim();
        final String password = input_password.getText().toString().trim();
        final String token = SharedPrefManager.getInstance(this).getDeviceToken();

        progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        /*Create handle for the RetrofitInstance interface*/
        BaseApiService service = RetrofitClient.getAPIService();

        Call<ResponseBody> call = service.loginRequest(username, password, token);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                progressDialog.dismiss();
                try {
                    try {
                        JSONObject json = new JSONObject(Objects.requireNonNull(response.body()).string());
                        Boolean status = json.getBoolean("status");
                        if (status.equals(true)){
                            Toast.makeText(LoginActivity.this, "Berhasil Login" ,Toast.LENGTH_LONG).show();
                            shareuser = username;
                            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                            startActivity(intent);
                        } else if (status.equals(false)){
                            Toast.makeText(LoginActivity.this, "Gagal Login, Cek Username dan Password" ,Toast.LENGTH_LONG).show();
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
                progressDialog.dismiss();
                Toast.makeText(LoginActivity.this, "Something went wrong... Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v == button_login){
            loginAction();
        }
    }
}