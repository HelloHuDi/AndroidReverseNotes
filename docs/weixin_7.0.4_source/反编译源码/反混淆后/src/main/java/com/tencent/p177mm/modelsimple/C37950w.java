package com.tencent.p177mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C44699i;
import com.tencent.p177mm.protocal.protobuf.bre;
import com.tencent.p177mm.protocal.protobuf.bxz;
import com.tencent.p177mm.protocal.protobuf.bya;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.modelsimple.w */
public final class C37950w extends C1207m implements C1918k {
    private C1202f ehi;
    public final C7472b fAT;

    public C37950w(int i, bre bre) {
        AppMethodBeat.m2504i(16603);
        C4990ab.m7417i("MicroMsg.NetSceneSetMsgRemind", "[NetSceneSetMsgRemind] opType:%s RemindId:%s time:%s Type:%s SubType:%s", Integer.valueOf(i), bre.wTy, Integer.valueOf(bre.lvf), Integer.valueOf(bre.jCt), Integer.valueOf(bre.wOI));
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bxz();
        c1196a.fsK = new bya();
        c1196a.uri = "/cgi-bin/micromsg-bin/setmsgremind";
        c1196a.fsI = C44699i.CTRL_INDEX;
        this.fAT = c1196a.acD();
        bxz bxz = (bxz) this.fAT.fsG.fsP;
        if (i == 0) {
            i = 1;
        }
        bxz.nbk = i;
        bxz.wXC = bre;
        AppMethodBeat.m2505o(16603);
    }

    public final int getType() {
        return C44699i.CTRL_INDEX;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(16604);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.fAT, this);
        AppMethodBeat.m2505o(16604);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(16605);
        if (i2 == 0 && i3 == 0) {
            C4990ab.m7417i("MicroMsg.NetSceneSetMsgRemind", "[onGYNetEnd] RemindId:%s", ((bya) this.fAT.fsH.fsP).wTy);
        } else {
            C4990ab.m7413e("MicroMsg.NetSceneSetMsgRemind", "[onGYNetEnd] errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(16605);
    }
}
