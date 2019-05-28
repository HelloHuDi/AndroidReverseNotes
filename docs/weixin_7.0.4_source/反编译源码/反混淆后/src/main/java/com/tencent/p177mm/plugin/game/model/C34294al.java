package com.tencent.p177mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.acw;
import com.tencent.p177mm.protocal.protobuf.acx;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.game.model.al */
public final class C34294al extends C1207m implements C1918k {
    public String ctj;
    private C1202f ehi;
    public final C7472b lty;

    public C34294al(String str, String str2, LinkedList<String> linkedList) {
        AppMethodBeat.m2504i(111430);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new acw();
        c1196a.fsK = new acx();
        c1196a.uri = "/cgi-bin/mmgame-bin/gamecentersearchrecommend";
        if (str2 == null) {
            this.ctj = "";
        } else {
            this.ctj = str2.trim();
        }
        this.lty = c1196a.acD();
        acw acw = (acw) this.lty.fsG.fsP;
        acw.nbs = str;
        acw.wkD = str2;
        acw.wkE = linkedList;
        AppMethodBeat.m2505o(111430);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(111431);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.lty, this);
        AppMethodBeat.m2505o(111431);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(111432);
        C4990ab.m7416i("MicroMsg.NetSceneGameSearchRecmd", "errType = " + i2 + ", errCode = " + i3);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(111432);
    }

    public final int getType() {
        return 1329;
    }
}
