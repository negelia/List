package com.example.list;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> toView = new ArrayList();
    String values;
    String fin="";

    String[] dev = {"Планшеты", "Компьютеры", "Телефоны", "Ноутбуки"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_multiple_choice, dev
        );
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String itemValue = (String) listView.getItemAtPosition(position);
                values = ((TextView) view).getText().toString();
                if(listView.isItemChecked(position))
                { toView.add(values); }
                else
                if(!listView.isItemChecked(position))
                {
                    for(int i =0; i<toView.size();i++)
                    {
                        if(toView.get(i)==values)
                        {
                            toView.remove(i);
                        }
                    }
                }
            }
        });
    }

    public void OK(View view) {
        fin="";
        for (String el : toView) {

            fin += el + "; ";
        }
        toView.clear();
        Toast toast = Toast.makeText(getApplicationContext(), fin, Toast.LENGTH_SHORT);
        toast.show();
    }
}