package com.tencent.mm.ba;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.bo;
import junit.framework.Assert;

public final class b extends k {
    public static final String[] fnj = new String[]{"CREATE TABLE IF NOT EXISTS chattingbginfo ( username text  PRIMARY KEY , bgflag int  , path text  , reserved1 text  , reserved2 text  , reserved3 int  , reserved4 int  ) "};
    public h fni;

    public b(h hVar) {
        this.fni = hVar;
    }

    public final boolean b(a aVar) {
        AppMethodBeat.i(78434);
        Assert.assertTrue(aVar != null);
        ContentValues Hl = aVar.Hl();
        if (Hl.size() > 0) {
            if (this.fni.update("chattingbginfo", Hl, "username= ?", new String[]{aVar.getUsername()}) > 0) {
                anF(aVar.getUsername());
                AppMethodBeat.o(78434);
                return true;
            }
        }
        AppMethodBeat.o(78434);
        return false;
    }

    public final a sU(String str) {
        a aVar = null;
        AppMethodBeat.i(78435);
        Cursor a = this.fni.a("select chattingbginfo.username,chattingbginfo.bgflag,chattingbginfo.path,chattingbginfo.reserved1,chattingbginfo.reserved2,chattingbginfo.reserved3,chattingbginfo.reserved4 from chattingbginfo   where chattingbginfo.username = \"" + bo.vA(String.valueOf(str)) + "\"", null, 2);
        if (a == null) {
            AppMethodBeat.o(78435);
        } else {
            if (a.moveToFirst()) {
                aVar = new a();
                aVar.d(a);
            }
            a.close();
            AppMethodBeat.o(78435);
        }
        return aVar;
    }

    public final boolean a(a aVar) {
        AppMethodBeat.i(78433);
        aVar.bJt = -1;
        if (((int) this.fni.insert("chattingbginfo", "username", aVar.Hl())) != -1) {
            anF(aVar.getUsername());
            AppMethodBeat.o(78433);
            return true;
        }
        AppMethodBeat.o(78433);
        return false;
    }
}
