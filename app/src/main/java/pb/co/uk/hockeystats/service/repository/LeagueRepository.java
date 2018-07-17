package pb.co.uk.hockeystats.service.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import pb.co.uk.hockeystats.service.model.League;
import pb.co.uk.hockeystats.service.network.BaseApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LeagueRepository {

    private LeagueService leagueService;
    private static LeagueRepository leagueRepository;

    private LeagueRepository() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        leagueService = retrofit.create(LeagueService.class);
    }

    public synchronized static LeagueRepository getInstance() {
        if (leagueRepository == null) {
            leagueRepository = new LeagueRepository();
        }
        return leagueRepository;
    }

    public LiveData<League> getLeague(long leagueId) {
        final MutableLiveData<League> data = new MutableLiveData<>();

        leagueService.getLeague(leagueId).enqueue(new Callback<League>() {
            @Override
            public void onResponse(Call<League> call, Response<League> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<League> call, Throwable t) {

            }
        });

        return data;
    }
}
