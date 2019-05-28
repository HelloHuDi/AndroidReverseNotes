package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bun;
import com.tencent.mm.protocal.protobuf.buo;

public final class aa extends m implements k {
    private f eIc;
    public final b ehh;

    public aa(String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(6643);
        a aVar = new a();
        aVar.fsJ = new bun();
        aVar.fsK = new buo();
        aVar.uri = "/cgi-bin/mmbiz-bin/sdk_oauth_authorize";
        this.ehh = aVar.acD();
        bun bun = (bun) this.ehh.fsG.fsP;
        bun.csB = str;
        bun.scope = str2;
        bun.state = str3;
        bun.wWd = str4;
        bun.wWe = str5;
        AppMethodBeat.o(6643);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(6644);
        this.eIc.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(6644);
    }

    public final int getType() {
        return 1388;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(6645);
        this.eIc = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(6645);
        return a;
    }
}
