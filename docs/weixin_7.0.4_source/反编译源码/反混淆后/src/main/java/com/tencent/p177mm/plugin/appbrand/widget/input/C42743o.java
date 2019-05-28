package com.tencent.p177mm.plugin.appbrand.widget.input;

import android.support.p057v4.p065f.C6197a;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p328r.C45673m;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.plugin.appbrand.widget.input.C38600e.C19874a;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.input.o */
public enum C42743o {
    ;
    
    public static final Map<String, Integer> jeS = null;
    public static final Set<String> jeT = null;
    private static final C6197a<C44709u, C38595ab> jeU = null;

    static {
        HashSet hashSet = new HashSet();
        hashSet.add("text");
        hashSet.add("emoji");
        hashSet.add("number");
        hashSet.add("digit");
        hashSet.add("idcard");
        jeT = Collections.unmodifiableSet(hashSet);
        HashMap hashMap = new HashMap(3);
        hashMap.put("digit", Integer.valueOf(2));
        hashMap.put("number", Integer.valueOf(0));
        hashMap.put("idcard", Integer.valueOf(1));
        jeS = Collections.unmodifiableMap(hashMap);
        jeU = new C6197a();
        AppMethodBeat.m2505o(123693);
    }

    /* renamed from: b */
    static void m75754b(C44709u c44709u, C45718aa c45718aa) {
        AppMethodBeat.m2504i(123683);
        C38600e.m65412a(c44709u, c45718aa);
        AppMethodBeat.m2505o(123683);
    }

    /* renamed from: a */
    public static C45718aa m75749a(C44709u c44709u, final int i) {
        AppMethodBeat.m2504i(123684);
        C45718aa a = C38600e.m65411a(c44709u, new C19874a() {
            /* renamed from: a */
            public final boolean mo35111a(C45718aa c45718aa) {
                AppMethodBeat.m2504i(123677);
                if (c45718aa.aQo() == null || ((C38595ab) c45718aa.aQo()).getInputId() != i) {
                    AppMethodBeat.m2505o(123677);
                    return false;
                }
                AppMethodBeat.m2505o(123677);
                return true;
            }
        });
        AppMethodBeat.m2505o(123684);
        return a;
    }

    /* renamed from: a */
    public static void m75751a(final C44709u c44709u, final String str, final Integer num) {
        AppMethodBeat.m2504i(123685);
        if (c44709u == null) {
            AppMethodBeat.m2505o(123685);
            return;
        }
        C45673m.runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(123678);
                C38595ab c38595ab = (C38595ab) C42743o.jeU.get(c44709u);
                if (c38595ab != null) {
                    C45718aa a = C42743o.m75749a(c44709u, c38595ab.getInputId());
                    if (a != null) {
                        a.mo35097a(str, num);
                    }
                }
                AppMethodBeat.m2505o(123678);
            }
        });
        AppMethodBeat.m2505o(123685);
    }

    /* renamed from: v */
    public static boolean m75756v(C44709u c44709u) {
        AppMethodBeat.m2504i(123686);
        boolean a = C42743o.m75753a(c44709u, null);
        AppMethodBeat.m2505o(123686);
        return a;
    }

    /* renamed from: a */
    public static boolean m75752a(C44709u c44709u, int i, int i2, int i3) {
        AppMethodBeat.m2504i(123688);
        C45718aa a = C42743o.m75749a(c44709u, i);
        if (a != null && a.mo35110s(c44709u) && a.mo35128dr(i2, i3)) {
            AppMethodBeat.m2505o(123688);
            return true;
        }
        AppMethodBeat.m2505o(123688);
        return false;
    }

    /* renamed from: b */
    public static boolean m75755b(C44709u c44709u, int i) {
        AppMethodBeat.m2504i(123689);
        C45718aa a = C42743o.m75749a(c44709u, i);
        if (a == null || !a.aQn()) {
            AppMethodBeat.m2505o(123689);
            return false;
        }
        AppMethodBeat.m2505o(123689);
        return true;
    }

    /* renamed from: a */
    static void m75750a(final C44709u c44709u, final C38595ab c38595ab) {
        AppMethodBeat.m2504i(123690);
        if (c44709u == null) {
            AppMethodBeat.m2505o(123690);
            return;
        }
        C45673m.runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(123679);
                C42743o.jeU.put(c44709u, c38595ab);
                AppMethodBeat.m2505o(123679);
            }
        });
        AppMethodBeat.m2505o(123690);
    }

    /* renamed from: w */
    static void m75757w(final C44709u c44709u) {
        AppMethodBeat.m2504i(123691);
        if (c44709u == null) {
            AppMethodBeat.m2505o(123691);
            return;
        }
        C45673m.runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(123680);
                C42743o.jeU.remove(c44709u);
                AppMethodBeat.m2505o(123680);
            }
        });
        AppMethodBeat.m2505o(123691);
    }

    /* renamed from: x */
    public static C45718aa m75758x(C44709u c44709u) {
        AppMethodBeat.m2504i(123692);
        if (c44709u == null) {
            AppMethodBeat.m2505o(123692);
            return null;
        }
        C38595ab c38595ab = (C38595ab) jeU.get(c44709u);
        if (c38595ab == null) {
            AppMethodBeat.m2505o(123692);
            return null;
        }
        C45718aa a = C42743o.m75749a(c44709u, c38595ab.getInputId());
        AppMethodBeat.m2505o(123692);
        return a;
    }

    /* renamed from: a */
    public static boolean m75753a(C44709u c44709u, Integer num) {
        AppMethodBeat.m2504i(123687);
        if (num == null) {
            try {
                C38595ab c38595ab = (C38595ab) jeU.get(c44709u);
                if (c38595ab == null) {
                    AppMethodBeat.m2505o(123687);
                    return false;
                }
                num = Integer.valueOf(c38595ab.getInputId());
            } catch (Throwable th) {
                C45124d.printErrStackTrace("MicroMsg.AppBrandInputService", th, "[NOT CRASH]", new Object[0]);
                AppMethodBeat.m2505o(123687);
                return false;
            }
        }
        C45718aa a = C42743o.m75749a(c44709u, num.intValue());
        if (a == null || !a.aQt()) {
            AppMethodBeat.m2505o(123687);
            return false;
        }
        AppMethodBeat.m2505o(123687);
        return true;
    }
}
