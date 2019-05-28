package com.tencent.p177mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C15351ir;
import com.tencent.p177mm.protocal.protobuf.C15352is;
import com.tencent.p177mm.protocal.protobuf.cfx;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.modelappbrand.o */
public final class C6676o extends C1207m implements C1918k {
    private C1202f eIc;
    private final C7472b fpJ;

    public C6676o(LinkedList<cfx> linkedList) {
        AppMethodBeat.m2504i(93730);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C15351ir();
        c1196a.fsK = new C15352is();
        c1196a.uri = "/cgi-bin/mmbiz-bin/wxausrevent/batchswitchservicenotifyoption";
        this.fpJ = c1196a.acD();
        ((C15351ir) this.fpJ.fsG.fsP).vKN = linkedList;
        AppMethodBeat.m2505o(93730);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(93731);
        C4990ab.m7417i("MicroMsg.NetSceneBatchSwitchServiceNotifyOption", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.eIc != null) {
            this.eIc.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(93731);
    }

    public final int getType() {
        return 1176;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(93732);
        C4990ab.m7416i("MicroMsg.NetSceneBatchSwitchServiceNotifyOption", "doScene");
        this.eIc = c1202f;
        int a = mo4457a(c1902e, this.fpJ, this);
        AppMethodBeat.m2505o(93732);
        return a;
    }
}
