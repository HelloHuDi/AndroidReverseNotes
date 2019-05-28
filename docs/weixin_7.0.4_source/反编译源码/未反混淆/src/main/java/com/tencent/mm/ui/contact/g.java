package com.tencent.mm.ui.contact;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.storage.ak;
import java.util.ArrayList;
import java.util.List;

public final class g {
    public static final Cursor fm(List<String> list) {
        AppMethodBeat.i(105201);
        List fn = fn(list);
        Cursor dsF;
        if (fn.size() == 0) {
            com.tencent.mm.kernel.g.RQ();
            dsF = ((j) com.tencent.mm.kernel.g.K(j.class)).XM().dsF();
            AppMethodBeat.o(105201);
            return dsF;
        }
        com.tencent.mm.kernel.g.RQ();
        dsF = ((j) com.tencent.mm.kernel.g.K(j.class)).XM().ew(fn);
        AppMethodBeat.o(105201);
        return dsF;
    }

    private static final List<String> fn(List<String> list) {
        AppMethodBeat.i(105202);
        ArrayList arrayList = new ArrayList();
        Cursor a = ((j) com.tencent.mm.kernel.g.K(j.class)).XR().a(t.fkP, (List) list, true, null);
        if (a.moveToFirst()) {
            int i = 0;
            do {
                ak akVar = new ak();
                akVar.d(a);
                if (ZG(akVar.field_username)) {
                    arrayList.add(akVar.field_username);
                    i++;
                    if (i >= 4) {
                        break;
                    }
                }
            } while (a.moveToNext());
        }
        a.close();
        AppMethodBeat.o(105202);
        return arrayList;
    }

    private static final boolean ZG(String str) {
        AppMethodBeat.i(105203);
        for (Object equals : t.fkY) {
            if (str.equals(equals)) {
                AppMethodBeat.o(105203);
                return false;
            }
        }
        if (t.kH(str)) {
            AppMethodBeat.o(105203);
            return false;
        } else if (t.mZ(str)) {
            AppMethodBeat.o(105203);
            return false;
        } else {
            AppMethodBeat.o(105203);
            return true;
        }
    }
}
