package com.ace.services.one.capital;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    DatabaseReference reference;
    String link;
    ImageView imgAdvertisement;
    Button payNow;
    TextView profile,credit,cashbook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //hide status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        //initialize reference to database
        reference= FirebaseDatabase.getInstance().getReference("advertisement");
        imgAdvertisement=findViewById(R.id.imgAdv);
        payNow=findViewById(R.id.pay_now);
        profile=findViewById(R.id.profile);
        credit=findViewById(R.id.credit);
        cashbook=findViewById(R.id.passbook);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //if snapshot not exists,create the node else load the image
                if(!snapshot.exists()){
                    reference.setValue("https://i.picsum.photos/id/100/2500/1656.jpg?hmac=gWyN-7ZB32rkAjMhKXQgdHOIBRHyTSgzuOK6U0vXb1w");
                }else{
                    //Access link from database
                    link=snapshot.getValue().toString();
                    //load image url using picasso
                    Picasso.get().load(link).placeholder(R.drawable.dummyimage).into(imgAdvertisement);
                    imgAdvertisement.setClipToOutline(true);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}