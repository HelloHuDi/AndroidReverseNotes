package com.tencent.p177mm.plugin.wallet_ecard.p1315a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bng;
import com.tencent.p177mm.protocal.protobuf.bnh;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p649c.C44428p;

/* renamed from: com.tencent.mm.plugin.wallet_ecard.a.g */
public final class C46375g extends C44428p {
    private C7472b ehh;
    private C1202f ehi;
    public bnh tQo;

    public C46375g() {
        AppMethodBeat.m2504i(48068);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bng();
        c1196a.fsK = new bnh();
        c1196a.uri = "/cgi-bin/mmpay-bin/qrycancelecarddesc";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        ((bng) this.ehh.fsG.fsP).wQe = 1;
        AppMethodBeat.m2505o(48068);
    }

    /* renamed from: b */
    public final void mo6948b(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(48069);
        C4990ab.m7417i("MicroMsg.NetSceneQryECardLogout", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.tQo = (bnh) ((C7472b) c1929q).fsH.fsP;
        C4990ab.m7417i("MicroMsg.NetSceneQryECardLogout", "retcode: %s, retmsg: %s", Integer.valueOf(this.tQo.kdT), this.tQo.kdU);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.m2505o(48069);
    }

    /* renamed from: f */
    public final void mo6949f(C1929q c1929q) {
        bnh bnh = (bnh) ((C7472b) c1929q).fsH.fsP;
        this.AfC = bnh.kdT;
        this.AfD = bnh.kdU;
    }

    public final int getType() {
        return 2931;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(48070);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(48070);
        return a;
    }
}
