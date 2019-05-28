package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.als;
import com.tencent.mm.protocal.protobuf.alt;
import com.tencent.mm.protocal.protobuf.bhu;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class h extends m implements k {
    public String aIm;
    public int czE;
    public boolean eTf = false;
    public final b ehh;
    private f ehi;
    public int errCode;
    public int errType;
    private Runnable fPK;
    public String hlm;
    public List<com.tencent.mm.plugin.location.ui.impl.f> list = new ArrayList();
    public byte[] nJH;
    public byte[] nJI = null;
    public String nJJ = "";
    public int nJK;

    public h(byte[] bArr, double d, double d2, int i, int i2, double d3, double d4, String str, String str2, boolean z) {
        AppMethodBeat.i(113315);
        a aVar = new a();
        aVar.fsJ = new als();
        aVar.fsK = new alt();
        aVar.fsK = new alt();
        aVar.uri = "/cgi-bin/micromsg-bin/getpoilist";
        aVar.fsI = 457;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        als als = (als) this.ehh.fsG.fsP;
        als.wpP = bArr == null ? new SKBuiltinBuffer_t() : new SKBuiltinBuffer_t().setBuffer(bArr);
        als.wkD = str2;
        als.vNI = d;
        als.vNH = d2;
        als.Scene = i;
        als.OpCode = i2;
        als.wqT = d4;
        als.wqS = d3;
        als.wpR = z ? 1 : 0;
        this.czE = als.OpCode;
        this.nJJ = str;
        this.nJH = bArr;
        ab.i("MicroMsg.NetSceneGetPoiList", "lat %f lng %f scene %d opcode %d oriLat %f oriLng %f isAutuQuery %s".concat(String.valueOf(bArr)), Double.valueOf(d), Double.valueOf(d2), Integer.valueOf(i), Integer.valueOf(i2), Double.valueOf(d4), Double.valueOf(d3), Boolean.valueOf(z));
        AppMethodBeat.o(113315);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(113316);
        ab.d("MicroMsg.NetSceneGetPoiList", "scene done");
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(113316);
        return a;
    }

    public final int getType() {
        return 457;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(113317);
        ab.d("MicroMsg.NetSceneGetPoiList", "onGYNetEnd  errType:" + i2 + " errCode:" + i3 + "errMsg:" + str);
        this.errType = i2;
        this.errCode = i3;
        this.aIm = str;
        alt alt = (alt) this.ehh.fsH.fsP;
        this.list.clear();
        ab.d("MicroMsg.NetSceneGetPoiList", "url " + alt.wpY + " " + alt.wdK + " " + alt.Url + " " + alt.vQg);
        ab.d("MicroMsg.NetSceneGetPoiList", "autoInterval: %d", Integer.valueOf(alt.wpZ));
        this.hlm = alt.vQg;
        this.nJK = alt.wpZ;
        if (alt.wqV != null) {
            ab.d("MicroMsg.NetSceneGetPoiList", "poi result %d ", Integer.valueOf(alt.wqV.size()));
            if (alt.wqV.size() > 0) {
                ab.d("MicroMsg.NetSceneGetPoiList", "addr %s, province %s, street %s, city %s", ((bhu) alt.wqV.get(0)).wKW, ((bhu) alt.wqV.get(0)).guO, ((bhu) alt.wqV.get(0)).wcm, ((bhu) alt.wqV.get(0)).guP);
            }
            Iterator it = alt.wqV.iterator();
            while (it.hasNext()) {
                this.list.add(new com.tencent.mm.plugin.location.ui.impl.f((bhu) it.next(), this.hlm));
            }
        }
        if (alt.wpP != null) {
            this.nJI = aa.a(alt.wpP);
        }
        this.eTf = alt.wqW == 1;
        this.ehi.onSceneEnd(i2, i3, str, this);
        if (this.fPK != null) {
            this.fPK.run();
        }
        AppMethodBeat.o(113317);
    }

    public final boolean isFirst() {
        return this.nJH == null;
    }
}
