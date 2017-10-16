package com.example.trabajo.calculadora;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int op1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    private void obtainData(){
        EditText e1=(EditText) findViewById(R.id.a);
        Editable editable = e1.getText();
        String dataString = editable.toString();
        try {
            op1= Integer.parseInt(dataString);
        }catch (Exception ex){
            op1=0;
        }
    }

    public void calculatePrimeFactors(View v){

        TextView t=(TextView)findViewById(R.id.result);

        obtainData();

        int copyOfN1 = op1;
        int copyOfN2 = op1;
        int numberOfFactors = 0;

        for (int index = 2; index <= copyOfN1; index++) {
            while (copyOfN1 % index == 0) {
                numberOfFactors = numberOfFactors+1;
                copyOfN1 /= index;
            }
        }

        int[] anArray;
        anArray = new int[numberOfFactors];

        int a;
        a = 0;

        String anStringsArrayInitial;
        anStringsArrayInitial = "The Prime Factors of " + String.valueOf(copyOfN2) + " are : " + "\n" ;

        String anStringsArray;
        anStringsArray = "";
        String finalConcatenation;


        for (int i = 2; i <= op1; i++) {
            while (op1 % i == 0) {
                anArray[a]=i;
                if (a<1) {
                    anStringsArray = String.valueOf(anArray[a]);
                }else{
                    anStringsArray = anStringsArray + " * " + String.valueOf(anArray[a]);
                }
                a=a+1;
                op1 /= i;
            }
        }

        finalConcatenation = anStringsArrayInitial + anStringsArray;

        t.setText(finalConcatenation);

    }


}