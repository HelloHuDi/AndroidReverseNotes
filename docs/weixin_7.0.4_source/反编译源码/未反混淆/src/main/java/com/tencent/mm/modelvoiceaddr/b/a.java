package com.tencent.mm.modelvoiceaddr.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bsm;
import com.tencent.mm.protocal.protobuf.bsn;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class a extends m implements k {
    private b ehh;
    private f ehi;

    public a(int i, LinkedList<bts> linkedList, bts bts, bts bts2) {
        AppMethodBeat.i(116796);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new bsm();
        aVar.fsK = new bsn();
        aVar.uri = "/cgi-bin/micromsg-bin/reportvoiceresult";
        this.ehh = aVar.acD();
        bsm bsm = (bsm) this.ehh.fsG.fsP;
        bsm.wUF = i;
        bsm.wUG = linkedList;
        bsm.wUH = bts;
        bsm.wUI = bts2;
        AppMethodBeat.o(116796);
    }

    public final int getType() {
        return 228;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(116797);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(116797);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(116798);
        ab.d("MicroMsg.NetSceneNewVoiceInputReport", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(116798);
    }
}
