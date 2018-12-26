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

public class HistoryFragment extends Fragment {
    public HistoryFragment(){
        //required empty constructor
    }

    private RecyclerView recyclerView;
    ProgressDialog progressDialog;
    SharedPrefManager sharedPrefManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPrefManager = new SharedPrefManager(getActivity());
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading....");
        progressDialog.show();

        /*Create handle for the RetrofitInstance interface*/
        BaseApiService service = RetrofitClient.getAPIService();

        //String user = LoginActivity.shareuser;
        String user = sharedPrefManager.getSPNama();

        Call<List<HistoryModel>> call = service.getHistory(user);
        call.enqueue(new Callback<List<HistoryModel>>() {

            @Override
            public void onResponse(@NonNull Call<List<HistoryModel>> call, @NonNull Response<List<HistoryModel>> response) {
                progressDialog.dismiss();
                generateDataList(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<List<HistoryModel>> call, @NonNull Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getActivity(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        recyclerView = view.findViewById(R.id.historyRecyclerView);
        return view;
    }

    /*Method to generate List of data using RecyclerView with custom adapter*/
    private void generateDataList(List<HistoryModel> historyList) {
        HistoryAdapter adapter = new HistoryAdapter(getActivity(), historyList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        initDataIntent(historyList);
    }

    private void initDataIntent(final List<HistoryModel> historyList){
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        String vacid = historyList.get(position).getVacid();
                        String custname = historyList.get(position).getCustName();
                        String plasmaname = historyList.get(position).getPlasmaName();
                        String address = historyList.get(position).getAddress();
                        String city = historyList.get(position).getCity();
                        String phone = historyList.get(position).getPhone();
                        String area = historyList.get(position).getArea();
                        String tanggal = historyList.get(position).getTanggal();
                        String populasi = historyList.get(position).getPopulasi();
                        String jenis = historyList.get(position).getJenis();
                        String umur = historyList.get(position).getUmur();
                        String aplikasi = historyList.get(position).getAplikasi();
                        String productname = historyList.get(position).getProductname();

                        String donumber = historyList.get(position).getDonumber();
                        String batch = historyList.get(position).getBatch();
                        String kmstart = historyList.get(position).getKmstart();
                        String kmfinish = historyList.get(position).getKmfinish();
                        String remark = historyList.get(position).getRemark();
                        String reschedule = historyList.get(position).getReschedule();
                        String newdate = historyList.get(position).getNewdate();
                        String cancel = historyList.get(position).getCancel();

                        Intent intent = new Intent(getActivity(), HistoryDetailActivity.class);

                        intent.putExtra(SharedPrefManager.KEY_VACID, vacid);
                        intent.putExtra(SharedPrefManager.KEY_CUSTNAME, custname);
                        intent.putExtra(SharedPrefManager.KEY_PLASMANAME, plasmaname);
                        intent.putExtra(SharedPrefManager.KEY_ADDRESS, address);
                        intent.putExtra(SharedPrefManager.KEY_CITY, city);
                        intent.putExtra(SharedPrefManager.KEY_PHONE, phone);
                        intent.putExtra(SharedPrefManager.KEY_AREA, area);
                        intent.putExtra(SharedPrefManager.KEY_TANGGAL, tanggal);
                        intent.putExtra(SharedPrefManager.KEY_POPULASI, populasi);
                        intent.putExtra(SharedPrefManager.KEY_JENIS, jenis);
                        intent.putExtra(SharedPrefManager.KEY_UMUR, umur);
                        intent.putExtra(SharedPrefManager.KEY_APLIKASI, aplikasi);
                        intent.putExtra(SharedPrefManager.KEY_PRODUCTNAME, productname);

                        intent.putExtra(SharedPrefManager.KEY_DONUMBER, donumber);
                        intent.putExtra(SharedPrefManager.KEY_BATCH, batch);
                        intent.putExtra(SharedPrefManager.KEY_KMSTART, kmstart);
                        intent.putExtra(SharedPrefManager.KEY_KMFINISH, kmfinish);
                        intent.putExtra(SharedPrefManager.KEY_REMARK, remark);
                        intent.putExtra(SharedPrefManager.KEY_RESCHEDULE, reschedule);
                        intent.putExtra(SharedPrefManager.KEY_NEWDATE, newdate);
                        intent.putExtra(SharedPrefManager.KEY_CANCEL, cancel);

                        startActivity(intent);
                    }
                }));
    }
}
