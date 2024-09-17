package com.example.expensetracker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class RVAdapter extends ListAdapter<Expense,RVAdapter.ViewHolder> {

    public RVAdapter()
    {
        super(CALLBACK);
    }

    private static final DiffUtil.ItemCallback<Expense> CALLBACK=new DiffUtil.ItemCallback<Expense>() {
        @Override
        public boolean areItemsTheSame(@NonNull Expense oldItem, @NonNull Expense newItem) {
            return oldItem.getId()== newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Expense oldItem, @NonNull Expense newItem) {
            return oldItem.getExpense().equals(newItem.getId())&& oldItem.getEarning().equals(newItem.getEarning());
        }
    }

    protected RVAdapter(@NonNull DiffUtil.ItemCallback<Expense> diffCallback) {
        super(diffCallback);
    }

    protected RVAdapter(@NonNull AsyncDifferConfig<Expense> config) {
        super(config);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.each_rv,parent,false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Expense expense=getItem(position);
        holder.binding.ExpenseRv.setText(Expense.getExpense());
        holder.binding.Earning.setText(Expense.getExpense());

    }
    public Expense getExpense(int position)
    {
        return getItem(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        EachRvBinding binding;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            binding=EachRvBinding.bind(itemView);
        }
    }
}
