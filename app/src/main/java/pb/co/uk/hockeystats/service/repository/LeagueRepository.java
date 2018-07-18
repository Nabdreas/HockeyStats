package pb.co.uk.hockeystats.service.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import java.util.List;

import pb.co.uk.hockeystats.service.model.League;
import pb.co.uk.hockeystats.service.network.BaseApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LeagueRepository extends BaseApi {

    private LeagueService leagueService;
    private static LeagueRepository leagueRepository;

    private LeagueRepository() {
        super();
        buildService();
    }

    @Override
    protected void buildService() {
        leagueService = getClient().create(LeagueService.class);
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
                if (response.isSuccessful()) {
                    data.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<League> call, Throwable t) {

            }
        });

        return data;
    }
}
