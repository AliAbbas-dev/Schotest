package co.wl.Schotest.Login.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import com.google.android.material.textfield.TextInputLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import co.wl.Schotest.Dashboard.ui.DashboardMain;
import co.wl.Schotest.R;
import co.wl.Schotest.Register.ui.RegisteredActivity;
import co.wl.Schotest.Utils.Loader;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    public Button btLogin;
      public Button rl_sign_up;
    Loader loader;
    public EditText edMobile;
    public EditText edPass;
     public TextView tv_skip,loginfrom;
     TextView Other,student,school,devolopment;
     LinearLayout li_forgot;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_login);

        getId();


    }

    public void getId() {

        loader = new Loader(this,android.R.style.Theme_Translucent_NoTitleBar);
        tv_skip=findViewById(R.id.tv_skip);
        loginfrom=findViewById(R.id.loginfrom);
        btLogin=(Button)findViewById(R.id.bt_login);
        rl_sign_up=findViewById(R.id.tv_signup);
         edMobile=(EditText)findViewById(R.id.mobilenumber);
        edPass=(EditText)findViewById(R.id.password);
        li_forgot=findViewById(R.id.li_forgot);




        setListners();



    }



    public void setListners() {

        btLogin.setOnClickListener(this);
         rl_sign_up.setOnClickListener(this);

        tv_skip.setOnClickListener(this);
        loginfrom.setOnClickListener(this);
        li_forgot.setOnClickListener(this);


    }




    @Override
    public void onClick(View v) {

        if(v==tv_skip){

            startActivity(new Intent(this, DashboardMain.class));
            overridePendingTransition(R.anim.slide_in_right, R.anim.anim_nothing);
            finish();

        }

      if(v==li_forgot){

            startActivity(new Intent(this, ForgotActivity.class));
            overridePendingTransition(R.anim.slide_in_right, R.anim.anim_nothing);
            finish();

        }


        if(v==loginfrom){

            OpenDialogloginfrom();


        }

        if(v==btLogin) {


            startActivity(new Intent(this, DashboardMain.class));


        }



        if(v==rl_sign_up)
        {
            startActivity(new Intent(this, RegisteredActivity.class));

            finish();
        }

    }



    public void OpenDialogloginfrom() {

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.loginfrom, null);



        Other =  view.findViewById(R.id.other);
        student =  view.findViewById(R.id.student);
        school =  view.findViewById(R.id.school);
        devolopment =  view.findViewById(R.id.devolopment);


        final Dialog dialog = new Dialog(this);

        dialog.setCancelable(false);
        dialog.setContentView(view);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


        Other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loginfrom.setText("Other");

                loginfrom.setTextColor(LoginActivity.this.getResources().getColor(R.color.colorPrimary));
                dialog.dismiss();

            }
        });

        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loginfrom.setText("Student");
                loginfrom.setTextColor(LoginActivity.this.getResources().getColor(R.color.colorPrimary));

                dialog.dismiss();

            }
        });

        school.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loginfrom.setText("School");
                loginfrom.setTextColor(LoginActivity.this.getResources().getColor(R.color.colorPrimary));


                dialog.dismiss();
            }
        });

        devolopment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loginfrom.setText("Bysubess Devekionebt Execytuve");
                loginfrom.setTextColor(LoginActivity.this.getResources().getColor(R.color.colorPrimary));


                dialog.dismiss();
            }
        });



        dialog.show();
    }

 }