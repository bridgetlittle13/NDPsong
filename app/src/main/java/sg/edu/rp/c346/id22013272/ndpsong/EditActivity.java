package sg.edu.rp.c346.id22013272.ndpsong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EditActivity extends AppCompatActivity {
    TextView tvID;
    EditText etContent;
    Button btnUpdate, btnDelete,btnCancel;
    song data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        //initialize the variables with UI here

        Intent i = getIntent();
        data = (song) i.getSerializableExtra("data");

        tvID.setText("ID: " + data.getId());
        etContent.setText(data.getSongContent());

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(EditActivity.this);
                data.setSongContent(etContent.getText().toString());
                db.updateNote(data);
                db.close();
                finish();

            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(EditActivity.this);
                db.deleteNote(data.getId());
                finish();

            }

        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(EditActivity.this);
                finish();
            }
        });
    }
}