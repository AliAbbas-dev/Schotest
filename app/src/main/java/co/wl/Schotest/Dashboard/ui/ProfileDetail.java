package co.wl.Schotest.Dashboard.ui;

import android.graphics.Color;
import android.os.Bundle;
  import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import co.wl.Schotest.R;
import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileDetail extends AppCompatActivity implements View.OnClickListener {

    TextView username,mobile,email ;
     CircleImageView userpic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_detail);

        GetId();
    }

    private void GetId() {

        username=findViewById(R.id.username);
        mobile=findViewById(R.id.mobile);
        email=findViewById(R.id.email);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setTitle("Profile");
        toolbar.setTitleTextColor(Color.WHITE);

        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        SharedPreferencesDeta();

    }

    private void SharedPreferencesDeta() {






    }

    @Override
    public void onClick(View view) {


    }
}
