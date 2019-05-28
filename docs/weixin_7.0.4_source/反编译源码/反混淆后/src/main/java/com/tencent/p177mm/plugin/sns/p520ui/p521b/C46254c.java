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

/* renamed from: com.tencent.mm.plugin.sns.ui.b.c */
public final class C46254c {
    public ValueAnimator nVD = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
    private Context rFO;
    public int rFP;
    public int rFQ;
    public int rFR;
    public int rFS;
    public C35111a rFT;
    View view;

    /* renamed from: com.tencent.mm.plugin.sns.ui.b.c$1 */
    class C40431 implements AnimatorUpdateListener {
        C40431() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(40006);
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            C46254c.this.view.setAlpha(1.0f - floatValue);
            if (floatValue != 0.0f) {
                LayoutParams layoutParams = (LayoutParams) C46254c.this.view.getLayoutParams();
                layoutParams.leftMargin = (int) (((float) C46254c.this.rFP) * floatValue);
                layoutParams.topMargin = (int) (((float) C46254c.this.rFQ) * floatValue);
                ViewGroup viewGroup = (ViewGroup) C46254c.this.view.getParent();
                layoutParams.rightMargin = (int) (((((float) viewGroup.getWidth()) * floatValue) - (((float) C46254c.this.rFR) * floatValue)) - ((float) layoutParams.leftMargin));
                layoutParams.bottomMargin = (int) (((((float) viewGroup.getHeight()) * floatValue) - (((float) C46254c.this.rFS) * floatValue)) - ((float) layoutParams.topMargin));
                C46254c.this.view.setLayoutParams(layoutParams);
            }
            if (C46254c.this.rFT != null) {
                C46254c.this.rFT.mo25680aZ(floatValue);
            }
            AppMethodBeat.m2505o(40006);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.b.c$2 */
    class C40442 extends AnimatorListenerAdapter {
        C40442() {
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.m2504i(40007);
            if (C46254c.this.rFT != null) {
                C46254c.this.rFT.onAnimationStart();
            }
            C46254c.this.view.setVisibility(0);
            AppMethodBeat.m2505o(40007);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(40008);
            if (C46254c.this.rFT != null) {
                C46254c.this.rFT.onAnimationEnd();
            }
            C46254c.this.view.setVisibility(8);
            AppMethodBeat.m2505o(40008);
        }
    }

    public C46254c(Activity activity, View view) {
        AppMethodBeat.m2504i(40009);
        this.rFO = activity;
        this.view = view;
        this.nVD.addUpdateListener(new C40431());
        this.nVD.addListener(new C40442());
        this.nVD.setDuration(400);
        AppMethodBeat.m2505o(40009);
    }
}
