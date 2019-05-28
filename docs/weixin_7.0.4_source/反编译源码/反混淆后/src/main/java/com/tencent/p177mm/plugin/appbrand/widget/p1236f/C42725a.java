package com.tencent.p177mm.plugin.appbrand.widget.p1236f;

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
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.f.a */
public final class C42725a extends FrameLayout implements OnClickListener, C19857f {
    private TextView iVf;
    private final Runnable jmx = new C427261();
    private ViewPropertyAnimator jmy;
    ViewPropertyAnimator jmz;
    private final C7306ak mHandler = new C7306ak(Looper.getMainLooper());

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.f.a$2 */
    class C385912 extends AnimatorListenerAdapter {
        C385912() {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(87523);
            C42725a.this.jmy = null;
            AppMethodBeat.m2505o(87523);
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.m2504i(87524);
            C42725a.this.jmy = null;
            AppMethodBeat.m2505o(87524);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.f.a$1 */
    class C427261 implements Runnable {
        C427261() {
        }

        public final void run() {
            AppMethodBeat.m2504i(87522);
            C42725a c42725a = C42725a.this;
            if (c42725a.getAlpha() == 0.0f || c42725a.jmz != null) {
                AppMethodBeat.m2505o(87522);
                return;
            }
            c42725a.animate().cancel();
            ViewPropertyAnimator animate = c42725a.animate();
            c42725a.jmz = animate;
            animate.alpha(0.0f).setListener(new C427273()).start();
            AppMethodBeat.m2505o(87522);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.f.a$3 */
    class C427273 extends AnimatorListenerAdapter {
        C427273() {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(87525);
            C42725a.this.setVisibility(8);
            C42725a.this.jmz = null;
            AppMethodBeat.m2505o(87525);
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.m2504i(87526);
            C42725a.this.jmz = null;
            AppMethodBeat.m2505o(87526);
        }
    }

    public C42725a(Context context) {
        super(context);
        AppMethodBeat.m2504i(87527);
        LayoutInflater.from(context).inflate(2130968734, this, true);
        this.iVf = (TextView) findViewById(2131820678);
        setOnClickListener(this);
        AppMethodBeat.m2505o(87527);
    }

    /* renamed from: EQ */
    public final void mo35077EQ(String str) {
        AppMethodBeat.m2504i(87528);
        this.iVf.setText(str);
        this.mHandler.removeCallbacks(this.jmx);
        this.mHandler.postDelayed(this.jmx, jmF);
        if (getAlpha() == 1.0f || this.jmy != null) {
            AppMethodBeat.m2505o(87528);
            return;
        }
        setVisibility(0);
        animate().cancel();
        ViewPropertyAnimator animate = animate();
        this.jmy = animate;
        animate.alpha(1.0f).setListener(new C385912()).start();
        setVisibility(0);
        AppMethodBeat.m2505o(87528);
    }

    public final View getView() {
        return this;
    }

    /* renamed from: a */
    public final void mo35078a(FrameLayout frameLayout) {
        AppMethodBeat.m2504i(87529);
        frameLayout.addView(this, new LayoutParams(-2, -2, 17));
        AppMethodBeat.m2505o(87529);
    }

    public final void onClick(View view) {
    }
}
