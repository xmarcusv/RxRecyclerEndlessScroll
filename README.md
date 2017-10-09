# RxRecyclerEndlessScroll

This library provide a binding endless scroll for RecyclerView, it is based on 
[RxBinding](https://github.com/JakeWharton/RxBinding) and 
[EndlessRecyclerViewScrollListener](https://gist.github.com/nesquena/d09dc68ff07e845cc622).

[![Download](https://api.bintray.com/packages/xmarcusv/android/rx-recycler-endless-scroll/images/download.svg)](https://bintray.com/xmarcusv/android/rx-recycler-endless-scroll/_latestVersion)

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

## Download

```Gradle
compile 'com.github.xmarcusv:rx-recycler-endless-scroll:1.0.0'
```

## License 
```
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```




