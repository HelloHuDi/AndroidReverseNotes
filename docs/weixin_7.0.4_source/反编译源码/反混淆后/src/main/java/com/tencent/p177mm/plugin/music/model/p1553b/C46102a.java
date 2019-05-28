package com.tencent.p177mm.plugin.music.model.p1553b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.music.model.p1000e.C28575a;
import com.tencent.p177mm.protocal.protobuf.C15382rm;
import com.tencent.p177mm.protocal.protobuf.C35947rl;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.music.model.b.a */
public final class C46102a extends C1207m implements C1918k {
    private C1202f ehi;
    private C7472b fAT;
    public C35947rl oMF;

    public C46102a(int i, C28575a c28575a) {
        AppMethodBeat.m2504i(104962);
        C1196a c1196a = new C1196a();
        c1196a.uri = "/cgi-bin/micromsg-bin/checkmusic";
        c1196a.fsJ = new C35947rl();
        c1196a.fsK = new C15382rm();
        this.fAT = c1196a.acD();
        this.oMF = (C35947rl) this.fAT.fsG.fsP;
        this.oMF.Scene = i;
        this.oMF.fKh = c28575a.field_appId;
        this.oMF.vYH = c28575a.field_songAlbumUrl;
        this.oMF.vYI = c28575a.field_songHAlbumUrl;
        this.oMF.vYK = c28575a.field_songWifiUrl;
        this.oMF.vYL = c28575a.field_songWapLinkUrl;
        this.oMF.vYJ = c28575a.field_songWebUrl;
        this.oMF.Title = c28575a.field_songName;
        this.oMF.fJU = c28575a.field_musicId;
        AppMethodBeat.m2505o(104962);
    }

    public final int getType() {
        return 940;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(104963);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.fAT, this);
        AppMethodBeat.m2505o(104963);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(104964);
        C4990ab.m7417i("MicroMsg.Music.NetSceneCheckMusic", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(104964);
    }
}
