package com.tencent.mm.ui.widget.snackbar;

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
import com.tencent.mm.R;
import com.tencent.mm.ui.widget.snackbar.a.c;
import java.util.LinkedList;
import java.util.Queue;

public class SnackContainer extends FrameLayout {
    private final Runnable mHideRunnable = new Runnable() {
        public final void run() {
            AppMethodBeat.i(112991);
            if (SnackContainer.this.getVisibility() == 0) {
                SnackContainer.this.startAnimation(SnackContainer.this.zTY);
            }
            AppMethodBeat.o(112991);
        }
    };
    private AnimationSet yPM;
    Queue<a> zTX = new LinkedList();
    private AnimationSet zTY;

    static class a {
        final View zUb;
        final TextView zUc;
        final TextView zUd;
        final Snack zUe;
        final c zUf;

        /* synthetic */ a(Snack snack, View view, c cVar, byte b) {
            this(snack, view, cVar);
        }

        private a(Snack snack, View view, c cVar) {
            AppMethodBeat.i(112995);
            this.zUb = view;
            this.zUd = (TextView) view.findViewById(R.id.eeo);
            this.zUc = (TextView) view.findViewById(R.id.een);
            this.zUe = snack;
            this.zUf = cVar;
            AppMethodBeat.o(112995);
        }
    }

    static /* synthetic */ void d(a aVar) {
        AppMethodBeat.i(113007);
        b(aVar);
        AppMethodBeat.o(113007);
    }

    public SnackContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(112996);
        init();
        AppMethodBeat.o(112996);
    }

    SnackContainer(ViewGroup viewGroup) {
        super(viewGroup.getContext());
        AppMethodBeat.i(112997);
        viewGroup.addView(this, new LayoutParams(-1, -1));
        setVisibility(8);
        setId(R.id.eel);
        init();
        AppMethodBeat.o(112997);
    }

    private void init() {
        AppMethodBeat.i(112998);
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
        this.zTY.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
                AppMethodBeat.i(112992);
                if (!(SnackContainer.this.isEmpty() || SnackContainer.this.zTX.peek() == null || ((a) SnackContainer.this.zTX.peek()).zUf == null)) {
                    b.rf(false);
                    ((a) SnackContainer.this.zTX.peek()).zUf.cLd();
                }
                AppMethodBeat.o(112992);
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(112993);
                SnackContainer.this.removeAllViews();
                if (!SnackContainer.this.zTX.isEmpty()) {
                    SnackContainer.d((a) SnackContainer.this.zTX.poll());
                }
                if (SnackContainer.this.isEmpty()) {
                    SnackContainer.this.setVisibility(8);
                    AppMethodBeat.o(112993);
                    return;
                }
                SnackContainer.a(SnackContainer.this, (a) SnackContainer.this.zTX.peek());
                AppMethodBeat.o(112993);
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        AppMethodBeat.o(112998);
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(112999);
        super.onDetachedFromWindow();
        this.yPM.cancel();
        this.zTY.cancel();
        removeCallbacks(this.mHideRunnable);
        this.zTX.clear();
        AppMethodBeat.o(112999);
    }

    public final boolean isEmpty() {
        AppMethodBeat.i(113000);
        boolean isEmpty = this.zTX.isEmpty();
        AppMethodBeat.o(113000);
        return isEmpty;
    }

    public final boolean isShowing() {
        AppMethodBeat.i(113001);
        if (this.zTX.isEmpty()) {
            AppMethodBeat.o(113001);
            return false;
        }
        AppMethodBeat.o(113001);
        return true;
    }

    public final void hide() {
        AppMethodBeat.i(113002);
        removeCallbacks(this.mHideRunnable);
        this.mHideRunnable.run();
        AppMethodBeat.o(113002);
    }

    /* Access modifiers changed, original: final */
    public final void a(final a aVar) {
        AppMethodBeat.i(113003);
        setVisibility(0);
        c(aVar);
        addView(aVar.zUb);
        aVar.zUc.setText(aVar.zUe.nqb);
        if (aVar.zUe.zTI != null) {
            aVar.zUd.setVisibility(0);
            aVar.zUd.setText(aVar.zUe.zTI);
        } else {
            aVar.zUd.setVisibility(8);
        }
        this.yPM.setDuration(500);
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.b5);
        loadAnimation.setDuration(500);
        startAnimation(this.yPM);
        loadAnimation.setStartOffset(200);
        aVar.zUd.startAnimation(loadAnimation);
        aVar.zUc.startAnimation(loadAnimation);
        if (aVar.zUe.zTL > (short) 0) {
            postDelayed(this.mHideRunnable, (long) aVar.zUe.zTL);
        }
        aVar.zUb.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(112994);
                switch (motionEvent.getAction()) {
                    case 4:
                        SnackContainer.this.removeCallbacks(SnackContainer.this.mHideRunnable);
                        SnackContainer.d(aVar);
                        SnackContainer.this.startAnimation(SnackContainer.this.zTY);
                        if (!SnackContainer.this.zTX.isEmpty()) {
                            SnackContainer.this.zTX.clear();
                            break;
                        }
                        break;
                }
                AppMethodBeat.o(112994);
                return true;
            }
        });
        AppMethodBeat.o(113003);
    }

    private static void b(a aVar) {
        AppMethodBeat.i(113004);
        if (aVar.zUf != null) {
            b.rf(false);
            aVar.zUf.onHide();
        }
        AppMethodBeat.o(113004);
    }

    private static void c(a aVar) {
        AppMethodBeat.i(113005);
        if (aVar.zUf != null) {
            b.rf(true);
            aVar.zUf.onShow();
        }
        AppMethodBeat.o(113005);
    }

    /* Access modifiers changed, original: protected */
    public void onVisibilityChanged(View view, int i) {
        AppMethodBeat.i(113006);
        super.onVisibilityChanged(view, i);
        if (8 == i) {
            removeAllViews();
            if (!this.zTX.isEmpty()) {
                b((a) this.zTX.poll());
            }
            if (isEmpty()) {
                setVisibility(8);
            } else {
                a((a) this.zTX.peek());
            }
            b.rf(false);
        }
        AppMethodBeat.o(113006);
    }

    static /* synthetic */ void a(SnackContainer snackContainer, a aVar) {
        AppMethodBeat.i(113008);
        snackContainer.a(aVar);
        AppMethodBeat.o(113008);
    }
}
