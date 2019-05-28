package com.tencent.mm.plugin.topstory.a.c;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.protocal.protobuf.chv;
import com.tencent.mm.protocal.protobuf.cvd;
import com.tencent.mm.protocal.protobuf.cve;
import com.tencent.mm.protocal.protobuf.tn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.Iterator;

public final class j extends m implements k {
    private b ehh;
    private f ehi;
    public chv sBa;

    public j(chv chv) {
        AppMethodBeat.i(96400);
        a(chv, 0, 0, "");
        AppMethodBeat.o(96400);
    }

    public j(chv chv, int i, String str) {
        AppMethodBeat.i(96401);
        a(chv, i, 1, str);
        AppMethodBeat.o(96401);
    }

    private void a(chv chv, int i, int i2, String str) {
        tn tnVar;
        AppMethodBeat.i(96402);
        ab.i("MicroMsg.TopStory.NetSceneTopStoryVideo", "Create NetSceneTopStory Video %s", chv.xgj, chv.hlm);
        this.sBa = chv;
        a aVar = new a();
        aVar.fsI = 1943;
        aVar.uri = "/cgi-bin/mmsearch-bin/mmwebrecommend";
        aVar.fsJ = new cvd();
        aVar.fsK = new cve();
        this.ehh = aVar.acD();
        cvd cvd = (cvd) this.ehh.fsG.fsP;
        cvd.vOq = chv.offset;
        cvd.wDH = aa.HV(1);
        cvd.wkD = chv.ctj;
        cvd.wDI = aa.abJ();
        cvd.Scene = chv.scene;
        cvd.vQg = chv.hlm;
        cvd.xqa.addAll(chv.tZG);
        if (!bo.isNullOrNil(str)) {
            Iterator it = cvd.xqa.iterator();
            while (it.hasNext()) {
                tnVar = (tn) it.next();
                if (tnVar.key.equals("relevant_vid")) {
                    tnVar.waE = str;
                    break;
                }
            }
            tnVar = new tn();
            tnVar.key = "relevant_vid";
            tnVar.waE = str;
            cvd.xqa.add(tnVar);
        }
        cvd.xfr = (int) chv.xgG;
        cvd.xre = i;
        cvd.jCt = i2;
        tnVar = new tn();
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
        Iterator it2 = cvd.xqa.iterator();
        while (it2.hasNext()) {
            tn tnVar2 = (tn) it2.next();
            ab.i("MicroMsg.TopStory.NetSceneTopStoryVideo", "key: %s unit_value %s text_value %s", tnVar2.key, Long.valueOf(tnVar2.waD), tnVar2.waE);
        }
        AppMethodBeat.o(96402);
    }

    public final int getType() {
        return 1943;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(96403);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(96403);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(96404);
        ab.i("MicroMsg.TopStory.NetSceneTopStoryVideo", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(96404);
    }

    public final cve cFt() {
        return (cve) this.ehh.fsH.fsP;
    }
}
