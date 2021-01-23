package w2.jan29th.groupchat;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;
import java.util.List;

public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.ViewHolder> {
    private List<Group> mGroupList;
    private Context mContext;

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView groupImage;
        TextView groupName;
        TextView groupCreator;
        CardView cardView;

        public ViewHolder(View view) {
            super(view);
            groupImage = (ImageView) view.findViewById(R.id.group_image);
            groupName = (TextView) view.findViewById(R.id.group_name);
            groupCreator = (TextView) view.findViewById(R.id.group_creator);
            cardView=(CardView)view.findViewById(R.id.card_view);
        }
    }

    public GroupAdapter(Context context, List<Group> groupList) {
        mGroupList = groupList;
        mContext=context;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.group_item, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Group group = mGroupList.get(position);
        holder.groupImage.setImageResource(group.getImageId());
        holder.groupName.setText(group.getName());
        holder.groupCreator.setText(group.getCreator());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(mContext,DetailActivity.class);
                        intent.putExtra("group_name",group.getName());
                        intent.putExtra("creator",group.getCreator());
                        intent.putExtra("head",group.getImageId());
                        mContext.startActivity (intent);

                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return mGroupList.size();
    }

}
