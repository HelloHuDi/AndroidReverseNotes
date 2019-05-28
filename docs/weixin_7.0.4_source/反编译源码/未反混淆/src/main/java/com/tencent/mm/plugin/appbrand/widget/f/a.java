package com.tencent.mm.plugin.appbrand.widget.f;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ak;

public final class a extends FrameLayout implements OnClickListener, f {
    private TextView iVf;
    private final Runnable jmx = new Runnable() {
        public final void run() {
            AppMethodBeat.i(87522);
            a aVar = a.this;
            if (aVar.getAlpha() == 0.0f || aVar.jmz != null) {
                AppMethodBeat.o(87522);
                return;
            }
            aVar.animate().cancel();
            ViewPropertyAnimator animate = aVar.animate();
            aVar.jmz = animate;
            animate.alpha(0.0f).setListener(new AnimatorListenerAdapter() {
                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(87525);
                    a.this.setVisibility(8);
                    a.this.jmz = null;
                    AppMethodBeat.o(87525);
                }

                public final void onAnimationCancel(Animator animator) {
                    AppMethodBeat.i(87526);
                    a.this.jmz = null;
                    AppMethodBeat.o(87526);
                }
            }).start();
            AppMethodBeat.o(87522);
        }
    };
    private ViewPropertyAnimator jmy;
    ViewPropertyAnimator jmz;
    private final ak mHandler = new ak(Looper.getMainLooper());

    public a(Context context) {
        super(context);
        AppMethodBeat.i(87527);
        LayoutInflater.from(context).inflate(R.layout.dk, this, true);
        this.iVf = (TextView) findViewById(R.id.cx);
        setOnClickListener(this);
        AppMethodBeat.o(87527);
    }

    public final void EQ(String str) {
        AppMethodBeat.i(87528);
        this.iVf.setText(str);
        this.mHandler.removeCallbacks(this.jmx);
        this.mHandler.postDelayed(this.jmx, jmF);
        if (getAlpha() == 1.0f || this.jmy != null) {
            AppMethodBeat.o(87528);
            return;
        }
        setVisibility(0);
        animate().cancel();
        ViewPropertyAnimator animate = animate();
        this.jmy = animate;
        animate.alpha(1.0f).setListener(new AnimatorListenerAdapter() {
            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(87523);
                a.this.jmy = null;
                AppMethodBeat.o(87523);
            }

            public final void onAnimationCancel(Animator animator) {
                AppMethodBeat.i(87524);
                a.this.jmy = null;
                AppMethodBeat.o(87524);
            }
        }).start();
        setVisibility(0);
        AppMethodBeat.o(87528);
    }

    public final View getView() {
        return this;
    }

    public final void a(FrameLayout frameLayout) {
        AppMethodBeat.i(87529);
        frameLayout.addView(this, new LayoutParams(-2, -2, 17));
        AppMethodBeat.o(87529);
    }

    public final void onClick(View view) {
    }
}
