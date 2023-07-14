package sg.edu.rp.c346.id22013272.ndpsong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnInsert, btnShow;
    TextView tvTitle, tvSinger,tvYear,tvStar;
    EditText etTitle,etSinger, etYear,etStar;
    ArrayList<song> al;
    ListView lv;
    ArrayAdapter<song> aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnInsert=findViewById(R.id.buttonInsert);
        btnShow=findViewById(R.id.buttonSL);
        tvTitle=findViewById(R.id.textViewTitle);
        tvSinger=findViewById(R.id.textViewSing);
        tvYear=findViewById(R.id.textViewYear);
        tvStar=findViewById(R.id.textViewStar);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = etTitle.getText().toString();
                String data1 = etSinger.getText().toString();
                String data2 = etYear.getText().toString();
                DBHelper db = new DBHelper(MainActivity.this);
                song Song = new song();
                long inserted_id = db.insertNote(Song);

                if (inserted_id != -1) {
                    al.clear();
                    al.addAll(db.getAllSong());
                    aa.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this, "Insert successful",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ListView.class));
            }
        });
    }
}
