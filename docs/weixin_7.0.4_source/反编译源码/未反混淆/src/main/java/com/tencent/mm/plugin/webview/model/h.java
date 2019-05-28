package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bu;
import com.tencent.mm.protocal.protobuf.bv;
import com.tencent.mm.sdk.platformtools.ab;

public final class h extends m implements k {
    private f eIc;
    public final b ehh;
    public String mnu;

    public h(String str, String str2, String str3) {
        AppMethodBeat.i(6586);
        this.mnu = str3;
        a aVar = new a();
        aVar.fsJ = new bu();
        aVar.fsK = new bv();
        aVar.uri = "/cgi-bin/mmbiz-bin/oauth_addavatarheadimg";
        this.ehh = aVar.acD();
        bu buVar = (bu) this.ehh.fsG.fsP;
        buVar.vEb = str;
        buVar.csB = str2;
        AppMethodBeat.o(6586);
    }

    public final int getType() {
        return 2667;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(6587);
        this.eIc = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(6587);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(6588);
        ab.i("MicroMsg.NetSceneCreateAvatar", "NetSceneCreateAvatar:  netId = %d, errType = %d,errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.eIc != null) {
            this.eIc.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(6588);
    }
}
