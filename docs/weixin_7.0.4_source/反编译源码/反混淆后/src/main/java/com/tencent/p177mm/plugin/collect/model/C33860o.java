package com.tencent.p177mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.byd;
import com.tencent.p177mm.protocal.protobuf.bye;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.collect.model.o */
public final class C33860o extends C1207m implements C1918k {
    private C1202f ehi;
    private C7472b gme;
    private byd kCC;

    public C33860o(String str) {
        AppMethodBeat.m2504i(40986);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new byd();
        c1196a.fsK = new bye();
        c1196a.uri = "/cgi-bin/micromsg-bin/setpushsound";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.gme = c1196a.acD();
        this.kCC = (byd) this.gme.fsG.fsP;
        this.kCC.jCt = 3;
        this.kCC.wXD = str;
        C4990ab.m7417i("MicroMsg.NetSceneSetPushSound", "type: %d, sound: %s", Integer.valueOf(3), str);
        AppMethodBeat.m2505o(40986);
    }

    public final int getType() {
        return 304;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(40987);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.gme, this);
        AppMethodBeat.m2505o(40987);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(40988);
        C4990ab.m7417i("MicroMsg.NetSceneSetPushSound", "errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(40988);
    }
}
