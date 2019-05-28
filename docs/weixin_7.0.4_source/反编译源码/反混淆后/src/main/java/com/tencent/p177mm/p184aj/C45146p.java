package com.tencent.p177mm.p184aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.protocal.protobuf.C40537kb;
import com.tencent.p177mm.protocal.protobuf.C46559ka;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.FilterEnum4Shaka;

/* renamed from: com.tencent.mm.aj.p */
public final class C45146p extends C1207m implements C1918k {
    private String edV;
    C7472b ehh;
    private C1202f ehi;
    private C25773a<C45146p> fwN;

    /* renamed from: com.tencent.mm.aj.p$a */
    public interface C25773a<T extends C1207m> {
        /* renamed from: a */
        void mo43736a(int i, int i2, String str, T t);
    }

    public C45146p(String str, String str2, C25773a<C45146p> c25773a) {
        this(str, str2);
        this.fwN = c25773a;
    }

    private C45146p(String str, String str2) {
        AppMethodBeat.m2504i(11432);
        this.edV = str;
        C4990ab.m7417i("MicroMsg.NetSceneBizAttrSync", "[BizAttr] NetSceneBizAttrSync (%s)", str);
        C1196a c1196a = new C1196a();
        c1196a.fsI = FilterEnum4Shaka.MIC_WEISHI_LIUJIN;
        c1196a.uri = "/cgi-bin/mmbiz-bin/bizattr/bizattrsync";
        c1196a.fsJ = new C46559ka();
        c1196a.fsK = new C40537kb();
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        C46559ka c46559ka = (C46559ka) this.ehh.fsG.fsP;
        c46559ka.vMR = this.edV;
        c46559ka.vMS = new C1332b(C5046bo.anf(C5046bo.nullAsNil(str2)));
        AppMethodBeat.m2505o(11432);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(11433);
        C4990ab.m7417i("MicroMsg.NetSceneBizAttrSync", "[BizAttr] onGYNetEnd netId %d, errType %d, errCode %d, errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        if (this.fwN != null) {
            this.fwN.mo43736a(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(11433);
    }

    public final int getType() {
        return FilterEnum4Shaka.MIC_WEISHI_LIUJIN;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(11434);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(11434);
        return a;
    }
}
