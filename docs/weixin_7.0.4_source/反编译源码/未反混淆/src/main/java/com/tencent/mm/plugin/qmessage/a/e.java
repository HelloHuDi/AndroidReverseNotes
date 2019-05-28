package com.tencent.mm.plugin.qmessage.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.bo;
import junit.framework.Assert;

public final class e extends k {
    public static final String[] fnj = new String[]{"CREATE TABLE IF NOT EXISTS qcontact ( username text  PRIMARY KEY , qq long  , extinfo text  , needupdate int  , extupdateseq long  , imgupdateseq long  , reserved1 int  , reserved2 int  , reserved3 int  , reserved4 int  , reserved5 text  , reserved6 text  , reserved7 text  , reserved8 text  ) "};
    private h fni;

    public e(h hVar) {
        this.fni = hVar;
    }

    public final boolean a(String str, d dVar) {
        AppMethodBeat.i(24083);
        boolean z = str != null && str.length() > 0;
        Assert.assertTrue(z);
        if (dVar == null) {
            AppMethodBeat.o(24083);
            return false;
        }
        if (this.fni.update("qcontact", dVar.Hl(), "username=?", new String[]{str}) > 0) {
            AppMethodBeat.o(24083);
            return true;
        }
        AppMethodBeat.o(24083);
        return false;
    }

    public final d Vb(String str) {
        d dVar = null;
        AppMethodBeat.i(24084);
        Cursor a = this.fni.a("select qcontact.username,qcontact.qq,qcontact.extinfo,qcontact.needupdate,qcontact.extupdateseq,qcontact.imgupdateseq,qcontact.reserved1,qcontact.reserved2,qcontact.reserved3,qcontact.reserved4,qcontact.reserved5,qcontact.reserved6,qcontact.reserved7,qcontact.reserved8 from qcontact   where qcontact.username = \"" + bo.vA(String.valueOf(str)) + "\"", null, 2);
        if (a == null) {
            AppMethodBeat.o(24084);
        } else {
            if (a.moveToFirst()) {
                dVar = new d();
                dVar.d(a);
            }
            a.close();
            AppMethodBeat.o(24084);
        }
        return dVar;
    }

    public final boolean a(d dVar) {
        AppMethodBeat.i(24082);
        dVar.bJt = -1;
        if (((int) this.fni.insert("qcontact", "username", dVar.Hl())) != -1) {
            AppMethodBeat.o(24082);
            return true;
        }
        AppMethodBeat.o(24082);
        return false;
    }
}
