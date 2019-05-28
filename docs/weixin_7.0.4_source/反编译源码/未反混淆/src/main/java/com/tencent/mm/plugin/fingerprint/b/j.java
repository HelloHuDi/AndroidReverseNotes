package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.lv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.wallet.k;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.rtmp.TXLiveConstants;

public final class j extends c<lv> {
    private String czZ;
    private a mrO;
    lv mrP;
    private k mrQ;
    private Runnable mrR;
    boolean mru;

    public class a implements com.tencent.mm.pluginsdk.wallet.c {
        public final void bJ(int i, int i2) {
            AppMethodBeat.i(41490);
            if (j.this.mru) {
                ab.e("MicroMsg.OpenFingerPrintAuthEventListener", "hy: event already end. ignore");
                AppMethodBeat.o(41490);
                return;
            }
            String string;
            switch (i) {
                case 0:
                    ab.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: identify FingerPrintConst.RESULT_SUCCESS");
                    j jVar = j.this;
                    ab.i("MicroMsg.OpenFingerPrintAuthEventListener", "onSuccess()");
                    jVar.mru = true;
                    com.tencent.mm.plugin.fingerprint.a.bwM();
                    com.tencent.mm.plugin.fingerprint.a.bwN();
                    ((l) g.K(l.class)).a(jVar.mrP, i2);
                    if (jVar.mru) {
                        jVar.mrP = null;
                    }
                    ab.i("MicroMsg.OpenFingerPrintAuthEventListener", "callback OpenFingerPrintAuthEvent onSuccess()");
                    j.bxK();
                    AppMethodBeat.o(41490);
                    return;
                case 2000:
                    ab.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: identify timeout");
                    AppMethodBeat.o(41490);
                    return;
                case 2001:
                    j.this.hv(false);
                    ab.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: identify FingerPrintConst.RESULT_TIMEOUT");
                    AppMethodBeat.o(41490);
                    return;
                case 2002:
                    ab.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: identify FingerPrintConst.RESULT_NO_MATCH");
                    j.this.mru = false;
                    j.bxK();
                    j.this.hv(true);
                    j.this.R(1, "");
                    AppMethodBeat.o(41490);
                    return;
                case 2004:
                case TXLiveConstants.PLAY_EVT_PLAY_PROGRESS /*2005*/:
                case TXLiveConstants.PLAY_EVT_PLAY_LOADING /*2007*/:
                case 10308:
                    ab.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: on error: %d", Integer.valueOf(i));
                    j.this.mru = true;
                    string = ah.getContext().getString(R.string.ere);
                    if (i == 10308) {
                        string = ah.getContext().getString(R.string.erf);
                    } else if (i == TXLiveConstants.PLAY_EVT_PLAY_LOADING) {
                        v.tCn.mso = true;
                    }
                    j.bxK();
                    j.this.R(2, string);
                    AppMethodBeat.o(41490);
                    return;
                case 2009:
                    ab.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: on error: %d", Integer.valueOf(i));
                    if (j.this.mrP != null) {
                        com.tencent.mm.plugin.soter.d.a.EE(j.this.mrP.cHD.cHG);
                    }
                    j.this.mru = true;
                    string = ah.getContext().getString(R.string.ere);
                    j.bxK();
                    j.this.R(i, string);
                    break;
            }
            AppMethodBeat.o(41490);
        }
    }

    public j() {
        AppMethodBeat.i(41491);
        this.mrQ = null;
        this.mrR = null;
        this.mru = false;
        this.czZ = "";
        this.xxI = lv.class.getName().hashCode();
        AppMethodBeat.o(41491);
    }

