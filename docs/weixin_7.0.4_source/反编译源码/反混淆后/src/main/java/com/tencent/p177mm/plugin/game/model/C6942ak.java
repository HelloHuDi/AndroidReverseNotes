package com.tencent.p177mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.acz;
import com.tencent.p177mm.protocal.protobuf.ada;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.game.model.ak */
public final class C6942ak extends C1207m implements C1918k {
    private C1202f ehi;
    public final C7472b lty;

    public C6942ak(String str, LinkedList<String> linkedList, LinkedList<String> linkedList2, int i) {
        AppMethodBeat.m2504i(111427);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new acz();
        c1196a.fsK = new ada();
        c1196a.uri = "/cgi-bin/mmgame-bin/gamecentersearch";
        this.lty = c1196a.acD();
        acz acz = (acz) this.lty.fsG.fsP;
        acz.nbs = str;
        acz.wkL = linkedList;
        acz.wkE = linkedList2;
        acz.wkM = i;
        AppMethodBeat.m2505o(111427);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(111428);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.lty, this);
        AppMethodBeat.m2505o(111428);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(111429);
        C4990ab.m7416i("MicroMsg.NetSceneGameCenterSearch", "errType = " + i2 + ", errCode = " + i3);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(111429);
    }

    public final int getType() {
        return 1328;
    }
}
