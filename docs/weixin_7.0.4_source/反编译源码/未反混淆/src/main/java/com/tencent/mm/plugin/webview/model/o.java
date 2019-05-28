package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ane;
import com.tencent.mm.protocal.protobuf.anf;
import com.tencent.mm.sdk.platformtools.ab;

public final class o extends m implements k {
    private f eIc;
    public final b ehh;
    public Object tag;

    public o(String str, String str2, int i, int i2) {
        AppMethodBeat.i(6607);
        ab.d("MicroMsg.NetSceneGetReadingModeInfoProxy", "NetSceneSetOAuthScope doScene url[%s], userAgent[%s], width[%d], height[%d]", str, str2, Integer.valueOf(i), Integer.valueOf(i2));
        a aVar = new a();
        aVar.fsJ = new ane();
        aVar.fsK = new anf();
        aVar.uri = "/cgi-bin/micromsg-bin/getreadingmodeinfo";
        this.ehh = aVar.acD();
        ane ane = (ane) this.ehh.fsG.fsP;
        ane.URL = str;
        ane.wrL = str2;
        ane.Width = i;
        ane.Height = i2;
        AppMethodBeat.o(6607);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(6608);
        ab.i("MicroMsg.NetSceneGetReadingModeInfoProxy", "errType = " + i2 + ", errCode = " + i3);
        this.eIc.onSceneEnd(i2, i3, str, this);
        if (i2 == 0 && i3 == 0) {
            AppMethodBeat.o(6608);
            return;
        }
        ab.e("MicroMsg.NetSceneGetReadingModeInfoProxy", "errType = " + i2 + ", errCode = " + i3);
        AppMethodBeat.o(6608);
    }

    public final int getType() {
        return 673;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(6609);
        ab.i("MicroMsg.NetSceneGetReadingModeInfoProxy", "doScene");
        this.eIc = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(6609);
        return a;
    }
}
