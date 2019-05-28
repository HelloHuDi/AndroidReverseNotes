package com.tencent.mm.plugin.fingerprint.b;

import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.g.a.hd;
import com.tencent.mm.g.a.hd.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.mm.plugin.fingerprint.c.e;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.wallet_core.c.w;

public final class f extends c<hd> implements com.tencent.mm.ai.f {
    private String czZ;
    private hd mrB;
    private int mrC;
    ak mrD;
    private boolean mru;

    class a implements com.tencent.mm.plugin.fingerprint.b.q.a {
        private a() {
        }

        /* synthetic */ a(f fVar, byte b) {
            this();
        }

        public final void AR(final String str) {
            AppMethodBeat.i(41472);
            f.this.mrD.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(41471);
                    if (TextUtils.isEmpty(str)) {
                        ab.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "rsaKey is null");
                    }
                    m eVar = new e(str);
                    g.RQ();
                    g.RO().eJo.a(eVar, 0);
                    AppMethodBeat.o(41471);
                }
            });
            AppMethodBeat.o(41472);
        }
    }

    public f() {
        AppMethodBeat.i(41473);
        this.mrC = 0;
        this.czZ = "";
        this.mru = false;
        this.mrD = new ak(Looper.getMainLooper());
        this.xxI = hd.class.getName().hashCode();
        AppMethodBeat.o(41473);
    }

    private boolean a(hd hdVar) {
        AppMethodBeat.i(41474);
        if (g.RK()) {
            ab.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "GenFingerPrintRsaKeyEventListener callback");
            this.mru = false;
            if (!(hdVar instanceof hd)) {
                AppMethodBeat.o(41474);
                return false;
            } else if (e.bxs()) {
                this.mrB = hdVar;
                g.RQ();
                g.RO().eJo.a(385, (com.tencent.mm.ai.f) this);
                boolean z = this.mrB.cBP.cBR;
                this.mrC = this.mrB.cBP.cBS;
                this.czZ = this.mrB.cBP.cBT;
                if (z) {
                    ab.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth should gen rsa key!");
                    z = true;
                } else {
                    String rsaKey = FingerPrintAuth.getRsaKey(e.dQ(ah.getContext()), e.getUserId(), q.LM());
                    if (TextUtils.isEmpty(rsaKey)) {
                        ab.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.getRsaKey() return null");
                        z = true;
                    } else {
                        ab.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.getRsaKey() success!");
                        m eVar = new e(rsaKey);
                        g.RQ();
                        g.RO().eJo.a(eVar, 0);
                        z = false;
                    }
                }
                if (z) {
                    ab.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth begin asyc gen rsa key!");
                    new q(new a(this, (byte) 0)).aBU();
                }
                AppMethodBeat.o(41474);
                return true;
            } else {
                ab.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "device is not support FingerPrintAuth");
                b bVar = new b();
                bVar.cxT = false;
                this.mrB.cBQ = bVar;
                this.mru = true;
                bah();
                AppMethodBeat.o(41474);
                return true;
            }
        }
        ab.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "GenFingerPrintRsaKeyEventListener account is not ready");
        AppMethodBeat.o(41474);
        return false;
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(41475);
        if (mVar instanceof e) {
            b bVar = new b();
            bVar.cxT = false;
            ab.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "NetSceneTenpayGetOpenTouchCert doscene return errcode " + i2 + " errmsg" + str);
            if (i == 0 && i2 == 0) {
                ab.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "NetSceneTenpayGetOpenTouchCert doscene is success");
                e eVar = (e) mVar;
                String str2 = eVar.mrK;
                String str3 = eVar.cBV;
                String userId = e.getUserId();
                String LM = q.LM();
                String dNR = w.dNR();
                if (TextUtils.isEmpty(FingerPrintAuth.genOpenFPEncrypt(e.dQ(ah.getContext()), userId, LM, String.valueOf(this.mrC), dNR, "", str2, str3, Build.MODEL))) {
                    ab.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.genOpenFPEncrypt failed!");
                } else {
                    ab.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.genOpenFPEncrypt success!");
                    bVar.cxT = true;
                }
                String genPayFPEncrypt = FingerPrintAuth.genPayFPEncrypt(e.dQ(ah.getContext()), userId, LM, String.valueOf(this.mrC), dNR, this.czZ, Build.MODEL);
                userId = FingerPrintAuth.genOpenFPSign(e.dQ(ah.getContext()), e.getUserId(), q.LM(), genPayFPEncrypt);
                bVar.cBU = genPayFPEncrypt;
                bVar.cBV = userId;
            } else {
                ab.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "NetSceneTenpayGetOpenTouchCert doscene is fail");
            }
            g.RQ();
            g.RO().eJo.b(385, (com.tencent.mm.ai.f) this);
            this.mrB.cBQ = bVar;
            this.mru = true;
            bah();
        }
        AppMethodBeat.o(41475);
    }

    private void bah() {
        AppMethodBeat.i(41476);
        ab.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "doCallback()");
        if (this.mrB.callback != null) {
            this.mrB.callback.run();
        }
        if (this.mru) {
            this.mrB = null;
        }
        AppMethodBeat.o(41476);
    }
}
