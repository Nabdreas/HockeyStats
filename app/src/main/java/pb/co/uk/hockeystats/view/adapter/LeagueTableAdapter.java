package pb.co.uk.hockeystats.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pb.co.uk.hockeystats.R;
import pb.co.uk.hockeystats.view.viewholder.LeagueTableViewHolder;

public class LeagueTableAdapter extends RecyclerView.Adapter<LeagueTableViewHolder> {

    private String[] mTeams;
    private LeagueTableListener mLeagueTableListener;

    public LeagueTableAdapter(String[] teams) {
        mTeams = teams;
    }

    @Override
    public LeagueTableViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.league_table_row, parent, false);
        LeagueTableViewHolder viewHolder = new LeagueTableViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final LeagueTableViewHolder holder, int position) {
        holder.mTeamName.setText(mTeams[position]);

        holder.mTeamName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLeagueTableListener.onTeamClicked(mTeams[holder.getAdapterPosition()], holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTeams.length;
    }

    public void setListener(LeagueTableListener listener) {
        mLeagueTableListener = listener;
    }

    public interface LeagueTableListener {
        void onTeamClicked(String teamName, int position);
    }
}
