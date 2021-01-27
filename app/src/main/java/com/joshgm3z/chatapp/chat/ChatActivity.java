package com.joshgm3z.chatapp.chat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.widget.EditText;
import android.widget.Toast;

import com.joshgm3z.chatapp.InitApplication;
import com.joshgm3z.chatapp.R;
import com.joshgm3z.chatapp.chat.di.ChatMvpModule;
import com.joshgm3z.chatapp.chat.di.DaggerChatComponent;
import com.joshgm3z.chatapp.chat.view.ChatListAdapter;
import com.joshgm3z.chatapp.common.data.Chat;
import com.joshgm3z.chatapp.common.utils.Logger;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChatActivity extends AppCompatActivity implements ChatContract.View {

    @Inject
    ChatContract.Presenter mPresenter;

    @BindView(R.id.et_message_input)
    EditText mEtMessageInput;

    @BindView(R.id.rv_chat_list)
    RecyclerView mRecyclerViewChatList;

    private ChatListAdapter mChatListAdapter;

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
