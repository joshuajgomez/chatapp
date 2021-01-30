package com.joshgm3z.chatapp.pages.chat.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.joshgm3z.chatapp.R;
import com.joshgm3z.chatapp.common.data.Chat;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChatListAdapter extends RecyclerView.Adapter<ChatListAdapter.ChatListViewHolder> {

    private List<Chat> mChatList;

    public ChatListAdapter() {
    }

    public void setChatList(List<Chat> mChatList) {
        this.mChatList = mChatList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ChatListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_chat_list, parent, false);
        return new ChatListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatListViewHolder holder, int position) {
        holder.setData(mChatList.get(position));
    }

    @Override
    public int getItemCount() {
        return mChatList != null ? mChatList.size() : 0;
    }

    public class ChatListViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_chat_item_message)
        TextView mTvChatMessage;

        public ChatListViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void setData(Chat chat) {
            mTvChatMessage.setText(chat.getMessage() + "");
        }
    }
}
