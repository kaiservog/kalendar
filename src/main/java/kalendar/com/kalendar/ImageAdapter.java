package kalendar.com.kalendar;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import kalendar.com.kalendar.detail.Point;

/**
 * Created by César on 12/05/2015.
 */
public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater inflater;
    private List<Point> points = new ArrayList<Point>();

    public ImageAdapter(Context c) {
        mContext = c;
        inflater = LayoutInflater.from(c);

        points.add(new Point("1", R.drawable.sample_0));
        points.add(new Point("2", R.drawable.sample_1));
        points.add(new Point("3", R.drawable.sample_2));
        points.add(new Point("4", R.drawable.sample_3));
        points.add(new Point("5", R.drawable.sample_4));
        points.add(new Point("6", R.drawable.sample_5));
        points.add(new Point("7", R.drawable.sample_6));
        points.add(new Point("8", R.drawable.sample_7));
        points.add(new Point("9", R.drawable.sample_0));
        points.add(new Point("10", R.drawable.sample_1));
        points.add(new Point("11", R.drawable.sample_2));
        points.add(new Point("12", R.drawable.sample_3));
        points.add(new Point("13", R.drawable.sample_4));
    }

    public int getCount() {
        return points.size();
    }

    public Object getItem(int position) {
        return points.get(position);
    }

    public long getItemId(int position) {
        return points.get(position).getDrawableId();
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null) {
            itemView = inflater.inflate(R.layout.grid_item, parent, false);
        }

        TextView tv = (TextView) itemView.findViewById(R.id.grid_item_text);
        tv.setText("Name " + position);

        //ImageView ii = (ImageView) itemView.findViewById(R.id.grid_item_icon);
        //ii.setImageResource(R.drawable.hot);

        ImageView imgv = (ImageView) itemView.findViewById(R.id.grid_item_image);
        imgv.setImageResource(points.get(position).getDrawableId());
        return itemView;
    }
}