package com.example.reserch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        useObservableWithJust();

    }

    /**
     * 簡單測試  subscribe()
     */
    private void simpleSubscribe() {
        // 觀察者
        // 決定行為
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onCompleted() {
                Log.e("onCompleted", "onCompleted");

            }

            @Override
            public void onError(Throwable throwable) {
                Log.e("onError", "onError");

            }

            @Override
            public void onNext(String o) {
                Log.e("onNext", "onNext  " + o);
            }
        };
        //被觀察者
        // 決定何時觸發
        Observable observable = Observable.create(new Observable.OnSubscribe<String>() {

            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("1");
                subscriber.onNext("2");
                subscriber.onNext("3");
                subscriber.onNext("4");
                subscriber.onCompleted();
            }
        });
        //訂閱
        observable.subscribe(observer);
    }


    /**
     * 動作的不完整定義
     * 用 Action1 來定義 onNext() 及 onError();
     * 用 Action1 來定義 onCompleted()
     */
    private void simpleSubscribeWithAction() {
        Action1 nextAction = new Action1() {

            @Override
            public void call(Object o) {
                Log.e("nextAction", "hello " + o);
            }
        };
        Action1 errorAction = new Action1() {

            @Override
            public void call(Object o) {
                Log.e("errorAction", "error");
            }
        };
        Action0 completedAction = new Action0() {

            @Override
            public void call() {
                Log.e("completedAction", "completed");
            }
        };
        Observable observable = Observable.create(new Observable.OnSubscribe<String>() {

            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("1");
//                subscriber.onError(new Exception());
                subscriber.onCompleted();
            }
        });
        observable.subscribe(nextAction, errorAction, completedAction);
    }

    private void useObservableWithJust() {
        Observable.just("1")
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable throwable) {

                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("onNext", s);
                    }
                });
    }
}
