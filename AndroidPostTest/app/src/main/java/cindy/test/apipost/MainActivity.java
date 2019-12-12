package cindy.test.apipost;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cindy.test.apipost.pojo.InsertPostRespon;
import cindy.test.apipost.retro.RetrofitInter;
import cindy.test.apipost.retro.RetrofitUrl;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public EditText nama_ins, email_ins, password_ins, data_ins;
    public Button post_ins;
    public  Button get_data_insert;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nama_ins=findViewById(R.id.ins_nama);
        email_ins=findViewById(R.id.ins_email);
        password_ins=findViewById(R.id.ins_password);
        data_ins=findViewById(R.id.ins_data);
        post_ins=findViewById(R.id.inst_btn);

        get_data_insert=findViewById(R.id.get_btn);



        post_ins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postInsert();

            }
        });

        get_data_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,GetData.class);

                startActivity(intent);
                finish();
            }
        });



    }

    public void postInsert(){
        String nama=nama_ins.getText().toString();
        String email=email_ins.getText().toString();
        String password=password_ins.getText().toString();
        String data=data_ins.getText().toString();

        RetrofitInter retrofitInter   = RetrofitUrl.getRetrofit().create(RetrofitInter.class);
        //User user = new User(name, email, password);


        Call<InsertPostRespon> userCall = retrofitInter.insertPost(nama,email,password,data);//.EmployeeRegister(name,email,password, employeeid,employeecomname);//.userSignUp(name, email, password);

        userCall.enqueue(new Callback<InsertPostRespon>() {
            @Override
            public void onResponse(@Nullable Call<InsertPostRespon> call, @Nullable Response<InsertPostRespon> response) {
                //hidepDialog();
                //onSignupSuccess();
                if (response.body() != null) {
                    Log.d("onResponse", "" + response.body().getStatus());//.getMessage());
                }


                if (response.body() != null) {
                    if(response.body().getStatus()=="ok") {
                       // Intent intent = new Intent(RegisterEmployee.this,UserProfile.class);
                        //startActivity(intent);

                        //finish();
                    }else {
                        Toast.makeText(getApplicationContext(), "" + response.body().getStatus(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<InsertPostRespon> call, Throwable t) {
                //hidepDialog();
                Log.d("onFailure", t.toString());
            }
        });



    }
}
