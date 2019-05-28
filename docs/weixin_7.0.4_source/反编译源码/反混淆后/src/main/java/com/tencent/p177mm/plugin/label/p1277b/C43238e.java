package com.tencent.p177mm.plugin.label.p1277b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.axj;
import com.tencent.p177mm.protocal.protobuf.cjp;
import com.tencent.p177mm.protocal.protobuf.cjq;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.label.b.e */
public final class C43238e extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;
    private axj nHz = null;

    public C43238e(int i, String str) {
        AppMethodBeat.m2504i(22533);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cjp();
        c1196a.fsK = new cjq();
        c1196a.uri = "/cgi-bin/micromsg-bin/updatecontactlabel";
        c1196a.fsI = 637;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        if (i >= 0 && !C5046bo.isNullOrNil(str)) {
            this.nHz = new axj();
            this.nHz.wBr = i;
            this.nHz.wBq = str;
        }
        AppMethodBeat.m2505o(22533);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(22534);
        C4990ab.m7411d("MicroMsg.Label.NetSceneUpdateContactLabel", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(22534);
    }

    public final int getType() {
        return 637;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(22535);
        this.ehi = c1202f;
        cjp cjp = (cjp) this.ehh.fsG.fsP;
        if (this.nHz != null) {
            cjp.xii = this.nHz;
            int a = mo4457a(c1902e, this.ehh, this);
            AppMethodBeat.m2505o(22535);
            return a;
        }
        C4990ab.m7412e("MicroMsg.Label.NetSceneUpdateContactLabel", "cpan[doScene] label pair is null.");
        c1202f.onSceneEnd(3, -1, "[doScene]empty label pair.", this);
        AppMethodBeat.m2505o(22535);
        return 0;
    }
}
