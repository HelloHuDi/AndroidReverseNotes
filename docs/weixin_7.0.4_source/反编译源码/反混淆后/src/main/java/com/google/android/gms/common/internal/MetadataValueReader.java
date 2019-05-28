package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.annotation.concurrent.GuardedBy;

public class MetadataValueReader {
    public static final String KEY_METADATA_APP_ID = "com.google.app.id";
    private static Object sLock = new Object();
    @GuardedBy("sLock")
    private static boolean zzui;
    private static String zzuj;
    private static int zzuk;

    static {
        AppMethodBeat.m2504i(89682);
        AppMethodBeat.m2505o(89682);
    }

    public static String getGoogleAppId(Context context) {
        AppMethodBeat.m2504i(89679);
        zze(context);
        String str = zzuj;
        AppMethodBeat.m2505o(89679);
        return str;
    }

    public static int getGooglePlayServicesVersion(Context context) {
        AppMethodBeat.m2504i(89680);
        zze(context);
        int i = zzuk;
        AppMethodBeat.m2505o(89680);
        return i;
    }

    @VisibleForTesting
    public static void resetForTesting() {
        synchronized (sLock) {
            zzui = false;
        }
    }

    @VisibleForTesting
    public static void setValuesForTesting(String str, int i) {
        synchronized (sLock) {
            zzuj = str;
            zzuk = i;
            zzui = true;
        }
    }

    private static void zze(Context context) {
        AppMethodBeat.m2504i(89681);
        synchronized (sLock) {
            try {
                if (zzui) {
                    AppMethodBeat.m2505o(89681);
                    return;
                }
                zzui = true;
                Bundle bundle = Wrappers.packageManager(context).getApplicationInfo(context.getPackageName(), 128).metaData;
                if (bundle == null) {
                    AppMethodBeat.m2505o(89681);
                    return;
                }
                zzuj = bundle.getString(KEY_METADATA_APP_ID);
                zzuk = bundle.getInt(GooglePlayServicesUtilLight.KEY_METADATA_GOOGLE_PLAY_SERVICES_VERSION);
                AppMethodBeat.m2505o(89681);
            } catch (NameNotFoundException e) {
                Log.wtf("MetadataValueReader", "This should never happen.", e);
            } catch (Throwable th) {
                AppMethodBeat.m2505o(89681);
            }
        }
    }
}
