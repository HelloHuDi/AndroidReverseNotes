package com.tencent.p177mm.plugin.brandservice.p926b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C35934mh;
import com.tencent.p177mm.protocal.protobuf.buw;
import com.tencent.p177mm.protocal.protobuf.bux;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.FilterEnum4Shaka;

/* renamed from: com.tencent.mm.plugin.brandservice.b.h */
public final class C20027h extends C1207m implements C1918k {
    private String ctj;
    private C1202f ehi;
    private String hlm;
    private C7472b jKA;
    private bux jKB;
    private long jKC;
    private int offset;
    private int scene;

    public C20027h(String str, long j, int i, int i2, String str2) {
        AppMethodBeat.m2504i(13846);
        this.ctj = str;
        this.jKC = j;
        this.offset = i;
        this.scene = i2;
        this.hlm = str2;
        C4990ab.m7417i("MicroMsg.NetSceneSearchDetailPageNew", "Constructors: keyword = (%s) , LSB exist () , businessType is (%d) , offset is (%d) , scene is (%d), searchId(%s).", str, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), str2);
        AppMethodBeat.m2505o(13846);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(13847);
        C4990ab.m7417i("MicroMsg.NetSceneSearchDetailPageNew", "netId (%d) , errType (%d) , errCode (%d) , errMsg (%s)", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0 && this.jKA != null) {
            this.jKB = (bux) this.jKA.fsH.fsP;
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(13847);
    }

    public final int getType() {
        return FilterEnum4Shaka.MIC_WEISHI_LIULI;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(13848);
        this.ehi = c1202f;
        if (C5046bo.isNullOrNil(this.ctj)) {
            C4990ab.m7412e("MicroMsg.NetSceneSearchDetailPageNew", "keyword is unavailable.");
            AppMethodBeat.m2505o(13848);
            return -1;
        }
        C1196a c1196a = new C1196a();
        c1196a.fsI = FilterEnum4Shaka.MIC_WEISHI_LIULI;
        c1196a.uri = "/cgi-bin/mmbiz-bin/bizsearch/detailpage";
        c1196a.fsJ = new buw();
        c1196a.fsK = new bux();
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.jKA = c1196a.acD();
        buw buw = (buw) this.jKA.fsG.fsP;
        buw.wDI = C42790b.abJ();
        buw.wol = this.ctj;
        buw.vQd = this.jKC;
        buw.vOq = this.offset;
        buw.wWo = this.scene;
        buw.vQg = this.hlm;
        int a = mo4457a(c1902e, this.jKA, this);
        AppMethodBeat.m2505o(13848);
        return a;
    }

    public final C35934mh aVX() {
        return this.jKB == null ? null : this.jKB.wWq;
    }
}
