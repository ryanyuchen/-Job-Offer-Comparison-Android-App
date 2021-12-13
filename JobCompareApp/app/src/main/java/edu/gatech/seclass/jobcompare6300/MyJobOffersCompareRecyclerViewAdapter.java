package edu.gatech.seclass.jobcompare6300;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import edu.gatech.seclass.jobcompare6300.JobOffersCompare.OnListFragmentInteractionListener;
import edu.gatech.seclass.jobcompare6300.jobs.Ranker;
import edu.gatech.seclass.jobcompare6300.storage.entities.JobOffer;
import edu.gatech.seclass.jobcompare6300.storage.entities.User;

import java.util.List;


public class MyJobOffersCompareRecyclerViewAdapter extends
        RecyclerView.Adapter<MyJobOffersCompareRecyclerViewAdapter.ViewHolder> {

    private final List<JobOffer> mValues;
    private final OnListFragmentInteractionListener mListener;
    private User currentUser;

    public MyJobOffersCompareRecyclerViewAdapter(User selected,
                                                 List<JobOffer> items,
                                                 OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
        currentUser = selected;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.job_offers_compare, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(String.valueOf(position + 1));
        holder.mContentView.setText(holder.mItem.getTitle() + " - " + holder.mItem.getCompany());
        holder.mScoreView.setText(
                String.valueOf(Math.floor(
                        Ranker.computeJobOfferScore(
                            currentUser.getUserWeights(),
                            holder.mItem))));
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public final TextView mScoreView;
        public JobOffer mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = view.findViewById(R.id.item_number);
            mContentView = view.findViewById(R.id.content);
            mScoreView = view.findViewById(R.id.score);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
