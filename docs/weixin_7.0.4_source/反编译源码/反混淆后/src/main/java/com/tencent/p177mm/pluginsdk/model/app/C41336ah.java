package com.tencent.p177mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p183ai.C7472b.C6295b;
import com.tencent.p177mm.plugin.p500s.p501a.C13114a.C3753a;
import com.tencent.p177mm.protocal.protobuf.bxn;
import com.tencent.p177mm.protocal.protobuf.bxo;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.pluginsdk.model.app.ah */
public final class C41336ah extends C40442x {
    private int cmdId;
    private String vcC;

    public C41336ah(String str, String str2) {
        AppMethodBeat.m2504i(27366);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bxn();
        c1196a.fsK = new bxo();
        c1196a.uri = "/cgi-bin/micromsg-bin/setappsetting";
        this.lty = c1196a.acD();
        bxn bxn = (bxn) this.lty.fsG.fsP;
        bxn.mZr = str;
        bxn.wXy = 0;
        bxn.wXz = str2;
        this.cmdId = 0;
        this.vcC = str2;
        AppMethodBeat.m2505o(27366);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(27367);
        C4990ab.m7416i("MicroMsg.NetSceneSetAppSetting", "errType = " + i2 + ", errCode = " + i3);
        if (i2 == 0 && i2 == 0) {
            bxo bxo = (bxo) this.lty.fsH.fsP;
            if (bxo != null) {
                C35796i bYO = C3753a.bYQ().bYO();
                C40439f bT = C46494g.m87739bT(bxo.mZr, false);
                if (bT != null) {
                    bT.field_authFlag = bxo.vGY;
                    C4990ab.m7410d("MicroMsg.NetSceneSetAppSetting", "onGYNetEnd, update ret = " + bYO.mo56566a(bT, new String[0]) + ", appId = " + bxo.mZr);
                }
            }
        }
        AppMethodBeat.m2505o(27367);
    }

    public final byte[] dhj() {
        AppMethodBeat.m2504i(27368);
        try {
            byte[] ZT = ((C6295b) this.lty.acF()).mo5742ZT();
            AppMethodBeat.m2505o(27368);
            return ZT;
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.NetSceneSetAppSetting", "toProtBuf failed: " + e.getMessage());
            AppMethodBeat.m2505o(27368);
            return null;
        }
    }

    /* renamed from: bG */
    public final void mo9871bG(byte[] bArr) {
        AppMethodBeat.m2504i(27369);
        if (bArr == null) {
            C4990ab.m7412e("MicroMsg.NetSceneSetAppSetting", "buf is null");
            AppMethodBeat.m2505o(27369);
            return;
        }
        try {
            this.lty.fsH.mo5744P(bArr);
            AppMethodBeat.m2505o(27369);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.NetSceneSetAppSetting", "parse error: " + e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.NetSceneSetAppSetting", e, "", new Object[0]);
            AppMethodBeat.m2505o(27369);
        }
    }

    public final int getType() {
        return 2;
    }
}
