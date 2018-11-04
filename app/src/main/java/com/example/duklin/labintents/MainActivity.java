package com.example.duklin.labintents;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnExplicit, btnImplicit, btnSendMsg;
    private TextView textView;
    private static final int EXPLICIT_INTENT_CODE = 1000;
    public static final String EXPLICIT_INTENT_TEXT_KEY = "text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        btnExplicit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ExplicitActivity.class);
                startActivityForResult(intent, MainActivity.EXPLICIT_INTENT_CODE);
            }
        });
        btnImplicit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("mk.ukim.finki.mpip.IMPLICIT_ACTION");
                startActivity(intent);
            }
        });
        btnSendMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/*");
                intent.putExtra(Intent.EXTRA_SUBJECT, "MPiP Send Title");
                intent.putExtra(Intent.EXTRA_TEXT, "Content send from MainActivity");
                startActivity(Intent.createChooser(intent, "Send"));
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == MainActivity.EXPLICIT_INTENT_CODE && resultCode == Activity.RESULT_OK){
            String text = data.getStringExtra(MainActivity.EXPLICIT_INTENT_TEXT_KEY);
            textView.setText(text);
            return;
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    private void initializeViews(){
        textView = (TextView) findViewById(R.id.text_view);
        btnExplicit = (Button) findViewById(R.id.btn_explicit_intent);
        btnImplicit = (Button) findViewById(R.id.btn_implicit_intent);
        btnSendMsg = (Button) findViewById(R.id.btn_send_message);
    }


}
