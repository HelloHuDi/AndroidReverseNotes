package com.tencent.p177mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.asl;
import com.tencent.p177mm.protocal.protobuf.asm;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.game.model.as */
public final class C28222as extends C1207m implements C1918k {
    private String appId;
    private C1202f ehi;
    final C7472b lty;

    public C28222as(String str) {
        AppMethodBeat.m2504i(111451);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new asl();
        c1196a.fsK = new asm();
        c1196a.uri = "/cgi-bin/mmgame-bin/gethvgamemenu";
        this.appId = str;
        this.lty = c1196a.acD();
        asl asl = (asl) this.lty.fsG.fsP;
        asl.nbs = C4988aa.dor();
        asl.guW = C5046bo.m7555gQ(C4996ah.getContext());
        asl.fKh = str;
        C4990ab.m7417i("MicroMsg.NetSceneHVGameGetMenu", "lang=%s, country=%s, appid=%s", asl.nbs, asl.guW, asl.fKh);
        AppMethodBeat.m2505o(111451);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(111452);
        C4990ab.m7416i("MicroMsg.NetSceneHVGameGetMenu", "errType = " + i2 + ", errCode = " + i3 + ", errMsg = " + str);
        if (i2 != 0 || i3 != 0) {
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(111452);
        } else if (((asm) ((C7472b) c1929q).fsH.fsP) == null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(111452);
        } else {
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(111452);
        }
    }

    public final int getType() {
        return 1369;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(111453);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.lty, this);
        AppMethodBeat.m2505o(111453);
        return a;
    }
}
