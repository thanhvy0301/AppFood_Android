package com.example.doanngocthanhvy_19dh110622;

import android.app.Application;

class App extends Application {

    private String myState;
    public String getState(){
        return myState;
    }
    public void setState(String s){
        myState = s;
    }
    public static Basket basket=new Basket();
    public void setBasket(Basket basket) {
        if(basket ==null){
            basket = new Basket();
        }
        App.basket = basket;
    }
    private Basket basket(){
        return this.basket();
    }

}
