package com.example.pc.xumuapp.newAdded;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pc.xumuapp.R;

public class adduserActivity extends AppCompatActivity {

    ImageView back_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adduser_layout);

        back_btn = (ImageView) findViewById(R.id.iv_back);
        TextView title = (TextView)findViewById(R.id.nav_title);


        title.setText("");
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
