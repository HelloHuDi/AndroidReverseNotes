package com.tencent.p177mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.exdevice.p956h.C11648b;
import com.tencent.p177mm.plugin.exdevice.service.C20548u;
import com.tencent.p177mm.protocal.protobuf.asq;
import com.tencent.p177mm.protocal.protobuf.cjc;
import com.tencent.p177mm.protocal.protobuf.cjd;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.exdevice.model.x */
public final class C20540x extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi;
    public asq ltI;

    public C20540x(asq asq, int i) {
        AppMethodBeat.m2504i(19350);
        this.ltI = asq;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cjc();
        c1196a.fsK = new cjd();
        c1196a.uri = "/cgi-bin/micromsg-bin/unbindharddevice";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        cjc cjc = (cjc) this.ehh.fsG.fsP;
        cjc.vLi = asq;
        cjc.vEq = i;
        AppMethodBeat.m2505o(19350);
    }

    public final int getType() {
        return 537;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(19351);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(19351);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        cjd cjd;
        AppMethodBeat.m2504i(19352);
        C4990ab.m7417i("MicroMsg.exdevice.NetSceneUnBindHardDevice", "onGYNetEnd netId = %d, errType= %d, errCode = %d , errMsg =%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        C38954i c38954i = C38954i.lto;
        C38954i.m66126hN(0);
        C11648b Kv = C45891ad.boW().mo45701Kv(this.ltI.jBE);
        if (Kv != null) {
            if (!(C20548u.bpy().lqX == null || C20548u.bpy().lqX.mo45761hZ(Kv.field_mac))) {
                C4990ab.m7412e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "stopChannel Failed!!!");
            }
            if (!C45891ad.boW().mo45708dU(this.ltI.jBE, this.ltI.vIk)) {
                C4990ab.m7412e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "deleteByDeviceId Failed!!!");
            }
        } else {
            C4990ab.m7413e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "getByDeviceIdServer Failed!!! DeviceIDServer = %s", this.ltI.jBE);
        }
        if (!(i2 == 0 && i3 == 0)) {
            C4990ab.m7413e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "scene.getType() = %s", Integer.valueOf(537));
        }
        if (this.ehh == null || this.ehh.fsH.fsP == null) {
            cjd = null;
        } else {
            cjd = (cjd) this.ehh.fsH.fsP;
        }
        if (cjd == null) {
            C4990ab.m7412e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "UnbindHardDevice resp or req is null");
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(19352);
    }
}
