package com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a;

import com.tencent.luggage.p1170a.C37384e;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C10429l;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19389c;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19392d;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19394e;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19395n;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C2288t;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C2289u;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C2292v;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C26982f;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C26983m;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C26985o;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C33323p;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C33324q;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C33325s;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C38305g;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C38306r;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C44697b;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C44698h;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C44699i;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C44700j;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C45602k;
import com.tencent.p177mm.plugin.appbrand.p326n.C2402a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.a.e */
public final class C33319e {
    private static final Map<String, Integer> hOz;

    static {
        AppMethodBeat.m2504i(93885);
        HashMap hashMap = new HashMap();
        hOz = hashMap;
        hashMap.put(C44697b.NAME, Integer.valueOf(0));
        hOz.put(C19394e.NAME, Integer.valueOf(1));
        hOz.put(C33325s.NAME, Integer.valueOf(2));
        hOz.put(C19392d.NAME, Integer.valueOf(3));
        hOz.put(C38306r.NAME, Integer.valueOf(4));
        hOz.put(C19395n.NAME, Integer.valueOf(5));
        hOz.put(C19389c.NAME, Integer.valueOf(6));
        hOz.put(C26982f.NAME, Integer.valueOf(7));
        hOz.put(C44698h.NAME, Integer.valueOf(8));
        hOz.put(C33323p.NAME, Integer.valueOf(9));
        hOz.put(C2289u.NAME, Integer.valueOf(10));
        hOz.put(C10429l.NAME, Integer.valueOf(11));
        hOz.put(C44700j.NAME, Integer.valueOf(12));
        hOz.put(C45602k.NAME, Integer.valueOf(13));
        hOz.put(C26983m.NAME, Integer.valueOf(14));
        hOz.put(C44699i.NAME, Integer.valueOf(15));
        hOz.put(C2288t.NAME, Integer.valueOf(16));
        hOz.put(C38305g.NAME, Integer.valueOf(17));
        AppMethodBeat.m2505o(93885);
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: Bj */
    public static void m54488Bj(String str) {
        AppMethodBeat.m2504i(93882);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(93882);
            return;
        }
        int i;
        switch (str.hashCode()) {
            case -1949215789:
                if (str.equals(C2292v.NAME)) {
                    i = 1;
                    break;
                }
            case -384482333:
                if (str.equals(C26985o.NAME)) {
                    i = 0;
                    break;
                }
            case 1282356792:
                if (str.equals(C33324q.NAME)) {
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
            C45124d.m82927e("Luggage.MapReporter", "key is -1, may be err");
            AppMethodBeat.m2505o(93882);
            return;
        }
        C33319e.m54490oq(i);
        C45124d.m82932v("Luggage.MapReporter", "name:%s invoke key:%d", str, Integer.valueOf(i));
        AppMethodBeat.m2505o(93882);
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: d */
    public static void m54489d(String str, boolean z, boolean z2) {
        AppMethodBeat.m2504i(93883);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(93883);
            return;
        }
        int i;
        switch (str.hashCode()) {
            case -1949215789:
                if (str.equals(C2292v.NAME)) {
                    i = 1;
                    break;
                }
            case -384482333:
                if (str.equals(C26985o.NAME)) {
                    i = 0;
                    break;
                }
            case 1282356792:
                if (str.equals(C33324q.NAME)) {
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
            C45124d.m82927e("Luggage.MapReporter", "key is -1, may be err");
            AppMethodBeat.m2505o(93883);
            return;
        }
        C33319e.m54490oq(i);
        C45124d.m82932v("Luggage.MapReporter", "name:%s, isOk:%b, isOtherMap:%b, key:%d", str, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i));
        AppMethodBeat.m2505o(93883);
    }

    /* renamed from: oq */
    public static void m54490oq(int i) {
        AppMethodBeat.m2504i(93884);
        C45124d.m82932v("Luggage.MapReporter", "reportKey:%d", Integer.valueOf(i));
        ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(1020, (long) i, 1);
        AppMethodBeat.m2505o(93884);
    }
}
