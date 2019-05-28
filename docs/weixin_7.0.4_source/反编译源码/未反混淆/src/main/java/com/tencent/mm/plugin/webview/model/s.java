package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.c.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.c.b;
import com.tencent.mm.protocal.protobuf.avq;
import com.tencent.mm.protocal.protobuf.avr;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.FilterEnum4Shaka;

public final class s extends m implements k, b {
    private f eIc;
    private final com.tencent.mm.ai.b ehh;
    public a ulV;
    private final int ulX;

    public s(a aVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, byte[] bArr, int i) {
        AppMethodBeat.i(6619);
        ab.i("MicroMsg.webview.NetSceneJSAPIRealtimeVerify", "NetSceneJSAPIRealtimeVerify doScene url[%s], appid[%s], jsapiName[%s], [%s], [%s], [%s], [%s]", str, str2, str3, str4, str5, str6, str7);
        this.ulV = aVar;
        this.ulX = i;
        com.tencent.mm.ai.b.a aVar2 = new com.tencent.mm.ai.b.a();
        aVar2.fsJ = new avq();
        aVar2.fsK = new avr();
        aVar2.uri = "/cgi-bin/mmbiz-bin/jsapi-realtimeverify";
        aVar2.fsI = FilterEnum4Shaka.MIC_WEISHI_v4_4_CHENGJING;
        this.ehh = aVar2.acD();
        avq avq = (avq) this.ehh.fsG.fsP;
        avq.url = str;
        avq.csB = str2;
        avq.wzd = str3;
        avq.cvO = str4;
        avq.wzf = str5;
        avq.signature = str6;
        avq.wzg = str7;
        avq.wzh = com.tencent.mm.bt.b.bI(bArr);
        AppMethodBeat.o(6619);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(6620);
        ab.i("MicroMsg.webview.NetSceneJSAPIRealtimeVerify", "errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.eIc.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(6620);
    }

    public final int getType() {
        return FilterEnum4Shaka.MIC_WEISHI_v4_4_CHENGJING;
    }

    public final avr cXB() {
        if (this.ehh == null) {
            return null;
        }
        return (avr) this.ehh.fsH.fsP;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(6621);
        ab.i("MicroMsg.webview.NetSceneJSAPIRealtimeVerify", "doScene");
        this.eIc = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(6621);
        return a;
    }

    public final int cXz() {
        return this.ulX;
    }
}
