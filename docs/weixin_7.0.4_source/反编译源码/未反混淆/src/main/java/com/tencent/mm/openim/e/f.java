package com.tencent.mm.openim.e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.List;

public final class f extends j<e> {
    public static final String[] fnj = new String[]{j.a(e.ccO, "OpenIMWordingInfo")};
    public h fni;

    static {
        AppMethodBeat.i(78994);
        AppMethodBeat.o(78994);
    }

    public f(h hVar) {
        super(hVar, e.ccO, "OpenIMWordingInfo", null);
        this.fni = hVar;
    }

    public final boolean a(e eVar) {
        AppMethodBeat.i(78991);
        eVar.field_updateTime = bo.anT();
        boolean a = super.a(eVar);
        AppMethodBeat.o(78991);
        return a;
    }

    public final List<String> B(int i, String str) {
        AppMethodBeat.i(78992);
        LinkedList linkedList = new LinkedList();
        ab.d("MicroMsg.Openim.OpenIMWordingInfoStg", "getLastWording sql:%s", " select wordingId from OpenIMWordingInfo where language='" + str + "' order by updateTime limit " + i);
        Cursor a = this.fni.a(r1, null, 2);
        if (a.moveToFirst()) {
            do {
                String string = a.getString(0);
                if (!bo.isNullOrNil(string)) {
                    linkedList.add(string);
                }
            } while (a.moveToNext());
        }
        ab.d("MicroMsg.Openim.OpenIMWordingInfoStg", "getLastWording result cnt: %d, language:%s", Integer.valueOf(linkedList.size()), str);
        a.close();
        AppMethodBeat.o(78992);
        return linkedList;
    }
}
