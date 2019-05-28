package com.tencent.p177mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.C40528ic;
import com.tencent.p177mm.protocal.protobuf.C46550id;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.view.C31128d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.card.model.s */
public final class C11291s extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;
    private LinkedList<C20140ak> kdX;
    public LinkedList<C20140ak> kdY = new LinkedList();

    public C11291s(LinkedList<C20140ak> linkedList) {
        AppMethodBeat.m2504i(87869);
        this.kdX = linkedList;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C40528ic();
        c1196a.fsK = new C46550id();
        c1196a.uri = "/cgi-bin/micromsg-bin/batchgetcarditem";
        c1196a.fsI = 559;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        ((C40528ic) this.ehh.fsG.fsP).vKf = C11291s.m19006J(linkedList);
        AppMethodBeat.m2505o(87869);
    }

    public final int getType() {
        return 559;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(87870);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(87870);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(87871);
        C4990ab.m7411d("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            String str2 = ((C46550id) this.ehh.fsH.fsP).kdS;
            if (TextUtils.isEmpty(str2)) {
                C4990ab.m7412e("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd fail, resp json_ret is null");
                this.ehi.onSceneEnd(4, -1, null, this);
                AppMethodBeat.m2505o(87871);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList Hg = C27575f.m43793Hg(str2);
            if (Hg != null) {
                if (this.kdX != null) {
                    this.kdY.addAll(this.kdX);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                long iV = C1720g.m3536RP().eJN.mo15639iV(Thread.currentThread().getId());
                int i4 = 0;
                Iterator it = Hg.iterator();
                int i5 = 0;
                while (it.hasNext()) {
                    CardInfo cardInfo = (CardInfo) it.next();
                    i5++;
                    if (!C38736l.m65719b(cardInfo)) {
                        i4++;
                        LinkedList linkedList = this.kdY;
                        if (cardInfo != null) {
                            C20140ak c20140ak = new C20140ak();
                            c20140ak.field_cardUserId = cardInfo.field_card_id;
                            linkedList.remove(c20140ak);
                        }
                    }
                    i4 = i4;
                }
                C1720g.m3536RP().eJN.mo15640mB(iV);
                C4990ab.m7417i("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd do transaction use time %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                C4990ab.m7413e("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd, deal CardObject %d fail of %d", Integer.valueOf(i4), Integer.valueOf(i5));
                C38736l.beB();
                if (Hg.size() > 0) {
                    int currentTimeMillis3 = (int) (System.currentTimeMillis() - currentTimeMillis);
                    ArrayList arrayList = new ArrayList();
                    IDKey iDKey = new IDKey();
                    iDKey.SetID(C31128d.MIC_PTU_TRANS_KONGCHENG);
                    iDKey.SetKey(43);
                    iDKey.SetValue(1);
                    IDKey iDKey2 = new IDKey();
                    iDKey2.SetID(C31128d.MIC_PTU_TRANS_KONGCHENG);
                    iDKey2.SetKey(44);
                    iDKey2.SetValue((long) currentTimeMillis3);
                    IDKey iDKey3 = new IDKey();
                    iDKey3.SetID(C31128d.MIC_PTU_TRANS_KONGCHENG);
                    iDKey3.SetKey(45);
                    iDKey3.SetValue((long) Hg.size());
                    IDKey iDKey4 = new IDKey();
                    iDKey4.SetID(C31128d.MIC_PTU_TRANS_KONGCHENG);
                    iDKey4.SetKey(47);
                    iDKey4.SetValue((long) (currentTimeMillis3 / Hg.size()));
                    arrayList.add(iDKey);
                    arrayList.add(iDKey2);
                    arrayList.add(iDKey3);
                    arrayList.add(iDKey4);
                    C7060h.pYm.mo8379b(arrayList, true);
                }
            }
            this.ehi.onSceneEnd(0, 0, str, this);
            AppMethodBeat.m2505o(87871);
            return;
        }
        C4990ab.m7413e("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd, batch get fail, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(87871);
    }

    /* renamed from: J */
    private static LinkedList<String> m19006J(LinkedList<C20140ak> linkedList) {
        AppMethodBeat.m2504i(87872);
        LinkedList<String> linkedList2 = new LinkedList();
        if (linkedList == null || linkedList.size() == 0) {
            AppMethodBeat.m2505o(87872);
            return linkedList2;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            C20140ak c20140ak = (C20140ak) it.next();
            if (c20140ak != null) {
                linkedList2.add(c20140ak.field_cardUserId);
            }
        }
        AppMethodBeat.m2505o(87872);
        return linkedList2;
    }
}
