package com.tencent.mm.plugin.wenote.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.abd;
import com.tencent.mm.protocal.protobuf.abj;
import com.tencent.mm.protocal.protobuf.abk;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class b extends m implements k {
    private final com.tencent.mm.ai.b ehh;
    private f ehi = null;
    public int uMF = 1;
    private String uMG = "";
    private abd uMH = null;
    private LinkedList<abd> uMI = new LinkedList();
    public int uMJ = 0;

    public b(int i, int i2, String str, LinkedList<abd> linkedList, abd abd) {
        AppMethodBeat.i(26595);
        this.uMI = linkedList;
        this.uMH = abd;
        this.uMG = str;
        this.uMF = i2;
        this.uMJ = i;
        a aVar = new a();
        aVar.fsJ = new abj();
        aVar.fsK = new abk();
        aVar.uri = "/cgi-bin/micromsg-bin/favsecurity ";
        aVar.fsI = 921;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        AppMethodBeat.o(26595);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(26596);
        abj abj = (abj) this.ehh.fsG.fsP;
        abj.nbk = this.uMF;
        abj.wiA = this.uMH;
        abj.wiz = this.uMI;
        abj.wdK = this.uMG;
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(26596);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(26597);
        ab.i("MicroMsg.NetSceneCheckNoteSecurity", "netId %d errType %d errCode %d errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        abk abk = (abk) ((com.tencent.mm.ai.b) qVar).fsH.fsP;
        if (i2 != 0) {
            ab.i("MicroMsg.NetSceneCheckNoteSecurity", "NetSceneCheckNoteSecurity,errType:%d,fail", Integer.valueOf(i2));
            this.ehi.onSceneEnd(i2, -1, str, this);
            AppMethodBeat.o(26597);
        } else if (abk == null || abk.getBaseResponse() == null) {
            ab.i("MicroMsg.NetSceneCheckNoteSecurity", "NetSceneCheckNoteSecurity,response == null,ok");
            this.ehi.onSceneEnd(i2, 0, str, this);
            AppMethodBeat.o(26597);
        } else if (abk.getBaseResponse().Ret != 0) {
            ab.i("MicroMsg.NetSceneCheckNoteSecurity", "NetSceneCheckNoteSecurity,baseresponse.ret != 0,ok");
            this.ehi.onSceneEnd(i2, 0, str, this);
            AppMethodBeat.o(26597);
        } else if (abk.wiB > 0) {
            ab.i("MicroMsg.NetSceneCheckNoteSecurity", "NetSceneCheckNoteSecurity,SecurityResult > 0,fail");
            this.ehi.onSceneEnd(i2, -1, str, this);
            AppMethodBeat.o(26597);
        } else {
            ab.i("MicroMsg.NetSceneCheckNoteSecurity", "NetSceneCheckNoteSecurity,SecurityResult = 0,fail");
            this.ehi.onSceneEnd(i2, 0, str, this);
            AppMethodBeat.o(26597);
        }
    }

    public final com.tencent.mm.ai.m.b b(q qVar) {
        return com.tencent.mm.ai.m.b.EOk;
    }

    public final int getType() {
        return 921;
    }
}
