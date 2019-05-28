package com.tencent.mm.plugin.subapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bfs;
import com.tencent.mm.protocal.protobuf.bft;
import com.tencent.mm.protocal.protobuf.coc;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.util.LinkedList;

public final class a extends m implements k {
    private b ehh;
    private f ehi;

    public a(LinkedList<coc> linkedList, int i) {
        AppMethodBeat.i(25247);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new bfs();
        aVar.fsK = new bft();
        aVar.uri = "/cgi-bin/micromsg-bin/opvoicereminder";
        aVar.fsI = ErrorCode.ERROR_QBSDK_INIT_ERROR_EMPTY_BUNDLE;
        this.ehh = aVar.acD();
        bfs bfs = (bfs) this.ehh.fsG.fsP;
        bfs.OpCode = 1;
        bfs.wJz = linkedList;
        bfs.wJy = i;
        AppMethodBeat.o(25247);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(25248);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(25248);
        return a;
    }

    public final int getType() {
        return ErrorCode.ERROR_QBSDK_INIT_ERROR_EMPTY_BUNDLE;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(25249);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(25249);
    }
}
