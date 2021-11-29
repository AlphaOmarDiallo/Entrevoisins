package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.events.OpenUserProfileEvent;
import com.openclassrooms.entrevoisins.events.PassNeighbourInformationEvent;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserInformationActivity extends AppCompatActivity {

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
    @BindView(R.id.tvAProposTitle)
    public TextView mTextViewAProposTitle;
    @BindView(R.id.tvAProposDescription)
    public TextView mTextViewAProposDescription;

    private boolean inFavourite = false;
    private Neighbour mNeighbour;
    private long mNeighbourID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_information);
        ButterKnife.bind(this);
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
        // retrieving data from EventBus
        /** gets sticky data
         * @param event
         */
      // @Subscribe
      // public void onPassNeighbourInformationEvent (PassNeighbourInformationEvent event) {


      //  }
        //retrieving data from intent
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        mTextViewUserName.setText(extras.getString("NEIGHBOURNAME"));
        mTextViewCardViewName.setText(extras.getString("NEIGHBOURNAME"));
        mTextViewCardViewAddress.setText(extras.getString("NEIGHBOURADDRESS"));
        mTextViewPhoneNumber.setText(extras.getString("NEIGHBOURPHONE"));
        mTextViewEmailAddress.setText(extras.getString("NEIGHBOUREMAIL"));
        mTextViewAProposDescription.setText(extras.getString("NEIGHBOURABOUTME"));
        inFavourite = extras.getBoolean("NEIGHBOURINFAVOURITE");
        mNeighbourID = extras.getLong("NEIGHBOURID");

        setFavouriteFAB(inFavourite);

        //Neighbour neighbour = (Neighbour) extras.getParcelable("NEIGHBOUR");

        Picasso.get().load(extras.getString("NEIGHBOURAVATAR")).into(mImageViewUserAvatar);

    }

    @OnClick(R.id.fabAddToFavourite)
    public void addToFavourite() {
        //TODO - method ot add to favourite and change star color if in favourite, also add toast
        if (inFavourite == false) {
            inFavourite = true;
        } else {
            inFavourite = false;
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

    private void setFavouriteFAB (Boolean favourite) {
        Context context = this;
        if (inFavourite == true){
            mFloatingActionButton.setColorFilter(ContextCompat.getColor(context, R.color.colorStarGold));
        } else {
            mFloatingActionButton.setColorFilter(ContextCompat.getColor(context, R.color.colorStarGrey));
        }
    }

    private void modifyUserInfo () {

    }

}

