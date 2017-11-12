package pb.co.uk.hockeystats.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import pb.co.uk.hockeystats.R;
import pb.co.uk.hockeystats.fragment.ArenasFragment;
import pb.co.uk.hockeystats.fragment.LeagueFragment;
import pb.co.uk.hockeystats.fragment.NationsFragment;
import pb.co.uk.hockeystats.fragment.SearchFragment;
import pb.co.uk.hockeystats.fragment.TransfersFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mBottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation_view);

        initialiseViews();
    }

    private void initialiseViews() {
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                switch (item.getItemId()) {
                    case R.id.nations:
                        selectedFragment = NationsFragment.newInstance();
                        break;
                    case R.id.transfers:
                        selectedFragment = TransfersFragment.newInstance();
                        break;
                    case R.id.league:
                        selectedFragment = LeagueFragment.newInstance();
                        break;
                    case R.id.search:
                        selectedFragment = SearchFragment.newInstance();
                        break;
                    case R.id.arenas:
                        selectedFragment = ArenasFragment.newInstance();
                        break;
                }

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout, selectedFragment);
                transaction.commit();
                return true;
            }
        });

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, LeagueFragment.newInstance());
        transaction.commit();
    }

}
