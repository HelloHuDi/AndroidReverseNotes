package com.tencent.p177mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bup;
import com.tencent.p177mm.protocal.protobuf.buq;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.exdevice.model.t */
public final class C42998t extends C1207m implements C1918k {
    private C7472b ehh = null;
    private C1202f ehi = null;

    public C42998t(String str, String str2, String str3) {
        AppMethodBeat.m2504i(19338);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bup();
        c1196a.fsK = new buq();
        c1196a.uri = "/cgi-bin/mmoc-bin/hardware/searchbleharddevice";
        c1196a.fsI = 1706;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        bup bup = (bup) this.ehh.fsG.fsP;
        bup.mac = str;
        if (str2 == null) {
            str2 = "";
        }
        bup.userName = str2;
        if (str3 == null) {
            str3 = "";
        }
        bup.category = str3;
        AppMethodBeat.m2505o(19338);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(19339);
        C4990ab.m7416i("MicroMsg.exdevice.NetSceneSearchBLEHardDevice", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(19339);
    }

    public final int getType() {
        return 1706;
    }

    public final buq boS() {
        return (buq) this.ehh.fsH.fsP;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(19340);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(19340);
        return a;
    }
}
