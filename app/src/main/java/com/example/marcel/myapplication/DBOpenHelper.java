package com.example.marcel.myapplication;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBOpenHelper extends SQLiteOpenHelper {

    //Constants for db name and version
    private static final String DATABASE_NAME = "foods.db";
    private static final int DATABASE_VERSION = 1;

    //Constants for table and columns
    public static final String TABLE_FOODS = "foods";
    public static final String COMMENTS = "comment";
    public static final String PREFERRED_AMOUNT = "preferredAmount";
    public static final String CALORIES_PER_GRAM = "caloriesG";
    public static final String SODIUM_PER_GRAM = "sodiumG";
    public static final String POTASSIUM_PER_GRAM = "potassiumG";
    public static final String PROTEIN_PER_GRAM = "proteinG";
    public static final String FIBER_PER_GRAM = "fiberG";

    public static final String[] ALL_COLUMNS =
            {COMMENTS, PREFERRED_AMOUNT, CALORIES_PER_GRAM, SODIUM_PER_GRAM, POTASSIUM_PER_GRAM, PROTEIN_PER_GRAM, FIBER_PER_GRAM};

    //Create Table
    private static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_FOODS + " (" +
                    COMMENTS + " TEXT PRIMARY KEY, " +
                    PREFERRED_AMOUNT + " FLOAT, " +
                    CALORIES_PER_GRAM + " FLOAT, " +
                    SODIUM_PER_GRAM + " FLOAT, " +
                    POTASSIUM_PER_GRAM + " FLOAT, " +
                    PROTEIN_PER_GRAM + " FLOAT, " +
                    FIBER_PER_GRAM + " FLOAT, " +
                    ")";

    public DBOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_FOODS);
        onCreate(sqLiteDatabase);
    }
}