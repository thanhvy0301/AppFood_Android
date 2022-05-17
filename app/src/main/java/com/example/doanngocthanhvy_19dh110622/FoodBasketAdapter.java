package com.example.doanngocthanhvy_19dh110622;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FoodBasketAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
//    public <E> FoodBasketAdapter(ArrayList<E> es) {
//    }
//
//    @NonNull
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        return null;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return 0;
//    }

    public class ViewHoderFoodBasket extends RecyclerView.ViewHolder{

        TextView tvFoodName,tvPriceFood,tvAmount,tvTotalPriceFood;

        public ViewHoderFoodBasket(@NonNull View itemView) {
            super(itemView);
            tvFoodName=itemView.findViewById(R.id.tvFoodName);
            tvPriceFood=itemView.findViewById(R.id.tvPriceFood);
            tvAmount=itemView.findViewById(R.id.tvAmount);
            tvTotalPriceFood=itemView.findViewById(R.id.tvTotalPriceFood);
        }
    }

    private List<FoodBasket> mFoodBasket;
    public FoodBasketAdapter (List<FoodBasket> foodBaskets)
    {
        mFoodBasket=foodBaskets;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.row_food_onbasket,parent,false);
        return new ViewHoderFoodBasket(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        FoodBasket foodBasket=mFoodBasket.get(position);
        ViewHoderFoodBasket viewHoderFoodBasket=(ViewHoderFoodBasket)holder;
        viewHoderFoodBasket.tvFoodName.setText(foodBasket.name);
        viewHoderFoodBasket.tvPriceFood.setText(foodBasket.price+" ");
        viewHoderFoodBasket.tvAmount.setText(foodBasket.quantity+" ");
        viewHoderFoodBasket.tvTotalPriceFood.setText(foodBasket.sum+" ");
    }

    @Override
    public int getItemCount() {
        return mFoodBasket.size();
    }
}