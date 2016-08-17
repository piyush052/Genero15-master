package com.dexterous.genero15;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.dexterous.genero15.coreteam.Utils;
import com.dexterous.genero15.coreteam.model.Friend;
import com.squareup.picasso.Picasso;
import com.yalantis.flipviewpager.adapter.BaseFlipAdapter;
import com.yalantis.flipviewpager.utils.FlipSettings;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class CoreTeam extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_core_team);
        final ListView friends = (ListView) findViewById(R.id.friends);
        Toast.makeText(this, "#Think", Toast.LENGTH_LONG).show();
        FlipSettings settings = new FlipSettings.Builder().defaultPage(1).build();
        friends.setAdapter(new FriendsAdapter(this, Utils.friends, settings));

        /*friends.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Friend f = (Friend) friends.getAdapter().getItem(position);

                //Toast.makeText(FriendsActivity.this, f.getNickname(), Toast.LENGTH_SHORT).show();
            }
        });*/
    }


    class FriendsAdapter extends BaseFlipAdapter<Friend> {
        Context context;
        private final int PAGES = 3;
        private int[] IDS_INTEREST = {R.id.interest_1, R.id.interest_4};

        public FriendsAdapter(Context context, List<Friend> items, FlipSettings settings) {
            super(context, items, settings);
            this.context = context;
        }

        @Override
        public View getPage(int position, View convertView, ViewGroup parent, Friend friend1, Friend friend2) {
            final FriendsHolder holder;

            if (convertView == null) {
                holder = new FriendsHolder();
                convertView = getLayoutInflater().inflate(R.layout.friends_merge_page, parent, false);
                holder.leftAvatar = (ImageView) convertView.findViewById(R.id.first);
                holder.rightAvatar = (ImageView) convertView.findViewById(R.id.second);
                holder.infoPage = getLayoutInflater().inflate(R.layout.friends_info, parent, false);
                holder.nickName = (TextView) holder.infoPage.findViewById(R.id.nickname);

                for (int id : IDS_INTEREST)
                    holder.interests.add((TextView) holder.infoPage.findViewById(id));

                convertView.setTag(holder);
            } else {
                holder = (FriendsHolder) convertView.getTag();
            }

            switch (position) {
                // Merged page with 2 friends
                case 1:
//                    holder.leftAvatar.setImageResource(friend1.getAvatar());
                    holder.leftAvatar.setAdjustViewBounds(true);
                    holder.leftAvatar.setScaleType(ImageView.ScaleType.FIT_XY);
//                    holder.leftAvatar.setScaleType(ImageView.ScaleType.FIT_CENTER);
//                    holder.leftAvatar.setAdjustViewBounds(true);
                    Picasso.with(context).load(friend1.getAvatar()).error(R.drawable.user).into(holder.leftAvatar);
                    if (friend2 != null) {
//                        holder.rightAvatar.setImageResource(friend2.getAvatar());
                        holder.rightAvatar.setAdjustViewBounds(true);
                        holder.rightAvatar.setScaleType(ImageView.ScaleType.FIT_XY);
//                        holder.rightAvatar.setAdjustViewBounds(true);
//                        holder.rightAvatar.setScaleType(ImageView.ScaleType.FIT_CENTER);
                        Picasso.with(context).load(friend2.getAvatar()).error(R.drawable.user).into(holder.rightAvatar);
                    }
                    break;
                default:
                    fillHolder(holder, position == 0 ? friend1 : friend2);
                    holder.infoPage.setTag(holder);
                    return holder.infoPage;
            }
            return convertView;
        }

        @Override
        public int getPagesCount() {
            return PAGES;
        }

        private void fillHolder(FriendsHolder holder, Friend friend) {
            if (friend == null)
                return;
            Iterator<TextView> iViews = holder.interests.iterator();
            Iterator<String> iInterests = friend.getInterests().iterator();
            while (iViews.hasNext() && iInterests.hasNext())
                iViews.next().setText(iInterests.next());
            holder.infoPage.setBackgroundColor(getResources().getColor(friend.getBackground()));
            holder.nickName.setText(friend.getNickname());
        }

        class FriendsHolder {
            ImageView leftAvatar;
            ImageView rightAvatar;
            View infoPage;

            List<TextView> interests = new ArrayList<>();
            TextView nickName;
        }
    }
}
