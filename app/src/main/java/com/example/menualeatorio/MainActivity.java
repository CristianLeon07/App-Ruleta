package com.example.menualeatorio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.bluehomestudio.luckywheel.LuckyWheel;
import com.bluehomestudio.luckywheel.OnLuckyWheelReachTheTarget;
import com.bluehomestudio.luckywheel.WheelItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    LuckyWheel ruleta;
    List<WheelItem> listaitem = new ArrayList<>();
    String points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ruleta = findViewById(R.id.ruleta);

        WheelItem wheelItem1 = new WheelItem(ResourcesCompat.getColor(getResources(), R.color.colorA, null),
                BitmapFactory.decodeResource(getResources(), R.mipmap.icon_menu), "Pony");

        listaitem.add(wheelItem1);

        WheelItem wheelItem2 = new WheelItem(ResourcesCompat.getColor(getResources(), R.color.design_default_color_secondary, null),
                BitmapFactory.decodeResource(getResources(),R.mipmap.icon_menu), "Cafe-Leche");

        listaitem.add(wheelItem2);

        WheelItem wheelItem3 = new WheelItem(ResourcesCompat.getColor(getResources(), R.color.colorB, null),
                BitmapFactory.decodeResource(getResources(),R.mipmap.icon_menu), "Jugo Hit");

        listaitem.add(wheelItem3);

        WheelItem wheelItem4 = new WheelItem(ResourcesCompat.getColor(getResources(), R.color.design_default_color_error, null),
                BitmapFactory.decodeResource(getResources(),R.mipmap.icon_menu), "Chocolate");

        listaitem.add(wheelItem4);

        WheelItem wheelItem5 = new WheelItem(ResourcesCompat.getColor(getResources(), R.color.colorD, null),
                BitmapFactory.decodeResource(getResources(),R.mipmap.icon_menu), "Yogurt");

        listaitem.add(wheelItem5);

        WheelItem wheelItem6= new WheelItem(ResourcesCompat.getColor(getResources(), R.color.colorC, null),
                BitmapFactory.decodeResource(getResources(),R.mipmap.icon_menu), "Avena");

        listaitem.add(wheelItem6);

        WheelItem wheelItem7= new WheelItem(ResourcesCompat.getColor(getResources(), R.color.design_default_color_primary, null),
                BitmapFactory.decodeResource(getResources(),R.mipmap.icon_menu), "Cafe");

        listaitem.add(wheelItem7);


        ruleta.addWheelItems(listaitem);

        ruleta.setLuckyWheelReachTheTarget(new OnLuckyWheelReachTheTarget() {
            @Override
            public void onReachTarget() {
                WheelItem itemSelected = listaitem.get(Integer.parseInt(points)-1);
                String putosAcomulados = itemSelected.text;
                Toast.makeText(MainActivity.this, putosAcomulados,Toast.LENGTH_LONG).show();
            }
        });



    }
    public  void  btnSelect(View view){

        Random random = new Random();
        points = String.valueOf(random.nextInt(6));
        if (points.equals("0")){
            points= String.valueOf(1);
        }
        else {
            ruleta.rotateWheelTo(Integer.parseInt(points));
        }
    }
    public void  irComida (View view) {
        Intent intent = new Intent(MainActivity.this, Comida.class);
        startActivity(intent);
        finish();
    };


}