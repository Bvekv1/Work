package adapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.work.work.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import model.Details;

public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.DetailsViewHolder> {
    Context Context;
    List<Details> detailsList;
    //constructor to receive data from the activity


    public DetailsAdapter(Context Context, List<Details> detailsList) {
        this.Context = Context;
        this.detailsList = detailsList;
    }

    @NonNull
    @Override
    public DetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list,parent , false);
        return new DetailsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailsViewHolder holder, int position) {

       final Details detail = detailsList.get(position);
        holder.imgProfile.setImageResource(detail.getImageId());
        holder.textName.setText(detail.getName());
        holder.textAge.setText(detail.getAge());
        holder.textGender.setText(detail.getGender());


    }

    @Override
    public int getItemCount() {
        return detailsList.size();
    }

    public  class DetailsViewHolder extends RecyclerView.ViewHolder{
        CircleImageView imgProfile;
        TextView textName, textAge, textGender;
        public DetailsViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProfile = itemView.findViewById(R.id.imgProfile);
            textName = itemView.findViewById(R.id.textName);
            textAge = itemView.findViewById(R.id.textAge);
            textGender = itemView.findViewById(R.id.textGender);

        }
    }
}
