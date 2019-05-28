package com.tencent.p177mm.plugin.appbrand.widget.p337b;

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
import com.tencent.luggage.p147g.C8873f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.view.C31128d;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.b.e */
public final class C2514e extends RelativeLayout implements C33589k {
    final Set<C2520a> jbU = new HashSet();
    private final C45711i jbV = new C45711i(this);
    private final LinkedList<C38571j> jbW = new LinkedList();
    private final Runnable jbX = new C25152();
    private C38571j jbY;
    private C38571j jbZ;
    private final OnClickListener mOnClickListener = new C25161();
    private int mRotation = 0;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.b.e$2 */
    class C25152 implements Runnable {
        C25152() {
        }

        public final void run() {
            AppMethodBeat.m2504i(77404);
            C2514e.this.removeAllViews();
            C2514e.this.setVisibility(4);
            AppMethodBeat.m2505o(77404);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.b.e$1 */
    class C25161 implements OnClickListener {
        C25161() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(77403);
            if (view == C2514e.this) {
                C2514e.m4751a(C2514e.this);
            }
            AppMethodBeat.m2505o(77403);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.b.e$a */
    public interface C2520a {
        /* renamed from: CV */
        void mo6481CV();
    }

    public C2514e(Context context) {
        super(context);
        AppMethodBeat.m2504i(77409);
        setVisibility(4);
        setBackgroundColor(0);
        setOnClickListener(this.mOnClickListener);
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        if (windowManager != null) {
            this.mRotation = windowManager.getDefaultDisplay().getRotation();
        }
        AppMethodBeat.m2505o(77409);
    }

    /* renamed from: b */
    public final void mo6468b(final C38571j c38571j) {
        AppMethodBeat.m2504i(77410);
        if (C5004al.isMainThread()) {
            int i;
            C8873f.m15846az(getContext());
            C45711i c45711i = this.jbV;
            if (c45711i.jcQ == null || !c45711i.jcQ.isRunning()) {
                i = 0;
            } else {
                i = 1;
            }
            if (i != 0) {
                c45711i = this.jbV;
                if (c45711i.jcQ != null) {
                    c45711i.jcQ.cancel();
                }
            }
            View contentView = c38571j.getContentView();
            if (contentView.getParent() != this) {
                LayoutParams layoutParams;
                if (!(contentView == null || contentView.getParent() == null)) {
                    ((ViewGroup) contentView.getParent()).removeView(contentView);
                }
                if (c38571j.getPosition() == 2) {
                    layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams.addRule(12);
                    layoutParams.addRule(14);
                } else {
                    layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(13);
                }
                addView(contentView, layoutParams);
                if (this.jbZ != c38571j) {
                    contentView.clearAnimation();
                    if (c38571j.getPosition() == 2) {
                        contentView.startAnimation(AnimationUtils.loadAnimation(getContext(), C25738R.anim.f8340bd));
                    } else {
                        contentView.startAnimation(AnimationUtils.loadAnimation(getContext(), C25738R.anim.f8298a0));
                    }
                }
                this.jbZ = c38571j;
            }
            contentView.setOnClickListener(this.mOnClickListener);
            this.jbW.add(c38571j);
            c38571j.mo15058a(this);
            setVisibility(0);
            this.jbV.mo73502c(Color.argb(C31128d.MIC_SketchMark, 0, 0, 0), null);
            AppMethodBeat.m2505o(77410);
            return;
        }
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(77405);
                C2514e.this.mo6468b(c38571j);
                AppMethodBeat.m2505o(77405);
            }
        });
        AppMethodBeat.m2505o(77410);
    }

