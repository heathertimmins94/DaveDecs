package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editTextName;
    EditText editTextHeight;
    EditText editTextLength;
    Button buttonSubmit;
    ListView listViewWalls;
    TextView textViewArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Wall> walls = new ArrayList<Wall>();

        //Links the array to the list view
        ArrayAdapter<Wall> adapter = new ArrayAdapter<Wall>
                (this, android.R.layout.simple_list_item_1, walls);

        editTextName = findViewById(R.id.editText_name);
        editTextHeight = findViewById(R.id.editText_height);
        editTextLength = findViewById(R.id.editText_length);
        buttonSubmit = findViewById(R.id.button_submit);
        textViewArea = findViewById(R.id.textView_area);
        listViewWalls = findViewById(R.id.listView_walls);
        listViewWalls.setAdapter(adapter);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editTextName.getText().toString();
                double length = Double.valueOf(editTextLength.getText().toString());
                double height = Double.valueOf(editTextHeight.getText().toString());

                Wall myWall = new Wall(name, length, height);
                walls.add(myWall);
                adapter.notifyDataSetChanged();

                Double area = 0.0;
                for (Wall w : walls) {
                    area = area + w.Area();
                }
                textViewArea.setText("Total Area = " + area);
            }
        });

    }
}