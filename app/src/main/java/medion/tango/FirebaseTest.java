package medion.tango;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FirebaseTest extends AppCompatActivity implements View.OnClickListener{

    //defining views
    private Button buttonDisplayToken;
    private TextView textViewToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_test);

        //getting views from xml
        textViewToken = findViewById(R.id.textViewToken);
        buttonDisplayToken = findViewById(R.id.buttonDisplayToken);

        //adding listener to view
        buttonDisplayToken.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == buttonDisplayToken) {
            //getting token from shared preferences
            String token = SharedPrefManager.getInstance(this).getDeviceToken();

            //if token is not null
            if (token != null) {
                //displaying the token
                textViewToken.setText(token);
            } else {
                //if token is null that means something wrong
                textViewToken.setText("Token not generated");
            }
        }
    }
}
