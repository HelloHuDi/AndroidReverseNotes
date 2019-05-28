package com.tencent.mm.chatroom.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.protocal.protobuf.by;
import com.tencent.mm.protocal.protobuf.bz;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.List;

public final class b extends a<bz> {
    public b(String str, LinkedList<String> linkedList) {
        AppMethodBeat.i(103907);
        ab.d("MicroMsg.CgiAddChatRoomAdmin", "roomName:%s,username:%s", str, bo.c((List) linkedList, ";"));
        by byVar = new by();
        byVar.vEf = str;
        byVar.vEg = linkedList;
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = byVar;
        aVar.fsK = new bz();
        aVar.uri = "/cgi-bin/micromsg-bin/addchatroomadmin";
        this.ehh = aVar.acD();
        AppMethodBeat.o(103907);
    }
}
