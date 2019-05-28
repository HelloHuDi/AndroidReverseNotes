package com.tencent.p177mm.plugin.webview.model;

import com.google.android.gms.measurement.AppMeasurement.Param;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.afv;
import com.tencent.p177mm.protocal.protobuf.afw;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.webview.model.m */
public final class C22893m extends C1207m implements C1918k {
    public C7472b ehh;
    private C1202f ehi;

    public C22893m(String str, String str2, Map<String, Object> map) {
        AppMethodBeat.m2504i(6601);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new afv();
        c1196a.fsK = new afw();
        c1196a.uri = "/cgi-bin/mmocbiz-bin/getbizjsapiredirecturl";
        this.ehh = c1196a.acD();
        afv afv = (afv) this.ehh.fsG.fsP;
        afv.wbO = str;
        afv.vOV = str2;
        afv.wmY = (String) map.get("groupId");
        afv.tyv = (String) map.get(Param.TIMESTAMP);
        afv.kmt = (String) map.get("nonceStr");
        afv.signature = (String) map.get("signature");
        afv.wmZ = map.get("params").toString();
        AppMethodBeat.m2505o(6601);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(6602);
        C4990ab.m7411d("MicroMsg.NetSceneGetBizJsApiRedirectUrl", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(6602);
    }

    public final int getType() {
        return 1393;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(6603);
        this.ehi = c1202f;
        C4990ab.m7416i("MicroMsg.NetSceneGetBizJsApiRedirectUrl", "do scene");
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(6603);
        return a;
    }

    public final afw cXw() {
        if (this.ehh == null || this.ehh.fsH.fsP == null) {
            return null;
        }
        return (afw) this.ehh.fsH.fsP;
    }
}
