package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ji;
import com.tencent.mm.protocal.protobuf.jj;
import com.tencent.mm.sdk.platformtools.ab;

public final class w extends m implements k {
    public static int gvL = 0;
    public static int gvM = 1;
    public static int gvN = -85;
    private final b ehh;
    private f ehi;
    private int gvO = -1;
    private String gvP;
    private int gvQ = 0;

    public enum a {
        MM_BIND_GCONTACT_OPCODE_BIND,
        MM_BIND_GCONTACT_OPCODE_UNBIND;

        static {
            AppMethodBeat.o(108424);
        }
    }

    public w(a aVar, String str, int i) {
        AppMethodBeat.i(108425);
        switch (aVar) {
            case MM_BIND_GCONTACT_OPCODE_BIND:
                this.gvO = 1;
                break;
            case MM_BIND_GCONTACT_OPCODE_UNBIND:
                this.gvO = 2;
                break;
        }
        this.gvP = str;
        this.gvQ = i;
        com.tencent.mm.ai.b.a aVar2 = new com.tencent.mm.ai.b.a();
        aVar2.fsJ = new ji();
        aVar2.fsK = new jj();
        aVar2.uri = "/cgi-bin/micromsg-bin/bindgooglecontact";
        aVar2.fsI = 487;
        aVar2.fsL = 0;
        aVar2.fsM = 0;
        this.ehh = aVar2.acD();
        AppMethodBeat.o(108425);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(108426);
        ab.i("MicroMsg.GoogleContact.NetSceneInviteGoogleContact", "doScene");
        this.ehi = fVar;
        ji jiVar = (ji) this.ehh.fsG.fsP;
        jiVar.vIJ = this.gvO;
        jiVar.vLf = this.gvP;
        jiVar.vLg = this.gvQ;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(108426);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(108427);
        ab.i("MicroMsg.GoogleContact.NetSceneInviteGoogleContact", "NetId:%d, ErrType:%d, ErrCode:%d, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(108427);
    }

    public final int getType() {
        return 487;
    }
}
