package pb.co.uk.hockeystats.service.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import pb.co.uk.hockeystats.BuildConfig;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class BaseApi {

    private OkHttpClient okHttpClient;
    private Gson gson;

    public static final String BASE_URL = "http://api.eliteprospects.com:80/beta/";

    protected BaseApi() {
        super();

        gson = new GsonBuilder()
                .setLenient()
                .create();

    }

    protected abstract void buildService();

    public Retrofit getClient() {
        okHttpClient = buildOkHttpClient();
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit;
    }

    private OkHttpClient buildOkHttpClient() {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                HttpUrl originalHttpUrl = original.url();

                HttpUrl url = originalHttpUrl.newBuilder()
                        .addQueryParameter("apikey", BuildConfig.ELITE_PROSPECT_TOKEN)
                        .build();

                // Request customization: add request headers
                Request.Builder requestBuilder = original.newBuilder()
                        .url(url);

                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        }).build();
        return client;
    }

}
