package com.xmarcusv.rxbinding2.support.v7.widget;

import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class RecyclerViewEndlessScrollEvent {

    @CheckResult
    @NonNull
    static RecyclerViewEndlessScrollEvent create(@NonNull RecyclerView recyclerView, int page, int totalItemsCount) {
        return new AutoValue_RecyclerViewEndlessScrollEvent(recyclerView, page, totalItemsCount);
    }

    RecyclerViewEndlessScrollEvent() {

    }

    /** The view from which this event occurred. */
    @NonNull
    public abstract RecyclerView view();
    public abstract int page();
    public abstract int totalItemsCount();
}
