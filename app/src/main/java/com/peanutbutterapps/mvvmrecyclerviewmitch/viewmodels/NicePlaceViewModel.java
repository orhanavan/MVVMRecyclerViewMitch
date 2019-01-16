package com.peanutbutterapps.mvvmrecyclerviewmitch.viewmodels;

import android.annotation.SuppressLint;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableBoolean;
import android.os.AsyncTask;

import com.peanutbutterapps.mvvmrecyclerviewmitch.models.NicePlace;
import com.peanutbutterapps.mvvmrecyclerviewmitch.repositories.NicePlaceRepository;

import java.util.List;

public class NicePlaceViewModel extends ViewModel {

    private MutableLiveData<List<NicePlace>> nicePlaces;
    private NicePlaceRepository repo;
    public ObservableBoolean isUpdating = new ObservableBoolean();

    public void init() {
        if (nicePlaces != null) {
            return;
        }

        repo = NicePlaceRepository.getInstance();
        nicePlaces = repo.getNicePlaces();
        isUpdating.set(false);
    }

    public LiveData<List<NicePlace>> getNicePlaces() {
        return nicePlaces;
    }

    @SuppressLint("StaticFieldLeak")
    public void addNewValue() {
        isUpdating.set(true);

        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;

            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);

                List<NicePlace> currentPlaces = nicePlaces.getValue();
                currentPlaces.add(new NicePlace("Orhan",
                        "https://cdn.pixabay.com/photo/2017/05/19/07/49/flag-2325752_960_720.jpg"));
                nicePlaces.postValue(currentPlaces);

                isUpdating.set(false);
            }
        }.execute();
    }
}
