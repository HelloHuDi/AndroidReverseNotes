package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bw;
import com.tencent.mm.protocal.protobuf.bx;

public final class g extends m implements k {
    private f eIc;
    public final b ehh;

    public g(String str, String str2, byte[] bArr) {
        AppMethodBeat.i(6582);
        a aVar = new a();
        aVar.fsJ = new bw();
        aVar.fsK = new bx();
        aVar.uri = "/cgi-bin/mmbiz-bin/oauth_addavatar";
        this.ehh = aVar.acD();
        bw bwVar = (bw) this.ehh.fsG.fsP;
        bwVar.csB = str;
        bwVar.nickname = str2;
        bwVar.vEc = new com.tencent.mm.bt.b(bArr);
        bwVar.vEd = 0;
        AppMethodBeat.o(6582);
    }

    public g(String str, String str2, String str3) {
        AppMethodBeat.i(6583);
        a aVar = new a();
        aVar.fsJ = new bw();
        aVar.fsK = new bx();
        aVar.uri = "/cgi-bin/mmbiz-bin/oauth_addavatar";
        this.ehh = aVar.acD();
        bw bwVar = (bw) this.ehh.fsG.fsP;
        bwVar.csB = str;
        bwVar.nickname = str2;
        bwVar.fileid = str3;
        bwVar.vEd = 1;
        AppMethodBeat.o(6583);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(6584);
        this.eIc.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(6584);
    }

    public final int getType() {
        return 2500;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(6585);
        this.eIc = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(6585);
        return a;
    }
}
