package com.tencent.mm.plugin.talkroom.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cgl;
import com.tencent.mm.protocal.protobuf.cgm;
import com.tencent.mm.protocal.protobuf.ym;
import com.tencent.mm.protocal.protobuf.yn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.util.Iterator;
import java.util.LinkedList;

public final class a extends f {
    private final b ehh;
    private f ehi;
    private final String nNq;
    public int nwu;
    public long nwv;
    private int sceneType = 0;
    public int syE;
    public int syF;
    public LinkedList<cgl> syH;
    public LinkedList<cgm> sza;

    public a(String str, int i) {
        AppMethodBeat.i(25867);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        this.sceneType = i;
        aVar.fsJ = new ym();
        aVar.fsK = new yn();
        aVar.uri = "/cgi-bin/micromsg-bin/entertalkroom";
        aVar.fsI = 332;
        aVar.fsL = ErrorCode.NEEDDOWNLOAD_8;
        aVar.fsM = 1000000147;
        this.ehh = aVar.acD();
        ((ym) this.ehh.fsG.fsP).wel = str;
        ((ym) this.ehh.fsG.fsP).Scene = i;
        this.nNq = str;
        AppMethodBeat.o(25867);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(25868);
        ab.d("MicroMsg.NetSceneEnterTalkRoom", "doScene %d", Integer.valueOf(this.sceneType));
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(25868);
        return a;
    }

    public final int getType() {
        return 332;
    }

    public final String cED() {
        return this.nNq;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(25869);
        ab.d("MicroMsg.NetSceneEnterTalkRoom", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            yn ynVar = (yn) this.ehh.fsH.fsP;
            ab.i("MicroMsg.NetSceneEnterTalkRoom", "resp %s", ynVar.toString());
            this.nwu = ynVar.wem;
            this.nwv = ynVar.wen;
            this.syE = ynVar.weo;
            this.syF = ynVar.weq;
            this.sza = as(ynVar.vEh);
            this.syH = at(ynVar.vIO);
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(25869);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(25869);
    }

    private static LinkedList<cgm> as(LinkedList<cgm> linkedList) {
        AppMethodBeat.i(25870);
        LinkedList linkedList2 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            cgm cgm = (cgm) it.next();
            if (!bo.isNullOrNil(cgm.jBB)) {
                linkedList2.add(cgm);
            }
        }
        AppMethodBeat.o(25870);
        return linkedList2;
    }

    private static LinkedList<cgl> at(LinkedList<cgl> linkedList) {
        AppMethodBeat.i(25871);
        LinkedList linkedList2 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            linkedList2.add((cgl) it.next());
        }
        AppMethodBeat.o(25871);
        return linkedList2;
    }

    public final int cEE() {
        return this.sceneType;
    }
}
