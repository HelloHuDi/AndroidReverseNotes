package com.tencent.p177mm.plugin.brandservice.p926b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bvg;
import com.tencent.p177mm.protocal.protobuf.bvh;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.FilterEnum4Shaka;

/* renamed from: com.tencent.mm.plugin.brandservice.b.i */
public final class C20028i extends C1207m implements C1918k {
    private String ctj;
    private C1202f ehi;
    private C7472b jKA;
    private long jKC;
    public bvh jKD;
    private int scene;

    public C20028i(String str, long j, int i) {
        AppMethodBeat.m2504i(13849);
        this.ctj = str;
        this.jKC = j;
        this.scene = i;
        C4990ab.m7417i("MicroMsg.NetSceneSearchHomePageNew", "Constructors: keyword (%s) , businessType (%d), scene (%d)", str, Long.valueOf(j), Integer.valueOf(i));
        AppMethodBeat.m2505o(13849);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(13850);
        C4990ab.m7417i("MicroMsg.NetSceneSearchHomePageNew", "netId (%d) , errType (%d) , errCode (%d) , errMsg (%s)", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0 && this.jKA != null) {
            this.jKD = (bvh) this.jKA.fsH.fsP;
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(13850);
    }

    public final int getType() {
        return FilterEnum4Shaka.MIC_WEISHI_XINXUE;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(13851);
        C4990ab.m7416i("MicroMsg.NetSceneSearchHomePageNew", "doScene");
        this.ehi = c1202f;
        if (C5046bo.isNullOrNil(this.ctj)) {
            C4990ab.m7412e("MicroMsg.NetSceneSearchHomePageNew", "keyword is unavailable");
            AppMethodBeat.m2505o(13851);
            return -1;
        }
        C1196a c1196a = new C1196a();
        c1196a.fsI = FilterEnum4Shaka.MIC_WEISHI_XINXUE;
        c1196a.uri = "/cgi-bin/mmbiz-bin/bizsearch/homepage";
        c1196a.fsJ = new bvg();
        c1196a.fsK = new bvh();
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.jKA = c1196a.acD();
        bvg bvg = (bvg) this.jKA.fsG.fsP;
        bvg.wol = this.ctj;
        bvg.wDI = C42790b.abJ();
        bvg.vQd = this.jKC;
        bvg.wWo = this.scene;
        C4990ab.m7417i("MicroMsg.NetSceneSearchHomePageNew", "businessTypeList is %d", Long.valueOf(this.jKC));
        int a = mo4457a(c1902e, this.jKA, this);
        AppMethodBeat.m2505o(13851);
        return a;
    }
}
