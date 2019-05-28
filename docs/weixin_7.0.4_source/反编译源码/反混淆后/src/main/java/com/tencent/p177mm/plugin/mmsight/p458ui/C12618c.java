package com.tencent.p177mm.plugin.mmsight.p458ui;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;

/* renamed from: com.tencent.mm.plugin.mmsight.ui.c */
public final class C12618c {
    boolean cFy;
    private int duration;
    float end;
    long eyR;
    C7564ap fJs = null;
    private float oCe = 0.0f;
    float oCf;
    C3509a oCg;
    private Runnable oCh = new C126202();
    private float start;

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.c$a */
    public interface C3509a {
        /* renamed from: aO */
        void mo7975aO(float f);

        void onAnimationEnd();
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.c$1 */
    class C126191 implements C5015a {
        C126191() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(55176);
            C12618c.m20584a(C12618c.this);
            if (!C12618c.this.cFy) {
                C4990ab.m7416i("MicroMsg.ProgressHandlerAnimator", "isStart is false now");
                AppMethodBeat.m2505o(55176);
                return false;
            } else if (C12618c.this.oCf < C12618c.this.end) {
                AppMethodBeat.m2505o(55176);
                return true;
            } else {
                C12618c.this.cFy = false;
                C4990ab.m7417i("MicroMsg.ProgressHandlerAnimator", "reach end, currentValue: %s, end: %s, callback: %s", Float.valueOf(C12618c.this.oCf), Float.valueOf(C12618c.this.end), C12618c.this.oCg);
                if (C12618c.this.oCg != null) {
                    C12618c.this.oCg.onAnimationEnd();
                }
                AppMethodBeat.m2505o(55176);
                return false;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.c$2 */
    class C126202 implements Runnable {
        C126202() {
        }

        public final void run() {
            AppMethodBeat.m2504i(55177);
            C12618c.m20584a(C12618c.this);
            if (!C12618c.this.cFy) {
                C4990ab.m7416i("MicroMsg.ProgressHandlerAnimator", "isStart is false now");
            } else if (C12618c.this.oCf < C12618c.this.end) {
                C12618c.this.fJs.post(this);
                AppMethodBeat.m2505o(55177);
                return;
            } else {
                C12618c.this.cFy = false;
                C4990ab.m7417i("MicroMsg.ProgressHandlerAnimator", "reach end, currentValue: %s, end: %s", Float.valueOf(C12618c.this.oCf), Float.valueOf(C12618c.this.end));
                if (C12618c.this.oCg != null) {
                    C12618c.this.oCg.onAnimationEnd();
                    AppMethodBeat.m2505o(55177);
                    return;
                }
            }
            AppMethodBeat.m2505o(55177);
        }
    }

    public C12618c(float f, float f2, int i) {
        AppMethodBeat.m2504i(55178);
        this.start = f;
        this.end = f2;
        this.duration = i;
        if (f2 > f) {
            this.oCe = ((f2 - f) / ((float) this.duration)) * 20.0f;
        }
        C4990ab.m7417i("MicroMsg.ProgressHandlerAnimator", "create ProgressHandlerAnimator, start: %s, end: %s, duration: %s, updateStep: %s", Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Float.valueOf(this.oCe));
        this.cFy = false;
        this.eyR = 0;
        this.fJs = new C7564ap(Looper.getMainLooper(), new C126191(), true);
        AppMethodBeat.m2505o(55178);
    }

    /* renamed from: a */
    static /* synthetic */ void m20584a(C12618c c12618c) {
        AppMethodBeat.m2504i(55179);
        c12618c.oCf = (((float) C5046bo.m7525az(c12618c.eyR)) / ((float) c12618c.duration)) * (c12618c.end - c12618c.start);
        if (c12618c.oCg != null) {
            c12618c.oCg.mo7975aO(c12618c.oCf);
        }
        AppMethodBeat.m2505o(55179);
    }
}
