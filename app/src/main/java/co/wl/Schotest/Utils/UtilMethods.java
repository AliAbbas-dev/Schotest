package co.wl.Schotest.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.content.res.AppCompatResources;

import cn.pedant.SweetAlert.SweetAlertDialog;
import co.wl.Schotest.R;
import co.wl.Schotest.Splash.ui.Splash;

import static android.content.Context.MODE_PRIVATE;

public enum UtilMethods {

    INSTANCE;

    public String getRecentLogin(Context context) {
        SharedPreferences myPrefs = context.getSharedPreferences(ApplicationConstant.INSTANCE.prefNamePref, MODE_PRIVATE);
        String key = myPrefs.getString(ApplicationConstant.INSTANCE.regRecentLoginPref, null);
        return key;
    }

    public void setRecentLogin(Context context, String key) {
        SharedPreferences prefs = context.getSharedPreferences(ApplicationConstant.INSTANCE.prefNamePref, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(ApplicationConstant.INSTANCE.regRecentLoginPref,key);
        editor.commit();
    }

    public void Failed(final Context context,final String message) {
        new SweetAlertDialog(context, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                .setTitleText(context.getResources().getString(R.string.attention_error_title))
                .setContentText(message)
                .setCustomImage(AppCompatResources.getDrawable(context,R.drawable.ic_cancel_black_24dp))
                .show();
    }

    public void Successful(final Context context, final String message, final int i, final Activity activity) {

        SweetAlertDialog pDialog = new SweetAlertDialog(context, SweetAlertDialog.CUSTOM_IMAGE_TYPE);
        pDialog.setTitleText(context.getResources().getString(R.string.successful_title));
        pDialog.setContentText(message);
        pDialog.setCustomImage(AppCompatResources.getDrawable(context,R.drawable.ic_check_circle_black_24dp));
        pDialog.setCancelable(false);
        pDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sweetAlertDialog) {

                 if(i==1){

                    activity.finish();
                    sweetAlertDialog.dismiss();
                }else if(i==2){

                    activity.finish();
                    sweetAlertDialog.dismiss();
                } else if(i==3){

                     activity.finish();
                     sweetAlertDialog.dismiss();

                } else {
                    sweetAlertDialog.dismiss();
                }
            }
        });
        pDialog.show();
    }



    public void Error(final Context context,final String message, final  int i) {

        SweetAlertDialog pDialog = new SweetAlertDialog(context, SweetAlertDialog.CUSTOM_IMAGE_TYPE);
        pDialog.setTitleText(context.getResources().getString(R.string.attention_error_title));
        pDialog.setContentText(message);
        pDialog.setCustomImage(AppCompatResources.getDrawable(context,R.drawable.ic_error_red_24dp) );
        pDialog.setCancelable(false);
        pDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sweetAlertDialog) {
                if (i==1){

                    sweetAlertDialog.dismiss();
                }if(i==2){
//                            UtilMethods.INSTANCE.logout(context);
                    sweetAlertDialog.dismiss();
                }else {
                    sweetAlertDialog.dismiss();
                }
            }});
        pDialog.show();

    }

    public void NetworkError(final Context context, String title, final String message) {
        new SweetAlertDialog(context, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                .setTitleText(title)
                .setContentText(message)
                .setCustomImage(AppCompatResources.getDrawable(context,R.drawable.ic_error_red_24dp))
                .show();
    }


    public boolean isNetworkAvialable(Context context) {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }



    public void dialogOknew(final Context context, String title, final String message, final int flag) {
        new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // "OK" button was clicked
                        if (flag == 1) {


                         }  else if (flag == 6) {


                        }
                    }
                })
                .show();
    }






    private void setProductInfo(Context context, String Productinfo) {

        SharedPreferences prefs = context.getSharedPreferences(ApplicationConstant.INSTANCE.prefNamePref, context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(ApplicationConstant.INSTANCE.Productinfo, Productinfo);
        editor.commit();


    }


    public void setLoginrespose(Context context, String Loginrespose ,String one ) {

        SharedPreferences prefs = context.getSharedPreferences(ApplicationConstant.INSTANCE.prefNamePref, context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(ApplicationConstant.INSTANCE.Loginrespose, Loginrespose);
        editor.putString(ApplicationConstant.INSTANCE.one, one);
         editor.commit();

    }

    public void setUserDetail(Context context, String getUser,String userid  ) {

        SharedPreferences prefs = context.getSharedPreferences(ApplicationConstant.INSTANCE.prefNamePref, context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(ApplicationConstant.INSTANCE.getUser, getUser);
        editor.putString(ApplicationConstant.INSTANCE.userid, userid);
         editor.commit();

    }

    public void logout(final Context context) {

        UtilMethods.INSTANCE.setLoginrespose(context, "","");

        Intent startIntent = new Intent(context, Splash.class);
        startIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(startIntent);

    }


}