package uk.ac.tees.p4072709.yourreview;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "reviews.db";
    private static final String REVIEWS_TABLE_NAME = "reviews";
    private static final String ARTISTS_TABLE_NAME = "artists";
    private static final String COL_ID = "id";
    private static final String COL_NAME = "name";
    private static final String COL_REVIEW = "review";
    private static final String COL_USER = "user";
    private static final String COL_LOCATION = "location";



    private static String CREATE_REVIEWS_TABLE = "CREATE TABLE "
            + REVIEWS_TABLE_NAME
            + "(" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COL_NAME + " TEXT, "
            + COL_REVIEW + " TEXT, "
            + COL_USER + " TEXT, "
            + COL_LOCATION + " TEXT" + ");";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    /* creates tables */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_REVIEWS_TABLE);
        Log.d("Database", "Database Created");
    }

    public String getDatabaseName() {
        return DATABASE_NAME;
    }

    /* drops the tables if already built */
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + REVIEWS_TABLE_NAME);
        onCreate(db);
    }

    /* add new review to the database */
    void addReview(Review review) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_NAME, review.getName());
        values.put(COL_LOCATION, review.getLocation());
        values.put(COL_NAME, review.getName());
        values.put(COL_USER, review.getUser());

        db.insert(REVIEWS_TABLE_NAME, null, values);
        db.close();

        Log.d("Database", "NEW ENTRY ADDED");
    }

    /* get all the reviews */
    public List<Review> getAllReviews() {
        List<Review> list = new ArrayList<Review>();
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM " + REVIEWS_TABLE_NAME;
        Cursor cursor = db.rawQuery(selectQuery, null);

          if (cursor.moveToFirst()) {
              int idIndex = cursor.getColumnIndex(COL_ID);
              int nameIndex = cursor.getColumnIndex(COL_NAME);
              int locationIndex = cursor.getColumnIndex(COL_LOCATION);
              int reviewIndex = cursor.getColumnIndex(COL_REVIEW);
              int userIndex = cursor.getColumnIndex(COL_USER);


              do {
                  Review review = new Review(
                          cursor.getString(nameIndex),
                          cursor.getString(locationIndex),
                          cursor.getString(reviewIndex),
                          cursor.getString(userIndex),
                          cursor.getInt(idIndex)
                  );

                  list.add(review);
              } while (cursor.moveToNext());
          }

        return list;
    }

    /* delete review */
    public void deleteReview(Review review) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(REVIEWS_TABLE_NAME, COL_ID + "=?", new String[]{String.valueOf(review.getId())});
        db.close();
    }


    /* get all the reviews */
    public int getReviewCount() {
        String countQuery = "SELECT * FROM " + REVIEWS_TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();
    }


}