    /* renamed from: c */
    public final void mo6469c(final C38571j c38571j) {
        AppMethodBeat.m2504i(77411);
        if (c38571j.getContentView().getParent() != this) {
            AppMethodBeat.m2505o(77411);
        } else if (this.jbY == c38571j) {
            AppMethodBeat.m2505o(77411);
        } else {
            Animator animatorSet;
            this.jbY = c38571j;
            final View contentView = c38571j.getContentView();
            contentView.animate().cancel();
            contentView.clearAnimation();
            if (c38571j.getPosition() == 2) {
                AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();
                animatorSet = new AnimatorSet();
                Animator[] animatorArr = new Animator[1];
                ObjectAnimator duration = ObjectAnimator.ofFloat(contentView, "translationY", new float[]{0.0f, (float) contentView.getHeight()}).setDuration(200);
                duration.setInterpolator(accelerateInterpolator);
                animatorArr[0] = duration;
                animatorSet.playTogether(animatorArr);
            } else {
                Interpolator loadInterpolator = AnimationUtils.loadInterpolator(contentView.getContext(), C25738R.anim.f8309ae);
                Interpolator loadInterpolator2 = AnimationUtils.loadInterpolator(contentView.getContext(), C25738R.anim.f8308ad);
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

                /* renamed from: com.tencent.mm.plugin.appbrand.widget.b.e$4$1 */
                class C25191 implements Runnable {
                    C25191() {
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(77406);
                        C2514e.this.removeView(contentView);
                        for (C2520a CV : C2514e.this.jbU) {
                            CV.mo6481CV();
                        }
                        AppMethodBeat.m2505o(77406);
                    }
                }

                public final void onAnimationCancel(Animator animator) {
                    AppMethodBeat.m2504i(77407);
                    onAnimationEnd(animator);
                    AppMethodBeat.m2505o(77407);
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.m2504i(77408);
                    contentView.setVisibility(8);
                    C2514e.this.jbW.remove(c38571j);
                    C2514e.this.jbY = null;
                    C2514e.this.post(new C25191());
                    AppMethodBeat.m2505o(77408);
                }
            });
            animatorSet.start();
            if (this.jbW.size() <= 1) {
                this.jbV.mo73502c(0, this.jbX);
            }
            AppMethodBeat.m2505o(77411);
        }
    }

    public final C38571j getCurrentDialog() {
        AppMethodBeat.m2504i(77412);
        C38571j c38571j = (C38571j) this.jbW.peekLast();
        AppMethodBeat.m2505o(77412);
        return c38571j;
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(77413);
        if (getChildCount() == 0) {
            AppMethodBeat.m2505o(77413);
            return false;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.m2505o(77413);
        return dispatchTouchEvent;
    }

    /* renamed from: wY */
    public final boolean mo6474wY() {
        AppMethodBeat.m2504i(77414);
        C38571j c38571j = (C38571j) this.jbW.peekLast();
        if (c38571j == null) {
            setVisibility(8);
            AppMethodBeat.m2505o(77414);
            return false;
        }
        if (c38571j.isCancelable()) {
            c38571j.onCancel();
            mo6469c(c38571j);
        }
        AppMethodBeat.m2505o(77414);
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(77415);
        super.onConfigurationChanged(configuration);
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        if (windowManager != null) {
            int rotation = windowManager.getDefaultDisplay().getRotation();
            if (this.mRotation != rotation) {
                this.mRotation = rotation;
                Iterator it = this.jbW.iterator();
                while (it.hasNext()) {
                    ((C38571j) it.next()).mo15063pF(this.mRotation);
                }
            }
        }
        AppMethodBeat.m2505o(77415);
    }

    public final int size() {
        AppMethodBeat.m2504i(77416);
        int size = this.jbW.size();
        AppMethodBeat.m2505o(77416);
        return size;
    }

    /* renamed from: a */
    public final void mo6466a(C2520a c2520a) {
        AppMethodBeat.m2504i(77417);
        this.jbU.add(c2520a);
        AppMethodBeat.m2505o(77417);
    }

    /* renamed from: b */
    public final void mo6467b(C2520a c2520a) {
        AppMethodBeat.m2504i(77418);
        this.jbU.remove(c2520a);
        AppMethodBeat.m2505o(77418);
    }
}
