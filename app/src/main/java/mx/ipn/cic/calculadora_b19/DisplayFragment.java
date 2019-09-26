package mx.ipn.cic.calculadora_b19;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DisplayFragment extends Fragment {

    TextView pantalla;

    public DisplayFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_display, container, false);
        pantalla = (TextView) view.findViewById(R.id.textView_Display);
        return view;
    }

    public void getExpression(String exp) {
        pantalla.setText(exp);
    }

}
