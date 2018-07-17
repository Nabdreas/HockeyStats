package pb.co.uk.hockeystats.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import pb.co.uk.hockeystats.service.model.League;
import pb.co.uk.hockeystats.service.repository.LeagueRepository;

public class LeagueViewModel extends AndroidViewModel {

    private LiveData<League> leagueObservable;

    public LeagueViewModel(@NonNull Application application) {
        super(application);

        leagueObservable = LeagueRepository.getInstance().getLeague(105);
    }

    public LiveData<League> getLeagueObservable() {
        return leagueObservable;
    }
}
