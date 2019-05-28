package com.tencent.mm.plugin.topstory.a.c;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.chr;
import com.tencent.mm.protocal.protobuf.chs;
import com.tencent.mm.protocal.protobuf.chw;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class i extends m implements k {
    public b ehh;
    private f ehi;
    public chw sAX;
    private long sAZ = System.currentTimeMillis();

    public i(JSONObject jSONObject) {
        AppMethodBeat.i(65514);
        a aVar = new a();
        aVar.fsI = 2802;
        aVar.uri = "/cgi-bin/mmsearch-bin/topstorypluginsetcomment";
        aVar.fsJ = new chr();
        aVar.fsK = new chs();
        this.ehh = aVar.acD();
        chr chr = (chr) this.ehh.fsG.fsP;
        chr.wUo = jSONObject.optString("docId", "");
        chr.xgx = jSONObject.optString("commentId", "");
        chr.nbk = jSONObject.optInt("opType", 0);
        chr.xgs = jSONObject.optString("requestId", "");
        chr.ncM = jSONObject.optString(FirebaseAnalytics.b.CONTENT, "");
        chr.Scene = jSONObject.optInt("scene", 0);
        chr.wDM = jSONObject.optString("searchId", "");
        chr.vGB = jSONObject.optInt("subScene", 0);
        chr.wbI = jSONObject.optString("vid", "");
        chr.xgw = jSONObject.optString("byPass", "");
        chr.vFH = 0;
        ab.i("MicroMsg.TopStory.NetSceneTopStorySetComment", "TopStoryPluginSetCommentRequest %s, %s, %s, %s, %s, %s, %s, %s, %s, %s", chr.wUo, chr.xgx, Integer.valueOf(chr.nbk), chr.xgs, chr.ncM, Integer.valueOf(chr.Scene), chr.wDM, Integer.valueOf(chr.vGB), chr.wbI, chr.xgw);
        AppMethodBeat.o(65514);
    }

    public i(chw chw, String str, int i, String str2, int i2, String str3, int i3, String str4, String str5) {
        AppMethodBeat.i(65515);
        this.sAX = chw;
        a aVar = new a();
        aVar.fsI = 2802;
        aVar.uri = "/cgi-bin/mmsearch-bin/topstorypluginsetcomment";
        aVar.fsJ = new chr();
        aVar.fsK = new chs();
        this.ehh = aVar.acD();
        chr chr = (chr) this.ehh.fsG.fsP;
        chr.wUo = str;
        chr.xgx = "";
        chr.nbk = i;
        chr.xgs = str2;
        chr.ncM = "";
        chr.Scene = i2;
        chr.wDM = str3;
        chr.vGB = i3;
        chr.wbI = str4;
        chr.xgw = str5;
        chr.vFH = 1;
        ab.i("MicroMsg.TopStory.NetSceneTopStorySetComment", "TopStoryPluginSetCommentRequest %s, %s, %s, %s, %s, %s, %s, %s, %s, %s", chr.wUo, chr.xgx, Integer.valueOf(chr.nbk), chr.xgs, chr.ncM, Integer.valueOf(chr.Scene), chr.wDM, Integer.valueOf(chr.vGB), chr.wbI, chr.xgw);
        AppMethodBeat.o(65515);
    }

    public final int getType() {
        return 2802;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(65516);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(65516);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(65517);
        ab.i("MicroMsg.TopStory.NetSceneTopStorySetComment", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str, Long.valueOf(System.currentTimeMillis() - this.sAZ));
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(65517);
    }

    public final chs cFw() {
        return (chs) this.ehh.fsH.fsP;
    }
}
