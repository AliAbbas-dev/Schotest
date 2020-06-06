package co.wl.Schotest.Dashboard.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
  import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import co.wl.Schotest.R;


public class SupportActivity extends AppCompatActivity implements View.OnClickListener {

    TextView link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);

        getid();

    }

    private void getid() {


        link=findViewById(R.id.link);
        link.setOnClickListener(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setTitle("Support");
        toolbar.setTitleTextColor(Color.WHITE);

        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onBackPressed();

            }
        });

    }

    @Override
    public void onClick(View view) {

        if(view==link){

            Intent i=new Intent(this,WebViewActivity.class);
            i.putExtra("name","Website");
            i.putExtra("url","http://rms.com/");
            startActivity(i);


        }

    }
}
