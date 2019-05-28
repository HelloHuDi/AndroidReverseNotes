package com.tencent.p177mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.protocal.C35972w.C23477a;
import com.tencent.p177mm.protocal.protobuf.bwd;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.modelsimple.v */
public final class C32829v extends C1207m implements C1918k {
    private C1202f ehi;
    private final C1929q ftU;

    public C32829v(int i, String str) {
        this(i, str, "");
    }

    public C32829v(int i, String str, String str2) {
        AppMethodBeat.m2504i(78596);
        this.ftU = new C18673b();
        C23477a c23477a = (C23477a) this.ftU.acF();
        c23477a.vyK.jBB = C1853r.m3846Yz();
        bwd bwd = c23477a.vyK;
        StringBuilder stringBuilder = new StringBuilder();
        if (i == 0) {
            i = 64;
        }
        stringBuilder = stringBuilder.append(i).append(";");
        if (str == null) {
            str = "";
        }
        bwd.ncM = stringBuilder.append(str).toString();
        C4990ab.m7410d("MicroMsg.NetSceneSendCard", "content:" + c23477a.vyK.ncM);
        Assert.assertTrue("empty sendcard", true);
        c23477a.vyK.wIi = 64;
        if (str2 != null && str2.length() > 0) {
            c23477a.vyK.wWU = str2;
        }
        AppMethodBeat.m2505o(78596);
    }

    public C32829v(String str) {
        AppMethodBeat.m2504i(78597);
        this.ftU = new C18673b();
        C23477a c23477a = (C23477a) this.ftU.acF();
        c23477a.vyK.jBB = C1853r.m3846Yz();
        c23477a.vyK.ncM = str;
        C4990ab.m7410d("MicroMsg.NetSceneSendCard", "content:".concat(String.valueOf(str)));
        c23477a.vyK.wrF = C5046bo.m7567h((Integer) C1720g.m3536RP().mo5239Ry().get(66561, null));
        Assert.assertTrue("empty sendcard", true);
        c23477a.vyK.wIi = 128;
        AppMethodBeat.m2505o(78597);
    }

    public C32829v(String str, boolean z, boolean z2) {
        int i;
        AppMethodBeat.m2504i(78598);
        this.ftU = new C18673b();
        C23477a c23477a = (C23477a) this.ftU.acF();
        c23477a.vyK.jBB = C1853r.m3846Yz();
        c23477a.vyK.ncM = str;
        C4990ab.m7410d("MicroMsg.NetSceneSendCard", "content:".concat(String.valueOf(str)));
        c23477a.vyK.wrF = C5046bo.m7567h((Integer) C1720g.m3536RP().mo5239Ry().get(66561, null));
        int i2 = ((z ? 1 : 0) | 0) | 0;
        if (z2) {
            i = 4;
        } else {
            i = 0;
        }
        i = (i | i2) | 8;
        Assert.assertTrue("empty sendcard", true);
        c23477a.vyK.wIi = i;
        AppMethodBeat.m2505o(78598);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(78599);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ftU, this);
        AppMethodBeat.m2505o(78599);
        return a;
    }

    public final int getType() {
        return 26;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(78600);
        this.ehi.onSceneEnd(i2, i3, c1929q.mo5618ZS().vyn, this);
        AppMethodBeat.m2505o(78600);
    }
}
