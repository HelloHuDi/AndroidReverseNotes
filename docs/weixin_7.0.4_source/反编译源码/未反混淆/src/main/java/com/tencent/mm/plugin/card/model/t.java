package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.protocal.protobuf.cdc;
import com.tencent.mm.protocal.protobuf.ia;
import com.tencent.mm.protocal.protobuf.ib;
import com.tencent.mm.protocal.protobuf.oj;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.LinkedList;

public final class t extends m implements k {
    public String cardId;
    private final b ehh;
    private f ehi;
    public LinkedList<CardInfo> kdZ;

    public t(LinkedList<oj> linkedList, cdc cdc, int i) {
        this(linkedList, cdc, i, "");
    }

    public t(LinkedList<oj> linkedList, cdc cdc, int i, String str) {
        AppMethodBeat.i(87873);
        this.kdZ = new LinkedList();
        a aVar = new a();
        aVar.fsJ = new ia();
        aVar.fsK = new ib();
        aVar.uri = "/cgi-bin/micromsg-bin/batchgetcarditembytpinfo";
        aVar.fsI = 699;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        ia iaVar = (ia) this.ehh.fsG.fsP;
        iaVar.fjr = linkedList;
        iaVar.vBy = cdc;
        iaVar.cME = i;
        this.cardId = str;
        AppMethodBeat.o(87873);
    }

    public final int getType() {
        return 699;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(87874);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(87874);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(87875);
        ab.i("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            String str2 = ((ib) this.ehh.fsH.fsP).kdS;
            if (TextUtils.isEmpty(str2)) {
                ab.e("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd fail, resp json_ret is null");
                this.ehi.onSceneEnd(4, -1, null, this);
                AppMethodBeat.o(87875);
                return;
            }
            ArrayList Hg = com.tencent.mm.plugin.card.d.f.Hg(str2);
            if (Hg != null) {
                l.beB();
                this.kdZ.addAll(Hg);
            }
            this.ehi.onSceneEnd(0, 0, str, this);
            AppMethodBeat.o(87875);
            return;
        }
        ab.e("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd, batch get fail, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(87875);
    }
}
