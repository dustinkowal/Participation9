package com.example.participation9;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("*/*");
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Hey Study M8");
                if (emailIntent.resolveActivity(getPackageManager()) != null){
                    startActivity(emailIntent);
                }
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            settings();
            return true;
        }
        if (id == R.id.action_email) {
            email();
            return true;
        }
        if (id == R.id.action_add) {
            add();
            return true;
        }
        if (id == R.id.action_delete) {
            delete();
            return true;
        }
        if (id == R.id.action_sms) {
            sms();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.action_add) {
            add();
        } else if (id == R.id.action_delete) {
            delete();
        } else if (id == R.id.action_email) {
            email();
        } else if (id == R.id.action_settings) {
            settings();
        } else if (id == R.id.action_sms) {
            sms();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void add() {
        Snackbar.make(findViewById(android.R.id.content), "Add a Study Mate not implemented", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
    public void delete() {
        Snackbar.make(findViewById(android.R.id.content), "Deleting a Study Mate not implemented", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
    public void settings() {
        Intent settingIntent = new Intent(this, SettingsActivity.class);
        startActivity(settingIntent);
    }
    public void email() {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setType("*/*");
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Hey Study M8");
        if (emailIntent.resolveActivity(getPackageManager()) != null){
            startActivity(emailIntent);
        }
    }
    public void sms() {
        Uri uri = Uri.parse("smsto:6129659104");
        Intent smsIntent = new Intent(Intent.ACTION_SEND);
        smsIntent.setData(Uri.parse("smsto:"));  // This ensures only SMS apps respond
        smsIntent.putExtra("sms_body", "I can't study today");
        if (smsIntent.resolveActivity(getPackageManager()) != null){
            startActivity(smsIntent);
        }
    }
}
