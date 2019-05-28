package com.tencent.p177mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.atr;
import com.tencent.p177mm.protocal.protobuf.cim;
import com.tencent.p177mm.protocal.protobuf.cin;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.exdevice.model.n */
public final class C20535n extends C1207m implements C1918k {
    public String ceI = null;
    C7472b ehh = null;
    private C1202f ehi = null;
    public int ltE = 0;

    public C20535n(atr atr, String str, String str2, int i) {
        AppMethodBeat.m2504i(19319);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cim();
        c1196a.fsK = new cin();
        c1196a.uri = "/cgi-bin/mmoc-bin/hardware/transfermsgtodevice";
        c1196a.fsI = 1717;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        cim cim = (cim) this.ehh.fsG.fsP;
        cim.vIk = str;
        cim.wbq = str2;
        cim.xhs = atr;
        cim.xht = i;
        this.ceI = str2;
        this.ltE = i;
        AppMethodBeat.m2505o(19319);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(19320);
        C4990ab.m7416i("MicroMsg.exdevice.NetSceneGetAppMsgInfo", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(19320);
    }

    public final int getType() {
        return 1717;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(19321);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(19321);
        return a;
    }
}
