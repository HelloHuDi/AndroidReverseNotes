package com.tencent.mm.app;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class r {
    static final Bundle aY(Context context) {
        AppMethodBeat.i(3240);
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            AppMethodBeat.o(3240);
            return bundle;
        } catch (NameNotFoundException e) {
            ab.printErrStackTrace("MicroMsg.SetupBaseBuildInfo", e, "", new Object[0]);
            AppMethodBeat.o(3240);
            return null;
        }
    }
}
