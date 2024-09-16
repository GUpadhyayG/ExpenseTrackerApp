package com.example.expensetracker;

import static com.example.expensetracker.ExpenseData.expenseDao;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ExpenseRepo {

    private ExpenseDao expenseDao;
    private LiveData <List<Expense>>ExpenseList;

    public ExpenseRepo (Application application)
    {
         ExpenseData expenseData=ExpenseData.getInstance(application);

         expenseDao= expenseDao();

         ExpenseList=expenseDao.getAllData();
    }

    public void insertData(Expense expense)
    {
       new InsertExpense(expenseDao).execute(expense);
    }
    public void updateData(Expense expense)
    {
        new UpdateExpense(expenseDao).execute(expense);
    }

    public void deleteData(Expense expense)
    {
        new DeleteExpense(expenseDao).execute(expense);
    }

    public LiveData<List<Expense>> getExpenseData() {
        return ExpenseList;
    }

    private static class InsertExpense extends AsyncTask<Expense,Void,Void>
    {
        private ExpenseDao expenseDao;

        public InsertExpense(ExpenseDao expenseDao) {
            this.expenseDao = expenseDao;
        }

        @Override
        protected Void doInBackground(Expense... expenses) {

            ExpenseDao.insert(expenses[0]);
            return null;
        }
    }
    private static class DeleteExpense extends AsyncTask<Expense,Void,Void>
    {
        private ExpenseDao expenseDao;

        public DeleteExpense(ExpenseDao expenseDao) {
            this.expenseDao = expenseDao;
        }

        @Override
        protected Void doInBackground(Expense... expenses) {

            ExpenseDao.insert(expenses[0]);
            return null;
        }
    }

    private static class UpdateExpense extends AsyncTask<Expense,Void,Void>
    {
        private ExpenseDao expenseDao;

        public UpdateExpense(ExpenseDao expenseDao) {
            this.expenseDao = expenseDao;
        }

        @Override
        protected Void doInBackground(Expense... expenses) {

            ExpenseDao.insert(expenses[0]);
            return null;
        }
    }
}
