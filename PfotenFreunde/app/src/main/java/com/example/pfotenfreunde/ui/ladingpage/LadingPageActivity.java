package com.example.pfotenfreunde.ui.ladingpage;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.pfotenfreunde.R;
import com.example.pfotenfreunde.ui.fragment.friend.Friendlist;
import com.example.pfotenfreunde.ui.fragment.feed.Feed;
import com.example.pfotenfreunde.ui.fragment.friend.requests.OpenRequests;
import com.example.pfotenfreunde.ui.fragment.institution.InstitutionProfile;
import com.example.pfotenfreunde.ui.fragment.message.MessageList;
import com.example.pfotenfreunde.ui.fragment.pet.ListPetprofile;
import com.example.pfotenfreunde.ui.fragment.search.Search;
import com.google.android.material.navigation.NavigationView;


public class LadingPageActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private NavigationView navigationView;
    private Toolbar toolbar;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ladingpage);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);
        drawerLayout = findViewById(R.id.landingpage);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.setDrawerIndicatorEnabled(true);
        drawerToggle.syncState();
        replaceFragment(new Feed());

    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.userProfilBtn){
            replaceFragment(new InstitutionProfile());
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        if(v.getId() == R.id.open_friend_requests){
            replaceFragment(new OpenRequests());
            drawerLayout.closeDrawer(GravityCompat.START);
        }

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.nav_friend){
            replaceFragment(new Friendlist());
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else if(item.getItemId() == R.id.nav_petprofil){
            replaceFragment(new ListPetprofile());
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else if(item.getItemId() == R.id.nav_search){
            replaceFragment(new Search());
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else if(item.getItemId() == R.id.nav_message){
            replaceFragment(new MessageList());
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else if (item.getItemId() == R.id.nav_home){
            replaceFragment(new Feed());
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        return false;
    }

    public void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.container_fragment, fragment)
                .commit();
    }

}
