package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.c.b;
import com.tencent.mm.protocal.protobuf.avf;
import com.tencent.mm.protocal.protobuf.avs;
import com.tencent.mm.protocal.protobuf.avt;
import com.tencent.mm.protocal.protobuf.awg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.LinkedList;

public final class t extends m implements k, b {
    private f eIc;
    public final com.tencent.mm.ai.b ehh;
    private final int ulX;
    public avf ulY;

    public t(avf avf, String str, String str2, String str3, String str4, String str5, String str6, String str7, com.tencent.mm.bt.b bVar, int i, LinkedList<awg> linkedList, int i2) {
        AppMethodBeat.i(6622);
        ab.i("MicroMsg.webview.NetSceneJSAPISetAuth", "NetSceneJSAPISetAuth doScene url[%s], appid[%s], jsapiName[%s], [%s], [%s], [%s], [%s], [%s]", str, str2, str3, str4, str5, str6, str7, Integer.valueOf(i));
        this.ulY = avf;
        this.ulX = i2;
        a aVar = new a();
        aVar.fsJ = new avs();
        aVar.fsK = new avt();
        aVar.uri = "/cgi-bin/mmbiz-bin/jsapi-setauth";
        aVar.fsI = FilterEnum4Shaka.MIC_WEISHI_v4_4_LAODIANYING;
        this.ehh = aVar.acD();
        avs avs = (avs) this.ehh.fsG.fsP;
        avs.url = str;
        avs.csB = str2;
        avs.wzd = str3;
        avs.cvO = str4;
        avs.wzf = str5;
        avs.signature = str6;
        avs.wzg = str7;
        avs.wzi = i;
        avs.wzh = bVar;
        avs.wzm = linkedList;
        AppMethodBeat.o(6622);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(6623);
        ab.i("MicroMsg.webview.NetSceneJSAPISetAuth", "errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.eIc.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(6623);
    }

    public final int getType() {
        return FilterEnum4Shaka.MIC_WEISHI_v4_4_LAODIANYING;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(6624);
        ab.i("MicroMsg.webview.NetSceneJSAPISetAuth", "doScene");
        this.eIc = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(6624);
        return a;
    }

    public final int cXz() {
        return this.ulX;
    }
}
