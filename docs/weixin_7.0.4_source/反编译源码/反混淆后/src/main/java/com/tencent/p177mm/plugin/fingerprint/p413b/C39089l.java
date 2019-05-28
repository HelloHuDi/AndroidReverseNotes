package com.tencent.p177mm.plugin.fingerprint.p413b;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.p230g.p231a.C18316lv;
import com.tencent.p177mm.plugin.fingerprint.p1261c.C43097c;
import com.tencent.p177mm.plugin.soter.p1301e.C22155b;
import com.tencent.p177mm.plugin.soter.p527b.C35151f;
import com.tencent.p177mm.plugin.soter.p528d.C13720d;
import com.tencent.p177mm.plugin.soter.p528d.C29254e;
import com.tencent.p177mm.plugin.soter.p528d.C46261a;
import com.tencent.p177mm.plugin.wallet_core.model.C35481v;
import com.tencent.p177mm.pluginsdk.wallet.C14990c;
import com.tencent.p177mm.pluginsdk.wallet.C14992j;
import com.tencent.p177mm.pluginsdk.wallet.C4786k;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.soter.core.C40997a;
import com.tencent.soter.core.p1351c.C30973j;
import com.tencent.soter.p663a.C30954a;
import com.tencent.soter.p663a.p1105a.C40985a;
import com.tencent.soter.p663a.p1105a.C40986b;
import com.tencent.soter.p663a.p1106b.C16163a;
import com.tencent.soter.p663a.p1106b.C16164b;
import com.tencent.soter.p663a.p1106b.C16165c;
import com.tencent.soter.p663a.p1106b.C46744e;
import com.tencent.soter.p663a.p1349d.C40987a;
import com.tencent.soter.p663a.p1349d.C40989b;
import com.tencent.soter.p663a.p664g.C24298b;
import com.tencent.soter.p663a.p664g.C24298b.C5823a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.fingerprint.b.l */
public final class C39089l extends C31356a {
    private boolean mrT = false;
    private C39091n mrU = null;
    private C40987a mrV = null;
    private C40985a mrW = null;

    /* renamed from: com.tencent.mm.plugin.fingerprint.b.l$2 */
    class C207612 implements C40986b {
        C207612() {
        }

        public final void bxL() {
            AppMethodBeat.m2504i(41505);
            C4990ab.m7416i("MicroMsg.SoterAuthMgrImp", "start biometric auth");
            AppMethodBeat.m2505o(41505);
        }

        public final void onAuthenticationHelp(int i, CharSequence charSequence) {
            AppMethodBeat.m2504i(41506);
            C4990ab.m7417i("MicroMsg.SoterAuthMgrImp", "onAuthenticationHelp helpCode: %d, helpString: %s", Integer.valueOf(i), charSequence);
            AppMethodBeat.m2505o(41506);
        }

        public final void bxM() {
            AppMethodBeat.m2504i(41507);
            C4990ab.m7416i("MicroMsg.SoterAuthMgrImp", "auth succeed");
            AppMethodBeat.m2505o(41507);
        }

        public final void onAuthenticationFailed() {
            AppMethodBeat.m2504i(41508);
            C4990ab.m7416i("MicroMsg.SoterAuthMgrImp", "auth failed");
            AppMethodBeat.m2505o(41508);
        }

        public final void onAuthenticationCancelled() {
            AppMethodBeat.m2504i(41509);
            C4990ab.m7416i("MicroMsg.SoterAuthMgrImp", "auth cancel");
            AppMethodBeat.m2505o(41509);
        }

