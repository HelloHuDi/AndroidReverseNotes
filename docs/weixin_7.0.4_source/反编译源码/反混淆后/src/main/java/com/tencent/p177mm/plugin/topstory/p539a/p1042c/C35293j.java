package com.tencent.p177mm.plugin.topstory.p539a.p1042c;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.websearch.api.C46400aa;
import com.tencent.p177mm.protocal.protobuf.C23447tn;
import com.tencent.p177mm.protocal.protobuf.chv;
import com.tencent.p177mm.protocal.protobuf.cvd;
import com.tencent.p177mm.protocal.protobuf.cve;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.topstory.a.c.j */
public final class C35293j extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi;
    public chv sBa;

    public C35293j(chv chv) {
        AppMethodBeat.m2504i(96400);
        m57957a(chv, 0, 0, "");
        AppMethodBeat.m2505o(96400);
    }

    public C35293j(chv chv, int i, String str) {
        AppMethodBeat.m2504i(96401);
        m57957a(chv, i, 1, str);
        AppMethodBeat.m2505o(96401);
    }

    /* renamed from: a */
    private void m57957a(chv chv, int i, int i2, String str) {
        C23447tn c23447tn;
        AppMethodBeat.m2504i(96402);
        C4990ab.m7417i("MicroMsg.TopStory.NetSceneTopStoryVideo", "Create NetSceneTopStory Video %s", chv.xgj, chv.hlm);
        this.sBa = chv;
        C1196a c1196a = new C1196a();
        c1196a.fsI = 1943;
        c1196a.uri = "/cgi-bin/mmsearch-bin/mmwebrecommend";
        c1196a.fsJ = new cvd();
        c1196a.fsK = new cve();
        this.ehh = c1196a.acD();
        cvd cvd = (cvd) this.ehh.fsG.fsP;
        cvd.vOq = chv.offset;
        cvd.wDH = C46400aa.m87305HV(1);
        cvd.wkD = chv.ctj;
        cvd.wDI = C46400aa.abJ();
        cvd.Scene = chv.scene;
        cvd.vQg = chv.hlm;
        cvd.xqa.addAll(chv.tZG);
        if (!C5046bo.isNullOrNil(str)) {
            Iterator it = cvd.xqa.iterator();
            while (it.hasNext()) {
                c23447tn = (C23447tn) it.next();
                if (c23447tn.key.equals("relevant_vid")) {
                    c23447tn.waE = str;
                    break;
                }
            }
            c23447tn = new C23447tn();
            c23447tn.key = "relevant_vid";
            c23447tn.waE = str;
            cvd.xqa.add(c23447tn);
        }
        cvd.xfr = (int) chv.xgG;
        cvd.xre = i;
        cvd.jCt = i2;
        c23447tn = new C23447tn();
        c23447tn.key = "client_system_version";
        c23447tn.waD = (long) VERSION.SDK_INT;
        cvd.xqa.add(c23447tn);
        c23447tn = new C23447tn();
        c23447tn.key = DownloadInfo.NETTYPE;
        c23447tn.waE = C46400aa.bVP();
        cvd.xqa.add(c23447tn);
        c23447tn = new C23447tn();
        c23447tn.key = "client_request_time";
        c23447tn.waE = String.valueOf(System.currentTimeMillis());
        cvd.xqa.add(c23447tn);
        Iterator it2 = cvd.xqa.iterator();
        while (it2.hasNext()) {
            C23447tn c23447tn2 = (C23447tn) it2.next();
            C4990ab.m7417i("MicroMsg.TopStory.NetSceneTopStoryVideo", "key: %s unit_value %s text_value %s", c23447tn2.key, Long.valueOf(c23447tn2.waD), c23447tn2.waE);
        }
        AppMethodBeat.m2505o(96402);
    }

    public final int getType() {
        return 1943;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(96403);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(96403);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(96404);
        C4990ab.m7417i("MicroMsg.TopStory.NetSceneTopStoryVideo", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(96404);
    }

    public final cve cFt() {
        return (cve) this.ehh.fsH.fsP;
    }
}
