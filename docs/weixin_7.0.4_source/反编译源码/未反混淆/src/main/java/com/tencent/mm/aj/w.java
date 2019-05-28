package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aww;
import com.tencent.mm.protocal.protobuf.awx;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class w extends m implements k {
    public b ehh;
    private f ehi;
    public String fwO;
    public int fwP;
    public String tag;

    public w(String str, LinkedList<String> linkedList) {
        this(str, linkedList, (byte) 0);
    }

    private w(String str, LinkedList<String> linkedList, byte b) {
        AppMethodBeat.i(11455);
        this.fwP = 1;
        a aVar = new a();
        aVar.fsJ = new aww();
        aVar.fsK = new awx();
        aVar.uri = "/cgi-bin/mmkf-bin/kfgetinfolist";
        aVar.fsI = 675;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        aww aww = (aww) this.ehh.fsG.fsP;
        aww.wAZ = str;
        aww.wBc = linkedList;
        this.fwO = str;
        this.fwP = 1;
        AppMethodBeat.o(11455);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(11456);
        ab.i("MicroMsg.NetSceneKFGetInfoList", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(11456);
    }

    public final int getType() {
        return 675;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(11457);
        this.ehi = fVar;
        ab.i("MicroMsg.NetSceneKFGetInfoList", "do scene");
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(11457);
        return a;
    }

    public final awx aeO() {
        if (this.ehh == null || this.ehh.fsH.fsP == null) {
            return null;
        }
        return (awx) this.ehh.fsH.fsP;
    }
}
