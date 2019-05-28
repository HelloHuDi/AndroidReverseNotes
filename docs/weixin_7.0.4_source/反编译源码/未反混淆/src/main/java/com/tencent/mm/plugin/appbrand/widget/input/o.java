package com.tencent.mm.plugin.appbrand.widget.input;

import android.support.v4.f.a;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.r.m;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public enum o {
    ;
    
    public static final Map<String, Integer> jeS = null;
    public static final Set<String> jeT = null;
    private static final a<u, ab> jeU = null;

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
        jeU = new a();
        AppMethodBeat.o(123693);
    }

    static void b(u uVar, aa aaVar) {
        AppMethodBeat.i(123683);
        e.a(uVar, aaVar);
        AppMethodBeat.o(123683);
    }

    public static aa a(u uVar, final int i) {
        AppMethodBeat.i(123684);
        aa a = e.a(uVar, new e.a() {
            public final boolean a(aa aaVar) {
                AppMethodBeat.i(123677);
                if (aaVar.aQo() == null || ((ab) aaVar.aQo()).getInputId() != i) {
                    AppMethodBeat.o(123677);
                    return false;
                }
                AppMethodBeat.o(123677);
                return true;
            }
        });
        AppMethodBeat.o(123684);
        return a;
    }

    public static void a(final u uVar, final String str, final Integer num) {
        AppMethodBeat.i(123685);
        if (uVar == null) {
            AppMethodBeat.o(123685);
            return;
        }
        m.runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(123678);
                ab abVar = (ab) o.jeU.get(uVar);
                if (abVar != null) {
                    aa a = o.a(uVar, abVar.getInputId());
                    if (a != null) {
                        a.a(str, num);
                    }
                }
                AppMethodBeat.o(123678);
            }
        });
        AppMethodBeat.o(123685);
    }

    public static boolean v(u uVar) {
        AppMethodBeat.i(123686);
        boolean a = a(uVar, null);
        AppMethodBeat.o(123686);
        return a;
    }

    public static boolean a(u uVar, int i, int i2, int i3) {
        AppMethodBeat.i(123688);
        aa a = a(uVar, i);
        if (a != null && a.s(uVar) && a.dr(i2, i3)) {
            AppMethodBeat.o(123688);
            return true;
        }
        AppMethodBeat.o(123688);
        return false;
    }

    public static boolean b(u uVar, int i) {
        AppMethodBeat.i(123689);
        aa a = a(uVar, i);
        if (a == null || !a.aQn()) {
            AppMethodBeat.o(123689);
            return false;
        }
        AppMethodBeat.o(123689);
        return true;
    }

    static void a(final u uVar, final ab abVar) {
        AppMethodBeat.i(123690);
        if (uVar == null) {
            AppMethodBeat.o(123690);
            return;
        }
        m.runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(123679);
                o.jeU.put(uVar, abVar);
                AppMethodBeat.o(123679);
            }
        });
        AppMethodBeat.o(123690);
    }

    static void w(final u uVar) {
        AppMethodBeat.i(123691);
        if (uVar == null) {
            AppMethodBeat.o(123691);
            return;
        }
        m.runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(123680);
                o.jeU.remove(uVar);
                AppMethodBeat.o(123680);
            }
        });
        AppMethodBeat.o(123691);
    }

    public static aa x(u uVar) {
        AppMethodBeat.i(123692);
        if (uVar == null) {
            AppMethodBeat.o(123692);
            return null;
        }
        ab abVar = (ab) jeU.get(uVar);
        if (abVar == null) {
            AppMethodBeat.o(123692);
            return null;
        }
        aa a = a(uVar, abVar.getInputId());
        AppMethodBeat.o(123692);
        return a;
    }

    public static boolean a(u uVar, Integer num) {
        AppMethodBeat.i(123687);
        if (num == null) {
            try {
                ab abVar = (ab) jeU.get(uVar);
                if (abVar == null) {
                    AppMethodBeat.o(123687);
                    return false;
                }
                num = Integer.valueOf(abVar.getInputId());
            } catch (Throwable th) {
                d.printErrStackTrace("MicroMsg.AppBrandInputService", th, "[NOT CRASH]", new Object[0]);
                AppMethodBeat.o(123687);
                return false;
            }
        }
        aa a = a(uVar, num.intValue());
        if (a == null || !a.aQt()) {
            AppMethodBeat.o(123687);
            return false;
        }
        AppMethodBeat.o(123687);
        return true;
    }
}
