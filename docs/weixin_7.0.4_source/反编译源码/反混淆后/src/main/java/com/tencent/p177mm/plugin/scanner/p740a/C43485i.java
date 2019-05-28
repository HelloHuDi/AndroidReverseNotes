package com.tencent.p177mm.plugin.scanner.p740a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.protobuf.C15358ld;
import com.tencent.p177mm.protocal.protobuf.C7546lc;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.ttpic.FilterEnum4Shaka;

/* renamed from: com.tencent.mm.plugin.scanner.a.i */
public final class C43485i extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi;

    public C43485i(String str, String str2, int i, String str3, int i2, int i3) {
        AppMethodBeat.m2504i(80850);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C7546lc();
        c1196a.fsK = new C15358ld();
        c1196a.uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscanproductreport";
        c1196a.fsI = FilterEnum4Shaka.MIC_WEISHI_BAIHUA;
        this.ehh = c1196a.acD();
        C7546lc c7546lc = (C7546lc) this.ehh.fsG.fsP;
        c7546lc.vOz = C7243d.vxj;
        c7546lc.vOA = C7243d.vxi;
        c7546lc.vOB = C7243d.vxl;
        c7546lc.vOC = C7243d.vxm;
        c7546lc.vOD = C4988aa.dor();
        c7546lc.pXL = 11294;
        c7546lc.vOE = null;
        c7546lc.pZp = str;
        c7546lc.pZo = str2;
        c7546lc.type = i;
        c7546lc.value = str3;
        c7546lc.count = i2;
        c7546lc.oZe = i3;
        C4990ab.m7418v("MircoMsg.NetSceneScanProductReport", "statid:".concat(String.valueOf(str2)));
        AppMethodBeat.m2505o(80850);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(80851);
        C4990ab.m7410d("MircoMsg.NetSceneScanProductReport", "errType = " + i2 + ", errCode = " + i3);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(80851);
    }

    public final int getType() {
        return FilterEnum4Shaka.MIC_WEISHI_BAIHUA;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(80852);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(80852);
        return a;
    }
}
