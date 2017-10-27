package alrayes.kodi;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Ala'a on 10/19/2017.
 */

public class MovieTypeAdapter extends RecyclerView.Adapter<MovieTypeAdapter.ViewHolder> {
    private List<String> values;

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView txtHeader;
       // public TextView txtFooter;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtHeader = (TextView) v.findViewById(R.id.movietype_txt);
          //  txtFooter = (TextView) v.findViewById(R.id.secondLine);
        }


    }
    public void add(int position, String item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MovieTypeAdapter(List<String> myDataset) {
        values = myDataset;
    }


    @Override
    public MovieTypeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.movietype_row, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final String name = values.get(position);
        holder.txtHeader.setText(name);
        holder.txtHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position==0) {

                    Intent intent = new Intent(v.getContext(), PosterActivity.class);
                    v.getContext().startActivity(intent);

                }
            }
        });

        //holder.txtFooter.setText("Footer: " + name);
    }

    @Override
    public int getItemCount() {
        return values.size();
    }


}
