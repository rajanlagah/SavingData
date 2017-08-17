package com.exapmle.rajan.savingdata;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by rajan on 16-08-2017.
 */

public class adapter extends RecyclerView.Adapter<adapter.viewHolder>{

    public int pole[];
    public String s="";
    public Context mContext;
    public adapter(){}
    public int temp;

    public adapter(int arr[],Context context){
        pole=arr;
        mContext=context;
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter,parent,false);
        viewHolder vh = new viewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(viewHolder holder, int position) {
    holder.BindHour(pole[position],position);
        if(temp!=0)
        pole[position]=temp;
     //   MainActivity.score[position]=position;//=temp;
    }

    @Override
    public int getItemCount() {
        return pole.length;
    }

public class viewHolder extends RecyclerView.ViewHolder {

    TextView score;
    TextView poleNumber;
    Button add;
    Button subtract;
    int pos;
    public viewHolder(View itemView) {
        super(itemView);
        score=(TextView)itemView.findViewById(R.id.score);
        poleNumber=(TextView)itemView.findViewById(R.id.poleNumber);
        add=(Button)itemView.findViewById(R.id.add);
        subtract=(Button)itemView.findViewById(R.id.subtract);
        pos=0;

    }
    public void BindHour(int run, final int position){
            pos=position;
            score.setText(pole[position]+"");
            poleNumber.setText("Pole "+position);

            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    score.setText((Integer.parseInt(score.getText().toString())+1)+"");
                    pole[position]=(Integer.parseInt(score.getText().toString()));
                }
            });

            subtract.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    score.setText((Integer.parseInt(score.getText().toString())-1)+"");
                    pole[position]=(Integer.parseInt(score.getText().toString()));
                }
            });

    }

}
}
