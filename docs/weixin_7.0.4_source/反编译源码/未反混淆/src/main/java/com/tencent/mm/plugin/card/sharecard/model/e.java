package com.tencent.mm.plugin.card.sharecard.model;

import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.hardcoder.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.aoe;
import com.tencent.mm.protocal.protobuf.aof;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.view.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class e extends m implements k {
    private final b ehh;
    private f ehi;
    public LinkedList<String> kdX;
    public LinkedList<String> kdY = new LinkedList();

    public e(LinkedList<String> linkedList) {
        AppMethodBeat.i(88027);
        this.kdX = linkedList;
        a aVar = new a();
        aVar.fsJ = new aoe();
        aVar.fsK = new aof();
        aVar.uri = "/cgi-bin/micromsg-bin/getsharecardlist";
        aVar.fsI = i.SCENE_BIZ_SCROLL;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        ((aoe) this.ehh.fsG.fsP).vKf = linkedList;
        ab.i("MicroMsg.NetSceneGetShareCardList", "card_ids length is " + linkedList.size());
        AppMethodBeat.o(88027);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(88028);
        ab.i("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", Integer.valueOf(i.SCENE_BIZ_SCROLL), Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            aof aof = (aof) this.ehh.fsH.fsP;
            ab.v("MicroMsg.NetSceneGetShareCardList", "json:" + aof.kdS);
            String str2 = aof.kdS;
            if (TextUtils.isEmpty(str2)) {
                ab.e("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd fail, resp json_ret is null");
                this.ehi.onSceneEnd(4, -1, null, this);
                AppMethodBeat.o(88028);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList Hf = com.tencent.mm.plugin.card.d.f.Hf(str2);
            if (Hf != null) {
                if (this.kdX != null) {
                    this.kdY.addAll(this.kdX);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                long iV = g.RP().eJN.iV(Thread.currentThread().getId());
                int i4 = 0;
                Iterator it = Hf.iterator();
                int i5 = 0;
                while (it.hasNext()) {
                    ShareCardInfo shareCardInfo = (ShareCardInfo) it.next();
                    i4++;
                    if (l.a(shareCardInfo)) {
                        ab.i("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd update share card count");
                        com.tencent.mm.plugin.card.sharecard.a.b.ad(ah.getContext(), shareCardInfo.field_card_tp_id);
                        if (shareCardInfo.field_status != 0) {
                            com.tencent.mm.plugin.card.sharecard.a.b.dn(shareCardInfo.field_card_id, shareCardInfo.field_card_tp_id);
                        }
                    } else {
                        i5++;
                        this.kdY.remove(shareCardInfo.field_card_id);
                    }
                }
                g.RP().eJN.mB(iV);
                ab.i("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd do transaction use time %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                ab.e("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd, deal CardObject %d fail of %d", Integer.valueOf(i5), Integer.valueOf(i4));
                l.beD();
                if (Hf.size() > 0) {
                    int currentTimeMillis3 = (int) (System.currentTimeMillis() - currentTimeMillis);
                    ArrayList arrayList = new ArrayList();
                    IDKey iDKey = new IDKey();
                    iDKey.SetID(d.MIC_PTU_TRANS_KONGCHENG);
                    iDKey.SetKey(17);
                    iDKey.SetValue(1);
                    IDKey iDKey2 = new IDKey();
                    iDKey2.SetID(d.MIC_PTU_TRANS_KONGCHENG);
                    iDKey2.SetKey(18);
                    iDKey2.SetValue((long) currentTimeMillis3);
                    IDKey iDKey3 = new IDKey();
                    iDKey3.SetID(d.MIC_PTU_TRANS_KONGCHENG);
                    iDKey3.SetKey(19);
                    iDKey3.SetValue((long) Hf.size());
                    IDKey iDKey4 = new IDKey();
                    iDKey4.SetID(d.MIC_PTU_TRANS_KONGCHENG);
                    iDKey4.SetKey(21);
                    iDKey4.SetValue((long) (currentTimeMillis3 / Hf.size()));
                    arrayList.add(iDKey);
                    arrayList.add(iDKey2);
                    arrayList.add(iDKey3);
                    arrayList.add(iDKey4);
                    h.pYm.b(arrayList, true);
                }
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(88028);
            return;
        }
        ab.e("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd, batch get fail, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(88028);
    }

    public final int getType() {
        return i.SCENE_BIZ_SCROLL;
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(88029);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(88029);
        return a;
    }
}
