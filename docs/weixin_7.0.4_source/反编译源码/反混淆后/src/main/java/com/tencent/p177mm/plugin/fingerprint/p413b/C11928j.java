package com.tencent.p177mm.plugin.fingerprint.p413b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p230g.p231a.C18316lv;
import com.tencent.p177mm.plugin.fingerprint.C43094a;
import com.tencent.p177mm.plugin.soter.p528d.C46261a;
import com.tencent.p177mm.plugin.wallet_core.model.C35481v;
import com.tencent.p177mm.pluginsdk.C30052l;
import com.tencent.p177mm.pluginsdk.wallet.C14990c;
import com.tencent.p177mm.pluginsdk.wallet.C30157a;
import com.tencent.p177mm.pluginsdk.wallet.C4786k;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.rtmp.TXLiveConstants;

/* renamed from: com.tencent.mm.plugin.fingerprint.b.j */
public final class C11928j extends C4884c<C18316lv> {
    private String czZ;
    private C3113a mrO;
    C18316lv mrP;
    private C4786k mrQ;
    private Runnable mrR;
    boolean mru;

    /* renamed from: com.tencent.mm.plugin.fingerprint.b.j$a */
    public class C3113a implements C14990c {
        /* renamed from: bJ */
        public final void mo7357bJ(int i, int i2) {
            AppMethodBeat.m2504i(41490);
            if (C11928j.this.mru) {
                C4990ab.m7412e("MicroMsg.OpenFingerPrintAuthEventListener", "hy: event already end. ignore");
                AppMethodBeat.m2505o(41490);
                return;
            }
            String string;
            switch (i) {
                case 0:
                    C4990ab.m7416i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: identify FingerPrintConst.RESULT_SUCCESS");
                    C11928j c11928j = C11928j.this;
                    C4990ab.m7416i("MicroMsg.OpenFingerPrintAuthEventListener", "onSuccess()");
                    c11928j.mru = true;
                    C43094a.bwM();
                    C43094a.bwN();
                    ((C30052l) C1720g.m3528K(C30052l.class)).mo48285a(c11928j.mrP, i2);
                    if (c11928j.mru) {
                        c11928j.mrP = null;
                    }
                    C4990ab.m7416i("MicroMsg.OpenFingerPrintAuthEventListener", "callback OpenFingerPrintAuthEvent onSuccess()");
                    C11928j.bxK();
                    AppMethodBeat.m2505o(41490);
                    return;
                case 2000:
                    C4990ab.m7416i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: identify timeout");
                    AppMethodBeat.m2505o(41490);
                    return;
                case 2001:
                    C11928j.this.mo23776hv(false);
                    C4990ab.m7416i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: identify FingerPrintConst.RESULT_TIMEOUT");
                    AppMethodBeat.m2505o(41490);
                    return;
                case 2002:
                    C4990ab.m7416i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: identify FingerPrintConst.RESULT_NO_MATCH");
                    C11928j.this.mru = false;
                    C11928j.bxK();
                    C11928j.this.mo23776hv(true);
                    C11928j.this.mo23775R(1, "");
                    AppMethodBeat.m2505o(41490);
                    return;
                case 2004:
                case TXLiveConstants.PLAY_EVT_PLAY_PROGRESS /*2005*/:
                case TXLiveConstants.PLAY_EVT_PLAY_LOADING /*2007*/:
                case 10308:
                    C4990ab.m7417i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: on error: %d", Integer.valueOf(i));
                    C11928j.this.mru = true;
                    string = C4996ah.getContext().getString(C25738R.string.ere);
                    if (i == 10308) {
                        string = C4996ah.getContext().getString(C25738R.string.erf);
                    } else if (i == TXLiveConstants.PLAY_EVT_PLAY_LOADING) {
                        C35481v.tCn.mso = true;
                    }
                    C11928j.bxK();
                    C11928j.this.mo23775R(2, string);
                    AppMethodBeat.m2505o(41490);
                    return;
                case 2009:
                    C4990ab.m7417i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: on error: %d", Integer.valueOf(i));
                    if (C11928j.this.mrP != null) {
                        C46261a.m86638EE(C11928j.this.mrP.cHD.cHG);
                    }
                    C11928j.this.mru = true;
                    string = C4996ah.getContext().getString(C25738R.string.ere);
                    C11928j.bxK();
                    C11928j.this.mo23775R(i, string);
                    break;
            }
            AppMethodBeat.m2505o(41490);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fingerprint.b.j$1 */
    class C119291 implements C30157a {
        C119291() {
        }

        /* renamed from: aC */
        public final void mo7375aC(int i, String str) {
            AppMethodBeat.m2504i(41489);
            C4990ab.m7417i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: pre processing done. errCode: %d, errMsg: %s", Integer.valueOf(i), str);
            if (i == 0) {
                C11928j.this.mo23776hv(false);
                AppMethodBeat.m2505o(41489);
                return;
            }
            C11928j.this.mo23775R(1, "");
            AppMethodBeat.m2505o(41489);
        }
    }

    public C11928j() {
        AppMethodBeat.m2504i(41491);
        this.mrQ = null;
        this.mrR = null;
        this.mru = false;
        this.czZ = "";
        this.xxI = C18316lv.class.getName().hashCode();
        AppMethodBeat.m2505o(41491);
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        AppMethodBeat.m2504i(41496);
        C18316lv c18316lv = (C18316lv) c4883b;
        if (C1720g.m3531RK()) {
            this.mru = false;
            if (c18316lv instanceof C18316lv) {
                C4990ab.m7416i("MicroMsg.OpenFingerPrintAuthEventListener", "handle OpenFingerPrintAuthEventListener");
                if (C39088e.bxs()) {
                    this.mrP = c18316lv;
                    if (this.mrP == null) {
                        C4990ab.m7413e("MicroMsg.OpenFingerPrintAuthEventListener", null, "mEvent is null !!!");
                    } else {
                        this.mrR = this.mrP.cHD.cHH;
                        this.czZ = c18316lv.cHD.cBT;
                        C43094a.bwM();
                        if (C43094a.bwN() != null) {
                            C43094a.bwM();
                            C43094a.bwN();
                            boolean bxl = C39086c.bxl();
                            if (this.mrO == null) {
                                this.mrO = new C3113a();
                            }
                            C43094a.bwM();
                            C43094a.bwN();
                            this.mrQ = ((C30052l) C1720g.m3528K(C30052l.class)).bxx();
                            if (this.mrQ != null) {
                                this.mrQ.mo9938a(new C119291());
                                AppMethodBeat.m2505o(41496);
                                return bxl;
                            }
                            boolean hv = mo23776hv(false);
                            AppMethodBeat.m2505o(41496);
                            return hv;
                        }
                        AppMethodBeat.m2505o(41496);
                        return true;
                    }
                }
                C4990ab.m7412e("MicroMsg.OpenFingerPrintAuthEventListener", "device is not support FingerPrintAuth");
                this.mru = true;
                mo23775R(1, "");
                AppMethodBeat.m2505o(41496);
                return true;
            }
        }
        C4990ab.m7412e("MicroMsg.OpenFingerPrintAuthEventListener", "OpenFingerPrintAuthEvent account is not ready");
        AppMethodBeat.m2505o(41496);
        return false;
    }

    public final void release() {
        AppMethodBeat.m2504i(41492);
        C43094a.bwM();
        if (C43094a.bwN() != null) {
            C43094a.bwM();
            C43094a.bwN();
            C39086c.release();
        }
        this.mrP = null;
        AppMethodBeat.m2505o(41492);
    }

    public static void bxK() {
        AppMethodBeat.m2504i(41493);
        C43094a.bwM();
        if (C43094a.bwN() != null) {
            boolean z;
            C43094a.bwM();
            C43094a.bwN();
            C39086c.abort();
            C43094a.bwM();
            C43094a.bwN();
            C39086c.release();
            String str = "MicroMsg.OpenFingerPrintAuthEventListener";
            String str2 = "stopIdentify() isSoter: %b";
            Object[] objArr = new Object[1];
            C43094a.bwM();
            C43094a.bwN();
            if (((C30052l) C1720g.m3528K(C30052l.class)).type() == 2) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            C4990ab.m7417i(str, str2, objArr);
        }
        AppMethodBeat.m2505o(41493);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: hv */
    public final boolean mo23776hv(boolean z) {
        AppMethodBeat.m2504i(41494);
        C11928j.bxK();
        C43094a.bwM();
        C43094a.bwN();
        if (C39086c.bxl()) {
            C43094a.bwM();
            C43094a.bwN();
            if (C39086c.m66508a(this.mrO, z) != 0) {
                C4990ab.m7412e("MicroMsg.OpenFingerPrintAuthEventListener", "failed to start identify");
                release();
                this.mru = true;
                mo23775R(1, "");
                AppMethodBeat.m2505o(41494);
                return false;
            }
            C4990ab.m7416i("MicroMsg.OpenFingerPrintAuthEventListener", "startIdentify()");
            AppMethodBeat.m2505o(41494);
            return true;
        }
        C4990ab.m7412e("MicroMsg.OpenFingerPrintAuthEventListener", "no fingerprints enrolled, use settings to enroll fingerprints first");
        release();
        this.mru = true;
        mo23775R(1, "");
        AppMethodBeat.m2505o(41494);
        return false;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: R */
    public final void mo23775R(int i, String str) {
        AppMethodBeat.m2504i(41495);
        C4990ab.m7416i("MicroMsg.OpenFingerPrintAuthEventListener", "onFail()");
        C43094a.bwM();
        C43094a.bwN();
        C39086c.m66509a(this.mrP, i, str);
        if (this.mru) {
            this.mrP = null;
        }
        C4990ab.m7416i("MicroMsg.OpenFingerPrintAuthEventListener", "callback OpenFingerPrintAuthEvent onFail()");
        AppMethodBeat.m2505o(41495);
    }
}
