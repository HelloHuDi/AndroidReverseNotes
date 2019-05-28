package com.tencent.p177mm.plugin.topstory.p539a.p1042c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.ahm;
import com.tencent.p177mm.protocal.protobuf.ahn;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.topstory.a.c.c */
public final class C46296c extends C1207m implements C1918k {
    public C7472b ehh;
    private C1202f ehi;
    private long sAZ = System.currentTimeMillis();
    public int type;

    public C46296c(int i) {
        AppMethodBeat.m2504i(96386);
        this.type = i;
        C1196a c1196a = new C1196a();
        c1196a.fsI = 2748;
        c1196a.uri = "/cgi-bin/mmsearch-bin/getcolikeblocklist";
        c1196a.fsJ = new ahm();
        c1196a.fsK = new ahn();
        this.ehh = c1196a.acD();
        ((ahm) this.ehh.fsG.fsP).jCt = i;
        C4990ab.m7417i("MicroMsg.TopStory.NetSceneTopStoryGetBlockList", "request NetSceneTopStoryGetBlockList: %d", Integer.valueOf(i));
        AppMethodBeat.m2505o(96386);
    }

    public final int getType() {
        return 2748;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(96387);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(96387);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(96388);
        C4990ab.m7417i("MicroMsg.TopStory.NetSceneTopStoryGetBlockList", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str, Long.valueOf(System.currentTimeMillis() - this.sAZ));
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(96388);
    }
}
