package com.uniarcadia.pixaclubapp.Profile;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.uniarcadia.pixaclubapp.R;

public class ProfileActivity extends AppCompatActivity {

    private static final String TAG = "ProfileActivity";
    private static final int ACTIVITY_NUM = 4;
    private static final int NUM_GRID_COLUMNS = 3;
    private Context mContext = ProfileActivity.this;
    private ProgressBar mProgressBar;
    private ImageView profileImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Log.d(TAG, "onCreate: starting.");

        init();

//        setupBottomNavigationView();
//        setupToolBar();
//        setupActivityWidgets();
//        setProfileImage();
//        tempGridSetup();
    }

    private void init(){
        Log.d(TAG, "init: inflating "+  getString(R.string.profile_fragment));

        ProfileFragment fragment = new ProfileFragment();
        FragmentTransaction transaction = ProfileActivity.this.getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container,  fragment);
        transaction.addToBackStack(getString(R.string.profile_fragment));
        transaction.commit();
    }

//    private void tempGridSetup() {
//        ArrayList<String> imageURIs = new ArrayList<>();
//        imageURIs.add("https://upload.wikimedia.org/wikipedia/en/0/02/Homer_Simpson_2006.png");
//        imageURIs.add("https://upload.wikimedia.org/wikipedia/en/0/0b/Marge_Simpson.png");
//        imageURIs.add("https://upload.wikimedia.org/wikipedia/en/a/aa/Bart_Simpson_200px.png");
//        imageURIs.add("https://upload.wikimedia.org/wikipedia/en/e/ec/Lisa_Simpson.png");
//        imageURIs.add("https://upload.wikimedia.org/wikipedia/en/9/9d/Maggie_Simpson.png");
//        imageURIs.add("https://upload.wikimedia.org/wikipedia/en/thumb/f/f8/Patty_Bouvier.png/195px-Patty_Bouvier.png");
//        imageURIs.add("https://upload.wikimedia.org/wikipedia/en/thumb/b/ba/Selma_Bouvier.png/198px-Selma_Bouvier.png");
//        imageURIs.add("https://upload.wikimedia.org/wikipedia/en/8/84/Ned_Flanders.png");
//
//        setUpImageGrid(imageURIs);
//    }
//
//    private void setUpImageGrid(ArrayList<String> imageURIs) {
//        GridView gridView = findViewById(R.id.gridView);
//
//        int gridWidth = getResources().getDisplayMetrics().widthPixels;
//        int imageWidth = gridWidth/NUM_GRID_COLUMNS;
//        gridView.setColumnWidth(imageWidth);
//
//
//        GridImageAdapter adapter = new GridImageAdapter(mContext, R.layout.layout_grid_imageview, "", imageURIs);
//        gridView.setAdapter(adapter);
//    }
//
//    private void setProfileImage(){
//        Log.d(TAG, "setProfileImage: Setting profile image");
//        String imageURI = "st1.bgr.in/wp-content/uploads/2017/05/android-google-io-2017.jpg";
//        UniversalImageLoader.setImage(imageURI, profileImage, mProgressBar, "https://");
//    }
//
//    private void setupActivityWidgets() {
//        mProgressBar = findViewById(R.id.profileProgressBar);
//        mProgressBar.setVisibility(View.GONE);
//
//        profileImage = findViewById(R.id.profileImage);
//    }
//
//    private void setupToolBar() {
//        Toolbar toolbar = findViewById(R.id.profileToolbar);
//        setSupportActionBar(toolbar);
//
//        ImageView profileMenu = findViewById(R.id.profileMenu);
//        profileMenu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d(TAG, "onClick: Navigating to Account Options");
//                Intent intent = new Intent(mContext, AccountOptionsActivity.class);
//                startActivity(intent);
//            }
//        });
//    }
//
//    private void setupBottomNavigationView() {
//        Log.d(TAG, "setupBottomNavigationView: settting up BottomNavigationView");
//        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);
//        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
//        BottomNavigationViewHelper.enableNavigation(mContext, bottomNavigationViewEx);
//        Menu menu = bottomNavigationViewEx.getMenu();
//        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
//        menuItem.setChecked(true);
//    }

}
