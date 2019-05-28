package com.tencent.p177mm.plugin.topstory.p539a.p1042c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C23444tf;
import com.tencent.p177mm.protocal.protobuf.C44169tg;
import com.tencent.p177mm.protocal.protobuf.C44170th;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.topstory.a.c.h */
public final class C39962h extends C1207m implements C1918k {
    public C7472b ehh;
    private C1202f ehi;
    public int fLW = 0;
    private long sAZ;
    private List<String> sBb;
    private List<Integer> sBc;

    public C39962h(C39962h c39962h) {
        AppMethodBeat.m2504i(96395);
        C4990ab.m7417i("MicroMsg.TopStory.NetSceneTopStorySetBlockList", "copy NetSceneTopStorySetBlockList", Integer.valueOf(c39962h.sBb.size()), Integer.valueOf(c39962h.sBc.size()));
        this.fLW = c39962h.fLW;
        m68424n(c39962h.sBb, c39962h.sBc);
        AppMethodBeat.m2505o(96395);
    }

    public C39962h(List<String> list, List<Integer> list2) {
        AppMethodBeat.m2504i(96396);
        C4990ab.m7417i("MicroMsg.TopStory.NetSceneTopStorySetBlockList", "create NetSceneTopStorySetBlockList, users size:%s, type size:%s", Integer.valueOf(list.size()), Integer.valueOf(list2.size()));
        m68424n(list, list2);
        AppMethodBeat.m2505o(96396);
    }

    /* renamed from: n */
    private void m68424n(List<String> list, List<Integer> list2) {
        AppMethodBeat.m2504i(96397);
        this.sAZ = System.currentTimeMillis();
        this.sBb = list;
        this.sBc = list2;
        C1196a c1196a = new C1196a();
        c1196a.fsI = 2859;
        c1196a.uri = "/cgi-bin/mmsearch-bin/colikeblock";
        c1196a.fsJ = new C23444tf();
        c1196a.fsK = new C44170th();
        this.ehh = c1196a.acD();
        C23444tf c23444tf = (C23444tf) this.ehh.fsG.fsP;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                C44169tg c44169tg = new C44169tg();
                c44169tg.cts = ((Integer) list2.get(i2)).intValue();
                c44169tg.vHl = (String) list.get(i2);
                c23444tf.vHk.add(c44169tg);
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(96397);
                return;
            }
        }
    }

    public final int getType() {
        return 2859;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(96398);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(96398);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(96399);
        C4990ab.m7417i("MicroMsg.TopStory.NetSceneTopStorySetBlockList", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str, Long.valueOf(System.currentTimeMillis() - this.sAZ));
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(96399);
    }
}
