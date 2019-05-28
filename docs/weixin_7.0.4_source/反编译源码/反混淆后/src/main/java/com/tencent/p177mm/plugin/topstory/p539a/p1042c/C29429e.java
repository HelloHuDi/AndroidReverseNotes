package com.tencent.p177mm.plugin.topstory.p539a.p1042c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C40577ue;
import com.tencent.p177mm.protocal.protobuf.bqf;
import com.tencent.p177mm.protocal.protobuf.bqg;
import com.tencent.p177mm.protocal.protobuf.chv;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.topstory.a.c.e */
public final class C29429e extends C1207m implements C1918k {
    public C7472b ehh;
    private C1202f ehi;
    private chv sBa;

    public C29429e(chv chv, List<String> list) {
        AppMethodBeat.m2504i(96389);
        C4990ab.m7416i("MicroMsg.TopStory.NetSceneTopStory", "Create NetSceneTopStoryGetVideoUrl Video");
        this.sBa = chv;
        C1196a c1196a = new C1196a();
        c1196a.uri = "/cgi-bin/mmsearch-bin/recommendgetvideourl";
        c1196a.fsJ = new bqf();
        c1196a.fsK = new bqg();
        this.ehh = c1196a.acD();
        bqf bqf = (bqf) this.ehh.fsG.fsP;
        for (String str : list) {
            C40577ue c40577ue = new C40577ue();
            c40577ue.wbI = str;
            bqf.wSy.add(c40577ue);
        }
        AppMethodBeat.m2505o(96389);
    }

    public final int getType() {
        return 2579;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(96390);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(96390);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(96391);
        C4990ab.m7417i("MicroMsg.TopStory.NetSceneTopStory", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(96391);
    }
}
