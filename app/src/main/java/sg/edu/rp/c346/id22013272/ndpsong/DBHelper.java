package sg.edu.rp.c346.id22013272.ndpsong;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "song.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_SONG = "song";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_SONG_CONTENT = "song_content";
    private static final String COLUMN_TITLE = "song title";
    private static final String COLUMN_NAME = "singer's name";
    private static final String COLUMN_YEAR = "Year";
    private static final String COLUMN_STAR= "Star";
    public DBHelper( Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createSongTableSql = "CREATE TABLE " + TABLE_SONG + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_TITLE + " TEXT,"+ COLUMN_NAME+" TEXT,"+ COLUMN_YEAR + " INTEGER, "+ COLUMN_STAR +" INTEGER) ";
        db.execSQL(createSongTableSql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("ALTER TABLE " + TABLE_SONG + " ADD COLUMN  module_name TEXT ");
        onCreate(db);

    }
    public long insertNote(String song) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_SONG_CONTENT,song );
        long result = db.insert(TABLE_SONG, null, values);
        db.close();
        Log.d("SQL Insert", "ID:" + result); //id returned, shouldn’t be -1
        return result;
    }
    public int updateNote(song data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_SONG_CONTENT, data.getSongContent());
        String condition = COLUMN_ID + "= ?";
        String[] args = {String.valueOf(data.getId())};
        int result = db.update(TABLE_SONG, values, condition, args);
        db.close();
        return result;
    }
    public int deleteNote(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        String condition = COLUMN_ID + "= ?";
        String[] args = {String.valueOf(id)};
        int result = db.delete(TABLE_SONG, condition, args);
        db.close();
        return result;
    }
    public ArrayList<song> getAllSong() {
        ArrayList<song> notes = new ArrayList<song>();

        SQLiteDatabase db = this.getReadableDatabase();

        String[] columns= {COLUMN_ID, COLUMN_TITLE, COLUMN_NAME, COLUMN_YEAR, COLUMN_STAR};

        Cursor cursor = db.query(TABLE_SONG, columns, null, null,
                null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String title = cursor.getString(1);
                String name= cursor.getString(2);
                int year= cursor.getInt(3);
                int star= cursor.getInt(4);
                song song = new song(id,title,name,year,star);
                notes.add(song);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return notes;
    }
    public ArrayList<song> getAll5StarSongs() {


    }
}
