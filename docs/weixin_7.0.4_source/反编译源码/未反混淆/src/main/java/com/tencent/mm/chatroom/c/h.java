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
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.vj;
import com.tencent.mm.protocal.protobuf.vk;
import com.tencent.mm.protocal.protobuf.vt;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;
import java.util.List;

public final class h extends m implements k {
    public List<String> cFX;
    private b ehh;
    private f ehi;

    public h(String str, List<String> list, int i) {
        AppMethodBeat.i(103922);
        a aVar = new a();
        aVar.fsJ = new vj();
        aVar.fsK = new vk();
        aVar.uri = "/cgi-bin/micromsg-bin/delchatroommember";
        this.ehh = aVar.acD();
        vj vjVar = (vj) this.ehh.fsG.fsP;
        vjVar.vEf = str;
        LinkedList linkedList = new LinkedList();
        for (String str2 : list) {
            vt vtVar = new vt();
            vtVar.wcG = aa.vy(str2);
            linkedList.add(vtVar);
        }
        vjVar.vEh = linkedList;
        vjVar.ehB = linkedList.size();
        vjVar.Scene = i;
        this.cFX = list;
        AppMethodBeat.o(103922);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(103923);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(103923);
        return a;
    }

    public final int getType() {
        return 179;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(103924);
        ab.d("MicroMsg.NetSceneDelChatRoomMember", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        vj vjVar = (vj) this.ehh.fsG.fsP;
        vk vkVar = (vk) this.ehh.fsH.fsP;
        if (this.ehh.fsH.vyl != 0) {
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(103924);
            return;
        }
        n.a(vjVar.vEf, vkVar);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(103924);
    }
}
