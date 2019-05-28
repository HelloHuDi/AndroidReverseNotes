package com.tencent.p177mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.protocal.protobuf.C23468yo;
import com.tencent.p177mm.protocal.protobuf.C44195yp;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.ttpic.FilterEnum4Shaka;

/* renamed from: com.tencent.mm.modelsimple.g */
public final class C37947g extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;

    public C37947g(String str, int i, String str2) {
        AppMethodBeat.m2504i(16572);
        C4990ab.m7417i("MicroMsg.NetSceneEnterTempSession", "NetSceneEnterTempSession %s, %s, %s", str, Integer.valueOf(i), str2);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C23468yo();
        c1196a.fsK = new C44195yp();
        c1196a.uri = "/cgi-bin/mmbiz-bin/usrmsg/entertempsession";
        c1196a.fsI = FilterEnum4Shaka.MIC_WEISHI_FEIHONG;
        this.ehh = c1196a.acD();
        String str3 = "";
        if (str2 == null) {
            str2 = str3;
        } else if (str2.length() > 32 && i != 19) {
            str2 = str2.substring(0, 32);
        }
        C23468yo c23468yo = (C23468yo) this.ehh.fsG.fsP;
        c23468yo.vMR = str;
        c23468yo.vFH = i;
        c23468yo.wer = C1332b.akB(str2);
        c23468yo.wcJ = C1332b.m2847bI(new byte[0]);
        C4990ab.m7417i("MicroMsg.NetSceneEnterTempSession", "NetSceneEnterTempSession %s, %s, %s", str, Integer.valueOf(i), Integer.valueOf(c23468yo.wcJ.f1226wR.length));
        AppMethodBeat.m2505o(16572);
    }

    public final int getType() {
        return FilterEnum4Shaka.MIC_WEISHI_FEIHONG;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(16573);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(16573);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(16574);
        C4990ab.m7417i("MicroMsg.NetSceneEnterTempSession", "onGYNetEnd: %d, %d, %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(16574);
    }
}
