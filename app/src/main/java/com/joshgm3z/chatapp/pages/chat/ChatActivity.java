package com.joshgm3z.chatapp.pages.chat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.widget.EditText;
import android.widget.Toast;

import com.joshgm3z.chatapp.InitApplication;
import com.joshgm3z.chatapp.R;
import com.joshgm3z.chatapp.pages.chat.di.ChatMvpModule;
import com.joshgm3z.chatapp.pages.chat.di.DaggerChatComponent;
import com.joshgm3z.chatapp.pages.chat.view.ChatListAdapter;
import com.joshgm3z.chatapp.common.data.Chat;
import com.joshgm3z.chatapp.common.utils.Logger;
import com.joshgm3z.chatapp.pages.home.HomeActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChatActivity extends AppCompatActivity implements ChatContract.View {

    private static final String CHAT_USER = "CHAT_USER";

    @Inject
    ChatContract.Presenter mPresenter;

    @BindView(R.id.et_message_input)
    EditText mEtMessageInput;

    @BindView(R.id.rv_chat_list)
    RecyclerView mRecyclerViewChatList;

    private ChatListAdapter mChatListAdapter;

    public static void launch(Context context, String chatUser) {
        Intent intent = new Intent(context, ChatActivity.class);
        intent.putExtra(CHAT_USER, chatUser);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        DaggerChatComponent.builder()
                .appComponent(InitApplication.getInstance(this).getAppComponent())
                .chatMvpModule(new ChatMvpModule(this))
                .build()
                .inject(this);

        initView();
    }

    private void initView() {
        ButterKnife.bind(this);
        mChatListAdapter = new ChatListAdapter();
        mRecyclerViewChatList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerViewChatList.setAdapter(mChatListAdapter);

        Intent intent = getIntent();
        if (intent.hasExtra(CHAT_USER)) {
            String chatUser = intent.getStringExtra(CHAT_USER);
            mPresenter.setChatUser(chatUser);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.refreshView();
    }

    @Override
    public void updateChatList(List<Chat> chatList) {
        mChatListAdapter.setChatList(chatList);
        if (!chatList.isEmpty()) {
            mRecyclerViewChatList.scrollToPosition(chatList.size() - 1);
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

    @OnClick(R.id.btn_send)
    void onClick() {
        Logger.entryLog();

        Editable text = mEtMessageInput.getText();
        if (text != null && !text.toString().trim().isEmpty()) {
            String message = text.toString().trim();

            mPresenter.onSendButtonClick(message);
            mEtMessageInput.setText("");
        }
    }
}
