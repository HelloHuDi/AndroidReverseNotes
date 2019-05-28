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
import com.tencent.mm.protocal.protobuf.hm;
import com.tencent.mm.protocal.protobuf.hn;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedList;

public final class r extends m implements k {
    private final b ehh;
    private f ehi;
    private int kdW = 0;

    public r(LinkedList<String> linkedList) {
        AppMethodBeat.i(87866);
        a aVar = new a();
        aVar.fsJ = new hm();
        aVar.fsK = new hn();
        aVar.uri = "/cgi-bin/micromsg-bin/batchdelcarditem";
        aVar.fsI = 560;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        ((hm) this.ehh.fsG.fsP).vKf = linkedList;
        AppMethodBeat.o(87866);
    }

    public final int getType() {
        return 560;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(87867);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(87867);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(87868);
        ab.i("MicroMsg.NetSceneBatchDelCardItem", "onGYNetEnd, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            LinkedList linkedList = ((hn) this.ehh.fsH.fsP).vKg;
            String str2 = "MicroMsg.NetSceneBatchDelCardItem";
            String str3 = "onGYNetEnd, resp list count = %d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(linkedList == null ? 0 : linkedList.size());
            ab.i(str2, str3, objArr);
            if (linkedList == null || linkedList.size() == 0) {
                ab.e("MicroMsg.NetSceneBatchDelCardItem", "onGYNetEnd fail, resp list is null");
            } else {
                this.kdW = 0;
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    boolean z;
                    String str4 = (String) it.next();
                    if (TextUtils.isEmpty(str4)) {
                        ab.e("MicroMsg.NetSceneBatchDelCardItem", "processDelCardItem fail, id is null");
                        z = false;
                    } else {
                        CardInfo cardInfo = new CardInfo();
                        cardInfo.field_card_id = str4;
                        z = am.baW().a((c) cardInfo, new String[0]);
                        ab.i("MicroMsg.NetSceneBatchDelCardItem", "processDelCardItem, delRet = %b", Boolean.valueOf(z));
                    }
                    if (!z) {
                        this.kdW++;
                    }
                }
                ab.d("MicroMsg.NetSceneBatchDelCardItem", "onGYNetEnd, %d fail items", Integer.valueOf(this.kdW));
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(87868);
    }
}
