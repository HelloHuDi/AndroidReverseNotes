package com.tencent.mm.sandbox.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.c.i;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.p.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sandbox.SubCoreSandBox;
import com.tencent.mm.protocal.protobuf.apg;
import com.tencent.mm.protocal.protobuf.aph;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.g;

public final class a extends m implements k, b {
    public final com.tencent.mm.ai.b ehh;
    private f ehi;

    public a(int i) {
        AppMethodBeat.i(28779);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new apg();
        aVar.fsK = new aph();
        aVar.uri = "/cgi-bin/micromsg-bin/getupdateinfo";
        this.ehh = aVar.acD();
        apg apg = (apg) this.ehh.fsG.fsP;
        apg.wth = i;
        apg.vAM = g.cdf;
        if (10012 == ae.giz && ae.giA > 0) {
            apg.vAM = ae.giA;
        }
        switch (i) {
            case 1:
                h.pYm.a(405, 3, 1, true);
                break;
            case 2:
                h.pYm.a(405, 4, 1, true);
                break;
            case 3:
                h.pYm.a(405, 5, 1, true);
                break;
            case 4:
                h.pYm.a(405, 6, 1, true);
                break;
        }
        ab.i("MicroMsg.NetSceneGetUpdateInfo", "summerupdate dkchan NetSceneGetUpdateInfo updateType:%d channel:%d release:%d, stack[%s]", Integer.valueOf(apg.wth), Integer.valueOf(apg.vAM), Integer.valueOf(g.cdf), bo.dpG());
        AppMethodBeat.o(28779);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(28780);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(28780);
        return a;
    }

    public final int getType() {
        return 11;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(28781);
        ab.i("MicroMsg.NetSceneGetUpdateInfo", "summertoken GetUpdateInfo onGYNetEnd errType[%d], errCode[%d], errMsg[%s]", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            h.pYm.a(405, 7, 1, true);
        } else {
            h.pYm.a(405, 8, 1, true);
            if (i2 == 4) {
                h.pYm.a(405, 9, 1, true);
                if (i3 == -16) {
                    h.pYm.a(405, 10, 1, true);
                } else if (i3 == -17) {
                    h.pYm.a(405, 11, 1, true);
                } else if (i3 == -18) {
                    h.pYm.a(405, 12, 1, true);
                }
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        String dnb = dnb();
        if (dnb != null) {
            i cO = i.cO(dnb);
            if (cO != null) {
                ab.i("MicroMsg.NetSceneGetUpdateInfo", "summertoken patchVersionCode[%d]", Integer.valueOf(cO.versionCode));
                aw.Rg().a(new ac(ah.getPackageName(), r0), 0);
                h.pYm.a(405, 13, 1, true);
                AppMethodBeat.o(28781);
                return;
            }
            ab.i("MicroMsg.NetSceneGetUpdateInfo", "summertoken patchInfo is null patchXml[%s]", dnb);
            AppMethodBeat.o(28781);
            return;
        }
        ab.w("MicroMsg.NetSceneGetUpdateInfo", "summertoken patchXml is null!");
        h.pYm.a(405, 14, 1, true);
        AppMethodBeat.o(28781);
    }

    public final int dmZ() {
        return ((aph) this.ehh.fsH.fsP).wtk;
    }

    public final String dna() {
        return ((aph) this.ehh.fsH.fsP).wtj;
    }

    public final int bQP() {
        return ((aph) this.ehh.fsH.fsP).wti;
    }

    public final String[] bQQ() {
        AppMethodBeat.i(28782);
        aph aph = (aph) this.ehh.fsH.fsP;
        String[] strArr = new String[aph.wtn.size()];
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            strArr[i] = ((bts) aph.wtn.get(i)).wVI;
        }
        AppMethodBeat.o(28782);
        return strArr;
    }

    public final String dnb() {
        AppMethodBeat.i(28783);
        ab.d("MicroMsg.NetSceneGetUpdateInfo", "summertoken getPatchInfo[%s], stack[%s]", ((aph) this.ehh.fsH.fsP).wto, bo.dpG());
        String str = r0.wto;
        AppMethodBeat.o(28783);
        return str;
    }

    public final aph bQR() {
        int i = 1;
        if (SubCoreSandBox.pYG) {
            aph aph = (aph) this.ehh.fsH.fsP;
            aph.wtp = 1;
            aph.wtq = "http://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/android_exp__index";
            if (!SubCoreSandBox.pYH) {
                i = 0;
            }
            aph.wtr = i;
        }
        return (aph) this.ehh.fsH.fsP;
    }
}
