package es.iesnervion.atellez.ejemplosaveinstance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Integer contador = 0;
    static final String TOTAL = "contador";
    Button btn1, btnMostrar;
    TextView txtResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btnSuma);
        btnMostrar = (Button) findViewById(R.id.btnMostrar);
        txtResultado = (TextView) findViewById(R.id.resultado);


        btn1.setOnClickListener(this);
        btnMostrar.setOnClickListener(this);

        if(savedInstanceState !=null){
            contador = savedInstanceState.getInt(TOTAL);
        }else{
            contador = 0;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSuma:

                contador++;
                break;
            case R.id.btnMostrar:
                txtResultado.setText(contador.toString());
                break;
        }
    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        savedInstanceState.putInt(TOTAL, contador);

        super.onSaveInstanceState(savedInstanceState);
    }


}
