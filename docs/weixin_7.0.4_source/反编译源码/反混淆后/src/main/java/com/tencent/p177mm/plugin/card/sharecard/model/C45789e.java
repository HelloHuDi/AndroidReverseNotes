package com.tencent.p177mm.plugin.card.sharecard.model;

import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.hardcoder.C1625i;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.card.p931d.C27575f;
import com.tencent.p177mm.plugin.card.p931d.C38736l;
import com.tencent.p177mm.plugin.card.sharecard.p932a.C42856b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.aoe;
import com.tencent.p177mm.protocal.protobuf.aof;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.view.C31128d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.card.sharecard.model.e */
public final class C45789e extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;
    public LinkedList<String> kdX;
    public LinkedList<String> kdY = new LinkedList();

    public C45789e(LinkedList<String> linkedList) {
        AppMethodBeat.m2504i(88027);
        this.kdX = linkedList;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new aoe();
        c1196a.fsK = new aof();
        c1196a.uri = "/cgi-bin/micromsg-bin/getsharecardlist";
        c1196a.fsI = C1625i.SCENE_BIZ_SCROLL;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        ((aoe) this.ehh.fsG.fsP).vKf = linkedList;
        C4990ab.m7416i("MicroMsg.NetSceneGetShareCardList", "card_ids length is " + linkedList.size());
        AppMethodBeat.m2505o(88027);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(88028);
        C4990ab.m7417i("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", Integer.valueOf(C1625i.SCENE_BIZ_SCROLL), Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            aof aof = (aof) this.ehh.fsH.fsP;
            C4990ab.m7418v("MicroMsg.NetSceneGetShareCardList", "json:" + aof.kdS);
            String str2 = aof.kdS;
            if (TextUtils.isEmpty(str2)) {
                C4990ab.m7412e("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd fail, resp json_ret is null");
                this.ehi.onSceneEnd(4, -1, null, this);
                AppMethodBeat.m2505o(88028);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList Hf = C27575f.m43792Hf(str2);
            if (Hf != null) {
                if (this.kdX != null) {
                    this.kdY.addAll(this.kdX);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                long iV = C1720g.m3536RP().eJN.mo15639iV(Thread.currentThread().getId());
                int i4 = 0;
                Iterator it = Hf.iterator();
                int i5 = 0;
                while (it.hasNext()) {
                    ShareCardInfo shareCardInfo = (ShareCardInfo) it.next();
                    i4++;
                    if (C38736l.m65713a(shareCardInfo)) {
                        C4990ab.m7416i("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd update share card count");
                        C42856b.m76082ad(C4996ah.getContext(), shareCardInfo.field_card_tp_id);
                        if (shareCardInfo.field_status != 0) {
                            C42856b.m76083dn(shareCardInfo.field_card_id, shareCardInfo.field_card_tp_id);
                        }
                    } else {
                        i5++;
                        this.kdY.remove(shareCardInfo.field_card_id);
                    }
                }
                C1720g.m3536RP().eJN.mo15640mB(iV);
                C4990ab.m7417i("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd do transaction use time %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                C4990ab.m7413e("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd, deal CardObject %d fail of %d", Integer.valueOf(i5), Integer.valueOf(i4));
                C38736l.beD();
                if (Hf.size() > 0) {
                    int currentTimeMillis3 = (int) (System.currentTimeMillis() - currentTimeMillis);
                    ArrayList arrayList = new ArrayList();
                    IDKey iDKey = new IDKey();
                    iDKey.SetID(C31128d.MIC_PTU_TRANS_KONGCHENG);
                    iDKey.SetKey(17);
                    iDKey.SetValue(1);
                    IDKey iDKey2 = new IDKey();
                    iDKey2.SetID(C31128d.MIC_PTU_TRANS_KONGCHENG);
                    iDKey2.SetKey(18);
                    iDKey2.SetValue((long) currentTimeMillis3);
                    IDKey iDKey3 = new IDKey();
                    iDKey3.SetID(C31128d.MIC_PTU_TRANS_KONGCHENG);
                    iDKey3.SetKey(19);
                    iDKey3.SetValue((long) Hf.size());
                    IDKey iDKey4 = new IDKey();
                    iDKey4.SetID(C31128d.MIC_PTU_TRANS_KONGCHENG);
                    iDKey4.SetKey(21);
                    iDKey4.SetValue((long) (currentTimeMillis3 / Hf.size()));
                    arrayList.add(iDKey);
                    arrayList.add(iDKey2);
                    arrayList.add(iDKey3);
                    arrayList.add(iDKey4);
                    C7060h.pYm.mo8379b(arrayList, true);
                }
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(88028);
            return;
        }
        C4990ab.m7413e("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd, batch get fail, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(88028);
    }

    public final int getType() {
        return C1625i.SCENE_BIZ_SCROLL;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(88029);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(88029);
        return a;
    }
}
