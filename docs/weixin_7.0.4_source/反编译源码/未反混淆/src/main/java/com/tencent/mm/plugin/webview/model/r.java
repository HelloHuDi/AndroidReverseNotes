package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.c.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.c.b;
import com.tencent.mm.protocal.protobuf.avo;
import com.tencent.mm.protocal.protobuf.avp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.LinkedList;

public final class r extends m implements k, b {
    private f eIc;
    public final com.tencent.mm.ai.b ehh;
    public String iCz;
    public a ulV;
    private final int ulX;

    public r(a aVar, String str, String str2, LinkedList<String> linkedList, String str3, String str4, String str5, String str6, int i, String str7, int i2) {
        AppMethodBeat.i(6616);
        ab.i("MicroMsg.webview.NetSceneJSAPIPreVerify", "NetSceneJSAPIPreVerify doScene url[%s], appid[%s], [%s], [%s], [%s], [%s]", str, str2, str3, str4, str5, str6);
        this.ulV = aVar;
        this.iCz = str;
        this.ulX = i2;
        com.tencent.mm.ai.b.a aVar2 = new com.tencent.mm.ai.b.a();
        aVar2.fsJ = new avo();
        aVar2.fsK = new avp();
        aVar2.uri = "/cgi-bin/mmbiz-bin/jsapi-preverify";
        aVar2.fsI = FilterEnum4Shaka.MIC_WEISHI_v4_4_HEIBAI;
        this.ehh = aVar2.acD();
        avo avo = (avo) this.ehh.fsG.fsP;
        avo.url = str;
        avo.csB = str2;
        avo.wzx = linkedList;
        avo.cvO = str3;
        avo.wzf = str4;
        avo.signature = str5;
        avo.wzg = str6;
        avo.scene = i;
        avo.wzy = str7;
        AppMethodBeat.o(6616);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(6617);
        ab.i("MicroMsg.webview.NetSceneJSAPIPreVerify", "errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.eIc.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(6617);
    }

    public final int getType() {
        return FilterEnum4Shaka.MIC_WEISHI_v4_4_HEIBAI;
    }

    public final avp cXA() {
        if (this.ehh == null) {
            return null;
        }
        return (avp) this.ehh.fsH.fsP;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(6618);
        ab.i("MicroMsg.webview.NetSceneJSAPIPreVerify", "doScene");
        this.eIc = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(6618);
        return a;
    }

    public final int cXz() {
        return this.ulX;
    }
}
