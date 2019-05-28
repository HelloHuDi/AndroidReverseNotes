package com.tencent.p177mm.plugin.fingerprint.p413b;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.p177mm.plugin.fingerprint.p1261c.C20765e;
import com.tencent.p177mm.plugin.fingerprint.p1261c.C20766f;
import com.tencent.p177mm.plugin.fingerprint.p413b.C3114q.C3116a;
import com.tencent.p177mm.plugin.soter.p528d.C46261a;
import com.tencent.p177mm.pluginsdk.wallet.C14992j;
import com.tencent.p177mm.pluginsdk.wallet.C30157a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7306ak.C4998a;
import com.tencent.p177mm.wallet_core.p649c.C30862w;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;

/* renamed from: com.tencent.mm.plugin.fingerprint.b.h */
public final class C28044h implements C14992j {
    private String cBV = null;
    private String gEk = null;
    C7306ak mrD = new C7306ak(new C69101());
    C30157a mrH = null;
    private C30157a mrI = null;
    WalletBaseUI mrJ = null;
    private String mrK = null;

    /* renamed from: com.tencent.mm.plugin.fingerprint.b.h$1 */
    class C69101 implements C4998a {

        /* renamed from: com.tencent.mm.plugin.fingerprint.b.h$1$1 */
        class C31121 implements Runnable {
            C31121() {
            }

            public final void run() {
                AppMethodBeat.m2504i(41480);
                C28044h.this.mrH.mo7375aC(-1, C28044h.this.mrJ.getString(C25738R.string.bv_));
                AppMethodBeat.m2505o(41480);
            }
        }

        C69101() {
        }

