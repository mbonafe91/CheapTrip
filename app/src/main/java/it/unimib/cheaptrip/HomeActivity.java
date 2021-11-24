package it.unimib.cheaptrip;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent intent = getIntent();

        //Riferimento al Container
        NavHostFragment navHostFragment =(NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);
        //Riferimento che controlla la navigazione
        NavController navController = navHostFragment.getNavController();

        //Riferimento alla Botton navigation view
        BottomNavigationView bottomNavigationView = findViewById(R.id.botton_navigation_home);

        NavigationUI.setupWithNavController(bottomNavigationView, navController);

    }
}