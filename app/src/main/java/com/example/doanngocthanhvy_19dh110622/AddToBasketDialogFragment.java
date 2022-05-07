package com.example.doanngocthanhvy_19dh110622;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddToBasketDialogFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddToBasketDialogFragment extends DialogFragment implements
        View.OnClickListener {
    TextView tvName, tvPrice, tvQuantity;
    Button btnBuy;
    ImageView btnSubtract, btnAdd;
    App app;
    FoodBasket food;
    CarRepository carRepository;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AddToBasketDialogFragment() {

        // Required empty public constructor
    }
    @SuppressLint("ValidFragment")
    public AddToBasketDialogFragment(FoodBasket food) {
        this.food = food;
        Log.d("ABC", food.toString());
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddToBasketDialogFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddToBasketDialogFragment newInstance(String param1, String param2) {
        AddToBasketDialogFragment fragment = new AddToBasketDialogFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_to_basket_dialog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        carRepository = new CarRepository(getActivity().getApplication());
        tvName = view.findViewById(R.id.tvName);
        tvPrice = view.findViewById(R.id.tvPrice);
        tvQuantity = view.findViewById(R.id.tvQuantity);
        btnAdd = view.findViewById(R.id.btnAdd);
        btnSubtract = view.findViewById(R.id.btnSubtract);
        btnBuy = view.findViewById(R.id.btnLogout);
        btnBuy.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnSubtract.setOnClickListener(this);
        tvName.setText(food.getName());
        tvPrice.setText(food.getPrice() + " VND");
        updateStats();
//        app = (App) getActivity().getApplication();

    }

    @Override
    public void onResume() {
        getDialog().getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        getDialog().getWindow().setGravity(Gravity.BOTTOM);
        getDialog().setCancelable(true);
        super.onResume();
    }
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btnSubtract:
                food.decrease();
                updateStats();
                break;
            case R.id.btnAdd:
                food.increase();
                updateStats();
                break;
            case R.id.btnLogout:
                if (food.quantity > 0) {
                    app.basket.addFood(food);
                }
                ((RestaurantDetailActivity) getActivity()).updateBasket();
                carRepository.insert(new Cart(food.getFoodKey(), food.getName(),
                        food.getPrice(), food.getImage(),food.getRate(),food.getResKey(),
                        food.getQuantity(), food.getSum()));
                getDialog().dismiss();
                break;
        }
    }
    private void updateStats() {
        if (food.getQuantity() > 0) {
            tvQuantity.setText(String.valueOf(food.getQuantity()));
            String add = getResources().getString(R.string.add_to_basket);
            btnBuy.setText(add + " : " + food.getSum()+ " VND");
        } else {
            btnBuy.setText(getResources().getString(R.string.back_to_menu));
        }
    }

}