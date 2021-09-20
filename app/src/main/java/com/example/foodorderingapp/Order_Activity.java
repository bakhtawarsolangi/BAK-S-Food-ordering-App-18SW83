package com.example.foodorderingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.foodorderingapp.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class Order_Activity extends AppCompatActivity {

    ActivityOrderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



DBhelper helper = new DBhelper(this);
ArrayList<OrderModel> list =helper.getOrder();





        OrderAdapter adapter = new OrderAdapter(list,this);
        binding.orderecyclerview.setAdapter(adapter);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        binding.orderecyclerview.setLayoutManager(layoutManager);

    }
}