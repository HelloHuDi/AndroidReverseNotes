package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.azi;
import com.tencent.mm.protocal.protobuf.azj;
import com.tencent.mm.sdk.platformtools.ab;

public final class j extends m implements k {
    String appId;
    private f eIc;
    final b ehh;
    String hep;

    public j(String str, String str2) {
        AppMethodBeat.i(6592);
        this.appId = str;
        this.hep = str2;
        a aVar = new a();
        aVar.fsJ = new azi();
        aVar.fsK = new azj();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/mmbizjsapi_downloadcdninfo";
        this.ehh = aVar.acD();
        azi azi = (azi) this.ehh.fsG.fsP;
        azi.csB = str;
        azi.wDu = str2;
        ab.i("MicroMsg.NetSceneDownloadCdnInfo", "download cdn info, appid : %s, mediaId : %s", str, str2);
        AppMethodBeat.o(6592);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(6593);
        ab.i("MicroMsg.NetSceneDownloadCdnInfo", "onGYNetEnd, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.eIc.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(6593);
    }

    public final int getType() {
        return 1035;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(6594);
        this.eIc = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(6594);
        return a;
    }
}
