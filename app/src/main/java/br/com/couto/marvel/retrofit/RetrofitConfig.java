package br.com.couto.marvel.retrofit;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public abstract class RetrofitConfig {
    private static Retrofit retrofit;
    private static final String url = "http://gateway.marvel.com/v1/public/";
    private static 
    public static Retrofit getInstance(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
