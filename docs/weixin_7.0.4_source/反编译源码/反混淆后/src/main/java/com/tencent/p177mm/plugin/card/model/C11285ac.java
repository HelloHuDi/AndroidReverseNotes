package com.tencent.p177mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C24699w;
import com.tencent.p177mm.protocal.protobuf.agr;
import com.tencent.p177mm.protocal.protobuf.ags;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.card.model.ac */
public final class C11285ac extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;
    public LinkedList<String> kaF;
    public int kaH;
    public int kaI;
    public int kaJ;

    public C11285ac(String str) {
        AppMethodBeat.m2504i(87901);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new agr();
        c1196a.fsK = new ags();
        c1196a.uri = "/cgi-bin/micromsg-bin/getcardserial";
        c1196a.fsI = C24699w.CTRL_INDEX;
        this.ehh = c1196a.acD();
        ((agr) this.ehh.fsG.fsP).cMC = str;
        AppMethodBeat.m2505o(87901);
    }

    public final int getType() {
        return C24699w.CTRL_INDEX;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(87902);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(87902);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(87903);
        C4990ab.m7417i("MicroMsg.NetSceneGetCardSerial", "onGYNetEnd, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            ags ags = (ags) this.ehh.fsH.fsP;
            this.kaF = ags.kaF;
            this.kaH = ags.kaH;
            this.kaI = ags.kaI;
            this.kaJ = ags.kaJ;
        }
        C4990ab.m7417i("MicroMsg.NetSceneGetCardSerial", "onGYNetEnd, resp request_time = %d, request_count = %d, refresh_interval = %d,", Integer.valueOf(this.kaH), Integer.valueOf(this.kaI), Integer.valueOf(this.kaJ));
        if (this.kaF != null) {
            C4990ab.m7416i("MicroMsg.NetSceneGetCardSerial", "onGYNetEnd, resp codes size is " + this.kaF.size());
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(87903);
    }
}
