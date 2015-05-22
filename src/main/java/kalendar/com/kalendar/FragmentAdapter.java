package kalendar.com.kalendar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.Locale;

import kalendar.com.kalendar.map.PlaceHolderMap;

/**
 * Created by César on 12/05/2015.
 */
public class FragmentAdapter extends FragmentPagerAdapter {

    public FragmentAdapter(FragmentManager fm)
    {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        if(position == 0) {
            return new PlaceHolderMap();
        }
        return new PlaceHolderFragment();
    }

    @Override
    public int getCount() {
        return 4;
    }


}
