package com.tencent.p177mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.apz;
import com.tencent.p177mm.protocal.protobuf.aqa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.voiceprint.model.d */
public final class C14014d extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;
    String sKW = "";
    int sKX = 0;
    String sKY = "";

    public C14014d(int i, String str) {
        AppMethodBeat.m2504i(26078);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new apz();
        c1196a.fsK = new aqa();
        c1196a.uri = "/cgi-bin/micromsg-bin/getvoiceprintresource";
        c1196a.fsI = 611;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        apz apz = (apz) this.ehh.fsG.fsP;
        C4990ab.m7417i("MicroMsg.NetSceneGetVoicePrintResource", "sceneType %d %s", Integer.valueOf(i), str);
        apz.wub = i;
        apz.wuc = str;
        AppMethodBeat.m2505o(26078);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(26079);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(26079);
        return a;
    }

    public final int getType() {
        return 611;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(26080);
        C4990ab.m7410d("MicroMsg.NetSceneGetVoicePrintResource", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        aqa aqa = (aqa) ((C7472b) c1929q).fsH.fsP;
        if (i2 == 0 || i3 == 0) {
            if (aqa.wud != null) {
                this.sKW = new String(aqa.wud.wVc.getBufferToBytes());
                this.sKX = aqa.wud.wTu;
                C4990ab.m7411d("MicroMsg.NetSceneGetVoicePrintResource", "vertify resid %d mtext %s", Integer.valueOf(this.sKX), this.sKW);
            } else {
                C4990ab.m7412e("MicroMsg.NetSceneGetVoicePrintResource", "resp ResourceData null ");
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(26080);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(26080);
    }
}
