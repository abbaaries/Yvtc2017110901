package nick.yvtc2017110901;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by 58_009 on 2017/11/9.
 */

public class MyAdapter extends BaseAdapter{
    Context context;
    String str[];
    boolean check[];
    public MyAdapter(Context context,String[] str)       //建構值(同名) 創立這個物件 就會執行(
    {
        this.context = context;
        this.str = str;
        check = new boolean[str.length];
    }
    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = new ViewHolder();
        LayoutInflater inflater = LayoutInflater.from(context);




        if(convertView == null){
            convertView = inflater.inflate(R.layout.myitem, null);
            holder.tv =  convertView.findViewById(R.id.textView);
            holder.bt1 =convertView.findViewById(R.id.button);
            holder.cbt = convertView.findViewById(R.id.checkBox);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
        final String msg = str[position];
        holder.bt1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
            }
        });



        holder.cbt.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                check[position]=b;
            }
        });
        holder.cbt.setChecked(check[position]);
        holder.tv.setText(str[position]);
        return convertView;
    }

    static class ViewHolder{
        TextView tv;
        Button bt1;
        CheckBox cbt;
    }

}
