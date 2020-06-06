package co.wl.Schotest.Dashboard.ui;

 import android.app.Fragment;
 import android.app.FragmentManager;
 import android.content.SharedPreferences;
 import android.content.res.ColorStateList;
 import android.os.Bundle;

 import com.bumptech.glide.Glide;
 import com.bumptech.glide.request.RequestOptions;
 import com.google.android.material.bottomnavigation.BottomNavigationView;
 import com.google.android.material.navigation.NavigationView;
 import com.google.gson.Gson;

 import androidx.annotation.NonNull;
 import androidx.appcompat.app.ActionBarDrawerToggle;
 import androidx.appcompat.app.AppCompatActivity;
 import androidx.appcompat.widget.Toolbar;
 import androidx.core.view.GravityCompat;
 import androidx.drawerlayout.widget.DrawerLayout;
 import androidx.fragment.app.FragmentTransaction;

 import android.text.Html;
 import android.view.MenuItem;
 import android.view.View;
 import android.widget.FrameLayout;
 import android.widget.ImageView;
 import android.widget.LinearLayout;
 import android.widget.RelativeLayout;
 import android.widget.TextView;
 import android.widget.Toast;

 import cn.pedant.SweetAlert.SweetAlertDialog;
 import co.wl.Schotest.R;
 import co.wl.Schotest.Utils.FragmentManagerHelper;
 import co.wl.Schotest.Utils.Loader;

public class DashboardMain extends AppCompatActivity  implements View.OnClickListener , NavigationView.OnNavigationItemSelectedListener{

     public static FragmentManager fm;
    public static FragmentManagerHelper fragmentManagerHelper;
     Loader loader;
    FrameLayout main_container;
     private static long  back_pressed;
     private static final int TIME_DELAY = 2000;

    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;
    DrawerLayout drawerLayout;
    LinearLayout cartcount;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        GetId();
        GEtDetailNavigation();

        changeFragment(new ServiceFragment());


    }

    private void GEtDetailNavigation() {

        navigationView = (NavigationView)findViewById(R.id.navigation_view);

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle(Html.fromHtml("<font color='#FFFFFF'></font>"));
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open, R.string.drawer_close);
        actionBarDrawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));

        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();




        navigationView.setNavigationItemSelectedListener(DashboardMain.this);

    }


    private void GetId() {

        cartcount=findViewById(R.id.cartcount);
        cartcount.setVisibility(View.VISIBLE);

        loader = new Loader(this,android.R.style.Theme_Translucent_NoTitleBar);
        main_container = (FrameLayout) findViewById(R.id.main_container);



    }

    @SuppressWarnings("StatementWithEmptyBody")

    @Override
    public void onBackPressed() {
      if (back_pressed + TIME_DELAY > System.currentTimeMillis()) {
            super.onBackPressed();
        } else {
            Toast.makeText(getBaseContext(), "Press once again to exit!",
                    Toast.LENGTH_SHORT).show();
        }
        back_pressed = System.currentTimeMillis();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    private void changeFragment(Fragment targetFragment){

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.main_container, targetFragment, "fragment")
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();


    }


    @Override
    public void onClick(View view) {


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        androidx.fragment.app.Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.home:

                changeFragment(new ServiceFragment());

                break;





            case R.id.logout:


                final SweetAlertDialog alertDialog = new SweetAlertDialog(this);
                alertDialog.setTitle("Alert!");
                alertDialog.setContentText("Do you want to logout?");
                alertDialog.setCancelButton("Cancel", new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        alertDialog.dismiss();
                    }
                });

                alertDialog.setConfirmButton("Yes", new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {

                       // UtilMethods.INSTANCE.logout(MainActivity.this);


                    }
                });

                alertDialog.show();

                break;


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;

    }

}
