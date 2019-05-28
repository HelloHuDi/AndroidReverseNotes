package com.tencent.mm.plugin.sns.abtest;

import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.AbsoluteLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.abtest.NotInterestMenu.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;

public final class b {
    int acV = 0;
    int iJp = 0;
    int mScreenHeight = 0;
    ViewGroup qCA;
    com.tencent.mm.plugin.sns.abtest.NotInterestMenu.b qCB = new com.tencent.mm.plugin.sns.abtest.NotInterestMenu.b() {
        public final void clZ() {
            AppMethodBeat.i(35670);
            b.this.cma();
            AppMethodBeat.o(35670);
        }
    };
    Animation qCC = null;
    Animation qCD = null;
    private Animation qCE = null;
    private Animation qCF = null;
    int qCG = 0;
    int qCH = 0;
    int qCI = 0;
    int qCJ = 0;
    int qCK = 0;
    boolean qCL = false;
    AbsoluteLayout qCM = null;
    boolean qCN = false;
    boolean qCO = false;
    c qCu;
    NotInterestMenu qCz;

    public b(ViewGroup viewGroup) {
        AppMethodBeat.i(35677);
        this.qCA = viewGroup;
        this.qCC = AnimationUtils.loadAnimation(ah.getContext(), R.anim.al);
        this.qCC.setFillAfter(true);
        this.qCC.setDuration(100);
        this.qCC.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
                b.this.qCN = true;
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(35671);
                if (b.this.qCz != null) {
                    b.this.qCz.setVisibility(0);
                }
                b.this.qCN = false;
                b.this.qCL = true;
                AppMethodBeat.o(35671);
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        this.qCD = AnimationUtils.loadAnimation(ah.getContext(), R.anim.ao);
        this.qCD.setFillAfter(true);
        this.qCD.setDuration(100);
        this.qCD.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
                b.this.qCN = true;
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(35672);
                if (b.this.qCz != null) {
                    b.this.qCz.setVisibility(0);
                }
                b.this.qCN = false;
                b.this.qCL = true;
                AppMethodBeat.o(35672);
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        this.qCE = AnimationUtils.loadAnimation(ah.getContext(), R.anim.am);
        this.qCE.setFillAfter(true);
        this.qCE.setDuration(100);
        this.qCE.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
                b.this.qCN = true;
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(35674);
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(35673);
                        b.this.cma();
                        AppMethodBeat.o(35673);
                    }
                });
                b.this.qCN = false;
                AppMethodBeat.o(35674);
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        this.qCF = AnimationUtils.loadAnimation(ah.getContext(), R.anim.an);
        this.qCF.setFillAfter(true);
        this.qCF.setDuration(100);
        this.qCF.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
                b.this.qCN = true;
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(35676);
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(35675);
                        b.this.cma();
                        AppMethodBeat.o(35675);
                    }
                });
                b.this.qCN = false;
                AppMethodBeat.o(35676);
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        AppMethodBeat.o(35677);
    }

    public final void cma() {
        AppMethodBeat.i(35678);
        if (!(this.qCM == null || this.qCA == null || this.qCz == null)) {
            this.qCM.removeView(this.qCz);
            this.qCA.removeView(this.qCM);
            this.qCM = null;
            this.qCz = null;
            this.qCL = false;
        }
        AppMethodBeat.o(35678);
    }
}
