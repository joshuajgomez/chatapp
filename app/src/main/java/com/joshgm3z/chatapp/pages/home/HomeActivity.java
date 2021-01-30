package com.joshgm3z.chatapp.pages.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.joshgm3z.chatapp.InitApplication;
import com.joshgm3z.chatapp.R;
import com.joshgm3z.chatapp.common.data.HomeItem;
import com.joshgm3z.chatapp.common.utils.Logger;
import com.joshgm3z.chatapp.pages.chat.ChatActivity;
import com.joshgm3z.chatapp.pages.home.di.DaggerHomeComponent;
import com.joshgm3z.chatapp.pages.home.di.HomeMvpModule;
import com.joshgm3z.chatapp.pages.home.view.HomeListAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity implements HomeContract.View, HomeListAdapter.HomeListClickListener {

    @Inject
    HomeContract.Presenter mPresenter;

    @BindView(R.id.rv_home_list)
    RecyclerView mRecyclerViewHomeList;

    private HomeListAdapter mHomeListAdapter;

    public static void launch(Context context) {
        context.startActivity(new Intent(context, HomeActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        DaggerHomeComponent.builder()
                .appComponent(InitApplication.getInstance(this).getAppComponent())
                .homeMvpModule(new HomeMvpModule(this))
                .build()
                .inject(this);

        initView();
    }

    private void initView() {
        ButterKnife.bind(this);
        mHomeListAdapter = new HomeListAdapter(this);
        mRecyclerViewHomeList.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerViewHomeList.setAdapter(mHomeListAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onActivityResume();
    }

    @Override
    public void updateList(List<HomeItem> chatList) {
        Logger.log("chatList = [" + chatList + "]");
        mHomeListAdapter.updateList(chatList);
        if (!chatList.isEmpty()) {
            mRecyclerViewHomeList.scrollToPosition(chatList.size() - 1);
        }
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    @Override
    public void onHomeItemClick(String chatUser) {
        ChatActivity.launch(this, chatUser);
    }
}
