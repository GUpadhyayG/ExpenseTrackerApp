package com.example.expensetracker;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.intellij.lang.annotations.PrintFormat;

 @Entity (tableName = "my_expenses")
public class Expense {

    private String expense;
    private String earning;
    private String AvailableBalance;



    @PrimaryKey(autoGenerate = true)

    private int id;

    public int getId() {
        return id;
    }

    public Expense(String expense, String earning, String availableBalance) {
        this.expense = expense;
        this.earning = earning;
        AvailableBalance = availableBalance;
    }

    public String getExpense() {
        return expense;
    }

    public void setExpense(String expense) {
        this.expense = expense;
    }

    public String getEarning() {
        return earning;
    }



    public void setEarning(String earning) {
        this.earning = earning;
    }
    public String getAvailableBalance() {
        return AvailableBalance;
    }

    public void setAvailableBalance(String availableBalance) {
        AvailableBalance = availableBalance;
    }

}
