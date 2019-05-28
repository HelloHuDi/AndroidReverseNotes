package com.samsung.android.sdk.look;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.SystemProperties;
import com.samsung.android.sdk.SsdkInterface;
import com.samsung.android.sdk.SsdkUnsupportedException;
import com.samsung.android.sdk.SsdkVendorCheck;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class Slook implements SsdkInterface {
    public static final int AIRBUTTON = 1;
    private static final int NOT_ASSIGN = -1;
    public static final int SMARTCLIP = 2;
    public static final int SPEN_BEZEL_INTERACTION = 5;
    public static final int SPEN_HOVER_ICON = 4;
    private static final String TAG = "Slook";
    public static final int WRITINGBUDDY = 3;
    private static int mVersionCode = -1;

    public static class VERSION_CODES {
        public static final int L1 = 1;
    }

    public final int getVersionCode() {
        AppMethodBeat.i(117188);
        int i;
        if (mVersionCode != -1) {
            i = mVersionCode;
            AppMethodBeat.o(117188);
            return i;
        }
        try {
            mVersionCode = SystemProperties.getInt("ro.slook.ver", 0);
        } catch (Exception e) {
            mVersionCode = 0;
        }
        i = mVersionCode;
        AppMethodBeat.o(117188);
        return i;
    }

    public final String getVersionName() {
        return "1.0.1";
    }

    public final void initialize(Context context) {
        AppMethodBeat.i(117189);
        SsdkUnsupportedException ssdkUnsupportedException;
        if (!SsdkVendorCheck.isSamsungDevice()) {
            ssdkUnsupportedException = new SsdkUnsupportedException("This device is not samsung product.", 0);
            AppMethodBeat.o(117189);
            throw ssdkUnsupportedException;
        } else if (getVersionCode() <= 0) {
            ssdkUnsupportedException = new SsdkUnsupportedException("This device is not supported.", 1);
            AppMethodBeat.o(117189);
            throw ssdkUnsupportedException;
        } else {
            try {
                insertLog(context);
                AppMethodBeat.o(117189);
            } catch (SecurityException e) {
                SecurityException securityException = new SecurityException("com.samsung.android.providers.context.permission.WRITE_USE_APP_FEATURE_SURVEY permission is required.");
                AppMethodBeat.o(117189);
                throw securityException;
            }
        }
    }

    public final boolean isFeatureEnabled(int i) {
        AppMethodBeat.i(117190);
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                if (getVersionCode() > 0) {
                    boolean isFeatureEnabled = SlookImpl.isFeatureEnabled(i);
                    AppMethodBeat.o(117190);
                    return isFeatureEnabled;
                }
                AppMethodBeat.o(117190);
                return false;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("The type(" + i + ") is not supported.");
                AppMethodBeat.o(117190);
                throw illegalArgumentException;
        }
    }

    private void insertLog(Context context) {
        AppMethodBeat.i(117191);
        int i = -1;
        try {
            i = context.getPackageManager().getPackageInfo("com.samsung.android.providers.context", 128).versionCode;
        } catch (NameNotFoundException e) {
        }
        if (i <= 1) {
            AppMethodBeat.o(117191);
        } else if (context.checkCallingOrSelfPermission("com.samsung.android.providers.context.permission.WRITE_USE_APP_FEATURE_SURVEY") != 0) {
            SecurityException securityException = new SecurityException();
            AppMethodBeat.o(117191);
            throw securityException;
        } else {
            ContentValues contentValues = new ContentValues();
            String name = getClass().getPackage().getName();
            String str = context.getPackageName() + "#" + getVersionCode();
            contentValues.put("app_id", name);
            contentValues.put("feature", str);
            Intent intent = new Intent();
            intent.setAction("com.samsung.android.providers.context.log.action.USE_APP_FEATURE_SURVEY");
            intent.putExtra("data", contentValues);
            intent.setPackage("com.samsung.android.providers.context");
            context.sendBroadcast(intent);
            AppMethodBeat.o(117191);
        }
    }
}
