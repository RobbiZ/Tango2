package medion.tango;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;
import java.util.List;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.CustomViewHolder>{
    private Context context;
    private List<ScheduleModel> dataList;

    public ScheduleAdapter(Context context, List<ScheduleModel> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View mView;
        TextView custname;
        TextView plasmaname;
        TextView tanggal;
        TextView jenis;
        TextView populasi;

        CustomViewHolder(View itemView) {
            super(itemView);
            this.mView = itemView;
            this.custname = mView.findViewById(R.id.custname);
            this.plasmaname = mView.findViewById(R.id.plasmaname);
            this.tanggal = mView.findViewById(R.id.tanggal);
            this.jenis= mView.findViewById(R.id.jenis);
            this.populasi = mView.findViewById(R.id.populasi);
        }
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_schedule, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

        holder.custname.setText(dataList.get(position).getCustName());
        holder.plasmaname.setText(dataList.get(position).getPlasmaName());
        holder.tanggal.setText(dataList.get(position).getTanggal());
        holder.jenis.setText(dataList.get(position).getJenis());
        holder.populasi.setText(dataList.get(position).getPopulasi());

        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
