package pei.yc.test;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolBar;
    private ShareActionProvider mShareActionProvider;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mActionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolBar = (Toolbar) findViewById(R.id.toolbar);
        mToolBar.setLogo(R.mipmap.ic_launcher);
        mToolBar.setTitle("主标");
        mToolBar.setSubtitle("副标");
        setSupportActionBar(mToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mActionBarDrawerToggle = new ActionBarDrawerToggle(
                this,mDrawerLayout,mToolBar,R.string.abc_action_bar_home_description,R.string.abc_action_bar_home_description_format){
            @Override
            public void onDrawerOpened(View drawerView) {
//                mToolBar.setNavigationIcon(R.drawable.ic_account);
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
//                mToolBar.setNavigationIcon(R.drawable.ic_polymer);
                super.onDrawerClosed(drawerView);
            }
        };
        mActionBarDrawerToggle.syncState();
//        mToolBar.setNavigationIcon(R.drawable.ic_polymer);
        mDrawerLayout.setDrawerListener(mActionBarDrawerToggle);
        mToolBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_settings:
                        Toast.makeText(MainActivity.this,"action setting",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.action_gettings:
                        Toast.makeText(MainActivity.this,"action getting",Toast.LENGTH_LONG).show();
                        break;
                    default:
                        break;
                }
                return true;

            }
        });
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"navigater is clicked!",Toast.LENGTH_SHORT).show();
                if(mDrawerLayout.isDrawerOpen(Gravity.START)){
                    mDrawerLayout.closeDrawer(Gravity.START);
                }else{
                    mDrawerLayout.openDrawer(Gravity.START);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        mShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menu.findItem(R.id.action_share));
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/*");
        mShareActionProvider.setShareIntent(intent);
        return super.onCreateOptionsMenu(menu);
    }
}
