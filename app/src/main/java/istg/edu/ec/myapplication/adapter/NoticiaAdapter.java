package istg.edu.ec.myapplication.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import istg.edu.ec.myapplication.NoticiaEmit;
import istg.edu.ec.myapplication.R;

public class NoticiaAdapter extends RecyclerView.Adapter<NoticiaAdapter.ViewHolder> {
    ArrayList<NoticiaEmit> items;
    Context context;
    public NoticiaAdapter(ArrayList<NoticiaEmit> items) {
        this.items = items;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.items, parent, false);
        context = parent.getContext();
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.titleTxt.setText(items.get(position).getTitulo());
        holder.timeTxt.setText(items.get(position).getDetalle());
        holder.ScoreTxt.setText(items.get(position).getFecha());
        @SuppressLint("DiscouragedApi") int drawableResourceId = holder.itemView.getResources().getIdentifier(items.get(position).getPicUrl(), "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .transform(new GranularRoundedCorners(30, 30, 0, 0))
                .into(holder.pic);

        holder.itemView.setOnClickListener(v -> {
            //Intent intent=new Intent(holder.itemView.getContext(), DetailActivity.class);
            //intent.putExtra("object",items.get(position));
            //holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTxt, timeTxt, ScoreTxt;
        ImageView pic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTxt = itemView.findViewById(R.id.titleTxt);
            timeTxt = itemView.findViewById(R.id.timeTxtR);
            ScoreTxt = itemView.findViewById(R.id.ScoreTxt);
            pic = itemView.findViewById(R.id.pic);

        }
    }

}

