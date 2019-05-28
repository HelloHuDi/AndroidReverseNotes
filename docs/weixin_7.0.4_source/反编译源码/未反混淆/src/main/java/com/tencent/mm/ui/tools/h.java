package com.tencent.mm.ui.tools;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorInflater;
import android.annotation.TargetApi;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ab;

public final class h {

    public interface a {
        void dbb();

        void onAnimationEnd();
    }

    @TargetApi(11)
    public static final void r(View view, float f) {
        AppMethodBeat.i(107652);
        if (view == null || d.fP(11)) {
            AppMethodBeat.o(107652);
            return;
        }
        Animator animator = (Animator) view.getTag(R.id.c8);
        if (animator != null) {
            animator.cancel();
        }
        view.setScaleX(f);
        view.setScaleY(f);
        AppMethodBeat.o(107652);
    }

    @TargetApi(14)
    public static final void s(View view, float f) {
        AppMethodBeat.i(107653);
        if (view == null || d.fP(14)) {
            AppMethodBeat.o(107653);
            return;
        }
        Animator animator = (Animator) view.getTag(R.id.c8);
        if (animator != null) {
            animator.cancel();
        }
        view.animate().cancel();
        view.setTranslationX(f);
        view.setTranslationY(0.0f);
        AppMethodBeat.o(107653);
    }

    @TargetApi(14)
    public static final void a(View view, long j, float f, final a aVar) {
        AppMethodBeat.i(107654);
        if (view == null || d.fP(14)) {
            AppMethodBeat.o(107654);
            return;
        }
        Animator animator = (Animator) view.getTag(R.id.c8);
        if (animator != null) {
            animator.cancel();
        }
        ab.i("Changelcai", "[animTran] duration:%s x:%s", Long.valueOf(j), Float.valueOf(f));
        view.animate().cancel();
        view.animate().setListener(null);
        Interpolator loadInterpolator = AnimationUtils.loadInterpolator(view.getContext(), R.anim.bn);
        if (aVar == null) {
            view.animate().setDuration(j).translationX(f).translationY(0.0f).setInterpolator(loadInterpolator);
            AppMethodBeat.o(107654);
            return;
        }
        view.animate().setDuration(j).translationX(f).translationY(0.0f).setInterpolator(loadInterpolator).setListener(new AnimatorListener() {
            public final void onAnimationStart(Animator animator) {
            }

            public final void onAnimationRepeat(Animator animator) {
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(107650);
                aVar.onAnimationEnd();
                AppMethodBeat.o(107650);
            }

            public final void onAnimationCancel(Animator animator) {
                AppMethodBeat.i(107651);
                aVar.dbb();
                AppMethodBeat.o(107651);
            }
        });
        AppMethodBeat.o(107654);
    }

    @TargetApi(11)
    public static void a(View view, AnimatorListener animatorListener) {
        AppMethodBeat.i(107655);
        if (view == null || d.fP(11)) {
            AppMethodBeat.o(107655);
            return;
        }
        Animator animator = (Animator) view.getTag(R.id.c8);
        if (animator != null) {
            animator.cancel();
        }
        animator = AnimatorInflater.loadAnimator(view.getContext(), R.animator.b);
        animator.setTarget(view);
        if (animatorListener != null) {
            animator.addListener(animatorListener);
        }
        animator.start();
        view.setTag(R.id.c8, animator);
        AppMethodBeat.o(107655);
    }
}
