package pb.co.uk.hockeystats.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pb.co.uk.hockeystats.R;

/**
 * Created by andreas_himself on 31/10/2017.
 */

public class TransfersFragment extends Fragment{

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
}
