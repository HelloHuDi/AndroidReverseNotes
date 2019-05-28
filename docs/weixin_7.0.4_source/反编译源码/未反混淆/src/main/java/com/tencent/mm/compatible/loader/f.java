package com.tencent.mm.compatible.loader;

import android.app.Application;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class f {
    public static e c(Application application, String str) {
        AppMethodBeat.i(93038);
        try {
            e eVar = (e) ah.getContext().getClassLoader().loadClass(ah.doz() + str).newInstance();
            eVar.b(application);
            AppMethodBeat.o(93038);
            return eVar;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.ProfileFactoryImpl", e, "", new Object[0]);
            AppMethodBeat.o(93038);
            return null;
        }
    }
}
