package com.yasmin.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.yasmin.myapplication.api.API;
import com.yasmin.myapplication.databinding.ActivityMainBinding;
import com.yasmin.myapplication.model.Address;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //configurar retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://viacep.com.br/ws/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //iniciar retrofit


        binding.btBuscarcep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String cep = binding.editCep.getText().toString();


                if (cep.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Preencha o campo do cep", Toast.LENGTH_SHORT).show();

                } else {
                    API api = retrofit.create(API.class);
                    Call<Address> call = api.getAddress();
                    call.enqueue(new Callback<Address>() {
                        @Override
                        public void onResponse(Call<Address> call, Response<Address> response) {

                            if (response.code() == 200){

                                String logradouro = response.body().getLograduro().toString();
                                String bairro = response.body().getBairro().toString();
                                String localidade = response.body().getLocalidade().toString();
                                String uf = response.body().getUf().toString();
                                Formularios(logradouro,bairro,localidade,uf);
                            }else{
                                Toast.makeText(MainActivity.this, "Cep Inválido!", Toast.LENGTH_SHORT).show();

                            }
                        }

                        @Override
                        public void onFailure(Call<Address> call, Throwable t) {

                            Toast.makeText(MainActivity.this, "Ocorreu um erro inesperado", Toast.LENGTH_SHORT).show();

                        }
                    });
                }
            }

        });

    }
    public void Formularios(String logradouro, String bairro, String localidade, String uf){
        binding.editLogradouro.setText(logradouro);
        binding.editBairro.setText(bairro);
        binding.editCidade.setText(localidade);
        binding.editEstado.setText(uf);

    }
}