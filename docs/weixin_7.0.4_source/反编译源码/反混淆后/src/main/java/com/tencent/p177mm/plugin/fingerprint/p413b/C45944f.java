package com.tencent.p177mm.plugin.fingerprint.p413b;

import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C42000hd;
import com.tencent.p177mm.p230g.p231a.C42000hd.C18279b;
import com.tencent.p177mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.p177mm.plugin.fingerprint.p1261c.C20765e;
import com.tencent.p177mm.plugin.fingerprint.p413b.C3114q.C3116a;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.wallet_core.p649c.C30862w;

/* renamed from: com.tencent.mm.plugin.fingerprint.b.f */
public final class C45944f extends C4884c<C42000hd> implements C1202f {
    private String czZ;
    private C42000hd mrB;
    private int mrC;
    C7306ak mrD;
    private boolean mru;

    /* renamed from: com.tencent.mm.plugin.fingerprint.b.f$a */
    class C20758a implements C3116a {
        private C20758a() {
        }

        /* synthetic */ C20758a(C45944f c45944f, byte b) {
            this();
        }

        /* renamed from: AR */
        public final void mo7360AR(final String str) {
            AppMethodBeat.m2504i(41472);
            C45944f.this.mrD.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(41471);
                    if (TextUtils.isEmpty(str)) {
                        C4990ab.m7412e("MicroMsg.GenFingerPrintRsaKeyEventListener", "rsaKey is null");
                    }
                    C1207m c20765e = new C20765e(str);
                    C1720g.m3537RQ();
                    C1720g.m3535RO().eJo.mo14541a(c20765e, 0);
                    AppMethodBeat.m2505o(41471);
                }
            });
            AppMethodBeat.m2505o(41472);
        }
    }

    public C45944f() {
        AppMethodBeat.m2504i(41473);
        this.mrC = 0;
        this.czZ = "";
        this.mru = false;
        this.mrD = new C7306ak(Looper.getMainLooper());
        this.xxI = C42000hd.class.getName().hashCode();
        AppMethodBeat.m2505o(41473);
    }

    /* renamed from: a */
    private boolean m85325a(C42000hd c42000hd) {
        AppMethodBeat.m2504i(41474);
        if (C1720g.m3531RK()) {
            C4990ab.m7416i("MicroMsg.GenFingerPrintRsaKeyEventListener", "GenFingerPrintRsaKeyEventListener callback");
            this.mru = false;
            if (!(c42000hd instanceof C42000hd)) {
                AppMethodBeat.m2505o(41474);
                return false;
            } else if (C39088e.bxs()) {
                this.mrB = c42000hd;
                C1720g.m3537RQ();
                C1720g.m3535RO().eJo.mo14539a(385, (C1202f) this);
                boolean z = this.mrB.cBP.cBR;
                this.mrC = this.mrB.cBP.cBS;
                this.czZ = this.mrB.cBP.cBT;
                if (z) {
                    C4990ab.m7412e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth should gen rsa key!");
                    z = true;
                } else {
                    String rsaKey = FingerPrintAuth.getRsaKey(C39088e.m66512dQ(C4996ah.getContext()), C39088e.getUserId(), C1427q.m3028LM());
                    if (TextUtils.isEmpty(rsaKey)) {
                        C4990ab.m7412e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.getRsaKey() return null");
                        z = true;
                    } else {
                        C4990ab.m7412e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.getRsaKey() success!");
                        C1207m c20765e = new C20765e(rsaKey);
                        C1720g.m3537RQ();
                        C1720g.m3535RO().eJo.mo14541a(c20765e, 0);
                        z = false;
                    }
                }
                if (z) {
                    C4990ab.m7416i("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth begin asyc gen rsa key!");
                    new C3114q(new C20758a(this, (byte) 0)).aBU();
                }
                AppMethodBeat.m2505o(41474);
                return true;
            } else {
                C4990ab.m7412e("MicroMsg.GenFingerPrintRsaKeyEventListener", "device is not support FingerPrintAuth");
                C18279b c18279b = new C18279b();
                c18279b.cxT = false;
                this.mrB.cBQ = c18279b;
                this.mru = true;
                bah();
                AppMethodBeat.m2505o(41474);
                return true;
            }
        }
        C4990ab.m7412e("MicroMsg.GenFingerPrintRsaKeyEventListener", "GenFingerPrintRsaKeyEventListener account is not ready");
        AppMethodBeat.m2505o(41474);
        return false;
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(41475);
        if (c1207m instanceof C20765e) {
            C18279b c18279b = new C18279b();
            c18279b.cxT = false;
            C4990ab.m7416i("MicroMsg.GenFingerPrintRsaKeyEventListener", "NetSceneTenpayGetOpenTouchCert doscene return errcode " + i2 + " errmsg" + str);
            if (i == 0 && i2 == 0) {
                C4990ab.m7416i("MicroMsg.GenFingerPrintRsaKeyEventListener", "NetSceneTenpayGetOpenTouchCert doscene is success");
                C20765e c20765e = (C20765e) c1207m;
                String str2 = c20765e.mrK;
                String str3 = c20765e.cBV;
                String userId = C39088e.getUserId();
                String LM = C1427q.m3028LM();
                String dNR = C30862w.dNR();
                if (TextUtils.isEmpty(FingerPrintAuth.genOpenFPEncrypt(C39088e.m66512dQ(C4996ah.getContext()), userId, LM, String.valueOf(this.mrC), dNR, "", str2, str3, Build.MODEL))) {
                    C4990ab.m7412e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.genOpenFPEncrypt failed!");
                } else {
                    C4990ab.m7412e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.genOpenFPEncrypt success!");
                    c18279b.cxT = true;
                }
                String genPayFPEncrypt = FingerPrintAuth.genPayFPEncrypt(C39088e.m66512dQ(C4996ah.getContext()), userId, LM, String.valueOf(this.mrC), dNR, this.czZ, Build.MODEL);
                userId = FingerPrintAuth.genOpenFPSign(C39088e.m66512dQ(C4996ah.getContext()), C39088e.getUserId(), C1427q.m3028LM(), genPayFPEncrypt);
                c18279b.cBU = genPayFPEncrypt;
                c18279b.cBV = userId;
            } else {
                C4990ab.m7412e("MicroMsg.GenFingerPrintRsaKeyEventListener", "NetSceneTenpayGetOpenTouchCert doscene is fail");
            }
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14546b(385, (C1202f) this);
            this.mrB.cBQ = c18279b;
            this.mru = true;
            bah();
        }
        AppMethodBeat.m2505o(41475);
    }

    private void bah() {
        AppMethodBeat.m2504i(41476);
        C4990ab.m7412e("MicroMsg.GenFingerPrintRsaKeyEventListener", "doCallback()");
        if (this.mrB.callback != null) {
            this.mrB.callback.run();
        }
        if (this.mru) {
            this.mrB = null;
        }
        AppMethodBeat.m2505o(41476);
    }
}
