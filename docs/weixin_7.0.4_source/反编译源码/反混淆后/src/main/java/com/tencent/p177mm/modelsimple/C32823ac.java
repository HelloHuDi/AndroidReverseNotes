package com.tencent.p177mm.modelsimple;

import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.normsg.p473a.C6998b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.cyg;
import com.tencent.p177mm.protocal.protobuf.cyh;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.MultiProcessSharedPreferences;

/* renamed from: com.tencent.mm.modelsimple.ac */
public final class C32823ac extends C1207m implements C1918k {
    private C1202f ehi;
    private final C7472b fmP;
    private int retryCount = 3;

    public C32823ac(String str, int i) {
        AppMethodBeat.m2504i(78615);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cyg();
        c1196a.fsK = new cyh();
        c1196a.uri = "/cgi-bin/micromsg-bin/yybgetpkgsig";
        c1196a.fsI = 729;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.fmP = c1196a.acD();
        cyg cyg = (cyg) this.fmP.fsG.fsP;
        cyg.luQ = C4988aa.dor();
        cyg.vIh = C6998b.oTO.mo8083An(0);
        cyg.xtD = str;
        cyg.mZv = i;
        C4990ab.m7417i("MicroMsg.NetSceneYybGetPkgSig", "summertoken YybGetPkgSig Language[%s], PkgName[%s], versionCode[%d], stack[%s]", cyg.luQ, str, Integer.valueOf(i), C5046bo.dpG());
        AppMethodBeat.m2505o(78615);
    }

    public final int getType() {
        return 729;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(78616);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.fmP, this);
        AppMethodBeat.m2505o(78616);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(78617);
        cyg cyg = (cyg) this.fmP.fsG.fsP;
        cyh cyh = (cyh) this.fmP.fsH.fsP;
        C4990ab.m7417i("MicroMsg.NetSceneYybGetPkgSig", "summertoken YybGetPkgSig onGYNetEnd netId[%d], errType[%d], errCode[%d], errMsg[%s], ret[%d], sig[%s]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(cyh.xtE), cyh.xtF);
        C7060h c7060h;
        Object[] objArr;
        if (i2 == 0 && i3 == 0) {
            if (cyh.xtE == 2 || cyh.xtE == 3) {
                this.retryCount--;
                if (this.retryCount <= 0) {
                    C4990ab.m7420w("MicroMsg.NetSceneYybGetPkgSig", "summertoken err and return with no try!");
                    C7060h.pYm.mo8378a(322, 2, 1, false);
                    c7060h = C7060h.pYm;
                    objArr = new Object[2];
                    objArr[0] = Integer.valueOf(WearableStatusCodes.UNKNOWN_LISTENER);
                    objArr[1] = String.format("%s,%d", new Object[]{cyg.xtD, Integer.valueOf(cyg.mZv)});
                    c7060h.mo8381e(11098, objArr);
                    this.ehi.onSceneEnd(3, -1, "", this);
                    AppMethodBeat.m2505o(78617);
                    return;
                }
                C4990ab.m7417i("MicroMsg.NetSceneYybGetPkgSig", "summertoken do scene again retryCount:%d", Integer.valueOf(this.retryCount));
                mo4456a(this.ftf, this.ehi);
            } else if (cyh.xtE == 1) {
                MultiProcessSharedPreferences.getSharedPreferences(C4996ah.getContext(), "yyb_pkg_sig_prefs", C1448h.m3078Mu()).edit().remove(cyg.xtD).commit();
                C7060h.pYm.mo8378a(322, 5, 1, false);
                c7060h = C7060h.pYm;
                objArr = new Object[2];
                objArr[0] = Integer.valueOf(WearableStatusCodes.ASSET_UNAVAILABLE);
                objArr[1] = String.format("%s,%d", new Object[]{cyg.xtD, Integer.valueOf(cyg.mZv)});
                c7060h.mo8381e(11098, objArr);
                C4990ab.m7417i("MicroMsg.NetSceneYybGetPkgSig", "summertoken ret no sig[%s] and remove", cyh.xtF);
            } else if (cyh.xtE == 4) {
                C4990ab.m7420w("MicroMsg.NetSceneYybGetPkgSig", "summertoken ret no need try and revise");
                C7060h.pYm.mo8378a(322, 4, 1, false);
                c7060h = C7060h.pYm;
                objArr = new Object[2];
                objArr[0] = Integer.valueOf(WearableStatusCodes.INVALID_TARGET_NODE);
                objArr[1] = String.format("%s,%d", new Object[]{cyg.xtD, Integer.valueOf(cyg.mZv)});
                c7060h.mo8381e(11098, objArr);
            } else {
                C4990ab.m7417i("MicroMsg.NetSceneYybGetPkgSig", "summertoken ret sig[%s]", cyh.xtF);
                MultiProcessSharedPreferences.getSharedPreferences(C4996ah.getContext(), "yyb_pkg_sig_prefs", C1448h.m3078Mu()).edit().putString(cyg.xtD, cyh.xtF).commit();
                C7060h.pYm.mo8378a(322, 3, 1, false);
                c7060h = C7060h.pYm;
                objArr = new Object[2];
                objArr[0] = Integer.valueOf(WearableStatusCodes.DATA_ITEM_TOO_LARGE);
                objArr[1] = String.format("%s,%d,%s", new Object[]{cyg.xtD, Integer.valueOf(cyg.mZv), cyh.xtF});
                c7060h.mo8381e(11098, objArr);
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(78617);
            return;
        }
        C4990ab.m7420w("MicroMsg.NetSceneYybGetPkgSig", "summertoken YybGetPkgSig err and return!");
        C7060h.pYm.mo8378a(322, 1, 1, false);
        c7060h = C7060h.pYm;
        objArr = new Object[2];
        objArr[0] = Integer.valueOf(WearableStatusCodes.DUPLICATE_LISTENER);
        objArr[1] = String.format("%s,%d,%d,%d", new Object[]{cyg.xtD, Integer.valueOf(cyg.mZv), Integer.valueOf(i2), Integer.valueOf(i3)});
        c7060h.mo8381e(11098, objArr);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(78617);
    }
}
