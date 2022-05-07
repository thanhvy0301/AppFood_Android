package com.example.doanngocthanhvy_19dh110622;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class    RestaurantDetailActivity extends AppCompatActivity implements
        FoodAdapter.OnFoodItemClickListener, View.OnClickListener {

    TextView tvName, tvAddress, tvOpenHours,tvTotalPrices, tvTotalItems;
    ImageView ivCover;
    View layoutViewBasket;
    RecyclerView rvFoods;
    FoodAdapter foodAdapter;
    Restaurant restaurant;
    Food food;
    ArrayList<Food> foods;
    public App app;

    CarRepository cartRepository;
    FirebaseDatabase fDatabase;
    DatabaseReference dRestaurant;
    FirebaseStorage fStorage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_detail);
        foods = new ArrayList<>();
//        app = (App) getApplication();
//        cartRepository = new CarRepository(getApplication());

        tvName = findViewById(R.id.tvName);
        tvAddress = findViewById(R.id.tvAddress);
        tvOpenHours = findViewById(R.id.tvOpenHours);
        ivCover = findViewById(R.id.ivCover);
        rvFoods = findViewById(R.id.rvFoods);

        foodAdapter = new FoodAdapter(foods, this,1);
        rvFoods.setAdapter(foodAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvFoods.setLayoutManager(layoutManager);
        rvFoods.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        fDatabase = FirebaseDatabase.getInstance();
        fStorage = FirebaseStorage.getInstance();

        Intent intent = getIntent();
        food = (Food) intent.getSerializableExtra("food");
        if(food != null){
            onFoodItemClick(food);
            dRestaurant = fDatabase.getReference();
            Query query = dRestaurant.child("restaurants").child(food.getResKey());
            query.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    restaurant = snapshot.getValue(Restaurant.class);
                    foods.addAll(restaurant.getMenu());
                    foodAdapter.notifyDataSetChanged();
                    tvName.setText(restaurant.name);
                    tvAddress.setText(restaurant.address);
                    tvOpenHours.setText(restaurant.getOpenHours());
                    StorageReference profileRef =
                            fStorage.getReference().child("restaurants/covers"+ restaurant.getCover());
                    profileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            Picasso.get().load(uri).into(ivCover);
                        }
                    });
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });
        }else {
            restaurant = (Restaurant) intent.getSerializableExtra("restaurant");
            //Toast.makeText(this, restaurant.resKey, Toast.LENGTH_SHORT).show();
            foods.addAll(restaurant.getMenu());
            foodAdapter.notifyDataSetChanged();
            tvName.setText(restaurant.getName());
            tvAddress.setText(restaurant.getAddress());
            tvOpenHours.setText(restaurant.getOpenHours());
            Log.d("IJK", restaurant.getCover());
            StorageReference profileRef = fStorage.getReference().child("restaurants/covers/"+ restaurant.getCover());
            profileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {
                    Picasso.get().load(uri).into(ivCover);
                }
            });
        }
        layoutViewBasket = findViewById(R.id.layoutViewBasket);
        layoutViewBasket.setOnClickListener(this);

        tvTotalPrices = findViewById(R.id.tvTotalPrices);
        tvTotalItems = findViewById(R.id.tvTotalItems);

//        app.basket = new Basket();
    
    }
    @Override
    public void onFoodItemClick(Food food) {


        FoodBasket foodBasket = app.basket.getFood(food.getFoodKey());
        if (foodBasket == null)
            foodBasket = new FoodBasket(food, 1, food.getPrice());

        AddToBasketDialogFragment dialog = new AddToBasketDialogFragment(foodBasket);
        dialog.show(getSupportFragmentManager(), "add_to_basket_dialog");
    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.layoutViewBasket) {
            BasketDialogFragment dialog = new BasketDialogFragment(app.basket);
            dialog.show(getSupportFragmentManager(), "basket_dialog");
        }
    }
    //@SuppressLint("SetTextI18n")
    public void updateBasket() {
        app.basket.calculateBasket();
        tvTotalPrices.setText(app.basket.getTotalPrice());
        tvTotalItems.setText(app.basket.getTotalItem() + "");
    }
}
