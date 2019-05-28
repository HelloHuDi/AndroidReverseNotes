package com.tencent.p177mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C43970c.C29934b;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C43970c.C43969a;
import com.tencent.p177mm.protocal.protobuf.avo;
import com.tencent.p177mm.protocal.protobuf.avp;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.webview.model.r */
public final class C46425r extends C1207m implements C1918k, C29934b {
    private C1202f eIc;
    public final C7472b ehh;
    public String iCz;
    public C43969a ulV;
    private final int ulX;

    public C46425r(C43969a c43969a, String str, String str2, LinkedList<String> linkedList, String str3, String str4, String str5, String str6, int i, String str7, int i2) {
        AppMethodBeat.m2504i(6616);
        C4990ab.m7417i("MicroMsg.webview.NetSceneJSAPIPreVerify", "NetSceneJSAPIPreVerify doScene url[%s], appid[%s], [%s], [%s], [%s], [%s]", str, str2, str3, str4, str5, str6);
        this.ulV = c43969a;
        this.iCz = str;
        this.ulX = i2;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new avo();
        c1196a.fsK = new avp();
        c1196a.uri = "/cgi-bin/mmbiz-bin/jsapi-preverify";
        c1196a.fsI = FilterEnum4Shaka.MIC_WEISHI_v4_4_HEIBAI;
        this.ehh = c1196a.acD();
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
        AppMethodBeat.m2505o(6616);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(6617);
        C4990ab.m7417i("MicroMsg.webview.NetSceneJSAPIPreVerify", "errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.eIc.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(6617);
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

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(6618);
        C4990ab.m7416i("MicroMsg.webview.NetSceneJSAPIPreVerify", "doScene");
        this.eIc = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(6618);
        return a;
    }

    public final int cXz() {
        return this.ulX;
    }
}
