package com.tencent.p177mm.plugin.emoji.p726f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.ail;
import com.tencent.p177mm.protocal.protobuf.aim;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.emoji.f.m */
public final class C20374m extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;
    public byte[] kWS = null;
    private String kWT;

    public C20374m(String str, byte[] bArr) {
        AppMethodBeat.m2504i(53131);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new ail();
        c1196a.fsK = new aim();
        c1196a.uri = "/cgi-bin/micromsg-bin/mmgetemotiondonorlist";
        c1196a.fsI = 299;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        this.kWS = bArr;
        this.kWT = str;
        AppMethodBeat.m2505o(53131);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(53132);
        C4990ab.m7410d("MicroMsg.emoji.NetSceneGetEmotionDonorList", "ErrType:" + i2 + "   errCode:" + i3);
        aim aim = (aim) ((C7472b) c1929q).fsH.fsP;
        if (aim.vFq != null) {
            this.kWS = C1946aa.m4150a(aim.vFq);
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(53132);
    }

    public final int getType() {
        return 299;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(53133);
        this.ehi = c1202f;
        ail ail = (ail) this.ehh.fsG.fsP;
        if (this.kWS != null) {
            ail.ReqBuf = C1946aa.m4152ad(this.kWS);
        } else {
            ail.ReqBuf = new SKBuiltinBuffer_t();
        }
        ail.ProductID = this.kWT;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(53133);
        return a;
    }

    public final aim bkA() {
        return (aim) this.ehh.fsH.fsP;
    }
}
