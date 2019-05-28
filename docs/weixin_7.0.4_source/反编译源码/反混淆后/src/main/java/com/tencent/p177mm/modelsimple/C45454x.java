package com.tencent.p177mm.modelsimple;

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
import com.tencent.p177mm.protocal.protobuf.byf;
import com.tencent.p177mm.protocal.protobuf.byg;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.modelsimple.x */
public final class C45454x extends C1207m implements C1918k {
    public final C7472b ehh;
    private C1202f ehi;

    public C45454x(String str, String str2, int i, SKBuiltinBuffer_t sKBuiltinBuffer_t) {
        AppMethodBeat.m2504i(123477);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new byf();
        c1196a.fsK = new byg();
        c1196a.uri = "/cgi-bin/micromsg-bin/newsetpasswd";
        this.ehh = c1196a.acD();
        byf byf = (byf) this.ehh.fsG.fsP;
        byf.luH = C5046bo.and(str);
        byf.wdB = str2;
        byf.wXE = i;
        byf.vHH = sKBuiltinBuffer_t;
        C4990ab.m7411d("MicroMsg.NetSceneSetPwd", "summersetpwd md5:%s ticket:%s, type:%d, authkey:%s", str, str2, Integer.valueOf(i), C5046bo.m7539ca(C1946aa.m4150a(sKBuiltinBuffer_t)));
        AppMethodBeat.m2505o(123477);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(123478);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(123478);
        return a;
    }

    public final int getType() {
        return 383;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(123479);
        C4990ab.m7410d("MicroMsg.NetSceneSetPwd", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(123479);
    }
}
