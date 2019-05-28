package com.tencent.p177mm.p1174aa;

import com.eclipsesource.p096a.C0803h;
import com.eclipsesource.p096a.C31986e;
import com.eclipsesource.p096a.C37205b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.tencent.mm.aa.j */
public final class C41727j {
    /* renamed from: k */
    public static C31986e m73485k(Map map) {
        AppMethodBeat.m2504i(117689);
        C31986e c31986e = new C31986e();
        if (map == null || map.isEmpty()) {
            AppMethodBeat.m2505o(117689);
            return c31986e;
        }
        for (Object next : map.keySet()) {
            C41727j.m73484a(c31986e, (String) next, map.get(next));
        }
        AppMethodBeat.m2505o(117689);
        return c31986e;
    }

    /* renamed from: a */
    public static C31986e m73482a(C17868c c17868c) {
        AppMethodBeat.m2504i(117690);
        C31986e c31986e = new C31986e();
        if (c17868c == null) {
            AppMethodBeat.m2505o(117690);
            return c31986e;
        }
        try {
            Iterator keys = c17868c.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                C41727j.m73484a(c31986e, str, c17868c.get(str));
            }
        } catch (C41724g e) {
        }
        AppMethodBeat.m2505o(117690);
        return c31986e;
    }

    /* renamed from: a */
    public static C37205b m73481a(C41723a c41723a) {
        AppMethodBeat.m2504i(117691);
        C37205b c37205b = new C37205b();
        if (c41723a == null) {
            AppMethodBeat.m2505o(117691);
        } else {
            int i = 0;
            while (i < c41723a.length()) {
                try {
                    C41727j.m73483a(c37205b, c41723a.get(i));
                    i++;
                } catch (C41724g e) {
                }
            }
            AppMethodBeat.m2505o(117691);
        }
        return c37205b;
    }

    /* renamed from: a */
    protected static void m73483a(C37205b c37205b, Object obj) {
        AppMethodBeat.m2504i(117692);
        if (obj instanceof C17868c) {
            c37205b.mo59301a(C41727j.m73482a((C17868c) obj));
            AppMethodBeat.m2505o(117692);
        } else if (obj instanceof C41723a) {
            c37205b.mo59301a(C41727j.m73481a((C41723a) obj));
            AppMethodBeat.m2505o(117692);
        } else if (obj instanceof Integer) {
            c37205b.mo59306ds(((Integer) obj).intValue());
            AppMethodBeat.m2505o(117692);
        } else if (obj instanceof String) {
            c37205b.mo59304aj((String) obj);
            AppMethodBeat.m2505o(117692);
        } else if (obj instanceof Boolean) {
            c37205b.mo59302aC(((Boolean) obj).booleanValue());
            AppMethodBeat.m2505o(117692);
        } else if (obj instanceof Long) {
            c37205b.mo59312u(((Long) obj).longValue());
            AppMethodBeat.m2505o(117692);
        } else if (obj instanceof Float) {
            c37205b.mo59299U(((Float) obj).floatValue());
            AppMethodBeat.m2505o(117692);
        } else if (obj instanceof Integer) {
            c37205b.mo59306ds(((Integer) obj).intValue());
            AppMethodBeat.m2505o(117692);
        } else if (obj instanceof Double) {
            c37205b.mo59310n(((Double) obj).doubleValue());
            AppMethodBeat.m2505o(117692);
        } else {
            if (obj instanceof C0803h) {
                c37205b.mo59301a((C0803h) obj);
            }
            AppMethodBeat.m2505o(117692);
        }
    }

    /* renamed from: a */
    protected static void m73484a(C31986e c31986e, String str, Object obj) {
        AppMethodBeat.m2504i(117693);
        if (obj instanceof C17868c) {
            c31986e.mo52097b(str, C41727j.m73482a((C17868c) obj));
            AppMethodBeat.m2505o(117693);
        } else if (obj instanceof C41723a) {
            c31986e.mo52097b(str, C41727j.m73481a((C41723a) obj));
            AppMethodBeat.m2505o(117693);
        } else if (obj instanceof Integer) {
            c31986e.mo52100g(str, ((Integer) obj).intValue());
            AppMethodBeat.m2505o(117693);
        } else if (obj instanceof String) {
            c31986e.mo52101h(str, (String) obj);
            AppMethodBeat.m2505o(117693);
        } else if (obj instanceof Boolean) {
            c31986e.mo52099d(str, ((Boolean) obj).booleanValue());
            AppMethodBeat.m2505o(117693);
        } else if (obj instanceof Long) {
            c31986e.mo52096b(str, ((Long) obj).longValue());
            AppMethodBeat.m2505o(117693);
        } else if (obj instanceof Float) {
            c31986e.mo52098d(str, ((Float) obj).floatValue());
            AppMethodBeat.m2505o(117693);
        } else if (obj instanceof Double) {
            c31986e.mo52095b(str, ((Double) obj).doubleValue());
            AppMethodBeat.m2505o(117693);
        } else {
            if (obj instanceof C0803h) {
                c31986e.mo52097b(str, (C0803h) obj);
            }
            AppMethodBeat.m2505o(117693);
        }
    }
}
