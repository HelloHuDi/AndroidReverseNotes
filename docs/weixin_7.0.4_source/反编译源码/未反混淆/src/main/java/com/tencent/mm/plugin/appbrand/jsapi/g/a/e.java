package com.tencent.mm.plugin.appbrand.jsapi.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.g.b;
import com.tencent.mm.plugin.appbrand.jsapi.g.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.d;
import com.tencent.mm.plugin.appbrand.jsapi.g.f;
import com.tencent.mm.plugin.appbrand.jsapi.g.g;
import com.tencent.mm.plugin.appbrand.jsapi.g.h;
import com.tencent.mm.plugin.appbrand.jsapi.g.i;
import com.tencent.mm.plugin.appbrand.jsapi.g.j;
import com.tencent.mm.plugin.appbrand.jsapi.g.k;
import com.tencent.mm.plugin.appbrand.jsapi.g.l;
import com.tencent.mm.plugin.appbrand.jsapi.g.m;
import com.tencent.mm.plugin.appbrand.jsapi.g.n;
import com.tencent.mm.plugin.appbrand.jsapi.g.o;
import com.tencent.mm.plugin.appbrand.jsapi.g.p;
import com.tencent.mm.plugin.appbrand.jsapi.g.q;
import com.tencent.mm.plugin.appbrand.jsapi.g.r;
import com.tencent.mm.plugin.appbrand.jsapi.g.s;
import com.tencent.mm.plugin.appbrand.jsapi.g.t;
import com.tencent.mm.plugin.appbrand.jsapi.g.u;
import com.tencent.mm.plugin.appbrand.jsapi.g.v;
import com.tencent.mm.plugin.appbrand.n.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;

public final class e {
    private static final Map<String, Integer> hOz;

    static {
        AppMethodBeat.i(93885);
        HashMap hashMap = new HashMap();
        hOz = hashMap;
        hashMap.put(b.NAME, Integer.valueOf(0));
        hOz.put(com.tencent.mm.plugin.appbrand.jsapi.g.e.NAME, Integer.valueOf(1));
        hOz.put(s.NAME, Integer.valueOf(2));
        hOz.put(d.NAME, Integer.valueOf(3));
        hOz.put(r.NAME, Integer.valueOf(4));
        hOz.put(n.NAME, Integer.valueOf(5));
        hOz.put(c.NAME, Integer.valueOf(6));
        hOz.put(f.NAME, Integer.valueOf(7));
        hOz.put(h.NAME, Integer.valueOf(8));
        hOz.put(p.NAME, Integer.valueOf(9));
        hOz.put(u.NAME, Integer.valueOf(10));
        hOz.put(l.NAME, Integer.valueOf(11));
        hOz.put(j.NAME, Integer.valueOf(12));
        hOz.put(k.NAME, Integer.valueOf(13));
        hOz.put(m.NAME, Integer.valueOf(14));
        hOz.put(i.NAME, Integer.valueOf(15));
        hOz.put(t.NAME, Integer.valueOf(16));
        hOz.put(g.NAME, Integer.valueOf(17));
        AppMethodBeat.o(93885);
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void Bj(String str) {
        AppMethodBeat.i(93882);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(93882);
            return;
        }
        int i;
        switch (str.hashCode()) {
            case -1949215789:
                if (str.equals(v.NAME)) {
                    i = 1;
                    break;
                }
            case -384482333:
                if (str.equals(o.NAME)) {
                    i = 0;
                    break;
                }
            case 1282356792:
                if (str.equals(q.NAME)) {
                    i = 2;
                    break;
                }
            default:
                i = -1;
                break;
        }
        switch (i) {
            case 0:
                i = 0;
                break;
            case 1:
                i = 3;
                break;
            case 2:
                i = 6;
                break;
            default:
                if (!hOz.containsKey(str)) {
                    i = -1;
                    break;
                } else {
                    i = ((((Integer) hOz.get(str)).intValue() * 5) + 20) + 0;
                    break;
                }
        }
        if (i == -1) {
            com.tencent.luggage.g.d.e("Luggage.MapReporter", "key is -1, may be err");
            AppMethodBeat.o(93882);
            return;
        }
        oq(i);
        com.tencent.luggage.g.d.v("Luggage.MapReporter", "name:%s invoke key:%d", str, Integer.valueOf(i));
        AppMethodBeat.o(93882);
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void d(String str, boolean z, boolean z2) {
        AppMethodBeat.i(93883);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(93883);
            return;
        }
        int i;
        switch (str.hashCode()) {
            case -1949215789:
                if (str.equals(v.NAME)) {
                    i = 1;
                    break;
                }
            case -384482333:
                if (str.equals(o.NAME)) {
                    i = 0;
                    break;
                }
            case 1282356792:
                if (str.equals(q.NAME)) {
                    i = 2;
                    break;
                }
            default:
                i = -1;
                break;
        }
        switch (i) {
            case 0:
                if (!z) {
                    i = 2;
                    break;
                } else {
                    i = 1;
                    break;
                }
            case 1:
                if (!z) {
                    i = 5;
                    break;
                } else {
                    i = 4;
                    break;
                }
            case 2:
                if (!z) {
                    i = 8;
                    break;
                } else {
                    i = 7;
                    break;
                }
            default:
                if (!hOz.containsKey(str)) {
                    i = -1;
                    break;
                }
                int intValue = (((Integer) hOz.get(str)).intValue() * 5) + 20;
                i = z2 ? z ? 3 : 4 : z ? 1 : 2;
                i += intValue;
                break;
        }
        if (i == -1) {
            com.tencent.luggage.g.d.e("Luggage.MapReporter", "key is -1, may be err");
            AppMethodBeat.o(93883);
            return;
        }
        oq(i);
        com.tencent.luggage.g.d.v("Luggage.MapReporter", "name:%s, isOk:%b, isOtherMap:%b, key:%d", str, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i));
        AppMethodBeat.o(93883);
    }

    public static void oq(int i) {
        AppMethodBeat.i(93884);
        com.tencent.luggage.g.d.v("Luggage.MapReporter", "reportKey:%d", Integer.valueOf(i));
        ((a) com.tencent.luggage.a.e.C(a.class)).f(1020, (long) i, 1);
        AppMethodBeat.o(93884);
    }
}
