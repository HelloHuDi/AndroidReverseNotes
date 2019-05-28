package com.tencent.mm.plugin.topstory.a.c;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.chp;
import com.tencent.mm.protocal.protobuf.chq;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class f extends m implements k {
    public b ehh;
    private com.tencent.mm.ai.f ehi;
    private long sAZ = System.currentTimeMillis();

    public f(JSONObject jSONObject) {
        AppMethodBeat.i(65509);
        a aVar = new a();
        aVar.fsI = 2906;
        aVar.uri = "/cgi-bin/mmsearch-bin/topstorypluginpostcomment";
        aVar.fsJ = new chp();
        aVar.fsK = new chq();
        this.ehh = aVar.acD();
        chp chp = (chp) this.ehh.fsG.fsP;
        chp.xgs = jSONObject.optString("requestId", "");
        chp.wUo = jSONObject.optString("docId", "");
        chp.ncM = jSONObject.optString(FirebaseAnalytics.b.CONTENT, "");
        chp.xgt = jSONObject.optString("replyId", "");
        chp.xgu = jSONObject.optString("subReplyId", "");
        chp.xgv = jSONObject.optString("docUrl", "");
        chp.Title = jSONObject.optString("title", "");
        chp.wDM = jSONObject.optString("searchId", "");
        chp.Scene = jSONObject.optInt("scene", 0);
        chp.vGB = jSONObject.optInt("subScene", 0);
        chp.wbI = jSONObject.optString("vid", "");
        chp.xgw = jSONObject.optString("byPass", "");
        chp.vFH = 0;
        ab.i("MicroMsg.TopStory.NetSceneTopStoryPostComment", "TopStoryPluginPostCommentRequest %s, %s, %s, %s, %s, %s, %s, %s, %s, %s", chp.xgs, chp.wUo, chp.ncM, chp.xgt, chp.xgu, chp.xgv, chp.Title, chp.wDM, Integer.valueOf(chp.Scene), Integer.valueOf(chp.vGB));
        AppMethodBeat.o(65509);
    }

    public f(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, int i2, String str9, String str10) {
        AppMethodBeat.i(65510);
        a aVar = new a();
        aVar.fsI = 2906;
        aVar.uri = "/cgi-bin/mmsearch-bin/topstorypluginpostcomment";
        aVar.fsJ = new chp();
        aVar.fsK = new chq();
        this.ehh = aVar.acD();
        chp chp = (chp) this.ehh.fsG.fsP;
        chp.xgs = str;
        chp.wUo = str2;
        chp.ncM = str3;
        chp.xgt = str4;
        chp.xgu = str5;
        chp.xgv = str6;
        chp.Title = str7;
        chp.wDM = str8;
        chp.Scene = i;
        chp.vGB = i2;
        chp.wbI = str9;
        chp.xgw = str10;
        chp.vFH = 1;
        ab.i("MicroMsg.TopStory.NetSceneTopStoryPostComment", "TopStoryPluginPostCommentRequest %s, %s, %s, %s, %s, %s, %s, %s, %s, %s", chp.xgs, chp.wUo, chp.ncM, chp.xgt, chp.xgu, chp.xgv, chp.Title, chp.wDM, Integer.valueOf(chp.Scene), Integer.valueOf(chp.vGB));
        AppMethodBeat.o(65510);
    }

    public f(f fVar) {
        AppMethodBeat.i(65511);
        a aVar = new a();
        aVar.fsI = 2906;
        aVar.uri = "/cgi-bin/mmsearch-bin/topstorypluginpostcomment";
        aVar.fsJ = new chp();
        aVar.fsK = new chq();
        this.ehh = aVar.acD();
        chp chp = (chp) this.ehh.fsG.fsP;
        chp cFv = fVar.cFv();
        chp.xgs = cFv.xgs;
        chp.wUo = cFv.wUo;
        chp.ncM = cFv.ncM;
        chp.xgt = cFv.xgt;
        chp.xgu = cFv.xgu;
        chp.xgv = cFv.xgv;
        chp.Title = cFv.Title;
        chp.wDM = cFv.wDM;
        chp.Scene = cFv.Scene;
        chp.vGB = cFv.vGB;
        chp.wbI = cFv.wbI;
        chp.xgw = cFv.xgw;
        chp.vFH = cFv.vFH;
        ab.i("MicroMsg.TopStory.NetSceneTopStoryPostComment", "TopStoryPluginPostCommentRequest %s, %s, %s, %s, %s, %s, %s, %s, %s, %s", chp.xgs, chp.wUo, chp.ncM, chp.xgt, chp.xgu, chp.xgv, chp.Title, chp.wDM, Integer.valueOf(chp.Scene), Integer.valueOf(chp.vGB));
        AppMethodBeat.o(65511);
    }

    public final int getType() {
        return 2906;
    }

    public final int a(e eVar, com.tencent.mm.ai.f fVar) {
        AppMethodBeat.i(65512);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(65512);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(65513);
        ab.i("MicroMsg.TopStory.NetSceneTopStoryPostComment", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str, Long.valueOf(System.currentTimeMillis() - this.sAZ));
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(65513);
    }

    public final chq cFu() {
        return (chq) this.ehh.fsH.fsP;
    }

    public final chp cFv() {
        return (chp) this.ehh.fsG.fsP;
    }
}
