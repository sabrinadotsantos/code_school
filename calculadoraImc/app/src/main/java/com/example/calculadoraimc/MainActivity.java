package com.example.calculadoraimc;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import androidx.navigation.ui.AppBarConfiguration;
import com.example.calculadoraimc.databinding.ActivityMainBinding;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        TextView resultado = findViewById(R.id.resultado);

        Button botaoCalcular = findViewById(R.id.botaoCalcular);
        botaoCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calcular();
            }
            private void calcular (){

                TextView altura = findViewById(R.id.altura);
                TextView peso = findViewById(R.id.peso);
                TextView classificao = findViewById(R.id.classificacao);

                double alturaNova;
                double pesoNovo;
                double imcCalculado;

                 alturaNova = Double.parseDouble(altura.getText().toString());
                 pesoNovo = Double.parseDouble(peso.getText().toString());

                 imcCalculado = pesoNovo / (alturaNova * alturaNova);

                String imcFormatado = String.format("%.2f", imcCalculado);


                resultado.setText(imcFormatado);


                if (imcCalculado < 18.5) {
                    classificao.setText("Filezinho!");

                } else if (imcCalculado < 25) {
                   classificao.setText("Diliça!");
                } else if (imcCalculado < 30) {
                    classificao.setText("Ta top!");
                } else {
                    classificao.setText("O la em casa!");
                }

                classificao.setVisibility(View.VISIBLE);
                resultado.setVisibility(View.VISIBLE);

            }
        });

    }
}