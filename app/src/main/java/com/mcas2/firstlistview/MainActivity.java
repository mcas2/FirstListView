package com.mcas2.firstlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    String [] paises = {"Países", "Italia", "Alemania", "Austria", "Unión Soviética"};
    private ArrayAdapter mAdapter;
    public TextView textResult;
    public TextView textResult2;
    public TextView textResult3;
    HashMap<String, String> nationalCompositors = new HashMap<String,String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nationalCompositors.put("Vivaldi","Italia");
        nationalCompositors.put("Bach", "Alemania");
        nationalCompositors.put("Beethoven","Austria");
        nationalCompositors.put("Mozart", "Austria");
        nationalCompositors.put("Shostakovich","Unión Soviética");

        Spinner sp1 = (Spinner) findViewById(R.id.sp1);
        Spinner sp2 = (Spinner) findViewById(R.id.sp2);
        textResult = (TextView) findViewById(R.id.tv1);
        textResult2 = (TextView) findViewById(R.id.tv2);
        textResult3 = (TextView) findViewById(R.id.tv3);

        mAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, paises);
        mAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        sp2.setAdapter(mAdapter);

        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    textResult.setText("No ha seleccionado nada");
                } else {
                    String showComp = sp1.getSelectedItem().toString();
                    textResult.setText("Ha seleccionado a " + showComp);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                textResult.setText("No hay selección");
            }
        });

        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                textResult2.setText(sp2.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}