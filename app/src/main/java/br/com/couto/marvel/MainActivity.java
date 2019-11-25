package br.com.couto.marvel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import br.com.couto.marvel.model.CharacterDTO;
import br.com.couto.marvel.retrofit.MarvelAPI;
import br.com.couto.marvel.retrofit.RetrofitConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit retrofit = RetrofitConfig.getInstance();
        MarvelAPI api = retrofit.create(MarvelAPI.class);
        api.getCharacter(1010344L).enqueue(new Callback<CharacterDTO>() {
            @Override
            public void onResponse(Call<CharacterDTO> call, Response<CharacterDTO> response) {
                response.body();
                Log.d("OK", response.body().toString());
            }

            @Override
            public void onFailure(Call<CharacterDTO> call, Throwable t) {
                Log.d("Erro",t.getMessage());

            }
        });
    }
}
