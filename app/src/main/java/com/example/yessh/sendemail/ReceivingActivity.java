package com.example.yessh.sendemail;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ReceivingActivity extends AppCompatActivity {
    TextView Name, Email, Phone;
    ImageView userImageView;
    String name, email, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiving);

        Name = (TextView) findViewById(R.id.textView_rname);
        Email = (TextView) findViewById(R.id.textView_remail);
        Phone = (TextView) findViewById(R.id.textView_rphone);

        Bundle bundle = this.getIntent().getExtras();
        name = bundle.getString("Name");
        email = bundle.getString("Email");
        phone = bundle.getString("Phone");

        Name.setText(name);
        Email.setText(email);
        Phone.setText(phone);

        userImageView = (ImageView) findViewById(R.id.imageView_user);
        String url = "http://pluspng.com/img-png/user-png-icon-checked-user-icon-512.png";

        Glide.with(this)
                .load(url)
                .into(userImageView);
    }
    public void process(View view){
        Intent intent=null, chooser=null;

        if (view.getId()==R.id.button_sendmail){
            intent = new Intent(Intent.ACTION_SEND);
            intent.setData(Uri.parse("mailto:"));
            String[] to={"yesel1601@hotmail.com",email.toString()};
            intent.putExtra(Intent.EXTRA_EMAIL,to);
            intent.putExtra(Intent.EXTRA_SUBJECT, "Hi, I´m Yess and this was sent from my new app");
            intent.putExtra(Intent.EXTRA_TEXT, "This is my first email message sent from my app"+'\n'+"Your name: "+name+'\n'+"Your phone number: "+phone);
            intent.setType("message/rfc822");
            chooser = Intent.createChooser(intent,"Send Email");
            startActivity(chooser);
        }
    }

}
