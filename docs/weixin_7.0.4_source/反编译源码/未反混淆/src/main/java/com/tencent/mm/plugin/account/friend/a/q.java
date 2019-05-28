package com.tencent.mm.plugin.account.friend.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.bo;

public final class q extends k {
    public static final String[] fnj = new String[]{"CREATE TABLE IF NOT EXISTS invitefriendopen ( username text  PRIMARY KEY , friendtype int  , updatetime int  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  ) "};
    private h fni;

    public q(h hVar) {
        this.fni = hVar;
    }

    private boolean a(p pVar) {
        AppMethodBeat.i(108402);
        if (pVar == null) {
            AppMethodBeat.o(108402);
            return false;
        }
        pVar.bJt = -1;
        if (((int) this.fni.insert("invitefriendopen", "username", pVar.Hl())) != -1) {
            AppMethodBeat.o(108402);
            return true;
        }
        AppMethodBeat.o(108402);
        return false;
    }

    public final boolean b(p pVar) {
        AppMethodBeat.i(108403);
        boolean c;
        if (wi(pVar.getUsername())) {
            c = c(pVar);
            AppMethodBeat.o(108403);
            return c;
        }
        c = a(pVar);
        AppMethodBeat.o(108403);
        return c;
    }

    public final boolean wi(String str) {
        AppMethodBeat.i(108405);
        Cursor a = this.fni.a("select invitefriendopen.username,invitefriendopen.friendtype,invitefriendopen.updatetime,invitefriendopen.reserved1,invitefriendopen.reserved2,invitefriendopen.reserved3,invitefriendopen.reserved4 from invitefriendopen   where invitefriendopen.username = \"" + bo.vA(String.valueOf(str)) + "\"", null, 2);
        boolean moveToFirst = a.moveToFirst();
        a.close();
        AppMethodBeat.o(108405);
        return moveToFirst;
    }

    private boolean c(p pVar) {
        AppMethodBeat.i(108404);
        pVar.bJt = -1;
        if (this.fni.update("invitefriendopen", pVar.Hl(), "username=?", new String[]{pVar.getUsername()}) > 0) {
            AppMethodBeat.o(108404);
            return true;
        }
        AppMethodBeat.o(108404);
        return false;
    }
}
