package edu.illinois.cs465.myquizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import edu.illinois.cs465.myquizapp.pojo.Flight;

public class FlightKeeperMainActivity extends AppCompatActivity {

    public static Map<String, Set<Flight>> collections = Database.collections;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flightkeeper_main);

        List<String> collectionNames = new ArrayList<>();
        for (Map.Entry entry : this.collections.entrySet()) {
            collectionNames.add(entry.getKey().toString());
        }

        ListView listView = (ListView) findViewById(R.id.collections);
        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.flightkeeper_main_card, R.id.collection_name, collectionNames);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String collectionName = listView.getItemAtPosition(position).toString();
                Intent detailView = new Intent(getApplicationContext(), FlightKeeperDetailActivity.class);
                detailView.putExtra("collectionName", collectionName);
                startActivity(detailView);
            }
        });
    }

}
