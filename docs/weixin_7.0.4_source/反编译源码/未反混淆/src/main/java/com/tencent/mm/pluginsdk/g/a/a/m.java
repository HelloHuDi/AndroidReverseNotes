package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.btc;
import com.tencent.mm.protocal.protobuf.rq;
import com.tencent.mm.protocal.protobuf.rr;
import com.tencent.mm.sdk.platformtools.ab;

public final class m extends n {
    /* Access modifiers changed, original: protected|final */
    public final String getTag() {
        return "MicroMsg.ResDownloader.CheckResUpdate.NetSceneCheckResUpdate";
    }

    /* Access modifiers changed, original: protected|final */
    public final rr i(q qVar) {
        return (rr) ((b) qVar).fsH.fsP;
    }

    public m(int i) {
        AppMethodBeat.i(79556);
        ab.i("MicroMsg.ResDownloader.CheckResUpdate.NetSceneCheckResUpdate", "NetSceneCheckResUpdate init, resType:%d", Integer.valueOf(i));
        btc btc = new btc();
        btc.jCt = i;
        this.veO.clear();
        this.veO.add(btc);
        AppMethodBeat.o(79556);
    }

    /* Access modifiers changed, original: protected|final */
    public final q diq() {
        AppMethodBeat.i(79557);
        a aVar = new a();
        rq rqVar = new rq();
        rqVar.vYX.addAll(this.veO);
        aVar.fsJ = rqVar;
        aVar.fsK = new rr();
        aVar.uri = "/cgi-bin/micromsg-bin/checkresupdate";
        aVar.fsI = 721;
        aVar.fsL = 0;
        aVar.fsM = 0;
        b acD = aVar.acD();
        AppMethodBeat.o(79557);
        return acD;
    }

    public final int getType() {
        return 721;
    }
}
