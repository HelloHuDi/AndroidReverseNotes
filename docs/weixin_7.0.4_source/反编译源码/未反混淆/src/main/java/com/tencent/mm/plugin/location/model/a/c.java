package com.tencent.mm.plugin.location.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bqt;
import com.tencent.mm.protocal.protobuf.bqu;
import com.tencent.mm.protocal.protobuf.cie;
import com.tencent.mm.protocal.protobuf.cmj;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c extends m implements k {
    public final b ehh;
    private f ehi;
    private Runnable fPK;
    public String hwA;
    public int nLb;
    public cie nLc = null;
    public List<cmj> nLd = null;
    public bqu nLe;
    public int nLf;
    private String nLg;

    public c(String str, int i, cmj cmj, int i2, cie cie) {
        AppMethodBeat.i(113415);
        a aVar = new a();
        aVar.fsJ = new bqt();
        aVar.fsK = new bqu();
        aVar.uri = "/cgi-bin/micromsg-bin/refreshtrackroom";
        aVar.fsI = com.tencent.mm.plugin.appbrand.jsapi.g.f.CTRL_INDEX;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        bqt bqt = (bqt) this.ehh.fsG.fsP;
        bqt.weu = str;
        bqt.jCt = i;
        bqt.wTf = cmj;
        bqt.nbj = i2;
        bqt.wTg = cie;
        this.nLg = str;
        this.nLf = bqt.jCt;
        ab.d("MicroMsg.NetSceneRefreshTrackRoom", "userPosiItem " + cmj.vHl + " " + cmj.xkm.vNI + " " + cmj.xkm.vNH + " heading:" + cmj.xkm.wNP);
        ab.d("MicroMsg.NetSceneRefreshTrackRoom", "userPoi " + cie.vNI + " " + cie.vNH + " " + cie.Name);
        ab.d("MicroMsg.NetSceneRefreshTrackRoom", "trackRoomId:" + str + " uploadStatus:" + i);
        AppMethodBeat.o(113415);
    }

    public final int getType() {
        return com.tencent.mm.plugin.appbrand.jsapi.g.f.CTRL_INDEX;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(113416);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(113416);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(113417);
        this.nLe = (bqu) ((b) qVar).fsH.fsP;
        if (this.nLe != null) {
            this.hwA = this.nLe.vKq;
        }
        if (i2 == 0 && i3 == 0) {
            this.nLb = this.nLe.wBg;
            this.nLc = this.nLe.wTi;
            this.nLd = this.nLe.wTh;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(String.format("[ resp count %d ] ", new Object[]{Integer.valueOf(this.nLe.jBv)}));
            if (this.nLc != null) {
                stringBuffer.append(String.format("[ roomPoi  %f %f %s] ", new Object[]{Double.valueOf(this.nLc.vNI), Double.valueOf(this.nLc.vNH), this.nLc.Name}));
            }
            ab.d("MicroMsg.NetSceneRefreshTrackRoom", "onGynetEnd " + stringBuffer.toString());
            LinkedList linkedList = new LinkedList();
            Iterator it = this.nLe.wTh.iterator();
            while (it.hasNext()) {
                cmj cmj = (cmj) it.next();
                if (cmj == null) {
                    linkedList.add(cmj);
                } else {
                    if (cmj.xkm == null) {
                        linkedList.add(cmj);
                    }
                    if (Math.abs(cmj.xkm.vNH) > 180.0d || Math.abs(cmj.xkm.vNI) > 90.0d) {
                        ab.w("MicroMsg.NetSceneRefreshTrackRoom", "server lat lng invalid %s %f %f %f", cmj.vHl, Double.valueOf(cmj.xkm.vNI), Double.valueOf(cmj.xkm.vNH), Double.valueOf(cmj.xkm.wNP));
                        linkedList.add(cmj);
                    }
                }
            }
            this.nLe.jBv = this.nLe.wTh.size();
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        if (this.fPK != null) {
            this.fPK.run();
        }
        AppMethodBeat.o(113417);
    }
}
