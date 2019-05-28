package com.tencent.mm.chatroom.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b;
import com.tencent.mm.protocal.protobuf.fm;
import com.tencent.mm.protocal.protobuf.fn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public final class c extends a<fn> {
    public c(long j, String str, String str2, String str3, LinkedList<String> linkedList) {
        AppMethodBeat.i(103908);
        ab.d("MicroMsg.CgiApproveAddChatRoomMember", "inviterusername%s,roomname:%s,ticket:%s,username:%s approvenewmsgid:%s", str, str2, bo.anv(str3), linkedList, Long.valueOf(j));
        fm fmVar = new fm();
        fmVar.fLi = str;
        fmVar.geY = str2;
        fmVar.cxb = str3;
        fmVar.vHv = linkedList;
        fmVar.vHw = j;
        b.a aVar = new b.a();
        aVar.fsJ = fmVar;
        aVar.fsK = new fn();
        aVar.uri = "/cgi-bin/micromsg-bin/approveaddchatroommember";
        this.ehh = aVar.acD();
        AppMethodBeat.o(103908);
    }
}
