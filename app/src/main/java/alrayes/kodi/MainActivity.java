package alrayes.kodi;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    FragmentTransaction fragmentTransaction;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        //set tool bar
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //DrawerLayout
         drawerLayout= (DrawerLayout) findViewById(R.id.drawer_layout);
         drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_OPEN); //DrawerLayout permanently open

   /*     //display Entertament Fragment when it run in fram
        fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.main_container,new MovieFragment());
        fragmentTransaction.commit();
*/

        navigationView= (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.movie_icon:
                       /* fragmentTransaction=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container,new MovieFragment());
                        fragmentTransaction.commit();
                        */
                        Intent myIntent = new Intent(MainActivity.this ,MovieType.class);
                        startActivity(myIntent);
                        item.setChecked(true);

                        break;

                    case R.id.tv_icon:
                        fragmentTransaction=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container,new TvFragment());
                        fragmentTransaction.commit();
                        item.setChecked(true);
                       // drawerLayout.closeDrawers();  // to close the drawer after selection
                        break;



                }

                return true;
            }
        });

        // getSupportActionBar().setTitle("Home Fragment.....");  // to dispaly text in toolbar
        //actionBarDrawerToggle= new ActionBarDrawerToggle(this,drawerLayout,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        // drawerLayout.addDrawerListener(actionBarDrawerToggle);
    }

    /*@Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();

    }*/
}
