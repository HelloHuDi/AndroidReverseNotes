package com.tencent.mm.plugin.websearch.api;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cvd;
import com.tencent.mm.protocal.protobuf.cve;
import com.tencent.mm.protocal.protobuf.tn;
import com.tencent.mm.sdk.platformtools.ab;

public final class t extends a implements k {
    private b ehh;
    private f ehi;
    private s fpL;

    public t(s sVar) {
        boolean z = true;
        AppMethodBeat.i(124061);
        this.fpL = sVar;
        this.tZu = sVar.ctj;
        this.Lp = sVar.offset;
        this.gOW = sVar.scene;
        this.tZt = sVar.cIv;
        this.fpL = sVar;
        this.tZv = sVar.tZN;
        a aVar = new a();
        aVar.uri = "/cgi-bin/mmsearch-bin/mmwebrecommend";
        aVar.fsJ = new cvd();
        aVar.fsK = new cve();
        this.ehh = aVar.acD();
        cvd cvd = (cvd) this.ehh.fsG.fsP;
        cvd.vOq = sVar.offset;
        cvd.wDH = aa.HV(1);
        cvd.wUr = sVar.tZw;
        cvd.wkD = sVar.ctj;
        cvd.wDI = aa.abJ();
        cvd.Scene = sVar.scene;
        cvd.vQg = sVar.lcA;
        cvd.xrc = sVar.cIC;
        cvd.wCv = sVar.tZC;
        cvd.xfr = sVar.cdf;
        cvd.xrd = sVar.tZP;
        tn tnVar = new tn();
        tnVar.key = "client_system_version";
        tnVar.waD = (long) VERSION.SDK_INT;
        sVar.tZG.add(tnVar);
        cvd.xqa = sVar.tZG;
        cvd.wCy = sVar.cvF;
        this.cIz = sVar.nQB;
        if (sVar.tZQ) {
            int i = sVar.scene;
            String str = sVar.cvF;
            String str2 = sVar.cIy;
            String str3 = sVar.lcA;
            int i2 = sVar.offset;
            if (sVar.tZw != 1) {
                z = false;
            }
            z.a(i, str, str2, str3, i2, z, sVar.nQB, sVar.ctj, sVar.businessType, sVar.tZM);
        }
        AppMethodBeat.o(124061);
    }

    public final int getType() {
        return 1943;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(124062);
        an.reportIdKey649ForLook(this.gOW, 2);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(124062);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(124063);
        ab.i("MicroMsg.FTS.NetSceneWebRecommend", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        boolean z = i2 == 0 && i3 == 0;
        if (this.fpL.tZQ) {
            z.a(this.fpL.scene, this.fpL.cvF, this.fpL.cIy, this.fpL.lcA, this.fpL.offset, this.fpL.tZw == 1, this.fpL.nQB, z, this.fpL.ctj, this.fpL.businessType, this.fpL.tZM);
        }
        if (i3 == -1) {
            an.reportIdKey649ForLook(this.gOW, 4);
        } else if (i2 == 0 && i3 == 0) {
            an.reportIdKey649ForLook(this.gOW, 3);
        } else {
            an.reportIdKey649ForLook(this.gOW, 8);
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(124063);
    }

    private cve cUW() {
        return (cve) this.ehh.fsH.fsP;
    }

    public final String abH() {
        AppMethodBeat.i(124064);
        String str;
        if (cUW() != null) {
            str = cUW().vOy;
            AppMethodBeat.o(124064);
            return str;
        }
        str = "";
        AppMethodBeat.o(124064);
        return str;
    }

    public final int abI() {
        AppMethodBeat.i(124065);
        if (cUW() != null) {
            int i = cUW().wCB;
            AppMethodBeat.o(124065);
            return i;
        }
        AppMethodBeat.o(124065);
        return 0;
    }
}