        public final void onAuthenticationError(int i, CharSequence charSequence) {
            AppMethodBeat.m2504i(41510);
            C4990ab.m7417i("MicroMsg.SoterAuthMgrImp", "auth error: %s, %s", Integer.valueOf(i), charSequence);
            AppMethodBeat.m2505o(41510);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fingerprint.b.l$6 */
    class C390906 implements C16164b<C16165c> {
        C390906() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo17330a(C46744e c46744e) {
            AppMethodBeat.m2504i(41514);
            C16165c c16165c = (C16165c) c46744e;
            C4990ab.m7417i("MicroMsg.SoterAuthMgrImp", "hy: gen auth key onResult: errCode: %d, errMsg: %s", Integer.valueOf(c16165c.errCode), c16165c.aIm);
            if (c16165c.isSuccess()) {
                C4990ab.m7416i("MicroMsg.SoterAuthMgrImp", "alvinluo gen auth key and upload success");
            } else {
                C4990ab.m7412e("MicroMsg.SoterAuthMgrImp", "alvinluo gen or upload auth key failed");
                C46261a.m86642fH(2, c16165c.errCode);
            }
            C35481v.tCn.reset();
            AppMethodBeat.m2505o(41514);
        }
    }

    public final boolean bxn() {
        boolean z;
        AppMethodBeat.m2504i(41515);
        if (C1427q.etg.etr == 1) {
            z = true;
        } else {
            z = false;
        }
        C4990ab.m7417i("MicroMsg.SoterAuthMgrImp", "hy: config support: %b, device support: %b", Boolean.valueOf(z), Boolean.valueOf(C30954a.dRc()));
        if (z && r3 && C40997a.m71097iP(C4996ah.getContext())) {
            AppMethodBeat.m2505o(41515);
            return true;
        }
        AppMethodBeat.m2505o(41515);
        return false;
    }

    public final boolean bxo() {
        AppMethodBeat.m2504i(41516);
        boolean iR = C40997a.m71099iR(C4996ah.getContext());
        AppMethodBeat.m2505o(41516);
        return iR;
    }

    public final void bxp() {
        AppMethodBeat.m2504i(41517);
        C4990ab.m7416i("MicroMsg.SoterAuthMgrImp", "hy: soter init fp. Do nothing?? Prepare ASK??");
        C39088e.m66516hu(true);
        C39088e.m66515ht(true);
        if (!this.mrT) {
            C4990ab.m7421w("MicroMsg.SoterAuthMgrImp", "SoterAuthMgrImp is set but still need to initSoter??? TaskInit had finished[%b]", Boolean.valueOf(C30954a.dRc()));
            C22155b.m33780a(false, false, null);
            this.mrT = true;
        }
        AppMethodBeat.m2505o(41517);
    }

    /* renamed from: dP */
    public final void mo48311dP(Context context) {
        AppMethodBeat.m2504i(41518);
        C39088e.m66516hu(true);
        C39088e.m66515ht(true);
        C4990ab.m7416i("MicroMsg.SoterAuthMgrImp", "hy: is soter. no need to init");
        AppMethodBeat.m2505o(41518);
    }

    public final boolean bxr() {
        return false;
    }

    /* renamed from: dO */
    public final void mo48310dO(Context context) {
        AppMethodBeat.m2504i(41519);
        C4990ab.m7416i("MicroMsg.SoterAuthMgrImp", "hy: start startRigesterSysFP");
        AppMethodBeat.m2505o(41519);
    }

    public final boolean bxs() {
        AppMethodBeat.m2504i(41520);
        boolean bxn = bxn();
        AppMethodBeat.m2505o(41520);
        return bxn;
    }

    @TargetApi(16)
    /* renamed from: a */
    public final int mo48284a(final C14990c c14990c, boolean z) {
        AppMethodBeat.m2504i(41521);
        if (z) {
            C4990ab.m7416i("MicroMsg.SoterAuthMgrImp", "hy: req restart after fail, but no need");
            AppMethodBeat.m2505o(41521);
        } else {
            C40989b c207601 = new C40989b() {
                public final void bxL() {
                    AppMethodBeat.m2504i(41499);
                    C4990ab.m7416i("MicroMsg.SoterAuthMgrImp", "alvinluo onStartAuthentication");
                    AppMethodBeat.m2505o(41499);
                }

                public final void onAuthenticationHelp(int i, CharSequence charSequence) {
                    AppMethodBeat.m2504i(41500);
                    C4990ab.m7417i("MicroMsg.SoterAuthMgrImp", "alvinluo onAuthenticationHelp helpCode: %d, helpString: %s", Integer.valueOf(i), charSequence);
                    if (c14990c != null) {
                        c14990c.mo7357bJ(2000, -1);
                    }
                    AppMethodBeat.m2505o(41500);
                }

                public final void bxM() {
                    AppMethodBeat.m2504i(41501);
                    C39089l.this.mrV = null;
                    C4990ab.m7416i("MicroMsg.SoterAuthMgrImp", "alvinluo onAuthenticationSucceed");
                    AppMethodBeat.m2505o(41501);
                }

                public final void onAuthenticationFailed() {
                    AppMethodBeat.m2504i(41502);
                    C4990ab.m7416i("MicroMsg.SoterAuthMgrImp", "alvinluo onAuthenticationFailed");
                    if (c14990c != null) {
                        c14990c.mo7357bJ(2002, -1);
                    }
                    AppMethodBeat.m2505o(41502);
                }

                public final void onAuthenticationCancelled() {
                    AppMethodBeat.m2504i(41503);
                    C4990ab.m7416i("MicroMsg.SoterAuthMgrImp", "alvinluo onAuthenticationCancelled");
                    C39089l.this.mrV = null;
                    AppMethodBeat.m2505o(41503);
                }

                public final void onAuthenticationError(int i, CharSequence charSequence) {
                    AppMethodBeat.m2504i(41504);
                    C4990ab.m7413e("MicroMsg.SoterAuthMgrImp", "alvinluo onAuthenticationError errCode: %d, errMsg: %s", Integer.valueOf(i), charSequence);
                    if (10308 == i) {
                        C4990ab.m7416i("MicroMsg.SoterAuthMgrImp", "py: authentication is frozen, auto cancel now.");
                        C39089l.this.bxk();
                    }
                    C39089l.this.mrV = null;
                    AppMethodBeat.m2505o(41504);
                }
            };
            this.mrV = new C40987a();
            C30954a.m49585a(new C16164b<C16163a>() {
                /* renamed from: a */
                public final /* synthetic */ void mo17330a(C46744e c46744e) {
                    AppMethodBeat.m2504i(41513);
                    C16163a c16163a = (C16163a) c46744e;
                    C4990ab.m7417i("MicroMsg.SoterAuthMgrImp", "alvinluo requestAuthAndSign onResult errCode: %d, errMsg: %s", Integer.valueOf(c16163a.errCode), c16163a.aIm);
                    if (c16163a.isSuccess()) {
                        C35481v.tCn.tCp = (C30973j) c16163a.AvM;
                        if (c14990c != null) {
                            c14990c.mo7357bJ(0, -1);
                        }
                        AppMethodBeat.m2505o(41513);
                        return;
                    }
                    C46261a.m86642fH(3, c16163a.errCode);
                    if (c16163a.errCode == 13) {
                        C4990ab.m7416i("MicroMsg.SoterAuthMgrImp", "hy: init error, maybe key invalid. remove former key and give suggestion");
                        C40997a.m71093cn(C39088e.bxC(), true);
                        if (c14990c != null) {
                            c14990c.mo7357bJ(TXLiveConstants.PLAY_EVT_PLAY_LOADING, -1);
                            AppMethodBeat.m2505o(41513);
                            return;
                        }
                    } else if (c16163a.errCode == 25) {
                        C4990ab.m7416i("MicroMsg.SoterAuthMgrImp", "hy: too many trial");
                        if (c14990c != null) {
                            c14990c.mo7357bJ(10308, -1);
                        }
                        C4990ab.m7416i("MicroMsg.SoterAuthMgrImp", "py: authentication is frozen in old task, auto cancel now.");
                        C39089l.this.bxk();
                        AppMethodBeat.m2505o(41513);
                        return;
                    } else if (c16163a.errCode == 24) {
                        C4990ab.m7416i("MicroMsg.SoterAuthMgrImp", "alvinluo user cancelled");
                        if (c14990c != null) {
                            c14990c.mo7357bJ(2000, -1);
                            AppMethodBeat.m2505o(41513);
                            return;
                        }
                    } else if (c16163a.errCode == 26) {
                        C4990ab.m7412e("MicroMsg.SoterAuthMgrImp", "alvinluo add authenticate task failed");
                        if (c14990c != null) {
                            c14990c.mo7357bJ(2009, -1);
                            AppMethodBeat.m2505o(41513);
                            return;
                        }
                    } else if (c14990c != null) {
                        c14990c.mo7357bJ(TXLiveConstants.PLAY_EVT_PLAY_PROGRESS, -1);
                    }
                    AppMethodBeat.m2505o(41513);
                }
            }, new C5823a().mo12210Rj(1).mo12217iW(C4996ah.getContext()).mo12214a(this.mrV).aug(C35481v.tCn.msn).mo12215a(c207601).Awk);
            AppMethodBeat.m2505o(41521);
        }
        return 0;
    }

    /* renamed from: a */
    public final int mo48283a(final C14990c c14990c) {
        AppMethodBeat.m2504i(41522);
        C4990ab.m7417i("MicroMsg.SoterAuthMgrImp", "start face auth: %s", Integer.valueOf(AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS));
        C40986b c207612 = new C207612();
        this.mrW = new C40985a();
        C24298b c24298b = new C5823a().mo12210Rj(1).mo12217iW(C4996ah.getContext()).mo12211Rk(2).mo12212a(this.mrW).mo12213a(c207612).aug(C35481v.tCn.msn).Awk;
        final C7564ap c7564ap = new C7564ap(new C5015a() {
            final /* synthetic */ int ioE = AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS;

            /* renamed from: BI */
            public final boolean mo4499BI() {
                AppMethodBeat.m2504i(41511);
                C4990ab.m7417i("MicroMsg.SoterAuthMgrImp", "timeout: %s", Integer.valueOf(this.ioE));
                C39089l.this.mrW.mo64929rp(true);
                AppMethodBeat.m2505o(41511);
                return false;
            }
        }, false);
        c7564ap.mo16770ae(3000, 3000);
        C30954a.m49585a(new C16164b<C16163a>() {
            /* renamed from: a */
            public final /* synthetic */ void mo17330a(C46744e c46744e) {
                AppMethodBeat.m2504i(41512);
                C16163a c16163a = (C16163a) c46744e;
                C4990ab.m7417i("MicroMsg.SoterAuthMgrImp", "requestAuthAndSign onResult errCode: %d, errMsg: %s", Integer.valueOf(c16163a.errCode), c16163a.aIm);
                C39089l.this.mrW = null;
                c7564ap.stopTimer();
                if (c16163a.isSuccess()) {
                    C35481v.tCn.tCp = (C30973j) c16163a.AvM;
                    if (c14990c != null) {
                        c14990c.mo7357bJ(0, -1);
                    }
                    AppMethodBeat.m2505o(41512);
                    return;
                }
                C46261a.m86642fH(3, c16163a.errCode);
                if (c16163a.errCode == 13) {
                    C4990ab.m7416i("MicroMsg.SoterAuthMgrImp", "hy: init error, maybe key invalid. remove former key and give suggestion");
                    C40997a.m71093cn(C39088e.bxC(), true);
                    if (c14990c != null) {
                        c14990c.mo7357bJ(TXLiveConstants.PLAY_EVT_PLAY_LOADING, -1);
                        AppMethodBeat.m2505o(41512);
                        return;
                    }
                } else if (c16163a.errCode == 25) {
                    C4990ab.m7416i("MicroMsg.SoterAuthMgrImp", "hy: too many trial");
                    if (c14990c != null) {
                        c14990c.mo7357bJ(10308, -1);
                        AppMethodBeat.m2505o(41512);
                        return;
                    }
                } else if (c16163a.errCode == 24) {
                    C4990ab.m7416i("MicroMsg.SoterAuthMgrImp", "alvinluo user cancelled");
                    if (c14990c != null) {
                        c14990c.mo7357bJ(2000, -1);
                        AppMethodBeat.m2505o(41512);
                        return;
                    }
                } else if (c16163a.errCode == 26) {
                    C4990ab.m7412e("MicroMsg.SoterAuthMgrImp", "alvinluo add authenticate task failed");
                    if (c14990c != null) {
                        c14990c.mo7357bJ(2009, -1);
                        AppMethodBeat.m2505o(41512);
                        return;
                    }
                } else if (c14990c != null) {
                    c14990c.mo7357bJ(TXLiveConstants.PLAY_EVT_PLAY_PROGRESS, -1);
                }
                AppMethodBeat.m2505o(41512);
            }
        }, c24298b);
        AppMethodBeat.m2505o(41522);
        return 0;
    }

    @SuppressLint({"NewApi"})
    public final void bxt() {
        AppMethodBeat.m2504i(41523);
        C4990ab.m7416i("MicroMsg.SoterAuthMgrImp", "hy: do nothing in system release");
        AppMethodBeat.m2505o(41523);
    }

    @SuppressLint({"NewApi"})
    public final void bxu() {
        AppMethodBeat.m2504i(41524);
        C4990ab.m7416i("MicroMsg.SoterAuthMgrImp", "hy: do nothing in system release");
        AppMethodBeat.m2505o(41524);
    }

    /* renamed from: a */
    public final void mo48285a(C18316lv c18316lv, int i) {
        AppMethodBeat.m2504i(41525);
        C4990ab.m7416i("MicroMsg.SoterAuthMgrImp", "hy: soter onOpenFingerprintAuthSuccess");
        c18316lv.cHE.cHI = bxi();
        c18316lv.cHE.errCode = !C5046bo.isNullOrNil(c18316lv.cHE.cHI) ? 0 : 1;
        c18316lv.cHE.cHJ = 2;
        c18316lv.cHE.cBU = "";
        c18316lv.cHE.cBV = "";
        if (c18316lv.cHD.cHH != null) {
            c18316lv.cHD.cHH.run();
        }
        AppMethodBeat.m2505o(41525);
    }

    public final String bxi() {
        AppMethodBeat.m2504i(41526);
        C30973j c30973j = C35481v.tCn.tCp;
        String jSONObject;
        if (c30973j != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("json", c30973j.Avx);
                jSONObject2.put("signature", c30973j.signature);
                jSONObject = jSONObject2.toString();
                AppMethodBeat.m2505o(41526);
                return jSONObject;
            } catch (JSONException e) {
                C4990ab.m7413e("MicroMsg.SoterAuthMgrImp", "hy: error when convert to json: %s", e.toString());
                C4990ab.printErrStackTrace("MicroMsg.SoterAuthMgrImp", e, "", new Object[0]);
                jSONObject = "";
                AppMethodBeat.m2505o(41526);
                return jSONObject;
            }
        }
        C4990ab.m7412e("MicroMsg.SoterAuthMgrImp", "hy: signature result is null");
        jSONObject = "";
        AppMethodBeat.m2505o(41526);
        return jSONObject;
    }

