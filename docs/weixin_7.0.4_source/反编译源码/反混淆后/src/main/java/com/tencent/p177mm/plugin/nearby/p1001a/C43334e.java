package com.tencent.p177mm.plugin.nearby.p1001a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p182ah.C17880h;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.ayb;
import com.tencent.p177mm.protocal.protobuf.ayc;
import com.tencent.p177mm.protocal.protobuf.ayd;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.ttpic.util.FaceOffUtil;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.nearby.a.e */
public final class C43334e extends C1207m implements C1918k {
    final C7472b ehh;
    private C1202f ehi;

    public C43334e(String str) {
        AppMethodBeat.m2504i(55371);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new ayc();
        c1196a.fsK = new ayd();
        c1196a.uri = "/cgi-bin/micromsg-bin/getroommember";
        c1196a.fsL = FaceOffUtil.NO_HOLE_TRIANGLE_COUNT_FACE_AVERAGE;
        c1196a.fsM = 1000000184;
        this.ehh = c1196a.acD();
        ((ayc) this.ehh.fsG.fsP).fLc = str;
        C4990ab.m7410d("MicroMsg.NetSceneLbsRoomGetMember", "Req: roomName:".concat(String.valueOf(str)));
        AppMethodBeat.m2505o(55371);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(55372);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(55372);
        return a;
    }

    public final int getType() {
        return 377;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(55373);
        C4990ab.m7410d("MicroMsg.NetSceneLbsRoomGetMember", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        ayd ayd = (ayd) this.ehh.fsH.fsP;
        if (i2 != 0) {
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(55373);
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 < ayd.vEh.size()) {
                C17880h c17880h = new C17880h();
                c17880h.username = ((ayb) ayd.vEh.get(i5)).jBB;
                c17880h.frW = ((ayb) ayd.vEh.get(i5)).vXm;
                c17880h.frV = ((ayb) ayd.vEh.get(i5)).vXn;
                c17880h.mo33385cB(true);
                arrayList.add(c17880h);
                i4 = i5 + 1;
            } else {
                C17884o.act().mo33390aa(arrayList);
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.m2505o(55373);
                return;
            }
        }
    }
}
