package com.evani.techmtest.presenters;

import com.evani.techmtest.model.DataModel;
import com.evani.techmtest.model.IData;
import com.evani.techmtest.view.IDataView;

import java.util.List;

public class DataPresenter implements IDataPresenter {

    private IData model;
    private IDataView dataView;

    public DataPresenter (IDataView dataView) {
        this.dataView = dataView;
        initModel();
    }

    @Override
    public List<String> getData() {
      return  model.displayData();
    }

    public void initModel() {
        model = new DataModel();
    }
}
