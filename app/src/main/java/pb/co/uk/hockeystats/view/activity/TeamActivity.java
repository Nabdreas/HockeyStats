package pb.co.uk.hockeystats.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import pb.co.uk.hockeystats.R;

public class TeamActivity extends BaseActivity {

    private static final String KEY_TEAM_NAME = "key_team_name";

    private TextView mTeamNameTitle;
    private String mTeamName;

    public static Intent newIntent(Context context, String teamName) {
        Intent intent = new Intent(context, TeamActivity.class);
        intent.putExtra(KEY_TEAM_NAME, teamName);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.team_page);
        setupToolbar();

        mTeamNameTitle = findViewById(R.id.team_name_title);
        mTeamName = getIntent().getStringExtra(KEY_TEAM_NAME);
        initialiseViews();
    }

    private void initialiseViews() {
        mTootBarTitle.setText(mTeamName);
    }


}
