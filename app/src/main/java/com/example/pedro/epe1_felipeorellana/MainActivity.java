package com.example.pedro.epe1_felipeorellana;

import android.content.Intent;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button promedio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        promedio = (Button) findViewById(R.id.btnPromedio);

        promedio.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent promedio = new Intent(MainActivity.this, PromedioNotas.class);
                startActivity(promedio);
                finish();
            }
        });
    }
}
