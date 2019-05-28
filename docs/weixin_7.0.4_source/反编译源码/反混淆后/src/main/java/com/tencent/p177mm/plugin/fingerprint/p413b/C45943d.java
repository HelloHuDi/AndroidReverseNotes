package com.tencent.p177mm.plugin.fingerprint.p413b;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.p782a.p783a.C44974a;
import com.p782a.p783a.C44974a.C8478b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.util.C1449k;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p242c.C1694a;
import com.tencent.p177mm.p230g.p231a.C18316lv;
import com.tencent.p177mm.p230g.p231a.C18316lv.C18317b;
import com.tencent.p177mm.plugin.fingerprint.C43094a;
import com.tencent.p177mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.p177mm.plugin.soter.p1301e.C22155b;
import com.tencent.p177mm.plugin.soter.p528d.C13722g;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.model.C29629ai;
import com.tencent.p177mm.pluginsdk.C30052l;
import com.tencent.p177mm.pluginsdk.wallet.C14990c;
import com.tencent.p177mm.pluginsdk.wallet.C14992j;
import com.tencent.p177mm.pluginsdk.wallet.C4786k;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.wallet_core.p649c.C30862w;
import com.tencent.soter.p663a.C30954a;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.fingerprint.b.d */
public final class C45943d extends C31356a {
    private C44974a mrv = null;
    private C39087a mrw = new C39087a(this, (byte) 0);
    private C14990c mrx = null;

    /* renamed from: com.tencent.mm.plugin.fingerprint.b.d$1 */
    class C207571 implements C13722g {
        C207571() {
        }

