package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.g.c.ev;
import com.tencent.mm.sdk.e.j;
import java.util.concurrent.ConcurrentHashMap;

public final class by extends j<ev> {
    public static final String[] fnj = new String[]{j.a(bx.ccO, "TablesVersion")};
    public h fni;

    static {
        AppMethodBeat.i(59018);
        AppMethodBeat.o(59018);
    }

    public by(h hVar) {
        super(hVar, bx.ccO, "TablesVersion", ev.diI);
        this.fni = hVar;
    }

    public final ConcurrentHashMap<Integer, String> duv() {
        AppMethodBeat.i(59017);
        Cursor a = this.fni.a("select * from TablesVersion", new String[0], 0);
        ConcurrentHashMap<Integer, String> concurrentHashMap = new ConcurrentHashMap();
        if (a == null) {
            AppMethodBeat.o(59017);
        } else {
            while (a.moveToNext()) {
                try {
                    concurrentHashMap.putIfAbsent(Integer.valueOf(a.getInt(0)), a.getString(1));
                } finally {
                    a.close();
                    AppMethodBeat.o(59017);
                }
            }
        }
        return concurrentHashMap;
    }
}
