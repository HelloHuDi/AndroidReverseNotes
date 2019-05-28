package com.tencent.p177mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.arl;
import com.tencent.p177mm.protocal.protobuf.arm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.card.model.af */
public final class C45784af extends C1207m implements C1918k {
    public String cMD;
    private final C7472b ehh;
    private C1202f ehi;
    public int kdT;
    public String kdU;

    public C45784af(String str, String str2, int i) {
        AppMethodBeat.m2504i(87910);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new arl();
        c1196a.fsK = new arm();
        c1196a.uri = "/cgi-bin/micromsg-bin/giftcarditem";
        this.ehh = c1196a.acD();
        arl arl = (arl) this.ehh.fsG.fsP;
        arl.cMC = str;
        arl.wvx = str2;
        arl.wvy = i;
        AppMethodBeat.m2505o(87910);
    }

    public final int getType() {
        return 652;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(87911);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(87911);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(87912);
        C4990ab.m7416i("MicroMsg.NetSceneGiftCardItem", "onGYNetEnd, errType = " + i2 + " errCode = " + i3);
        arm arm;
        if (i2 == 0 && i3 == 0) {
            arm = (arm) this.ehh.fsH.fsP;
            if (arm != null) {
                this.cMD = arm.cMD;
                this.kdU = arm.kdU;
                this.kdT = arm.kdT;
            }
        } else {
            arm = (arm) this.ehh.fsH.fsP;
            if (arm != null) {
                this.cMD = arm.cMD;
                this.kdU = arm.kdU;
                this.kdT = arm.kdT;
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(87912);
    }
}
