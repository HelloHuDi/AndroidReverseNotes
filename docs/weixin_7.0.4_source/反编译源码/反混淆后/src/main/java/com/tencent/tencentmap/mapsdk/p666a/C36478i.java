package com.tencent.tencentmap.mapsdk.p666a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.tencentmap.mapsdk.a.i */
public class C36478i {
    /* renamed from: a */
    private static Boolean f15241a = Boolean.FALSE;

    /* renamed from: a */
    public static void m60316a(String str, String str2) {
        AppMethodBeat.m2504i(101227);
        C36478i.m60317a(str, str2, 'v');
        AppMethodBeat.m2505o(101227);
    }

    /* renamed from: a */
    public static void m60315a(String str) {
        AppMethodBeat.m2504i(101228);
        C36478i.m60317a(null, str, 'e');
        AppMethodBeat.m2505o(101228);
    }

    /* renamed from: a */
    private static void m60317a(String str, String str2, char c) {
        AppMethodBeat.m2504i(101229);
        if (f15241a.booleanValue()) {
            TextUtils.isEmpty(str);
            AppMethodBeat.m2505o(101229);
            return;
        }
        AppMethodBeat.m2505o(101229);
    }
}
