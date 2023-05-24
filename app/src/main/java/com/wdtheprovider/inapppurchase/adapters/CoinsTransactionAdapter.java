package com.wdtheprovider.inapppurchase.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.billingclient.api.ProductDetails;
import com.wdtheprovider.inapppurchase.R;
import com.wdtheprovider.inapppurchase.interfaces.RecycleViewInterface;
import com.wdtheprovider.inapppurchase.models.ConsumableTransaction;

import java.util.List;

/**
 * File Created by Dingaan Letjane
 * 2023/05/13
 **/

public class CoinsTransactionAdapter extends RecyclerView.Adapter<CoinsTransactionAdapter.CoinsTransactionAdapterViewHolder> {

    List<ConsumableTransaction> transactions;
    Context context;
    RecycleViewInterface recycleViewInterface;

    public CoinsTransactionAdapter(Context context, List<ConsumableTransaction> transactions, RecycleViewInterface recycleViewInterface) {
        this.transactions = transactions;
        this.context = context;
        this.recycleViewInterface = recycleViewInterface;
    }


    @NonNull
    @Override
    public CoinsTransactionAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.transaction_item, parent, false);
        return new CoinsTransactionAdapter.CoinsTransactionAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CoinsTransactionAdapterViewHolder holder, int position) {
        ConsumableTransaction currentItem = transactions.get(position);
        holder.orderNumber.setText(String.format("Order Number: %s", currentItem.getOrderNumber()));
        holder.orderDate.setText(String.format("Order Date: %s", currentItem.getOrderDate()));
        holder.price.setText(String.format("Total Price: %s", currentItem.getPrice()));
        holder.item.setText(String.format("%s\nReward: %d", currentItem.getItem(), currentItem.getReward()));
        holder.qty.setText(String.format("Qty: %d", currentItem.getQty()));
        holder.purchasedTime.setText(String.format("Time: %s", currentItem.getPurchasedTime()));
    }

    @Override
    public int getItemCount() {
        return transactions.size();
    }

    public static class CoinsTransactionAdapterViewHolder extends RecyclerView.ViewHolder {

        TextView orderNumber;
        TextView orderDate;
        TextView purchasedTime;
        TextView price;
        TextView qty;
        TextView item;

        public CoinsTransactionAdapterViewHolder(@NonNull View itemView) {
            super(itemView);

            orderNumber = itemView.findViewById(R.id.txt_order_number);
            item = itemView.findViewById(R.id.txt_item);
            orderDate = itemView.findViewById(R.id.txt_order_date);
            purchasedTime = itemView.findViewById(R.id.txt_time);
            price = itemView.findViewById(R.id.txt_price);
            qty = itemView.findViewById(R.id.txt_qty);
        }
    }
}
