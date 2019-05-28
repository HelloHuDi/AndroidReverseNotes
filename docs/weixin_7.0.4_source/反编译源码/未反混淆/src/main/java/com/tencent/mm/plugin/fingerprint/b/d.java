package com.tencent.mm.plugin.fingerprint.b;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.a.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.g.a.lv;
import com.tencent.mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.mm.plugin.soter.d.g;
import com.tencent.mm.plugin.wallet_core.model.ai;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.wallet.c;
import com.tencent.mm.pluginsdk.wallet.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.wallet_core.c.w;
import java.util.Map;

public final class d extends a {
    private com.a.a.a mrv = null;
    private a mrw = new a(this, (byte) 0);
    private c mrx = null;

    class a implements b {
        private a() {
        }

        /* synthetic */ a(d dVar, byte b) {
            this();
        }

        public final void vR() {
            AppMethodBeat.i(41440);
            if (d.this.mrx != null) {
                d.this.mrx;
            }
            AppMethodBeat.o(41440);
        }

        public final void bJ(int i, int i2) {
            AppMethodBeat.i(41441);
            if (d.this.mrx != null) {
                d.this.mrx.bJ(i, i2);
            }
            AppMethodBeat.o(41441);
        }
    }

    public d() {
        AppMethodBeat.i(41442);
        AppMethodBeat.o(41442);
    }

    private int[] vO() {
        AppMethodBeat.i(41445);
        if (this.mrv != null) {
            int[] vO = this.mrv.vO();
            AppMethodBeat.o(41445);
            return vO;
        }
        ab.i("MicroMsg.FingerPrintMgrImpl", "getIds auth == null");
        AppMethodBeat.o(41445);
        return null;
    }

