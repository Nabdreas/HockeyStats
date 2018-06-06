package pb.co.uk.hockeystats.activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import pb.co.uk.hockeystats.R;

public class BaseActivity extends AppCompatActivity {

    protected ActionBar mActionBar;
    protected Toolbar mToolbar;
    protected TextView mTootBarTitle;

    protected void setupToolbar() {
        mToolbar = findViewById(R.id.toolbar);
        mTootBarTitle = findViewById(R.id.toolbar_title);
        setSupportActionBar(mToolbar);
        mActionBar = getSupportActionBar();
        if (mActionBar != null) {
            mActionBar.setDisplayHomeAsUpEnabled(true);
            mActionBar.setDisplayShowTitleEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
