package co.wl.Schotest.Splash.ui;

 import android.content.Intent;
 import android.content.SharedPreferences;
 import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
 import android.util.Log;
 import android.view.Window;

 import co.wl.Schotest.Dashboard.ui.DashboardMain;
 import co.wl.Schotest.Login.ui.LoginActivity;
 import co.wl.Schotest.R;
 import co.wl.Schotest.Utils.ApplicationConstant;


public class Splash extends AppCompatActivity {

    String Email="";

    @Override
    protected void onPause() {
         super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.splash_screen);

        Selectpagr();

    }

    private void Selectpagr() {

      //

        SharedPreferences myPreferences =  getSharedPreferences(ApplicationConstant.INSTANCE.prefNamePref, MODE_PRIVATE);
        String balanceResponse = myPreferences.getString(ApplicationConstant.INSTANCE.one, null);
        Email = ""+balanceResponse;

        Log.e("Email","  Email"+   Email +"    "+  Email.length() );

        if ( Email.equalsIgnoreCase("1")){

            DashboardLogin();


        }else{

            loginpage();

        }


    }

    public void loginpage() {

        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(2000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{

                    startLogin();
                }
            }
        };
        timerThread.start();
    }

    public void DashboardLogin() {
        Intent intent = new Intent(Splash.this, DashboardMain.class);
        startActivity(intent);
        finish();
    }

    public void startLogin() {
       // Intent intent = new Intent(Splash.this, LoginActivity.class);
        Intent intent = new Intent(Splash.this, SplashSecand.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.anim_nothing);
        finish();

    }


}
