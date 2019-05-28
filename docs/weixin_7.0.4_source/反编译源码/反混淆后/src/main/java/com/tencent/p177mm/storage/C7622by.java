package com.tencent.p177mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.p230g.p711c.C6577ev;
import com.tencent.p177mm.sdk.p603e.C7563j;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.storage.by */
public final class C7622by extends C7563j<C6577ev> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C7576bx.ccO, "TablesVersion")};
    public C7480h fni;

    static {
        AppMethodBeat.m2504i(59018);
        AppMethodBeat.m2505o(59018);
    }

    public C7622by(C7480h c7480h) {
        super(c7480h, C7576bx.ccO, "TablesVersion", C6577ev.diI);
        this.fni = c7480h;
    }

    public final ConcurrentHashMap<Integer, String> duv() {
        AppMethodBeat.m2504i(59017);
        Cursor a = this.fni.mo10104a("select * from TablesVersion", new String[0], 0);
        ConcurrentHashMap<Integer, String> concurrentHashMap = new ConcurrentHashMap();
        if (a == null) {
            AppMethodBeat.m2505o(59017);
        } else {
            while (a.moveToNext()) {
                try {
                    concurrentHashMap.putIfAbsent(Integer.valueOf(a.getInt(0)), a.getString(1));
                } finally {
                    a.close();
                    AppMethodBeat.m2505o(59017);
                }
            }
        }
        return concurrentHashMap;
    }
}
