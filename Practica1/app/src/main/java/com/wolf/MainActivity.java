package com.wolf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText temperature = findViewById(R.id.temperature);
        TextView result = findViewById(R.id.txt_result);
        Button boton = findViewById(R.id.btn_convert);


        boton.setOnClickListener(v->{
            double conversion;
            double conversionResult = 0;
            String farentheit = temperature.getText().toString();
            if(!farentheit.isEmpty()) {
                String success = getString(R.string.success);
                try {
                    conversion = Double.parseDouble(farentheit);
                    conversionResult = ((conversion - 32)* 5) / 9;
                    Toast.makeText(this, conversionResult + " ",
                            Toast.LENGTH_SHORT).show();
                } catch(NumberFormatException nfe) {
                    conversion = 0;
                    Toast.makeText(this, R.string.fail,
                            Toast.LENGTH_SHORT).show();
                }
                result.setText(conversionResult + "");
            }else{
                Toast.makeText(this, R.string.fail,
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
}