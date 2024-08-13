package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ObjectListActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<String> objectNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_list);

        listView = findViewById(R.id.object_list_view);
        objectNames = new ArrayList<>();

        // Read object names from the text file
        readObjectNamesFromFile();

        // Set up the list view with the object names
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, objectNames);
        listView.setAdapter(adapter);

        // Handle click events on list items
        listView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedItem = objectNames.get(position);

            // Pass the selected item name to the ObjectDetectionActivity
            Intent intent = new Intent(ObjectListActivity.this, ObjectDetectionActivity.class);
            intent.putExtra("selectedItem", selectedItem);
            startActivity(intent);
        });
    }

    private void readObjectNamesFromFile() {
        try {
            InputStream inputStream = getResources().openRawResource(R.raw.object_names);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                objectNames.add(line);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}