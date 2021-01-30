package com.joshgm3z.chatapp.pages.home.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.joshgm3z.chatapp.R;
import com.joshgm3z.chatapp.common.data.HomeItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeListAdapter extends RecyclerView.Adapter<HomeListAdapter.HomeChatViewHolder> {

    private List<HomeItem> mHomeItemList;

    private HomeListClickListener mListener;

    public HomeListAdapter(HomeListClickListener listener) {
        mListener = listener;
    }

    public void updateList(List<HomeItem> chatList) {
        mHomeItemList = chatList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HomeChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_home_chat_list, parent, false);
        return new HomeChatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeChatViewHolder holder, int position) {
        holder.setData(mHomeItemList.get(position));
    }

    @Override
    public int getItemCount() {
        return mHomeItemList != null ? mHomeItemList.size() : 0;
    }

    public class HomeChatViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.tv_home_chat_sender)
        TextView mTvSender;

        @BindView(R.id.tv_home_chat_message)
        TextView mTvMessage;

        @BindView(R.id.tv_unread_chat_count)
        TextView mTvUnreadCounter;

        @BindView(R.id.iv_sender_profile_pic)
        ImageView mIvSenderPic;

        private String mChatUser;

        private HomeChatViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        private void setData(HomeItem homeItem) {
            mChatUser = homeItem.getUsername();
            mTvSender.setText(homeItem.getUsername());
            mTvMessage.setText(homeItem.getMessage());
            if (homeItem.getCounter() > 0) {
                mTvUnreadCounter.setVisibility(View.VISIBLE);
                mTvUnreadCounter.setText(homeItem.getCounter() + "");
            } else {
                mTvUnreadCounter.setVisibility(View.INVISIBLE);
            }
        }

        @Override
        public void onClick(View view) {
            mListener.onHomeItemClick(mChatUser);
        }
    }

    public interface HomeListClickListener {
        void onHomeItemClick(String chatUser);
    }

}
