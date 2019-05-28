package com.tencent.p177mm.plugin.topstory.p539a.p1042c;

import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.chp;
import com.tencent.p177mm.protocal.protobuf.chq;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.topstory.a.c.f */
public final class C13944f extends C1207m implements C1918k {
    public C7472b ehh;
    private C1202f ehi;
    private long sAZ = System.currentTimeMillis();

    public C13944f(JSONObject jSONObject) {
        AppMethodBeat.m2504i(65509);
        C1196a c1196a = new C1196a();
        c1196a.fsI = 2906;
        c1196a.uri = "/cgi-bin/mmsearch-bin/topstorypluginpostcomment";
        c1196a.fsJ = new chp();
        c1196a.fsK = new chq();
        this.ehh = c1196a.acD();
        chp chp = (chp) this.ehh.fsG.fsP;
        chp.xgs = jSONObject.optString("requestId", "");
        chp.wUo = jSONObject.optString("docId", "");
        chp.ncM = jSONObject.optString(C8741b.CONTENT, "");
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
        C4990ab.m7417i("MicroMsg.TopStory.NetSceneTopStoryPostComment", "TopStoryPluginPostCommentRequest %s, %s, %s, %s, %s, %s, %s, %s, %s, %s", chp.xgs, chp.wUo, chp.ncM, chp.xgt, chp.xgu, chp.xgv, chp.Title, chp.wDM, Integer.valueOf(chp.Scene), Integer.valueOf(chp.vGB));
        AppMethodBeat.m2505o(65509);
    }

    public C13944f(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, int i2, String str9, String str10) {
        AppMethodBeat.m2504i(65510);
        C1196a c1196a = new C1196a();
        c1196a.fsI = 2906;
        c1196a.uri = "/cgi-bin/mmsearch-bin/topstorypluginpostcomment";
        c1196a.fsJ = new chp();
        c1196a.fsK = new chq();
        this.ehh = c1196a.acD();
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
        C4990ab.m7417i("MicroMsg.TopStory.NetSceneTopStoryPostComment", "TopStoryPluginPostCommentRequest %s, %s, %s, %s, %s, %s, %s, %s, %s, %s", chp.xgs, chp.wUo, chp.ncM, chp.xgt, chp.xgu, chp.xgv, chp.Title, chp.wDM, Integer.valueOf(chp.Scene), Integer.valueOf(chp.vGB));
        AppMethodBeat.m2505o(65510);
    }

    public C13944f(C13944f c13944f) {
        AppMethodBeat.m2504i(65511);
        C1196a c1196a = new C1196a();
        c1196a.fsI = 2906;
        c1196a.uri = "/cgi-bin/mmsearch-bin/topstorypluginpostcomment";
        c1196a.fsJ = new chp();
        c1196a.fsK = new chq();
        this.ehh = c1196a.acD();
        chp chp = (chp) this.ehh.fsG.fsP;
        chp cFv = c13944f.cFv();
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
        C4990ab.m7417i("MicroMsg.TopStory.NetSceneTopStoryPostComment", "TopStoryPluginPostCommentRequest %s, %s, %s, %s, %s, %s, %s, %s, %s, %s", chp.xgs, chp.wUo, chp.ncM, chp.xgt, chp.xgu, chp.xgv, chp.Title, chp.wDM, Integer.valueOf(chp.Scene), Integer.valueOf(chp.vGB));
        AppMethodBeat.m2505o(65511);
    }

    public final int getType() {
        return 2906;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(65512);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(65512);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(65513);
        C4990ab.m7417i("MicroMsg.TopStory.NetSceneTopStoryPostComment", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str, Long.valueOf(System.currentTimeMillis() - this.sAZ));
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(65513);
    }

    public final chq cFu() {
        return (chq) this.ehh.fsH.fsP;
    }

    public final chp cFv() {
        return (chp) this.ehh.fsG.fsP;
    }
}
