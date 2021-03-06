package com.fire.weatherapp.model.api;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RxTransformer {

  public static <T> Observable.Transformer<T, T> applyIOSchedulers() {
    return observable -> observable
        .subscribeOn(Schedulers.io())
        .unsubscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread());
  }

  public static <T> Observable.Transformer<T, T> applyComputationSchedulers() {
    return observable -> observable
        .subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread());
  }
}
