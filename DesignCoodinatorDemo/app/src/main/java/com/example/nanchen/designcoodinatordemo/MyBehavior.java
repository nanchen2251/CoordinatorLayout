package com.example.nanchen.designcoodinatordemo;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.view.View;

/**
 * 自定义Behavior
 * Created by 南尘 on 16-7-14.
 */
public class MyBehavior extends FloatingActionButton.Behavior {

    //写了这个构造方法才能在XML文件中直接指定
    public MyBehavior(Context context, AttributeSet attrs) {
        super();
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View directTargetChild, View target, int nestedScrollAxes) {
        return true;//返回true代表我们关心这个滚动事件
    }

    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);
        if (dy < 0) {//向下滚动
//            ViewCompat.animate(child).scaleX(1).alpha(1).start();
            child.show();
        } else {//向上滚动
//            ViewCompat.animate(child).scaleX(0).alpha(0).start();
            child.hide();
        }
    }
}
