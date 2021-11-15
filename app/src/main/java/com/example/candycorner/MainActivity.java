package com.example.candycorner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = (ListView) findViewById(R.id.menuOptions);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (position == 0){
                    Toast.makeText(getApplicationContext(), "Receiving Stock", Toast.LENGTH_SHORT).show();
                }

                if (position == 1){
                    Toast.makeText(getApplicationContext(), "Ordering Stock", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}