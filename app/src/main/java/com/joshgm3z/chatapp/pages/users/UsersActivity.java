package com.joshgm3z.chatapp.pages.users;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.joshgm3z.chatapp.InitApplication;
import com.joshgm3z.chatapp.R;
import com.joshgm3z.chatapp.common.data.User;
import com.joshgm3z.chatapp.pages.chat.ChatActivity;
import com.joshgm3z.chatapp.pages.home.HomeActivity;
import com.joshgm3z.chatapp.pages.users.di.DaggerUsersComponent;
import com.joshgm3z.chatapp.pages.users.di.UsersMvpModule;
import com.joshgm3z.chatapp.pages.users.view.UsersListAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UsersActivity extends AppCompatActivity implements UsersContract.View,
        UsersListAdapter.UsersListClickListener {

    @Inject
    UsersContract.Presenter mPresenter;

    @BindView(R.id.rv_users_list)
    RecyclerView mRvUsersList;

    private UsersListAdapter mUsersListAdapter;

    public static void launch(Context context) {
        context.startActivity(new Intent(context, UsersActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        DaggerUsersComponent.builder()
                .appComponent(InitApplication.getInstance(this).getAppComponent())
                .usersMvpModule(new UsersMvpModule(this))
                .build()
                .inject(this);

        initView();
    }

    private void initView() {
        ButterKnife.bind(this);
        mUsersListAdapter = new UsersListAdapter(this);
        mRvUsersList.setLayoutManager(new LinearLayoutManager(this));
        mRvUsersList.setAdapter(mUsersListAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onActivityResume();
    }

    @Override
    public void updateList(List<User> userList) {
        mUsersListAdapter.setUserList(userList);
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUserListClicked(String username) {
        ChatActivity.launch(this, username);
    }
}
