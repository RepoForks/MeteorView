package com.hoanganhtuan95ptit.meteorview;

import android.animation.Animator;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hoanganhtuan95ptit.library.MeteorView;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.img_background_star)
    ImageView imgBackgroundStar;
    @BindView(R.id.img_meteor0)
    MeteorView imgMeteor0;
    @BindView(R.id.img_meteor1)
    MeteorView imgMeteor1;
    @BindView(R.id.img_meteor2)
    MeteorView imgMeteor2;
    @BindView(R.id.img_meteor3)
    MeteorView imgMeteor3;
    @BindView(R.id.img_background_tree)
    ImageView imgBackgroundTree;
    @BindView(R.id.img_background_moon)
    ImageView imgBackgroundMoon;
    @BindView(R.id.img_background_fire)
    ImageView imgBackgroundFire;
    @BindView(R.id.button)
    FrameLayout button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        Picasso.with(this).load(R.drawable.star).resize(900, 1600).centerCrop().into(imgBackgroundStar, new Callback() {
            @Override
            public void onSuccess() {
                AnimationDrawable frameAnimation = (AnimationDrawable) imgBackgroundFire.getDrawable();
                frameAnimation.start();

                showButtonStartChat();
            }

            @Override
            public void onError() {

            }
        });
        Picasso.with(this).load(R.drawable.icon_light_moon).resize(100, 100).centerCrop().into(imgBackgroundMoon);
        Picasso.with(this).load(R.drawable.background_main_back).resize(500, 322).centerCrop().into(imgBackgroundTree);
        Picasso.with(this).load(R.drawable.icon_meteor).into(imgMeteor0);
        Picasso.with(this).load(R.drawable.icon_meteor).into(imgMeteor1);
        Picasso.with(this).load(R.drawable.icon_meteor).into(imgMeteor2);
        Picasso.with(this).load(R.drawable.icon_meteor).into(imgMeteor3);

    }


    private void showButtonStartChat() {
        button.setAlpha(0f);
        button.animate()
                .alpha(1f)
                .setDuration(1000)
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        if (button.getVisibility() != View.VISIBLE)
                            button.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {
                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {
                    }
                }).start();
    }
}
