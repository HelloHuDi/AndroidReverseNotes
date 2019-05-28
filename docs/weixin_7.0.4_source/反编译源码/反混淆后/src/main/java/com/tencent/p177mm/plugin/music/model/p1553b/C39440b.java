package com.tencent.p177mm.plugin.music.model.p1553b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p198aw.C25847d;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.appbrand.jsapi.p309j.C41234e;
import com.tencent.p177mm.plugin.music.model.p1000e.C28575a;
import com.tencent.p177mm.protocal.protobuf.amy;
import com.tencent.p177mm.protocal.protobuf.amz;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.music.model.b.b */
public final class C39440b extends C1207m implements C1918k {
    private C1202f ehi;
    private C7472b fAT;
    public amz oMG;
    public boolean oMH;
    public C28575a oMw;

    public C39440b(C28575a c28575a, boolean z) {
        int i;
        AppMethodBeat.m2504i(104965);
        this.oMw = c28575a;
        this.oMH = z;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new amy();
        c1196a.fsK = new amz();
        c1196a.uri = "/cgi-bin/micromsg-bin/getqqmusiclyric";
        c1196a.fsI = C41234e.CTRL_INDEX;
        this.fAT = c1196a.acD();
        amy amy = (amy) this.fAT.fsG.fsP;
        amy.fKj = c28575a.field_songId;
        if (c28575a.field_songWebUrl != null) {
            amy.wrz = C1946aa.m4152ad(c28575a.field_songWebUrl.getBytes());
        }
        if (C25847d.aio()) {
            i = 0;
        } else {
            i = 1;
        }
        amy.wrA = i;
        if (C25847d.ain()) {
            i = 1;
        } else {
            i = 0;
        }
        amy.wrB = i;
        C4990ab.m7417i("MicroMsg.Music.NetSceneGetQQMusicLyric", "songId=%d, url=%s IsOutsideGFW=%d ShakeMusicGlobalSwitch=%d", Integer.valueOf(c28575a.field_songId), c28575a.field_songWebUrl, Integer.valueOf(amy.wrA), Integer.valueOf(amy.wrB));
        AppMethodBeat.m2505o(104965);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(104966);
        C4990ab.m7417i("MicroMsg.Music.NetSceneGetQQMusicLyric", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.oMG = (amz) this.fAT.fsH.fsP;
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(104966);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(104966);
    }

    public final int getType() {
        return C41234e.CTRL_INDEX;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(104967);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.fAT, this);
        AppMethodBeat.m2505o(104967);
        return a;
    }
}
