package com.tencent.mm.aa;

import com.eclipsesource.a.b;
import com.eclipsesource.a.e;
import com.eclipsesource.a.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map;

public final class j {
    public static e k(Map map) {
        AppMethodBeat.i(117689);
        e eVar = new e();
        if (map == null || map.isEmpty()) {
            AppMethodBeat.o(117689);
            return eVar;
        }
        for (Object next : map.keySet()) {
            a(eVar, (String) next, map.get(next));
        }
        AppMethodBeat.o(117689);
        return eVar;
    }

    public static e a(c cVar) {
        AppMethodBeat.i(117690);
        e eVar = new e();
        if (cVar == null) {
            AppMethodBeat.o(117690);
            return eVar;
        }
        try {
            Iterator keys = cVar.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                a(eVar, str, cVar.get(str));
            }
        } catch (g e) {
        }
        AppMethodBeat.o(117690);
        return eVar;
    }

    public static b a(a aVar) {
        AppMethodBeat.i(117691);
        b bVar = new b();
        if (aVar == null) {
            AppMethodBeat.o(117691);
        } else {
            int i = 0;
            while (i < aVar.length()) {
                try {
                    a(bVar, aVar.get(i));
                    i++;
                } catch (g e) {
                }
            }
            AppMethodBeat.o(117691);
        }
        return bVar;
    }

    protected static void a(b bVar, Object obj) {
        AppMethodBeat.i(117692);
        if (obj instanceof c) {
            bVar.a(a((c) obj));
            AppMethodBeat.o(117692);
        } else if (obj instanceof a) {
            bVar.a(a((a) obj));
            AppMethodBeat.o(117692);
        } else if (obj instanceof Integer) {
            bVar.ds(((Integer) obj).intValue());
            AppMethodBeat.o(117692);
        } else if (obj instanceof String) {
            bVar.aj((String) obj);
            AppMethodBeat.o(117692);
        } else if (obj instanceof Boolean) {
            bVar.aC(((Boolean) obj).booleanValue());
            AppMethodBeat.o(117692);
        } else if (obj instanceof Long) {
            bVar.u(((Long) obj).longValue());
            AppMethodBeat.o(117692);
        } else if (obj instanceof Float) {
            bVar.U(((Float) obj).floatValue());
            AppMethodBeat.o(117692);
        } else if (obj instanceof Integer) {
            bVar.ds(((Integer) obj).intValue());
            AppMethodBeat.o(117692);
        } else if (obj instanceof Double) {
            bVar.n(((Double) obj).doubleValue());
            AppMethodBeat.o(117692);
        } else {
            if (obj instanceof h) {
                bVar.a((h) obj);
            }
            AppMethodBeat.o(117692);
        }
    }

    protected static void a(e eVar, String str, Object obj) {
        AppMethodBeat.i(117693);
        if (obj instanceof c) {
            eVar.b(str, a((c) obj));
            AppMethodBeat.o(117693);
        } else if (obj instanceof a) {
            eVar.b(str, a((a) obj));
            AppMethodBeat.o(117693);
        } else if (obj instanceof Integer) {
            eVar.g(str, ((Integer) obj).intValue());
            AppMethodBeat.o(117693);
        } else if (obj instanceof String) {
            eVar.h(str, (String) obj);
            AppMethodBeat.o(117693);
        } else if (obj instanceof Boolean) {
            eVar.d(str, ((Boolean) obj).booleanValue());
            AppMethodBeat.o(117693);
        } else if (obj instanceof Long) {
            eVar.b(str, ((Long) obj).longValue());
            AppMethodBeat.o(117693);
        } else if (obj instanceof Float) {
            eVar.d(str, ((Float) obj).floatValue());
            AppMethodBeat.o(117693);
        } else if (obj instanceof Double) {
            eVar.b(str, ((Double) obj).doubleValue());
            AppMethodBeat.o(117693);
        } else {
            if (obj instanceof h) {
                eVar.b(str, (h) obj);
            }
            AppMethodBeat.o(117693);
        }
    }
}
