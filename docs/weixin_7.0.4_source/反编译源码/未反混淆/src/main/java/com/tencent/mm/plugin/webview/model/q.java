package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.c.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.c.b;
import com.tencent.mm.protocal.protobuf.avg;
import com.tencent.mm.protocal.protobuf.avh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.FilterEnum4Shaka;

public final class q extends m implements k, b {
    private f eIc;
    private final com.tencent.mm.ai.b ehh;
    public a ulV;
    public String ulW;
    private final int ulX;
    public String url;

    public q(a aVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, byte[] bArr, int i, String str8, int i2) {
        AppMethodBeat.i(6613);
        ab.i("MicroMsg.webview.NetSceneJSAPIAuth", "NetSceneJSAPIAuth doScene appid[%s], jsapiName[%s], [%s], [%s], [%s], [%s], [%s], [%s]", str2, str3, str4, str5, str6, str7, Integer.valueOf(i), str8);
        this.ulV = aVar;
        this.ulW = str3;
        this.url = str;
        this.ulX = i2;
        com.tencent.mm.ai.b.a aVar2 = new com.tencent.mm.ai.b.a();
        aVar2.fsJ = new avg();
        aVar2.fsK = new avh();
        aVar2.uri = "/cgi-bin/mmbiz-bin/jsapi-auth";
        aVar2.fsI = FilterEnum4Shaka.MIC_WEISHI_v4_4_LIANKONG;
        this.ehh = aVar2.acD();
        avg avg = (avg) this.ehh.fsG.fsP;
        avg.url = str;
        avg.mZr = str2;
        avg.wzd = str3;
        avg.cvO = str4;
        avg.wzf = str5;
        avg.signature = str6;
        avg.wzg = str7;
        avg.wzh = com.tencent.mm.bt.b.bI(bArr);
        avg.wzi = i;
        avg.scope = str8;
        AppMethodBeat.o(6613);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        AppMethodBeat.i(6614);
        ab.i("MicroMsg.webview.NetSceneJSAPIAuth", "errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.eIc.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(6614);
    }

    public final int getType() {
        return FilterEnum4Shaka.MIC_WEISHI_v4_4_LIANKONG;
    }

    public final avg cXx() {
        if (this.ehh == null) {
            return null;
        }
        return (avg) this.ehh.fsG.fsP;
    }

    public final avh cXy() {
        if (this.ehh == null) {
            return null;
        }
        return (avh) this.ehh.fsH.fsP;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(6615);
        ab.i("MicroMsg.webview.NetSceneJSAPIAuth", "doScene");
        this.eIc = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(6615);
        return a;
    }

    public final int cXz() {
        return this.ulX;
    }
}