        public final boolean handleMessage(Message message) {
            AppMethodBeat.m2504i(41481);
            if (1 == message.what) {
                String string = message.getData().getString("rsaKey");
                if (TextUtils.isEmpty(string)) {
                    C4990ab.m7412e("MicroMsg.HwFingerprintOpenDelegate", "handleMessage msg.what=" + message.what + " rsaKey is null");
                    C5004al.m7441d(new C31121());
                }
                C28044h.this.mrJ.mo39970a(new C20765e(string), false, false);
                AppMethodBeat.m2505o(41481);
                return true;
            }
            AppMethodBeat.m2505o(41481);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fingerprint.b.h$a */
    class C28045a implements C3116a {

        /* renamed from: com.tencent.mm.plugin.fingerprint.b.h$a$1 */
        class C280461 implements Runnable {
            C280461() {
            }

            public final void run() {
                AppMethodBeat.m2504i(41482);
                C28044h.this.mrH.mo7375aC(-1, C28044h.this.mrJ.getString(C25738R.string.bv_));
                AppMethodBeat.m2505o(41482);
            }
        }

        private C28045a() {
        }

        /* synthetic */ C28045a(C28044h c28044h, byte b) {
            this();
        }

        /* renamed from: AR */
        public final void mo7360AR(final String str) {
            AppMethodBeat.m2504i(41484);
            if (TextUtils.isEmpty(str)) {
                C5004al.m7441d(new C280461());
                C4990ab.m7412e("MicroMsg.HwFingerprintOpenDelegate", "GenRsaKeySync.callback rsaKey is empty!");
                AppMethodBeat.m2505o(41484);
                return;
            }
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(41483);
                    C4990ab.m7416i("MicroMsg.HwFingerprintOpenDelegate", "GenRsaKeySync.callback running");
                    Message obtainMessage = C28044h.this.mrD.obtainMessage();
                    obtainMessage.what = 1;
                    Bundle bundle = new Bundle();
                    bundle.putString("rsaKey", str);
                    obtainMessage.setData(bundle);
                    obtainMessage.sendToTarget();
                    AppMethodBeat.m2505o(41483);
                }
            });
            AppMethodBeat.m2505o(41484);
        }
    }

    public C28044h() {
        AppMethodBeat.m2504i(41485);
        AppMethodBeat.m2505o(41485);
    }

    /* renamed from: a */
    public final void mo27383a(Context context, C30157a c30157a, String str) {
        AppMethodBeat.m2504i(41486);
        this.mrJ = (WalletBaseUI) context;
        this.mrH = c30157a;
        this.gEk = str;
        String rsaKey = FingerPrintAuth.getRsaKey(C39088e.m66512dQ(C4996ah.getContext()), C39088e.getUserId(), C1427q.m3028LM());
        C46261a.cvN();
        if (TextUtils.isEmpty(rsaKey)) {
            C4990ab.m7412e("MicroMsg.HwFingerprintOpenDelegate", "FingerPrintAuth.getRsaKey() is null");
            new C3114q(new C28045a(this, (byte) 0)).aBU();
            AppMethodBeat.m2505o(41486);
            return;
        }
        C4990ab.m7416i("MicroMsg.HwFingerprintOpenDelegate", "do NetSceneTenpayGetOpenTouchCert");
        this.mrJ.mo39970a(new C20765e(rsaKey), false, false);
        AppMethodBeat.m2505o(41486);
    }

    public final void clear() {
    }

    /* renamed from: c */
    public final boolean mo27385c(int i, int i2, String str, C1207m c1207m) {
        int i3 = 0;
        AppMethodBeat.m2504i(41487);
        if (c1207m instanceof C20765e) {
            C30157a c30157a;
            if (i == 0 && i2 == 0) {
                C4990ab.m7416i("MicroMsg.HwFingerprintOpenDelegate", "get FingerPrint cert success");
                C20765e c20765e = (C20765e) c1207m;
                this.mrK = c20765e.mrK;
                this.cBV = c20765e.cBV;
                c30157a = this.mrH;
                str = "";
            } else {
                C4990ab.m7416i("MicroMsg.HwFingerprintOpenDelegate", "get FingerPrint cert error");
                c30157a = this.mrH;
                i3 = -1;
                if (C5046bo.isNullOrNil(str)) {
                    str = this.mrJ.getString(C25738R.string.bv_);
                }
            }
            c30157a.mo7375aC(i3, str);
            AppMethodBeat.m2505o(41487);
            return true;
        } else if (c1207m instanceof C20766f) {
            if (i == 0 && i2 == 0) {
                C46261a.cvO();
                C46261a.m86639d(0, 0, 0, "OK");
                this.mrI.mo7375aC(0, "");
            } else {
                this.mrI.mo7375aC(-2, "");
            }
            AppMethodBeat.m2505o(41487);
            return true;
        } else {
            AppMethodBeat.m2505o(41487);
            return false;
        }
    }

    /* renamed from: a */
    public final void mo27384a(C30157a c30157a, String str, int i) {
        AppMethodBeat.m2504i(41488);
        this.mrI = c30157a;
        if (TextUtils.isEmpty(this.gEk)) {
            C4990ab.m7412e("MicroMsg.HwFingerprintOpenDelegate", "get user pwd error");
            c30157a.mo7375aC(-1, this.mrJ.getString(C25738R.string.bv_));
            AppMethodBeat.m2505o(41488);
            return;
        }
        String userId = C39088e.getUserId();
        String LM = C1427q.m3028LM();
        String dNR = C30862w.dNR();
        String str2 = "";
        String str3 = "";
        if (C39088e.bxs()) {
            userId = FingerPrintAuth.genOpenFPEncrypt(C39088e.m66512dQ(C4996ah.getContext()), userId, LM, str, dNR, "", this.mrK, this.cBV, Build.MODEL);
            str3 = FingerPrintAuth.genOpenFPSign(C39088e.m66512dQ(C4996ah.getContext()), C39088e.getUserId(), C1427q.m3028LM(), userId);
        } else {
            userId = str2;
        }
        if (TextUtils.isEmpty(this.mrK)) {
            C4990ab.m7412e("MicroMsg.HwFingerprintOpenDelegate", "The value of encrypted_device_info which return by FingerPrintAuth.genOpenFPEncrypt is null");
        } else if (TextUtils.isEmpty(str3)) {
            C4990ab.m7412e("MicroMsg.HwFingerprintOpenDelegate", "The value of encrypto_open_sign which return by FingerPrintAuth.genOpenFPSign is null");
        }
        this.mrJ.mo39970a(new C20766f(userId, str3, this.gEk, i), false, false);
        AppMethodBeat.m2505o(41488);
    }
}
