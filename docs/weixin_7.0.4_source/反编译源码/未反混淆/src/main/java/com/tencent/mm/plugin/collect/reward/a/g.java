package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.pu;
import com.tencent.mm.protocal.protobuf.pv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g extends a {
    private final String TAG = "MicroMsg.NetSceneQrRewardSetCode";
    private b ehh;
    private f ehi;
    public pv kDA;

    public g(LinkedList<Integer> linkedList, String str, boolean z, boolean z2) {
        AppMethodBeat.i(41048);
        a aVar = new a();
        aVar.fsJ = new pu();
        aVar.fsK = new pv();
        aVar.fsI = 1562;
        aVar.uri = "/cgi-bin/mmpay-bin/setrewardqrcode";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        pu puVar = (pu) this.ehh.fsG.fsP;
        puVar.vWt = linkedList;
        puVar.desc = str;
        puVar.vWT = z;
        puVar.vWU = z2;
        ab.i("MicroMsg.NetSceneQrRewardSetCode", "desc: %s, flag: %s, default: %s", str, Boolean.valueOf(z), Boolean.valueOf(z2));
        AppMethodBeat.o(41048);
    }

    public final int getType() {
        return 1562;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(41049);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(41049);
        return a;
    }

    public final void b(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(41050);
        ab.i("MicroMsg.NetSceneQrRewardSetCode", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.kDA = (pv) ((b) qVar).fsH.fsP;
        ab.i("MicroMsg.NetSceneQrRewardSetCode", "retcode: %s, retmsg: %s", Integer.valueOf(this.kDA.kCl), this.kDA.kCm);
        if (!(this.kDr || this.kDA.kCl == 0)) {
            this.kDs = true;
        }
        if (!this.kDr && !this.kDs) {
            com.tencent.mm.kernel.g.RP().Ry().set(ac.a.USERINFO_WALLET_QR_REWARD_PHOTO_WIDTH_INT_SYNC, Integer.valueOf(this.kDA.vWw));
            com.tencent.mm.kernel.g.RP().Ry().set(ac.a.USERINFO_WALLET_QR_REWARD_ICON_WIDTH_INT_SYNC, Integer.valueOf(this.kDA.vWs));
            com.tencent.mm.kernel.g.RP().Ry().set(ac.a.USERINFO_WALLET_QR_REWARD_DESC_STRING_SYNC, this.kDA.desc);
            com.tencent.mm.kernel.g.RP().Ry().set(ac.a.USERINFO_WALLET_QR_REWARD_LAST_PHOTO_URL_STRING_SYNC, this.kDA.pOy);
            List arrayList = new ArrayList();
            Iterator it = this.kDA.vWt.iterator();
            while (it.hasNext()) {
                arrayList.add(String.valueOf(((Integer) it.next()).intValue()));
            }
            com.tencent.mm.kernel.g.RP().Ry().set(ac.a.USERINFO_WALLET_QR_REWARD_AMT_LIST_STRING_SYNC, bo.c(arrayList, ","));
            h.pYm.a(724, 5, 1, false);
        } else if (this.kDr) {
            h.pYm.a(724, 7, 1, false);
        } else {
            h.pYm.a(724, 6, 1, false);
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.o(41050);
    }
}
