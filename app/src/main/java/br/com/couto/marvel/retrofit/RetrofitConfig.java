package br.com.couto.marvel.retrofit;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public abstract class RetrofitConfig {
    private static Retrofit retrofit;
    private static final String url = "http://gateway.marvel.com/v1/public/";
    private static final String PUBLIC_KEY = "ab64f13f191c62a2c96cfd459a9d9f62";
    private static final String PRIVATE_KEY = "bf953f1d468f3ff0a870d9d96526599dd9f179fd";
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
