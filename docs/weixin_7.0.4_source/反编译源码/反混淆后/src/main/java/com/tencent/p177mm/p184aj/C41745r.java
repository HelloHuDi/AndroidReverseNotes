package com.tencent.p177mm.p184aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.protobuf.bmr;
import com.tencent.p177mm.protocal.protobuf.bms;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5059g;
import java.util.Date;

/* renamed from: com.tencent.mm.aj.r */
public final class C41745r extends C1207m implements C1918k {
    private Object data;
    public C7472b ehh;
    private C1202f ehi;

    public C41745r(C36692b c36692b, int i, int i2, Object obj) {
        AppMethodBeat.m2504i(11438);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bmr();
        c1196a.fsK = new bms();
        c1196a.uri = "/cgi-bin/mmocbiz-bin/reportpluginstat";
        this.ehh = c1196a.acD();
        bmr bmr = (bmr) this.ehh.fsG.fsP;
        bmr.wPC = 1;
        bmr.wPD = c36692b.field_wwCorpId;
        bmr.vNx = c36692b.field_wwUserVid;
        C1720g.m3534RN();
        bmr.wPE = C1668a.m3383QF();
        bmr.scene = i2;
        bmr.cuy = i;
        bmr.wPF = 0;
        bmr.wPG = new Date().getTime();
        bmr.platform = 1;
        bmr.wMv = C5059g.m7672ar(null, C7243d.vxo);
        this.data = obj;
        AppMethodBeat.m2505o(11438);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(11439);
        C4990ab.m7411d("MicroMsg.NetSceneEnterprisePushStat", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(11439);
    }

    public final int getType() {
        return 2805;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(11440);
        this.ehi = c1202f;
        C4990ab.m7416i("MicroMsg.NetSceneEnterprisePushStat", "do scene");
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(11440);
        return a;
    }
}
