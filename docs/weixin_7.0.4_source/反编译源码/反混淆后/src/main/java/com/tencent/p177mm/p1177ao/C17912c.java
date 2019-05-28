package com.tencent.p177mm.p1177ao;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.awp;
import com.tencent.p177mm.protocal.protobuf.awq;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.ao.c */
public final class C17912c extends C1207m implements C1918k {
    private C1202f ehi;
    private final C7472b fAT;
    public Object tag;

    public C17912c(String str) {
        AppMethodBeat.m2504i(62294);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new awp();
        c1196a.fsK = new awq();
        c1196a.uri = "/cgi-bin/micromsg-bin/jumpemotiondetail";
        this.fAT = c1196a.acD();
        ((awp) this.fAT.fsG.fsP).Url = str;
        AppMethodBeat.m2505o(62294);
    }

    public final int getType() {
        return 666;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(62295);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.fAT, this);
        AppMethodBeat.m2505o(62295);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(62296);
        C4990ab.m7411d("MicroMsg.NetSceneScanEmoji", "[oneliang][NetSceneScanEmoji]:netId:%s,errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            C4990ab.m7410d("MicroMsg.NetSceneScanEmoji", "[oneliang][NetSceneScanEmoji]:net end ok");
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(62296);
    }

    public final awq agd() {
        return (awq) this.fAT.fsH.fsP;
    }
}
