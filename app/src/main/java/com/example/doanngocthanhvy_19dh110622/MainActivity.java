package com.example.doanngocthanhvy_19dh110622;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.navigation.NavigationView;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.auth.User;

public class MainActivity extends AppCompatActivity {
    NavController navController;
    AppBarConfiguration appBarConfiguration;
    NavigationView navigationView;
    DrawerLayout drawer;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;

    TextView textCartItemCount;
    int mCartItemCount = 0;
    //App app;
    Menu mMenu;
    boolean flag = true;
    //CartRepository cartRepository;
    FirebaseDatabase fDatabase;
    FirebaseAuth fAuth;

    TextView tvFullName, tvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fDatabase = FirebaseDatabase.getInstance();
        fAuth = FirebaseAuth.getInstance();

//        app = (App) getApplication();
//        cartRepository = new CartRepository(getApplication());
//
//        toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        drawer = findViewById(R.id.drawerLayout);
//        navigationView = findViewById(R.id.navView);
//
//        actionBarDrawerToggle = new ActionBarDrawerToggle(MainActivity.this,
//                drawer,
//                toolbar,
//                R.string.open,
//                R.string.close);
//
//        drawer.addDrawerListener(actionBarDrawerToggle);
//
//        appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.homeFragment, R.id.orderFragment, R.id.profileFragment)
//                .setDrawerLayout(drawer)
//                .build();
//
//        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        NavigationUI.setupActionBarWithNavController(this, navController,appBarConfiguration);
//        NavigationUI.setupWithNavController(navigationView, navController);
//        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
//            @Override
//            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
//                if (destination.getId() == R.id.profileFragment) {
//                    mMenu.findItem(R.id.mnuCart).setVisible(false);
//                } else if (mMenu != null) {
//                    mMenu.findItem(R.id.mnuCart).setVisible(true);
////                }
//            }
//        });
//
//        View view = navigationView.getHeaderView(0);
//        tvFullName = view.findViewById(R.id.tvFullName);
//        tvEmail = view.findViewById(R.id.tvEmail);
//
//        String userID = fAuth.getCurrentUser().getUid();
//
//        fDatabase.getReference().child("users").child(userID).get()
//                .addOnSuccessListener(new OnSuccessListener<DataSnapshot>() {
//                    @Override
//                    public void onSuccess(DataSnapshot dataSnapshot) {
//                        User user = dataSnapshot.getValue(User.class);
//                        user.setUserID(userID);
//                        tvFullName.setText(user.getFirstname() + " " + user.getLastname());
//                        tvEmail.setText(user.getEmail());
//
//                    }`
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
//                    }
//                });
//
//    }
//    @Override
//    public boolean onSupportNavigateUp() {
//        return NavigationUI.navigateUp(navController, appBarConfiguration)
//                || super.onSupportNavigateUp();
//    }
//
//    @Override
//    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
//        super.onPostCreate(savedInstanceState);
//        actionBarDrawerToggle.syncState();
//        }
    }
}