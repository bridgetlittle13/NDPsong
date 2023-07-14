package sg.edu.rp.c346.id22013272.ndpsong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Listview extends AppCompatActivity {

    Button btnShowFiveStar;
    ArrayAdapter aa;
    ArrayList<song> al;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        lv = findViewById(R.id.lv);
        al = new ArrayList<song>();
        aa = new ArrayAdapter<song>(this,
                android.R.layout.simple_list_item_1, al);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?>parent, View view, int
                    position, long identity) {
                song data = al.get(position);
                Intent i = new Intent(Listview.this,
                        EditActivity.class);
                i.putExtra("data", data);
                startActivity(i);
            }
        });
        btnShowFiveStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(Listview.this);
                // retrieve all 5 star songs from db and assign to arraylist
                al.clear();
                al = dbh.getAllSong();
                aa.notifyDataSetChanged();
            }
        });
    }
}