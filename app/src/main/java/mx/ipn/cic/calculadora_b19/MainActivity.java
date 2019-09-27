package mx.ipn.cic.calculadora_b19;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity implements BasicFunctions.SenderFragmentListener, ScientificFunctions.SenderFragmentListener  {


    private final String ESPACIO = " ";
    private final String VACIO = "";
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
    private String expPantalla;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expPantalla = VACIO;
        expInfija = VACIO;
    }

    @Override
    public void getBasicCalculatorInput(String entrada) {

        if (entrada.equals(IGUAL)) {
            try {
                String postfix = Calculator.Converter.infix2postfix(new StringTokenizer(expInfija));
                Toast toastPostfix = Toast.makeText(getApplicationContext(),
                        postfix, Toast.LENGTH_LONG);
                toastPostfix.show();
                Calculator.Evaluator eval = new Calculator.Evaluator(postfix, ESPACIO);
                double resultado = eval.Evaluate();
                sendToDisplay(Double.toString(resultado));
            } catch (Exception e) {
                Toast toastError = Toast.makeText(getApplicationContext(),
                                e.getMessage(), Toast.LENGTH_LONG);
                toastError.show();
            }

        } else {
            try {
                int num = new Integer(entrada);
                if((!expInfija.isEmpty() & lastIsNumber()) | expInfija.isEmpty()) {
                    expPantalla += entrada;
                    expInfija += entrada;
                } else {
                    expPantalla += entrada + ESPACIO;
                    expInfija += entrada + ESPACIO;
                }
            } catch (Exception e) {
                if (entrada.equals(PUNTO)) {
                    expPantalla += entrada;
                    expInfija += entrada;
                } else {
                    if (!expInfija.isEmpty() & lastIsNumber()) {
                        expPantalla += ESPACIO;
                        expInfija += ESPACIO;
                    }

                    if (entrada.equals(LIMPIAR)) {
                        expPantalla = VACIO;
                        expInfija = VACIO;
                    } else if (entrada.equals(SIGNO)) {
                        expPantalla += NEGATIVO;
                        expInfija += NEGATIVO;
                    } else {
                        expPantalla += entrada + ESPACIO;
                        expInfija += entrada + ESPACIO;
                    }
                }
            }
            sendToDisplay(expPantalla);
        }

    }

    @Override
    public void getScientificCalculatorInput(String texto) {

        if (!expInfija.isEmpty() & lastIsNumber()) {
            expPantalla += ESPACIO;
            expInfija += ESPACIO;
        }

        if (texto.equals(PAR_A) | texto.equals(PAR_C) | texto.equals(OP_POT)) {
            expPantalla += texto + ESPACIO;
            expInfija += texto + ESPACIO;
        } else if (texto.equals(CONST_E)) {
            expPantalla += texto + ESPACIO;
            String ec = Double.toString(Math.E);
            expInfija += ec + ESPACIO;
        } else if (texto.equals(CONST_PI)) {
            expPantalla += texto + ESPACIO;
            String pi = Double.toString(Math.PI);
            expInfija += pi + ESPACIO;
        } else if (texto.equals(OP_FAC)) {
            expPantalla += FUN_FAC + ESPACIO;
            expInfija += FUN_FAC + ESPACIO;
        } else {
            expPantalla += texto + ESPACIO + PAR_A + ESPACIO;
            expInfija += texto + ESPACIO + PAR_A + ESPACIO;
        }
        sendToDisplay(expPantalla);
    }

    private void sendToDisplay(String exp) {
        FragmentManager manager = getSupportFragmentManager();
        DisplayFragment mDisplayFragment = (DisplayFragment)manager.findFragmentById(R.id.fragment);
        mDisplayFragment.getExpression(exp);
    }

    private boolean lastIsNumber () {
        boolean isnumber = false;
        try {
            int num = new Integer(expInfija.charAt(expInfija.length()-1));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