    public final /* synthetic */ boolean a(b bVar) {
        AppMethodBeat.i(41496);
        lv lvVar = (lv) bVar;
        if (g.RK()) {
            this.mru = false;
            if (lvVar instanceof lv) {
                ab.i("MicroMsg.OpenFingerPrintAuthEventListener", "handle OpenFingerPrintAuthEventListener");
                if (e.bxs()) {
                    this.mrP = lvVar;
                    if (this.mrP == null) {
                        ab.e("MicroMsg.OpenFingerPrintAuthEventListener", null, "mEvent is null !!!");
                    } else {
                        this.mrR = this.mrP.cHD.cHH;
                        this.czZ = lvVar.cHD.cBT;
                        com.tencent.mm.plugin.fingerprint.a.bwM();
                        if (com.tencent.mm.plugin.fingerprint.a.bwN() != null) {
                            com.tencent.mm.plugin.fingerprint.a.bwM();
                            com.tencent.mm.plugin.fingerprint.a.bwN();
                            boolean bxl = c.bxl();
                            if (this.mrO == null) {
                                this.mrO = new a();
                            }
                            com.tencent.mm.plugin.fingerprint.a.bwM();
                            com.tencent.mm.plugin.fingerprint.a.bwN();
                            this.mrQ = ((l) g.K(l.class)).bxx();
                            if (this.mrQ != null) {
                                this.mrQ.a(new com.tencent.mm.pluginsdk.wallet.a() {
                                    public final void aC(int i, String str) {
                                        AppMethodBeat.i(41489);
                                        ab.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: pre processing done. errCode: %d, errMsg: %s", Integer.valueOf(i), str);
                                        if (i == 0) {
                                            j.this.hv(false);
                                            AppMethodBeat.o(41489);
                                            return;
                                        }
                                        j.this.R(1, "");
                                        AppMethodBeat.o(41489);
                                    }
                                });
                                AppMethodBeat.o(41496);
                                return bxl;
                            }
                            boolean hv = hv(false);
                            AppMethodBeat.o(41496);
                            return hv;
                        }
                        AppMethodBeat.o(41496);
                        return true;
                    }
                }
                ab.e("MicroMsg.OpenFingerPrintAuthEventListener", "device is not support FingerPrintAuth");
                this.mru = true;
                R(1, "");
                AppMethodBeat.o(41496);
                return true;
            }
        }
        ab.e("MicroMsg.OpenFingerPrintAuthEventListener", "OpenFingerPrintAuthEvent account is not ready");
        AppMethodBeat.o(41496);
        return false;
    }

    public final void release() {
        AppMethodBeat.i(41492);
        com.tencent.mm.plugin.fingerprint.a.bwM();
        if (com.tencent.mm.plugin.fingerprint.a.bwN() != null) {
            com.tencent.mm.plugin.fingerprint.a.bwM();
            com.tencent.mm.plugin.fingerprint.a.bwN();
            c.release();
        }
        this.mrP = null;
        AppMethodBeat.o(41492);
    }

    public static void bxK() {
        AppMethodBeat.i(41493);
        com.tencent.mm.plugin.fingerprint.a.bwM();
        if (com.tencent.mm.plugin.fingerprint.a.bwN() != null) {
            boolean z;
            com.tencent.mm.plugin.fingerprint.a.bwM();
            com.tencent.mm.plugin.fingerprint.a.bwN();
            c.abort();
            com.tencent.mm.plugin.fingerprint.a.bwM();
            com.tencent.mm.plugin.fingerprint.a.bwN();
            c.release();
            String str = "MicroMsg.OpenFingerPrintAuthEventListener";
            String str2 = "stopIdentify() isSoter: %b";
            Object[] objArr = new Object[1];
            com.tencent.mm.plugin.fingerprint.a.bwM();
            com.tencent.mm.plugin.fingerprint.a.bwN();
            if (((l) g.K(l.class)).type() == 2) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            ab.i(str, str2, objArr);
        }
        AppMethodBeat.o(41493);
    }

    /* Access modifiers changed, original: final */
    public final boolean hv(boolean z) {
        AppMethodBeat.i(41494);
        bxK();
        com.tencent.mm.plugin.fingerprint.a.bwM();
        com.tencent.mm.plugin.fingerprint.a.bwN();
        if (c.bxl()) {
            com.tencent.mm.plugin.fingerprint.a.bwM();
            com.tencent.mm.plugin.fingerprint.a.bwN();
            if (c.a(this.mrO, z) != 0) {
                ab.e("MicroMsg.OpenFingerPrintAuthEventListener", "failed to start identify");
                release();
                this.mru = true;
                R(1, "");
                AppMethodBeat.o(41494);
                return false;
            }
            ab.i("MicroMsg.OpenFingerPrintAuthEventListener", "startIdentify()");
            AppMethodBeat.o(41494);
            return true;
        }
        ab.e("MicroMsg.OpenFingerPrintAuthEventListener", "no fingerprints enrolled, use settings to enroll fingerprints first");
        release();
        this.mru = true;
        R(1, "");
        AppMethodBeat.o(41494);
        return false;
    }

    /* Access modifiers changed, original: final */
    public final void R(int i, String str) {
        AppMethodBeat.i(41495);
        ab.i("MicroMsg.OpenFingerPrintAuthEventListener", "onFail()");
        com.tencent.mm.plugin.fingerprint.a.bwM();
        com.tencent.mm.plugin.fingerprint.a.bwN();
        c.a(this.mrP, i, str);
        if (this.mru) {
            this.mrP = null;
        }
        ab.i("MicroMsg.OpenFingerPrintAuthEventListener", "callback OpenFingerPrintAuthEvent onFail()");
        AppMethodBeat.o(41495);
    }
}
