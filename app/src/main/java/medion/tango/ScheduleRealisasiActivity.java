package medion.tango;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class ScheduleRealisasiActivity extends AppCompatActivity {

    Spinner spinner;
    private static final String[] reschedule = {"RESCHEDULE ?", "Ayam dalam pengobatan", "Ayam terlalu kecil",
            "Chick in mundur", "Jadwal padat", "Kurang vaksinator", "Mendahulukan kasus",
            "Permintaan peternak", "Lain-lain"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_realisasi);

        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(ScheduleRealisasiActivity.this,
                android.R.layout.simple_spinner_item,reschedule);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.v("item", (String) parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //
            }
        });
    }
}
