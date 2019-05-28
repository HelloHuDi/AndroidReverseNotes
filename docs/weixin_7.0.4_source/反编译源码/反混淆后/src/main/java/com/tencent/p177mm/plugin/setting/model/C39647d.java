package com.tencent.p177mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.adm;
import com.tencent.p177mm.protocal.protobuf.adn;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;

/* renamed from: com.tencent.mm.plugin.setting.model.d */
public final class C39647d extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi;

    public C39647d(String str) {
        AppMethodBeat.m2504i(126844);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new adm();
        c1196a.fsK = new adn();
        c1196a.uri = "/cgi-bin/micromsg-bin/generalset";
        c1196a.fsI = ErrorCode.NONEEDDOWNLOAD_OTHER_PROCESS_DOWNLOADING;
        this.ehh = c1196a.acD();
        adm adm = (adm) this.ehh.fsG.fsP;
        adm.SetType = 1;
        adm.wlj = str;
        AppMethodBeat.m2505o(126844);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(126845);
        C4990ab.m7410d("MicroMsg.NetSceneGeneralSet", "doScene");
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(126845);
        return a;
    }

    public final int getType() {
        return ErrorCode.NONEEDDOWNLOAD_OTHER_PROCESS_DOWNLOADING;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(126846);
        C4990ab.m7410d("MicroMsg.NetSceneGeneralSet", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(126846);
    }
}
