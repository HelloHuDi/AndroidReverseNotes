package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
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
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ic;
import com.tencent.mm.protocal.protobuf.id;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.view.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class s extends m implements k {
    private final b ehh;
    private f ehi;
    private LinkedList<ak> kdX;
    public LinkedList<ak> kdY = new LinkedList();

    public s(LinkedList<ak> linkedList) {
        AppMethodBeat.i(87869);
        this.kdX = linkedList;
        a aVar = new a();
        aVar.fsJ = new ic();
        aVar.fsK = new id();
        aVar.uri = "/cgi-bin/micromsg-bin/batchgetcarditem";
        aVar.fsI = 559;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        ((ic) this.ehh.fsG.fsP).vKf = J(linkedList);
        AppMethodBeat.o(87869);
    }

    public final int getType() {
        return 559;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(87870);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(87870);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(87871);
        ab.d("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            String str2 = ((id) this.ehh.fsH.fsP).kdS;
            if (TextUtils.isEmpty(str2)) {
                ab.e("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd fail, resp json_ret is null");
                this.ehi.onSceneEnd(4, -1, null, this);
                AppMethodBeat.o(87871);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList Hg = com.tencent.mm.plugin.card.d.f.Hg(str2);
            if (Hg != null) {
                if (this.kdX != null) {
                    this.kdY.addAll(this.kdX);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                long iV = g.RP().eJN.iV(Thread.currentThread().getId());
                int i4 = 0;
                Iterator it = Hg.iterator();
                int i5 = 0;
                while (it.hasNext()) {
                    CardInfo cardInfo = (CardInfo) it.next();
                    i5++;
                    if (!l.b(cardInfo)) {
                        i4++;
                        LinkedList linkedList = this.kdY;
                        if (cardInfo != null) {
                            ak akVar = new ak();
                            akVar.field_cardUserId = cardInfo.field_card_id;
                            linkedList.remove(akVar);
                        }
                    }
                    i4 = i4;
                }
                g.RP().eJN.mB(iV);
                ab.i("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd do transaction use time %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                ab.e("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd, deal CardObject %d fail of %d", Integer.valueOf(i4), Integer.valueOf(i5));
                l.beB();
                if (Hg.size() > 0) {
                    int currentTimeMillis3 = (int) (System.currentTimeMillis() - currentTimeMillis);
                    ArrayList arrayList = new ArrayList();
                    IDKey iDKey = new IDKey();
                    iDKey.SetID(d.MIC_PTU_TRANS_KONGCHENG);
                    iDKey.SetKey(43);
                    iDKey.SetValue(1);
                    IDKey iDKey2 = new IDKey();
                    iDKey2.SetID(d.MIC_PTU_TRANS_KONGCHENG);
                    iDKey2.SetKey(44);
                    iDKey2.SetValue((long) currentTimeMillis3);
                    IDKey iDKey3 = new IDKey();
                    iDKey3.SetID(d.MIC_PTU_TRANS_KONGCHENG);
                    iDKey3.SetKey(45);
                    iDKey3.SetValue((long) Hg.size());
                    IDKey iDKey4 = new IDKey();
                    iDKey4.SetID(d.MIC_PTU_TRANS_KONGCHENG);
                    iDKey4.SetKey(47);
                    iDKey4.SetValue((long) (currentTimeMillis3 / Hg.size()));
                    arrayList.add(iDKey);
                    arrayList.add(iDKey2);
                    arrayList.add(iDKey3);
                    arrayList.add(iDKey4);
                    h.pYm.b(arrayList, true);
                }
            }
            this.ehi.onSceneEnd(0, 0, str, this);
            AppMethodBeat.o(87871);
            return;
        }
        ab.e("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd, batch get fail, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(87871);
    }

    private static LinkedList<String> J(LinkedList<ak> linkedList) {
        AppMethodBeat.i(87872);
        LinkedList<String> linkedList2 = new LinkedList();
        if (linkedList == null || linkedList.size() == 0) {
            AppMethodBeat.o(87872);
            return linkedList2;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ak akVar = (ak) it.next();
            if (akVar != null) {
                linkedList2.add(akVar.field_cardUserId);
            }
        }
        AppMethodBeat.o(87872);
        return linkedList2;
    }
}
