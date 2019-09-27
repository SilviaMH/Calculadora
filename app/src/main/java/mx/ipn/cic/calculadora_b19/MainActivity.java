package mx.ipn.cic.calculadora_b19;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements BasicFunctions.SenderFragmentListener, ScientificFunctions.SenderFragmentListener  {


    private final String ESPACIO = " ";
    private final String VACIO = "";
    private final String RESET = "0.0";
    private final String LIMPIAR = "C";
    private final String IGUAL = "=";
    private final String SIGNO = "+/-";
    private final String NEGATIVO = "-";
    private final String PAR_A = "(";
    private final String PAR_C = ")";
    private final String CONST_PI = "π";
    private final String CONST_E = "e";
    private final String OP_FAC = "x!";
    private final String FUN_FAC = "fact (";
    private final String OP_POT = "^";
    private final String PUNTO = ".";
    private String expInfija;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expInfija = VACIO;
    }

    @Override
    public void getBasicCalculatorInput(String entrada) {

        if (entrada.equals(IGUAL)) {
            //codigo para convertir a postfija
            //evaluar expresion
            //sendToDisplay("0.0");   enviar resultado a pantalla

        } else if (entrada.equals(LIMPIAR)) {
            expInfija = VACIO;
            sendToDisplay(RESET);
        } else if (entrada.equals(SIGNO)) {
            expInfija += NEGATIVO;
            sendToDisplay(expInfija);
        } else if (entrada.equals(PUNTO)) {
            expInfija += entrada;
            sendToDisplay(expInfija);
        } else {
            expInfija += entrada + ESPACIO;
            sendToDisplay(expInfija);
        }
    }

    @Override
    public void getScientificCalculatorInput(String entrada) {
        if (entrada.equals(PAR_A) | entrada.equals(PAR_C) | entrada.equals(OP_POT)) {
            expInfija += entrada + ESPACIO;
            sendToDisplay(expInfija);
        } else if (entrada.equals(CONST_E)) {
            expInfija += Math.E + ESPACIO ;
            sendToDisplay(expInfija);
        } else if (entrada.equals(CONST_PI)) {
            expInfija += Math.PI + ESPACIO ;
            sendToDisplay(expInfija);
        } else if (entrada.equals(OP_FAC)) {
            expInfija += FUN_FAC + ESPACIO ;
            sendToDisplay(expInfija);
        } else {
            expInfija += entrada + ESPACIO + PAR_A + ESPACIO ;
            sendToDisplay(expInfija);
        }
    }

    private void sendToDisplay(String exp) {
        FragmentManager manager = getSupportFragmentManager();
        DisplayFragment mDisplayFragment = (DisplayFragment)manager.findFragmentById(R.id.fragment);
        mDisplayFragment.getExpression(exp);
    }

}
