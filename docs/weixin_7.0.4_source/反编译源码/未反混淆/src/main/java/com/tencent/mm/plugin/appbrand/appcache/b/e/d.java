package com.tencent.mm.plugin.appbrand.appcache.b.e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class d extends c<c> {
    public static final String[] fjY = new String[]{j.a(c.fjX, "PredownloadCmdGetCodePersistentInfo")};
    private final e gTC;

    public d(e eVar) {
        super(eVar, c.fjX, "PredownloadCmdGetCodePersistentInfo", c.diI);
        this.gTC = eVar;
    }

    static {
        AppMethodBeat.i(129512);
        AppMethodBeat.o(129512);
    }

    public final List<c> c(String str, String... strArr) {
        AppMethodBeat.i(129511);
        Cursor query = this.gTC.query("PredownloadCmdGetCodePersistentInfo", null, str, strArr, null, null, null);
        if (query == null || query.isClosed()) {
            List emptyList = Collections.emptyList();
            AppMethodBeat.o(129511);
            return emptyList;
        }
        List<c> linkedList = new LinkedList();
        if (query.moveToFirst()) {
            do {
                c cVar = new c();
                cVar.d(query);
                linkedList.add(cVar);
            } while (query.moveToNext());
        }
        query.close();
        AppMethodBeat.o(129511);
        return linkedList;
    }
}
