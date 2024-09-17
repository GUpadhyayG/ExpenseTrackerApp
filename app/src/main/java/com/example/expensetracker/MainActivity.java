package com.example.expensetracker;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.example.expensetracker.databinding.ActivityMainBinding;

import kotlinx.coroutines.Delay;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    private ExpViewModel expViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding=ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        expViewModel=new ViewModelProvider(this,ViewModelProvider.
                AndroidViewModelFactory.getInstance(this.getApplication())).get(ExpViewModel.class);
        binding.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(MainActivity.this,DataInsertActivity.class);
                startActivityForResult(intent,1);
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1)
        {
            String Expense=data.getStringExtra("Expense");
            String Earning=data.getStringExtra("Earning");
            String MainBalance=data.getStringExtra("Balance");
            Expense expense=new Expense(Expense,Earning,MainBalance);
            expViewModel.insert(expense);

            Toast.makeText(this,"Expenses added",Toast.LENGTH_SHORT).show();

        }
    }
}