package com.wdtheprovider.inapppurchase.adapters;

import android.annotation.SuppressLint;
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

import java.util.List;

public class SubscriptionAdapter extends RecyclerView.Adapter<SubscriptionAdapter.ProductDetailsViewHolder>  {

    List<ProductDetails> productDetailsList;
    Context context;
    RecycleViewInterface recycleViewInterface;

    public SubscriptionAdapter(Context context, List<ProductDetails> productDetailsList, RecycleViewInterface recycleViewInterface) {
        this.productDetailsList = productDetailsList;
        this.context = context;
        this.recycleViewInterface = recycleViewInterface;
    }

    @NonNull
    @Override
    public ProductDetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sub_item,parent,false);
        return new ProductDetailsViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ProductDetailsViewHolder holder, int position) {
        ProductDetails currentItem = productDetailsList.get(position);
        List<ProductDetails.SubscriptionOfferDetails> subDetails = currentItem.getSubscriptionOfferDetails();
        assert subDetails != null;
        holder.type.setText("1 "+currentItem.getName());
        holder.duration.setText("/"+currentItem.getName());
        holder.price.setText(subDetails.get(0).getPricingPhases().getPricingPhaseList().get(0).getFormattedPrice());
    }

    @Override
    public int getItemCount() {
        return productDetailsList.size();
    }

    public class ProductDetailsViewHolder extends RecyclerView.ViewHolder{
        TextView duration;
        TextView price;
        TextView type;

        public ProductDetailsViewHolder(@NonNull View itemView) {
            super(itemView);
            price = itemView.findViewById(R.id.price);
            type = itemView.findViewById(R.id.type);
            duration = itemView.findViewById(R.id.duration);
            itemView.setOnClickListener(v -> recycleViewInterface.onItemClick(getAdapterPosition()));
        }
    }
}