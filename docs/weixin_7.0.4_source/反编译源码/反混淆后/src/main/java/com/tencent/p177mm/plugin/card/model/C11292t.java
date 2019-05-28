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
import com.tencent.p177mm.plugin.card.p931d.C27575f;
import com.tencent.p177mm.plugin.card.p931d.C38736l;
import com.tencent.p177mm.protocal.protobuf.C15346ia;
import com.tencent.p177mm.protocal.protobuf.C30191ib;
import com.tencent.p177mm.protocal.protobuf.C44152oj;
import com.tencent.p177mm.protocal.protobuf.cdc;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.card.model.t */
public final class C11292t extends C1207m implements C1918k {
    public String cardId;
    private final C7472b ehh;
    private C1202f ehi;
    public LinkedList<CardInfo> kdZ;

    public C11292t(LinkedList<C44152oj> linkedList, cdc cdc, int i) {
        this(linkedList, cdc, i, "");
    }

    public C11292t(LinkedList<C44152oj> linkedList, cdc cdc, int i, String str) {
        AppMethodBeat.m2504i(87873);
        this.kdZ = new LinkedList();
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C15346ia();
        c1196a.fsK = new C30191ib();
        c1196a.uri = "/cgi-bin/micromsg-bin/batchgetcarditembytpinfo";
        c1196a.fsI = 699;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        C15346ia c15346ia = (C15346ia) this.ehh.fsG.fsP;
        c15346ia.fjr = linkedList;
        c15346ia.vBy = cdc;
        c15346ia.cME = i;
        this.cardId = str;
        AppMethodBeat.m2505o(87873);
    }

    public final int getType() {
        return 699;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(87874);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(87874);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(87875);
        C4990ab.m7417i("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            String str2 = ((C30191ib) this.ehh.fsH.fsP).kdS;
            if (TextUtils.isEmpty(str2)) {
                C4990ab.m7412e("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd fail, resp json_ret is null");
                this.ehi.onSceneEnd(4, -1, null, this);
                AppMethodBeat.m2505o(87875);
                return;
            }
            ArrayList Hg = C27575f.m43793Hg(str2);
            if (Hg != null) {
                C38736l.beB();
                this.kdZ.addAll(Hg);
            }
            this.ehi.onSceneEnd(0, 0, str, this);
            AppMethodBeat.m2505o(87875);
            return;
        }
        C4990ab.m7413e("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd, batch get fail, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(87875);
    }
}
