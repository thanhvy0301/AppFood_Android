package com.example.doanngocthanhvy_19dh110622;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public abstract class CartDao {
    @Query("SELECT * FROM Cart")
    public abstract List<Cart> getAll();
    @Insert
    public abstract void insertAll(Cart... carts);
    @Insert
    public abstract void insertCart(Cart cart);
    @Delete
    public abstract void deleteCart(Cart cart);
    @Update
    public abstract void updateCart(Cart cart);
    @Delete
    public abstract void deleteMultiCart(Cart... cart);
    @Query("DELETE FROM Cart")
    public abstract void delete();
}