    public final void bxv() {
        AppMethodBeat.m2504i(41527);
        if (C40997a.aua(C39088e.bxC())) {
            C40997a.m71093cn(C39088e.bxC(), false);
        }
        AppMethodBeat.m2505o(41527);
    }

    public final C14992j bxm() {
        AppMethodBeat.m2504i(41528);
        this.mrU = new C39091n();
        C39091n c39091n = this.mrU;
        AppMethodBeat.m2505o(41528);
        return c39091n;
    }

    public final Map<String, String> bxw() {
        AppMethodBeat.m2504i(41529);
        HashMap hashMap = new HashMap();
        C29254e cvQ = C13720d.cvQ();
        String str = cvQ.rOh;
        String str2 = cvQ.jSY;
        hashMap.put("cpu_id", str);
        hashMap.put("uid", str2);
        AppMethodBeat.m2505o(41529);
        return hashMap;
    }

    public final C4786k bxx() {
        AppMethodBeat.m2504i(41530);
        C34179o c34179o = new C34179o();
        AppMethodBeat.m2505o(41530);
        return c34179o;
    }

    public final Map<String, String> bxy() {
        AppMethodBeat.m2504i(41531);
        Map bxw = bxw();
        AppMethodBeat.m2505o(41531);
        return bxw;
    }

