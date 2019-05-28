package com.tencent.tencentmap.mapsdk.maps.a;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.ce.a;
import java.util.HashMap;
import java.util.Map;

public final class bx {
    private static Handler a = bt.j();

    static {
        AppMethodBeat.i(98602);
        AppMethodBeat.o(98602);
    }

    public static void a(String str, int i, int i2, String str2, Map<String, String> map, Map<String, String> map2, boolean z) {
        AppMethodBeat.i(98600);
        a.post(new bz(str, i, i2, str2, map, map2, z));
        AppMethodBeat.o(98600);
    }

    public static boolean a(String str, int i, int i2, String str2, Map<String, String> map, Map<String, String> map2, boolean z, int i3) {
        AppMethodBeat.i(98599);
        boolean a = a.a(1);
        if (a) {
            a.post(new by(str, i, i2, str2, map, map2, z, 1));
        }
        AppMethodBeat.o(98599);
        return a;
    }

    static /* synthetic */ void b(String str, int i, int i2, String str2, Map map, Map map2, boolean z, int i3) {
        CharSequence str22;
        boolean z2;
        AppMethodBeat.i(98601);
        if (z) {
            try {
                if (ce.l()) {
                    i2 = -288;
                } else {
                    ce.e();
                    if (!ce.h()) {
                        i2 = -4;
                    } else if (!cj.a()) {
                        i2 = -3;
                    }
                }
                if (i2 == -3) {
                    str22 = "ping failed, ".concat(String.valueOf(str22));
                }
            } catch (Throwable th) {
                AppMethodBeat.o(98601);
                return;
            }
        }
        if (i3 > 0) {
            z2 = true;
        } else {
            i3 = a.a(str, i, i2, map);
            z2 = a.a(i3);
        }
        if (z2) {
            if (map2 != null) {
                if (map2.containsKey("B83")) {
                    map2.put("B83", eu.a(Long.parseLong((String) map2.get("B83")), "yyyy-MM-dd HH:mm:ss.SSS"));
                }
                if (map2.containsKey("B84")) {
                    map2.put("B84", eu.a(Long.parseLong((String) map2.get("B84")), "yyyy-MM-dd HH:mm:ss.SSS"));
                }
                if (map2.containsKey("B44")) {
                    map2.put("B44", eu.b((String) map2.get("B44")));
                }
                if (map2.containsKey("B49")) {
                    map2.put("B49", eu.b((String) map2.get("B49")));
                }
                if (map2.containsKey("B47")) {
                    map2.put("B47", eu.b((String) map2.get("B47")));
                }
            }
            if (map == null) {
                map = new HashMap();
            }
            map.put("B31", String.valueOf(i3));
            map.put("B7", String.valueOf(i2));
            map.put("B1", bt.h());
            map.put("B2", bt.b);
            map.put("B30", bt.f());
            map.put("B3", String.valueOf(i));
            String i4 = bt.i();
            if (!TextUtils.isEmpty(i4)) {
                map.put("B4", i4);
            }
            map.put("B5", er.a());
            i4 = ce.c();
            if (!TextUtils.isEmpty(i4)) {
                map.put("B29", i4);
            }
            if (a.a("access_report_detail", 0, 1, 1) == 1) {
                if (map2 != null) {
                    map.putAll(map2);
                }
                map.put("B6", ce.b());
                if (!(i2 == -4 || TextUtils.isEmpty(str22))) {
                    map.put("B8", str22);
                }
                map.put("D1", bt.d());
                map.put("D2", bt.e());
                map.put("D3", bt.c);
            }
            if (i2 == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            a.a(str, z2, map, false, true);
        }
        AppMethodBeat.o(98601);
    }
}
