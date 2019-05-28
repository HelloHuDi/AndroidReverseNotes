package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.protocal.protobuf.agf;
import com.tencent.mm.protocal.protobuf.agg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac;

public final class y extends m implements k {
    private final b ehh;
    private f ehi;

    public y() {
        AppMethodBeat.i(87889);
        a aVar = new a();
        aVar.fsJ = new agf();
        aVar.fsK = new agg();
        aVar.uri = "/cgi-bin/micromsg-bin/getcardcount";
        this.ehh = aVar.acD();
        AppMethodBeat.o(87889);
    }

    public final int getType() {
        return 663;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(87890);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(87890);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(87891);
        ab.i("MicroMsg.NetSceneGetCardCount", "onGYNetEnd, errType = " + i2 + " errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            agg agg = (agg) this.ehh.fsH.fsP;
            ab.i("MicroMsg.NetSceneGetCardCount", "has_card_item:" + agg.wnc + " has_share_card:" + agg.wnd);
            if (agg.wnc > 0) {
                l.beB();
                if (TextUtils.isEmpty((String) g.RP().Ry().get(ac.a.USERINFO_CARD_LAYOUT_BUF_DATA_STRING_SYNC, null))) {
                    am.baV();
                    com.tencent.mm.plugin.card.b.b.sO(1);
                }
            }
            if (agg.wnd > 0) {
                l.beD();
                Long l = (Long) g.RP().Ry().get(ac.a.USERINFO_CARD_REQUENCE_LONG_SYNC, Long.valueOf(0));
                if (l != null && l.longValue() == 0) {
                    am.bbd().bbr();
                }
            }
        }
        g.RP().Ry().set(282882, Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(87891);
    }
}
