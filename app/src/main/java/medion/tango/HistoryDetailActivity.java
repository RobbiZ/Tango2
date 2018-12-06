package medion.tango;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class HistoryDetailActivity extends AppCompatActivity {

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

    TextView donumber;
    TextView batch;
    TextView kmstart;
    TextView kmfinish;
    TextView remark;
    TextView reschedule;
    TextView newdate;
    TextView cancel;

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

    String don;
    String bat;
    String kms;
    String kmf;
    String rem;
    String res;
    String newd;
    String can;

    private static final String ZZZ = "zzz";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_detail);

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

        donumber = findViewById(R.id.donumber);
        batch = findViewById(R.id.batch);
        kmstart = findViewById(R.id.kmstart);
        kmfinish = findViewById(R.id.kmfinish);
        remark = findViewById(R.id.remark);
//        reschedule = findViewById(R.id.reschedule);
//        newdate = findViewById(R.id.newdate);
//        cancel = findViewById(R.id.cancel);

        Intent intent = getIntent();
        cust = intent.getStringExtra(SharedPrefManager.KEY_CUSTNAME);
        plas = intent.getStringExtra(SharedPrefManager.KEY_PLASMANAME);
        addr = intent.getStringExtra(SharedPrefManager.KEY_ADDRESS);
        cit = intent.getStringExtra(SharedPrefManager.KEY_CITY);
        pho = intent.getStringExtra(SharedPrefManager.KEY_PHONE);
        are = intent.getStringExtra(SharedPrefManager.KEY_AREA);
        tan = intent.getStringExtra(SharedPrefManager.KEY_TANGGAL);
        pop = intent.getStringExtra(SharedPrefManager.KEY_POPULASI);
        jen = intent.getStringExtra(SharedPrefManager.KEY_JENIS);
        umu = intent.getStringExtra(SharedPrefManager.KEY_UMUR);
        apl = intent.getStringExtra(SharedPrefManager.KEY_APLIKASI);
        pro = intent.getStringExtra(SharedPrefManager.KEY_PRODUCTNAME);

        don = intent.getStringExtra(SharedPrefManager.KEY_DONUMBER);
        bat = intent.getStringExtra(SharedPrefManager.KEY_BATCH);
        kms = intent.getStringExtra(SharedPrefManager.KEY_KMSTART);
        kmf = intent.getStringExtra(SharedPrefManager.KEY_KMFINISH);
        rem = intent.getStringExtra(SharedPrefManager.KEY_REMARK);
        res = intent.getStringExtra(SharedPrefManager.KEY_RESCHEDULE);
        newd = intent.getStringExtra(SharedPrefManager.KEY_NEWDATE);
        can = intent.getStringExtra(SharedPrefManager.KEY_CANCEL);

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


        Log.d(ZZZ, "NILAI VARIABEL res : " + res);

        if (don != null){
            donumber.setText("DO Number :  " + don);
        }
        if (bat != null){
            batch.setText("Batch Number :  " + bat);
        }
        if (kms != null){
            kmstart.setText("KM Start :  " + kms);
        }
        if (kmf != null){
            kmfinish.setText("KM Finish :  " + kmf);
        }
        if (rem != null && !rem.isEmpty()){
            remark.setText("Remark :  " + rem);
        }
//        if (res != null){
//            reschedule.setText("Reschedule :  " + res);
//        }
//        if (newd != null){
//            newdate.setText("Tanggal Reschedule :  " + newd);
//        }
//        if (can != null){
//            cancel.setText("Cancel :  " + can);
//        }
    }
}
