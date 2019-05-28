package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.bcj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONObject;

public final class ae extends m {
    private long fRS;
    public String tuA;
    public String tuB;
    public String tuC;
    public String tuD;
    public String tuE;
    public int tuF;
    public int tuG;

    public ae() {
        AppMethodBeat.i(46557);
        M(null);
        AppMethodBeat.o(46557);
    }

    public final int bgI() {
        return 0;
    }

    public final int ZU() {
        return 1992;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/gettransferwording";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(46558);
        ab.i("MicroMsg.NetSceneTransferWording", "errCode: %d, errMsg: %s", Integer.valueOf(i), str);
        ab.d("MicroMsg.NetSceneTransferWording", "json: %s", jSONObject);
        this.tuA = jSONObject.optString("delay_confirm_wording");
        this.tuB = jSONObject.optString("delay_confirm_switch_wording");
        this.tuC = jSONObject.optString("delay_confirm_switch_remind_wording");
        this.tuD = jSONObject.optString("delay_confirm_desc_url");
        this.tuF = jSONObject.optInt("delay_confirm_desc_url_flag", 0);
        this.fRS = jSONObject.optLong("expire_time", 0) * 1000;
        this.tuG = jSONObject.optInt("delay_confirm_switch_flag", 0);
        g.RQ();
        z Ry = g.RP().Ry();
        if (!bo.isNullOrNil(this.tuA)) {
            Ry.set(a.USERINFO_DELAY_TRANSFER_CONFIRM_WORDING_STRING, this.tuA);
        }
        if (!bo.isNullOrNil(this.tuB)) {
            Ry.set(a.USERINFO_DELAY_TRANSFER_SWITCH_WORDING_STRING, this.tuB);
        }
        if (!bo.isNullOrNil(this.tuC)) {
            Ry.set(a.USERINFO_DELAY_TRANSFER_REMIND_WORDING_STRING, this.tuC);
        }
        if (!bo.isNullOrNil(this.tuD)) {
            try {
                this.tuE = URLDecoder.decode(this.tuD, "UTF-8");
                if (!bo.isNullOrNil(this.tuE)) {
                    Ry.set(a.USERINFO_DELAY_TRANSFER_DESC_URL_STRING, this.tuE);
                }
            } catch (UnsupportedEncodingException e) {
                ab.printErrStackTrace("MicroMsg.NetSceneTransferWording", e, "", new Object[0]);
            }
        }
        Ry.set(a.USERINFO_DELAY_TRANSFER_DESC_URL_FLAG_INT, Integer.valueOf(this.tuF));
        Ry.set(a.USERINFO_DELAY_TRANSFER_EXPIRE_TIME_LONG, Long.valueOf(this.fRS));
        Ry.set(a.USERINFO_DELAY_TRANSFER_SHOW_SWITCH_FLAG_INT, Integer.valueOf(this.tuG));
        if (this.tuG == 0) {
            ab.i("MicroMsg.NetSceneTransferWording", "do reset oplog");
            bcj bcj = new bcj();
            bcj.pXD = 0;
            ((j) g.K(j.class)).XL().c(new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(205, bcj));
            Ry.set(147457, Long.valueOf((((Long) Ry.get(147457, Long.valueOf(0))).longValue() & -17) & -33));
        }
        AppMethodBeat.o(46558);
    }

    public static boolean a(boolean z, i iVar) {
        AppMethodBeat.i(46559);
        g.RQ();
        long longValue = ((Long) g.RP().Ry().get(a.USERINFO_DELAY_TRANSFER_EXPIRE_TIME_LONG, Long.valueOf(0))).longValue();
        if (z || longValue < System.currentTimeMillis()) {
            ab.i("MicroMsg.NetSceneTransferWording", "do scene: %d, force: %B", Long.valueOf(longValue), Boolean.valueOf(z));
            if (iVar != null) {
                iVar.a(new ae(), false, 1);
            } else {
                g.RQ();
                g.RO().eJo.a(new ae(), 0);
            }
            AppMethodBeat.o(46559);
            return true;
        }
        ab.d("MicroMsg.NetSceneTransferWording", "not time");
        AppMethodBeat.o(46559);
        return false;
    }

    public final boolean bXm() {
        return false;
    }
}