        /* renamed from: aC */
        public final void mo25925aC(int i, String str) {
            AppMethodBeat.m2504i(41437);
            if (i == 0 && C30954a.dRc()) {
                C4990ab.m7416i("MicroMsg.FingerPrintMgrImpl", "After recheck IFingerPrintMgr is now switched to SoterAuthMgrImp");
                C1694a c39089l = new C39089l();
                c39089l.bxp();
                C1720g.m3542a(C30052l.class, c39089l);
                AppMethodBeat.m2505o(41437);
                return;
            }
            C4990ab.m7416i("MicroMsg.FingerPrintMgrImpl", "After recheck IFingerPrintMgr is still FingerPrintMgrImpl errCode[" + i + "], errMsg[" + str + "]");
            AppMethodBeat.m2505o(41437);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fingerprint.b.d$a */
    class C39087a implements C8478b {
        private C39087a() {
        }

        /* synthetic */ C39087a(C45943d c45943d, byte b) {
            this();
        }

        /* renamed from: vR */
        public final void mo18533vR() {
            AppMethodBeat.m2504i(41440);
            if (C45943d.this.mrx != null) {
                C45943d.this.mrx;
            }
            AppMethodBeat.m2505o(41440);
        }

        /* renamed from: bJ */
        public final void mo18532bJ(int i, int i2) {
            AppMethodBeat.m2504i(41441);
            if (C45943d.this.mrx != null) {
                C45943d.this.mrx.mo7357bJ(i, i2);
            }
            AppMethodBeat.m2505o(41441);
        }
    }

    public C45943d() {
        AppMethodBeat.m2504i(41442);
        AppMethodBeat.m2505o(41442);
    }

    /* renamed from: vO */
    private int[] m85318vO() {
        AppMethodBeat.m2504i(41445);
        if (this.mrv != null) {
            int[] vO = this.mrv.mo72257vO();
            AppMethodBeat.m2505o(41445);
            return vO;
        }
        C4990ab.m7416i("MicroMsg.FingerPrintMgrImpl", "getIds auth == null");
        AppMethodBeat.m2505o(41445);
        return null;
    }

    public final void bxp() {
        AppMethodBeat.m2504i(41447);
        C4990ab.m7416i("MicroMsg.FingerPrintMgrImpl", "initFP");
        if (C1427q.eti.cOQ) {
            C4990ab.m7416i("MicroMsg.FingerPrintMgrImpl", "IFingerPrintMgr is not SoterAuthMgrImp but the device is in white list of SOTER, recheck it!");
            C22155b.m33780a(false, false, new C207571());
        }
        if (bxn()) {
            C29629ai cQo = C14241r.cPI().cQo();
            if (cQo == null || cQo.cPY()) {
                final C7306ak c7306ak = new C7306ak(Looper.myLooper());
                C4990ab.m7416i("MicroMsg.FingerPrintMgrImpl", "device is support fingerprintAuth");
                C7305d.post(new Runnable() {

                    /* renamed from: com.tencent.mm.plugin.fingerprint.b.d$2$1 */
                    class C280421 implements Runnable {
                        C280421() {
                        }

                        public final void run() {
                            AppMethodBeat.m2504i(41438);
                            try {
                                C45943d.bxq();
                                AppMethodBeat.m2505o(41438);
                            } catch (UnsatisfiedLinkError e) {
                                C4990ab.m7412e("MicroMsg.FingerPrintMgrImpl", "can not LoadLibrary fingerprintauth.so e:=" + e.getMessage());
                                AppMethodBeat.m2505o(41438);
                            } catch (Exception e2) {
                                C4990ab.printErrStackTrace("MicroMsg.FingerPrintMgrImpl", e2, "", new Object[0]);
                                C4990ab.m7412e("MicroMsg.FingerPrintMgrImpl", "init rsa key is occur exception e=" + e2.getMessage());
                                AppMethodBeat.m2505o(41438);
                            }
                        }
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(41439);
                        if (!C39088e.bxH()) {
                            try {
                                C45943d.this.mo48311dP(C4996ah.getContext());
                            } catch (Exception e) {
                                C4990ab.printErrStackTrace("MicroMsg.FingerPrintMgrImpl", e, "", new Object[0]);
                                C4990ab.m7412e("MicroMsg.FingerPrintMgrImpl", "init wechat ta secure world is occur exception e=" + e.getMessage());
                                C39088e.m66515ht(false);
                            }
                        }
                        if (!C39088e.bxI()) {
                            try {
                                ClassLoader classLoader = C43094a.class.getClassLoader();
                                if (TextUtils.isEmpty(C1449k.m3081ky("teec"))) {
                                    C4990ab.m7412e("MicroMsg.FingerPrintMgrImpl", "can not LoadLibrary fingerprintauth.so, because can not find the libteec");
                                    C39088e.m66516hu(false);
                                } else {
                                    C4990ab.m7416i("MicroMsg.FingerPrintMgrImpl", "LoadLibrary fingerprintauth.so, find the libteec so");
                                    C1449k.m3079a("fingerprintauth", classLoader);
                                    C39088e.m66516hu(true);
                                }
                            } catch (UnsatisfiedLinkError e2) {
                                C4990ab.m7412e("MicroMsg.FingerPrintMgrImpl", "can not LoadLibrary fingerprintauth.so e:=" + e2.getMessage());
                                C39088e.m66516hu(false);
                            } catch (Exception e3) {
                                C4990ab.printErrStackTrace("MicroMsg.FingerPrintMgrImpl", e3, "", new Object[0]);
                                C4990ab.m7412e("MicroMsg.FingerPrintMgrImpl", "init rsa key is occur exception e=" + e3.getMessage());
                                C39088e.m66516hu(false);
                            }
                        }
                        c7306ak.post(new C280421());
                        AppMethodBeat.m2505o(41439);
                    }
                }, getClass().getName());
                AppMethodBeat.m2505o(41447);
                return;
            }
            C4990ab.m7412e("MicroMsg.FingerPrintMgrImpl", "isSupportTouchPay is false");
            AppMethodBeat.m2505o(41447);
            return;
        }
        C4990ab.m7412e("MicroMsg.FingerPrintMgrImpl", "device is not support fingerprintAuth");
        AppMethodBeat.m2505o(41447);
    }

    public static void bxq() {
        AppMethodBeat.m2504i(41448);
        C4990ab.m7416i("MicroMsg.FingerPrintMgrImpl", "initRsaKey");
        if (!C39088e.bxs()) {
            C4990ab.m7412e("MicroMsg.FingerPrintMgrImpl", "device is not support");
            AppMethodBeat.m2505o(41448);
        } else if (C14241r.cPI().cQi() || C14241r.cPI().cQh()) {
            C4990ab.m7412e("MicroMsg.FingerPrintMgrImpl", "user had not reg wxpay or is isSimpleReg");
            AppMethodBeat.m2505o(41448);
        } else {
            try {
                String userId = C39088e.getUserId();
                C4990ab.m7416i("MicroMsg.FingerPrintMgrImpl", "initRsaKey userId:".concat(String.valueOf(userId)));
                CharSequence rsaKey = FingerPrintAuth.getRsaKey(C39088e.m66512dQ(C4996ah.getContext()), userId, C1427q.m3028LM());
                if (TextUtils.isEmpty(rsaKey)) {
                    C4990ab.m7412e("MicroMsg.FingerPrintMgrImpl", "FingerPrintAuth.getRsaKey() is null");
                    rsaKey = FingerPrintAuth.genRsaKey(C39088e.m66512dQ(C4996ah.getContext()), C39088e.getUserId(), C1427q.m3028LM());
                }
                if (TextUtils.isEmpty(rsaKey)) {
                    C4990ab.m7412e("MicroMsg.FingerPrintMgrImpl", "FingerPrintAuth.genRsaKey() return null");
                    AppMethodBeat.m2505o(41448);
                    return;
                }
                C4990ab.m7412e("MicroMsg.FingerPrintMgrImpl", "initRsaKey success!");
                AppMethodBeat.m2505o(41448);
            } catch (UnsatisfiedLinkError e) {
                C4990ab.m7412e("MicroMsg.FingerPrintMgrImpl", "can not LoadLibrary fingerprintauth.so e:=" + e.getMessage());
                AppMethodBeat.m2505o(41448);
            } catch (Exception e2) {
                C4990ab.printErrStackTrace("MicroMsg.FingerPrintMgrImpl", e2, "", new Object[0]);
                C4990ab.m7412e("MicroMsg.FingerPrintMgrImpl", "can not LoadLibrary fingerprintauth.so e:=" + e2.getMessage());
                AppMethodBeat.m2505o(41448);
            }
        }
    }

    public final boolean bxr() {
        return true;
    }

    /* renamed from: dP */
    public final void mo48311dP(Context context) {
        AppMethodBeat.m2504i(41449);
        C4990ab.m7416i("MicroMsg.FingerPrintMgrImpl", "initTASecureWorld");
        if (!C39086c.bxj()) {
            C4990ab.m7412e("MicroMsg.FingerPrintMgrImpl", "device is not support");
            AppMethodBeat.m2505o(41449);
        } else if (C39088e.m66513dR(context) != 0) {
            C39088e.m66515ht(false);
            C4990ab.m7412e("MicroMsg.FingerPrintMgrImpl", "copyTAFromAssets failed!");
            AppMethodBeat.m2505o(41449);
        } else {
            C39088e.m66515ht(true);
            C4990ab.m7412e("MicroMsg.FingerPrintMgrImpl", "copyTAFromAssets success!");
            AppMethodBeat.m2505o(41449);
        }
    }

    public final boolean bxs() {
        AppMethodBeat.m2504i(41450);
        boolean bxs = C39088e.bxs();
        AppMethodBeat.m2505o(41450);
        return bxs;
    }

    /* renamed from: a */
    public final int mo48284a(C14990c c14990c, boolean z) {
        AppMethodBeat.m2504i(41451);
        if (this.mrv == null) {
            this.mrv = C44974a.m82340vN();
        }
        if (this.mrv != null) {
            this.mrx = c14990c;
            this.mrv = C44974a.m82340vN();
            int a = this.mrv.mo72254a(this.mrw, m85318vO());
            AppMethodBeat.m2505o(41451);
            return a;
        }
        AppMethodBeat.m2505o(41451);
        return -1;
    }

    /* renamed from: a */
    public final int mo48283a(C14990c c14990c) {
        return 0;
    }

    public final void bxt() {
        AppMethodBeat.m2504i(41452);
        this.mrx = null;
        if (this.mrv != null) {
            try {
                this.mrv.release();
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.FingerPrintMgrImpl", e, "", new Object[0]);
                C4990ab.m7416i("MicroMsg.FingerPrintMgrImpl", "auth systemRelease occur exception e:" + e.getMessage());
            }
            this.mrv = null;
            AppMethodBeat.m2505o(41452);
            return;
        }
        C4990ab.m7416i("MicroMsg.FingerPrintMgrImpl", "systemRelease auth == null");
        AppMethodBeat.m2505o(41452);
    }

    public final void bxu() {
        AppMethodBeat.m2504i(41453);
        if (this.mrv != null) {
            try {
                this.mrv.abort();
                AppMethodBeat.m2505o(41453);
                return;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.FingerPrintMgrImpl", e, "", new Object[0]);
                C4990ab.m7416i("MicroMsg.FingerPrintMgrImpl", "auth systemAbort occur exception e:" + e.getMessage());
            }
        }
        AppMethodBeat.m2505o(41453);
    }

    /* renamed from: a */
    public final void mo48285a(C18316lv c18316lv, int i) {
        AppMethodBeat.m2504i(41454);
        String genPayFPEncrypt = FingerPrintAuth.genPayFPEncrypt(C39088e.m66512dQ(C4996ah.getContext()), C39088e.getUserId(), C1427q.m3028LM(), String.valueOf(i), C30862w.dNR(), c18316lv != null ? c18316lv.cHD.cBT : "", Build.MODEL);
        String genOpenFPSign = FingerPrintAuth.genOpenFPSign(C39088e.m66512dQ(C4996ah.getContext()), C39088e.getUserId(), C1427q.m3028LM(), genPayFPEncrypt);
        if (TextUtils.isEmpty(genPayFPEncrypt)) {
            C4990ab.m7416i("MicroMsg.FingerPrintMgrImpl", "fail gen encrypted_pay_info!");
        } else {
            C4990ab.m7416i("MicroMsg.FingerPrintMgrImpl", "success gen encrypted_pay_info!");
        }
        if (TextUtils.isEmpty(genOpenFPSign)) {
            C4990ab.m7416i("MicroMsg.FingerPrintMgrImpl", "fail gen encrypted_pay_sign!");
        } else {
            C4990ab.m7416i("MicroMsg.FingerPrintMgrImpl", "success gen encrypted_pay_sign!");
        }
        C4990ab.m7416i("MicroMsg.FingerPrintMgrImpl", "callback FingerPrintAuthEvent onSuccess()");
        if (!(c18316lv == null || c18316lv.cHD.cHH == null)) {
            C18317b c18317b = new C18317b();
            c18317b.cHJ = 1;
            c18317b.errCode = 0;
            c18317b.cBU = genPayFPEncrypt;
            c18317b.cBV = genOpenFPSign;
            c18317b.cBS = i;
            c18316lv.cHE = c18317b;
            c18316lv.cHD.cHH.run();
        }
        AppMethodBeat.m2505o(41454);
    }

    public final void bxv() {
        AppMethodBeat.m2504i(41455);
        C4990ab.m7412e("MicroMsg.FingerPrintMgrImpl", "hy: param incorrect");
        AppMethodBeat.m2505o(41455);
    }

    public final C14992j bxm() {
        AppMethodBeat.m2504i(41456);
        C28044h c28044h = new C28044h();
        AppMethodBeat.m2505o(41456);
        return c28044h;
    }

    public final Map<String, String> bxw() {
        return null;
    }

    public final C4786k bxx() {
        return null;
    }

    public final Map<String, String> bxy() {
        return null;
    }

    public final boolean bxz() {
        return true;
    }

    /* renamed from: a */
    public final boolean mo48287a(boolean z, boolean z2, Bundle bundle) {
        return false;
    }

    public final void bxk() {
        AppMethodBeat.m2504i(41457);
        bxu();
        bxt();
        AppMethodBeat.m2505o(41457);
    }

    public final int type() {
        return 1;
    }

    public final boolean bxA() {
        return false;
    }

    public final boolean bxB() {
        return false;
    }

    public final boolean bxn() {
        int i;
        boolean z;
        AppMethodBeat.m2504i(41443);
        int[] vP = C44974a.m82341vP();
        if (vP != null) {
            for (int i2 : vP) {
                if (1 == i2) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        boolean z2 = C1427q.etg.etr == 1;
        if (C1427q.eti == null || !C1427q.eti.euf) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        C4990ab.m7417i("MicroMsg.FingerPrintMgrImpl", "hy: is hardware support: %b, is config support : %b", Boolean.valueOf(z), Boolean.valueOf(z2));
        if (z && z2 && r4 == 0) {
            AppMethodBeat.m2505o(41443);
            return true;
        }
        AppMethodBeat.m2505o(41443);
        return false;
    }

    public final boolean bxo() {
        AppMethodBeat.m2504i(41444);
        this.mrv = C44974a.m82340vN();
        int[] vO = m85318vO();
        if (vO == null || vO.length <= 0) {
            C4990ab.m7412e("MicroMsg.FingerPrintMgrImpl", "ids is null");
        }
        bxt();
        if (vO == null || vO.length <= 0) {
            AppMethodBeat.m2505o(41444);
            return false;
        }
        AppMethodBeat.m2505o(41444);
        return true;
    }

    /* renamed from: dO */
    public final void mo48310dO(Context context) {
        AppMethodBeat.m2504i(41446);
        if (context != null) {
            Intent intent = new Intent();
            intent.setAction("com.android.settings.fingerprint.FingerprintSettings");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setFlags(268435456);
            context.startActivity(intent);
        }
        AppMethodBeat.m2505o(41446);
    }
}
