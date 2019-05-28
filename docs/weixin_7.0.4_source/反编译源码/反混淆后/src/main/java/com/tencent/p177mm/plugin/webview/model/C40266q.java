package com.tencent.p177mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C43970c.C29934b;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C43970c.C43969a;
import com.tencent.p177mm.protocal.protobuf.avg;
import com.tencent.p177mm.protocal.protobuf.avh;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.ttpic.FilterEnum4Shaka;

/* renamed from: com.tencent.mm.plugin.webview.model.q */
public final class C40266q extends C1207m implements C1918k, C29934b {
    private C1202f eIc;
    private final C7472b ehh;
    public C43969a ulV;
    public String ulW;
    private final int ulX;
    public String url;

    public C40266q(C43969a c43969a, String str, String str2, String str3, String str4, String str5, String str6, String str7, byte[] bArr, int i, String str8, int i2) {
        AppMethodBeat.m2504i(6613);
        C4990ab.m7417i("MicroMsg.webview.NetSceneJSAPIAuth", "NetSceneJSAPIAuth doScene appid[%s], jsapiName[%s], [%s], [%s], [%s], [%s], [%s], [%s]", str2, str3, str4, str5, str6, str7, Integer.valueOf(i), str8);
        this.ulV = c43969a;
        this.ulW = str3;
        this.url = str;
        this.ulX = i2;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new avg();
        c1196a.fsK = new avh();
        c1196a.uri = "/cgi-bin/mmbiz-bin/jsapi-auth";
        c1196a.fsI = FilterEnum4Shaka.MIC_WEISHI_v4_4_LIANKONG;
        this.ehh = c1196a.acD();
        avg avg = (avg) this.ehh.fsG.fsP;
        avg.url = str;
        avg.mZr = str2;
        avg.wzd = str3;
        avg.cvO = str4;
        avg.wzf = str5;
        avg.signature = str6;
        avg.wzg = str7;
        avg.wzh = C1332b.m2847bI(bArr);
        avg.wzi = i;
        avg.scope = str8;
        AppMethodBeat.m2505o(6613);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(6614);
        C4990ab.m7417i("MicroMsg.webview.NetSceneJSAPIAuth", "errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.eIc.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(6614);
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

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(6615);
        C4990ab.m7416i("MicroMsg.webview.NetSceneJSAPIAuth", "doScene");
        this.eIc = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(6615);
        return a;
    }

    public final int cXz() {
        return this.ulX;
    }
}
