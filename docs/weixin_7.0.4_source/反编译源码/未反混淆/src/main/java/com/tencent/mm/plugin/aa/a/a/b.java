package com.tencent.mm.plugin.aa.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.protocal.protobuf.r;
import com.tencent.mm.protocal.protobuf.s;
import com.tencent.mm.sdk.platformtools.ab;

public final class b extends a<s> {
    public b(String str, String str2, int i) {
        AppMethodBeat.i(40640);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        r rVar = new r();
        rVar.vzL = str;
        rVar.vzM = str2;
        rVar.scene = i;
        aVar.fsJ = rVar;
        aVar.fsK = new s();
        aVar.uri = "/cgi-bin/mmpay-bin/newaapayurge";
        this.ehh = aVar.acD();
        ab.i("MicroMsg.CgiAAPayUrge", "CgiAAPayUrge, billNo: %s, chatroom: %s, scene: %s", str, str2, Integer.valueOf(i));
        AppMethodBeat.o(40640);
    }
}
