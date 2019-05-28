package com.tencent.mm.plugin.aa.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b;
import com.tencent.mm.protocal.protobuf.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class d extends a<c> {
    public d(String str, String str2) {
        AppMethodBeat.i(40643);
        b.a aVar = new b.a();
        com.tencent.mm.protocal.protobuf.b bVar = new com.tencent.mm.protocal.protobuf.b();
        bVar.vzL = str;
        bVar.vzM = str2;
        aVar.fsJ = bVar;
        aVar.fsK = new c();
        aVar.uri = "/cgi-bin/mmpay-bin/newaaclosenotify";
        this.ehh = aVar.acD();
        ab.i("MicroMsg.CgiCloseAAUrgeNotify", "CgiCloseAAUrgeNotify, billNo: %s, chatroom: %s", str, str2);
        AppMethodBeat.o(40643);
    }
}
