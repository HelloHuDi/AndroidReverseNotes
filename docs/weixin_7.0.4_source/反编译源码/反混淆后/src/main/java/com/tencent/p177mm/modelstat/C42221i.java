package com.tencent.p177mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.protocal.protobuf.C23374bj;
import com.tencent.p177mm.protocal.protobuf.C30170bk;
import com.tencent.p177mm.protocal.protobuf.C44105bp;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.modelstat.i */
public final class C42221i extends C1207m implements C1918k {
    private C1202f eIc;
    private final C7472b ehh;

    public C42221i(int i, String str, int i2) {
        AppMethodBeat.m2504i(35583);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C23374bj();
        c1196a.fsK = new C30170bk();
        c1196a.uri = "/cgi-bin/mmoc-bin/ad/addatareport";
        this.ehh = c1196a.acD();
        C23374bj c23374bj = (C23374bj) this.ehh.fsG.fsP;
        C44105bp c44105bp = new C44105bp();
        c44105bp.vDS = i;
        c44105bp.vDT = new C1332b(str.getBytes());
        c44105bp.vDU = (long) i2;
        c23374bj.vDC.add(c44105bp);
        C4990ab.m7417i("MicroMsg.NetSceneAdDataReport", "init logId:%d, logStr:%s", Integer.valueOf(i), str);
        AppMethodBeat.m2505o(35583);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(35584);
        C30170bk c30170bk = (C30170bk) this.ehh.fsH.fsP;
        C4990ab.m7417i("MicroMsg.NetSceneAdDataReport", "onGYNetEnd, errType = %d, errCode = %d, ret=%d, msg=%s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(c30170bk.ret), c30170bk.bzH);
        this.eIc.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(35584);
    }

    public final int getType() {
        return 1295;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(35585);
        this.eIc = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(35585);
        return a;
    }
}
