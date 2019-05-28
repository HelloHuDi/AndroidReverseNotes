package com.tencent.p177mm.plugin.topstory.p539a.p1042c;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.topstory.p539a.C13943b;
import com.tencent.p177mm.plugin.websearch.api.C14423an;
import com.tencent.p177mm.plugin.websearch.api.C46400aa;
import com.tencent.p177mm.protocal.protobuf.C23447tn;
import com.tencent.p177mm.protocal.protobuf.chn;
import com.tencent.p177mm.protocal.protobuf.cht;
import com.tencent.p177mm.protocal.protobuf.cvd;
import com.tencent.p177mm.protocal.protobuf.cve;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.topstory.a.c.b */
public final class C39961b extends C1207m implements C1918k {
    public chn cPu;
    private C7472b ehh;
    private C1202f ehi;
    private long sAZ = System.currentTimeMillis();

    public C39961b(chn chn, int i) {
        AppMethodBeat.m2504i(96383);
        C4990ab.m7417i("MicroMsg.TopStory.NetSceneTopStory", "Create NetSceneTopStory Home channelId:%s, %s %s %s", Integer.valueOf(chn.cdf), Integer.valueOf(i), chn.xgj, chn.cvF);
        this.cPu = chn;
        C1196a c1196a = new C1196a();
        c1196a.fsI = 1943;
        c1196a.uri = "/cgi-bin/mmsearch-bin/mmwebrecommend";
        c1196a.fsJ = new cvd();
        c1196a.fsK = new cve();
        this.ehh = c1196a.acD();
        cvd cvd = (cvd) this.ehh.fsG.fsP;
        cvd.vOq = chn.offset;
        cvd.wDH = C46400aa.m87305HV(1);
        cvd.wkD = chn.ctj;
        cvd.wDI = C46400aa.abJ();
        cvd.Scene = chn.scene;
        cvd.vQg = chn.hlm;
        cvd.xqa.addAll(chn.tZG);
        cvd.xfr = chn.cdf;
        cvd.xrf = i;
        if (cvd.xfr == 110) {
            cht cEP = ((C13943b) C1720g.m3530M(C13943b.class)).getRedDotMgr().cEP();
            if (cEP != null) {
                cvd.wSi = cEP.cJb;
            }
        } else if (cvd.xfr == 100) {
            cvd.wSi = ((C13943b) C1720g.m3530M(C13943b.class)).getRedDotMgr().cFc();
        } else {
            cvd.wSi = "";
        }
        cvd.xrd = chn.tZP;
        cvd.xgp = chn.xgp;
        C23447tn c23447tn = new C23447tn();
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
        Iterator it = cvd.xqa.iterator();
        while (it.hasNext()) {
            c23447tn = (C23447tn) it.next();
            C4990ab.m7417i("MicroMsg.TopStory.NetSceneTopStory", "key: %s unit_value %s text_value %s", c23447tn.key, Long.valueOf(c23447tn.waD), c23447tn.waE);
        }
        C4990ab.m7417i("MicroMsg.TopStory.NetSceneTopStory", "request params offset %d h5Version %d CheckDocListSize: %d", Integer.valueOf(cvd.vOq), Integer.valueOf(cvd.wDH), Integer.valueOf(cvd.xgp.size()));
        AppMethodBeat.m2505o(96383);
    }

    public final int getType() {
        return 1943;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(96384);
        C14423an.reportIdKey649ForLook(this.cPu.scene, 2);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(96384);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(96385);
        C4990ab.m7417i("MicroMsg.TopStory.NetSceneTopStory", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str, Long.valueOf(System.currentTimeMillis() - this.sAZ));
        if (i3 == -1) {
            C14423an.reportIdKey649ForLook(this.cPu.scene, 4);
        } else if (i2 == 0 && i3 == 0) {
            C14423an.reportIdKey649ForLook(this.cPu.scene, 3);
        } else {
            C14423an.reportIdKey649ForLook(this.cPu.scene, 8);
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(96385);
    }

    public final cve cFt() {
        return (cve) this.ehh.fsH.fsP;
    }
}
