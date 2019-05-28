package com.tencent.p177mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C35941nx;
import com.tencent.p177mm.protocal.protobuf.C40502ak;
import com.tencent.p177mm.protocal.protobuf.C46522al;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.card.model.p */
public final class C38749p extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;
    public String kdS;
    public int kdT;
    public String kdU;

    public C38749p(LinkedList<C35941nx> linkedList, int i, String str, String str2, int i2) {
        AppMethodBeat.m2504i(87860);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C40502ak();
        c1196a.fsK = new C46522al();
        c1196a.uri = "/cgi-bin/micromsg-bin/acceptcardlistfromapp";
        this.ehh = c1196a.acD();
        C40502ak c40502ak = (C40502ak) this.ehh.fsG.fsP;
        c40502ak.vBz = linkedList;
        c40502ak.cME = i;
        c40502ak.vBv = str;
        c40502ak.vBu = str2;
        c40502ak.vBw = i2;
        AppMethodBeat.m2505o(87860);
    }

    public final int getType() {
        return 687;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(87861);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(87861);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(87862);
        C4990ab.m7416i("MicroMsg.NetSceneGetCardListFromApp", "onGYNetEnd, errType = " + i2 + " errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            C46522al c46522al = (C46522al) this.ehh.fsH.fsP;
            this.kdS = c46522al.kdS;
            this.kdT = c46522al.kdT;
            this.kdU = c46522al.kdU;
            C4990ab.m7412e("MicroMsg.NetSceneGetCardListFromApp", "onGYNetEnd, ret_code = " + this.kdT + " ret_msg = " + this.kdU);
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(87862);
    }
}
