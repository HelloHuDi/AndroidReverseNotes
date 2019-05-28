package com.tencent.p177mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.protocal.protobuf.asx;
import com.tencent.p177mm.protocal.protobuf.asy;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.ttpic.FilterEnum4Shaka;

/* renamed from: com.tencent.mm.plugin.exdevice.model.s */
public final class C42997s extends C1207m implements C1918k {
    private C1202f eIc = null;
    private String lst = null;
    private C7472b ltG = null;

    public C42997s(String str, String str2, String str3, int i) {
        AppMethodBeat.m2504i(19335);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new asx();
        c1196a.fsK = new asy();
        c1196a.uri = "/cgi-bin/mmbiz-bin/device/subscribestatus";
        c1196a.fsI = FilterEnum4Shaka.MIC_WEISHI_v4_4_LANMEI;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ltG = c1196a.acD();
        asx asx = (asx) this.ltG.fsG.fsP;
        asx.vKe = C1332b.akB(str2);
        asx.vKc = C1332b.akB(str3);
        asx.nbk = i;
        this.lst = str;
        AppMethodBeat.m2505o(19335);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(19336);
        C4990ab.m7416i("MicroMsg.exdevice.NetSceneHardDeviceStatusSubscribe", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        C45891ad.boW().mo45701Kv(this.lst);
        if (i2 == 0 && i3 == 0) {
            C4990ab.m7416i("MicroMsg.exdevice.NetSceneHardDeviceStatusSubscribe", "HardDeviceStatusSubResponse: ret=" + ((asy) this.ltG.fsH.fsP).getBaseResponse().Ret + ",msg=" + str);
        }
        this.eIc.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(19336);
    }

    public final int getType() {
        return FilterEnum4Shaka.MIC_WEISHI_v4_4_LANMEI;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(19337);
        this.eIc = c1202f;
        int a = mo4457a(c1902e, this.ltG, this);
        AppMethodBeat.m2505o(19337);
        return a;
    }
}
