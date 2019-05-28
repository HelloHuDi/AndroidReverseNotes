package com.tencent.mm.ar;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.sdk.e.k;

public final class b extends k {
    public static final String[] fnj = new String[]{"CREATE TABLE IF NOT EXISTS getcontactinfov2 ( username text  PRIMARY KEY , inserttime long  , type int  , lastgettime int  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  ) "};
    h fni;

    public b(h hVar) {
        this.fni = hVar;
    }

    public final boolean rY(String str) {
        AppMethodBeat.i(16469);
        if (this.fni.delete("getcontactinfov2", "username= ?", new String[]{String.valueOf(str)}) > 0) {
            anF(str);
            AppMethodBeat.o(16469);
            return true;
        }
        AppMethodBeat.o(16469);
        return false;
    }

    public final boolean a(a aVar) {
        AppMethodBeat.i(16468);
        aVar.bJt = -1;
        ContentValues contentValues = new ContentValues();
        if ((aVar.bJt & 1) != 0) {
            contentValues.put("username", aVar.getUsername());
        }
        if ((aVar.bJt & 2) != 0) {
            contentValues.put("inserttime", Long.valueOf(aVar.fCv));
        }
        if ((aVar.bJt & 4) != 0) {
            contentValues.put("type", Integer.valueOf(aVar.type));
        }
        if ((aVar.bJt & 8) != 0) {
            contentValues.put("lastgettime", Integer.valueOf(aVar.fCw));
        }
        if ((aVar.bJt & 16) != 0) {
            contentValues.put("reserved1", Integer.valueOf(aVar.fne));
        }
        if ((aVar.bJt & 32) != 0) {
            contentValues.put("reserved2", Integer.valueOf(aVar.fCx));
        }
        if ((aVar.bJt & 64) != 0) {
            contentValues.put("reserved3", aVar.agH());
        }
        if ((aVar.bJt & 128) != 0) {
            contentValues.put("reserved4", aVar.agI());
        }
        if (((int) this.fni.replace("getcontactinfov2", "username", contentValues)) != -1) {
            anF(aVar.getUsername());
            AppMethodBeat.o(16468);
            return true;
        }
        AppMethodBeat.o(16468);
        return false;
    }
}
