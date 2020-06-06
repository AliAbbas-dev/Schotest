package co.wl.Schotest.Register.ui;

import android.content.Intent;
import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import co.wl.Schotest.R;
import co.wl.Schotest.Utils.Loader;
import co.wl.Schotest.Utils.UtilMethods;

public class RegisteredActivity extends AppCompatActivity implements View.OnClickListener {


    Loader loader;
    Button tv_createacc;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered);

        getID();
    }

    private void getID() {

        loader = new Loader(this,android.R.style.Theme_Translucent_NoTitleBar);

        tv_createacc=findViewById(R.id.tv_createacc);
        tv_createacc.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        if(view==tv_createacc){

startActivity(new Intent(RegisteredActivity.this,RegisteredSelectAccpunt.class));

        }


    }



}
