package com.tencent.p177mm.plugin.topstory.p539a.p1042c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.protocal.protobuf.C30226te;
import com.tencent.p177mm.protocal.protobuf.C44171ti;
import com.tencent.p177mm.protocal.protobuf.C44172tj;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.topstory.a.c.g */
public final class C29430g extends C1207m implements C1918k {
    public C7472b ehh;
    private C1202f ehi;
    private long sAZ = System.currentTimeMillis();

    public C29430g(long j, String str, String str2, String str3, C40439f c40439f, String str4) {
        AppMethodBeat.m2504i(96392);
        C4990ab.m7417i("MicroMsg.TopStory.NetSceneTopStoryPostVideo", "Create NetSceneTopStoryPostVideo ts:%s, extInfo:%s, comment:%s, requestId:%s, appVersion:%s", Long.valueOf(j), str, str2, str3, str4);
        C1196a c1196a = new C1196a();
        c1196a.fsI = 2534;
        c1196a.uri = "/cgi-bin/mmsearch-bin/colikepost";
        c1196a.fsJ = new C44171ti();
        c1196a.fsK = new C44172tj();
        this.ehh = c1196a.acD();
        C44171ti c44171ti = (C44171ti) this.ehh.fsG.fsP;
        c44171ti.timestamp = j;
        c44171ti.way = str;
        c44171ti.vGv = str2;
        c44171ti.nQB = str3;
        c44171ti.waz = new C30226te();
        c44171ti.waz.appName = c40439f.field_appName;
        c44171ti.waz.appId = c40439f.field_appId;
        c44171ti.waz.version = str4;
        AppMethodBeat.m2505o(96392);
    }

    public final int getType() {
        return 2534;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(96393);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(96393);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(96394);
        C4990ab.m7417i("MicroMsg.TopStory.NetSceneTopStoryPostVideo", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str, Long.valueOf(System.currentTimeMillis() - this.sAZ));
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(96394);
    }
}
