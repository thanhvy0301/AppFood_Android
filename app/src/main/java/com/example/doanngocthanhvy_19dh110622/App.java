package com.example.doanngocthanhvy_19dh110622;

import android.app.Application;

import java.util.ArrayList;

class App extends Application {



    public static Basket basket;

    public static Basket getBasket() {
        return basket;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (basket==null)
            basket=new Basket();
    }
    //    public static void setBasket(ArrayList<FoodBasket> list) {
//        if (basket==null)
//        {
//            basket=new Basket();
//        }
//        for (FoodBasket foodBasket:list) {
//            basket.foods.put(foodBasket.foodKey,foodBasket);
//        }
//    }

    public static void listtoBasket(ArrayList<FoodBasket> list)
    {
        for (FoodBasket foodBasket:list  ) {
            basket.foods.put(foodBasket.foodKey,foodBasket);
        }

    }


}
