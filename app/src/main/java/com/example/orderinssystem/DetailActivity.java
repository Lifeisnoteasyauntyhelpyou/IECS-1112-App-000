package com.example.orderinssystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class DetailActivity extends AppCompatActivity {

    TextView detailDesc, detailTitle;
    ImageView detailImage;
    String[] Name = {"歐姆蛋吐司", "鮮蔬吐司", "培根吐司", "里肌吐司", "雞腿排吐司", "魚排吐司",
                    "蝦排漢堡", "雞排漢堡", "牛肉漢堡", "照燒豬漢堡", "卡啦雞腿漢堡", "雙層厚豬漢堡",
                    "原味蛋餅", "玉米蛋餅", "薯餅蛋餅", "起士蛋餅", "牛肉蛋餅", "豬肉蛋餅",
                    "朝日淬釀紅茶", "四季春茶", "非基改現磨豆漿", "紅茶歐雷", "精選黑咖啡", "咖啡密斯朵",
            "古早味炒麵佐蘿蔔糕", "鮮奶山峰厚片拼盤", "綜合炸物佐沙拉", "美式牛肉佐鱈魚海陸拼盤", "厚牛起司堡雞塊拼盤", "雙泥沙拉炒蛋佐蘿蔔糕"
    , "豬肉起司堡"};
    int[] Images = {R.drawable.egg_toast, R.drawable.vegetable_toast, R.drawable.bacon_toast, R.drawable.pork_toast, R.drawable.drumstick_toast, R.drawable.fish_toast,
            R.drawable.shrimp_buger, R.drawable.chicken_chop_burger, R.drawable.beef_burger, R.drawable.roast_pork_burger, R.drawable.karai_drumstick_burger, R.drawable.double_pork_burger,
            R.drawable.oringin_eggcake, R.drawable.cron_eggcake, R.drawable.potatocake_eggcake, R.drawable.cheese_eggcake, R.drawable.beef_eggcake, R.drawable.pork_eggcake,
            R.drawable.black_tea, R.drawable.green_tea, R.drawable.soy_milk, R.drawable.milk_tea, R.drawable.black_coffee, R.drawable.latte,
            R.drawable.traditional_fried_noodles_with_carrot_cake, R.drawable.fresh_milk_shanfeng_thick_slice_platter, R.drawable.mixed_fried_foods_with_salad, R.drawable.american_style_beef_with_cod_fish_surf_and_turf_platter, R.drawable.thick_beef_cheeseburger_and_chicken_nugget_platter, R.drawable.double_mud_salad_with_scrambled_eggs_and_carrot_cake
    ,R.drawable.activity};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detailDesc = findViewById(R.id.detailDes);
        detailImage = findViewById(R.id.detailImage);
        detailTitle = findViewById(R.id.detailTitle);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            detailDesc.setText(bundle.getString("Description"));
            detailTitle.setText(bundle.getString("Title"));
            //detailImage.setImageResource(Images[2]);

            for(int i = 0;i<Name.length;i++){
                if(Name[i].equals(detailTitle.getText().toString())){
                    detailImage.setImageResource(Images[i]);
                    break;
                }
            }
        }
    }
}