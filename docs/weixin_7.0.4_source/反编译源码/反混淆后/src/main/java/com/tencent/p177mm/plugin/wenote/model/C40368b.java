package com.tencent.p177mm.plugin.wenote.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.abd;
import com.tencent.p177mm.protocal.protobuf.abj;
import com.tencent.p177mm.protocal.protobuf.abk;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.wenote.model.b */
public final class C40368b extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi = null;
    public int uMF = 1;
    private String uMG = "";
    private abd uMH = null;
    private LinkedList<abd> uMI = new LinkedList();
    public int uMJ = 0;

    public C40368b(int i, int i2, String str, LinkedList<abd> linkedList, abd abd) {
        AppMethodBeat.m2504i(26595);
        this.uMI = linkedList;
        this.uMH = abd;
        this.uMG = str;
        this.uMF = i2;
        this.uMJ = i;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new abj();
        c1196a.fsK = new abk();
        c1196a.uri = "/cgi-bin/micromsg-bin/favsecurity ";
        c1196a.fsI = 921;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        AppMethodBeat.m2505o(26595);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(26596);
        abj abj = (abj) this.ehh.fsG.fsP;
        abj.nbk = this.uMF;
        abj.wiA = this.uMH;
        abj.wiz = this.uMI;
        abj.wdK = this.uMG;
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(26596);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(26597);
        C4990ab.m7417i("MicroMsg.NetSceneCheckNoteSecurity", "netId %d errType %d errCode %d errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        abk abk = (abk) ((C7472b) c1929q).fsH.fsP;
        if (i2 != 0) {
            C4990ab.m7417i("MicroMsg.NetSceneCheckNoteSecurity", "NetSceneCheckNoteSecurity,errType:%d,fail", Integer.valueOf(i2));
            this.ehi.onSceneEnd(i2, -1, str, this);
            AppMethodBeat.m2505o(26597);
        } else if (abk == null || abk.getBaseResponse() == null) {
            C4990ab.m7416i("MicroMsg.NetSceneCheckNoteSecurity", "NetSceneCheckNoteSecurity,response == null,ok");
            this.ehi.onSceneEnd(i2, 0, str, this);
            AppMethodBeat.m2505o(26597);
        } else if (abk.getBaseResponse().Ret != 0) {
            C4990ab.m7416i("MicroMsg.NetSceneCheckNoteSecurity", "NetSceneCheckNoteSecurity,baseresponse.ret != 0,ok");
            this.ehi.onSceneEnd(i2, 0, str, this);
            AppMethodBeat.m2505o(26597);
        } else if (abk.wiB > 0) {
            C4990ab.m7416i("MicroMsg.NetSceneCheckNoteSecurity", "NetSceneCheckNoteSecurity,SecurityResult > 0,fail");
            this.ehi.onSceneEnd(i2, -1, str, this);
            AppMethodBeat.m2505o(26597);
        } else {
            C4990ab.m7416i("MicroMsg.NetSceneCheckNoteSecurity", "NetSceneCheckNoteSecurity,SecurityResult = 0,fail");
            this.ehi.onSceneEnd(i2, 0, str, this);
            AppMethodBeat.m2505o(26597);
        }
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        return C1206b.EOk;
    }

    public final int getType() {
        return 921;
    }
}
