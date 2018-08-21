package com.appentus.nutrition;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class adpaterFood extends RecyclerView.Adapter<adpaterFood.MyViewHolder> {

    private final Context context;
    private List<MemberModel> memberModelList;
    private OnItemClicked onClick;

    public interface OnItemClicked {
        void onItemClick(int position);
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName;
        public CircleImageView circleImage,circleImageCustom;
        public LinearLayout cardItemll;

        public MyViewHolder(View view) {
            super(view);
            tvName = (TextView) view.findViewById(R.id.tvName);
            circleImage = (CircleImageView) view.findViewById(R.id.circleImage);
            cardItemll = (LinearLayout) view.findViewById(R.id.cardItemll);
        }
    }


    public adpaterFood(List<MemberModel> memberModelList, Context context) {
        this.memberModelList = memberModelList;
        this.context= context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.add_food_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        MemberModel movie = memberModelList.get(position);

        holder.tvName.setText(movie.getName());

            holder.circleImage.setVisibility(View.VISIBLE);



        //............//
        holder.cardItemll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClick.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return memberModelList.size();
    }


    public void setOnClick(OnItemClicked onClick)
    {
        this.onClick=onClick;
    }
}

