package medion.tango;

import android.app.ProgressDialog;
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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading....");
        progressDialog.show();

        /*Create handle for the RetrofitInstance interface*/
        BaseApiService service = RetrofitClient.getAPIService();

        String user = LoginActivity.shareuser;

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
    }
}
