package com.example.doanngocthanhvy_19dh110622;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

public class Store implements Serializable {
    int ImageStore;
    String NameStore;
    String AddressStore;
    String OpenHour;

    public Store(){}

    public Store(int imageStore, String nameStore, String addressStore, String openHour) {
        ImageStore = imageStore;
        NameStore = nameStore;
        AddressStore = addressStore;
        OpenHour = openHour;
    }

}
