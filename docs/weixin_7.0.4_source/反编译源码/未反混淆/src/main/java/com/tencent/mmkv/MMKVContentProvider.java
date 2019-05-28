package com.tencent.mmkv;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MMKVContentProvider extends ContentProvider {
    private static Uri AiG;

    protected static Uri ix(Context context) {
        AppMethodBeat.i(124037);
        Uri uri;
        if (AiG != null) {
            uri = AiG;
            AppMethodBeat.o(124037);
            return uri;
        } else if (context == null) {
            AppMethodBeat.o(124037);
            return null;
        } else {
            String gz = gz(context);
            if (gz == null) {
                AppMethodBeat.o(124037);
                return null;
            }
            uri = Uri.parse("content://".concat(String.valueOf(gz)));
            AiG = uri;
            AppMethodBeat.o(124037);
            return uri;
        }
    }

    private static String gz(Context context) {
        AppMethodBeat.i(124038);
        try {
            ComponentName componentName = new ComponentName(context, MMKVContentProvider.class.getName());
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                ProviderInfo providerInfo = packageManager.getProviderInfo(componentName, 0);
                if (providerInfo != null) {
                    String str = providerInfo.authority;
                    AppMethodBeat.o(124038);
                    return str;
                }
            }
        } catch (Exception e) {
        }
        AppMethodBeat.o(124038);
        return null;
    }

    public boolean onCreate() {
        AppMethodBeat.i(124039);
        Context context = getContext();
        if (context == null) {
            AppMethodBeat.o(124039);
            return false;
        }
        String gz = gz(context);
        if (gz == null) {
            AppMethodBeat.o(124039);
            return false;
        }
        if (AiG == null) {
            AiG = Uri.parse("content://".concat(String.valueOf(gz)));
        }
        AppMethodBeat.o(124039);
        return true;
    }

    protected static String aB(Context context, int i) {
        String str;
        AppMethodBeat.i(124040);
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null) {
            for (RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == i) {
                    str = runningAppProcessInfo.processName;
                    AppMethodBeat.o(124040);
                    return str;
                }
            }
        }
        str = "";
        AppMethodBeat.o(124040);
        return str;
    }

    public Bundle call(String str, String str2, Bundle bundle) {
        AppMethodBeat.i(124041);
        if (!str.equals("mmkvFromAshmemID") || bundle == null) {
            AppMethodBeat.o(124041);
            return null;
        }
        MMKV mmkvWithAshmemID = MMKV.mmkvWithAshmemID(getContext(), str2, bundle.getInt("KEY_SIZE"), bundle.getInt("KEY_MODE"), bundle.getString("KEY_CRYPT"));
        if (mmkvWithAshmemID != null) {
            ParcelableMMKV parcelableMMKV = new ParcelableMMKV(mmkvWithAshmemID);
            new StringBuilder().append(str2).append(" fd = ").append(mmkvWithAshmemID.ashmemFD()).append(", meta fd = ").append(mmkvWithAshmemID.ashmemMetaFD());
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("KEY", parcelableMMKV);
            AppMethodBeat.o(124041);
            return bundle2;
        }
        AppMethodBeat.o(124041);
        return null;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        AppMethodBeat.i(124042);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Not implement in MMKV");
        AppMethodBeat.o(124042);
        throw unsupportedOperationException;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        AppMethodBeat.i(124043);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Not implement in MMKV");
        AppMethodBeat.o(124043);
        throw unsupportedOperationException;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        AppMethodBeat.i(124044);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Not implement in MMKV");
        AppMethodBeat.o(124044);
        throw unsupportedOperationException;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        AppMethodBeat.i(124045);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Not implement in MMKV");
        AppMethodBeat.o(124045);
        throw unsupportedOperationException;
    }
}
