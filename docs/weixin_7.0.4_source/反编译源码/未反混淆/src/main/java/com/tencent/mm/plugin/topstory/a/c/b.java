package com.tencent.mm.plugin.topstory.a.c;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.protocal.protobuf.chn;
import com.tencent.mm.protocal.protobuf.cht;
import com.tencent.mm.protocal.protobuf.cvd;
import com.tencent.mm.protocal.protobuf.cve;
import com.tencent.mm.protocal.protobuf.tn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.Iterator;

public final class b extends m implements k {
    public chn cPu;
    private com.tencent.mm.ai.b ehh;
    private f ehi;
    private long sAZ = System.currentTimeMillis();

    public b(chn chn, int i) {
        AppMethodBeat.i(96383);
        ab.i("MicroMsg.TopStory.NetSceneTopStory", "Create NetSceneTopStory Home channelId:%s, %s %s %s", Integer.valueOf(chn.cdf), Integer.valueOf(i), chn.xgj, chn.cvF);
        this.cPu = chn;
        a aVar = new a();
        aVar.fsI = 1943;
        aVar.uri = "/cgi-bin/mmsearch-bin/mmwebrecommend";
        aVar.fsJ = new cvd();
        aVar.fsK = new cve();
        this.ehh = aVar.acD();
        cvd cvd = (cvd) this.ehh.fsG.fsP;
        cvd.vOq = chn.offset;
        cvd.wDH = aa.HV(1);
        cvd.wkD = chn.ctj;
        cvd.wDI = aa.abJ();
        cvd.Scene = chn.scene;
        cvd.vQg = chn.hlm;
        cvd.xqa.addAll(chn.tZG);
        cvd.xfr = chn.cdf;
        cvd.xrf = i;
        if (cvd.xfr == 110) {
            cht cEP = ((com.tencent.mm.plugin.topstory.a.b) g.M(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().cEP();
            if (cEP != null) {
                cvd.wSi = cEP.cJb;
            }
        } else if (cvd.xfr == 100) {
            cvd.wSi = ((com.tencent.mm.plugin.topstory.a.b) g.M(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().cFc();
        } else {
            cvd.wSi = "";
        }
        cvd.xrd = chn.tZP;
        cvd.xgp = chn.xgp;
        tn tnVar = new tn();
        tnVar.key = "client_system_version";
        tnVar.waD = (long) VERSION.SDK_INT;
        cvd.xqa.add(tnVar);
        tnVar = new tn();
        tnVar.key = DownloadInfo.NETTYPE;
        tnVar.waE = aa.bVP();
        cvd.xqa.add(tnVar);
        tnVar = new tn();
        tnVar.key = "client_request_time";
        tnVar.waE = String.valueOf(System.currentTimeMillis());
        cvd.xqa.add(tnVar);
        Iterator it = cvd.xqa.iterator();
        while (it.hasNext()) {
            tnVar = (tn) it.next();
            ab.i("MicroMsg.TopStory.NetSceneTopStory", "key: %s unit_value %s text_value %s", tnVar.key, Long.valueOf(tnVar.waD), tnVar.waE);
        }
        ab.i("MicroMsg.TopStory.NetSceneTopStory", "request params offset %d h5Version %d CheckDocListSize: %d", Integer.valueOf(cvd.vOq), Integer.valueOf(cvd.wDH), Integer.valueOf(cvd.xgp.size()));
        AppMethodBeat.o(96383);
    }

    public final int getType() {
        return 1943;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(96384);
        an.reportIdKey649ForLook(this.cPu.scene, 2);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(96384);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(96385);
        ab.i("MicroMsg.TopStory.NetSceneTopStory", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str, Long.valueOf(System.currentTimeMillis() - this.sAZ));
        if (i3 == -1) {
            an.reportIdKey649ForLook(this.cPu.scene, 4);
        } else if (i2 == 0 && i3 == 0) {
            an.reportIdKey649ForLook(this.cPu.scene, 3);
        } else {
            an.reportIdKey649ForLook(this.cPu.scene, 8);
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(96385);
    }

    public final cve cFt() {
        return (cve) this.ehh.fsH.fsP;
    }
}
