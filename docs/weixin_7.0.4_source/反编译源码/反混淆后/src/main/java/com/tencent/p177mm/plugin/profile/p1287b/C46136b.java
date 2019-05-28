package com.tencent.p177mm.plugin.profile.p1287b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.aqv;
import com.tencent.p177mm.protocal.protobuf.aqw;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.profile.b.b */
public final class C46136b extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;
    public String pkH;

    public C46136b(String str, String str2) {
        AppMethodBeat.m2504i(23284);
        this.pkH = str;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new aqv();
        c1196a.fsK = new aqw();
        c1196a.uri = "/cgi-bin/micromsg-bin/getwburl";
        this.ehh = c1196a.acD();
        aqv aqv = (aqv) this.ehh.fsG.fsP;
        aqv.jBB = str2;
        C9638aw.m17190ZK();
        String nullAsNil = C5046bo.nullAsNil((String) C18628c.m29072Ry().get(46, null));
        aqv.vHP = new SKBuiltinBuffer_t().setBuffer(C5046bo.anf(nullAsNil));
        C9638aw.m17190ZK();
        String nullAsNil2 = C5046bo.nullAsNil((String) C18628c.m29072Ry().get(72, null));
        aqv.wlr = new SKBuiltinBuffer_t().setBuffer(C5046bo.anf(nullAsNil2));
        C4990ab.m7410d("MicroMsg.NetSceneGetWeiboURL", "dkwt get weibo url with id=" + str + ", a2=" + nullAsNil + " , newa2:" + nullAsNil2);
        AppMethodBeat.m2505o(23284);
    }

    public final int getType() {
        return 205;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(23285);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(23285);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(23286);
        C4990ab.m7411d("MicroMsg.NetSceneGetWeiboURL", "dkwt onGYNetEnd:[%d,%d] get weibo url result:[%s] ", Integer.valueOf(i2), Integer.valueOf(i3), getURL());
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(23286);
    }

    public final String getURL() {
        return ((aqw) this.ehh.fsH.fsP).URL;
    }
}
