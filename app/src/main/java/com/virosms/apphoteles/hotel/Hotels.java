package com.virosms.apphoteles.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.virosms.apphoteles.R;
import com.virosms.apphoteles.Visited;
import com.virosms.apphoteles.databinding.ActivityHotelsBinding;

import java.util.ArrayList;
import java.util.List;

public class Hotels extends AppCompatActivity {

    List<Integer> images = new ArrayList<Integer>() {{
        add(R.drawable.hotel1);
        add(R.drawable.hotel2);
        add(R.drawable.hotel3);
        add(R.drawable.hotel4);
        add(R.drawable.hotel5);
    }};

    List<String> names = new ArrayList<String>() {{
        add("Charles Hotel");
        add("Hotel 2");
        add("Hotel 3");
        add("Hotel 4");
        add("Hotel 5");
    }};

    List<String> addresses = new ArrayList<String>() {{
        add("Av. 1");
        add("Av. 2");
        add("Av. 3");
        add("Av. 4");
        add("Av. 5");
    }};

    ActivityHotelsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHotelsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        binding.toolbar.setTitle("Charles Hotel");
        setSupportActionBar(binding.toolbar);

        binding.hotelsRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        binding.hotelsRecyclerView.setAdapter(new HotelAdapter(images, names, addresses));

        binding.hotelsRecyclerView.addItemDecoration(new SpaceItemDecoration(30));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_hotels_activity, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_search) {
            Intent intent = new Intent(Hotels.this, Visited.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}