package com.example.foodorderingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.foodorderingapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        ArrayList<MainModel> list = new ArrayList<>();
        list.add(new MainModel("Zinger Burger",R.drawable.f_1,"500","Zinger Burger with extra cheese and juicy chicken"));
        list.add(new MainModel("Chicken Burger",R.drawable.f_2,"380","Chicken Burger with extra cheese and salad"));
        list.add(new MainModel("Crispy Fries",R.drawable.f_3,"200","Crispy fries with extra sauces and spices "));
        list.add(new MainModel("Lasagne",R.drawable.f_4,"800","Baked pasta with extra cheese and meat"));
        list.add(new MainModel("Hot shots",R.drawable.f_5,"500","They are tasty and hot!"));
        list.add(new MainModel("Pizza",R.drawable.f_6,"900","Cheesy pizza with extra chicken and toppings"));
        list.add(new MainModel("Club sandwich",R.drawable.f_7,"250","Sandwich with extra spices and crispy fries"));
        list.add(new MainModel("White sauce pasta",R.drawable.f_8,"350","Made with silky smooth and aromatic sauce"));
        list.add(new MainModel("Red sauce pasta",R.drawable.f_9,"300","Made with creamy tomato paste and for spice lovers"));
        list.add(new MainModel("Pizza Burger",R.drawable.f10,"450","Crunchiest zinger with pizza toppings and spices"));
        list.add(new MainModel("Fried Rice",R.drawable.f_11,"510","  fried rice with rich vegetables and red chilli chicken"));
        list.add(new MainModel(" Paratha Roll",R.drawable.f_12,"180","Crispy paratha with flavoured chicken served with red and green sauce"));
        list.add(new MainModel("Chicken Karahi",R.drawable.f_13,"780","Spicy Karahi served with hot naan and salad for two servings"));
        list.add(new MainModel("Chicken pilau",R.drawable.f_14,"400","Classic chicken pilau with tasty spices"));
        list.add(new MainModel("Chicken Biryani",R.drawable.f_15,"450","Tasty and spicy daigi biryani served with raita"));








        MainAdapter adapter = new MainAdapter(list,this);
        binding.recyclerview.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerview.setLayoutManager(layoutManager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.orders:
                startActivity(new Intent(MainActivity.this,Order_Activity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}