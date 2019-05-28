package com.tencent.p177mm.sandbox.p758a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelsimple.C32823ac;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p209c.C41914i;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.plugin.p1283p.C21427b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sandbox.SubCoreSandBox;
import com.tencent.p177mm.protocal.protobuf.apg;
import com.tencent.p177mm.protocal.protobuf.aph;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5059g;

/* renamed from: com.tencent.mm.sandbox.a.a */
public final class C7291a extends C1207m implements C1918k, C21427b {
    public final C7472b ehh;
    private C1202f ehi;

    public C7291a(int i) {
        AppMethodBeat.m2504i(28779);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new apg();
        c1196a.fsK = new aph();
        c1196a.uri = "/cgi-bin/micromsg-bin/getupdateinfo";
        this.ehh = c1196a.acD();
        apg apg = (apg) this.ehh.fsG.fsP;
        apg.wth = i;
        apg.vAM = C5059g.cdf;
        if (10012 == C1947ae.giz && C1947ae.giA > 0) {
            apg.vAM = C1947ae.giA;
        }
        switch (i) {
            case 1:
                C7060h.pYm.mo8378a(405, 3, 1, true);
                break;
            case 2:
                C7060h.pYm.mo8378a(405, 4, 1, true);
                break;
            case 3:
                C7060h.pYm.mo8378a(405, 5, 1, true);
                break;
            case 4:
                C7060h.pYm.mo8378a(405, 6, 1, true);
                break;
        }
        C4990ab.m7417i("MicroMsg.NetSceneGetUpdateInfo", "summerupdate dkchan NetSceneGetUpdateInfo updateType:%d channel:%d release:%d, stack[%s]", Integer.valueOf(apg.wth), Integer.valueOf(apg.vAM), Integer.valueOf(C5059g.cdf), C5046bo.dpG());
        AppMethodBeat.m2505o(28779);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(28780);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(28780);
        return a;
    }

    public final int getType() {
        return 11;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(28781);
        C4990ab.m7417i("MicroMsg.NetSceneGetUpdateInfo", "summertoken GetUpdateInfo onGYNetEnd errType[%d], errCode[%d], errMsg[%s]", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            C7060h.pYm.mo8378a(405, 7, 1, true);
        } else {
            C7060h.pYm.mo8378a(405, 8, 1, true);
            if (i2 == 4) {
                C7060h.pYm.mo8378a(405, 9, 1, true);
                if (i3 == -16) {
                    C7060h.pYm.mo8378a(405, 10, 1, true);
                } else if (i3 == -17) {
                    C7060h.pYm.mo8378a(405, 11, 1, true);
                } else if (i3 == -18) {
                    C7060h.pYm.mo8378a(405, 12, 1, true);
                }
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        String dnb = dnb();
        if (dnb != null) {
            C41914i cO = C41914i.m74023cO(dnb);
            if (cO != null) {
                C4990ab.m7417i("MicroMsg.NetSceneGetUpdateInfo", "summertoken patchVersionCode[%d]", Integer.valueOf(cO.versionCode));
                C9638aw.m17182Rg().mo14541a(new C32823ac(C4996ah.getPackageName(), r0), 0);
                C7060h.pYm.mo8378a(405, 13, 1, true);
                AppMethodBeat.m2505o(28781);
                return;
            }
            C4990ab.m7417i("MicroMsg.NetSceneGetUpdateInfo", "summertoken patchInfo is null patchXml[%s]", dnb);
            AppMethodBeat.m2505o(28781);
            return;
        }
        C4990ab.m7420w("MicroMsg.NetSceneGetUpdateInfo", "summertoken patchXml is null!");
        C7060h.pYm.mo8378a(405, 14, 1, true);
        AppMethodBeat.m2505o(28781);
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
        AppMethodBeat.m2504i(28782);
        aph aph = (aph) this.ehh.fsH.fsP;
        String[] strArr = new String[aph.wtn.size()];
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            strArr[i] = ((bts) aph.wtn.get(i)).wVI;
        }
        AppMethodBeat.m2505o(28782);
        return strArr;
    }

    public final String dnb() {
        AppMethodBeat.m2504i(28783);
        C4990ab.m7411d("MicroMsg.NetSceneGetUpdateInfo", "summertoken getPatchInfo[%s], stack[%s]", ((aph) this.ehh.fsH.fsP).wto, C5046bo.dpG());
        String str = r0.wto;
        AppMethodBeat.m2505o(28783);
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
