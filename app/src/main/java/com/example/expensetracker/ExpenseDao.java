package com.example.expensetracker;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ExpenseDao {

    @Insert
    public static void insert(Expense expense);
    @Update
    public void update(Expense expense);

    @Delete
    public void delete(Expense expense);
    @Query("SELECT * FROM my_expenses")
    public LiveData<List<Expense>> getAllData();

}
