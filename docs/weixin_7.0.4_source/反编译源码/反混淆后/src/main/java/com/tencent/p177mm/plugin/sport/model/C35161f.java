package com.tencent.p177mm.plugin.sport.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.cku;
import com.tencent.p177mm.protocal.protobuf.ckv;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.sport.model.f */
public final class C35161f extends C1207m implements C1918k {
    private C7472b ehh = null;
    private C1202f ehi = null;
    private cku rPv;

    public C35161f(String str, String str2, int i, int i2, int i3, String str3, int i4) {
        AppMethodBeat.m2504i(93663);
        C4990ab.m7417i("MicroMsg.Sport.NetSceneUploadDeviceStep", "NetSceneUploadDeviceStep %s, %s, %s, %s, %s", str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cku();
        c1196a.fsK = new ckv();
        c1196a.uri = "/cgi-bin/mmoc-bin/hardware/uploaddevicestep";
        c1196a.fsI = 1261;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        this.rPv = (cku) this.ehh.fsG.fsP;
        this.rPv.ceI = str;
        this.rPv.cws = str2;
        this.rPv.xiu = i;
        this.rPv.xiv = i2;
        this.rPv.bIb = i3;
        this.rPv.xiw = String.valueOf(C22172n.cwD());
        this.rPv.xiy = str3;
        this.rPv.xiB = i4;
        AppMethodBeat.m2505o(93663);
    }

    public final int getType() {
        return 1261;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(93664);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(93664);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(93665);
        C4990ab.m7417i("MicroMsg.Sport.NetSceneUploadDeviceStep", "NetSceneUploadDeviceStep end: errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(93665);
    }
}
