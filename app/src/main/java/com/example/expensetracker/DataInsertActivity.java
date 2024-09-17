 package com.example.expensetracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.expensetracker.databinding.ActivityDataInsertBinding;

 public class DataInsertActivity extends AppCompatActivity {

    ActivityDataInsertBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding=ActivityDataInsertBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent();
                intent.putExtra("Expense",binding.et1.getText().toString());
                intent.putExtra("Earning",binding.et2.getText().toString());
                intent.putExtra("MainBalance",binding.txt1.getText().toString());
                setResult(RESULT_OK,intent);
                finish();
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
}