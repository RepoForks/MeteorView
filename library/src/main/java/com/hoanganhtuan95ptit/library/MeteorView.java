package com.hoanganhtuan95ptit.library;

import android.animation.Animator;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

/**
 * Created by Hoang Anh Tuan on 10/23/2017.
 */

public class MeteorView extends AppCompatImageView {

    private static final int CORNER = 30;

    private int screenWidth;
    private int corner = CORNER;
    private double tag;
    private Random random;

    public MeteorView(Context context) {
        super(context);
        initView(context, null);
    }

    public MeteorView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    public MeteorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        setVisibility(View.GONE);

        if (attrs != null) {
            TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.MeteorView, 0, 0);
            corner = a.getInteger(R.styleable.MeteorView_corner, CORNER);
            if (corner % 90 == 0) corner = CORNER;
        }

        random = new Random();
        tag = Math.tan(corner * 3.14 / 180);
        screenWidth = Utils.getScreenWidth(context);

        postDelayed(new Runnable() {
            @Override
            public void run() {
                anim();
            }
        }, random.nextInt(500));
    }

    public void setCorner(int corner) {
        if (corner % 90 == 0) corner = CORNER;
        this.corner = corner;
        tag = Math.tan(corner * 3.14 / 180);
    }

    private void anim() {
        setTranslationX(screenWidth);
        setTranslationY((float) (-screenWidth * tag));
        animate().translationX(-screenWidth)
                .translationY((float) (screenWidth * tag))
                .setStartDelay(random.nextInt(1500))
                .setDuration(1500)
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        if (getVisibility() != VISIBLE) setVisibility(VISIBLE);
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        animation.cancel();
                        anim();
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                })
                .start();
    }
}
