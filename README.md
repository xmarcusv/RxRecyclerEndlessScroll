# RxRecyclerEndlessScroll

This library provide a binding endless scroll for RecyclerView, it is based on 
[RxBinding](https://github.com/JakeWharton/RxBinding) and 
[EndlessRecyclerViewScrollListener](https://gist.github.com/nesquena/d09dc68ff07e845cc622).

## How to use it?

It is really simple:

```java
RxRecyclerViewScroll
    .scrollEvents(recyclerView)
    .observeOn(AndroidSchedulers.mainThread())
    .subscribe(new Consumer<RecyclerViewEndlessScrollEvent>() {
        @Override
        public void accept(RecyclerViewEndlessScrollEvent recyclerViewEndlessScrollEvent) throws Exception {
            // load more items
        }
    })
```

**That's all you need!**


