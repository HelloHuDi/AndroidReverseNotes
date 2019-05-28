package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.pd;
import com.tencent.mm.protocal.protobuf.pe;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b extends a {
    private final String TAG = "MicroMsg.NetSceneQrRewardGetCode";
    private com.tencent.mm.ai.b ehh;
    private f ehi;
    public pe kDu;
    public boolean kDv;

    public b(boolean z) {
        AppMethodBeat.i(41034);
        a aVar = new a();
        aVar.fsJ = new pd();
        aVar.fsK = new pe();
        aVar.fsI = 1323;
        aVar.uri = "/cgi-bin/mmpay-bin/getrewardqrcode";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        ((pd) this.ehh.fsG.fsP).vWp = z;
        this.kDv = z;
        AppMethodBeat.o(41034);
    }

    public final int getType() {
        return 1323;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(41035);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(41035);
        return a;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean bgQ() {
        return false;
    }

    public final void b(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(41036);
        ab.i("MicroMsg.NetSceneQrRewardGetCode", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.kDu = (pe) ((com.tencent.mm.ai.b) qVar).fsH.fsP;
        ab.i("MicroMsg.NetSceneQrRewardGetCode", "retcode: %s, retmsg: %s", Integer.valueOf(this.kDu.kCl), this.kDu.kCm);
        if (!(this.kDr || this.kDu.kCl == 0)) {
            this.kDs = true;
        }
        if (!this.kDr && !this.kDs) {
            g.RP().Ry().set(ac.a.USERINFO_WALLET_QR_REWARD_PHOTO_WIDTH_INT_SYNC, Integer.valueOf(this.kDu.vWw));
            g.RP().Ry().set(ac.a.USERINFO_WALLET_QR_REWARD_ICON_WIDTH_INT_SYNC, Integer.valueOf(this.kDu.vWs));
            g.RP().Ry().set(ac.a.USERINFO_WALLET_QR_REWARD_DESC_STRING_SYNC, this.kDu.desc);
            g.RP().Ry().set(ac.a.USERINFO_WALLET_QR_REWARD_WORD_STRING_SYNC, this.kDu.jMS);
            g.RP().Ry().set(ac.a.USERINFO_WALLET_QR_REWARD_MAX_AMT_INT_SYNC, Integer.valueOf(this.kDu.vWv));
            g.RP().Ry().set(ac.a.USERINFO_WALLET_QR_REWARD_BOTTOM_STR_STRING_SYNC, this.kDu.kdE);
            g.RP().Ry().set(ac.a.USERINFO_WALLET_QR_REWARD_BOTTOM_URL_STRING_SYNC, this.kDu.vWu);
            g.RP().Ry().set(ac.a.USERINFO_WALLET_QR_REWARD_LAST_PHOTO_URL_STRING_SYNC, this.kDu.pOy);
            List arrayList = new ArrayList();
            Iterator it = this.kDu.vWt.iterator();
            while (it.hasNext()) {
                arrayList.add(String.valueOf(((Integer) it.next()).intValue()));
            }
            g.RP().Ry().set(ac.a.USERINFO_WALLET_QR_REWARD_AMT_LIST_STRING_SYNC, bo.c(arrayList, ","));
            h.pYm.a(724, 2, 1, false);
        } else if (this.kDr) {
            h.pYm.a(724, 4, 1, false);
        } else {
            h.pYm.a(724, 3, 1, false);
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.o(41036);
    }
}
