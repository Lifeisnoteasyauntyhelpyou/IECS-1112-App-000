package com.example.orderinssystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.orderinssystem.databinding.ActivityMainBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

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
        String[] ToastName = {"歐姆蛋吐司", "鮮蔬吐司", "培根吐司", "里肌吐司", "雞腿排吐司", "魚排吐司"};
        int[] ToastImages = {R.drawable.egg_toast, R.drawable.vegetable_toast, R.drawable.bacon_toast, R.drawable.pork_toast, R.drawable.drumstick_toast, R.drawable.fish_toast};
        String[] burgerName = {"蝦排漢堡", "雞排漢堡", "牛肉漢堡", "照燒豬漢堡", "卡啦雞腿漢堡", "雙層厚豬漢堡"};
        int[] burgerImages = {R.drawable.shrimp_buger, R.drawable.chicken_chop_burger, R.drawable.beef_burger, R.drawable.roast_pork_burger, R.drawable.karai_drumstick_burger, R.drawable.double_pork_burger};
        String[] OmeletName = {"原味蛋餅", "玉米蛋餅", "薯餅蛋餅", "起士蛋餅", "牛肉蛋餅", "豬肉蛋餅"};
        int[] OmeletImages = {R.drawable.oringin_eggcake, R.drawable.cron_eggcake, R.drawable.potatocake_eggcake, R.drawable.cheese_eggcake, R.drawable.beef_eggcake, R.drawable.pork_eggcake};
        String[] DrinksName = {"朝日淬釀紅茶", "四季春茶", "非基改現磨豆漿", "紅茶歐雷", "精選黑咖啡", "咖啡密斯朵"};
        int[] DrinksImages = {R.drawable.black_tea, R.drawable.green_tea, R.drawable.soy_milk, R.drawable.milk_tea, R.drawable.black_coffee, R.drawable.latte};
        String[] PackageName = {"古早味炒麵佐蘿蔔糕", "鮮奶山峰厚片拼盤", "綜合炸物佐沙拉", "美式牛肉佐鱈魚海陸拼盤", "厚牛起司堡雞塊拼盤", "雙泥沙拉炒蛋佐蘿蔔糕"};
        int[] PackageImages = {R.drawable.traditional_fried_noodles_with_carrot_cake, R.drawable.fresh_milk_shanfeng_thick_slice_platter, R.drawable.mixed_fried_foods_with_salad, R.drawable.american_style_beef_with_cod_fish_surf_and_turf_platter, R.drawable.thick_beef_cheeseburger_and_chicken_nugget_platter, R.drawable.double_mud_salad_with_scrambled_eggs_and_carrot_cake};


        //GridAdapters
        GridAdapter gridAdapter = new GridAdapter(MainActivity.this, ToastName, ToastImages);
        GridAdapter gridAdapterburger = new GridAdapter(MainActivity.this, burgerName, burgerImages);
        GridAdapter gridAdapterOmelet = new GridAdapter(MainActivity.this, OmeletName, OmeletImages);
        GridAdapter gridAdapterDrinks = new GridAdapter(MainActivity.this, DrinksName, DrinksImages);
        GridAdapter gridAdapterPackage = new GridAdapter(MainActivity.this, PackageName, PackageImages);
        //first
        binding.gvBurger.setAdapter(gridAdapter);
        binding.gvBurger.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "click", Toast.LENGTH_LONG).show();
                if(position == 0){
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, EggToast.class);
                    startActivity(intent);
                } else if(position == 1){
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, VegetableToast.class);
                    startActivity(intent);
                } else if(position == 2){
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, BaconToast.class);
                    startActivity(intent);
                } else if(position == 3){
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, PorkToast.class);
                    startActivity(intent);
                } else if(position == 4){
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, DrumstickToast.class);
                    startActivity(intent);
                } else if(position == 5){
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, FishToast.class);
                    startActivity(intent);
                }
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
                            if(position == 0){
                                Intent intent = new Intent( );
                                intent.setClass(MainActivity.this, EggToast.class);
                                startActivity(intent);
                            } else if(position == 1){
                                Intent intent = new Intent();
                                intent.setClass(MainActivity.this, VegetableToast.class);
                                startActivity(intent);
                            } else if(position == 2){
                                Intent intent = new Intent();
                                intent.setClass(MainActivity.this, BaconToast.class);
                                startActivity(intent);
                            } else if(position == 3){
                                Intent intent = new Intent();
                                intent.setClass(MainActivity.this, PorkToast.class);
                                startActivity(intent);
                            } else if(position == 4){
                                Intent intent = new Intent();
                                intent.setClass(MainActivity.this, DrumstickToast.class);
                                startActivity(intent);
                            } else if(position == 5){
                                Intent intent = new Intent();
                                intent.setClass(MainActivity.this, FishToast.class);
                                startActivity(intent);
                            }
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
                            if(position == 0){
                                Intent intent = new Intent( );
                                intent.setClass(MainActivity.this, ShrimpBuger.class);
                                startActivity(intent);
                            } else if(position == 1){
                                Intent intent = new Intent( );
                                intent.setClass(MainActivity.this, ChickenChopBurger.class);
                                startActivity(intent);
                            } else if(position == 2){
                                Intent intent = new Intent( );
                                intent.setClass(MainActivity.this, BeefBurger.class);
                                startActivity(intent);
                            } else if(position == 3){
                                Intent intent = new Intent( );
                                intent.setClass(MainActivity.this, RoastPorkBurger.class);
                                startActivity(intent);
                            } else if(position == 4){
                                Intent intent = new Intent( );
                                intent.setClass(MainActivity.this, KaraiDrumBurger.class);
                                startActivity(intent);
                            } else if(position == 5){
                                Intent intent = new Intent( );
                                intent.setClass(MainActivity.this, DoublePorkBurger.class);
                                startActivity(intent);
                            }
                        }
                    });
                    break;
                case R.id.Omelet:
                    replaceFragment((new OmeletFragment()));
                    binding.gvBurger.setAdapter(gridAdapterOmelet);
                    binding.gvBurger.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Toast.makeText(MainActivity.this, "click", Toast.LENGTH_LONG).show();
                            if(position == 0){
                                Intent intent = new Intent( );
                                intent.setClass(MainActivity.this, OringinEggcake.class);
                                startActivity(intent);
                            } else if(position == 1){
                                Intent intent = new Intent( );
                                intent.setClass(MainActivity.this, CronEggcake.class);
                                startActivity(intent);
                            } else if(position == 2){
                                Intent intent = new Intent( );
                                intent.setClass(MainActivity.this, PotatocakeEggcake.class);
                                startActivity(intent);
                            } else if(position == 3){
                                Intent intent = new Intent( );
                                intent.setClass(MainActivity.this, CheeseEggcake.class);
                                startActivity(intent);
                            } else if(position == 4){
                                Intent intent = new Intent( );
                                intent.setClass(MainActivity.this, BeefEggcake.class);
                                startActivity(intent);
                            } else if(position == 5){
                                Intent intent = new Intent( );
                                intent.setClass(MainActivity.this, PorkEggcake.class);
                                startActivity(intent);
                            }
                        }
                    });
                    break;
                case R.id.Drinks:
                    replaceFragment((new DrinksFragment()));
                    binding.gvBurger.setAdapter(gridAdapterDrinks);
                    binding.gvBurger.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Toast.makeText(MainActivity.this, "click", Toast.LENGTH_LONG).show();
                            if(position == 0){
                                Intent intent = new Intent( );
                                intent.setClass(MainActivity.this, BlackTea.class);
                                startActivity(intent);
                            } else if(position == 1){
                                Intent intent = new Intent( );
                                intent.setClass(MainActivity.this, GreenTea.class);
                                startActivity(intent);
                            } else if(position == 2){
                                Intent intent = new Intent( );
                                intent.setClass(MainActivity.this, SoyMilk.class);
                                startActivity(intent);
                            } else if(position == 3){
                                Intent intent = new Intent( );
                                intent.setClass(MainActivity.this, MilkTea.class);
                                startActivity(intent);
                            } else if(position == 4){
                                Intent intent = new Intent( );
                                intent.setClass(MainActivity.this, BlackCoffee.class);
                                startActivity(intent);
                            } else if(position == 5){
                                Intent intent = new Intent( );
                                intent.setClass(MainActivity.this, Latte.class);
                                startActivity(intent);
                            }
                        }
                    });
                    break;
                case R.id.Package:
                    replaceFragment(new PackageFragment());
                    binding.gvBurger.setAdapter(gridAdapterPackage);
                    binding.gvBurger.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Toast.makeText(MainActivity.this, "click", Toast.LENGTH_LONG).show();
                            if(position == 0){
                                Intent intent = new Intent( );
                                intent.setClass(MainActivity.this, SetMealA.class);
                                startActivity(intent);
                            } else if(position == 1){
                                Intent intent = new Intent( );
                                intent.setClass(MainActivity.this, SetMealB.class);
                                startActivity(intent);
                            } else if(position == 2){
                                Intent intent = new Intent( );
                                intent.setClass(MainActivity.this, SetMealC.class);
                                startActivity(intent);
                            } else if(position == 3){
                                Intent intent = new Intent( );
                                intent.setClass(MainActivity.this, SetMealD.class);
                                startActivity(intent);
                            } else if(position == 4){
                                Intent intent = new Intent( );
                                intent.setClass(MainActivity.this, SetMealE.class);
                                startActivity(intent);
                            } else if(position == 5){
                                Intent intent = new Intent( );
                                intent.setClass(MainActivity.this, SetMealF.class);
                                startActivity(intent);
                            }
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