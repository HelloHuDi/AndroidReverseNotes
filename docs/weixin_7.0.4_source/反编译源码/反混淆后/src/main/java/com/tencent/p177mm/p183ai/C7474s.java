package com.tencent.p177mm.p183ai;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1919l.C1920a;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.network.C1930r;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.ai.s */
public final class C7474s extends C1920a {
    private final C1207m cwn;
    private boolean eVT = false;
    private final long ftT = 330000;
    private C1929q ftU;
    private C1918k ftV;
    private boolean ftW = false;
    Runnable ftX = new C12151();
    private final C1902e ftf;
    private final C1202f ftj;
    final C7306ak handler;

    /* renamed from: com.tencent.mm.ai.s$1 */
    class C12151 implements Runnable {
        C12151() {
        }

        public final void run() {
            int i = 0;
            AppMethodBeat.m2504i(58259);
            if (C7474s.this.eVT || C7474s.this.ftW) {
                String str = "MicroMsg.RemoteOnGYNetEnd";
                String str2 = "time exceed But removeCallbacks failed hash:%d type:%d";
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(C7474s.this.cwn == null ? 0 : C7474s.this.cwn.hashCode());
                if (C7474s.this.cwn != null) {
                    i = C7474s.this.cwn.getType();
                }
                objArr[1] = Integer.valueOf(i);
                C4990ab.m7413e(str, str2, objArr);
                AppMethodBeat.m2505o(58259);
                return;
            }
            final boolean a = C7474s.this.eVT;
            final boolean b = C7474s.this.ftW;
            String str3 = "MicroMsg.RemoteOnGYNetEnd";
            String str4 = "time exceed, force to callback hash:%d type:%d";
            Object[] objArr2 = new Object[2];
            objArr2[0] = Integer.valueOf(C7474s.this.cwn == null ? 0 : C7474s.this.cwn.hashCode());
            if (C7474s.this.cwn != null) {
                i = C7474s.this.cwn.getType();
            }
            objArr2[1] = Integer.valueOf(i);
            C4990ab.m7421w(str3, str4, objArr2);
            C7474s.this.eVT = true;
            C7305d.post(new Runnable() {
                public final void run() {
                    int i = 0;
                    AppMethodBeat.m2504i(58258);
                    C7474s.this.ftf.mo5542qt("push process's network haven't callback in 5.5min!!!! cancelStatus:" + a + " hasCallbackStatus:" + b);
                    String str = "MicroMsg.RemoteOnGYNetEnd";
                    String str2 = "time exceed, force to callback . kill push fin. hash:%d type:%d";
                    Object[] objArr = new Object[2];
                    objArr[0] = Integer.valueOf(C7474s.this.cwn == null ? 0 : C7474s.this.cwn.hashCode());
                    if (C7474s.this.cwn != null) {
                        i = C7474s.this.cwn.getType();
                    }
                    objArr[1] = Integer.valueOf(i);
                    C4990ab.m7421w(str, str2, objArr);
                    AppMethodBeat.m2505o(58258);
                }
            }, "RemoteOnGYNetEnd_killPush");
            C7474s.this.ftV.mo4498a(-1, 3, -1, "time exceed, force to callback", C7474s.this.ftU, null);
            AppMethodBeat.m2505o(58259);
        }
    }

    public C7474s(C1929q c1929q, C1918k c1918k, C1207m c1207m, C1202f c1202f, C1902e c1902e) {
        AppMethodBeat.m2504i(58261);
        this.ftU = c1929q;
        this.ftV = c1918k;
        this.cwn = c1207m;
        this.ftj = c1202f;
        this.handler = Looper.myLooper() == null ? new C7306ak(Looper.getMainLooper()) : new C7306ak();
        this.ftf = c1902e;
        AppMethodBeat.m2505o(58261);
    }

    public final void cancel() {
        AppMethodBeat.m2504i(58262);
        this.eVT = true;
        this.handler.removeCallbacks(this.ftX);
        AppMethodBeat.m2505o(58262);
    }

    /* renamed from: a */
    public final void mo5606a(int i, int i2, int i3, String str, C1930r c1930r, byte[] bArr) {
        AppMethodBeat.m2504i(58263);
        C4990ab.m7417i("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd netId:%d, errType:%d, errCode:%d, isCancel:%b, hash[%d,%d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(this.eVT), Integer.valueOf(this.cwn.hashCode()), Integer.valueOf(this.ftU.hashCode()));
        this.cwn.fth = -1;
        if (this.eVT) {
            AppMethodBeat.m2505o(58263);
        } else if (this.ftW) {
            AppMethodBeat.m2505o(58263);
        } else {
            this.ftW = true;
            this.handler.removeCallbacks(this.ftX);
            final int i4 = i;
            final int i5 = i2;
            final int i6 = i3;
            final String str2 = str;
            final byte[] bArr2 = bArr;
            this.handler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(58260);
                    if (C7474s.this.eVT) {
                        C4990ab.m7421w("MicroMsg.RemoteOnGYNetEnd", "netId:%d has been canceled", Integer.valueOf(i4));
                        AppMethodBeat.m2505o(58260);
                        return;
                    }
                    int i = i5;
                    int i2 = i6;
                    if (10016 == C1947ae.giz && !C5046bo.isNullOrNil(C1947ae.giB)) {
                        C4990ab.m7417i("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd DK TEST SET : %s ", C1947ae.giB);
                        String[] split = C1947ae.giB.split(",");
                        if (split != null && split.length == 3 && C5046bo.getInt(split[0], -1) == C7474s.this.cwn.getType()) {
                            i = C5046bo.getInt(split[1], 0);
                            i2 = C5046bo.getInt(split[2], 0);
                            if (i == 999) {
                                C4990ab.m7421w("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd DK TEST SET syncservice : %s  NOT  CALLBACK !!!", C1947ae.giB);
                                AppMethodBeat.m2505o(58260);
                                return;
                            }
                        }
                    }
                    C4990ab.m7417i("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd after post to worker netId:%d, errType:%d, errCode:%d, isCancel:%b, hashcode:%d", Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(C7474s.this.eVT), Integer.valueOf(C7474s.this.cwn.hashCode()));
                    C7474s.this.ftV.mo4498a(i4, i, i2, str2, C7474s.this.ftU, bArr2);
                    if (C7474s.this.cwn.acM() && !C7474s.this.cwn.ftk) {
                        C4990ab.m7413e("MicroMsg.RemoteOnGYNetEnd", "the netscene hasn't call callback to onSceneEnd, type:%d", Integer.valueOf(C7474s.this.cwn.getType()));
                        C4990ab.dot();
                    }
                    AppMethodBeat.m2505o(58260);
                }
            });
            AppMethodBeat.m2505o(58263);
        }
    }
}
