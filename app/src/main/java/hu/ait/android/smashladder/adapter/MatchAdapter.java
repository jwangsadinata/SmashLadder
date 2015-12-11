package hu.ait.android.smashladder.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.parse.ParseObject;

import java.util.ArrayList;
import java.util.List;

import hu.ait.android.smashladder.R;
import hu.ait.android.smashladder.data.MatchItem;
import hu.ait.android.smashladder.fragment.MatchDetailsDialog;

/**
 * Created by joe on 12/6/15.
 */
public class MatchAdapter  extends RecyclerView.Adapter<MatchAdapter.ViewHolder>{

    public class ViewHolder extends RecyclerView.ViewHolder {

        //TODO: add more views
        public TextView tvMatch;
        public LinearLayout matchItemView;

        public ViewHolder(View view) {
            super(view);
            tvMatch = (TextView) view.findViewById(R.id.tvMatch);
            matchItemView = (LinearLayout) view.findViewById(R.id.matchItemView);
        }

    }

    private List<MatchItem> matchItemList;
    private Context context;


    public MatchAdapter(List<ParseObject> matches, Context context) {
        this.context = context;

        List<MatchItem> resValues = new ArrayList<>();
        for (int i = 0; i < matches.size(); i++) {
            resValues.add(new MatchItem(matches.get(i)));
        }

        //Collections.sort(resValues, new PlayerComparator());

        matchItemList = resValues;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.match_row, viewGroup, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        //TODO: add more stuff
        holder.tvMatch.setText(matchItemList.get(position).getChallengerName() + " vs. " + matchItemList.get(position).getOpponentName());

        holder.matchItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* //TODO: start matchdetails dialog, make sure to bundle the match item
                final MatchDetailsDialog dialog = new MatchDetailsDialog();
                dialog.show(context.getSupportFragmentManager(), MatchDetailsDialog.TAG); */
            }
        });
    }

    @Override
    public int getItemCount() {
        return matchItemList.size();
    }

    public MatchItem getItem(int i) {
        return matchItemList.get(i);
    }

    public void addMatchItem(MatchItem item) {
        //TODO: add to Parse also
        matchItemList.add(item);
        notifyDataSetChanged();
    }

}
