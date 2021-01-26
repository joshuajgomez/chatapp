package com.joshgm3z.chatapp.chat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.widget.EditText;

import com.joshgm3z.chatapp.InitApplication;
import com.joshgm3z.chatapp.R;
import com.joshgm3z.chatapp.chat.di.ChatMvpModule;
import com.joshgm3z.chatapp.chat.di.DaggerChatComponent;
import com.joshgm3z.chatapp.common.data.Chat;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChatActivity extends AppCompatActivity implements ChatContract.View{

    @Inject
    ChatContract.Presenter mPresenter;

    @BindView(R.id.et_message_input)
    EditText mEtMessageInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        DaggerChatComponent.builder()
                .appComponent(InitApplication.getInstance(this).getAppComponent())
                .chatMvpModule(new ChatMvpModule(this))
                .build()
                .inject(this);

        ButterKnife.bind(this);
    }

    @Override
    public void updateChatList(List<Chat> chatList) {

    }

    @OnClick(R.id.btn_send)
    void onClick(){
        Editable text = mEtMessageInput.getText();
        if (text != null && !text.toString().trim().isEmpty()) {
            String message = text.toString().trim();

            mPresenter.onSendButtonClick(message);
        }
    }
}
