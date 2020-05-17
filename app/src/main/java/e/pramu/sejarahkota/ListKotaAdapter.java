package e.pramu.sejarahkota;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class ListKotaAdapter extends RecyclerView.Adapter<ListKotaAdapter.ListViewHolder> {

    private ArrayList<Kota> listKota;
    private Context context;
    public ListKotaAdapter(ArrayList<Kota> list){
        this.listKota = list;
    }
    public ListKotaAdapter(Context ctx,ArrayList<Kota> kt){
        context = ctx;
        listKota = kt;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_kota,viewGroup,false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, final int position) {
        Kota kota = listKota.get(position);
        Glide.with(holder.itemView.getContext())
                .load(kota.getPhotoKota())
                .apply(new RequestOptions().override(60,60))
                .into(holder.imgPhoto);
        holder.tvName.setText(kota.getNamaKota());
        holder.tvDetail.setText(kota.getDetailKota());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,detailKota.class);
                intent.putExtra("NamaKota",listKota.get(position).getNamaKota());
                intent.putExtra("DetailKota",listKota.get(position).getDetailKota());
                intent.putExtra("PhotoKota",listKota.get(position).getPhotoKota());
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return listKota.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName,tvDetail;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDetail = itemView.findViewById(R.id.tv_item_detail);
        }
    }
}

