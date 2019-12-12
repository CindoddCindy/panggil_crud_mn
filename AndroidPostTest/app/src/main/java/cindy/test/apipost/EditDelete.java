package cindy.test.apipost;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import cindy.test.apipost.adapter.AdapterGetData;
import cindy.test.apipost.pojo.Datum;
import cindy.test.apipost.pojo.DeleteInsertRespon;
import cindy.test.apipost.pojo.GetPostResponData;
import cindy.test.apipost.retro.RetrofitInter;
import cindy.test.apipost.retro.RetrofitUrl;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditDelete extends AppCompatActivity {

    public  TextView textView_nama, textView_email, textView_password, textView_data;
    public Button btn_hapus;
    public TextView textView_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_delete);
        textView_nama=findViewById(R.id.tv_nama);
        textView_email=findViewById(R.id.tv_email);
        textView_password=findViewById(R.id.tv_password);
        textView_data=findViewById(R.id.tv_data);

        textView_id=findViewById(R.id.tv_id_edt_dlt);

        btn_hapus=findViewById(R.id.btn_delete);

        btn_hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteItem();

            }
        });

        //final long id = Long.valueOf("id");

        textView_nama.setText("nama: "+getIntent().getStringExtra("nama"));
        textView_email.setText("email" + getIntent().getStringExtra("email"));
        textView_password.setText("password" + getIntent().getStringExtra("password"));
        textView_data.setText("data" + getIntent().getStringExtra("data"));
       // textView_id.setText(Long.valueOf(String.format("id%d", getIntent().getLongExtra("id"))));
        textView_id.setText(""+ getIntent().getLongExtra("id", 0));


        // Bundle bdl=getIntent().getExtras();



    }

    public void deleteItem(){
       // Long id = Long.valueOf(textView_id.getText().toString());


        RetrofitInter retrofitInter = RetrofitUrl.getRetrofit().create(RetrofitInter.class);
        Call<DeleteInsertRespon> getPostResponCall = retrofitInter.deteleInsert(Long.parseLong(textView_id.getText().toString()));//.getNearbyFacilities(portid);
        getPostResponCall.enqueue(new Callback<DeleteInsertRespon>() {
            @Override
            public void onResponse(Call<DeleteInsertRespon> call, Response<DeleteInsertRespon> response) {
                if (response.isSuccessful()){
                   DeleteInsertRespon deleteInsertRespon = response.body();
                   deleteInsertRespon.getStatus();
                }





            }

            @Override
            public void onFailure(Call<DeleteInsertRespon> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(EditDelete.this, "Jaringan Error!", Toast.LENGTH_SHORT).show();

            }
        });









    }
}
