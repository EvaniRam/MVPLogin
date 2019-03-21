package com.evani.techmtest.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.evani.techmtest.R;
import com.evani.techmtest.model.IData;
import com.evani.techmtest.presenters.DataPresenter;
import com.evani.techmtest.presenters.IDataPresenter;
import com.evani.techmtest.presenters.ILoginPresenter;
import com.evani.techmtest.presenters.LoginPresenter;
import com.evani.techmtest.view.adapters.CustomAdapter;

import java.util.List;

public class MyRecyclerListActivity extends AppCompatActivity implements IDataView {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private CustomAdapter mAdapter;
    private IDataPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager  = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        presenter = new DataPresenter(this);

        mAdapter = new CustomAdapter(getDataFromModel(),this);
        mRecyclerView.setAdapter(mAdapter);
    }


    @Override
    public List<String> getDataFromModel() {
        return presenter.getData();
    }
}
