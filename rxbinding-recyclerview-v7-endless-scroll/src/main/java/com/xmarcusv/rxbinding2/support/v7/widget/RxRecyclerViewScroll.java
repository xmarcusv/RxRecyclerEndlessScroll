package com.xmarcusv.rxbinding2.support.v7.widget;

import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import io.reactivex.Observable;

public class RxRecyclerViewScroll {

    @CheckResult
    @NonNull
    public static Observable<RecyclerViewEndlessScrollEvent> scrollEvents(@NonNull RecyclerView view) {
        return new RecyclerViewEndlessScrollEventObservable(view);
    }

    @CheckResult
    @NonNull
    public static Observable<RecyclerViewEndlessScrollEvent> scrollEvents(@NonNull RecyclerView view, int visibleThreshold) {
        return new RecyclerViewEndlessScrollEventObservable(view, visibleThreshold);
    }
}