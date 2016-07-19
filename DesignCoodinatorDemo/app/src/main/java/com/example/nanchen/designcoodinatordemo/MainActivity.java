    package com.example.nanchen.designcoodinatordemo;

    import android.content.Intent;
    import android.os.Bundle;
    import android.support.design.widget.FloatingActionButton;
    import android.support.design.widget.Snackbar;
    import android.support.design.widget.SwipeDismissBehavior;
    import android.support.v4.view.ViewCompat;
    import android.support.v7.app.AppCompatActivity;
    import android.support.v7.widget.RecyclerView;
    import android.support.v7.widget.Toolbar;
    import android.view.View;
    import android.widget.TextView;

    import java.util.ArrayList;
    import java.util.List;
    import java.util.Locale;

    public class MainActivity extends AppCompatActivity implements SwipeDismissBehavior.OnDismissListener, View.OnClickListener {

        private TextView tv;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

//            tv = (TextView) findViewById(R.id.main_tv);

            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.main_recycler);
            List<String> list = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                list.add(String.format(Locale.CHINA,"第%03d行",i));
            }
            MyAdapter adapter = new MyAdapter(list,this);
            recyclerView.setAdapter(adapter);

            Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
            setSupportActionBar(toolbar);

            //        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) tv.getLayoutParams();
    //        SwipeDismissBehavior<TextView> behavior = new SwipeDismissBehavior<>();
    //        behavior.setListener(this);//设置一个监听
    //        params.setBehavior(behavior);//设置一个行为
    //        MyBehavior behavior = new MyBehavior();
    //        params.setBehavior(behavior);

            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.main_fabtn);
            fab.setOnClickListener(this);

            findViewById(R.id.main_ib).setOnClickListener(this);
        }

        @Override
        public void onDismiss(View view) {
            view.setVisibility(View.GONE);
            Snackbar.make(view,"删除了一个控件！",Snackbar.LENGTH_SHORT)
                    .setAction("撤销", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            tv.setVisibility(View.VISIBLE);
                            ViewCompat.animate(tv).alpha(1).start();//把透明度设置为1
                        }
                    }).show();

        }

        @Override
        public void onDragStateChanged(int state) {

        }

        @Override
        public void onClick(View v) {
            Snackbar.make(v,"将跳转到TextInputActivity",Snackbar.LENGTH_SHORT).show();
            startActivity(new Intent(this,TextInputActivity.class));
        }
    }
