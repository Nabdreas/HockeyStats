package pb.co.uk.hockeystats.presenter;

import pb.co.uk.hockeystats.view.LeagueView;

public class LeaguePresenter {

    private LeagueView mView;

    public LeaguePresenter(LeagueView view) {
        mView = view;
    }

    public void request() {
        mView.displayLeagueName();
    }

}
