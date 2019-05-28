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
import com.tencent.p177mm.protocal.protobuf.avq;
import com.tencent.p177mm.protocal.protobuf.avr;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.ttpic.FilterEnum4Shaka;

/* renamed from: com.tencent.mm.plugin.webview.model.s */
public final class C40267s extends C1207m implements C1918k, C29934b {
    private C1202f eIc;
    private final C7472b ehh;
    public C43969a ulV;
    private final int ulX;

    public C40267s(C43969a c43969a, String str, String str2, String str3, String str4, String str5, String str6, String str7, byte[] bArr, int i) {
        AppMethodBeat.m2504i(6619);
        C4990ab.m7417i("MicroMsg.webview.NetSceneJSAPIRealtimeVerify", "NetSceneJSAPIRealtimeVerify doScene url[%s], appid[%s], jsapiName[%s], [%s], [%s], [%s], [%s]", str, str2, str3, str4, str5, str6, str7);
        this.ulV = c43969a;
        this.ulX = i;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new avq();
        c1196a.fsK = new avr();
        c1196a.uri = "/cgi-bin/mmbiz-bin/jsapi-realtimeverify";
        c1196a.fsI = FilterEnum4Shaka.MIC_WEISHI_v4_4_CHENGJING;
        this.ehh = c1196a.acD();
        avq avq = (avq) this.ehh.fsG.fsP;
        avq.url = str;
        avq.csB = str2;
        avq.wzd = str3;
        avq.cvO = str4;
        avq.wzf = str5;
        avq.signature = str6;
        avq.wzg = str7;
        avq.wzh = C1332b.m2847bI(bArr);
        AppMethodBeat.m2505o(6619);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(6620);
        C4990ab.m7417i("MicroMsg.webview.NetSceneJSAPIRealtimeVerify", "errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.eIc.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(6620);
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

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(6621);
        C4990ab.m7416i("MicroMsg.webview.NetSceneJSAPIRealtimeVerify", "doScene");
        this.eIc = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(6621);
        return a;
    }

    public final int cXz() {
        return this.ulX;
    }
}
