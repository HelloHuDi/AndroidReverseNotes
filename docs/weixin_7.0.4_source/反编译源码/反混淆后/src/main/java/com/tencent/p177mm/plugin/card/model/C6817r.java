package com.tencent.p177mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C15345hm;
import com.tencent.p177mm.protocal.protobuf.C30189hn;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.card.model.r */
public final class C6817r extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;
    private int kdW = 0;

    public C6817r(LinkedList<String> linkedList) {
        AppMethodBeat.m2504i(87866);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C15345hm();
        c1196a.fsK = new C30189hn();
        c1196a.uri = "/cgi-bin/micromsg-bin/batchdelcarditem";
        c1196a.fsI = 560;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        ((C15345hm) this.ehh.fsG.fsP).vKf = linkedList;
        AppMethodBeat.m2505o(87866);
    }

    public final int getType() {
        return 560;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(87867);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(87867);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(87868);
        C4990ab.m7417i("MicroMsg.NetSceneBatchDelCardItem", "onGYNetEnd, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            LinkedList linkedList = ((C30189hn) this.ehh.fsH.fsP).vKg;
            String str2 = "MicroMsg.NetSceneBatchDelCardItem";
            String str3 = "onGYNetEnd, resp list count = %d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(linkedList == null ? 0 : linkedList.size());
            C4990ab.m7417i(str2, str3, objArr);
            if (linkedList == null || linkedList.size() == 0) {
                C4990ab.m7412e("MicroMsg.NetSceneBatchDelCardItem", "onGYNetEnd fail, resp list is null");
            } else {
                this.kdW = 0;
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    boolean z;
                    String str4 = (String) it.next();
                    if (TextUtils.isEmpty(str4)) {
                        C4990ab.m7412e("MicroMsg.NetSceneBatchDelCardItem", "processDelCardItem fail, id is null");
                        z = false;
                    } else {
                        CardInfo cardInfo = new CardInfo();
                        cardInfo.field_card_id = str4;
                        z = C42852am.baW().mo16760a((C4925c) cardInfo, new String[0]);
                        C4990ab.m7417i("MicroMsg.NetSceneBatchDelCardItem", "processDelCardItem, delRet = %b", Boolean.valueOf(z));
                    }
                    if (!z) {
                        this.kdW++;
                    }
                }
                C4990ab.m7411d("MicroMsg.NetSceneBatchDelCardItem", "onGYNetEnd, %d fail items", Integer.valueOf(this.kdW));
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(87868);
    }
}
