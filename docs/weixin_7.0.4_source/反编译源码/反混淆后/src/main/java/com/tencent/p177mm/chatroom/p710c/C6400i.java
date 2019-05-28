package com.tencent.p177mm.chatroom.p710c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C37921n;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.aha;
import com.tencent.p177mm.protocal.protobuf.ahb;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.chatroom.c.i */
public final class C6400i extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;
    public String ehm;
    public int ehn;
    public String eho;
    public int ehp;
    private String ehq = "";

    public C6400i(String str) {
        AppMethodBeat.m2504i(103925);
        C1196a c1196a = new C1196a();
        this.ehq = str;
        aha aha = new aha();
        aha.vEf = str;
        c1196a.fsJ = aha;
        c1196a.fsK = new ahb();
        c1196a.uri = "/cgi-bin/micromsg-bin/getchatroominfodetail";
        c1196a.fsI = 223;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        AppMethodBeat.m2505o(103925);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(103926);
        C4990ab.m7420w("MicroMsg.NetSceneGetChatRoomInfoDetail", "errType = " + i2 + " errCode " + i3 + " errMsg " + str);
        if (i2 == 0 && i3 == 0) {
            C4990ab.m7410d("MicroMsg.NetSceneGetChatRoomInfoDetail", "OK");
            this.ehm = ((ahb) this.ehh.fsH.fsP).wny;
            this.ehn = ((ahb) this.ehh.fsH.fsP).ehn;
            this.eho = ((ahb) this.ehh.fsH.fsP).eho;
            this.ehp = ((ahb) this.ehh.fsH.fsP).ehp;
            int i4 = ((ahb) this.ehh.fsH.fsP).wnz;
            String str2 = this.ehm;
            C4990ab.m7417i("MicroMsg.NetSceneGetChatRoomInfoDetail", "dz[onSceneEnd : get announcement successfully!] roomId:%s newVersion:%s AnnouncementPublishTime:%s chatRoomStatus:%s", this.ehq, Integer.valueOf(this.ehn), Integer.valueOf(this.ehp), Integer.valueOf(i4));
            C37921n.m64049a(this.ehq, C5046bo.nullAsNil(str2), this.eho, (long) this.ehp, r6, i4);
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(103926);
    }

    public final int getType() {
        return 223;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(103927);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(103927);
        return a;
    }
}
