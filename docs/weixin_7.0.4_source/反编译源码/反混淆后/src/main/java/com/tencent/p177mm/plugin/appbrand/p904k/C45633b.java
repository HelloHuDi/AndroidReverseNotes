package com.tencent.p177mm.plugin.appbrand.p904k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.csy;
import com.tencent.p177mm.protocal.protobuf.csz;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7580z;
import java.util.Locale;

/* renamed from: com.tencent.mm.plugin.appbrand.k.b */
public final class C45633b extends C1207m implements C1918k {
    private C1202f eIc;
    private C7472b fpJ;
    private csz ioc;

    public C45633b() {
        AppMethodBeat.m2504i(132309);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new csy();
        c1196a.fsK = new csz();
        c1196a.uri = "/cgi-bin/mmbiz-bin/wxaapp/weappsearchtitle";
        this.fpJ = c1196a.acD();
        AppMethodBeat.m2505o(132309);
    }

    public final int getType() {
        return 1170;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(132310);
        C4990ab.m7416i("MicroMsg.NetSceneGetWeAppSearchTitle", "doScene");
        this.eIc = c1202f;
        int a = mo4457a(c1902e, this.fpJ, this);
        AppMethodBeat.m2505o(132310);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(132311);
        C4990ab.m7417i("MicroMsg.NetSceneGetWeAppSearchTitle", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ioc = (csz) this.fpJ.fsH.fsP;
        if (this.eIc != null) {
            this.eIc.onSceneEnd(i2, i3, str, this);
        }
        if (this.ioc.xqh == null) {
            AppMethodBeat.m2505o(132311);
            return;
        }
        C7580z Ry = C1720g.m3536RP().mo5239Ry();
        Ry.set(C5127a.USERINFO_WXA_SEARCH_INPUT_HINT_LANG_STRING_SYNC, Locale.getDefault().getLanguage());
        Ry.set(C5127a.USERINFO_WXA_SEARCH_INPUT_HINT_CONTENT_STRING_SYNC, this.ioc.xqh.nzz);
        Ry.set(C5127a.USERINFO_WXA_SEARCH_INPUT_HINT_CONTENT_ID_STRING_SYNC, this.ioc.xqh.xqg);
        Ry.set(C5127a.USERINFO_WXA_SEARCH_INPUT_HINT_UPDATE_TIME_LONG_SYNC, Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.m2505o(132311);
    }
}
