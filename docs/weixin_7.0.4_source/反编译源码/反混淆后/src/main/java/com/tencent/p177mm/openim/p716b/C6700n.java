package com.tencent.p177mm.openim.p716b;

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
import com.tencent.p177mm.plugin.appbrand.jsapi.p299b.C33251a;
import com.tencent.p177mm.protocal.protobuf.bvk;
import com.tencent.p177mm.protocal.protobuf.bvl;
import com.tencent.p177mm.protocal.protobuf.bvm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.openim.b.n */
public final class C6700n extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;
    private String gff;
    public bvk gfg;
    public String gfh;

    public C6700n(String str) {
        AppMethodBeat.m2504i(78871);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bvl();
        c1196a.fsK = new bvm();
        c1196a.uri = "/cgi-bin/micromsg-bin/searchopenimcontact";
        c1196a.fsI = C33251a.CTRL_INDEX;
        this.ehh = c1196a.acD();
        C4990ab.m7417i("MicroMsg.NetSceneSearchOpenIMContact", "search tpQrcode [%s]", this.gff);
        bvl bvl = (bvl) this.ehh.fsG.fsP;
        bvl.wWz = "";
        bvl.cFl = str;
        bvl.wWA = 1;
        AppMethodBeat.m2505o(78871);
    }

    public C6700n(String str, byte b) {
        AppMethodBeat.m2504i(78872);
        this.gff = str;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bvl();
        c1196a.fsK = new bvm();
        c1196a.uri = "/cgi-bin/micromsg-bin/searchopenimcontact";
        c1196a.fsI = C33251a.CTRL_INDEX;
        this.ehh = c1196a.acD();
        C4990ab.m7417i("MicroMsg.NetSceneSearchOpenIMContact", "search tpQrcode [%s]", str);
        ((bvl) this.ehh.fsG.fsP).wWz = str;
        AppMethodBeat.m2505o(78872);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(78873);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(78873);
        return a;
    }

    public final int getType() {
        return C33251a.CTRL_INDEX;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(78874);
        C4990ab.m7417i("MicroMsg.NetSceneSearchOpenIMContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.gfg = ((bvm) this.ehh.fsH.fsP).wWB;
            C17880h c17880h = new C17880h();
            c17880h.username = this.gfg.jBB;
            c17880h.frW = this.gfg.vXm;
            c17880h.frV = this.gfg.vXn;
            c17880h.bJt = -1;
            C4990ab.m7411d("MicroMsg.NetSceneSearchOpenIMContact", "onGYNetEnd search setImageFlag %s b[%s] s[%s]", c17880h.getUsername(), c17880h.ack(), c17880h.acl());
            c17880h.dtR = 3;
            c17880h.mo33385cB(true);
            C17884o.act().mo33391b(c17880h);
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(78874);
            return;
        }
        if (i2 == 4 && i3 == -2034) {
            this.gfh = ((bvm) this.ehh.fsH.fsP).url;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(78874);
    }
}
