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
import com.tencent.p177mm.protocal.protobuf.chr;
import com.tencent.p177mm.protocal.protobuf.chs;
import com.tencent.p177mm.protocal.protobuf.chw;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.topstory.a.c.i */
public final class C35292i extends C1207m implements C1918k {
    public C7472b ehh;
    private C1202f ehi;
    public chw sAX;
    private long sAZ = System.currentTimeMillis();

    public C35292i(JSONObject jSONObject) {
        AppMethodBeat.m2504i(65514);
        C1196a c1196a = new C1196a();
        c1196a.fsI = 2802;
        c1196a.uri = "/cgi-bin/mmsearch-bin/topstorypluginsetcomment";
        c1196a.fsJ = new chr();
        c1196a.fsK = new chs();
        this.ehh = c1196a.acD();
        chr chr = (chr) this.ehh.fsG.fsP;
        chr.wUo = jSONObject.optString("docId", "");
        chr.xgx = jSONObject.optString("commentId", "");
        chr.nbk = jSONObject.optInt("opType", 0);
        chr.xgs = jSONObject.optString("requestId", "");
        chr.ncM = jSONObject.optString(C8741b.CONTENT, "");
        chr.Scene = jSONObject.optInt("scene", 0);
        chr.wDM = jSONObject.optString("searchId", "");
        chr.vGB = jSONObject.optInt("subScene", 0);
        chr.wbI = jSONObject.optString("vid", "");
        chr.xgw = jSONObject.optString("byPass", "");
        chr.vFH = 0;
        C4990ab.m7417i("MicroMsg.TopStory.NetSceneTopStorySetComment", "TopStoryPluginSetCommentRequest %s, %s, %s, %s, %s, %s, %s, %s, %s, %s", chr.wUo, chr.xgx, Integer.valueOf(chr.nbk), chr.xgs, chr.ncM, Integer.valueOf(chr.Scene), chr.wDM, Integer.valueOf(chr.vGB), chr.wbI, chr.xgw);
        AppMethodBeat.m2505o(65514);
    }

    public C35292i(chw chw, String str, int i, String str2, int i2, String str3, int i3, String str4, String str5) {
        AppMethodBeat.m2504i(65515);
        this.sAX = chw;
        C1196a c1196a = new C1196a();
        c1196a.fsI = 2802;
        c1196a.uri = "/cgi-bin/mmsearch-bin/topstorypluginsetcomment";
        c1196a.fsJ = new chr();
        c1196a.fsK = new chs();
        this.ehh = c1196a.acD();
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
        C4990ab.m7417i("MicroMsg.TopStory.NetSceneTopStorySetComment", "TopStoryPluginSetCommentRequest %s, %s, %s, %s, %s, %s, %s, %s, %s, %s", chr.wUo, chr.xgx, Integer.valueOf(chr.nbk), chr.xgs, chr.ncM, Integer.valueOf(chr.Scene), chr.wDM, Integer.valueOf(chr.vGB), chr.wbI, chr.xgw);
        AppMethodBeat.m2505o(65515);
    }

    public final int getType() {
        return 2802;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(65516);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(65516);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(65517);
        C4990ab.m7417i("MicroMsg.TopStory.NetSceneTopStorySetComment", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str, Long.valueOf(System.currentTimeMillis() - this.sAZ));
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(65517);
    }

    public final chs cFw() {
        return (chs) this.ehh.fsH.fsP;
    }
}
