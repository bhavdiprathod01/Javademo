package com.bmrwork.javademo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    private AdvertiseViewModel viewModel;
    private AdvertiseAdapter adapter;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressBar);

        // Setup RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AdvertiseAdapter(this, new ArrayList<>());
        recyclerView.setAdapter(adapter);

        // Initialize ViewModel
        viewModel = new ViewModelProvider(this).get(AdvertiseViewModel.class);

        // Observe data changes
        viewModel.getAllAdvertise().observe(this, advertiseEntities -> {
            if (advertiseEntities != null && !advertiseEntities.isEmpty()) {
                progressBar.setVisibility(View.GONE);
                adapter.updateList(advertiseEntities);
            } else {
                // No data in DB yet, show loading
                progressBar.setVisibility(View.VISIBLE);
            }
        });
        viewModel.getErrorMessage().observe(this, error -> {
            progressBar.setVisibility(View.GONE);
            Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
        });
        viewModel.loadData();
        progressBar.setVisibility(View.VISIBLE);
    }
}