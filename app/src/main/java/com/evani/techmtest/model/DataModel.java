package com.evani.techmtest.model;

import com.evani.techmtest.model.IData;

import java.util.ArrayList;
import java.util.List;

public class DataModel implements IData {
    @Override
    public List<String> displayData() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20 ; i++) {
            list.add(" Sample "+i);
        }
        return list;
    }
}
