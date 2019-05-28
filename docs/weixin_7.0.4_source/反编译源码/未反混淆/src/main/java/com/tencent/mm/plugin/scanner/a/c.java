package com.tencent.mm.plugin.scanner.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.kn;
import com.tencent.mm.protocal.protobuf.ko;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.LinkedList;

public final class c extends m implements k {
    public b ehh;
    private f ehi;

    public c(String str, LinkedList<String> linkedList, int i, String str2, double d, double d2) {
        AppMethodBeat.i(80831);
        a aVar = new a();
        aVar.fsJ = new kn();
        aVar.fsK = new ko();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscangetactioninfo";
        aVar.fsI = FilterEnum4Shaka.MIC_WEISHI_HUANGDAN;
        this.ehh = aVar.acD();
        kn knVar = (kn) this.ehh.fsG.fsP;
        knVar.ProductID = str;
        knVar.Scene = i;
        knVar.vNG = str2;
        knVar.vNF = linkedList;
        knVar.vNI = d2;
        knVar.vNH = d;
        AppMethodBeat.o(80831);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(80832);
        ab.i("MicroMsg.NetSceneGetActionInfo", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(80832);
    }

    public final int getType() {
        return FilterEnum4Shaka.MIC_WEISHI_HUANGDAN;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(80833);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(80833);
        return a;
    }
}
