package pb.co.uk.hockeystats.view.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;

import pb.co.uk.hockeystats.R;
import pb.co.uk.hockeystats.view.fragment.LeagueFragment;
import pb.co.uk.hockeystats.view.fragment.SearchFragment;
import pb.co.uk.hockeystats.view.fragment.TransfersFragment;

public class MainActivity extends BaseActivity {

    private BottomNavigationView mBottomNavigationView;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.transfers:
                    selectedFragment(TransfersFragment.newInstance());
                    return true;
                case R.id.league:
                    selectedFragment(LeagueFragment.newInstance());
                    return true;
                case R.id.search:
                    selectedFragment(SearchFragment.newInstance());
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBottomNavigationView = findViewById(R.id.navigation_view);

        initialiseViews();
    }

    private void initialiseViews() {
        mBottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        mBottomNavigationView.setSelectedItemId(R.id.league);
    }

    private void selectedFragment(Fragment selectedFragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, selectedFragment);
        transaction.commit();
    }

}
