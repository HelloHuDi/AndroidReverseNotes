package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C31029ce.C24362a;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.bx */
public final class C31027bx {
    /* renamed from: a */
    private static Handler f14062a = C46772bt.m88746j();

    static {
        AppMethodBeat.m2504i(98602);
        AppMethodBeat.m2505o(98602);
    }

    /* renamed from: a */
    public static void m49842a(String str, int i, int i2, String str2, Map<String, String> map, Map<String, String> map2, boolean z) {
        AppMethodBeat.m2504i(98600);
        f14062a.post(new C16213bz(str, i, i2, str2, map, map2, z));
        AppMethodBeat.m2505o(98600);
    }

    /* renamed from: a */
    public static boolean m49843a(String str, int i, int i2, String str2, Map<String, String> map, Map<String, String> map2, boolean z, int i3) {
        AppMethodBeat.m2504i(98599);
        boolean a = C24362a.m37670a(1);
        if (a) {
            f14062a.post(new C31028by(str, i, i2, str2, map, map2, z, 1));
        }
        AppMethodBeat.m2505o(98599);
        return a;
    }

    /* renamed from: b */
    static /* synthetic */ void m49844b(String str, int i, int i2, String str2, Map map, Map map2, boolean z, int i3) {
        CharSequence str22;
        boolean z2;
        AppMethodBeat.m2504i(98601);
        if (z) {
            try {
                if (C31029ce.m49857l()) {
                    i2 = -288;
                } else {
                    C31029ce.m49850e();
                    if (!C31029ce.m49853h()) {
                        i2 = -4;
                    } else if (!C44502cj.m80707a()) {
                        i2 = -3;
                    }
                }
                if (i2 == -3) {
                    str22 = "ping failed, ".concat(String.valueOf(str22));
                }
            } catch (Throwable th) {
                AppMethodBeat.m2505o(98601);
                return;
            }
        }
        if (i3 > 0) {
            z2 = true;
        } else {
            i3 = C24362a.m37666a(str, i, i2, map);
            z2 = C24362a.m37670a(i3);
        }
        if (z2) {
            if (map2 != null) {
                if (map2.containsKey("B83")) {
                    map2.put("B83", C24373eu.m37734a(Long.parseLong((String) map2.get("B83")), "yyyy-MM-dd HH:mm:ss.SSS"));
                }
                if (map2.containsKey("B84")) {
                    map2.put("B84", C24373eu.m37734a(Long.parseLong((String) map2.get("B84")), "yyyy-MM-dd HH:mm:ss.SSS"));
                }
                if (map2.containsKey("B44")) {
                    map2.put("B44", C24373eu.m37741b((String) map2.get("B44")));
                }
                if (map2.containsKey("B49")) {
                    map2.put("B49", C24373eu.m37741b((String) map2.get("B49")));
                }
                if (map2.containsKey("B47")) {
                    map2.put("B47", C24373eu.m37741b((String) map2.get("B47")));
                }
            }
            if (map == null) {
                map = new HashMap();
            }
            map.put("B31", String.valueOf(i3));
            map.put("B7", String.valueOf(i2));
            map.put("B1", C46772bt.m88744h());
            map.put("B2", C46772bt.f18093b);
            map.put("B30", C46772bt.m88742f());
            map.put("B3", String.valueOf(i));
            String i4 = C46772bt.m88745i();
            if (!TextUtils.isEmpty(i4)) {
                map.put("B4", i4);
            }
            map.put("B5", C24370er.m37706a());
            i4 = C31029ce.m49848c();
            if (!TextUtils.isEmpty(i4)) {
                map.put("B29", i4);
            }
            if (C24362a.m37665a("access_report_detail", 0, 1, 1) == 1) {
                if (map2 != null) {
                    map.putAll(map2);
                }
                map.put("B6", C31029ce.m49847b());
                if (!(i2 == -4 || TextUtils.isEmpty(str22))) {
                    map.put("B8", str22);
                }
                map.put("D1", C46772bt.m88740d());
                map.put("D2", C46772bt.m88741e());
                map.put("D3", C46772bt.f18094c);
            }
            if (i2 == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            C24362a.m37671a(str, z2, map, false, true);
        }
        AppMethodBeat.m2505o(98601);
    }
}
