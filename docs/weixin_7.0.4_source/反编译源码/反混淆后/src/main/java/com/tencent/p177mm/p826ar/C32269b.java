package com.tencent.p177mm.p826ar;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.sdk.p603e.C7296k;

/* renamed from: com.tencent.mm.ar.b */
public final class C32269b extends C7296k {
    public static final String[] fnj = new String[]{"CREATE TABLE IF NOT EXISTS getcontactinfov2 ( username text  PRIMARY KEY , inserttime long  , type int  , lastgettime int  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  ) "};
    C7480h fni;

    public C32269b(C7480h c7480h) {
        this.fni = c7480h;
    }

    /* renamed from: rY */
    public final boolean mo52978rY(String str) {
        AppMethodBeat.m2504i(16469);
        if (this.fni.delete("getcontactinfov2", "username= ?", new String[]{String.valueOf(str)}) > 0) {
            anF(str);
            AppMethodBeat.m2505o(16469);
            return true;
        }
        AppMethodBeat.m2505o(16469);
        return false;
    }

    /* renamed from: a */
    public final boolean mo52977a(C37471a c37471a) {
        AppMethodBeat.m2504i(16468);
        c37471a.bJt = -1;
        ContentValues contentValues = new ContentValues();
        if ((c37471a.bJt & 1) != 0) {
            contentValues.put("username", c37471a.getUsername());
        }
        if ((c37471a.bJt & 2) != 0) {
            contentValues.put("inserttime", Long.valueOf(c37471a.fCv));
        }
        if ((c37471a.bJt & 4) != 0) {
            contentValues.put("type", Integer.valueOf(c37471a.type));
        }
        if ((c37471a.bJt & 8) != 0) {
            contentValues.put("lastgettime", Integer.valueOf(c37471a.fCw));
        }
        if ((c37471a.bJt & 16) != 0) {
            contentValues.put("reserved1", Integer.valueOf(c37471a.fne));
        }
        if ((c37471a.bJt & 32) != 0) {
            contentValues.put("reserved2", Integer.valueOf(c37471a.fCx));
        }
        if ((c37471a.bJt & 64) != 0) {
            contentValues.put("reserved3", c37471a.agH());
        }
        if ((c37471a.bJt & 128) != 0) {
            contentValues.put("reserved4", c37471a.agI());
        }
        if (((int) this.fni.replace("getcontactinfov2", "username", contentValues)) != -1) {
            anF(c37471a.getUsername());
            AppMethodBeat.m2505o(16468);
            return true;
        }
        AppMethodBeat.m2505o(16468);
        return false;
    }
}
