package com.google.android.gms.common.wrappers;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class Wrappers {
    private static Wrappers zzabb = new Wrappers();
    private PackageManagerWrapper zzaba = null;

    static {
        AppMethodBeat.i(90330);
        AppMethodBeat.o(90330);
    }

    public static PackageManagerWrapper packageManager(Context context) {
        AppMethodBeat.i(90329);
        PackageManagerWrapper packageManagerWrapper = zzabb.getPackageManagerWrapper(context);
        AppMethodBeat.o(90329);
        return packageManagerWrapper;
    }

    @VisibleForTesting
    public static void resetForTests() {
        AppMethodBeat.i(90328);
        zzabb = new Wrappers();
        AppMethodBeat.o(90328);
    }

    public static void setWrappers(Wrappers wrappers) {
        zzabb = wrappers;
    }

    @VisibleForTesting
    public synchronized PackageManagerWrapper getPackageManagerWrapper(Context context) {
        PackageManagerWrapper packageManagerWrapper;
        AppMethodBeat.i(90327);
        if (this.zzaba == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.zzaba = new PackageManagerWrapper(context);
        }
        packageManagerWrapper = this.zzaba;
        AppMethodBeat.o(90327);
        return packageManagerWrapper;
    }
}
