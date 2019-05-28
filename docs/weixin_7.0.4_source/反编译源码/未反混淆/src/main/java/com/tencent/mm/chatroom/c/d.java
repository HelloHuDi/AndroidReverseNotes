package com.tencent.mm.chatroom.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b;
import com.tencent.mm.protocal.protobuf.vh;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.List;

public final class d extends a<vi> {
    public d(String str, LinkedList<String> linkedList) {
        AppMethodBeat.i(103909);
        ab.d("MicroMsg.CgiAddChatRoomAdmin", "roomName:%s,username:%s", str, bo.c((List) linkedList, ";"));
        vh vhVar = new vh();
        vhVar.vEf = str;
        vhVar.vEg = linkedList;
        b.a aVar = new b.a();
        aVar.fsJ = vhVar;
        aVar.fsK = new vi();
        aVar.uri = "/cgi-bin/micromsg-bin/delchatroomadmin";
        aVar.fsI = com.tencent.view.d.MIC_PTU_ZIPAI_MEDSEA;
        this.ehh = aVar.acD();
        AppMethodBeat.o(103909);
    }
}
