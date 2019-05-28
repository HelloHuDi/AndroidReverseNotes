package com.tencent.p177mm.openim.p716b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.alk;
import com.tencent.p177mm.protocal.protobuf.all;
import com.tencent.p177mm.protocal.protobuf.bgf;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.openim.b.h */
public final class C32877h extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;
    private String geZ;
    private String gfa;
    public bgf gfb;
    private int ret;

    public C32877h(String str, String str2, String str3) {
        AppMethodBeat.m2504i(78855);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new alk();
        c1196a.fsK = new all();
        c1196a.uri = "/cgi-bin/micromsg-bin/getopenimcontact";
        this.ehh = c1196a.acD();
        this.geZ = str;
        this.gfa = C5046bo.m7532bc(str2, "");
        C4990ab.m7417i("MicroMsg.Openim.NetSceneGetOpenIMContact", "get openim username: %s, roomname: %s, ticket:%s", str, this.gfa, str3);
        alk alk = (alk) this.ehh.fsG.fsP;
        alk.geZ = str;
        alk.geY = this.gfa;
        alk.cxb = str3;
        AppMethodBeat.m2505o(78855);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(78856);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(78856);
        return a;
    }

    public final int getType() {
        return 881;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(78857);
        C4990ab.m7417i("MicroMsg.Openim.NetSceneGetOpenIMContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, tp_username = %s", Integer.valueOf(i2), Integer.valueOf(i3), str, this.geZ);
        if (i2 == 0 && i3 == 0) {
            all all = (all) this.ehh.fsH.fsP;
            this.gfb = all.wqL;
            this.ret = C37976s.m64266a(all);
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(78857);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(78857);
    }
}
