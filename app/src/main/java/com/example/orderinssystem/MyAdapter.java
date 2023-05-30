package com.example.orderinssystem;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private Context context;
    private List<DataClass> dataList;
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

    public MyAdapter(Context context, List<DataClass> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.recTitle.setText(dataList.get(position).getDataTitle());
        holder.recLang.setText(dataList.get(position).getDataMoney());
        holder.recDesc.setText(dataList.get(position).getDataNumber());
        for(int i = 0;i<Name.length;i++){
            if(Name[i].equals(holder.recTitle.getText().toString())){
                holder.recImage.setImageResource(Images[i]);
                break;
            }
        }

        holder.recCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);

                intent.putExtra("Description", dataList.get(holder.getAdapterPosition()).getDataNumber());
                intent.putExtra("Title", dataList.get(holder.getAdapterPosition()).getDataTitle());


                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}

class MyViewHolder extends  RecyclerView.ViewHolder{

    ImageView recImage;
    TextView recTitle, recDesc, recLang;
    CardView recCard;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        recImage = itemView.findViewById(R.id.recImage);
        recCard = itemView.findViewById(R.id.recCard);
        recDesc = itemView.findViewById(R.id.recDesc);
        recLang = itemView.findViewById(R.id.recLang);
        recTitle = itemView.findViewById(R.id.recTitle);
    }
}

