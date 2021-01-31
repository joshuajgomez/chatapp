package com.joshgm3z.chatapp.pages.users.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.joshgm3z.chatapp.R;
import com.joshgm3z.chatapp.common.data.User;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UsersListAdapter extends RecyclerView.Adapter<UsersListAdapter.UsersListViewHolder> {

    private List<User> mUserList;

    private UsersListClickListener mListener;

    public UsersListAdapter(UsersListClickListener listener) {
        mListener = listener;
    }

    public void setUserList(List<User> userList) {
        mUserList = userList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UsersListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_users_list, parent, false);
        return new UsersListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersListViewHolder holder, int position) {
        holder.setData(mUserList.get(position));
    }

    @Override
    public int getItemCount() {
        return mUserList != null ? mUserList.size() : 0;
    }

    public class UsersListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.iv_users_list_pic)
        ImageView mIvUsersListPic;

        @BindView(R.id.tv_users_list_name)
        TextView mTvUsersListName;

        private User mUser;

        public UsersListViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        public void setData(User user) {
            mUser = user;
            mTvUsersListName.setText(user.getUsername());
        }

        @Override
        public void onClick(View view) {
            mListener.onUserListClicked(mUser.getUsername());
        }
    }

    public interface UsersListClickListener {

        void onUserListClicked(String username);
    }
}
