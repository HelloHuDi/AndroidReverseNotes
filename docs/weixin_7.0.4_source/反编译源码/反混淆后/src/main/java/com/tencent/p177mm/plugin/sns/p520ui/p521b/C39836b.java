package com.tencent.p177mm.plugin.sns.p520ui.p521b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.sns.ui.b.b */
public final class C39836b {
    public ValueAnimator nVD = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
    private Context rFO;
    public int rFP;
    public int rFQ;
    public int rFR;
    public int rFS;
    public C35111a rFT;
    View view;

    /* renamed from: com.tencent.mm.plugin.sns.ui.b.b$1 */
    class C351121 implements AnimatorUpdateListener {
        C351121() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(40002);
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            C39836b.this.view.setAlpha(1.0f - floatValue);
            if (floatValue != 1.0f) {
                LayoutParams layoutParams = (LayoutParams) C39836b.this.view.getLayoutParams();
                layoutParams.leftMargin = (int) (((float) C39836b.this.rFP) * floatValue);
                layoutParams.topMargin = (int) (((float) C39836b.this.rFQ) * floatValue);
                ViewGroup viewGroup = (ViewGroup) C39836b.this.view.getParent();
                layoutParams.rightMargin = (int) (((((float) viewGroup.getWidth()) * floatValue) - (((float) C39836b.this.rFR) * floatValue)) - ((float) layoutParams.leftMargin));
                layoutParams.bottomMargin = (int) (((((float) viewGroup.getHeight()) * floatValue) - (((float) C39836b.this.rFS) * floatValue)) - ((float) layoutParams.topMargin));
                C39836b.this.view.setLayoutParams(layoutParams);
            }
            if (C39836b.this.rFT != null) {
                C39836b.this.rFT.mo25680aZ(floatValue);
            }
            AppMethodBeat.m2505o(40002);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.b.b$2 */
    class C398342 extends AnimatorListenerAdapter {
        C398342() {
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.m2504i(40003);
            LayoutParams layoutParams = (LayoutParams) C39836b.this.view.getLayoutParams();
            layoutParams.leftMargin = C39836b.this.rFP;
            layoutParams.topMargin = C39836b.this.rFQ;
            ViewGroup viewGroup = (ViewGroup) C39836b.this.view.getParent();
            layoutParams.rightMargin = (viewGroup.getWidth() - C39836b.this.rFR) - layoutParams.leftMargin;
            layoutParams.bottomMargin = (viewGroup.getHeight() - C39836b.this.rFS) - layoutParams.topMargin;
            C39836b.this.view.setLayoutParams(layoutParams);
            C39836b.this.view.setVisibility(0);
            if (C39836b.this.rFT != null) {
                C39836b.this.rFT.onAnimationStart();
            }
            AppMethodBeat.m2505o(40003);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(40004);
            if (C39836b.this.rFT != null) {
                C39836b.this.rFT.onAnimationEnd();
            }
            C39836b.this.view.setVisibility(8);
            AppMethodBeat.m2505o(40004);
        }
    }

    public C39836b(Activity activity, View view) {
        AppMethodBeat.m2504i(40005);
        this.rFO = activity;
        this.view = view;
        this.nVD.addUpdateListener(new C351121());
        this.nVD.addListener(new C398342());
        this.nVD.setDuration(400);
        AppMethodBeat.m2505o(40005);
    }
}
