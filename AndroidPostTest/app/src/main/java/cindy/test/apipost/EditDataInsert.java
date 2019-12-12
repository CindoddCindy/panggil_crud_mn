package cindy.test.apipost;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.renderscript.Sampler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cindy.test.apipost.pojo.DeleteInsertRespon;
import cindy.test.apipost.pojo.EditRespon;
import cindy.test.apipost.retro.RetrofitInter;
import cindy.test.apipost.retro.RetrofitUrl;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditDataInsert extends AppCompatActivity{

    public EditText  editText_id, editText_edt_nama, editText_edt_email, editText_edt_password, editText_edt_data;
    public Button button_edit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data_insert);
        editText_edt_nama=findViewById(R.id.et_edit_nama);
        editText_edt_email=findViewById(R.id.et_edit_email);
        editText_edt_password=findViewById(R.id.et_edit_password);
        editText_edt_data=findViewById(R.id.et_edit_data);
        editText_id=findViewById(R.id.et_edit_id);


        button_edit=findViewById(R.id.edit_btn);
        button_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setEdit();

            }
        });
        if(getIntent().getExtras() != null){
            editText_edt_nama.setText(" "+getIntent().getStringExtra("name"));
            editText_edt_email.setText("" + getIntent().getStringExtra("email"));
            editText_edt_password.setText("" + getIntent().getStringExtra("password"));
            editText_edt_data.setText("" + getIntent().getStringExtra("data"));
            // textView_id.setText(Long.valueOf(String.format("id%d", getIntent().getLongExtra("id"))));
            editText_id.setText(""+ getIntent().getLongExtra("id", 0));


        }




    }



public void setEdit(){

        long id = Long.parseLong(editText_id.getText().toString());
        String nama = editText_edt_nama.getText().toString();
        String email= editText_edt_email.getText().toString();
        String pass = editText_edt_password.getText().toString();
        String data= editText_edt_data.getText().toString();

    RetrofitInter retrofitInter = RetrofitUrl.getRetrofit().create(RetrofitInter.class);
    Call<EditRespon> call = retrofitInter.editDataInsert(id,nama,email,pass,data);//.ubah(npm, nama, kelas, sesi);
    call.enqueue(new Callback<EditRespon>() {
        @Override
        public void onResponse(Call<EditRespon> call, Response<EditRespon> response) {

                //EditRespon editRespon = response.body();
                //editRespon.getStatus();


            if (response.isSuccessful()) {
                Log.d("onResponse", "" + response.body().getStatus());
            }

        }

        @Override
        public void onFailure(Call<EditRespon> call, Throwable t) {
            t.printStackTrace();
            //progress.dismiss();
            Toast.makeText(EditDataInsert.this, "Jaringan Error!", Toast.LENGTH_SHORT).show();
        }
    });











}




}



