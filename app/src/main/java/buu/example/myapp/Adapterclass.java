package buu.example.myapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapterclass extends RecyclerView.Adapter<Adapterclass.MyViewHolder>{
ArrayList<BOOK>list;

    public Adapterclass(ArrayList<BOOK>list){
        this.list = list;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup , int i) {
        View view  = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_listlibrary,viewGroup,
                false) ;
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
    myViewHolder.id.setText(list.get(i).getBOOKID());
    myViewHolder.desc.setText(list.get(i).getANTHOR());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView id,desc;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            id = itemView.findViewById(R.id.Title_text);
            desc = itemView.findViewById(R.id.description);

        }
    }
}