    public final boolean bxz() {
        AppMethodBeat.m2504i(41532);
        C4990ab.m7417i("MicroMsg.SoterAuthMgrImp", "py: hasAuthKey: %b", Boolean.valueOf(C40997a.aua(C39088e.bxC())));
        if (!C40997a.aua(C39088e.bxC())) {
            C4990ab.m7416i("MicroMsg.SoterAuthMgrImp", "hy: no ask or auth key");
            C35481v.tCn.mso = true;
        }
        if (C35481v.tCn.mso) {
            AppMethodBeat.m2505o(41532);
            return false;
        }
        AppMethodBeat.m2505o(41532);
        return true;
    }

    /* renamed from: a */
    public final boolean mo48287a(boolean z, boolean z2, Bundle bundle) {
        AppMethodBeat.m2504i(41533);
        C4990ab.m7417i("MicroMsg.SoterAuthMgrImp", "hy: post pay. is fingerprint pay: %b, is pay ok: %b, extInfo: %s", Boolean.valueOf(z), Boolean.valueOf(z2), bundle);
        if (!z) {
            String string = bundle.getString("pwd");
            int i = bundle.getInt("key_open_biometric_type");
            if (C5046bo.isNullOrNil(string)) {
                C4990ab.m7412e("MicroMsg.SoterAuthMgrImp", "hy: no pwd. can not change auth key");
                AppMethodBeat.m2505o(41533);
                return false;
            } else if (C35481v.tCn.mso) {
                C4990ab.m7416i("MicroMsg.SoterAuthMgrImp", "hy: need change auth key. start gen auth key");
                C30954a.m49586a(new C390906(), true, 1, new C43097c(string, i), new C35151f());
            }
        }
        AppMethodBeat.m2505o(41533);
        return false;
    }

