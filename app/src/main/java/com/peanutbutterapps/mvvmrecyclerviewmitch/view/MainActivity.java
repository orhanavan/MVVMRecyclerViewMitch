package com.peanutbutterapps.mvvmrecyclerviewmitch.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.peanutbutterapps.mvvmrecyclerviewmitch.R;
import com.peanutbutterapps.mvvmrecyclerviewmitch.adapters.RecyclerViewAdapter;
import com.peanutbutterapps.mvvmrecyclerviewmitch.databinding.ActivityMainBinding;
import com.peanutbutterapps.mvvmrecyclerviewmitch.models.NicePlace;
import com.peanutbutterapps.mvvmrecyclerviewmitch.viewmodels.NicePlaceViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private NicePlaceViewModel viewModel;
    private RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setHasFixedSize(true);

        viewModel = ViewModelProviders.of(this).get(NicePlaceViewModel.class);
        viewModel.init();
        viewModel.getNicePlaces().observe(this, new Observer<List<NicePlace>>() {
            @Override
            public void onChanged(@Nullable List<NicePlace> nicePlaces) {
                adapter.notifyDataSetChanged();
                binding.recyclerView.smoothScrollToPosition(viewModel.getNicePlaces().getValue().size() - 1);

            }
        });

        adapter = new RecyclerViewAdapter(this, viewModel.getNicePlaces().getValue());
        binding.recyclerView.setAdapter(adapter);
        binding.setViewModel(viewModel);
    }


}
