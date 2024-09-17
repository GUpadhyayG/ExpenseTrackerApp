package com.example.expensetracker;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ExpViewModel extends AndroidViewModel {

    private ExpenseRepo expenseRepo;
    private LiveData<List<Expense>> expenselist;

    public ExpViewModel(@NonNull Application application) {
        super(application);
        expenseRepo = new ExpenseRepo(application);
        expenselist=expenseRepo.getExpenseData();

    }
    public void insert(Expense expense)
    {
        expenseRepo.insertData(expense);
    }
    public void delete(Expense expense)
    {
        expenseRepo.insertData(expense);
    }
    public void update(Expense expense)
    {
        expenseRepo.insertData(expense);
    }

    public LiveData<List<Expense>> getExpenselist() {
        return expenselist;
    }
}
