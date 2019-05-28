package com.tencent.mm.plugin.account.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.jg;
import com.tencent.mm.protocal.protobuf.jh;

public final class d extends m implements k {
    public static int gyK = 1;
    public static int gyL = 2;
    private b ehh;
    private f ehi;

    public d(int i, String str) {
        AppMethodBeat.i(124676);
        a aVar = new a();
        aVar.fsJ = new jg();
        aVar.fsK = new jh();
        aVar.uri = "/cgi-bin/micromsg-bin/bindemail";
        this.ehh = aVar.acD();
        jg jgVar = (jg) this.ehh.fsG.fsP;
        jgVar.OpCode = i;
        jgVar.vLe = str;
        AppMethodBeat.o(124676);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(124677);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(124677);
        return a;
    }

    public final int getType() {
        return 256;
    }

    public final int Ah() {
        return ((jg) this.ehh.fsG.fsP).OpCode;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(124678);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(124678);
    }
}
