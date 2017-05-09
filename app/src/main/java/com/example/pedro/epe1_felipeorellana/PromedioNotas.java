package com.example.pedro.epe1_felipeorellana;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;
import static com.example.pedro.epe1_felipeorellana.R.id.btnCalcularEx;
import static com.example.pedro.epe1_felipeorellana.R.id.txtPromedio;
import static com.example.pedro.epe1_felipeorellana.R.id.txtPromedioFinal;

public class PromedioNotas extends AppCompatActivity {

    double s1,s2,s3,s4,e1,e2,e3,e4;
    double promsol1,promsol2,promsol3,promsol4,promeva1,promeva2,promeva3,promeva4;
    double promediosEva,total1;

    EditText solemne1, solemne2, solemne3, solemne4, eva1, eva2, eva3, eva4, txtPromedio, txtNotaExamen, txtPromedioFinal;
    Button btnCalcular, btnLimpiar, btnVolver, btnCalcularEx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promedio_notas);
        //Solemnes
        solemne1 = (EditText) findViewById(R.id.txtEPR1);
        solemne2 = (EditText) findViewById(R.id.txtEPE1);
        solemne3 = (EditText) findViewById(R.id.txtEPR2);
        solemne4 = (EditText) findViewById(R.id.txtEPE2);
        //EVAS
        eva1 = (EditText) findViewById(R.id.txtE1);
        eva2 = (EditText) findViewById(R.id.txtE2);
        eva3 = (EditText) findViewById(R.id.txtE3);
        eva4 = (EditText) findViewById(R.id.txtE4);
        //Nota examen
        txtNotaExamen = (EditText) findViewById(R.id.txtNotaExamen);
        //llamar id plaintext Promedio
        txtPromedio = (EditText) findViewById(R.id.txtPromedio);
        //llamar al plaindtext promediofinal
        txtPromedioFinal = (EditText) findViewById(R.id.txtPromedioFinal);
        //llamar al boton calcularex
        btnCalcularEx = (Button) findViewById(R.id.btnCalcularEx);
        //llamar id boton Volver
        btnVolver = (Button) findViewById(R.id.btnVolver);
        //llamar id boton Limpiar
        btnLimpiar = (Button) findViewById(R.id.btnLimpiar);
        //llamar id boton Calcular
        btnCalcular = (Button) findViewById(R.id.btnCalcular);

        //Accion del boton Volver
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btnVolver = new Intent(PromedioNotas.this, MainActivity.class);
                startActivity(btnVolver);
                finish();
            }
        });

        //Accion del boton Limpiar
        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                solemne1.setText("");
                solemne2.setText("");
                solemne3.setText("");
                solemne4.setText("");
                eva1.setText("");
                eva2.setText("");
                eva3.setText("");
                eva4.setText("");
                txtPromedio.setText("");
                txtNotaExamen.setText("");
                txtPromedioFinal.setText("");

                solemne1.requestFocus();

            }
        });

        //Accion del boton Calcular
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //VALIDACION DE VACIOS
                if (solemne1.getText().length() == 0) {
                    Toast.makeText(PromedioNotas.this, "Campo EPR1 Vacio", Toast.LENGTH_SHORT).show();
                    solemne1.requestFocus();
                } else {
                    if (solemne2.getText().length() == 0) {
                        Toast.makeText(PromedioNotas.this, "Campo EPE1 Vacio", Toast.LENGTH_SHORT).show();
                        solemne2.requestFocus();
                    } else {
                        if (solemne3.getText().length() == 0) {
                            Toast.makeText(PromedioNotas.this, "Campo EPR2 Vacio", Toast.LENGTH_SHORT).show();
                            solemne3.requestFocus();
                        } else {
                            if (solemne4.getText().length() == 0) {
                                Toast.makeText(PromedioNotas.this, "Campo EPE2 Vacio", Toast.LENGTH_SHORT).show();
                                solemne4.requestFocus();
                            } else {
                                if (eva1.getText().length() == 0) {
                                    Toast.makeText(PromedioNotas.this, "Campo EVA1 Vacio", Toast.LENGTH_SHORT).show();
                                    eva1.requestFocus();
                                } else {
                                    if (eva2.getText().length() == 0) {
                                        Toast.makeText(PromedioNotas.this, "Campo EVA2 Vacio", Toast.LENGTH_SHORT).show();
                                        eva2.requestFocus();
                                    } else {
                                        if (eva3.getText().length() == 0) {
                                            Toast.makeText(PromedioNotas.this, "Campo EVA3 Vacio", Toast.LENGTH_SHORT).show();
                                            eva3.requestFocus();
                                        } else {
                                            if (eva4.getText().length() == 0) {
                                                Toast.makeText(PromedioNotas.this, "Campo EVA4 Vacio", Toast.LENGTH_SHORT).show();
                                                eva4.requestFocus();
                                            } else {

                                                s1 = Double.parseDouble(solemne1.getText().toString());
                                                s2 = Double.parseDouble(solemne2.getText().toString());
                                                s3 = Double.parseDouble(solemne3.getText().toString());
                                                s4 = Double.parseDouble(solemne4.getText().toString());
                                                e1 = Double.parseDouble(eva1.getText().toString());
                                                e2 = Double.parseDouble(eva2.getText().toString());
                                                e3 = Double.parseDouble(eva3.getText().toString());
                                                e4 = Double.parseDouble(eva4.getText().toString());

                                                //VALIDACION DE NOTAS SEGUN EL RANGO

                                                int contador = 0;

                                                if(s1<10 || s1>70){
                                                    Toast.makeText(PromedioNotas.this, "Rango de notas debe ser entre 10 y 70 en EPR1", Toast.LENGTH_SHORT).show();
                                                    solemne1.setText("");
                                                    solemne1.requestFocus();
                                                    contador += 1;
                                                }
                                                if(s2<10 || s2>70){
                                                    Toast.makeText(PromedioNotas.this, "Rango de notas debe ser entre 10 y 70 en EPE1", Toast.LENGTH_SHORT).show();
                                                    solemne2.setText("");
                                                    solemne2.requestFocus();
                                                    contador += 1;
                                                }
                                                if(s3<10 || s3>70){
                                                    Toast.makeText(PromedioNotas.this, "Rango de notas debe ser entre 10 y 70 en EPR2", Toast.LENGTH_SHORT).show();
                                                    solemne3.setText("");
                                                    solemne3.requestFocus();
                                                    contador += 1;
                                                }
                                                if(s4<10 || s4>70){
                                                    Toast.makeText(PromedioNotas.this, "Rango de notas debe ser entre 10 y 70 en EPE2", Toast.LENGTH_SHORT).show();
                                                    solemne4.setText("");
                                                    solemne4.requestFocus();
                                                    contador += 1;
                                                }
                                                if(e1<10 || e1>70){
                                                    Toast.makeText(PromedioNotas.this, "Rango de notas debe ser entre 10 y 70 en EVA1", Toast.LENGTH_SHORT).show();
                                                    eva1.setText("");
                                                    eva1.requestFocus();
                                                    contador += 1;
                                                }
                                                if(e2<10 || e2>70){
                                                    Toast.makeText(PromedioNotas.this, "Rango de notas debe ser entre 10 y 70 en EVA2", Toast.LENGTH_SHORT).show();
                                                    eva2.setText("");
                                                    eva2.requestFocus();
                                                    contador += 1;
                                                }
                                                if(e3<10 || e3>70){
                                                    Toast.makeText(PromedioNotas.this, "Rango de notas debe ser entre 10 y 70 en EVA3", Toast.LENGTH_SHORT).show();
                                                    eva3.setText("");
                                                    eva3.requestFocus();
                                                    contador += 1;
                                                }
                                                if(e4<10 || e4>70){
                                                    Toast.makeText(PromedioNotas.this, "Rango de notas debe ser entre 10 y 70 en EVA4", Toast.LENGTH_SHORT).show();
                                                    eva4.setText("");
                                                    eva4.requestFocus();
                                                    contador += 1;
                                                }

                                                Log.d("CONT"," "+contador);
                                                if(contador == 0){

                                                    //Calculo para promedio
                                                    promsol1 = (s1 * 10) / 100;
                                                    promsol2 = (s2 * 15) / 100;
                                                    promsol3 = (s3 * 20) / 100;
                                                    promsol4 = (s4 * 25) / 100;

                                                    promeva1 = (e1 * 7.5) / 100;
                                                    promeva2 = (e2 * 7.5) / 100;
                                                    promeva3 = (e3 * 7.5) / 100;
                                                    promeva4 = (e4 * 7.5) / 100;

                                                    promediosEva = (e1 + e2 + e3 + e4) / 4;

                                                    total1 = (promsol1 + promsol2 + promsol3 + promsol4 + promeva1 + promeva2 + promeva3 + promeva4);

                                                    //Parsear a String el total
                                                    String total = Double.toString(total1);
                                                    //Mostrar en cuadro de texto
                                                    txtPromedio.setText(total);

                                                    if (s1 < 40) {
                                                        Toast.makeText(PromedioNotas.this, "Debes dar examen EPR1 bajo 40", Toast.LENGTH_SHORT).show();
                                                    } else {
                                                        if (s2 < 40) {
                                                            Toast.makeText(PromedioNotas.this, "Debes dar examen EPE1 bajo 40", Toast.LENGTH_SHORT).show();
                                                        } else {
                                                            if (s3 < 40) {
                                                                Toast.makeText(PromedioNotas.this, "Debes dar examen EPR2 bajo 40", Toast.LENGTH_SHORT).show();
                                                            } else {
                                                                if (s4 < 40) {
                                                                    Toast.makeText(PromedioNotas.this, "Debes dar examen EPE2 bajo 40", Toast.LENGTH_SHORT).show();
                                                                } else {
                                                                    if (promediosEva < 40) {
                                                                        Toast.makeText(PromedioNotas.this, "Debes dar examen promedio evas bajo 40", Toast.LENGTH_SHORT).show();
                                                                    }else{
                                                                        if (total1<55){
                                                                            Toast.makeText(PromedioNotas.this, "Debes dar examen promedio bajo 55", Toast.LENGTH_SHORT).show();
                                                                        }else{
                                                                            txtNotaExamen.setEnabled(false);
                                                                            txtPromedioFinal.setText(total);
                                                                            Toast.makeText(PromedioNotas.this, "No debes dar Examen", Toast.LENGTH_SHORT).show();
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }

                                                }
                                            }//Fin del 1er if
                                        }
                                    }
                                }
                            }
                        }
                    }
                }//1er if



            }
        });

        btnCalcularEx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(s1 < 40 || s2 < 40 || s3 < 40 || s4 < 40 || e1 < 40 || e2 < 40 || e3 < 40 || e4 < 40 || total1<55){

                    double totalPresentacion = total1*0.70;
                    //Promedio Examen
                    double notae = Double.parseDouble(txtNotaExamen.getText().toString());
                    double examen = notae * 0.30;

                    double promedioFinal = totalPresentacion + examen;
                    String promfinal = Double.toString(promedioFinal);
                    txtPromedioFinal.setText(promfinal);

                }
            }
        });
    }

}

