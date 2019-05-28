package com.tencent.tencentmap.mapsdk.p666a;

import android.content.Context;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C31019an;
import com.tencent.tencentmap.mapsdk.maps.p667a.C36520ic;
import com.tencent.tencentmap.mapsdk.maps.p667a.C46790hs;

/* renamed from: com.tencent.tencentmap.mapsdk.a.dq */
public class C46760dq {
    /* renamed from: a */
    public static void m88657a(Context context) {
        AppMethodBeat.m2504i(101103);
        if (context != null) {
            context = context.getApplicationContext();
        }
        try {
            C31019an.m49819a(false, false);
            C31019an.m49824b(C46790hs.m88921c());
            C31019an.m49818a("4.2.2");
            C31019an.m49816a(context);
            if (!StringUtil.isEmpty(C36520ic.f15396a)) {
                C31019an.m49826c(Integer.toString(C36520ic.f15396a.hashCode()));
            }
            AppMethodBeat.m2505o(101103);
        } catch (Exception e) {
            AppMethodBeat.m2505o(101103);
        } catch (Error e2) {
            AppMethodBeat.m2505o(101103);
        }
    }

    /* renamed from: a */
    public static void m88656a() {
    }
}
