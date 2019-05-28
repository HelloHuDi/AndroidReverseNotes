package com.tencent.mm.plugin.appbrand;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.a.a;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.b;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.c;

public final class ac {
    private static volatile Boolean gQv = null;

    public static boolean aux() {
        boolean z;
        AppMethodBeat.i(129142);
        if (gQv == null) {
            a aVar = b.eGM;
            c ll = a.ll("100400");
            if (ll == null || !ll.isValid()) {
                gQv = Boolean.FALSE;
            } else {
                boolean z2 = bo.getInt((String) ll.dru().get("openIsolateContext"), 0) > 0;
                int i = bo.getInt((String) ll.dru().get("isolateContextLibVersion"), BaseClientBuilder.API_PRIORITY_OTHER);
                if (!z2 || i > WxaCommLibRuntimeReader.avQ().gVu) {
                    z = false;
                } else {
                    z = true;
                }
                gQv = Boolean.valueOf(z);
                ab.i("MicroMsg.AppBrand.MultiContextABTests", "openLibraryIsolateContext exp(%b, %d), result %b", Boolean.valueOf(z2), Integer.valueOf(i), gQv);
            }
        }
        z = gQv.booleanValue();
        AppMethodBeat.o(129142);
        return z;
    }
}
