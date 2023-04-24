package com.example.orderinssystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.orderinssystem.databinding.ActivityMainBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    FloatingActionButton btn_shoppingButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replaceFragment((new ToastFragment()));
        binding.bottomNavigationView.setBackground(null);
        //images, names
        String[] ToastName = {"1", "2", "3", "4", "5", "6"};
        int[] ToastImages = {R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e, R.drawable.f};
        String[] burgerName = {"7", "8", "9", "10", "11", "12"};
        int[] burgerImages = {R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e, R.drawable.f};
        String[] OmeletName = {"7", "8", "9", "10", "11", "12"};
        int[] OmeletImages = {R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e, R.drawable.f};
        String[] DrinksName = {"7", "8", "9", "10", "11", "12"};
        int[] DrinksImages = {R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e, R.drawable.f};
        //GridAdapters
        GridAdapter gridAdapter = new GridAdapter(MainActivity.this, ToastName, ToastImages);
        GridAdapter gridAdapterburger = new GridAdapter(MainActivity.this, burgerName, burgerImages);
        GridAdapter gridAdapterOmelet = new GridAdapter(MainActivity.this, OmeletName, OmeletImages);
        GridAdapter gridAdapterDrinks = new GridAdapter(MainActivity.this, DrinksName, DrinksImages);
        //first
        binding.gvBurger.setAdapter(gridAdapter);
        binding.gvBurger.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "click", Toast.LENGTH_LONG).show();
            }
        });

        //all pages
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){
                case R.id.Toast:
                    replaceFragment((new ToastFragment()));
                    binding.gvBurger.setAdapter(gridAdapter);
                    binding.gvBurger.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Toast.makeText(MainActivity.this, "click", Toast.LENGTH_LONG).show();
                        }
                    });
                    break;
                case R.id.Burger:
                    replaceFragment((new BurgerFragment()));
                    binding.gvBurger.setAdapter(gridAdapterburger);
                    binding.gvBurger.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Toast.makeText(MainActivity.this, "click", Toast.LENGTH_LONG).show();
                        }
                    });
                    break;
                case R.id.Omelet:
                    replaceFragment((new OmeletFragment()));
                    replaceFragment((new BurgerFragment()));
                    binding.gvBurger.setAdapter(gridAdapterOmelet);
                    binding.gvBurger.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Toast.makeText(MainActivity.this, "click", Toast.LENGTH_LONG).show();
                        }
                    });
                    break;
                case R.id.Drinks:
                    replaceFragment((new DrinksFragment()));
                    replaceFragment((new BurgerFragment()));
                    binding.gvBurger.setAdapter(gridAdapterDrinks);
                    binding.gvBurger.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Toast.makeText(MainActivity.this, "click", Toast.LENGTH_LONG).show();
                        }
                    });
                    break;
            }

            return true;
        });
        //shopping car button
        btn_shoppingButton = (FloatingActionButton) findViewById(R.id.btn_shoppingCar);
        btn_shoppingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, ShoppingCar.class);
                startActivity(intent);
            }
        });
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}