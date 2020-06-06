package co.wl.Schotest.Login.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import co.wl.Schotest.R;

public class ForgotActivity extends AppCompatActivity implements View.OnClickListener {
    Button bt_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);

        GetId();


    }

    private void GetId() {

        bt_submit=findViewById(R.id.bt_submit);
        bt_submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view==bt_submit){
            startActivity(new Intent(ForgotActivity.this,ForgotActivityReset.class));



        }

    }
}
