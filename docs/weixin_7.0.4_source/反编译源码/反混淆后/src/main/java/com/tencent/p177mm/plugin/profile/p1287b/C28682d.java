package com.tencent.p177mm.plugin.profile.p1287b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.cfr;
import com.tencent.p177mm.protocal.protobuf.cfs;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.profile.b.d */
public final class C28682d extends C1207m implements C1918k {
    public C7472b ehh;
    private C1202f ehi;

    public C28682d(String str, boolean z) {
        AppMethodBeat.m2504i(14672);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cfr();
        c1196a.fsK = new cfs();
        c1196a.uri = "/cgi-bin/mmocbiz-bin/switchbrand";
        this.ehh = c1196a.acD();
        cfr cfr = (cfr) this.ehh.fsG.fsP;
        cfr.vNb = str;
        cfr.xeS = z;
        AppMethodBeat.m2505o(14672);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(14673);
        C4990ab.m7411d("MicroMsg.brandservice.NetSceneSwitchBrand", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(14673);
    }

    public final int getType() {
        return 1394;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(14674);
        this.ehi = c1202f;
        C4990ab.m7416i("MicroMsg.brandservice.NetSceneSwitchBrand", "do scene");
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(14674);
        return a;
    }

    public final cfs cay() {
        if (this.ehh == null || this.ehh.fsH.fsP == null) {
            return null;
        }
        return (cfs) this.ehh.fsH.fsP;
    }

    public final cfr caz() {
        if (this.ehh == null || this.ehh.fsG.fsP == null) {
            return null;
        }
        return (cfr) this.ehh.fsG.fsP;
    }
}
