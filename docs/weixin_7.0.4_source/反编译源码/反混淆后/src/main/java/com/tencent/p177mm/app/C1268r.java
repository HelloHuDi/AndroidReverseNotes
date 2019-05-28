package com.tencent.p177mm.app;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.app.r */
public final class C1268r {
    /* renamed from: aY */
    static final Bundle m2726aY(Context context) {
        AppMethodBeat.m2504i(3240);
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            AppMethodBeat.m2505o(3240);
            return bundle;
        } catch (NameNotFoundException e) {
            C4990ab.printErrStackTrace("MicroMsg.SetupBaseBuildInfo", e, "", new Object[0]);
            AppMethodBeat.m2505o(3240);
            return null;
        }
    }
}
