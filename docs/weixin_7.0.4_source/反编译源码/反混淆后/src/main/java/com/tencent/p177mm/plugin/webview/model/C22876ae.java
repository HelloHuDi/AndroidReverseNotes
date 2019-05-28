package com.tencent.p177mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.cmq;
import com.tencent.p177mm.protocal.protobuf.cmr;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.webview.model.ae */
public final class C22876ae extends C1207m implements C1918k {
    private C1202f ehi;
    public final C7472b fAT;

    public C22876ae(String str, String str2, String str3) {
        AppMethodBeat.m2504i(6656);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cmq();
        c1196a.fsK = new cmr();
        c1196a.uri = "/cgi-bin/mmo2o-bin/verifybeaconjspermission";
        this.fAT = c1196a.acD();
        cmq cmq = (cmq) this.fAT.fsG.fsP;
        cmq.Url = str;
        cmq.csB = str2;
        cmq.cxb = str3;
        AppMethodBeat.m2505o(6656);
    }

    public final int getType() {
        return 1702;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(6657);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.fAT, this);
        AppMethodBeat.m2505o(6657);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(6658);
        C4990ab.m7417i("MicroMsg.NetSceneVerifyBeaconJsPermission", "[oneliang][NetSceneVerifyBeaconJsPermission]:netId:%s,errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            C4990ab.m7410d("MicroMsg.NetSceneVerifyBeaconJsPermission", "[oneliang][NetSceneVerifyBeaconJsPermission]:net end ok");
        } else {
            C4990ab.m7410d("MicroMsg.NetSceneVerifyBeaconJsPermission", "[oneliang][NetSceneVerifyBeaconJsPermission]:net end not ok");
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(6658);
    }
}