    public final void bxp() {
        AppMethodBeat.i(41447);
        ab.i("MicroMsg.FingerPrintMgrImpl", "initFP");
        if (q.eti.cOQ) {
            ab.i("MicroMsg.FingerPrintMgrImpl", "IFingerPrintMgr is not SoterAuthMgrImp but the device is in white list of SOTER, recheck it!");
            com.tencent.mm.plugin.soter.e.b.a(false, false, new g() {
                public final void aC(int i, String str) {
                    AppMethodBeat.i(41437);
                    if (i == 0 && com.tencent.soter.a.a.dRc()) {
                        ab.i("MicroMsg.FingerPrintMgrImpl", "After recheck IFingerPrintMgr is now switched to SoterAuthMgrImp");
                        com.tencent.mm.kernel.c.a lVar = new l();
                        lVar.bxp();
                        com.tencent.mm.kernel.g.a(l.class, lVar);
                        AppMethodBeat.o(41437);
                        return;
                    }
                    ab.i("MicroMsg.FingerPrintMgrImpl", "After recheck IFingerPrintMgr is still FingerPrintMgrImpl errCode[" + i + "], errMsg[" + str + "]");
                    AppMethodBeat.o(41437);
                }
            });
        }
        if (bxn()) {
            ai cQo = r.cPI().cQo();
            if (cQo == null || cQo.cPY()) {
                final ak akVar = new ak(Looper.myLooper());
                ab.i("MicroMsg.FingerPrintMgrImpl", "device is support fingerprintAuth");
                com.tencent.mm.sdk.g.d.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(41439);
                        if (!e.bxH()) {
                            try {
                                d.this.dP(ah.getContext());
                            } catch (Exception e) {
                                ab.printErrStackTrace("MicroMsg.FingerPrintMgrImpl", e, "", new Object[0]);
                                ab.e("MicroMsg.FingerPrintMgrImpl", "init wechat ta secure world is occur exception e=" + e.getMessage());
                                e.ht(false);
                            }
                        }
                        if (!e.bxI()) {
                            try {
                                ClassLoader classLoader = com.tencent.mm.plugin.fingerprint.a.class.getClassLoader();
                                if (TextUtils.isEmpty(k.ky("teec"))) {
                                    ab.e("MicroMsg.FingerPrintMgrImpl", "can not LoadLibrary fingerprintauth.so, because can not find the libteec");
                                    e.hu(false);
                                } else {
                                    ab.i("MicroMsg.FingerPrintMgrImpl", "LoadLibrary fingerprintauth.so, find the libteec so");
                                    k.a("fingerprintauth", classLoader);
                                    e.hu(true);
                                }
                            } catch (UnsatisfiedLinkError e2) {
                                ab.e("MicroMsg.FingerPrintMgrImpl", "can not LoadLibrary fingerprintauth.so e:=" + e2.getMessage());
                                e.hu(false);
                            } catch (Exception e3) {
                                ab.printErrStackTrace("MicroMsg.FingerPrintMgrImpl", e3, "", new Object[0]);
                                ab.e("MicroMsg.FingerPrintMgrImpl", "init rsa key is occur exception e=" + e3.getMessage());
                                e.hu(false);
                            }
                        }
                        akVar.post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(41438);
                                try {
                                    d.bxq();
                                    AppMethodBeat.o(41438);
                                } catch (UnsatisfiedLinkError e) {
                                    ab.e("MicroMsg.FingerPrintMgrImpl", "can not LoadLibrary fingerprintauth.so e:=" + e.getMessage());
                                    AppMethodBeat.o(41438);
                                } catch (Exception e2) {
                                    ab.printErrStackTrace("MicroMsg.FingerPrintMgrImpl", e2, "", new Object[0]);
                                    ab.e("MicroMsg.FingerPrintMgrImpl", "init rsa key is occur exception e=" + e2.getMessage());
                                    AppMethodBeat.o(41438);
                                }
                            }
                        });
                        AppMethodBeat.o(41439);
                    }
                }, getClass().getName());
                AppMethodBeat.o(41447);
                return;
            }
            ab.e("MicroMsg.FingerPrintMgrImpl", "isSupportTouchPay is false");
            AppMethodBeat.o(41447);
            return;
        }
        ab.e("MicroMsg.FingerPrintMgrImpl", "device is not support fingerprintAuth");
        AppMethodBeat.o(41447);
    }

    public static void bxq() {
        AppMethodBeat.i(41448);
        ab.i("MicroMsg.FingerPrintMgrImpl", "initRsaKey");
        if (!e.bxs()) {
            ab.e("MicroMsg.FingerPrintMgrImpl", "device is not support");
            AppMethodBeat.o(41448);
        } else if (r.cPI().cQi() || r.cPI().cQh()) {
            ab.e("MicroMsg.FingerPrintMgrImpl", "user had not reg wxpay or is isSimpleReg");
            AppMethodBeat.o(41448);
        } else {
            try {
                String userId = e.getUserId();
                ab.i("MicroMsg.FingerPrintMgrImpl", "initRsaKey userId:".concat(String.valueOf(userId)));
                CharSequence rsaKey = FingerPrintAuth.getRsaKey(e.dQ(ah.getContext()), userId, q.LM());
                if (TextUtils.isEmpty(rsaKey)) {
                    ab.e("MicroMsg.FingerPrintMgrImpl", "FingerPrintAuth.getRsaKey() is null");
                    rsaKey = FingerPrintAuth.genRsaKey(e.dQ(ah.getContext()), e.getUserId(), q.LM());
                }
                if (TextUtils.isEmpty(rsaKey)) {
                    ab.e("MicroMsg.FingerPrintMgrImpl", "FingerPrintAuth.genRsaKey() return null");
                    AppMethodBeat.o(41448);
                    return;
                }
                ab.e("MicroMsg.FingerPrintMgrImpl", "initRsaKey success!");
                AppMethodBeat.o(41448);
            } catch (UnsatisfiedLinkError e) {
                ab.e("MicroMsg.FingerPrintMgrImpl", "can not LoadLibrary fingerprintauth.so e:=" + e.getMessage());
                AppMethodBeat.o(41448);
            } catch (Exception e2) {
                ab.printErrStackTrace("MicroMsg.FingerPrintMgrImpl", e2, "", new Object[0]);
                ab.e("MicroMsg.FingerPrintMgrImpl", "can not LoadLibrary fingerprintauth.so e:=" + e2.getMessage());
                AppMethodBeat.o(41448);
            }
        }
    }

    public final boolean bxr() {
        return true;
    }

    public final void dP(Context context) {
        AppMethodBeat.i(41449);
        ab.i("MicroMsg.FingerPrintMgrImpl", "initTASecureWorld");
        if (!c.bxj()) {
            ab.e("MicroMsg.FingerPrintMgrImpl", "device is not support");
            AppMethodBeat.o(41449);
        } else if (e.dR(context) != 0) {
            e.ht(false);
            ab.e("MicroMsg.FingerPrintMgrImpl", "copyTAFromAssets failed!");
            AppMethodBeat.o(41449);
        } else {
            e.ht(true);
            ab.e("MicroMsg.FingerPrintMgrImpl", "copyTAFromAssets success!");
            AppMethodBeat.o(41449);
        }
    }

    public final boolean bxs() {
        AppMethodBeat.i(41450);
        boolean bxs = e.bxs();
        AppMethodBeat.o(41450);
        return bxs;
    }

    public final int a(c cVar, boolean z) {
        AppMethodBeat.i(41451);
        if (this.mrv == null) {
            this.mrv = com.a.a.a.vN();
        }
        if (this.mrv != null) {
            this.mrx = cVar;
            this.mrv = com.a.a.a.vN();
            int a = this.mrv.a(this.mrw, vO());
            AppMethodBeat.o(41451);
            return a;
        }
        AppMethodBeat.o(41451);
        return -1;
    }

    public final int a(c cVar) {
        return 0;
    }

    public final void bxt() {
        AppMethodBeat.i(41452);
        this.mrx = null;
        if (this.mrv != null) {
            try {
                this.mrv.release();
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.FingerPrintMgrImpl", e, "", new Object[0]);
                ab.i("MicroMsg.FingerPrintMgrImpl", "auth systemRelease occur exception e:" + e.getMessage());
            }
            this.mrv = null;
            AppMethodBeat.o(41452);
            return;
        }
        ab.i("MicroMsg.FingerPrintMgrImpl", "systemRelease auth == null");
        AppMethodBeat.o(41452);
    }

    public final void bxu() {
        AppMethodBeat.i(41453);
        if (this.mrv != null) {
            try {
                this.mrv.abort();
                AppMethodBeat.o(41453);
                return;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.FingerPrintMgrImpl", e, "", new Object[0]);
                ab.i("MicroMsg.FingerPrintMgrImpl", "auth systemAbort occur exception e:" + e.getMessage());
            }
        }
        AppMethodBeat.o(41453);
    }

    public final void a(lv lvVar, int i) {
        AppMethodBeat.i(41454);
        String genPayFPEncrypt = FingerPrintAuth.genPayFPEncrypt(e.dQ(ah.getContext()), e.getUserId(), q.LM(), String.valueOf(i), w.dNR(), lvVar != null ? lvVar.cHD.cBT : "", Build.MODEL);
        String genOpenFPSign = FingerPrintAuth.genOpenFPSign(e.dQ(ah.getContext()), e.getUserId(), q.LM(), genPayFPEncrypt);
        if (TextUtils.isEmpty(genPayFPEncrypt)) {
            ab.i("MicroMsg.FingerPrintMgrImpl", "fail gen encrypted_pay_info!");
        } else {
            ab.i("MicroMsg.FingerPrintMgrImpl", "success gen encrypted_pay_info!");
        }
        if (TextUtils.isEmpty(genOpenFPSign)) {
            ab.i("MicroMsg.FingerPrintMgrImpl", "fail gen encrypted_pay_sign!");
        } else {
            ab.i("MicroMsg.FingerPrintMgrImpl", "success gen encrypted_pay_sign!");
        }
        ab.i("MicroMsg.FingerPrintMgrImpl", "callback FingerPrintAuthEvent onSuccess()");
        if (!(lvVar == null || lvVar.cHD.cHH == null)) {
            lv.b bVar = new lv.b();
            bVar.cHJ = 1;
            bVar.errCode = 0;
            bVar.cBU = genPayFPEncrypt;
            bVar.cBV = genOpenFPSign;
            bVar.cBS = i;
            lvVar.cHE = bVar;
            lvVar.cHD.cHH.run();
        }
        AppMethodBeat.o(41454);
    }

    public final void bxv() {
        AppMethodBeat.i(41455);
        ab.e("MicroMsg.FingerPrintMgrImpl", "hy: param incorrect");
        AppMethodBeat.o(41455);
    }

    public final j bxm() {
        AppMethodBeat.i(41456);
        h hVar = new h();
        AppMethodBeat.o(41456);
        return hVar;
    }

    public final Map<String, String> bxw() {
        return null;
    }

    public final com.tencent.mm.pluginsdk.wallet.k bxx() {
        return null;
    }

    public final Map<String, String> bxy() {
        return null;
    }

    public final boolean bxz() {
        return true;
    }

    public final boolean a(boolean z, boolean z2, Bundle bundle) {
        return false;
    }

    public final void bxk() {
        AppMethodBeat.i(41457);
        bxu();
        bxt();
        AppMethodBeat.o(41457);
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
        AppMethodBeat.i(41443);
        int[] vP = com.a.a.a.vP();
        if (vP != null) {
            for (int i2 : vP) {
                if (1 == i2) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        boolean z2 = q.etg.etr == 1;
        if (q.eti == null || !q.eti.euf) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        ab.i("MicroMsg.FingerPrintMgrImpl", "hy: is hardware support: %b, is config support : %b", Boolean.valueOf(z), Boolean.valueOf(z2));
        if (z && z2 && r4 == 0) {
            AppMethodBeat.o(41443);
            return true;
        }
        AppMethodBeat.o(41443);
        return false;
    }

    public final boolean bxo() {
        AppMethodBeat.i(41444);
        this.mrv = com.a.a.a.vN();
        int[] vO = vO();
        if (vO == null || vO.length <= 0) {
            ab.e("MicroMsg.FingerPrintMgrImpl", "ids is null");
        }
        bxt();
        if (vO == null || vO.length <= 0) {
            AppMethodBeat.o(41444);
            return false;
        }
        AppMethodBeat.o(41444);
        return true;
    }

    public final void dO(Context context) {
        AppMethodBeat.i(41446);
        if (context != null) {
            Intent intent = new Intent();
            intent.setAction("com.android.settings.fingerprint.FingerprintSettings");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setFlags(268435456);
            context.startActivity(intent);
        }
        AppMethodBeat.o(41446);
    }
}
