package com.tencent.mm.plugin.freewifi.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.m;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class a {
    private Map<String, b> cache;
    private boolean mvc;

    static class a {
        private static a mve = new a();

        static {
            AppMethodBeat.i(20662);
            AppMethodBeat.o(20662);
        }
    }

    public static class b {
        String cuH;
        int mue;
    }

    /* synthetic */ a(byte b) {
        this();
    }

    private a() {
        AppMethodBeat.i(20663);
        this.mvc = false;
        this.cache = new LinkedHashMap<String, b>() {
            /* Access modifiers changed, original: protected|final */
            public final boolean removeEldestEntry(Entry entry) {
                AppMethodBeat.i(20661);
                if (size() > 512) {
                    AppMethodBeat.o(20661);
                    return true;
                }
                AppMethodBeat.o(20661);
                return false;
            }
        };
        AppMethodBeat.o(20663);
    }

    private static String ep(String str, String str2) {
        AppMethodBeat.i(20664);
        String str3 = str + "-" + str2;
        AppMethodBeat.o(20664);
        return str3;
    }

    public final synchronized void e(String str, String str2, String str3, int i) {
        AppMethodBeat.i(20665);
        if (m.isEmpty(str) || m.isEmpty(str2) || m.isEmpty(str3) || !(i == 4 || i == 31)) {
            AppMethodBeat.o(20665);
        } else {
            b bVar = new b();
            bVar.cuH = str3;
            bVar.mue = i;
            this.cache.put(ep(str, str2), bVar);
            AppMethodBeat.o(20665);
        }
    }

    public final synchronized b eq(String str, String str2) {
        b bVar;
        AppMethodBeat.i(20666);
        if (m.isEmpty(str) || m.isEmpty(str2)) {
            bVar = null;
            AppMethodBeat.o(20666);
        } else {
            bVar = (b) this.cache.get(ep(str, str2));
            AppMethodBeat.o(20666);
        }
        return bVar;
    }

    public final synchronized int size() {
        int size;
        AppMethodBeat.i(20667);
        size = this.cache.size();
        AppMethodBeat.o(20667);
        return size;
    }
}
