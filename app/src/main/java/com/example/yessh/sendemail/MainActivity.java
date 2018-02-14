package com.example.yessh.sendemail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ShareActionProvider;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {
    EditText Name,Email,Phone;
    Button Send;
    ImageView usImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText)findViewById(R.id.editText_name);
        Email = (EditText)findViewById(R.id.editText_email);
        Phone = (EditText)findViewById(R.id.editText_phone);
        Send = (Button)findViewById(R.id.button_send);

        Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SendData();
            }
        });

        usImageView = (ImageView) findViewById(R.id.imageView_user);
        String url = "http://3.bp.blogspot.com/-GRRh9UHmCOU/UQ7LrFQDXeI/AAAAAAAAFcM/SOzsZ3RvzIA/s320/Tapestry_detail+3%252C0078.JPG";

        Glide.with(this)
                    .load(url)
                    .into(usImageView);

    }
    private void SendData(){
        String name,email,phone;
        name = Name.getText().toString();
        email = Email.getText().toString();
        phone = Phone.getText().toString();
        Intent intent = new Intent(MainActivity.this, ReceivingActivity.class);
        intent.putExtra("Name",name);
        intent.putExtra("Email",email);
        intent.putExtra("Phone",phone);
        startActivity(intent);
    }

}
