package mx.ipn.cic.calculadora_b19;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements BasicFunctions.SenderFragmentListener  {


    private final String ESPACIO = " ";
    private final String VACIO = "";
    private final String RESET = "0.0";
    private final String LIMPIAR = "C";
    private final String IGUAL = "=";
    private final String SIGNO = "+/-";
    private final String NEGATIVO = "-";
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
        } else {
            expInfija += entrada + ESPACIO;
            sendToDisplay(expInfija);
        }
    }

    private void sendToDisplay(String exp) {
        FragmentManager manager = getSupportFragmentManager();
        DisplayFragment mDisplayFragment = (DisplayFragment)manager.findFragmentById(R.id.fragment);
        mDisplayFragment.getExpression(exp);
    }

}
