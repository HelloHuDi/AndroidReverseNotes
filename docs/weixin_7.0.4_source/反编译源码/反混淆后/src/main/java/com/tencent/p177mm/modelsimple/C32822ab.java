package com.tencent.p177mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.ayy;
import com.tencent.p177mm.protocal.protobuf.ayz;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.view.C31128d;

/* renamed from: com.tencent.mm.modelsimple.ab */
public final class C32822ab extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;

    public C32822ab(int i) {
        AppMethodBeat.m2504i(78612);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new ayy();
        c1196a.fsK = new ayz();
        c1196a.uri = "/cgi-bin/micromsg-bin/logoutwebwx";
        c1196a.fsI = C31128d.MIC_PTU_TRANS_KONGCHENG;
        this.ehh = c1196a.acD();
        ((ayy) this.ehh.fsG.fsP).OpCode = i;
        AppMethodBeat.m2505o(78612);
    }

    public final int getType() {
        return C31128d.MIC_PTU_TRANS_KONGCHENG;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(78613);
        C4990ab.m7410d("MicroMsg.NetSceneWebWXLogout", "doScene");
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(78613);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(78614);
        if (!(i2 == 0 && i3 == 0)) {
            C4990ab.m7410d("MicroMsg.NetSceneWebWXLogout", "logout Error. ");
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(78614);
    }
}
