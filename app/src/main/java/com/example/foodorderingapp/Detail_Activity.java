package com.example.foodorderingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.foodorderingapp.databinding.ActivityDetailBinding;

public class Detail_Activity extends AppCompatActivity {
    ActivityDetailBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        final DBhelper helper = new DBhelper(this);
        if(getIntent().getIntExtra("type",0)==1) {



            final int image = getIntent().getIntExtra("image", 0);
            final int price = Integer.parseInt(getIntent().getStringExtra("price"));
            String name = getIntent().getStringExtra("name");
            String description = getIntent().getStringExtra("desc");

            binding.detailimage.setImageResource(image);
            binding.pricelbl.setText(String.format("%d", price));
            binding.namedetail.setText(name);
            binding.detaildesc.setText(description);


            binding.insertbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    boolean isInserted = helper.insertOrder(binding.Namebox.getText().toString(),
                            binding.Phonebox.getText().toString(),
                            price, image, description, name,
                            Integer.parseInt(binding.quantity.getText().toString())

                    );
                    if (isInserted)
                        Toast.makeText(Detail_Activity.this, "Data is sucessfully inserted", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(Detail_Activity.this, "Error", Toast.LENGTH_SHORT).show();

                }
            });
        }
        else{
            int id=getIntent().getIntExtra("id",0);
            Cursor cursor= helper.getOrderByid(id);
            final int image = cursor.getInt(4);
            binding.detailimage.setImageResource(image);
            binding.pricelbl.setText(String.format("%d", cursor.getInt(3)));
            binding.namedetail.setText(cursor.getString(6));
            binding.detaildesc.setText(cursor.getString(7));
            binding.Namebox.setText(cursor.getString(1));
            binding.Phonebox.setText(cursor.getString(2));
            binding.insertbtn.setText("Update Now");
            binding.insertbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   boolean isUpdated=helper.updateOrder
                           (binding.Namebox.getText().toString(),
                            binding.Phonebox.getText().toString(),
                            Integer.parseInt(binding.pricelbl.getText().toString()),
                            image,
                            binding.detaildesc.getText().toString(),
                            binding.namedetail.getText().toString(),
                            1,
                            id);

                 if(isUpdated)
                     Toast.makeText(Detail_Activity.this, "Data is sucessfully updated", Toast.LENGTH_SHORT).show();
                 else
                     Toast.makeText(Detail_Activity.this, "Error", Toast.LENGTH_SHORT).show();


                }
            });

        }
    }



        }


