package Adapters;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Ofek on 15-Nov-17.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyVH> {
    int count;
    int selectedCount;
    public ListAdapter(int count) {
        this.count = count;
        selectedCount=0;
    }

    @Override
    public ListAdapter.MyVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1,parent,false);
        return new MyVH(view);
    }

    @Override
    public void onBindViewHolder(ListAdapter.MyVH holder, int position) {
        int colorId=Color.RED;
        switch (position%3){
            case 0:{
                colorId= Color.BLACK;
                break;
            }
            case 1:{
                colorId= Color.GRAY;
                break;
            }
            case 2:{
                colorId= Color.GREEN;
                break;
            }
        }
        holder.itemView.setBackgroundColor(colorId);
        holder.textView.setText(""+position);
    }

    @Override
    public int getItemCount() {
        return count;
    }

    public class MyVH extends RecyclerView.ViewHolder {
        TextView textView;
        public MyVH(final View itemView) {
            super(itemView);
            textView=itemView.findViewById(android.R.id.text1);
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    itemView.setBackgroundColor(Color.WHITE);
                    selectedCount++;
                    return true;
                }
            });
        }
    }
    public int getSaveCount(){
        return count-selectedCount;
    }
}
