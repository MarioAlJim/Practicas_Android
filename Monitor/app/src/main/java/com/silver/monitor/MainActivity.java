package com.silver.monitor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.os.Bundle;
import android.widget.Toast;

import com.silver.monitor.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        binding.eqRecycler.setLayoutManager(new LinearLayoutManager(this));
        EqAdapter adapter = new EqAdapter();
        adapter.setOnItemClickListener(earthquake ->
                Toast.makeText(MainActivity.this,
                        earthquake.getPlace(),
                        Toast.LENGTH_SHORT).show());
        binding.eqRecycler.setAdapter(adapter);
        viewModel.getEqList().observe(this, eqList -> {
            adapter.submitList(eqList);
        });
        viewModel.getEarthquakes();
    }
}