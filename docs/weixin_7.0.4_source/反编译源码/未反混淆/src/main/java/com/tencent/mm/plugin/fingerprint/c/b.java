package com.tencent.mm.plugin.fingerprint.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.soter.b.d;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.ccs;
import com.tencent.mm.protocal.protobuf.cct;
import com.tencent.mm.sdk.platformtools.ab;
import com.tenpay.android.wechat.TenpayUtil;

public final class b extends d implements k {
    public final com.tencent.mm.ai.b ehh;
    private f ehi;
    private int msp;

    public b(String str, String str2, String str3, int i) {
        AppMethodBeat.i(41573);
        a aVar = new a();
        aVar.fsJ = new ccs();
        aVar.fsK = new cct();
        aVar.uri = "/cgi-bin/mmpay-bin/soteropenfppayment";
        this.ehh = aVar.acD();
        ccs ccs = (ccs) this.ehh.fsG.fsP;
        ccs.wKv = str;
        ccs.signature = str2;
        ccs.xcb = str3;
        ccs.cDo = TenpayUtil.signWith3Des("passwd=" + ccs.xcb);
        ccs.xbY = i;
        ccs.xbZ = 1;
        this.msp = i;
        ab.i("MicroMsg.NetSceneSoterOpenTouchPay", "soter type: %s", Integer.valueOf(i));
        AppMethodBeat.o(41573);
    }

    public final void d(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(41574);
        ab.i("MicroMsg.NetSceneSoterOpenTouchPay", "hy: errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (i == 0 && i2 == 0) {
            ab.i("MicroMsg.NetSceneSoterOpenTouchPay", "open fingerprintpay success");
            if (this.msp == 1) {
                ((l) g.K(l.class)).hq(true);
                ((l) g.K(l.class)).hr(false);
            } else {
                ((l) g.K(l.class)).hr(true);
                ((l) g.K(l.class)).hq(false);
            }
        } else {
            ab.e("MicroMsg.NetSceneSoterOpenTouchPay", "open fingerprintpay failed");
        }
        this.ehi.onSceneEnd(i, i2, "", this);
        AppMethodBeat.o(41574);
    }

    public final void bxO() {
        AppMethodBeat.i(41575);
        ab.i("MicroMsg.NetSceneSoterOpenTouchPay", "hy: authkey required");
        if (this.ehi != null) {
            this.ehi.onSceneEnd(4, -1, "", this);
        }
        AppMethodBeat.o(41575);
    }

    public final void vL(int i) {
        AppMethodBeat.i(41576);
        ab.i("MicroMsg.NetSceneSoterOpenTouchPay", "hy: onError: errType: %d, errcode: %d", Integer.valueOf(3), Integer.valueOf(i));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(4, -1, "", this);
        }
        AppMethodBeat.o(41576);
    }

    public final int getType() {
        return 1638;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(41577);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(41577);
        return a;
    }
}
