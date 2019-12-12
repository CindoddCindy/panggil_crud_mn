package cindy.test.apipost;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cindy.test.apipost.adapter.AdapterGetData;
import cindy.test.apipost.pojo.Datum;
import cindy.test.apipost.pojo.GetPostResponData;
import cindy.test.apipost.retro.RetrofitInter;
import cindy.test.apipost.retro.RetrofitUrl;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetData extends AppCompatActivity {

    RecyclerView recyclerView;
    AdapterGetData adapterGetData;
    //String datumList  = new String();
    //ArrayList<Datum> datumList= new ArrayList<>();

    RetrofitUrl retrofitUrl ;
    Context context;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_data);
        //

        recyclerView = findViewById(R.id.get_data_rv);
        // nearbyFacilitiesAdapter = new NearbyFacilitiesAdapter(NearbyFacilitiesActivity.this,dataNearbies);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(GetData.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        // retrofitServices = RetrofitFactory.getRetrofit().create(RetrofitServices.class);




        getDataInsert();
    }

    public void getDataInsert(){

        RetrofitInter retrofitInter = RetrofitUrl.getRetrofit().create(RetrofitInter.class);
        Call<GetPostResponData> getPostResponCall = retrofitInter.getDataInsert();//.getNearbyFacilities(portid);
        getPostResponCall.enqueue(new Callback<GetPostResponData>() {
            @Override
            public void onResponse(Call<GetPostResponData> call, Response<GetPostResponData> response) {


                List<Datum> kontakList = response.body().getData();//getListDataKontak();
                Log.d("Retrofit Get", "Jumlah data Kontak: " +
                        String.valueOf(kontakList.size()));
                adapterGetData = new AdapterGetData(GetData.this,kontakList);
                recyclerView.setAdapter(adapterGetData);



                // if (response.isSuccessful()){

                    //adapterGetData = new AdapterGetData(datumList, GetData.this);
                    //recyclerView.setAdapter(adapterGetData);





            }

            @Override
            public void onFailure(Call<GetPostResponData> call, Throwable t) {

            }
        });






    }



}
