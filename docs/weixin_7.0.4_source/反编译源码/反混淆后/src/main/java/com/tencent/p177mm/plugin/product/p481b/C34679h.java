package com.tencent.p177mm.plugin.product.p481b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.amo;
import com.tencent.p177mm.protocal.protobuf.amp;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.product.b.h */
public final class C34679h extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi;
    public String phj;
    public C12812m phk;
    public List<C12813n> phl;

    public C34679h(C12812m c12812m, String str) {
        AppMethodBeat.m2504i(43988);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new amo();
        c1196a.fsK = new amp();
        c1196a.uri = "/cgi-bin/micromsg-bin/getproductdetail";
        this.ehh = c1196a.acD();
        amo amo = (amo) this.ehh.fsG.fsP;
        this.phj = str;
        amo.wrm = str;
        C4990ab.m7410d("MicroMsg.NetSceneMallGetProductDetail", "pid ".concat(String.valueOf(str)));
        amo.Version = 0;
        this.phk = c12812m;
        AppMethodBeat.m2505o(43988);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(43989);
        amp amp = (amp) ((C7472b) c1929q).fsH.fsP;
        if (!C5046bo.isNullOrNil(amp.wro)) {
            C4990ab.m7410d("MicroMsg.NetSceneMallGetProductDetail", "resp.ProductInfo " + amp.wro);
            this.phk = C12812m.m20812a(this.phk, amp.wro);
        }
        if (i3 == 0 && amp.vKp != 0) {
            i3 = amp.vKp;
            str = amp.vKq;
        }
        if (!C5046bo.isNullOrNil(amp.wrp)) {
            C4990ab.m7410d("MicroMsg.NetSceneMallGetProductDetail", "resp.RecommendInfo " + amp.wrp);
            this.phl = C12813n.parse(amp.wrp);
        }
        C4990ab.m7410d("MicroMsg.NetSceneMallGetProductDetail", "errCode " + i3 + ", errMsg " + str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(43989);
    }

    public final int getType() {
        return 553;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(43990);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(43990);
        return a;
    }
}
