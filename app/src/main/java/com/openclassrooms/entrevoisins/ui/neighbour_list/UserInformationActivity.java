package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserInformationActivity extends AppCompatActivity {

    private static final String TAG = "TAG";

    public boolean inFavourite;
    private long neighbourID;
    private String neighbourName;
    private String neighbourAvatar;
    private String neighbourAddress;
    private String neighbourPhone;
    private String neighbourAboutMe;
    private String neighbourEmail;
    public Boolean neighbourFavourite;
    public Neighbour mNeighbour; // = new Neighbour(neighbourID, neighbourName, neighbourAvatar, neighbourAddress, neighbourPhone, neighbourAboutMe, neighbourEmail);
    private NeighbourApiService mApiService;

    @BindView(R.id.toolbarUserInfo)
    public Toolbar mToolbarUserInfo;
    @BindView(R.id.iVUserAvatar)
    public ImageView mImageViewUserAvatar;
    @BindView(R.id.tVUserName)
    public TextView mTextViewUserName;
    @BindView(R.id.fabAddToFavourite)
    public FloatingActionButton mFloatingActionButton;
    @BindView(R.id.cardViewUserInfo)
    public CardView mCardViewUserInfo;
    @BindView(R.id.cvName)
    public TextView mTextViewCardViewName;
    @BindView(R.id.tvAddress)
    public TextView mTextViewCardViewAddress;
    @BindView(R.id.tvPhoneNumber)
    public TextView mTextViewPhoneNumber;
    @BindView(R.id.tvEmailAddress)
    public TextView mTextViewEmailAddress;
    @BindView(R.id.ivLocation)
    public ImageView mImageViewLocation;
    @BindView(R.id.ivEmail)
    public ImageView mImageViewEmail;
    @BindView(R.id.ivPhone)
    public ImageView mImageViewPhone;
    @BindView(R.id.cardViewUserDescription)
    public CardView mCardViewUserDescription;
    @BindView(R.id.tvAProposDescription)
    public TextView mTextViewAProposDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_information);
        ButterKnife.bind(this);
        mApiService = DI.getNeighbourApiService();

        //toolbar settings
        setSupportActionBar(mToolbarUserInfo);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mToolbarUserInfo.setNavigationIcon(getResources().getDrawable(R.drawable.ic_action_back));
        mToolbarUserInfo.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // retrieving neighbour
        mNeighbour = getIntent().getParcelableExtra("NEIGHBOUR");
        neighbourID = mNeighbour.getId();
        neighbourName = mNeighbour.getName();
        neighbourAvatar = mNeighbour.getAvatarUrl();
        neighbourAddress = mNeighbour.getAddress();
        neighbourPhone = mNeighbour.getPhoneNumber();
        neighbourAboutMe = mNeighbour.getAboutMe();
        neighbourEmail = mNeighbour.getEmailAddress();

        if (getIntent().getIntExtra("ISIN", 0) == 0) {
            neighbourFavourite = false;
        } else {
            neighbourFavourite = true;
        }

        inFavourite = neighbourFavourite;

        mTextViewUserName.setText(neighbourName);
        mTextViewCardViewName.setText(neighbourName);
        mTextViewCardViewAddress.setText(neighbourAddress);
        mTextViewPhoneNumber.setText(neighbourPhone);
        mTextViewEmailAddress.setText(neighbourEmail);
        mTextViewAProposDescription.setText(neighbourAboutMe);

        Picasso.get().load(neighbourAvatar).into(mImageViewUserAvatar);
        Log.d(TAG, "onCreate: " + inFavourite);

        setFavouriteFAB(inFavourite);
    }

    @OnClick(R.id.fabAddToFavourite)
    public void addToFavourite() {
            if (inFavourite == false) {
                neighbourFavourite = true;
                inFavourite = true;
                mNeighbour.setInFavourite(true);
                mApiService.createFavNeighbour(mNeighbour);
            } else if (inFavourite == true){
                neighbourFavourite = false;
                inFavourite = false;
                mNeighbour.setInFavourite(false);
                mApiService.deleteFavNeighbour(mNeighbour);
            }
        setFavouriteFAB(inFavourite);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    private void setFavouriteFAB(Boolean favourite) {
        Context context = this;
        if (inFavourite == true) {
            mFloatingActionButton.setColorFilter(ContextCompat.getColor(context, R.color.colorStarGold));
        } else {
            mFloatingActionButton.setColorFilter(ContextCompat.getColor(context, R.color.colorStarGrey));
        }
    }

}

