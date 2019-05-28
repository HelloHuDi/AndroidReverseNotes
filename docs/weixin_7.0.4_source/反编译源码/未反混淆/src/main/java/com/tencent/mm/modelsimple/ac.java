package com.tencent.mm.modelsimple;

import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.cyg;
import com.tencent.mm.protocal.protobuf.cyh;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class ac extends m implements k {
    private f ehi;
    private final b fmP;
    private int retryCount = 3;

    public ac(String str, int i) {
        AppMethodBeat.i(78615);
        a aVar = new a();
        aVar.fsJ = new cyg();
        aVar.fsK = new cyh();
        aVar.uri = "/cgi-bin/micromsg-bin/yybgetpkgsig";
        aVar.fsI = 729;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.fmP = aVar.acD();
        cyg cyg = (cyg) this.fmP.fsG.fsP;
        cyg.luQ = aa.dor();
        cyg.vIh = com.tencent.mm.plugin.normsg.a.b.oTO.An(0);
        cyg.xtD = str;
        cyg.mZv = i;
        ab.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken YybGetPkgSig Language[%s], PkgName[%s], versionCode[%d], stack[%s]", cyg.luQ, str, Integer.valueOf(i), bo.dpG());
        AppMethodBeat.o(78615);
    }

    public final int getType() {
        return 729;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(78616);
        this.ehi = fVar;
        int a = a(eVar, this.fmP, this);
        AppMethodBeat.o(78616);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(78617);
        cyg cyg = (cyg) this.fmP.fsG.fsP;
        cyh cyh = (cyh) this.fmP.fsH.fsP;
        ab.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken YybGetPkgSig onGYNetEnd netId[%d], errType[%d], errCode[%d], errMsg[%s], ret[%d], sig[%s]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(cyh.xtE), cyh.xtF);
        h hVar;
        Object[] objArr;
        if (i2 == 0 && i3 == 0) {
            if (cyh.xtE == 2 || cyh.xtE == 3) {
                this.retryCount--;
                if (this.retryCount <= 0) {
                    ab.w("MicroMsg.NetSceneYybGetPkgSig", "summertoken err and return with no try!");
                    h.pYm.a(322, 2, 1, false);
                    hVar = h.pYm;
                    objArr = new Object[2];
                    objArr[0] = Integer.valueOf(WearableStatusCodes.UNKNOWN_LISTENER);
                    objArr[1] = String.format("%s,%d", new Object[]{cyg.xtD, Integer.valueOf(cyg.mZv)});
                    hVar.e(11098, objArr);
                    this.ehi.onSceneEnd(3, -1, "", this);
                    AppMethodBeat.o(78617);
                    return;
                }
                ab.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken do scene again retryCount:%d", Integer.valueOf(this.retryCount));
                a(this.ftf, this.ehi);
            } else if (cyh.xtE == 1) {
                MultiProcessSharedPreferences.getSharedPreferences(ah.getContext(), "yyb_pkg_sig_prefs", com.tencent.mm.compatible.util.h.Mu()).edit().remove(cyg.xtD).commit();
                h.pYm.a(322, 5, 1, false);
                hVar = h.pYm;
                objArr = new Object[2];
                objArr[0] = Integer.valueOf(WearableStatusCodes.ASSET_UNAVAILABLE);
                objArr[1] = String.format("%s,%d", new Object[]{cyg.xtD, Integer.valueOf(cyg.mZv)});
                hVar.e(11098, objArr);
                ab.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken ret no sig[%s] and remove", cyh.xtF);
            } else if (cyh.xtE == 4) {
                ab.w("MicroMsg.NetSceneYybGetPkgSig", "summertoken ret no need try and revise");
                h.pYm.a(322, 4, 1, false);
                hVar = h.pYm;
                objArr = new Object[2];
                objArr[0] = Integer.valueOf(WearableStatusCodes.INVALID_TARGET_NODE);
                objArr[1] = String.format("%s,%d", new Object[]{cyg.xtD, Integer.valueOf(cyg.mZv)});
                hVar.e(11098, objArr);
            } else {
                ab.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken ret sig[%s]", cyh.xtF);
                MultiProcessSharedPreferences.getSharedPreferences(ah.getContext(), "yyb_pkg_sig_prefs", com.tencent.mm.compatible.util.h.Mu()).edit().putString(cyg.xtD, cyh.xtF).commit();
                h.pYm.a(322, 3, 1, false);
                hVar = h.pYm;
                objArr = new Object[2];
                objArr[0] = Integer.valueOf(WearableStatusCodes.DATA_ITEM_TOO_LARGE);
                objArr[1] = String.format("%s,%d,%s", new Object[]{cyg.xtD, Integer.valueOf(cyg.mZv), cyh.xtF});
                hVar.e(11098, objArr);
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(78617);
            return;
        }
        ab.w("MicroMsg.NetSceneYybGetPkgSig", "summertoken YybGetPkgSig err and return!");
        h.pYm.a(322, 1, 1, false);
        hVar = h.pYm;
        objArr = new Object[2];
        objArr[0] = Integer.valueOf(WearableStatusCodes.DUPLICATE_LISTENER);
        objArr[1] = String.format("%s,%d,%d,%d", new Object[]{cyg.xtD, Integer.valueOf(cyg.mZv), Integer.valueOf(i2), Integer.valueOf(i3)});
        hVar.e(11098, objArr);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(78617);
    }
}
