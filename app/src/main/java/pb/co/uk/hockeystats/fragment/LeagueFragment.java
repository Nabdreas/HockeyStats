package pb.co.uk.hockeystats.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import pb.co.uk.hockeystats.R;
import pb.co.uk.hockeystats.activity.TeamActivity;
import pb.co.uk.hockeystats.adapters.LeagueTableAdapter;
import pb.co.uk.hockeystats.presenter.LeaguePresenter;
import pb.co.uk.hockeystats.view.LeagueView;

/**
 * Created by andreas_himself on 31/10/2017.
 */

public class LeagueFragment extends Fragment implements LeagueView {

    private LeaguePresenter mPresenter;

    private Toolbar mToolbar;
    private TextView mToolBarTitle;
    private TextView mLeagueTitle;
    private RecyclerView mLeagueTableRecyclerView;

    private LeagueTableAdapter mLeagueTableAdapter;

    private String[] mTeams = {"Cardiff Devils", "Manchester Storm", "Braehead Clan",
            "Belfast Giants", "Coventry Blaze", "Nottingham Panthers", "Sheffield Steelers", "MK Lightning", "Dundee Stars", "Guildford Flames"};

    private LinearLayoutManager mLinearLayoutManager;

    private LeagueTableAdapter.LeagueTableListener mListener = new LeagueTableAdapter.LeagueTableListener() {
        @Override
        public void onTeamClicked(String teamName, int position) {
            startActivity(TeamActivity.newIntent(getActivity(), teamName));
        }
    };

    public static LeagueFragment newInstance() {
        Bundle args = new Bundle();

        LeagueFragment fragment = new LeagueFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter = new LeaguePresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_league, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mToolbar = view.findViewById(R.id.toolbar);
        mLeagueTitle = view.findViewById(R.id.league_title_label);
        mLeagueTableRecyclerView = view.findViewById(R.id.league_table);
        initialiseViews();

        mPresenter.request();
    }

    private void initialiseViews() {
        mToolBarTitle = mToolbar.findViewById(R.id.toolbar_title);

        mLeagueTableRecyclerView.setHasFixedSize(true);
        mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mLeagueTableRecyclerView.setLayoutManager(mLinearLayoutManager);

        mLeagueTableAdapter = new LeagueTableAdapter(mTeams);
        mLeagueTableRecyclerView.setAdapter(mLeagueTableAdapter);
        mLeagueTableAdapter.setListener(mListener);

    }


    @Override
    public void displayLeagueName() {
        mToolBarTitle.setText(getString(R.string.league));
        mLeagueTitle.setText("Elite Ice Hockey League");
    }
}
