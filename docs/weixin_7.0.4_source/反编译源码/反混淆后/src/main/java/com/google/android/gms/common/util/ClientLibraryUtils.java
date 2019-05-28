package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.wrappers.Wrappers;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ClientLibraryUtils {
    public static final int GMS_CLIENT_VERSION_UNKNOWN = -1;

    private ClientLibraryUtils() {
    }

    public static int getClientVersion(Context context, String str) {
        AppMethodBeat.m2504i(90042);
        int clientVersion = getClientVersion(getPackageInfo(context, str));
        AppMethodBeat.m2505o(90042);
        return clientVersion;
    }

    public static int getClientVersion(PackageInfo packageInfo) {
        AppMethodBeat.m2504i(90043);
        if (packageInfo == null || packageInfo.applicationInfo == null) {
            AppMethodBeat.m2505o(90043);
            return -1;
        }
        Bundle bundle = packageInfo.applicationInfo.metaData;
        if (bundle == null) {
            AppMethodBeat.m2505o(90043);
            return -1;
        }
        int i = bundle.getInt(GooglePlayServicesUtilLight.KEY_METADATA_GOOGLE_PLAY_SERVICES_VERSION, -1);
        AppMethodBeat.m2505o(90043);
        return i;
    }

    public static PackageInfo getPackageInfo(Context context, String str) {
        AppMethodBeat.m2504i(90044);
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str, 128);
            AppMethodBeat.m2505o(90044);
            return packageInfo;
        } catch (NameNotFoundException e) {
            AppMethodBeat.m2505o(90044);
            return null;
        }
    }

    public static boolean isPackageSide() {
        return false;
    }

    public static boolean isPackageStopped(Context context, String str) {
        AppMethodBeat.m2504i(90045);
        "com.google.android.gms".equals(str);
        try {
            if ((Wrappers.packageManager(context).getApplicationInfo(str, 0).flags & 2097152) != 0) {
                AppMethodBeat.m2505o(90045);
                return true;
            }
            AppMethodBeat.m2505o(90045);
            return false;
        } catch (NameNotFoundException e) {
            AppMethodBeat.m2505o(90045);
            return false;
        }
    }
}
