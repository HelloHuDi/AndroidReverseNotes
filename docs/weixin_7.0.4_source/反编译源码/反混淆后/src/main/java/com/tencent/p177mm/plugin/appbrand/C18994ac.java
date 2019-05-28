package com.tencent.p177mm.plugin.appbrand;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.wx_extension.p1463a.C42142a;
import com.tencent.p177mm.ipcinvoker.wx_extension.p1463a.C42142a.C32718b;
import com.tencent.p177mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5141c;

/* renamed from: com.tencent.mm.plugin.appbrand.ac */
public final class C18994ac {
    private static volatile Boolean gQv = null;

    public static boolean aux() {
        boolean z;
        AppMethodBeat.m2504i(129142);
        if (gQv == null) {
            C42142a c42142a = C32718b.eGM;
            C5141c ll = C42142a.m74295ll("100400");
            if (ll == null || !ll.isValid()) {
                gQv = Boolean.FALSE;
            } else {
                boolean z2 = C5046bo.getInt((String) ll.dru().get("openIsolateContext"), 0) > 0;
                int i = C5046bo.getInt((String) ll.dru().get("isolateContextLibVersion"), BaseClientBuilder.API_PRIORITY_OTHER);
                if (!z2 || i > WxaCommLibRuntimeReader.avQ().gVu) {
                    z = false;
                } else {
                    z = true;
                }
                gQv = Boolean.valueOf(z);
                C4990ab.m7417i("MicroMsg.AppBrand.MultiContextABTests", "openLibraryIsolateContext exp(%b, %d), result %b", Boolean.valueOf(z2), Integer.valueOf(i), gQv);
            }
        }
        z = gQv.booleanValue();
        AppMethodBeat.m2505o(129142);
        return z;
    }
}
