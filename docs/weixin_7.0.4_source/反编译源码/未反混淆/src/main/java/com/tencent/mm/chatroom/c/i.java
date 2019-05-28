package com.tencent.mm.chatroom.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aha;
import com.tencent.mm.protocal.protobuf.ahb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class i extends m implements k {
    private final b ehh;
    private f ehi;
    public String ehm;
    public int ehn;
    public String eho;
    public int ehp;
    private String ehq = "";

    public i(String str) {
        AppMethodBeat.i(103925);
        a aVar = new a();
        this.ehq = str;
        aha aha = new aha();
        aha.vEf = str;
        aVar.fsJ = aha;
        aVar.fsK = new ahb();
        aVar.uri = "/cgi-bin/micromsg-bin/getchatroominfodetail";
        aVar.fsI = 223;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        AppMethodBeat.o(103925);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(103926);
        ab.w("MicroMsg.NetSceneGetChatRoomInfoDetail", "errType = " + i2 + " errCode " + i3 + " errMsg " + str);
        if (i2 == 0 && i3 == 0) {
            ab.d("MicroMsg.NetSceneGetChatRoomInfoDetail", "OK");
            this.ehm = ((ahb) this.ehh.fsH.fsP).wny;
            this.ehn = ((ahb) this.ehh.fsH.fsP).ehn;
            this.eho = ((ahb) this.ehh.fsH.fsP).eho;
            this.ehp = ((ahb) this.ehh.fsH.fsP).ehp;
            int i4 = ((ahb) this.ehh.fsH.fsP).wnz;
            String str2 = this.ehm;
            ab.i("MicroMsg.NetSceneGetChatRoomInfoDetail", "dz[onSceneEnd : get announcement successfully!] roomId:%s newVersion:%s AnnouncementPublishTime:%s chatRoomStatus:%s", this.ehq, Integer.valueOf(this.ehn), Integer.valueOf(this.ehp), Integer.valueOf(i4));
            n.a(this.ehq, bo.nullAsNil(str2), this.eho, (long) this.ehp, r6, i4);
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(103926);
    }

    public final int getType() {
        return 223;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(103927);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(103927);
        return a;
    }
}
