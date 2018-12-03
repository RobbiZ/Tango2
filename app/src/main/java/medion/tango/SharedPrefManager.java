package medion.tango;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {

    public static final String KEY_VACID = "keyVacId";
    public static final String KEY_CUSTNAME = "keyCustName";
    public static final String KEY_PLASMANAME = "keyPlasmaName";
    public static final String KEY_ADDRESS = "keyAddress";
    public static final String KEY_CITY = "keyCity";
    public static final String KEY_PHONE = "keyPhone";
    public static final String KEY_AREA = "keyArea";
    public static final String KEY_TANGGAL = "keyTanggal";
    public static final String KEY_POPULASI = "keyPopulasi";
    public static final String KEY_JENIS = "keyJenis";
    public static final String KEY_UMUR = "keyUmur";
    public static final String KEY_APLIKASI = "keyAplikasi";
    public static final String KEY_PRODUCTNAME = "keyProductName";

    public static final String KEY_DONUMBER = "doNumber";
    public static final String KEY_BATCH = "batch";
    public static final String KEY_KMSTART = "kmStart";
    public static final String KEY_KMFINISH = "kmFinish";
    public static final String KEY_REMARK = "remark";
    public static final String KEY_RESCHEDULE = "reSchedule";
    public static final String KEY_NEWDATE = "newDate";
    public static final String KEY_CANCEL = "cancel";

    private static final String SHARED_PREF_NAME = "FCMSharedPref";
    private static final String TAG_TOKEN = "tagtoken";

    private static SharedPrefManager mInstance;
    private static Context mCtx;

    private SharedPrefManager(Context context) {
        mCtx = context;
    }

    public static synchronized SharedPrefManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }

    //this method will save the device token to shared preferences
    public boolean saveDeviceToken(String token){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(TAG_TOKEN, token);
        editor.apply();
        return true;
    }

    //this method will fetch the device token from shared preferences
    public String getDeviceToken(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return  sharedPreferences.getString(TAG_TOKEN, null);
    }
}
