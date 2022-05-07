package com.example.doanngocthanhvy_19dh110622;

import android.app.Application;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class CarRepository {
    CartDao cartDao;
    List<Cart> carts;
    public CarRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        cartDao = db.cartDao();
    }
    public int getCountCart() throws ExecutionException, InterruptedException {
        Future<Integer> data = AppDatabase.databaseWriteExecutor.submit(() -> {
            int count = cartDao.getAll().size();
            return count;
        });
        return data.get();
    }
    public void insert(Cart cart) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            cartDao.insertCart(cart);
        });
    }
    public void update(Cart cart) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            cartDao.updateCart(cart);
        });
    }
    public void delete(Cart cart) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            cartDao.deleteCart(cart);
        });
    }
    public void deleteAll(){
        AppDatabase.databaseWriteExecutor.execute(() -> {
            cartDao.delete();
        });
    }
    public List<Cart> getAllCarts() throws ExecutionException, InterruptedException
    {
        Future<List<Cart>> data = AppDatabase.databaseWriteExecutor.submit(() ->
        {
            List<Cart> dataCart = cartDao.getAll();
            return dataCart;
        });
        return data.get();
    }
}

