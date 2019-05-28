package com.tencent.xweb.xwalk.p687b;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.xwalk.p687b.C24553a.C16409b;
import com.tencent.xweb.xwalk.p687b.C24553a.C16411e;
import com.tencent.xweb.xwalk.p687b.C24553a.C24555a;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;

/* renamed from: com.tencent.xweb.xwalk.b.d */
public final class C36607d {
    /* renamed from: a */
    static C16411e m60704a(C24555a c24555a) {
        AppMethodBeat.m2504i(85470);
        if (c24555a == null || c24555a.ATd == null || c24555a.ATd.length == 0) {
            AppMethodBeat.m2505o(85470);
            return null;
        }
        int i = VERSION.SDK_INT;
        for (C16411e c16411e : c24555a.ATd) {
            if (c16411e == null) {
                XWalkInitializer.addXWalkInitializeLog("no matched version  version == null");
            } else {
                Log.m81049i("VersionMatcher", "try match version = " + c16411e.ATn);
                if (c16411e.ATn < 49) {
                    Log.m81049i("VersionMatcher", " apk is not support, below 49");
                } else if (c16411e.ATn <= XWalkEnvironment.getInstalledNewstVersion()) {
                    Log.m81049i("VersionMatcher", " apk is too old ");
                } else if (c16411e.AOK.dUw()) {
                    AppMethodBeat.m2505o(85470);
                    return c16411e;
                } else {
                    Log.m81049i("VersionMatcher", " apk filter out ");
                }
            }
        }
        XWalkInitializer.addXWalkInitializeLog("no matched version");
        AppMethodBeat.m2505o(85470);
        return null;
    }

    /* renamed from: a */
    static C16409b m60703a(C16411e c16411e) {
        AppMethodBeat.m2504i(85471);
        if (c16411e.ATm != null) {
            for (C16409b c16409b : c16411e.ATm) {
                if (c16409b.ATf == XWalkEnvironment.getInstalledNewstVersion()) {
                    XWalkInitializer.addXWalkInitializeLog("got matched patch");
                    AppMethodBeat.m2505o(85471);
                    return c16409b;
                }
            }
        }
        XWalkInitializer.addXWalkInitializeLog("no matched patch");
        AppMethodBeat.m2505o(85471);
        return null;
    }
}
