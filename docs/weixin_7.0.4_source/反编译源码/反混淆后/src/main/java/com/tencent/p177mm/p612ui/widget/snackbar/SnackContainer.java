package com.tencent.p177mm.p612ui.widget.snackbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.widget.snackbar.C24110a.C24112c;
import java.util.LinkedList;
import java.util.Queue;

/* renamed from: com.tencent.mm.ui.widget.snackbar.SnackContainer */
public class SnackContainer extends FrameLayout {
    private final Runnable mHideRunnable = new C241081();
    private AnimationSet yPM;
    Queue<C44405a> zTX = new LinkedList();
    private AnimationSet zTY;

    /* renamed from: com.tencent.mm.ui.widget.snackbar.SnackContainer$1 */
    class C241081 implements Runnable {
        C241081() {
        }

        public final void run() {
            AppMethodBeat.m2504i(112991);
            if (SnackContainer.this.getVisibility() == 0) {
                SnackContainer.this.startAnimation(SnackContainer.this.zTY);
            }
            AppMethodBeat.m2505o(112991);
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.snackbar.SnackContainer$2 */
    class C308112 implements AnimationListener {
        C308112() {
        }

        public final void onAnimationStart(Animation animation) {
            AppMethodBeat.m2504i(112992);
            if (!(SnackContainer.this.isEmpty() || SnackContainer.this.zTX.peek() == null || ((C44405a) SnackContainer.this.zTX.peek()).zUf == null)) {
                C5670b.m8524rf(false);
                ((C44405a) SnackContainer.this.zTX.peek()).zUf.cLd();
            }
            AppMethodBeat.m2505o(112992);
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(112993);
            SnackContainer.this.removeAllViews();
            if (!SnackContainer.this.zTX.isEmpty()) {
                SnackContainer.m80270d((C44405a) SnackContainer.this.zTX.poll());
            }
            if (SnackContainer.this.isEmpty()) {
                SnackContainer.this.setVisibility(8);
                AppMethodBeat.m2505o(112993);
                return;
            }
            SnackContainer.m80265a(SnackContainer.this, (C44405a) SnackContainer.this.zTX.peek());
            AppMethodBeat.m2505o(112993);
        }

        public final void onAnimationRepeat(Animation animation) {
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.snackbar.SnackContainer$a */
    static class C44405a {
        final View zUb;
        final TextView zUc;
        final TextView zUd;
        final Snack zUe;
        final C24112c zUf;

        /* synthetic */ C44405a(Snack snack, View view, C24112c c24112c, byte b) {
            this(snack, view, c24112c);
        }

        private C44405a(Snack snack, View view, C24112c c24112c) {
            AppMethodBeat.m2504i(112995);
            this.zUb = view;
            this.zUd = (TextView) view.findViewById(2131827598);
            this.zUc = (TextView) view.findViewById(2131827597);
            this.zUe = snack;
            this.zUf = c24112c;
            AppMethodBeat.m2505o(112995);
        }
    }

    /* renamed from: d */
    static /* synthetic */ void m80270d(C44405a c44405a) {
        AppMethodBeat.m2504i(113007);
        SnackContainer.m80267b(c44405a);
        AppMethodBeat.m2505o(113007);
    }

    public SnackContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(112996);
        init();
        AppMethodBeat.m2505o(112996);
    }

    SnackContainer(ViewGroup viewGroup) {
        super(viewGroup.getContext());
        AppMethodBeat.m2504i(112997);
        viewGroup.addView(this, new LayoutParams(-1, -1));
        setVisibility(8);
        setId(2131827595);
        init();
        AppMethodBeat.m2505o(112997);
    }

    private void init() {
        AppMethodBeat.m2504i(112998);
        this.yPM = new AnimationSet(false);
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 1.0f, 1, 0.0f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.yPM.setInterpolator(new DecelerateInterpolator(1.5f));
        this.yPM.addAnimation(translateAnimation);
        this.yPM.addAnimation(alphaAnimation);
        this.zTY = new AnimationSet(false);
        translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 1, 1.0f);
        alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        this.zTY.addAnimation(translateAnimation);
        this.zTY.addAnimation(alphaAnimation);
        this.zTY.setDuration(300);
        this.zTY.setAnimationListener(new C308112());
        AppMethodBeat.m2505o(112998);
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.m2504i(112999);
        super.onDetachedFromWindow();
        this.yPM.cancel();
        this.zTY.cancel();
        removeCallbacks(this.mHideRunnable);
        this.zTX.clear();
        AppMethodBeat.m2505o(112999);
    }

    public final boolean isEmpty() {
        AppMethodBeat.m2504i(113000);
        boolean isEmpty = this.zTX.isEmpty();
        AppMethodBeat.m2505o(113000);
        return isEmpty;
    }

    public final boolean isShowing() {
        AppMethodBeat.m2504i(113001);
        if (this.zTX.isEmpty()) {
            AppMethodBeat.m2505o(113001);
            return false;
        }
        AppMethodBeat.m2505o(113001);
        return true;
    }

    public final void hide() {
        AppMethodBeat.m2504i(113002);
        removeCallbacks(this.mHideRunnable);
        this.mHideRunnable.run();
        AppMethodBeat.m2505o(113002);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo70282a(final C44405a c44405a) {
        AppMethodBeat.m2504i(113003);
        setVisibility(0);
        SnackContainer.m80269c(c44405a);
        addView(c44405a.zUb);
        c44405a.zUc.setText(c44405a.zUe.nqb);
        if (c44405a.zUe.zTI != null) {
            c44405a.zUd.setVisibility(0);
            c44405a.zUd.setText(c44405a.zUe.zTI);
        } else {
            c44405a.zUd.setVisibility(8);
        }
        this.yPM.setDuration(500);
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), C25738R.anim.f8332b5);
        loadAnimation.setDuration(500);
        startAnimation(this.yPM);
        loadAnimation.setStartOffset(200);
        c44405a.zUd.startAnimation(loadAnimation);
        c44405a.zUc.startAnimation(loadAnimation);
        if (c44405a.zUe.zTL > (short) 0) {
            postDelayed(this.mHideRunnable, (long) c44405a.zUe.zTL);
        }
        c44405a.zUb.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.m2504i(112994);
                switch (motionEvent.getAction()) {
                    case 4:
                        SnackContainer.this.removeCallbacks(SnackContainer.this.mHideRunnable);
                        SnackContainer.m80270d(c44405a);
                        SnackContainer.this.startAnimation(SnackContainer.this.zTY);
                        if (!SnackContainer.this.zTX.isEmpty()) {
                            SnackContainer.this.zTX.clear();
                            break;
                        }
                        break;
                }
                AppMethodBeat.m2505o(112994);
                return true;
            }
        });
        AppMethodBeat.m2505o(113003);
    }

    /* renamed from: b */
    private static void m80267b(C44405a c44405a) {
        AppMethodBeat.m2504i(113004);
        if (c44405a.zUf != null) {
            C5670b.m8524rf(false);
            c44405a.zUf.onHide();
        }
        AppMethodBeat.m2505o(113004);
    }

    /* renamed from: c */
    private static void m80269c(C44405a c44405a) {
        AppMethodBeat.m2504i(113005);
        if (c44405a.zUf != null) {
            C5670b.m8524rf(true);
            c44405a.zUf.onShow();
        }
        AppMethodBeat.m2505o(113005);
    }

    /* Access modifiers changed, original: protected */
    public void onVisibilityChanged(View view, int i) {
        AppMethodBeat.m2504i(113006);
        super.onVisibilityChanged(view, i);
        if (8 == i) {
            removeAllViews();
            if (!this.zTX.isEmpty()) {
                SnackContainer.m80267b((C44405a) this.zTX.poll());
            }
            if (isEmpty()) {
                setVisibility(8);
            } else {
                mo70282a((C44405a) this.zTX.peek());
            }
            C5670b.m8524rf(false);
        }
        AppMethodBeat.m2505o(113006);
    }

    /* renamed from: a */
    static /* synthetic */ void m80265a(SnackContainer snackContainer, C44405a c44405a) {
        AppMethodBeat.m2504i(113008);
        snackContainer.mo70282a(c44405a);
        AppMethodBeat.m2505o(113008);
    }
}
