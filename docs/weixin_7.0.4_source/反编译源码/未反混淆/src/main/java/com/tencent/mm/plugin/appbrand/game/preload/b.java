package com.tencent.mm.plugin.appbrand.game.preload;

import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class b {
    private static String htk;

    static final class a implements i<IPCVoid, IPCString> {
        private a() {
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(130287);
            String str = g.RP().cachePath;
            if (!str.endsWith("/")) {
                str = str + "/";
            }
            IPCString iPCString = new IPCString(str + "appbrand/loadingurl");
            AppMethodBeat.o(130287);
            return iPCString;
        }
    }

    public static String aBv() {
        AppMethodBeat.i(130288);
        String absolutePath;
        if (bo.isNullOrNil(htk)) {
            IPCString iPCString;
            try {
                iPCString = (IPCString) XIPCInvoker.a("com.tencent.mm", IPCVoid.eGH, a.class);
            } catch (Exception e) {
                ab.e("MicroMsg.V8CodeCachePathRetriever", "retrieve ipc ex = %s", e);
                iPCString = null;
            }
            if (iPCString == null) {
                absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
                if (!absolutePath.endsWith("/")) {
                    absolutePath = absolutePath + "/";
                }
                absolutePath = absolutePath + "Tencent/MicroMsg/appbrand/loadingurl";
                AppMethodBeat.o(130288);
                return absolutePath;
            }
            absolutePath = iPCString.value;
            htk = absolutePath;
            AppMethodBeat.o(130288);
            return absolutePath;
        }
        absolutePath = htk;
        AppMethodBeat.o(130288);
        return absolutePath;
    }
}
