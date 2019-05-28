package com.tencent.p177mm.chatroom.p710c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bxt;
import com.tencent.p177mm.protocal.protobuf.bxu;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.smtt.utils.TbsLog;

/* renamed from: com.tencent.mm.chatroom.c.o */
public final class C32441o extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;

    public C32441o(String str, String str2) {
        AppMethodBeat.m2504i(103947);
        C1196a c1196a = new C1196a();
        bxt bxt = new bxt();
        bxt.vEf = str;
        bxt.wny = str2;
        c1196a.fsJ = bxt;
        c1196a.fsK = new bxu();
        c1196a.uri = "/cgi-bin/micromsg-bin/setchatroomannouncement";
        c1196a.fsI = TbsLog.TBSLOG_CODE_SDK_CONFLICT_X5CORE;
        this.ehh = c1196a.acD();
        AppMethodBeat.m2505o(103947);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(103948);
        C4990ab.m7420w("MicroMsg.NetSceneSetChatRoomAnnouncement", "errType = " + i2 + " errCode " + i3 + " errMsg " + str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(103948);
    }

    public final int getType() {
        return TbsLog.TBSLOG_CODE_SDK_CONFLICT_X5CORE;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(103949);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(103949);
        return a;
    }
}
