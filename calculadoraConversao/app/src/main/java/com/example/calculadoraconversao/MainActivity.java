package com.example.calculadoraconversao;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.calculadoraconversao.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        TextView resultado = findViewById(R.id.exibirResultado);

        Button botaoConverter = findViewById(R.id.botaoConverter);
        botaoConverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                converter();

            }

            private void converter() {
                EditText valorInput = findViewById(R.id.inputValor);

                RadioGroup grupoOpcoes = findViewById(R.id.grupoEscolha);
                int opcaoSelecionada = grupoOpcoes.getCheckedRadioButtonId();

                double valorConvertido;

                if (opcaoSelecionada == R.id.rdEur) {
                    valorConvertido = Double.parseDouble(valorInput.getText().toString()) * 5.35;

                } else if (opcaoSelecionada == R.id.rdLbr) {
                    valorConvertido = Double.parseDouble(valorInput.getText().toString()) * 4.87;

                } else {
                    valorConvertido = Double.parseDouble(valorInput.getText().toString()) * 6.22;
                }

                resultado.setText(String.valueOf(valorConvertido));
                resultado.setVisibility(View.VISIBLE);


            }
        });
    }
}