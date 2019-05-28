package com.tencent.p177mm.plugin.voip.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.mm.plugin.voip.model.p */
public final class C35355p {
    public static C35355p sSH;
    private boolean sSA = false;
    private WeakReference<C35357a> sSB;
    int sSC = -1;
    boolean sSD = false;
    private int sSE = 0;
    public int sSF;
    public int sSG;
    C7564ap sSI = new C7564ap(Looper.getMainLooper(), new C353561(), true);
    v2protocal sSz = new v2protocal(new C7306ak(Looper.getMainLooper()));

    /* renamed from: com.tencent.mm.plugin.voip.model.p$3 */
    class C224613 implements Runnable {
        C224613() {
        }

        public final void run() {
            AppMethodBeat.m2504i(4569);
            C35355p.this.sSI.stopTimer();
            AppMethodBeat.m2505o(4569);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.model.p$2 */
    class C295012 implements Runnable {
        C295012() {
        }

        public final void run() {
            AppMethodBeat.m2504i(4568);
            C35355p.this.sSI.mo16770ae(FaceGestureDetGLThread.BRIGHTNESS_DURATION, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
            AppMethodBeat.m2505o(4568);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.model.p$1 */
    class C353561 implements C5015a {
        C353561() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(4567);
            if (C35355p.this.sSD) {
                C35355p c35355p = C35355p.this;
                byte[] bArr = new byte[4];
                int[] iArr = new int[]{-1, -1};
                if (c35355p.sSz.setAppCmd(10, bArr, 4) < 0) {
                    C4990ab.m7410d("MicroMsg.VoipNetStatusChecker", "get netStatus failed");
                } else {
                    iArr[0] = C5046bo.m7533bf(bArr);
                    iArr[1] = c35355p.sSz.GetNetBottleneckSide();
                    C4990ab.m7411d("MicroMsg.VoipNetStatusChecker", "netStatus: %d net_bottleneck_side %d", Integer.valueOf(r4), Integer.valueOf(iArr[1]));
                }
                if (iArr[0] != -1) {
                    C35355p.this.sSC = iArr[0];
                    C35355p.this.sSF = C35355p.this.sSC + C35355p.this.sSF;
                    c35355p = C35355p.this;
                    c35355p.sSG++;
                    if (iArr[1] == 0) {
                        C35355p.m58018a(C35355p.this, true);
                    } else {
                        C35355p.m58018a(C35355p.this, false);
                    }
                }
                AppMethodBeat.m2505o(4567);
                return true;
            }
            AppMethodBeat.m2505o(4567);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.model.p$a */
    public interface C35357a {
        void bGR();

        /* renamed from: ig */
        void mo30909ig(boolean z);
    }

    public static C35355p cJR() {
        AppMethodBeat.m2504i(4570);
        if (sSH == null) {
            sSH = new C35355p();
        }
        C35355p c35355p = sSH;
        AppMethodBeat.m2505o(4570);
        return c35355p;
    }

    private C35355p() {
        AppMethodBeat.m2504i(4571);
        AppMethodBeat.m2505o(4571);
    }

    /* renamed from: a */
    public final void mo56094a(C35357a c35357a) {
        AppMethodBeat.m2504i(4572);
        this.sSB = new WeakReference(c35357a);
        AppMethodBeat.m2505o(4572);
    }

    public final void cJS() {
        AppMethodBeat.m2504i(4573);
        C4990ab.m7410d("MicroMsg.VoipNetStatusChecker", "startNetStatusCheck");
        this.sSC = -1;
        this.sSD = true;
        this.sSG = 0;
        this.sSF = 0;
        C5004al.m7442n(new C295012(), 3000);
        AppMethodBeat.m2505o(4573);
    }

    public final void cJT() {
        AppMethodBeat.m2504i(4574);
        C4990ab.m7410d("MicroMsg.VoipNetStatusChecker", "stopNetStatusCheck");
        this.sSC = -1;
        this.sSA = false;
        this.sSD = false;
        this.sSG = 0;
        this.sSF = 0;
        C5004al.m7441d(new C224613());
        AppMethodBeat.m2505o(4574);
    }

    /* renamed from: a */
    static /* synthetic */ void m58018a(C35355p c35355p, boolean z) {
        AppMethodBeat.m2504i(4575);
        C35357a c35357a;
        if (c35355p.sSC < 5) {
            c35355p.sSE = 0;
            if (!c35355p.sSA) {
                c35355p.sSA = true;
                C4990ab.m7410d("MicroMsg.VoipNetStatusChecker", "go to bad net status");
                if (c35355p.sSB != null) {
                    c35357a = (C35357a) c35355p.sSB.get();
                    if (c35357a != null) {
                        c35357a.mo30909ig(z);
                    }
                    AppMethodBeat.m2505o(4575);
                    return;
                }
            }
        } else if (c35355p.sSA) {
            if (c35355p.sSE <= 0) {
                C4990ab.m7410d("MicroMsg.VoipNetStatusChecker", "ignore this good net status");
                c35355p.sSE++;
                AppMethodBeat.m2505o(4575);
                return;
            }
            c35355p.sSA = false;
            C4990ab.m7410d("MicroMsg.VoipNetStatusChecker", "go to good net status");
            if (c35355p.sSB != null) {
                c35357a = (C35357a) c35355p.sSB.get();
                if (c35357a != null) {
                    c35357a.bGR();
                }
            }
        }
        AppMethodBeat.m2505o(4575);
    }
}
