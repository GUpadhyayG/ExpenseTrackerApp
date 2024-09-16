package com.example.expensetracker;


import android.content.Context;
import android.provider.ContactsContract;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = ContactsContract.CommonDataKinds.Note.class,version = 1)
public abstract class ExpenseData extends RoomDatabase {


   private static ExpenseData instance;

    public static ExpenseDao expenseDao() {
        return null;
    }

    public static synchronized ExpenseData getInstance(Context context)
   {

       if(instance==null)
       {
           instance= Room.databaseBuilder(context.getApplicationContext(), ExpenseData.class,"Expense database")
                   .fallbackToDestructiveMigration().build();
       }

       return instance;
   }



}
