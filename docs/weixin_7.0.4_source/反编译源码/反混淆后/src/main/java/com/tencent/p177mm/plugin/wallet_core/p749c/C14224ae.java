package com.tencent.p177mm.plugin.wallet_core.p749c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3465a;
import com.tencent.p177mm.protocal.protobuf.bcj;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7580z;
import com.tencent.p177mm.wallet_core.p760d.C30868i;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_core.c.ae */
public final class C14224ae extends C5749m {
    private long fRS;
    public String tuA;
    public String tuB;
    public String tuC;
    public String tuD;
    public String tuE;
    public int tuF;
    public int tuG;

    public C14224ae() {
        AppMethodBeat.m2504i(46557);
        mo70323M(null);
        AppMethodBeat.m2505o(46557);
    }

    public final int bgI() {
        return 0;
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return 1992;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/gettransferwording";
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(46558);
        C4990ab.m7417i("MicroMsg.NetSceneTransferWording", "errCode: %d, errMsg: %s", Integer.valueOf(i), str);
        C4990ab.m7411d("MicroMsg.NetSceneTransferWording", "json: %s", jSONObject);
        this.tuA = jSONObject.optString("delay_confirm_wording");
        this.tuB = jSONObject.optString("delay_confirm_switch_wording");
        this.tuC = jSONObject.optString("delay_confirm_switch_remind_wording");
        this.tuD = jSONObject.optString("delay_confirm_desc_url");
        this.tuF = jSONObject.optInt("delay_confirm_desc_url_flag", 0);
        this.fRS = jSONObject.optLong("expire_time", 0) * 1000;
        this.tuG = jSONObject.optInt("delay_confirm_switch_flag", 0);
        C1720g.m3537RQ();
        C7580z Ry = C1720g.m3536RP().mo5239Ry();
        if (!C5046bo.isNullOrNil(this.tuA)) {
            Ry.set(C5127a.USERINFO_DELAY_TRANSFER_CONFIRM_WORDING_STRING, this.tuA);
        }
        if (!C5046bo.isNullOrNil(this.tuB)) {
            Ry.set(C5127a.USERINFO_DELAY_TRANSFER_SWITCH_WORDING_STRING, this.tuB);
        }
        if (!C5046bo.isNullOrNil(this.tuC)) {
            Ry.set(C5127a.USERINFO_DELAY_TRANSFER_REMIND_WORDING_STRING, this.tuC);
        }
        if (!C5046bo.isNullOrNil(this.tuD)) {
            try {
                this.tuE = URLDecoder.decode(this.tuD, "UTF-8");
                if (!C5046bo.isNullOrNil(this.tuE)) {
                    Ry.set(C5127a.USERINFO_DELAY_TRANSFER_DESC_URL_STRING, this.tuE);
                }
            } catch (UnsupportedEncodingException e) {
                C4990ab.printErrStackTrace("MicroMsg.NetSceneTransferWording", e, "", new Object[0]);
            }
        }
        Ry.set(C5127a.USERINFO_DELAY_TRANSFER_DESC_URL_FLAG_INT, Integer.valueOf(this.tuF));
        Ry.set(C5127a.USERINFO_DELAY_TRANSFER_EXPIRE_TIME_LONG, Long.valueOf(this.fRS));
        Ry.set(C5127a.USERINFO_DELAY_TRANSFER_SHOW_SWITCH_FLAG_INT, Integer.valueOf(this.tuG));
        if (this.tuG == 0) {
            C4990ab.m7416i("MicroMsg.NetSceneTransferWording", "do reset oplog");
            bcj bcj = new bcj();
            bcj.pXD = 0;
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C3465a(205, bcj));
            Ry.set(147457, Long.valueOf((((Long) Ry.get(147457, Long.valueOf(0))).longValue() & -17) & -33));
        }
        AppMethodBeat.m2505o(46558);
    }

    /* renamed from: a */
    public static boolean m22423a(boolean z, C30868i c30868i) {
        AppMethodBeat.m2504i(46559);
        C1720g.m3537RQ();
        long longValue = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_DELAY_TRANSFER_EXPIRE_TIME_LONG, Long.valueOf(0))).longValue();
        if (z || longValue < System.currentTimeMillis()) {
            C4990ab.m7417i("MicroMsg.NetSceneTransferWording", "do scene: %d, force: %B", Long.valueOf(longValue), Boolean.valueOf(z));
            if (c30868i != null) {
                c30868i.mo49367a(new C14224ae(), false, 1);
            } else {
                C1720g.m3537RQ();
                C1720g.m3535RO().eJo.mo14541a(new C14224ae(), 0);
            }
            AppMethodBeat.m2505o(46559);
            return true;
        }
        C4990ab.m7410d("MicroMsg.NetSceneTransferWording", "not time");
        AppMethodBeat.m2505o(46559);
        return false;
    }

    public final boolean bXm() {
        return false;
    }
}
