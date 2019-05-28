package com.tencent.p177mm.plugin.facedetectaction.p1483a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.wallet.C30158b;
import com.tencent.p177mm.protocal.protobuf.ait;
import com.tencent.p177mm.protocal.protobuf.aiu;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.facedetectaction.a.b */
public final class C39027b extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi;
    private ait mbU;
    public aiu mbV;

    public C39027b(String str, String str2, float f, String str3, String str4, int i, String str5, String str6) {
        AppMethodBeat.m2504i(673);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new ait();
        c1196a.fsK = new aiu();
        c1196a.uri = "/cgi-bin/mmpay-bin/getfacecheckresult";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        this.mbU = (ait) this.ehh.fsG.fsP;
        this.mbU.person_id = str;
        this.mbU.woJ = str2;
        this.mbU.woM = (int) f;
        this.mbU.woN = str3;
        this.mbU.woO = str4;
        this.mbU.scene = i;
        this.mbU.vYl = str5;
        this.mbU.kKO = str6;
        this.mbU.woh = ((C30158b) C1720g.m3528K(C30158b.class)).bQO();
        C4990ab.m7417i("MicroMsg.NetSceneGetFaceCheckResult", "create GetFaceCheckResult, personId: %s, actionData: %s, reductionRatio: %s, videoFileid: %s, scene: %s, takeMessage: %s, packageName: %s", str, str2, Float.valueOf(f), str3, Integer.valueOf(i), str5, str6);
        AppMethodBeat.m2505o(673);
    }

    public final int getType() {
        return 2726;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(674);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(674);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(675);
        C4990ab.m7417i("MicroMsg.NetSceneGetFaceCheckResult", "onGYNetEnd, errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        C7060h.pYm.mo8378a(917, i3 == 0 ? 54 : 55, 1, false);
        this.mbV = (aiu) ((C7472b) c1929q).fsH.fsP;
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(675);
    }
}
