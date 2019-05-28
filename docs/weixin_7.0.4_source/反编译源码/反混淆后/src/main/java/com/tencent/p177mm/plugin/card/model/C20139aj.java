package com.tencent.p177mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.protocal.protobuf.aen;
import com.tencent.p177mm.protocal.protobuf.aeo;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.card.model.aj */
public final class C20139aj extends C1207m implements C1918k {
    public boolean eTf;
    private final C7472b ehh;
    private C1202f ehi;
    public String kdS;
    public C1332b keu;

    public C20139aj(String str, int i, String str2, String str3, int i2, String str4, String str5, String str6, C1332b c1332b) {
        AppMethodBeat.m2504i(87922);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new aen();
        c1196a.fsK = new aeo();
        c1196a.uri = "/cgi-bin/micromsg-bin/getavailablecard";
        this.ehh = c1196a.acD();
        aen aen = (aen) this.ehh.fsG.fsP;
        aen.app_id = str;
        aen.kmq = i;
        aen.kmr = str2;
        aen.kms = str3;
        aen.time_stamp = i2;
        aen.kmt = str4;
        aen.kbU = str5;
        aen.kmu = str6;
        aen.keu = c1332b;
        if ("INVOICE".equalsIgnoreCase(str6)) {
            aen.wmp = 1;
            AppMethodBeat.m2505o(87922);
            return;
        }
        aen.wmp = 0;
        AppMethodBeat.m2505o(87922);
    }

    public final int getType() {
        return 664;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(87923);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(87923);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(87924);
        C4990ab.m7416i("MicroMsg.NetsceneGetAvailableCard", "onGYNetEnd, errType = " + i2 + " errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            aeo aeo = (aeo) this.ehh.fsH.fsP;
            this.kdS = aeo.kdS;
            this.keu = aeo.keu;
            this.eTf = aeo.wmq != 0;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(87924);
    }
}
