package com.tencent.p177mm.pluginsdk.p592g.p593a.p594a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C40567rr;
import com.tencent.p177mm.protocal.protobuf.C46583rq;
import com.tencent.p177mm.protocal.protobuf.btc;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.pluginsdk.g.a.a.m */
public final class C44796m extends C44047n {
    /* Access modifiers changed, original: protected|final */
    public final String getTag() {
        return "MicroMsg.ResDownloader.CheckResUpdate.NetSceneCheckResUpdate";
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: i */
    public final C40567rr mo69735i(C1929q c1929q) {
        return (C40567rr) ((C7472b) c1929q).fsH.fsP;
    }

    public C44796m(int i) {
        AppMethodBeat.m2504i(79556);
        C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdate.NetSceneCheckResUpdate", "NetSceneCheckResUpdate init, resType:%d", Integer.valueOf(i));
        btc btc = new btc();
        btc.jCt = i;
        this.veO.clear();
        this.veO.add(btc);
        AppMethodBeat.m2505o(79556);
    }

    /* Access modifiers changed, original: protected|final */
    public final C1929q diq() {
        AppMethodBeat.m2504i(79557);
        C1196a c1196a = new C1196a();
        C46583rq c46583rq = new C46583rq();
        c46583rq.vYX.addAll(this.veO);
        c1196a.fsJ = c46583rq;
        c1196a.fsK = new C40567rr();
        c1196a.uri = "/cgi-bin/micromsg-bin/checkresupdate";
        c1196a.fsI = 721;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        C7472b acD = c1196a.acD();
        AppMethodBeat.m2505o(79557);
        return acD;
    }

    public final int getType() {
        return 721;
    }
}
