package com.tencent.p177mm.plugin.facedetect.p966b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.aaj;
import com.tencent.p177mm.protocal.protobuf.aak;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.facedetect.b.r */
public final class C43031r extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi;
    public String mFileName = "";

    public C43031r(String str, long j, String str2, String str3, String str4) {
        AppMethodBeat.m2504i(98);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new aaj();
        c1196a.fsK = new aak();
        c1196a.uri = "/cgi-bin/mmbiz-bin/usrmsg/facevideobindbioid";
        c1196a.fsI = 1197;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        this.mFileName = str;
        aaj aaj = (aaj) this.ehh.fsG.fsP;
        aaj.csB = str2;
        aaj.wfw = j;
        aaj.wfx = str4;
        aaj.wfE = str3;
        AppMethodBeat.m2505o(98);
    }

    public final int getType() {
        return 1197;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(99);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(99);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(100);
        C4990ab.m7411d("MicroMsg.NetSceneFaceThirdBindVideo", "hy:  errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(100);
    }
}
