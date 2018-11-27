package medion.tango;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScheduleFragment extends Fragment {
    public ScheduleFragment(){
        //required empty constructor
    }

    private RecyclerView recyclerView;
    ProgressDialog progressDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading....");
        progressDialog.show();

        /*Create handle for the RetrofitInstance interface*/
        BaseApiService service = RetrofitClient.getAPIService();

        String user = LoginActivity.shareuser;

        Call<List<ScheduleModel>> call = service.getSchedule(user);
        call.enqueue(new Callback<List<ScheduleModel>>() {

            @Override
            public void onResponse(@NonNull Call<List<ScheduleModel>> call, @NonNull Response<List<ScheduleModel>> response) {
                progressDialog.dismiss();
                generateDataList(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<List<ScheduleModel>> call, @NonNull Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getActivity(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);
        recyclerView = view.findViewById(R.id.scheduleRecyclerView);
        return view;
    }

    /*Method to generate List of data using RecyclerView with custom adapter*/
    private void generateDataList(List<ScheduleModel> scheduleList) {
        ScheduleAdapter adapter = new ScheduleAdapter(getActivity(), scheduleList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        initDataIntent(scheduleList);
    }

    private void initDataIntent(final List<ScheduleModel> scheduleList){
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        String vacid = scheduleList.get(position).getVacid();
                        String custname = scheduleList.get(position).getCustName();
                        String plasmaname = scheduleList.get(position).getPlasmaName();
                        String address = scheduleList.get(position).getAddress();
                        String city = scheduleList.get(position).getCity();
                        String phone = scheduleList.get(position).getPhone();
                        String area = scheduleList.get(position).getArea();
                        String tanggal = scheduleList.get(position).getTanggal();
                        String populasi = scheduleList.get(position).getPopulasi();
                        String jenis = scheduleList.get(position).getJenis();
                        String umur = scheduleList.get(position).getUmur();
                        String aplikasi = scheduleList.get(position).getAplikasi();
                        String productname = scheduleList.get(position).getProductname();

                        Intent intent = new Intent(getActivity(), ScheduleDetailActivity.class);

                        intent.putExtra(SharedKeys.KEY_VACID, vacid);
                        intent.putExtra(SharedKeys.KEY_CUSTNAME, custname);
                        intent.putExtra(SharedKeys.KEY_PLASMANAME, plasmaname);
                        intent.putExtra(SharedKeys.KEY_ADDRESS, address);
                        intent.putExtra(SharedKeys.KEY_CITY, city);
                        intent.putExtra(SharedKeys.KEY_PHONE, phone);
                        intent.putExtra(SharedKeys.KEY_AREA, area);
                        intent.putExtra(SharedKeys.KEY_TANGGAL, tanggal);
                        intent.putExtra(SharedKeys.KEY_POPULASI, populasi);
                        intent.putExtra(SharedKeys.KEY_JENIS, jenis);
                        intent.putExtra(SharedKeys.KEY_UMUR, umur);
                        intent.putExtra(SharedKeys.KEY_APLIKASI, aplikasi);
                        intent.putExtra(SharedKeys.KEY_PRODUCTNAME, productname);

                        startActivity(intent);
                    }
                }));
    }
}
