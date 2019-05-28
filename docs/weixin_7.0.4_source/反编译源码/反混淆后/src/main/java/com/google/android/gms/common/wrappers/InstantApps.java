package com.google.android.gms.common.wrappers;

import android.content.Context;
import com.google.android.gms.common.util.PlatformVersion;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class InstantApps {
    private static Context zzaay;
    private static Boolean zzaaz;

    public static synchronized boolean isInstantApp(Context context) {
        boolean booleanValue;
        synchronized (InstantApps.class) {
            AppMethodBeat.m2504i(90306);
            Context applicationContext = context.getApplicationContext();
            if (zzaay == null || zzaaz == null || zzaay != applicationContext) {
                zzaaz = null;
                if (PlatformVersion.isAtLeastO()) {
                    zzaaz = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
                } else {
                    try {
                        context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                        zzaaz = Boolean.TRUE;
                    } catch (ClassNotFoundException e) {
                        zzaaz = Boolean.FALSE;
                    }
                }
                zzaay = applicationContext;
                booleanValue = zzaaz.booleanValue();
                AppMethodBeat.m2505o(90306);
            } else {
                booleanValue = zzaaz.booleanValue();
                AppMethodBeat.m2505o(90306);
            }
        }
        return booleanValue;
    }
}
