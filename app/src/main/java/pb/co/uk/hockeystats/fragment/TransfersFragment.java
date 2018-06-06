package pb.co.uk.hockeystats.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import pb.co.uk.hockeystats.R;

/**
 * Created by andreas_himself on 31/10/2017.
 */

public class TransfersFragment extends Fragment {

    private Toolbar mToolbar;
    private TextView mToolBarTitle;

    public static TransfersFragment newInstance() {
        return new TransfersFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_transfers, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mToolbar = view.findViewById(R.id.toolbar);

        initialiseViews();
    }

    private void initialiseViews() {
        mToolBarTitle = mToolbar.findViewById(R.id.toolbar_title);
        mToolBarTitle.setText(getString(R.string.transfers));
    }


}
