package com.peanutbutterapps.mvvmrecyclerviewmitch.repositories;

import android.arch.lifecycle.MutableLiveData;

import com.peanutbutterapps.mvvmrecyclerviewmitch.models.NicePlace;

import java.util.ArrayList;
import java.util.List;

public class NicePlaceRepository {

    private static NicePlaceRepository instance;
    private List<NicePlace> dataSet = new ArrayList<>();

    public static NicePlaceRepository getInstance() {
        if (instance == null) {
            instance = new NicePlaceRepository();
        }

        return instance;
    }

    public MutableLiveData<List<NicePlace>> getNicePlaces() {
        setNicePlaces();
        MutableLiveData<List<NicePlace>> data = new MutableLiveData<>();
        data.setValue(dataSet);
        return data;
    }

    private void setNicePlaces() {
        dataSet.add(new NicePlace("Tac Mahal",
                "https://images.unsplash.com/photo-1524492412937-b28074a5d7da?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=400&q=80"));

        dataSet.add(new NicePlace("Mountain Cliff",
                "https://images.unsplash.com/photo-1536355207659-10f4a533163e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=400&q=80"));

        dataSet.add(new NicePlace("Vila Nova de Gaia",
                "https://images.unsplash.com/photo-1521017432531-fbd92d768814?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=400&q=80"));

        dataSet.add(new NicePlace("Waterpark",
                "https://images.unsplash.com/photo-1505246615136-e254ebed602d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=400&q=80"));

        dataSet.add(new NicePlace("Brown Castle",
                "https://images.unsplash.com/photo-1519586153880-4aaa41ebc2f7?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=400&q=80"));

        dataSet.add(new NicePlace("Korean Kingdom",
                "https://images.unsplash.com/photo-1542606004-f5c87297199c?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=400&q=80"));

        dataSet.add(new NicePlace("Lac du Salagou",
                "https://images.unsplash.com/photo-1502093986419-d6b4a2cb4f74?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=400&q=80"));

        dataSet.add(new NicePlace("Moena",
                "https://images.unsplash.com/photo-1519681393784-d120267933ba?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=400&q=80"));

        dataSet.add(new NicePlace("Tre Cime di Lavaredo",
                "https://images.unsplash.com/photo-1478515463067-d20f52aace26?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=400&q=80"));

    }
}