    public final boolean bxf() {
        AppMethodBeat.m2504i(41534);
        boolean iT = C40997a.m71101iT(C4996ah.getContext());
        AppMethodBeat.m2505o(41534);
        return iT;
    }

    public final void bxk() {
        AppMethodBeat.m2504i(41535);
        if (this.mrV != null && VERSION.SDK_INT >= 16) {
            C4990ab.m7416i("MicroMsg.SoterAuthMgrImp", "alvinluo cancel fingeprint canceller");
            this.mrV.mo64931rr(true);
        }
        if (this.mrW != null) {
            C4990ab.m7416i("MicroMsg.SoterAuthMgrImp", "cancel biometric canceller");
            this.mrW.mo64929rp(true);
        }
        AppMethodBeat.m2505o(41535);
    }

    public final int type() {
        return 2;
    }

    public final boolean bxA() {
        AppMethodBeat.m2504i(41536);
        int i = C1427q.eti.eue & 2;
        if (!C1427q.eti.cOQ || i != 2) {
            C4990ab.m7413e("MicroMsg.SoterAuthMgrImp", "peteryan check isDeviceSupportFaceID from DeviceInfo.mSoterInfo return false typeis[%d]", Integer.valueOf(C1427q.eti.eue));
            AppMethodBeat.m2505o(41536);
            return false;
        } else if (C30954a.dRc() && C40997a.m71098iQ(C4996ah.getContext())) {
            AppMethodBeat.m2505o(41536);
            return true;
        } else {
            AppMethodBeat.m2505o(41536);
            return false;
        }
    }

    public final boolean bxB() {
        AppMethodBeat.m2504i(41537);
        boolean iS = C40997a.m71100iS(C4996ah.getContext());
        AppMethodBeat.m2505o(41537);
        return iS;
    }

    public final boolean bxg() {
        AppMethodBeat.m2504i(41538);
        boolean aC = C40997a.m71092aC(C4996ah.getContext(), 2);
        AppMethodBeat.m2505o(41538);
        return aC;
    }
}
