package com.tencent.p177mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p230g.p231a.C42006ig;
import com.tencent.p177mm.plugin.websearch.api.C14425b;
import com.tencent.p177mm.protocal.protobuf.csw;
import com.tencent.p177mm.protocal.protobuf.csx;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;

/* renamed from: com.tencent.mm.modelappbrand.r */
public final class C32814r extends C14425b implements C1918k {
    private C1202f eIc;
    private C7472b fpJ;
    private csx fpM;

    public C32814r(String str, int i, int i2) {
        AppMethodBeat.m2504i(93740);
        this.f2956Kg = str;
        this.gOW = i;
        this.tZt = i2;
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.NetSceneWeAppSuggest", "keyword is unavailable");
            AppMethodBeat.m2505o(93740);
            return;
        }
        C4990ab.m7417i("MicroMsg.NetSceneWeAppSuggest", "Constructors: query = %s", str);
        C1196a c1196a = new C1196a();
        c1196a.fsI = 1173;
        c1196a.uri = "/cgi-bin/mmbiz-bin/wxaapp/weappsearchsuggestion";
        c1196a.fsJ = new csw();
        c1196a.fsK = new csx();
        this.fpJ = c1196a.acD();
        csw csw = (csw) this.fpJ.fsG.fsP;
        csw.query = str;
        C42006ig c42006ig = new C42006ig();
        C4879a.xxA.mo10055m(c42006ig);
        csw.wCu = c42006ig.cDp.cDq;
        Object obj = C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WXA_SEARCH_INPUT_HINT_CONTENT_ID_STRING_SYNC, null);
        if (obj != null && (obj instanceof String)) {
            csw.xqg = (String) obj;
        }
        csw.wCy = C45445b.fpD;
        csw.xqb = C45445b.fpE;
        AppMethodBeat.m2505o(93740);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(93741);
        C4990ab.m7417i("MicroMsg.NetSceneWeAppSuggest", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.fpM = (csx) this.fpJ.fsH.fsP;
            if (this.fpM != null) {
                C4990ab.m7419v("MicroMsg.NetSceneWeAppSuggest", "return data\n%s", this.fpM.vOy);
            }
            this.eIc.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(93741);
            return;
        }
        this.eIc.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(93741);
    }

    public final int getType() {
        return 1173;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(93742);
        this.eIc = c1202f;
        int a = mo4457a(c1902e, this.fpJ, this);
        AppMethodBeat.m2505o(93742);
        return a;
    }

    public final String abH() {
        return this.fpM != null ? this.fpM.vOy : "";
    }
}
