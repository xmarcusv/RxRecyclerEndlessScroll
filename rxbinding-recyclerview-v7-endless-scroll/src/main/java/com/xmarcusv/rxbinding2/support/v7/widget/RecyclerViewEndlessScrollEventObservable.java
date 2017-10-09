package com.xmarcusv.rxbinding2.support.v7.widget;

import android.support.v7.widget.RecyclerView;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

import static com.jakewharton.rxbinding2.internal.Preconditions.checkMainThread;

public class RecyclerViewEndlessScrollEventObservable extends Observable<RecyclerViewEndlessScrollEvent> {

    private RecyclerView view;
    private int visibleThreshold = 5;

    RecyclerViewEndlessScrollEventObservable(RecyclerView view) {
        this.view = view;
    }

    RecyclerViewEndlessScrollEventObservable(RecyclerView view, int visibleThreshold) {
        this.view = view;
        this.visibleThreshold = visibleThreshold;
    }

    @Override
    protected void subscribeActual(Observer<? super RecyclerViewEndlessScrollEvent> observer) {
        if (!checkMainThread(observer)) {
            return;
        }
        Listener listener = new Listener(view, observer);
        observer.onSubscribe(listener);
        view.addOnScrollListener(listener.endlessScrollListener);
    }

    final class Listener extends MainThreadDisposable {
        private final RecyclerView recyclerView;
        private final EndlessScrollListener endlessScrollListener;

        Listener(RecyclerView recyclerView, final Observer<? super RecyclerViewEndlessScrollEvent> observer) {
            this.recyclerView = recyclerView;
            this.endlessScrollListener = new EndlessScrollListener(recyclerView.getLayoutManager(), visibleThreshold) {
                @Override
                public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                    if (!isDisposed()) {
                        observer.onNext(RecyclerViewEndlessScrollEvent.create(view, page, totalItemsCount));
                    }
                }
            };
        }

        @Override
        protected void onDispose() {
            recyclerView.removeOnScrollListener(endlessScrollListener);
        }
    }
}

