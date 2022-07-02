package com.ace.services.one.capital;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.DecimalFormat;

public class RequestLoanActivity extends AppCompatActivity {

    SeekBar s_tenure, s_amount;
    TextView amount, tenure;
    Button proceed;
    TextView processingFee,gstAmount,disbursedAmount,emiAmount;
    int loanAmount,tenureMonths;
    double processing_Fee,gst_Applicable,amount_Disbursed,emi_Amount;
    //for rounding to two decimal places
    private static final DecimalFormat df = new DecimalFormat("0.00");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_loan);
        //link XML components
        s_tenure = findViewById(R.id.seekbar_tenure);
        s_amount = findViewById(R.id.seekbar_amount);
        amount = findViewById(R.id.txt_amount);
        tenure = findViewById(R.id.txt_time);
        proceed=findViewById(R.id.bt_proceed);
        processingFee=findViewById(R.id.processing_fee);
        gstAmount=findViewById(R.id.gst_applicable);
        disbursedAmount=findViewById(R.id.amount_disbursed);
        emiAmount=findViewById(R.id.emi_amount);
        //setting max values of seekbar
        s_amount.setMax(10);
        s_tenure.setMax(3);
        s_amount.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    if (progress >= 0 && progress <= s_amount.getMax()) {
                        String progressString = String.valueOf(progress * 10);
                        amount.setText("INR "+progressString+"0.00");
                        int temp=Integer.parseInt(progressString);
                        //calculating required fields
                        processing_Fee=Double.parseDouble(df.format(0.05*temp));
                        gst_Applicable=Double.parseDouble(df.format(0.18*temp));
                        amount_Disbursed=temp-(processing_Fee+gst_Applicable);
                        processingFee.setText("INR "+(processing_Fee));
                        gstAmount.setText("INR "+(gst_Applicable));
                        disbursedAmount.setText("INR "+(amount_Disbursed));
                        seekBar.setSecondaryProgress(progress);
                    }
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        s_tenure.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    if (progress >= 0 && progress <= s_tenure.getMax()) {
                        String progressString = String.valueOf(progress * 1);
                        tenure.setText(progressString+" Months");
                        seekBar.setSecondaryProgress(progress);
                    }
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //getting the current progress of both seekbar
                loanAmount=s_amount.getProgress()*10;
                tenureMonths=s_tenure.getProgress();
            }
        });

    }
}