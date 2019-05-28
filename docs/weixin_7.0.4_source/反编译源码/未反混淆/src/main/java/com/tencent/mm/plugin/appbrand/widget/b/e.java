package com.tencent.mm.plugin.appbrand.widget.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.RelativeLayout;
import com.tencent.luggage.g.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.view.d;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class e extends RelativeLayout implements k {
    final Set<a> jbU = new HashSet();
    private final i jbV = new i(this);
    private final LinkedList<j> jbW = new LinkedList();
    private final Runnable jbX = new Runnable() {
        public final void run() {
            AppMethodBeat.i(77404);
            e.this.removeAllViews();
            e.this.setVisibility(4);
            AppMethodBeat.o(77404);
        }
    };
    private j jbY;
    private j jbZ;
    private final OnClickListener mOnClickListener = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(77403);
            if (view == e.this) {
                e.a(e.this);
            }
            AppMethodBeat.o(77403);
        }
    };
    private int mRotation = 0;

    public interface a {
        void CV();
    }

    public e(Context context) {
        super(context);
        AppMethodBeat.i(77409);
        setVisibility(4);
        setBackgroundColor(0);
        setOnClickListener(this.mOnClickListener);
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        if (windowManager != null) {
            this.mRotation = windowManager.getDefaultDisplay().getRotation();
        }
        AppMethodBeat.o(77409);
    }

    public final void b(final j jVar) {
        AppMethodBeat.i(77410);
        if (al.isMainThread()) {
            int i;
            f.az(getContext());
            i iVar = this.jbV;
            if (iVar.jcQ == null || !iVar.jcQ.isRunning()) {
                i = 0;
            } else {
                i = 1;
            }
            if (i != 0) {
                iVar = this.jbV;
                if (iVar.jcQ != null) {
                    iVar.jcQ.cancel();
                }
            }
            View contentView = jVar.getContentView();
            if (contentView.getParent() != this) {
                LayoutParams layoutParams;
                if (!(contentView == null || contentView.getParent() == null)) {
                    ((ViewGroup) contentView.getParent()).removeView(contentView);
                }
                if (jVar.getPosition() == 2) {
                    layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams.addRule(12);
                    layoutParams.addRule(14);
                } else {
                    layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(13);
                }
                addView(contentView, layoutParams);
                if (this.jbZ != jVar) {
                    contentView.clearAnimation();
                    if (jVar.getPosition() == 2) {
                        contentView.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.bd));
                    } else {
                        contentView.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.a0));
                    }
                }
                this.jbZ = jVar;
            }
            contentView.setOnClickListener(this.mOnClickListener);
            this.jbW.add(jVar);
            jVar.a(this);
            setVisibility(0);
            this.jbV.c(Color.argb(d.MIC_SketchMark, 0, 0, 0), null);
            AppMethodBeat.o(77410);
            return;
        }
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(77405);
                e.this.b(jVar);
                AppMethodBeat.o(77405);
            }
        });
        AppMethodBeat.o(77410);
    }

    public final void c(final j jVar) {
        AppMethodBeat.i(77411);
        if (jVar.getContentView().getParent() != this) {
            AppMethodBeat.o(77411);
        } else if (this.jbY == jVar) {
            AppMethodBeat.o(77411);
        } else {
            Animator animatorSet;
            this.jbY = jVar;
            final View contentView = jVar.getContentView();
            contentView.animate().cancel();
            contentView.clearAnimation();
            if (jVar.getPosition() == 2) {
                AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();
                animatorSet = new AnimatorSet();
                Animator[] animatorArr = new Animator[1];
                ObjectAnimator duration = ObjectAnimator.ofFloat(contentView, "translationY", new float[]{0.0f, (float) contentView.getHeight()}).setDuration(200);
                duration.setInterpolator(accelerateInterpolator);
                animatorArr[0] = duration;
                animatorSet.playTogether(animatorArr);
            } else {
                Interpolator loadInterpolator = AnimationUtils.loadInterpolator(contentView.getContext(), R.anim.ae);
                Interpolator loadInterpolator2 = AnimationUtils.loadInterpolator(contentView.getContext(), R.anim.ad);
                animatorSet = new AnimatorSet();
                r4 = new Animator[3];
                ObjectAnimator duration2 = ObjectAnimator.ofFloat(contentView, "scaleX", new float[]{1.0f, 0.9f}).setDuration(220);
                duration2.setInterpolator(loadInterpolator);
                r4[0] = duration2;
                duration2 = ObjectAnimator.ofFloat(contentView, "scaleY", new float[]{1.0f, 0.9f}).setDuration(220);
                duration2.setInterpolator(loadInterpolator);
                r4[1] = duration2;
                ObjectAnimator duration3 = ObjectAnimator.ofFloat(contentView, "alpha", new float[]{1.0f, 0.0f}).setDuration(150);
                duration3.setInterpolator(loadInterpolator2);
                r4[2] = duration3;
                animatorSet.playTogether(r4);
            }
            animatorSet.addListener(new AnimatorListenerAdapter() {
                public final void onAnimationCancel(Animator animator) {
                    AppMethodBeat.i(77407);
                    onAnimationEnd(animator);
                    AppMethodBeat.o(77407);
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(77408);
                    contentView.setVisibility(8);
                    e.this.jbW.remove(jVar);
                    e.this.jbY = null;
                    e.this.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(77406);
                            e.this.removeView(contentView);
                            for (a CV : e.this.jbU) {
                                CV.CV();
                            }
                            AppMethodBeat.o(77406);
                        }
                    });
                    AppMethodBeat.o(77408);
                }
            });
            animatorSet.start();
            if (this.jbW.size() <= 1) {
                this.jbV.c(0, this.jbX);
            }
            AppMethodBeat.o(77411);
        }
    }

    public final j getCurrentDialog() {
        AppMethodBeat.i(77412);
        j jVar = (j) this.jbW.peekLast();
        AppMethodBeat.o(77412);
        return jVar;
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(77413);
        if (getChildCount() == 0) {
            AppMethodBeat.o(77413);
            return false;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(77413);
        return dispatchTouchEvent;
    }

    public final boolean wY() {
        AppMethodBeat.i(77414);
        j jVar = (j) this.jbW.peekLast();
        if (jVar == null) {
            setVisibility(8);
            AppMethodBeat.o(77414);
            return false;
        }
        if (jVar.isCancelable()) {
            jVar.onCancel();
            c(jVar);
        }
        AppMethodBeat.o(77414);
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(77415);
        super.onConfigurationChanged(configuration);
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        if (windowManager != null) {
            int rotation = windowManager.getDefaultDisplay().getRotation();
            if (this.mRotation != rotation) {
                this.mRotation = rotation;
                Iterator it = this.jbW.iterator();
                while (it.hasNext()) {
                    ((j) it.next()).pF(this.mRotation);
                }
            }
        }
        AppMethodBeat.o(77415);
    }

    public final int size() {
        AppMethodBeat.i(77416);
        int size = this.jbW.size();
        AppMethodBeat.o(77416);
        return size;
    }

    public final void a(a aVar) {
        AppMethodBeat.i(77417);
        this.jbU.add(aVar);
        AppMethodBeat.o(77417);
    }

    public final void b(a aVar) {
        AppMethodBeat.i(77418);
        this.jbU.remove(aVar);
        AppMethodBeat.o(77418);
    }
}
