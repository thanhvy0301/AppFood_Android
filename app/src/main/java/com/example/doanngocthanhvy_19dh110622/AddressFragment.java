package com.example.doanngocthanhvy_19dh110622;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.location.Location;
import android.location.LocationListener;

import com.google.android.material.textfield.TextInputEditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddressFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddressFragment extends Fragment {

    TextInputEditText tvAddress, tvMobile;
    Button btnNext;
    NavController navController;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AddressFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddressFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddressFragment newInstance(String param1, String param2) {
        AddressFragment fragment = new AddressFragment();
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
        return inflater.inflate(R.layout.fragment_address, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @NonNull Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);
        tvAddress = view.findViewById(R.id.tvAddress);
        tvMobile = view.findViewById(R.id.tvMobile);
        btnNext = view.findViewById(R.id.btnNext);
        btnNext.setOnClickListener(v -> {
//            LatLng latLng = LocationServiceTask.getLatLngFromAddress(getContext(), tvAddress.getText().toString());
            Bundle bundle = new Bundle();
            bundle.putString("address", tvAddress.getText().toString());
//            bundle.putDouble("latitude", latLng.latitude);
//            bundle.putDouble("longitude", latLng.longitude);
            bundle.putString("mobile", tvMobile.getText().toString());
            bundle.putString("firstname", getArguments().getString("firstname"));
            bundle.putString("lastname", getArguments().getString("lastname"));

            navController.navigate(R.id.action_addressFragment_to_usernamePasswordFragment, bundle);
        });

    }

//    @Override
//    public void onResume() {
//        super.onResume();
//        if (LocationServiceTask.isLocationServiceEnabled(getActivity())) {
//            if (Permis.isLocationServiceAllowed(getActivity()))
//                getLastLocation(getActivity());
//            else
//                PermissionTask.requestLocationServicePermissions(getActivity());
//        } else {
//            LocationServiceTask.displayEnableLocationServiceDialog(getActivity());
//        }
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        if (requestCode == PermissionTask.LOCATION_SERVICE_REQUEST_CODE && grantResults.length == 2 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//            getLastLocation(getActivity());
//        }
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//    }
//
//    public void getLastLocation(Context context) {
//
//    }
}