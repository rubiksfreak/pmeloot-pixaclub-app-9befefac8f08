package com.uniarcadia.pixaclubapp.Share;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.uniarcadia.pixaclubapp.R;
import com.uniarcadia.pixaclubapp.util.FirebaseHelper;
import com.uniarcadia.pixaclubapp.util.UniversalImageLoader;

public class ConfirmShareActivity extends AppCompatActivity {
    private static final String TAG = "ConfirmShareActivity";

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mRef;
    private FirebaseHelper helper;

    private EditText mCaption;
    private String imageURL;
    private Bitmap bitmap;
    private Intent intent;

    private String mAppend = "file:/";
    private int imageCount = 0;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_share);
        helper = new FirebaseHelper(ConfirmShareActivity.this);
        mCaption = findViewById(R.id.caption);

        setupFireBaseAuth();


        ImageView backArrow = findViewById(R.id.backArrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Closing activity.");
                finish();
            }
        });

        TextView share = findViewById(R.id.shareButton);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Navigating to confirm share.");
                Toast.makeText(ConfirmShareActivity.this, "Uploading new photo.", Toast.LENGTH_SHORT).show();
                String caption = mCaption.getText().toString();
                if(intent.hasExtra(getString(R.string.selected_image))){
                    imageURL = intent.getStringExtra(getString(R.string.selected_image));
                    helper.uploadNewPhoto(getString(R.string.new_photo), caption, imageCount, imageURL,null);
                }
                else if(intent.hasExtra(getString(R.string.selected_bitmap))){
                    bitmap = (Bitmap) intent.getParcelableExtra(getString(R.string.selected_bitmap));
                    helper.uploadNewPhoto(getString(R.string.new_photo), caption, imageCount, null,bitmap);
                }
            }
        });

        setImage();

    }

    private void setImage(){
        intent = getIntent();
        ImageView image = (ImageView) findViewById(R.id.imageShare);

        if(intent.hasExtra(getString(R.string.selected_image))){
            imageURL = intent.getStringExtra(getString(R.string.selected_image));
            Log.d(TAG, "setImage: got new image url: " + imageURL);
            UniversalImageLoader.setImage(imageURL, image, null, mAppend);
        }
        else if(intent.hasExtra(getString(R.string.selected_bitmap))){
            bitmap = (Bitmap) intent.getParcelableExtra(getString(R.string.selected_bitmap));
            Log.d(TAG, "setImage: got new bitmap");
            image.setImageBitmap(bitmap);
        }
    }

    //************************************** Firebase *********************************************

    private void setupFireBaseAuth() {
        Log.d(TAG, "setupFireBaseAuth: Setting up Firebase Auth.");

        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mRef = mFirebaseDatabase.getReference();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                if (user != null) {
                    Log.d(TAG, "onAuthStateChanged: Signed in." + user.getUid());
                } else {
                    Log.d(TAG, "onAuthStateChanged: Signed Out.");
                }
            }
        };

        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                imageCount = helper.getImageCount(dataSnapshot);
                Log.d(TAG, "onDataChange: Image Count: " + imageCount);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }
}
