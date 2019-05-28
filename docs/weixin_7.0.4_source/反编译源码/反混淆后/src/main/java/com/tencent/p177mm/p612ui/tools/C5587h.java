package com.tencent.p177mm.p612ui.tools;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorInflater;
import android.annotation.TargetApi;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.ui.tools.h */
public final class C5587h {

    /* renamed from: com.tencent.mm.ui.tools.h$a */
    public interface C5586a {
        void dbb();

        void onAnimationEnd();
    }

    @TargetApi(11)
    /* renamed from: r */
    public static final void m8389r(View view, float f) {
        AppMethodBeat.m2504i(107652);
        if (view == null || C1443d.m3067fP(11)) {
            AppMethodBeat.m2505o(107652);
            return;
        }
        Animator animator = (Animator) view.getTag(2131820652);
        if (animator != null) {
            animator.cancel();
        }
        view.setScaleX(f);
        view.setScaleY(f);
        AppMethodBeat.m2505o(107652);
    }

    @TargetApi(14)
    /* renamed from: s */
    public static final void m8390s(View view, float f) {
        AppMethodBeat.m2504i(107653);
        if (view == null || C1443d.m3067fP(14)) {
            AppMethodBeat.m2505o(107653);
            return;
        }
        Animator animator = (Animator) view.getTag(2131820652);
        if (animator != null) {
            animator.cancel();
        }
        view.animate().cancel();
        view.setTranslationX(f);
        view.setTranslationY(0.0f);
        AppMethodBeat.m2505o(107653);
    }

    @TargetApi(14)
    /* renamed from: a */
    public static final void m8387a(View view, long j, float f, final C5586a c5586a) {
        AppMethodBeat.m2504i(107654);
        if (view == null || C1443d.m3067fP(14)) {
            AppMethodBeat.m2505o(107654);
            return;
        }
        Animator animator = (Animator) view.getTag(2131820652);
        if (animator != null) {
            animator.cancel();
        }
        C4990ab.m7417i("Changelcai", "[animTran] duration:%s x:%s", Long.valueOf(j), Float.valueOf(f));
        view.animate().cancel();
        view.animate().setListener(null);
        Interpolator loadInterpolator = AnimationUtils.loadInterpolator(view.getContext(), C25738R.anim.f8348bn);
        if (c5586a == null) {
            view.animate().setDuration(j).translationX(f).translationY(0.0f).setInterpolator(loadInterpolator);
            AppMethodBeat.m2505o(107654);
            return;
        }
        view.animate().setDuration(j).translationX(f).translationY(0.0f).setInterpolator(loadInterpolator).setListener(new AnimatorListener() {
            public final void onAnimationStart(Animator animator) {
            }

            public final void onAnimationRepeat(Animator animator) {
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.m2504i(107650);
                c5586a.onAnimationEnd();
                AppMethodBeat.m2505o(107650);
            }

            public final void onAnimationCancel(Animator animator) {
                AppMethodBeat.m2504i(107651);
                c5586a.dbb();
                AppMethodBeat.m2505o(107651);
            }
        });
        AppMethodBeat.m2505o(107654);
    }

    @TargetApi(11)
    /* renamed from: a */
    public static void m8388a(View view, AnimatorListener animatorListener) {
        AppMethodBeat.m2504i(107655);
        if (view == null || C1443d.m3067fP(11)) {
            AppMethodBeat.m2505o(107655);
            return;
        }
        Animator animator = (Animator) view.getTag(2131820652);
        if (animator != null) {
            animator.cancel();
        }
        animator = AnimatorInflater.loadAnimator(view.getContext(), C25738R.animator.f8458b);
        animator.setTarget(view);
        if (animatorListener != null) {
            animator.addListener(animatorListener);
        }
        animator.start();
        view.setTag(2131820652, animator);
        AppMethodBeat.m2505o(107655);
    }
}
