package com.example.drawer_activity_lab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.internal.ToolbarUtils;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout mDrawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //UI
        mDrawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        //Mostrar un fragmento predeterminado
        getSupportFragmentManager().beginTransaction().add(R.id.content, new HomeFragment()).commit();
        setTitle("Home");

        //Setup Toolbar
        //setSupportActionBar(toolbar);


        navigationView.setNavigationItemSelectedListener(this);
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        selectItemNav(item);
        return true;
    }

    private void selectItemNav(MenuItem item) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        switch (item.getItemId()){
            case R.id.nav_home:
                ft.replace(R.id.content, new HomeFragment()).commit();
                break;
            case R.id.nav_profile:
                ft.replace(R.id.content, new ProfileFragment()).commit();
                break;
            case R.id.nav_event:
                ft.replace(R.id.content, new EventFragment()).commit();
                break;
            case R.id.nav_notification:
                ft.replace(R.id.content, new NotificationFragment()).commit();
                break;
            case R.id.nav_contact:
                ft.replace(R.id.content, new ContactFragment()).commit();
                break;

        }
        setTitle(item.getTitle());
        //Para que se oculte el navigation Drawer
        mDrawerLayout.closeDrawers();

    }
}