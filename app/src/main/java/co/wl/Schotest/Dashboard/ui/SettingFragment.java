package co.wl.Schotest.Dashboard.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import co.wl.Schotest.R;
import co.wl.Schotest.Utils.Loader;

public class SettingFragment extends Fragment implements View.OnClickListener {




     Loader loader;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v= inflater.inflate(R.layout.setting_home, container, false);

        getid(v);


        return v;

    }

    private void getid(View v) {


        loader = new Loader(getActivity(),android.R.style.Theme_Translucent_NoTitleBar);





     }



    @Override
    public void onClick(View view) {

    }
}