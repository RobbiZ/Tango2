package medion.tango;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ScheduleDetailActivity extends AppCompatActivity {

    TextView custname1;
    TextView plasmaname1;
    TextView address1;
    TextView city1;
    TextView phone1;
    TextView area1;
    TextView tanggal1;
    TextView populasi1;
    TextView jenis1;
    TextView umur1;
    TextView aplikasi1;
    TextView productname1;

    String cust;
    String plas;
    String addr;
    String cit;
    String pho;
    String are;
    String tan;
    String pop;
    String jen;
    String umu;
    String apl;
    String pro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_detail);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ScheduleDetailActivity.this, ScheduleRealisasiActivity.class);
                startActivity(intent);
            }
        });

        custname1 = findViewById(R.id.custname1);
        plasmaname1 = findViewById(R.id.plasmaname1);
        address1 = findViewById(R.id.address1);
        city1 = findViewById(R.id.city1);
        phone1 = findViewById(R.id.phone1);
        area1 = findViewById(R.id.area1);
        tanggal1 = findViewById(R.id.tanggal1);
        populasi1 = findViewById(R.id.populasi1);
        jenis1 = findViewById(R.id.jenis1);
        umur1 = findViewById(R.id.umur1);
        aplikasi1 = findViewById(R.id.aplikasi1);
        productname1 = findViewById(R.id.productname1);

        Intent intent = getIntent();
        cust = intent.getStringExtra(SharedKeys.KEY_CUSTNAME);
        plas = intent.getStringExtra(SharedKeys.KEY_PLASMANAME);
        addr = intent.getStringExtra(SharedKeys.KEY_ADDRESS);
        cit = intent.getStringExtra(SharedKeys.KEY_CITY);
        pho = intent.getStringExtra(SharedKeys.KEY_PHONE);
        are = intent.getStringExtra(SharedKeys.KEY_AREA);
        tan = intent.getStringExtra(SharedKeys.KEY_TANGGAL);
        pop = intent.getStringExtra(SharedKeys.KEY_POPULASI);
        jen = intent.getStringExtra(SharedKeys.KEY_JENIS);
        umu = intent.getStringExtra(SharedKeys.KEY_UMUR);
        apl = intent.getStringExtra(SharedKeys.KEY_APLIKASI);
        pro = intent.getStringExtra(SharedKeys.KEY_PRODUCTNAME);

        custname1.setText(cust);
        plasmaname1.setText("Nama :  " + plas);
        address1.setText("Alamat :  " + addr);
        city1.setText("Kota :  " + cit);
        phone1.setText("Telepon :  " + pho);
        area1.setText("Kategori Wilayah :  " + are);
        tanggal1.setText("Tanggal :  " + tan);
        populasi1.setText("Populasi :  " + pop);
        jenis1.setText("Jenis :  " + jen);
        umur1.setText("Umur :  " + umu);
        aplikasi1.setText("Aplikasi :  " + apl);
        productname1.setText("Produk :  " + pro);
    }
}
