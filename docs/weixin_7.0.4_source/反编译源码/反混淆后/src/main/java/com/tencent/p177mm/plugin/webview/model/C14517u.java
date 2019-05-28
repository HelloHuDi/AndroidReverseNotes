package com.tencent.p177mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.webview.model.C22890f.C22891a;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.protobuf.aus;
import com.tencent.p177mm.protocal.protobuf.awn;
import com.tencent.p177mm.protocal.protobuf.awo;
import com.tencent.p177mm.protocal.protobuf.axb;
import com.tencent.p177mm.protocal.protobuf.axc;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.webview.model.u */
public final class C14517u extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;

    public C14517u(List<axc> list) {
        AppMethodBeat.m2504i(6625);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new awn();
        c1196a.fsK = new awo();
        c1196a.uri = "/cgi-bin/mmux-bin/jslog";
        this.ehh = c1196a.acD();
        awn awn = (awn) this.ehh.fsG.fsP;
        axb axb = new axb();
        axb.vOz = C7243d.vxj;
        axb.vOA = C7243d.vxi;
        axb.vOB = C7243d.vxl;
        axb.vOC = C7243d.vxm;
        axb.vOD = C4988aa.dor();
        axb.wBk = (int) (System.currentTimeMillis() / 1000);
        awn.vDV = axb;
        awn.vDW.addAll(list);
        AppMethodBeat.m2505o(6625);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(6626);
        C4990ab.m7416i("MicroMsg.NetSceneJsLog", "onGYNetEnd, netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            awo awo = (awo) ((C7472b) c1929q).fsH.fsP;
            C4990ab.m7416i("MicroMsg.NetSceneJsLog", "received InvalidLogList: ");
            StringBuilder stringBuilder = new StringBuilder("{ ");
            if (C5046bo.m7548ek(awo.wAU)) {
                stringBuilder.append("{  }");
            } else {
                Iterator it = awo.wAU.iterator();
                while (it.hasNext()) {
                    aus aus = (aus) it.next();
                    stringBuilder.append(String.format(" { logId(%d), interval(%d) },", new Object[]{Integer.valueOf(aus.wyT), Integer.valueOf(aus.wyU)}));
                }
            }
            stringBuilder.append(" }");
            C4990ab.m7416i("MicroMsg.NetSceneJsLog", stringBuilder.toString());
            C22891a.ulU;
            C22890f.m34739ea(awo.wAU);
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(6626);
    }

    public final int getType() {
        return 1803;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(6627);
        this.ehi = c1202f;
        C4990ab.m7410d("MicroMsg.NetSceneJsLog", "doScene");
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(6627);
        return a;
    }
}
