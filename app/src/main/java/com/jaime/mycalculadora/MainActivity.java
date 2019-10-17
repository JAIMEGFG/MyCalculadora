package com.jaime.mycalculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Enumeration;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
     Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnSum,btnRes,btnIgual,btnDiv,btnMult,btnDel;
    TextView etiqueta,operador1;
    int op1,op2;
    boolean operando=false;
    String simbolo=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
        etiqueta.setText("");
    }

    private void acciones(){
        ArrayList<View> botones = findViewById(R.id.layPadre).getTouchables();
        for (View item: botones
             ) {
            ((Button) item).setOnClickListener(this);
        }
        /*btnInicial.setOnClickListener(this);
        btnInicialDos.setOnClickListener(this);
         */

    }

    private void instancias(){
        btn1=this.findViewById(R.id.btnUno);
        btn2=this.findViewById(R.id.btnDos);
        btn3=this.findViewById(R.id.btnTres);
        btn4=this.findViewById(R.id.btnCuatro);
        btn5=this.findViewById(R.id.btnCinco);
        btn6=this.findViewById(R.id.btnSeis);
        btn7=this.findViewById(R.id.btnSiete);
        btn8=this.findViewById(R.id.btnOcho);
        btn9=this.findViewById(R.id.btnNueve);
        btnSum=this.findViewById(R.id.btnSum);
        btnRes=this.findViewById(R.id.btnRest);
        btnDiv=this.findViewById(R.id.btnDiv);
        btnMult=this.findViewById(R.id.btnMult);
        btnDel=this.findViewById(R.id.btnBorrar);
        btnIgual=this.findViewById(R.id.btnIgual);
       etiqueta=this.findViewById(R.id.etiqueta);
       /*
        operador1=this.findViewById(R.id.operador1);
        ArrayList<View> botones = findViewById(R.id.buttonPanel).getTouchables();
        for (View item: botones) {
            ((Button)item).setOnClickListener(this);
        }*/
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnUno: {
                etiqueta.setText(etiqueta.getText() + "1");
                break;
            }
            case R.id.btnDos:{
                etiqueta.setText(etiqueta.getText()+"2");
                break;
            }
            case R.id.btnTres:{
                etiqueta.setText(etiqueta.getText()+"3");
                break;
            }
            case R.id.btnCuatro:{
                etiqueta.setText(etiqueta.getText()+"4");
                break;
            }
            case R.id.btnCinco:{
                etiqueta.setText(etiqueta.getText()+"5");
                break;
            }
            case R.id.btnSeis:{
                etiqueta.setText(etiqueta.getText()+"6");
                break;
            }
            case R.id.btnSiete: {
                //  Toast.makeText(getApplicationContext(), "boton 7", Toast.LENGTH_SHORT).show();
                etiqueta.setText(etiqueta.getText()+"7");
                break;
            }
            case R.id.btnOcho:{
                etiqueta.setText(etiqueta.getText()+"8");
                break;
            }
            case R.id.btnNueve:{
                etiqueta.setText(etiqueta.getText()+"9");
                break;
            }
            case R.id.btnCero:{
                etiqueta.setText(etiqueta.getText()+"0");
                break;
            }
            case R.id.btnBorrar:{
                etiqueta.setText(""); break;
            }
            case R.id.btnSum:{
                operador1.setText(etiqueta.getText());
                etiqueta.setText("");
                op1=Integer.valueOf(operador1.getText().toString());
                simbolo="sum";
                break;
            }
            case R.id.btnRest:{
                operador1.setText(etiqueta.getText());
                etiqueta.setText("");
                op1=Integer.valueOf(operador1.getText().toString());
                simbolo="rest";
                break;
            }
            case R.id.btnMult:{
                operador1.setText(etiqueta.getText());
                etiqueta.setText("");
                op1=Integer.valueOf(operador1.getText().toString());
                simbolo="mult";
                break;
            }
            case R.id.btnDiv:{
                operador1.setText(etiqueta.getText());
                etiqueta.setText("");
                op1=Integer.valueOf(operador1.getText().toString());
                simbolo="div";
                break;
            }
            case R.id.btnIgual:{
                int resultado=0;
                op2=Integer.valueOf(etiqueta.getText().toString());
                operador1.setText("");
                switch (simbolo){

                    case "sum":{
                        resultado=op1+op2;
                        break;
                    }
                    case "rest":{
                        resultado=op1-op2;
                        break;
                    }
                    case "mult":{
                        resultado=op1*op2;
                        break;
                    }
                    case "div":{
                        resultado=op1/op2;
                        break;
                    }
                    default:{
                        etiqueta.setText(operador1.getText().toString());
                        break;
                    }

                }
                etiqueta.setText(Integer.toString(resultado));
                break;
            }


        }

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
