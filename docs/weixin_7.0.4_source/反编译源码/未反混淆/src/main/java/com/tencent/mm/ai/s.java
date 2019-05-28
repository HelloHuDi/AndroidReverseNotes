package com.tencent.mm.ai;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.l.a;
import com.tencent.mm.network.q;
import com.tencent.mm.network.r;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;

public final class s extends a {
    private final m cwn;
    private boolean eVT = false;
    private final long ftT = 330000;
    private q ftU;
    private k ftV;
    private boolean ftW = false;
    Runnable ftX = new Runnable() {
        public final void run() {
            int i = 0;
            AppMethodBeat.i(58259);
            if (s.this.eVT || s.this.ftW) {
                String str = "MicroMsg.RemoteOnGYNetEnd";
                String str2 = "time exceed But removeCallbacks failed hash:%d type:%d";
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(s.this.cwn == null ? 0 : s.this.cwn.hashCode());
                if (s.this.cwn != null) {
                    i = s.this.cwn.getType();
                }
                objArr[1] = Integer.valueOf(i);
                ab.e(str, str2, objArr);
                AppMethodBeat.o(58259);
                return;
            }
            final boolean a = s.this.eVT;
            final boolean b = s.this.ftW;
            String str3 = "MicroMsg.RemoteOnGYNetEnd";
            String str4 = "time exceed, force to callback hash:%d type:%d";
            Object[] objArr2 = new Object[2];
            objArr2[0] = Integer.valueOf(s.this.cwn == null ? 0 : s.this.cwn.hashCode());
            if (s.this.cwn != null) {
                i = s.this.cwn.getType();
            }
            objArr2[1] = Integer.valueOf(i);
            ab.w(str3, str4, objArr2);
            s.this.eVT = true;
            d.post(new Runnable() {
                public final void run() {
                    int i = 0;
                    AppMethodBeat.i(58258);
                    s.this.ftf.qt("push process's network haven't callback in 5.5min!!!! cancelStatus:" + a + " hasCallbackStatus:" + b);
                    String str = "MicroMsg.RemoteOnGYNetEnd";
                    String str2 = "time exceed, force to callback . kill push fin. hash:%d type:%d";
                    Object[] objArr = new Object[2];
                    objArr[0] = Integer.valueOf(s.this.cwn == null ? 0 : s.this.cwn.hashCode());
                    if (s.this.cwn != null) {
                        i = s.this.cwn.getType();
                    }
                    objArr[1] = Integer.valueOf(i);
                    ab.w(str, str2, objArr);
                    AppMethodBeat.o(58258);
                }
            }, "RemoteOnGYNetEnd_killPush");
            s.this.ftV.a(-1, 3, -1, "time exceed, force to callback", s.this.ftU, null);
            AppMethodBeat.o(58259);
        }
    };
    private final e ftf;
    private final f ftj;
    final ak handler;

    public s(q qVar, k kVar, m mVar, f fVar, e eVar) {
        AppMethodBeat.i(58261);
        this.ftU = qVar;
        this.ftV = kVar;
        this.cwn = mVar;
        this.ftj = fVar;
        this.handler = Looper.myLooper() == null ? new ak(Looper.getMainLooper()) : new ak();
        this.ftf = eVar;
        AppMethodBeat.o(58261);
    }

    public final void cancel() {
        AppMethodBeat.i(58262);
        this.eVT = true;
        this.handler.removeCallbacks(this.ftX);
        AppMethodBeat.o(58262);
    }

    public final void a(int i, int i2, int i3, String str, r rVar, byte[] bArr) {
        AppMethodBeat.i(58263);
        ab.i("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd netId:%d, errType:%d, errCode:%d, isCancel:%b, hash[%d,%d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(this.eVT), Integer.valueOf(this.cwn.hashCode()), Integer.valueOf(this.ftU.hashCode()));
        this.cwn.fth = -1;
        if (this.eVT) {
            AppMethodBeat.o(58263);
        } else if (this.ftW) {
            AppMethodBeat.o(58263);
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
                    AppMethodBeat.i(58260);
                    if (s.this.eVT) {
                        ab.w("MicroMsg.RemoteOnGYNetEnd", "netId:%d has been canceled", Integer.valueOf(i4));
                        AppMethodBeat.o(58260);
                        return;
                    }
                    int i = i5;
                    int i2 = i6;
                    if (10016 == ae.giz && !bo.isNullOrNil(ae.giB)) {
                        ab.i("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd DK TEST SET : %s ", ae.giB);
                        String[] split = ae.giB.split(",");
                        if (split != null && split.length == 3 && bo.getInt(split[0], -1) == s.this.cwn.getType()) {
                            i = bo.getInt(split[1], 0);
                            i2 = bo.getInt(split[2], 0);
                            if (i == 999) {
                                ab.w("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd DK TEST SET syncservice : %s  NOT  CALLBACK !!!", ae.giB);
                                AppMethodBeat.o(58260);
                                return;
                            }
                        }
                    }
                    ab.i("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd after post to worker netId:%d, errType:%d, errCode:%d, isCancel:%b, hashcode:%d", Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(s.this.eVT), Integer.valueOf(s.this.cwn.hashCode()));
                    s.this.ftV.a(i4, i, i2, str2, s.this.ftU, bArr2);
                    if (s.this.cwn.acM() && !s.this.cwn.ftk) {
                        ab.e("MicroMsg.RemoteOnGYNetEnd", "the netscene hasn't call callback to onSceneEnd, type:%d", Integer.valueOf(s.this.cwn.getType()));
                        ab.dot();
                    }
                    AppMethodBeat.o(58260);
                }
            });
            AppMethodBeat.o(58263);
        }
    }
}
