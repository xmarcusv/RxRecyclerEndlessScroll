package com.xmarcusv.rxendless.scroll.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.xmarcusv.rxbinding2.support.v7.widget.RecyclerViewEndlessScrollEvent;
import com.xmarcusv.rxbinding2.support.v7.widget.RxRecyclerViewScroll;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private int numberCreatedItems = 15;
    private List<String> items = new ArrayList<>();
    private SampleAdapter sampleAdapter;
    private CompositeDisposable compositeDisposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        recyclerView = findViewById(R.id.sample_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        sampleAdapter = new SampleAdapter(items);
        recyclerView.setAdapter(sampleAdapter);

        loadMore();
    }

    @Override
    protected void onResume() {
        super.onResume();

        getCompositeDisposable()
                .add(RxRecyclerViewScroll
                        .scrollEvents(recyclerView, 5)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<RecyclerViewEndlessScrollEvent>() {
                            @Override
                            public void accept(RecyclerViewEndlessScrollEvent recyclerViewEndlessScrollEvent) throws Exception {
                                loadMore();
                            }
                        }));
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (compositeDisposable != null) {
            compositeDisposable.dispose();
        }
    }

    private void loadMore() {
        int oldSize = items.size();

        Random randomGenerator = new Random();
        for (int idx = 1; idx <= numberCreatedItems; ++idx) {
            int randomInt = randomGenerator.nextInt(100);
            items.add(String.valueOf(randomInt));
        }

        sampleAdapter.notifyItemRangeInserted(oldSize, numberCreatedItems);
    }

    public CompositeDisposable getCompositeDisposable() {
        if (compositeDisposable == null || compositeDisposable.isDisposed()) {
            compositeDisposable = new CompositeDisposable();

        }

        return compositeDisposable;
    }
}
