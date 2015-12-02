package net.gfdz.com.drawerlayoutdemo;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import net.gfdz.com.drawerlayoutdemo.bean.LeftMenu;
import net.gfdz.com.drawerlayoutdemo.fragment.ContentFragment;
import net.gfdz.com.drawerlayoutdemo.utils.CommonAdapter;
import net.gfdz.com.drawerlayoutdemo.utils.ViewHolder;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ArrayList<LeftMenu> menuLists;
    private CommonAdapter adapter;
    private ActionBarDrawerToggle mDrawerToggle;
    private String mTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTitle=(String)getTitle();
        initDatas();
        initViews();



    }
    private void initDatas(){
        menuLists = new ArrayList<>();

        LeftMenu mLeftMenu = new LeftMenu();
        mLeftMenu.setTitle("极客学院1");
        mLeftMenu.setIc(R.drawable.ic_action_add);
        menuLists.add(mLeftMenu);


        LeftMenu mLeftMenu2 = new LeftMenu();
        mLeftMenu2.setTitle("极客学院2");
        mLeftMenu2.setIc(R.drawable.ic_action_alarm);
        menuLists.add(mLeftMenu2);

        LeftMenu mLeftMenu3 = new LeftMenu();
        mLeftMenu3.setTitle("极客学院3");
        mLeftMenu3.setIc(R.drawable.ic_action_amazon);
        menuLists.add(mLeftMenu3);

        LeftMenu mLeftMenu4 = new LeftMenu();
        mLeftMenu4.setTitle("极客学院4");
        mLeftMenu4.setIc(R.drawable.ic_action_anchor);
        menuLists.add(mLeftMenu4);

        LeftMenu mLeftMenu5 = new LeftMenu();
        mLeftMenu5.setTitle("极客学院5");
        mLeftMenu5.setIc(R.drawable.ic_action_achievement);
        menuLists.add(mLeftMenu5);
        adapter = new CommonAdapter(this, menuLists, R.layout.cell) {
            @Override
            public void conver(ViewHolder holder, Object o) {
                ((TextView) holder.getView(R.id.tv01)).setText(((LeftMenu) o).getTitle());
                ((ImageView)holder.getView(R.id.iv01)).setImageResource(((LeftMenu) o).getIc());
            }
        };
        mDrawerToggle =new ActionBarDrawerToggle(this,mDrawerLayout,R.drawable.ic_action_list,R.string.drawer_open,R.string.drawer_close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);

            }
        };
    }
    private void initViews(){
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        mDrawerList.setAdapter(adapter);
        mDrawerList.setOnItemClickListener(this);

    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //动态插入一个Fragment 到FramentLayou中
        Fragment contentFragment = new ContentFragment();
        Bundle args = new Bundle();
        args.putString("text", menuLists.get(position).getTitle());
        contentFragment.setArguments(args);
        FragmentManager fm = getFragmentManager();
        fm.beginTransaction().replace(R.id.content_frame, contentFragment).commit();
        mDrawerLayout.closeDrawer(mDrawerList);

    }
}
