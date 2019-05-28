package com.tencent.mm.plugin.fingerprint.b;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.g.a.lv;
import com.tencent.mm.plugin.soter.b.f;
import com.tencent.mm.plugin.soter.d.d;
import com.tencent.mm.plugin.soter.e.b;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.pluginsdk.wallet.c;
import com.tencent.mm.pluginsdk.wallet.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.soter.a.b.e;
import com.tencent.soter.a.d.a;
import com.tencent.soter.core.c.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class l extends a {
    private boolean mrT = false;
    private n mrU = null;
    private a mrV = null;
    private com.tencent.soter.a.a.a mrW = null;

    public final boolean bxn() {
        boolean z;
        AppMethodBeat.i(41515);
        if (q.etg.etr == 1) {
            z = true;
        } else {
            z = false;
        }
        ab.i("MicroMsg.SoterAuthMgrImp", "hy: config support: %b, device support: %b", Boolean.valueOf(z), Boolean.valueOf(com.tencent.soter.a.a.dRc()));
        if (z && r3 && com.tencent.soter.core.a.iP(ah.getContext())) {
            AppMethodBeat.o(41515);
            return true;
        }
        AppMethodBeat.o(41515);
        return false;
    }

    public final boolean bxo() {
        AppMethodBeat.i(41516);
        boolean iR = com.tencent.soter.core.a.iR(ah.getContext());
        AppMethodBeat.o(41516);
        return iR;
    }

    public final void bxp() {
        AppMethodBeat.i(41517);
        ab.i("MicroMsg.SoterAuthMgrImp", "hy: soter init fp. Do nothing?? Prepare ASK??");
        e.hu(true);
        e.ht(true);
        if (!this.mrT) {
            ab.w("MicroMsg.SoterAuthMgrImp", "SoterAuthMgrImp is set but still need to initSoter??? TaskInit had finished[%b]", Boolean.valueOf(com.tencent.soter.a.a.dRc()));
            b.a(false, false, null);
            this.mrT = true;
        }
        AppMethodBeat.o(41517);
    }

    public final void dP(Context context) {
        AppMethodBeat.i(41518);
        e.hu(true);
        e.ht(true);
        ab.i("MicroMsg.SoterAuthMgrImp", "hy: is soter. no need to init");
        AppMethodBeat.o(41518);
    }

    public final boolean bxr() {
        return false;
    }

    public final void dO(Context context) {
        AppMethodBeat.i(41519);
        ab.i("MicroMsg.SoterAuthMgrImp", "hy: start startRigesterSysFP");
        AppMethodBeat.o(41519);
    }

    public final boolean bxs() {
        AppMethodBeat.i(41520);
        boolean bxn = bxn();
        AppMethodBeat.o(41520);
        return bxn;
    }

    @TargetApi(16)
    public final int a(final c cVar, boolean z) {
        AppMethodBeat.i(41521);
        if (z) {
            ab.i("MicroMsg.SoterAuthMgrImp", "hy: req restart after fail, but no need");
            AppMethodBeat.o(41521);
        } else {
            com.tencent.soter.a.d.b anonymousClass1 = new com.tencent.soter.a.d.b() {
                public final void bxL() {
                    AppMethodBeat.i(41499);
                    ab.i("MicroMsg.SoterAuthMgrImp", "alvinluo onStartAuthentication");
                    AppMethodBeat.o(41499);
                }

                public final void onAuthenticationHelp(int i, CharSequence charSequence) {
                    AppMethodBeat.i(41500);
                    ab.i("MicroMsg.SoterAuthMgrImp", "alvinluo onAuthenticationHelp helpCode: %d, helpString: %s", Integer.valueOf(i), charSequence);
                    if (cVar != null) {
                        cVar.bJ(2000, -1);
                    }
                    AppMethodBeat.o(41500);
                }

                public final void bxM() {
                    AppMethodBeat.i(41501);
                    l.this.mrV = null;
                    ab.i("MicroMsg.SoterAuthMgrImp", "alvinluo onAuthenticationSucceed");
                    AppMethodBeat.o(41501);
                }

                public final void onAuthenticationFailed() {
                    AppMethodBeat.i(41502);
                    ab.i("MicroMsg.SoterAuthMgrImp", "alvinluo onAuthenticationFailed");
                    if (cVar != null) {
                        cVar.bJ(2002, -1);
                    }
                    AppMethodBeat.o(41502);
                }

                public final void onAuthenticationCancelled() {
                    AppMethodBeat.i(41503);
                    ab.i("MicroMsg.SoterAuthMgrImp", "alvinluo onAuthenticationCancelled");
                    l.this.mrV = null;
                    AppMethodBeat.o(41503);
                }

                public final void onAuthenticationError(int i, CharSequence charSequence) {
                    AppMethodBeat.i(41504);
                    ab.e("MicroMsg.SoterAuthMgrImp", "alvinluo onAuthenticationError errCode: %d, errMsg: %s", Integer.valueOf(i), charSequence);
                    if (10308 == i) {
                        ab.i("MicroMsg.SoterAuthMgrImp", "py: authentication is frozen, auto cancel now.");
                        l.this.bxk();
                    }
                    l.this.mrV = null;
                    AppMethodBeat.o(41504);
                }
            };
            this.mrV = new a();
            com.tencent.soter.a.a.a(new com.tencent.soter.a.b.b<com.tencent.soter.a.b.a>() {
                public final /* synthetic */ void a(e eVar) {
                    AppMethodBeat.i(41513);
                    com.tencent.soter.a.b.a aVar = (com.tencent.soter.a.b.a) eVar;
                    ab.i("MicroMsg.SoterAuthMgrImp", "alvinluo requestAuthAndSign onResult errCode: %d, errMsg: %s", Integer.valueOf(aVar.errCode), aVar.aIm);
                    if (aVar.isSuccess()) {
                        v.tCn.tCp = (j) aVar.AvM;
                        if (cVar != null) {
                            cVar.bJ(0, -1);
                        }
                        AppMethodBeat.o(41513);
                        return;
                    }
                    com.tencent.mm.plugin.soter.d.a.fH(3, aVar.errCode);
                    if (aVar.errCode == 13) {
                        ab.i("MicroMsg.SoterAuthMgrImp", "hy: init error, maybe key invalid. remove former key and give suggestion");
                        com.tencent.soter.core.a.cn(e.bxC(), true);
                        if (cVar != null) {
                            cVar.bJ(TXLiveConstants.PLAY_EVT_PLAY_LOADING, -1);
                            AppMethodBeat.o(41513);
                            return;
                        }
                    } else if (aVar.errCode == 25) {
                        ab.i("MicroMsg.SoterAuthMgrImp", "hy: too many trial");
                        if (cVar != null) {
                            cVar.bJ(10308, -1);
                        }
                        ab.i("MicroMsg.SoterAuthMgrImp", "py: authentication is frozen in old task, auto cancel now.");
                        l.this.bxk();
                        AppMethodBeat.o(41513);
                        return;
                    } else if (aVar.errCode == 24) {
                        ab.i("MicroMsg.SoterAuthMgrImp", "alvinluo user cancelled");
                        if (cVar != null) {
                            cVar.bJ(2000, -1);
                            AppMethodBeat.o(41513);
                            return;
                        }
                    } else if (aVar.errCode == 26) {
                        ab.e("MicroMsg.SoterAuthMgrImp", "alvinluo add authenticate task failed");
                        if (cVar != null) {
                            cVar.bJ(2009, -1);
                            AppMethodBeat.o(41513);
                            return;
                        }
                    } else if (cVar != null) {
                        cVar.bJ(TXLiveConstants.PLAY_EVT_PLAY_PROGRESS, -1);
                    }
                    AppMethodBeat.o(41513);
                }
            }, new com.tencent.soter.a.g.b.a().Rj(1).iW(ah.getContext()).a(this.mrV).aug(v.tCn.msn).a(anonymousClass1).Awk);
            AppMethodBeat.o(41521);
        }
        return 0;
    }

    public final int a(final c cVar) {
        AppMethodBeat.i(41522);
        ab.i("MicroMsg.SoterAuthMgrImp", "start face auth: %s", Integer.valueOf(AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS));
        com.tencent.soter.a.a.b anonymousClass2 = new com.tencent.soter.a.a.b() {
            public final void bxL() {
                AppMethodBeat.i(41505);
                ab.i("MicroMsg.SoterAuthMgrImp", "start biometric auth");
                AppMethodBeat.o(41505);
            }

            public final void onAuthenticationHelp(int i, CharSequence charSequence) {
                AppMethodBeat.i(41506);
                ab.i("MicroMsg.SoterAuthMgrImp", "onAuthenticationHelp helpCode: %d, helpString: %s", Integer.valueOf(i), charSequence);
                AppMethodBeat.o(41506);
            }

            public final void bxM() {
                AppMethodBeat.i(41507);
                ab.i("MicroMsg.SoterAuthMgrImp", "auth succeed");
                AppMethodBeat.o(41507);
            }

            public final void onAuthenticationFailed() {
                AppMethodBeat.i(41508);
                ab.i("MicroMsg.SoterAuthMgrImp", "auth failed");
                AppMethodBeat.o(41508);
            }

            public final void onAuthenticationCancelled() {
                AppMethodBeat.i(41509);
                ab.i("MicroMsg.SoterAuthMgrImp", "auth cancel");
                AppMethodBeat.o(41509);
            }

            public final void onAuthenticationError(int i, CharSequence charSequence) {
                AppMethodBeat.i(41510);
                ab.i("MicroMsg.SoterAuthMgrImp", "auth error: %s, %s", Integer.valueOf(i), charSequence);
                AppMethodBeat.o(41510);
            }
        };
        this.mrW = new com.tencent.soter.a.a.a();
        com.tencent.soter.a.g.b bVar = new com.tencent.soter.a.g.b.a().Rj(1).iW(ah.getContext()).Rk(2).a(this.mrW).a(anonymousClass2).aug(v.tCn.msn).Awk;
        final ap apVar = new ap(new ap.a() {
            final /* synthetic */ int ioE = AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS;

            public final boolean BI() {
                AppMethodBeat.i(41511);
                ab.i("MicroMsg.SoterAuthMgrImp", "timeout: %s", Integer.valueOf(this.ioE));
                l.this.mrW.rp(true);
                AppMethodBeat.o(41511);
                return false;
            }
        }, false);
        apVar.ae(3000, 3000);
        com.tencent.soter.a.a.a(new com.tencent.soter.a.b.b<com.tencent.soter.a.b.a>() {
            public final /* synthetic */ void a(e eVar) {
                AppMethodBeat.i(41512);
                com.tencent.soter.a.b.a aVar = (com.tencent.soter.a.b.a) eVar;
                ab.i("MicroMsg.SoterAuthMgrImp", "requestAuthAndSign onResult errCode: %d, errMsg: %s", Integer.valueOf(aVar.errCode), aVar.aIm);
                l.this.mrW = null;
                apVar.stopTimer();
                if (aVar.isSuccess()) {
                    v.tCn.tCp = (j) aVar.AvM;
                    if (cVar != null) {
                        cVar.bJ(0, -1);
                    }
                    AppMethodBeat.o(41512);
                    return;
                }
                com.tencent.mm.plugin.soter.d.a.fH(3, aVar.errCode);
                if (aVar.errCode == 13) {
                    ab.i("MicroMsg.SoterAuthMgrImp", "hy: init error, maybe key invalid. remove former key and give suggestion");
                    com.tencent.soter.core.a.cn(e.bxC(), true);
                    if (cVar != null) {
                        cVar.bJ(TXLiveConstants.PLAY_EVT_PLAY_LOADING, -1);
                        AppMethodBeat.o(41512);
                        return;
                    }
                } else if (aVar.errCode == 25) {
                    ab.i("MicroMsg.SoterAuthMgrImp", "hy: too many trial");
                    if (cVar != null) {
                        cVar.bJ(10308, -1);
                        AppMethodBeat.o(41512);
                        return;
                    }
                } else if (aVar.errCode == 24) {
                    ab.i("MicroMsg.SoterAuthMgrImp", "alvinluo user cancelled");
                    if (cVar != null) {
                        cVar.bJ(2000, -1);
                        AppMethodBeat.o(41512);
                        return;
                    }
                } else if (aVar.errCode == 26) {
                    ab.e("MicroMsg.SoterAuthMgrImp", "alvinluo add authenticate task failed");
                    if (cVar != null) {
                        cVar.bJ(2009, -1);
                        AppMethodBeat.o(41512);
                        return;
                    }
                } else if (cVar != null) {
                    cVar.bJ(TXLiveConstants.PLAY_EVT_PLAY_PROGRESS, -1);
                }
                AppMethodBeat.o(41512);
            }
        }, bVar);
        AppMethodBeat.o(41522);
        return 0;
    }

    @SuppressLint({"NewApi"})
    public final void bxt() {
        AppMethodBeat.i(41523);
        ab.i("MicroMsg.SoterAuthMgrImp", "hy: do nothing in system release");
        AppMethodBeat.o(41523);
    }

    @SuppressLint({"NewApi"})
    public final void bxu() {
        AppMethodBeat.i(41524);
        ab.i("MicroMsg.SoterAuthMgrImp", "hy: do nothing in system release");
        AppMethodBeat.o(41524);
    }

    public final void a(lv lvVar, int i) {
        AppMethodBeat.i(41525);
        ab.i("MicroMsg.SoterAuthMgrImp", "hy: soter onOpenFingerprintAuthSuccess");
        lvVar.cHE.cHI = bxi();
        lvVar.cHE.errCode = !bo.isNullOrNil(lvVar.cHE.cHI) ? 0 : 1;
        lvVar.cHE.cHJ = 2;
        lvVar.cHE.cBU = "";
        lvVar.cHE.cBV = "";
        if (lvVar.cHD.cHH != null) {
            lvVar.cHD.cHH.run();
        }
        AppMethodBeat.o(41525);
    }

    public final String bxi() {
        AppMethodBeat.i(41526);
        j jVar = v.tCn.tCp;
        String jSONObject;
        if (jVar != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("json", jVar.Avx);
                jSONObject2.put("signature", jVar.signature);
                jSONObject = jSONObject2.toString();
                AppMethodBeat.o(41526);
                return jSONObject;
            } catch (JSONException e) {
                ab.e("MicroMsg.SoterAuthMgrImp", "hy: error when convert to json: %s", e.toString());
                ab.printErrStackTrace("MicroMsg.SoterAuthMgrImp", e, "", new Object[0]);
                jSONObject = "";
                AppMethodBeat.o(41526);
                return jSONObject;
            }
        }
        ab.e("MicroMsg.SoterAuthMgrImp", "hy: signature result is null");
        jSONObject = "";
        AppMethodBeat.o(41526);
        return jSONObject;
    }

    public final void bxv() {
        AppMethodBeat.i(41527);
        if (com.tencent.soter.core.a.aua(e.bxC())) {
            com.tencent.soter.core.a.cn(e.bxC(), false);
        }
        AppMethodBeat.o(41527);
    }

    public final com.tencent.mm.pluginsdk.wallet.j bxm() {
        AppMethodBeat.i(41528);
        this.mrU = new n();
        n nVar = this.mrU;
        AppMethodBeat.o(41528);
        return nVar;
    }

    public final Map<String, String> bxw() {
        AppMethodBeat.i(41529);
        HashMap hashMap = new HashMap();
        com.tencent.mm.plugin.soter.d.e cvQ = d.cvQ();
        String str = cvQ.rOh;
        String str2 = cvQ.jSY;
        hashMap.put("cpu_id", str);
        hashMap.put("uid", str2);
        AppMethodBeat.o(41529);
        return hashMap;
    }

    public final k bxx() {
        AppMethodBeat.i(41530);
        o oVar = new o();
        AppMethodBeat.o(41530);
        return oVar;
    }

    public final Map<String, String> bxy() {
        AppMethodBeat.i(41531);
        Map bxw = bxw();
        AppMethodBeat.o(41531);
        return bxw;
    }

    public final boolean bxz() {
        AppMethodBeat.i(41532);
        ab.i("MicroMsg.SoterAuthMgrImp", "py: hasAuthKey: %b", Boolean.valueOf(com.tencent.soter.core.a.aua(e.bxC())));
        if (!com.tencent.soter.core.a.aua(e.bxC())) {
            ab.i("MicroMsg.SoterAuthMgrImp", "hy: no ask or auth key");
            v.tCn.mso = true;
        }
        if (v.tCn.mso) {
            AppMethodBeat.o(41532);
            return false;
        }
        AppMethodBeat.o(41532);
        return true;
    }

    public final boolean a(boolean z, boolean z2, Bundle bundle) {
        AppMethodBeat.i(41533);
        ab.i("MicroMsg.SoterAuthMgrImp", "hy: post pay. is fingerprint pay: %b, is pay ok: %b, extInfo: %s", Boolean.valueOf(z), Boolean.valueOf(z2), bundle);
        if (!z) {
            String string = bundle.getString("pwd");
            int i = bundle.getInt("key_open_biometric_type");
            if (bo.isNullOrNil(string)) {
                ab.e("MicroMsg.SoterAuthMgrImp", "hy: no pwd. can not change auth key");
                AppMethodBeat.o(41533);
                return false;
            } else if (v.tCn.mso) {
                ab.i("MicroMsg.SoterAuthMgrImp", "hy: need change auth key. start gen auth key");
                com.tencent.soter.a.a.a(new com.tencent.soter.a.b.b<com.tencent.soter.a.b.c>() {
                    public final /* synthetic */ void a(e eVar) {
                        AppMethodBeat.i(41514);
                        com.tencent.soter.a.b.c cVar = (com.tencent.soter.a.b.c) eVar;
                        ab.i("MicroMsg.SoterAuthMgrImp", "hy: gen auth key onResult: errCode: %d, errMsg: %s", Integer.valueOf(cVar.errCode), cVar.aIm);
                        if (cVar.isSuccess()) {
                            ab.i("MicroMsg.SoterAuthMgrImp", "alvinluo gen auth key and upload success");
                        } else {
                            ab.e("MicroMsg.SoterAuthMgrImp", "alvinluo gen or upload auth key failed");
                            com.tencent.mm.plugin.soter.d.a.fH(2, cVar.errCode);
                        }
                        v.tCn.reset();
                        AppMethodBeat.o(41514);
                    }
                }, true, 1, new com.tencent.mm.plugin.fingerprint.c.c(string, i), new f());
            }
        }
        AppMethodBeat.o(41533);
        return false;
    }

    public final boolean bxf() {
        AppMethodBeat.i(41534);
        boolean iT = com.tencent.soter.core.a.iT(ah.getContext());
        AppMethodBeat.o(41534);
        return iT;
    }

    public final void bxk() {
        AppMethodBeat.i(41535);
        if (this.mrV != null && VERSION.SDK_INT >= 16) {
            ab.i("MicroMsg.SoterAuthMgrImp", "alvinluo cancel fingeprint canceller");
            this.mrV.rr(true);
        }
        if (this.mrW != null) {
            ab.i("MicroMsg.SoterAuthMgrImp", "cancel biometric canceller");
            this.mrW.rp(true);
        }
        AppMethodBeat.o(41535);
    }

    public final int type() {
        return 2;
    }

    public final boolean bxA() {
        AppMethodBeat.i(41536);
        int i = q.eti.eue & 2;
        if (!q.eti.cOQ || i != 2) {
            ab.e("MicroMsg.SoterAuthMgrImp", "peteryan check isDeviceSupportFaceID from DeviceInfo.mSoterInfo return false typeis[%d]", Integer.valueOf(q.eti.eue));
            AppMethodBeat.o(41536);
            return false;
        } else if (com.tencent.soter.a.a.dRc() && com.tencent.soter.core.a.iQ(ah.getContext())) {
            AppMethodBeat.o(41536);
            return true;
        } else {
            AppMethodBeat.o(41536);
            return false;
        }
    }

    public final boolean bxB() {
        AppMethodBeat.i(41537);
        boolean iS = com.tencent.soter.core.a.iS(ah.getContext());
        AppMethodBeat.o(41537);
        return iS;
    }

    public final boolean bxg() {
        AppMethodBeat.i(41538);
        boolean aC = com.tencent.soter.core.a.aC(ah.getContext(), 2);
        AppMethodBeat.o(41538);
        return aC;
    }
}
