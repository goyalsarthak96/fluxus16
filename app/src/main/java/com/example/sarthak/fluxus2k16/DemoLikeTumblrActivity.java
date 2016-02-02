package com.example.sarthak.fluxus2k16;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;


import com.example.sarthak.fluxus2k16.R;

import java.util.ArrayList;
import java.util.List;

public class DemoLikeTumblrActivity extends AppCompatActivity implements View.OnClickListener {

  private static final String KEY_DEMO = "demo";
  View rootLayout;
  ClipRevealFrame menuLayout;
  ArcLayout arcLayout;
  View centerItem;
  Button b;



  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.like_a_tumblr);



    rootLayout = findViewById(R.id.root_layout);
    menuLayout = (ClipRevealFrame) findViewById(R.id.menu_layout);
    arcLayout = (ArcLayout) findViewById(R.id.arc_layout);
    centerItem = findViewById(R.id.center_item);
    b = (Button)findViewById(R.id.fab);
    b.setVisibility(View.INVISIBLE);

    //centerItem.setOnClickListener(this);
    for (int i = 0, size = arcLayout.getChildCount(); i < size; i++) {
      arcLayout.getChildAt(i).setOnClickListener(this);
    }
    onFabClick(b);
    findViewById(R.id.fab).setOnClickListener(this);

  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    if (item.getItemId() == android.R.id.home) {
      finish();
      return true;
    }
    return super.onOptionsItemSelected(item);
  }

  @Override
  public void onClick(View v) {
    if (v.getId() == R.id.fab) {
      onFabClick(v);
      return;
    }

    if (v instanceof Button) {

      Intent intent=new Intent(DemoLikeTumblrActivity.this,subcategories.class);
      switch (v.getId())
      {
        case R.id.cultural_fab:intent.putExtra("category_no",0);
          break;
        case R.id.technical_fab:intent.putExtra("category_no",1);
          break;
        case R.id.informal_fab:intent.putExtra("category_no",2);
          break;
        case R.id.quiz_fab:intent.putExtra("category_no",3);
          break;
        case R.id.literary_fab:intent.putExtra("category_no",4);
          break;
      }
      startActivity(intent);
      //
    }

  }



  private void onFabClick(View v) {
    int x = (v.getLeft() + v.getRight()) / 2;
    int y = (v.getTop() + v.getBottom()) / 2;
    float radiusOfFab = 1f * v.getWidth() / 2f;
    float radiusFromFabToRoot = (float) Math.hypot(
        Math.max(x, rootLayout.getWidth() - x),
        Math.max(y, rootLayout.getHeight() - y));

    if (v.isSelected()) {
      //hideMenu(x, y, radiusFromFabToRoot, radiusOfFab);
    } else {
      showMenu(x, y, radiusOfFab, radiusFromFabToRoot);
    }
    v.setSelected(!v.isSelected());
  }

  private void showMenu(int cx, int cy, float startRadius, float endRadius) {
      menuLayout.setVisibility(View.VISIBLE);

      final List<Animator> animList = new ArrayList<>();
      final int cx_,cy_;
      final float startRadius_,endRadius_;
      cx_=cx;
      cy_=cy;
      startRadius_=startRadius;
      endRadius_=endRadius;

      menuLayout.post(new Runnable() {
                        @Override
                      public void run() {
                        Animator revealAnim = createCircularReveal(menuLayout, cx_, cy_, startRadius_, endRadius_);
                        revealAnim.setInterpolator(new AccelerateDecelerateInterpolator());
                        revealAnim.setDuration(500);

                        animList.add(revealAnim);
                        animList.add(createShowItemAnimator(centerItem));

                        for (int i = 0, len = arcLayout.getChildCount(); i < len; i++) {
                          animList.add(createShowItemAnimator(arcLayout.getChildAt(i)));
                        }

                        AnimatorSet animSet = new AnimatorSet();
                        animSet.playSequentially(animList);
                        animSet.start();
                      }
                    }
    );




  }

  /*private void hideMenu(int cx, int cy, float startRadius, float endRadius) {
    List<Animator> animList = new ArrayList<>();

    for (int i = arcLayout.getChildCount() - 1; i >= 0; i--) {
      animList.add(createHideItemAnimator(arcLayout.getChildAt(i)));
    }

    animList.add(createHideItemAnimator(centerItem));

    Animator revealAnim = createCircularReveal(menuLayout, cx, cy, startRadius, endRadius);
    revealAnim.setInterpolator(new AccelerateDecelerateInterpolator());
    revealAnim.setDuration(200);
    revealAnim.addListener(new AnimatorListenerAdapter() {
      @Override
      public void onAnimationEnd(Animator animation) {
        super.onAnimationEnd(animation);
        menuLayout.setVisibility(View.INVISIBLE);
      }
    });

    animList.add(revealAnim);

    AnimatorSet animSet = new AnimatorSet();
    animSet.playSequentially(animList);
    animSet.start();

  }*/

  private Animator createShowItemAnimator(View item) {
    float dx = centerItem.getX() - item.getX();
    float dy = centerItem.getY() - item.getY();

    item.setScaleX(0f);
    item.setScaleY(0f);
    item.setTranslationX(dx);
    item.setTranslationY(dy);

    Animator anim = ObjectAnimator.ofPropertyValuesHolder(
        item,
        AnimatorUtils.scaleX(0f, 1f),
        AnimatorUtils.scaleY(0f, 1f),
        AnimatorUtils.translationX(dx, 0f),
        AnimatorUtils.translationY(dy, 0f)
    );

    anim.setInterpolator(new DecelerateInterpolator());
    anim.setDuration(100);
    return anim;
  }

  /*private Animator createHideItemAnimator(final View item) {
    final float dx = centerItem.getX() - item.getX();
    final float dy = centerItem.getY() - item.getY();

    Animator anim = ObjectAnimator.ofPropertyValuesHolder(
        item,
        AnimatorUtils.scaleX(1f, 0f),
        AnimatorUtils.scaleY(1f, 0f),
        AnimatorUtils.translationX(0f, dx),
        AnimatorUtils.translationY(0f, dy)
    );

    anim.setInterpolator(new DecelerateInterpolator());
    anim.addListener(new AnimatorListenerAdapter() {
      @Override
      public void onAnimationEnd(Animator animation) {
        super.onAnimationEnd(animation);
        item.setTranslationX(0f);
        item.setTranslationY(0f);
      }
    });
    anim.setDuration(50);
    return anim;
  }*/

  private Animator createCircularReveal(final ClipRevealFrame view, int x, int y, float startRadius,
      float endRadius) {
    final Animator reveal;
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      reveal = ViewAnimationUtils.createCircularReveal(view, x, y, startRadius, endRadius);
    } else {
      view.setClipOutLines(true);
      view.setClipCenter(x, y);
      reveal = ObjectAnimator.ofFloat(view, "ClipRadius", startRadius, endRadius);
      reveal.addListener(new Animator.AnimatorListener() {
        @Override
        public void onAnimationStart(Animator animation) {

        }

        @Override
        public void onAnimationEnd(Animator animation) {
          view.setClipOutLines(false);
        }

        @Override
        public void onAnimationCancel(Animator animation) {

        }

        @Override
        public void onAnimationRepeat(Animator animation) {

        }
      });
    }
    return reveal;
  }

}
