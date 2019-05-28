package com.tencent.p177mm.plugin.sns.abtest;

import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.AbsoluteLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.sns.abtest.NotInterestMenu.C21862b;
import com.tencent.p177mm.plugin.sns.abtest.NotInterestMenu.C21864c;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;

/* renamed from: com.tencent.mm.plugin.sns.abtest.b */
public final class C21870b {
    int acV = 0;
    int iJp = 0;
    int mScreenHeight = 0;
    ViewGroup qCA;
    C21862b qCB = new C218711();
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
    C21864c qCu;
    NotInterestMenu qCz;

    /* renamed from: com.tencent.mm.plugin.sns.abtest.b$2 */
    class C38652 implements AnimationListener {
        C38652() {
        }

        public final void onAnimationStart(Animation animation) {
            C21870b.this.qCN = true;
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(35671);
            if (C21870b.this.qCz != null) {
                C21870b.this.qCz.setVisibility(0);
            }
            C21870b.this.qCN = false;
            C21870b.this.qCL = true;
            AppMethodBeat.m2505o(35671);
        }

        public final void onAnimationRepeat(Animation animation) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.abtest.b$3 */
    class C38663 implements AnimationListener {
        C38663() {
        }

        public final void onAnimationStart(Animation animation) {
            C21870b.this.qCN = true;
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(35672);
            if (C21870b.this.qCz != null) {
                C21870b.this.qCz.setVisibility(0);
            }
            C21870b.this.qCN = false;
            C21870b.this.qCL = true;
            AppMethodBeat.m2505o(35672);
        }

        public final void onAnimationRepeat(Animation animation) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.abtest.b$5 */
    class C38675 implements AnimationListener {

        /* renamed from: com.tencent.mm.plugin.sns.abtest.b$5$1 */
        class C38681 implements Runnable {
            C38681() {
            }

            public final void run() {
                AppMethodBeat.m2504i(35675);
                C21870b.this.cma();
                AppMethodBeat.m2505o(35675);
            }
        }

        C38675() {
        }

        public final void onAnimationStart(Animation animation) {
            C21870b.this.qCN = true;
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(35676);
            C5004al.m7441d(new C38681());
            C21870b.this.qCN = false;
            AppMethodBeat.m2505o(35676);
        }

        public final void onAnimationRepeat(Animation animation) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.abtest.b$1 */
    class C218711 implements C21862b {
        C218711() {
        }

        public final void clZ() {
            AppMethodBeat.m2504i(35670);
            C21870b.this.cma();
            AppMethodBeat.m2505o(35670);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.abtest.b$4 */
    class C218724 implements AnimationListener {

        /* renamed from: com.tencent.mm.plugin.sns.abtest.b$4$1 */
        class C218731 implements Runnable {
            C218731() {
            }

            public final void run() {
                AppMethodBeat.m2504i(35673);
                C21870b.this.cma();
                AppMethodBeat.m2505o(35673);
            }
        }

        C218724() {
        }

        public final void onAnimationStart(Animation animation) {
            C21870b.this.qCN = true;
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(35674);
            C5004al.m7441d(new C218731());
            C21870b.this.qCN = false;
            AppMethodBeat.m2505o(35674);
        }

        public final void onAnimationRepeat(Animation animation) {
        }
    }

    public C21870b(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(35677);
        this.qCA = viewGroup;
        this.qCC = AnimationUtils.loadAnimation(C4996ah.getContext(), C25738R.anim.f8316al);
        this.qCC.setFillAfter(true);
        this.qCC.setDuration(100);
        this.qCC.setAnimationListener(new C38652());
        this.qCD = AnimationUtils.loadAnimation(C4996ah.getContext(), C25738R.anim.f8319ao);
        this.qCD.setFillAfter(true);
        this.qCD.setDuration(100);
        this.qCD.setAnimationListener(new C38663());
        this.qCE = AnimationUtils.loadAnimation(C4996ah.getContext(), C25738R.anim.f8317am);
        this.qCE.setFillAfter(true);
        this.qCE.setDuration(100);
        this.qCE.setAnimationListener(new C218724());
        this.qCF = AnimationUtils.loadAnimation(C4996ah.getContext(), C25738R.anim.f8318an);
        this.qCF.setFillAfter(true);
        this.qCF.setDuration(100);
        this.qCF.setAnimationListener(new C38675());
        AppMethodBeat.m2505o(35677);
    }

    public final void cma() {
        AppMethodBeat.m2504i(35678);
        if (!(this.qCM == null || this.qCA == null || this.qCz == null)) {
            this.qCM.removeView(this.qCz);
            this.qCA.removeView(this.qCM);
            this.qCM = null;
            this.qCz = null;
            this.qCL = false;
        }
        AppMethodBeat.m2505o(35678);
    }
}
