package kalendar.com.kalendar;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;


public class MainActivity extends ActionBarActivity  {

    private FragmentAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    static MainActivity ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ma = MainActivity.this;

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        ActionBar.TabListener tabListener = new ActionBar.TabListener() {
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
                mViewPager.setCurrentItem(tab.getPosition());
            }
            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {}
            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {}
        };

        mSectionsPagerAdapter = new FragmentAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setOnPageChangeListener(
                new ViewPager.SimpleOnPageChangeListener() {
                    @Override
                    public void onPageSelected(int position) {
                        getSupportActionBar().setSelectedNavigationItem(position);
                    }
                });

        for (Integer i = 0; i < 3; i++) {
            String tabName = "";
            Calendar now = Calendar.getInstance();
            if(i.equals(0)){
                tabName = new String("Hoje");
            } else {
                now.add(Calendar.DAY_OF_MONTH, i);
                tabName = now.get(Calendar.DAY_OF_MONTH) + "/" + now.get(Calendar.MONTH);
            }

            actionBar.addTab(
                    actionBar.newTab()
                            .setText(tabName)
                            .setTabListener(tabListener));
        }
    }
}
