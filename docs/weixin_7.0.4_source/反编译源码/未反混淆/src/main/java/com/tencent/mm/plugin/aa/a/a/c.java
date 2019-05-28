package com.tencent.mm.plugin.aa.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b;
import com.tencent.mm.protocal.protobuf.w;
import com.tencent.mm.protocal.protobuf.x;
import com.tencent.mm.sdk.platformtools.ab;

public final class c extends a<x> {
    public c(int i, int i2, int i3, String str, int i4, int i5, String str2) {
        AppMethodBeat.i(40641);
        b.a aVar = new b.a();
        w wVar = new w();
        wVar.limit = i;
        wVar.offset = i2;
        wVar.type = i3;
        wVar.vAz = str;
        wVar.vAA = i4;
        wVar.vAB = i5;
        wVar.vAC = str2;
        aVar.fsJ = wVar;
        aVar.fsK = new x();
        aVar.uri = "/cgi-bin/mmpay-bin/newaaquerylist";
        this.ehh = aVar.acD();
        ab.i("MicroMsg.CgiAAQueryList", "CgiAAQueryList, limit: %s, offset: %s, type: %s, bill_id: %s, trans_id: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str, str2);
        AppMethodBeat.o(40641);
    }

    public c(int i, int i2, int i3) {
        AppMethodBeat.i(40642);
        b.a aVar = new b.a();
        w wVar = new w();
        wVar.limit = i;
        wVar.offset = i2;
        wVar.type = i3;
        aVar.fsJ = wVar;
        aVar.fsK = new x();
        aVar.uri = "/cgi-bin/mmpay-bin/newaaquerylist";
        this.ehh = aVar.acD();
        ab.i("MicroMsg.CgiAAQueryList", "CgiAAQueryList, limit: %s, offset: %s, type: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(40642);
    }
}
