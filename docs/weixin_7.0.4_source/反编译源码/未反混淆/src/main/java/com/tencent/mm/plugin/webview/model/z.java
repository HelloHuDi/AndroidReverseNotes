package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bmy;
import com.tencent.mm.protocal.protobuf.bmz;
import java.util.LinkedList;

public final class z extends m implements k {
    private f eIc;
    private final b ehh;

    public z(int i, String str, LinkedList<String> linkedList, int i2) {
        AppMethodBeat.i(6640);
        a aVar = new a();
        aVar.fsJ = new bmy();
        aVar.fsK = new bmz();
        aVar.uri = "/cgi-bin/mmbiz-bin/qrconnect_authorize_confirm";
        this.ehh = aVar.acD();
        bmy bmy = (bmy) this.ehh.fsG.fsP;
        bmy.wII = i;
        bmy.wIH = str;
        bmy.wIJ = linkedList;
        bmy.wcA = i2;
        AppMethodBeat.o(6640);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(6641);
        this.eIc.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(6641);
    }

    public final int getType() {
        return 1137;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(6642);
        this.eIc = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(6642);
        return a;
    }
}
