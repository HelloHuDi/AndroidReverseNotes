package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.an;
import com.tencent.tencentmap.mapsdk.maps.a.hs;
import com.tencent.tencentmap.mapsdk.maps.a.ic;

public class dq {
    public static void a(Context context) {
        AppMethodBeat.i(101103);
        if (context != null) {
            context = context.getApplicationContext();
        }
        try {
            an.a(false, false);
            an.b(hs.c());
            an.a("4.2.2");
            an.a(context);
            if (!StringUtil.isEmpty(ic.a)) {
                an.c(Integer.toString(ic.a.hashCode()));
            }
            AppMethodBeat.o(101103);
        } catch (Exception e) {
            AppMethodBeat.o(101103);
        } catch (Error e2) {
            AppMethodBeat.o(101103);
        }
    }

    public static void a() {
    }
}
