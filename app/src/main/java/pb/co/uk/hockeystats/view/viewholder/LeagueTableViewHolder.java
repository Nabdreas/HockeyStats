package pb.co.uk.hockeystats.view.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import pb.co.uk.hockeystats.R;

public class LeagueTableViewHolder extends RecyclerView.ViewHolder {

    public TextView mTeamName;

    public LeagueTableViewHolder(View itemView) {
        super(itemView);

        mTeamName = itemView.findViewById(R.id.team_name_league_table_label);
    }
}
