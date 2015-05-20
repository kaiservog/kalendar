package kalendar.com.kalendar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import kalendar.com.kalendar.detail.DetailActivity;

/**
 * Created by César on 12/05/2015.
 */
public class PlaceHolderFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";

    public PlaceHolderFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.frag_main, container, false);

        GridView gridView = (GridView) rootView.findViewById(R.id.gridview);
        gridView.setAdapter(new ImageAdapter(MainActivity.ma));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Intent changeToDetail = new Intent(getActivity(), DetailActivity.class);
                changeToDetail.putExtra("index", 0);
                Toast.makeText(MainActivity.ma, "" + position,
                        Toast.LENGTH_SHORT).show();

                getActivity().startActivity(changeToDetail);
               // MainActivity.ma.finish();
            }
        });

        return rootView;
    }
}
