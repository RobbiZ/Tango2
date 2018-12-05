package medion.tango;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Objects;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScheduleRealisasiActivity extends AppCompatActivity implements View.OnClickListener{

    EditText input_donumber;
    EditText input_batch;
    EditText input_kmstart;
    EditText input_kmfinish;
    EditText input_remark;
    Button button_save;
    ProgressDialog progressDialog;

//    Spinner spinner;
//    private static final String[] reschedule = {"RESCHEDULE ?", "Ayam dalam pengobatan", "Ayam terlalu kecil",
//            "Chick in mundur", "Jadwal padat", "Kurang vaksinator", "Mendahulukan kasus",
//            "Permintaan peternak", "Lain-lain"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_realisasi);

        input_donumber = findViewById(R.id.input_donumber);
        input_batch = findViewById(R.id.input_batch);
        input_kmstart = findViewById(R.id.input_kmstart);
        input_kmfinish = findViewById(R.id.input_kmfinish);
        input_remark = findViewById(R.id.input_remark);
        button_save = findViewById(R.id.button_save);
        button_save.setOnClickListener(this);

//        Spinner spinner = findViewById(R.id.spinner);
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(ScheduleRealisasiActivity.this,
//                android.R.layout.simple_spinner_item,reschedule);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);
//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Log.v("item", (String) parent.getItemAtPosition(position));
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//                //
//            }
//        });
    }

    public void saveAction() {
        final String donumber = input_donumber.getText().toString().trim();
        final String batch = input_batch.getText().toString().trim();
        final String kmstart = input_kmstart.getText().toString().trim();
        final String kmfinish = input_kmfinish.getText().toString().trim();
        final String remark = input_remark.getText().toString().trim();

        progressDialog = new ProgressDialog(ScheduleRealisasiActivity.this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        BaseApiService service = RetrofitClient.getAPIService();

        String vacid = ScheduleDetailActivity.vacid;

        Call<ResponseBody> call = service.saveRealisasi(vacid, donumber, batch, kmstart, kmfinish, remark);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                progressDialog.dismiss();
                try {
                    try {
                        JSONObject json = new JSONObject(Objects.requireNonNull(response.body()).string());
                        Boolean status = json.getBoolean("status");
                        if (status.equals(true)){
                            Toast.makeText(ScheduleRealisasiActivity.this, "Data Berhasil Disimpan " ,Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(ScheduleRealisasiActivity.this, MainActivity.class);
                            finish();
                            startActivity(intent);
                        } else if (status.equals(false)){
                            Toast.makeText(ScheduleRealisasiActivity.this, "Gagal Menyimpan Data" ,Toast.LENGTH_LONG).show();
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
                Toast.makeText(ScheduleRealisasiActivity.this, "Something went wrong... Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v == button_save){
            saveAction();
        }
    }
}
