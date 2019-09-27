package mx.ipn.cic.calculadora_b19;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ScientificFunctions extends Fragment implements View.OnClickListener {

    Button buttonfuncSeno;
    Button buttonfuncCoseno;
    Button buttonfuncTangente;
    Button buttonfuncCosecante;
    Button buttonfuncSecante;
    Button buttonfuncCotangente;
    Button buttonfuncFactorial;
    Button buttonfuncRaiz;
    Button buttonfuncPotencia;
    Button buttonfuncLognat;
    Button buttonfuncLog10;
    Button buttonconstPI;
    Button buttonconstE;
    Button buttonParAbre;
    Button buttonParCierra;

    SenderFragmentListener mCommunication;

    public ScientificFunctions() {
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
        View v = inflater.inflate(R.layout.fragment_scientific_functions, container, false);

        buttonfuncSeno = (Button) v.findViewById(R.id.buttonOpSen);
        buttonfuncCoseno = (Button) v.findViewById(R.id.buttonOpCos);
        buttonfuncTangente = (Button) v.findViewById(R.id.buttonOpTan);
        buttonfuncCosecante = (Button) v.findViewById(R.id.buttonOpCsc);
        buttonfuncSecante = (Button) v.findViewById(R.id.buttonOpSec);
        buttonfuncCotangente = (Button) v.findViewById(R.id.buttonOpCtg);
        buttonfuncFactorial = (Button) v.findViewById(R.id.buttonOpFact);
        buttonfuncLog10 = (Button) v.findViewById(R.id.buttonFunLog10);
        buttonfuncLognat = (Button) v.findViewById(R.id.buttonOpLn);
        buttonfuncPotencia = (Button) v.findViewById(R.id.buttonOpPot);
        buttonfuncRaiz = (Button) v.findViewById(R.id.buttonOpRaiz);
        buttonconstPI = (Button) v.findViewById(R.id.buttonDigPi);
        buttonconstE = (Button) v.findViewById(R.id.buttonDigE);
        buttonParAbre = (Button) v.findViewById(R.id.buttonParA);
        buttonParCierra = (Button) v.findViewById(R.id.buttonParC);

        buttonfuncSeno.setOnClickListener(this);
        buttonfuncCoseno.setOnClickListener(this);
        buttonfuncTangente.setOnClickListener(this);
        buttonfuncCosecante.setOnClickListener(this);
        buttonfuncSecante.setOnClickListener(this);
        buttonfuncCotangente.setOnClickListener(this);
        buttonfuncFactorial.setOnClickListener(this);
        buttonfuncLog10.setOnClickListener(this);
        buttonfuncLognat.setOnClickListener(this);
        buttonfuncPotencia.setOnClickListener(this);
        buttonfuncRaiz.setOnClickListener(this);
        buttonconstPI.setOnClickListener(this);
        buttonconstE.setOnClickListener(this);
        buttonParAbre.setOnClickListener(this);
        buttonParCierra.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        Button buttonOP = (Button)v;
        mCommunication.getScientificCalculatorInput(buttonOP.getText().toString());
    }

    //Interface for communication
    public interface SenderFragmentListener {
        void getScientificCalculatorInput(String input);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCommunication = null;
    }
}
