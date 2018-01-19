package co.gosalo.androidreview.api;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GosaloClient {

    private static final String BASE_URL = "http://gosalo.eu-west-2.elasticbeanstalk.com";

    private Retrofit retrofit;

    public GosaloClient() {

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addNetworkInterceptor()
                .build();


        Retrofit.Builder builder = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL);

        retrofit = builder.build();
    }

    public GosaloService getGosaloService() {
        return retrofit.create(GosaloService.class);
    }
}
