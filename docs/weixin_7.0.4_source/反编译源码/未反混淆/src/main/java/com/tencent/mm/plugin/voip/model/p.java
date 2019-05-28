package com.tencent.mm.plugin.voip.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.lang.ref.WeakReference;

public final class p {
    public static p sSH;
    private boolean sSA = false;
    private WeakReference<a> sSB;
    int sSC = -1;
    boolean sSD = false;
    private int sSE = 0;
    public int sSF;
    public int sSG;
    ap sSI = new ap(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(4567);
            if (p.this.sSD) {
                p pVar = p.this;
                byte[] bArr = new byte[4];
                int[] iArr = new int[]{-1, -1};
                if (pVar.sSz.setAppCmd(10, bArr, 4) < 0) {
                    ab.d("MicroMsg.VoipNetStatusChecker", "get netStatus failed");
                } else {
                    iArr[0] = bo.bf(bArr);
                    iArr[1] = pVar.sSz.GetNetBottleneckSide();
                    ab.d("MicroMsg.VoipNetStatusChecker", "netStatus: %d net_bottleneck_side %d", Integer.valueOf(r4), Integer.valueOf(iArr[1]));
                }
                if (iArr[0] != -1) {
                    p.this.sSC = iArr[0];
                    p.this.sSF = p.this.sSC + p.this.sSF;
                    pVar = p.this;
                    pVar.sSG++;
                    if (iArr[1] == 0) {
                        p.a(p.this, true);
                    } else {
                        p.a(p.this, false);
                    }
                }
                AppMethodBeat.o(4567);
                return true;
            }
            AppMethodBeat.o(4567);
            return false;
        }
    }, true);
    v2protocal sSz = new v2protocal(new ak(Looper.getMainLooper()));

    public interface a {
        void bGR();

        void ig(boolean z);
    }

    public static p cJR() {
        AppMethodBeat.i(4570);
        if (sSH == null) {
            sSH = new p();
        }
        p pVar = sSH;
        AppMethodBeat.o(4570);
        return pVar;
    }

    private p() {
        AppMethodBeat.i(4571);
        AppMethodBeat.o(4571);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(4572);
        this.sSB = new WeakReference(aVar);
        AppMethodBeat.o(4572);
    }

    public final void cJS() {
        AppMethodBeat.i(4573);
        ab.d("MicroMsg.VoipNetStatusChecker", "startNetStatusCheck");
        this.sSC = -1;
        this.sSD = true;
        this.sSG = 0;
        this.sSF = 0;
        al.n(new Runnable() {
            public final void run() {
                AppMethodBeat.i(4568);
                p.this.sSI.ae(FaceGestureDetGLThread.BRIGHTNESS_DURATION, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
                AppMethodBeat.o(4568);
            }
        }, 3000);
        AppMethodBeat.o(4573);
    }

    public final void cJT() {
        AppMethodBeat.i(4574);
        ab.d("MicroMsg.VoipNetStatusChecker", "stopNetStatusCheck");
        this.sSC = -1;
        this.sSA = false;
        this.sSD = false;
        this.sSG = 0;
        this.sSF = 0;
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(4569);
                p.this.sSI.stopTimer();
                AppMethodBeat.o(4569);
            }
        });
        AppMethodBeat.o(4574);
    }

    static /* synthetic */ void a(p pVar, boolean z) {
        AppMethodBeat.i(4575);
        a aVar;
        if (pVar.sSC < 5) {
            pVar.sSE = 0;
            if (!pVar.sSA) {
                pVar.sSA = true;
                ab.d("MicroMsg.VoipNetStatusChecker", "go to bad net status");
                if (pVar.sSB != null) {
                    aVar = (a) pVar.sSB.get();
                    if (aVar != null) {
                        aVar.ig(z);
                    }
                    AppMethodBeat.o(4575);
                    return;
                }
            }
        } else if (pVar.sSA) {
            if (pVar.sSE <= 0) {
                ab.d("MicroMsg.VoipNetStatusChecker", "ignore this good net status");
                pVar.sSE++;
                AppMethodBeat.o(4575);
                return;
            }
            pVar.sSA = false;
            ab.d("MicroMsg.VoipNetStatusChecker", "go to good net status");
            if (pVar.sSB != null) {
                aVar = (a) pVar.sSB.get();
                if (aVar != null) {
                    aVar.bGR();
                }
            }
        }
        AppMethodBeat.o(4575);
    }
}
