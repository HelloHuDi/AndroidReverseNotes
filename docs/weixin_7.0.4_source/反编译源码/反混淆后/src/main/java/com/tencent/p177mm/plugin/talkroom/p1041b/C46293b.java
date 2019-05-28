package com.tencent.p177mm.plugin.talkroom.p1041b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C30250yw;
import com.tencent.p177mm.protocal.protobuf.C30251yx;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.talkroom.b.b */
public final class C46293b extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;
    private int sceneType;

    public C46293b(int i, long j, String str, int i2) {
        AppMethodBeat.m2504i(25872);
        this.sceneType = i2;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C30250yw();
        c1196a.fsK = new C30251yx();
        c1196a.uri = "/cgi-bin/micromsg-bin/exittalkroom";
        this.ehh = c1196a.acD();
        C30250yw c30250yw = (C30250yw) this.ehh.fsG.fsP;
        c30250yw.wel = str;
        c30250yw.wem = i;
        c30250yw.wen = j;
        c30250yw.Scene = i2;
        AppMethodBeat.m2505o(25872);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(25873);
        C4990ab.m7411d("MicroMsg.NetSceneExitTalkRoom", "doScene %d", Integer.valueOf(this.sceneType));
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(25873);
        return a;
    }

    public final int getType() {
        return 333;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(25874);
        C4990ab.m7410d("MicroMsg.NetSceneExitTalkRoom", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(25874);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(25874);
    }
}
