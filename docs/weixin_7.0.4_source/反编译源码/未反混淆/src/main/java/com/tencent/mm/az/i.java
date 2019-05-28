package com.tencent.mm.az;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.sdk.e.k;

public final class i extends k implements j {
    public static final String[] fnj = new String[]{"CREATE TABLE IF NOT EXISTS oplog2 ( id INTEGER PRIMARY KEY , inserTime long , cmdId int , buffer blob , reserved1 int , reserved2 long , reserved3 text , reserved4 text ) "};
    h fni;

    public i(h hVar) {
        this.fni = hVar;
    }

    public final boolean b(b bVar) {
        AppMethodBeat.i(990);
        if (bVar == null) {
            AppMethodBeat.o(990);
            return true;
        }
        if (this.fni.delete("oplog2", "id= ? AND inserTime= ?", new String[]{bVar.id, bVar.fCv}) >= 0) {
            AppMethodBeat.o(990);
            return true;
        }
        AppMethodBeat.o(990);
        return false;
    }
}
