package com.tencent.xweb.xwalk.b;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.xwalk.b.a.a;
import com.tencent.xweb.xwalk.b.a.b;
import com.tencent.xweb.xwalk.b.a.e;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;

public final class d {
    static e a(a aVar) {
        AppMethodBeat.i(85470);
        if (aVar == null || aVar.ATd == null || aVar.ATd.length == 0) {
            AppMethodBeat.o(85470);
            return null;
        }
        int i = VERSION.SDK_INT;
        for (e eVar : aVar.ATd) {
            if (eVar == null) {
                XWalkInitializer.addXWalkInitializeLog("no matched version  version == null");
            } else {
                Log.i("VersionMatcher", "try match version = " + eVar.ATn);
                if (eVar.ATn < 49) {
                    Log.i("VersionMatcher", " apk is not support, below 49");
                } else if (eVar.ATn <= XWalkEnvironment.getInstalledNewstVersion()) {
                    Log.i("VersionMatcher", " apk is too old ");
                } else if (eVar.AOK.dUw()) {
                    AppMethodBeat.o(85470);
                    return eVar;
                } else {
                    Log.i("VersionMatcher", " apk filter out ");
                }
            }
        }
        XWalkInitializer.addXWalkInitializeLog("no matched version");
        AppMethodBeat.o(85470);
        return null;
    }

    static b a(e eVar) {
        AppMethodBeat.i(85471);
        if (eVar.ATm != null) {
            for (b bVar : eVar.ATm) {
                if (bVar.ATf == XWalkEnvironment.getInstalledNewstVersion()) {
                    XWalkInitializer.addXWalkInitializeLog("got matched patch");
                    AppMethodBeat.o(85471);
                    return bVar;
                }
            }
        }
        XWalkInitializer.addXWalkInitializeLog("no matched patch");
        AppMethodBeat.o(85471);
        return null;
    }
}
