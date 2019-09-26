package mx.ipn.cic.calculadora_b19;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;

public class BasicFunctions extends Fragment implements View.OnClickListener {

    Button buttonDig0;
    Button buttonDig1;
    Button buttonDig2;
    Button buttonDig3;
    Button buttonDig4;
    Button buttonDig5;
    Button buttonDig6;
    Button buttonDig7;
    Button buttonDig8;
    Button buttonDig9;
    Button buttonOpIg;
    Button buttonOpSuma;
    Button buttonOpResta;
    Button buttonOpProducto;
    Button buttonOpDivision;
    Button buttonOpModulo;
    Button buttonOpPunto;
    Button buttonOpSigno;
    Button buttonOpLimpiar;
    SenderFragmentListener mCommunication;

    public BasicFunctions() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mCommunication = (SenderFragmentListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_basic_functions, container, false);

        buttonDig0 = (Button) v.findViewById(R.id.buttonDigCero);
        buttonDig1 = (Button) v.findViewById(R.id.buttonDigUno);
        buttonDig2 = (Button) v.findViewById(R.id.buttonDigDos);
        buttonDig3 = (Button) v.findViewById(R.id.buttonDigTres);
        buttonDig4 = (Button) v.findViewById(R.id.buttonDigCuatro);
        buttonDig5 = (Button) v.findViewById(R.id.buttonDigCinco);
        buttonDig6 = (Button) v.findViewById(R.id.buttonDigSeis);
        buttonDig7 = (Button) v.findViewById(R.id.buttonDigSiete);
        buttonDig8 = (Button) v.findViewById(R.id.buttonDigOcho);
        buttonDig9 = (Button) v.findViewById(R.id.buttonDigNueve);
        buttonOpIg = (Button) v.findViewById(R.id.buttonDigIgual);
        buttonOpSuma= (Button) v.findViewById(R.id.buttonDigMas);
        buttonOpResta = (Button) v.findViewById(R.id.buttonDigMenos);
        buttonOpProducto = (Button) v.findViewById(R.id.buttonDigMult);
        buttonOpDivision = (Button) v.findViewById(R.id.buttonDigDiv);
        buttonOpModulo = (Button) v.findViewById(R.id.buttonDigModulo);
        buttonOpSigno = (Button) v.findViewById(R.id.buttonDigDSign);
        buttonOpLimpiar = (Button) v.findViewById(R.id.buttonDigC);
        buttonOpPunto = (Button) v.findViewById(R.id.buttonDigPunto);

        buttonDig0.setOnClickListener(this);
        buttonDig1.setOnClickListener(this);
        buttonDig2.setOnClickListener(this);
        buttonDig3.setOnClickListener(this);
        buttonDig4.setOnClickListener(this);
        buttonDig5.setOnClickListener(this);
        buttonDig6.setOnClickListener(this);
        buttonDig7.setOnClickListener(this);
        buttonDig8.setOnClickListener(this);
        buttonDig9.setOnClickListener(this);
        buttonOpIg.setOnClickListener(this);
        buttonOpSuma.setOnClickListener(this);
        buttonOpResta.setOnClickListener(this);
        buttonOpProducto.setOnClickListener(this);
        buttonOpDivision.setOnClickListener(this);
        buttonOpModulo.setOnClickListener(this);
        buttonOpSigno.setOnClickListener(this);
        buttonOpLimpiar.setOnClickListener(this);
        buttonOpPunto.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        mCommunication.getBasicCalculatorInput(((Button)v).getText().toString());
    }

    //Interface for communication
    public interface SenderFragmentListener {
        void getBasicCalculatorInput(String msg);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCommunication = null;
    }
}

