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
import com.tencent.p177mm.protocal.protobuf.avf;
import com.tencent.p177mm.protocal.protobuf.avs;
import com.tencent.p177mm.protocal.protobuf.avt;
import com.tencent.p177mm.protocal.protobuf.awg;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.webview.model.t */
public final class C46426t extends C1207m implements C1918k, C29934b {
    private C1202f eIc;
    public final C7472b ehh;
    private final int ulX;
    public avf ulY;

    public C46426t(avf avf, String str, String str2, String str3, String str4, String str5, String str6, String str7, C1332b c1332b, int i, LinkedList<awg> linkedList, int i2) {
        AppMethodBeat.m2504i(6622);
        C4990ab.m7417i("MicroMsg.webview.NetSceneJSAPISetAuth", "NetSceneJSAPISetAuth doScene url[%s], appid[%s], jsapiName[%s], [%s], [%s], [%s], [%s], [%s]", str, str2, str3, str4, str5, str6, str7, Integer.valueOf(i));
        this.ulY = avf;
        this.ulX = i2;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new avs();
        c1196a.fsK = new avt();
        c1196a.uri = "/cgi-bin/mmbiz-bin/jsapi-setauth";
        c1196a.fsI = FilterEnum4Shaka.MIC_WEISHI_v4_4_LAODIANYING;
        this.ehh = c1196a.acD();
        avs avs = (avs) this.ehh.fsG.fsP;
        avs.url = str;
        avs.csB = str2;
        avs.wzd = str3;
        avs.cvO = str4;
        avs.wzf = str5;
        avs.signature = str6;
        avs.wzg = str7;
        avs.wzi = i;
        avs.wzh = c1332b;
        avs.wzm = linkedList;
        AppMethodBeat.m2505o(6622);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(6623);
        C4990ab.m7417i("MicroMsg.webview.NetSceneJSAPISetAuth", "errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.eIc.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(6623);
    }

    public final int getType() {
        return FilterEnum4Shaka.MIC_WEISHI_v4_4_LAODIANYING;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(6624);
        C4990ab.m7416i("MicroMsg.webview.NetSceneJSAPISetAuth", "doScene");
        this.eIc = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(6624);
        return a;
    }

    public final int cXz() {
        return this.ulX;
    }
}
