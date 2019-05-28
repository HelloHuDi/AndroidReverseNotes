package com.tencent.p177mm.plugin.card.sharecard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.aoc;
import com.tencent.p177mm.protocal.protobuf.aod;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.card.sharecard.model.d */
public final class C20153d extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;
    public String kdS;
    public int kdT;
    public String kdU;

    public C20153d(String str, String str2, String str3) {
        AppMethodBeat.m2504i(88024);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new aoc();
        c1196a.fsK = new aod();
        c1196a.uri = "/cgi-bin/mmbiz-bin/card/getsharecardconsumedinfo";
        this.ehh = c1196a.acD();
        aoc aoc = (aoc) this.ehh.fsG.fsP;
        aoc.cMC = str;
        aoc.scene = 20;
        aoc.kbU = str2;
        aoc.code = str3;
        AppMethodBeat.m2505o(88024);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(88025);
        C4990ab.m7417i("MicroMsg.NetSceneGetShareCardConsumedInfo", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", Integer.valueOf(910), Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            aod aod = (aod) this.ehh.fsH.fsP;
            C4990ab.m7418v("MicroMsg.NetSceneGetShareCardConsumedInfo", "json:" + aod.kdS);
            this.kdS = aod.kdS;
            this.kdU = aod.kdU;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(88025);
    }

    public final int getType() {
        return 910;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(88026);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(88026);
        return a;
    }
}
