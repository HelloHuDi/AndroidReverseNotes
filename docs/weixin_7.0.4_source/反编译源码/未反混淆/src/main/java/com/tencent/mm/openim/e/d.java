package com.tencent.mm.openim.e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.List;

public final class d extends j<c> {
    public static final String[] fnj = new String[]{j.a(c.ccO, "OpenIMAppIdInfo")};
    public h fni;

    static {
        AppMethodBeat.i(78989);
        AppMethodBeat.o(78989);
    }

    public d(h hVar) {
        super(hVar, c.ccO, "OpenIMAppIdInfo", null);
        this.fni = hVar;
    }

    public final boolean a(c cVar) {
        AppMethodBeat.i(78986);
        cVar.field_updateTime = bo.anT();
        boolean a = super.a(cVar);
        AppMethodBeat.o(78986);
        return a;
    }

    public final List<String> vm(String str) {
        AppMethodBeat.i(78987);
        LinkedList linkedList = new LinkedList();
        Cursor a = this.fni.a("select distinct appid from OpenIMAppIdInfo where appid=? ", new String[]{str}, 2);
        if (a.moveToFirst()) {
            do {
                String string = a.getString(0);
                if (!bo.isNullOrNil(string)) {
                    linkedList.add(string);
                }
            } while (a.moveToNext());
        }
        a.close();
        AppMethodBeat.o(78987);
        return linkedList;
    }
}
