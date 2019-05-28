package com.tencent.p177mm.plugin.qmessage.p739a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.ajt;
import com.tencent.p177mm.protocal.protobuf.aju;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.qmessage.a.c */
public final class C7026c extends C1207m implements C1918k {
    public final C7472b fSY;
    private C1202f psJ;

    public C7026c() {
        AppMethodBeat.m2504i(24076);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new ajt();
        c1196a.fsK = new aju();
        c1196a.uri = "/cgi-bin/micromsg-bin/getimunreadmsgcount";
        this.fSY = c1196a.acD();
        AppMethodBeat.m2505o(24076);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(24077);
        C4990ab.m7411d("MicroMsg.NetSceneGetImUnreadMsgCount", "end get im unread msg count, errType: %d, errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.psJ.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(24077);
    }

    public final int getType() {
        return 630;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(24078);
        C4990ab.m7410d("MicroMsg.NetSceneGetImUnreadMsgCount", "get im unread msg count");
        this.psJ = c1202f;
        int a = mo4457a(c1902e, this.fSY, this);
        AppMethodBeat.m2505o(24078);
        return a;
    }
}
