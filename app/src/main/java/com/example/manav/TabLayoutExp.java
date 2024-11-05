package com.example.manav;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class TabLayoutExp extends AppCompatActivity {

    private Toolbar toolbar;

TabLayout tabsView;
ViewPager views;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layoutexp);
        toolbar=findViewById(R.id.my_toolbar);
       tabsView=findViewById(R.id.tabLayout);
        views=findViewById(R.id.viewPager);
        MyAdapter adapter=new MyAdapter(getSupportFragmentManager());
        views.setAdapter(adapter);
         tabsView.setupWithViewPager(views);
        setSupportActionBar(toolbar);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.dropmenu,menu);
        MenuItem.OnActionExpandListener onActionExpandListener=new MenuItem.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(@NonNull MenuItem menuItem) {
                Toast.makeText(TabLayoutExp.this,"Search is Expanded",Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onMenuItemActionCollapse(@NonNull MenuItem menuItem) {
                Toast.makeText(TabLayoutExp.this,"Search is collapse",Toast.LENGTH_SHORT).show();
                return false;
            }
        } ;
menu.findItem(R.id.item5).setOnActionExpandListener(onActionExpandListener);
SearchView searchView=(SearchView) menu.findItem(R.id.item5).getActionView();
searchView.setQueryHint("Search");
        return super.onCreateOptionsMenu(menu);
    }
}