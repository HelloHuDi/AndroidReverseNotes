package com.google.android.gms.common.wrappers;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AppOpsManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.graphics.drawable.Drawable;
import android.os.Binder;
import android.os.Process;
import android.support.v4.content.f;
import android.support.v4.f.j;
import com.google.android.gms.common.util.PlatformVersion;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PackageManagerWrapper {
    private final Context zzjp;

    public PackageManagerWrapper(Context context) {
        this.zzjp = context;
    }

    public boolean allowApiAccess(String str, int i) {
        return true;
    }

    public void checkCallerIsNotInstantApp() {
        AppMethodBeat.i(90326);
        if (isCallerInstantApp()) {
            SecurityException securityException = new SecurityException("This operation is not supported for instant apps.");
            AppMethodBeat.o(90326);
            throw securityException;
        }
        AppMethodBeat.o(90326);
    }

    public int checkCallingOrSelfPermission(String str) {
        AppMethodBeat.i(90317);
        int checkCallingOrSelfPermission = this.zzjp.checkCallingOrSelfPermission(str);
        AppMethodBeat.o(90317);
        return checkCallingOrSelfPermission;
    }

    public int checkCallingOrSelfPermissionAndAppOps(String str) {
        AppMethodBeat.i(90318);
        int f = f.f(this.zzjp, str);
        AppMethodBeat.o(90318);
        return f;
    }

    public int checkCallingPermission(String str) {
        AppMethodBeat.i(90315);
        int checkCallingPermission = this.zzjp.checkCallingPermission(str);
        AppMethodBeat.o(90315);
        return checkCallingPermission;
    }

    @Deprecated
    public int checkCallingPermission(String str, String str2) {
        AppMethodBeat.i(90319);
        int checkPermission = checkPermission(str, str2);
        AppMethodBeat.o(90319);
        return checkPermission;
    }

    public void checkPackage(int i, String str) {
        AppMethodBeat.i(90310);
        if (uidHasPackageName(i, str)) {
            AppMethodBeat.o(90310);
            return;
        }
        SecurityException securityException = new SecurityException(new StringBuilder(String.valueOf(str).length() + 39).append("Package ").append(str).append(" does not belong to ").append(i).toString());
        AppMethodBeat.o(90310);
        throw securityException;
    }

    public int checkPermission(String str, int i, int i2) {
        AppMethodBeat.i(90312);
        int checkPermission = this.zzjp.checkPermission(str, i, i2);
        AppMethodBeat.o(90312);
        return checkPermission;
    }

    @Deprecated
    public int checkPermission(String str, int i, int i2, String str2) {
        AppMethodBeat.i(90313);
        int checkPermission = checkPermission(str, i, i2);
        AppMethodBeat.o(90313);
        return checkPermission;
    }

    public int checkPermission(String str, String str2) {
        AppMethodBeat.i(90320);
        int checkPermission = this.zzjp.getPackageManager().checkPermission(str, str2);
        AppMethodBeat.o(90320);
        return checkPermission;
    }

    public int checkPermissionAndAppOps(String str, int i, int i2, String str2) {
        AppMethodBeat.i(90314);
        int a = f.a(this.zzjp, str, i, i2, str2);
        AppMethodBeat.o(90314);
        return a;
    }

    public ApplicationInfo getApplicationInfo(String str, int i) {
        AppMethodBeat.i(90307);
        ApplicationInfo applicationInfo = this.zzjp.getPackageManager().getApplicationInfo(str, i);
        AppMethodBeat.o(90307);
        return applicationInfo;
    }

    public CharSequence getApplicationLabel(String str) {
        AppMethodBeat.i(90323);
        CharSequence applicationLabel = this.zzjp.getPackageManager().getApplicationLabel(this.zzjp.getPackageManager().getApplicationInfo(str, 0));
        AppMethodBeat.o(90323);
        return applicationLabel;
    }

    public ComponentName getCallingActivity(Activity activity) {
        AppMethodBeat.i(90322);
        ComponentName callingActivity = activity.getCallingActivity();
        AppMethodBeat.o(90322);
        return callingActivity;
    }

    public String getCallingPackage(Activity activity) {
        AppMethodBeat.i(90321);
        ComponentName callingActivity = activity.getCallingActivity();
        if (callingActivity == null) {
            AppMethodBeat.o(90321);
            return null;
        }
        String packageName = callingActivity.getPackageName();
        if (packageName == null) {
            packageName = String.valueOf(callingActivity);
            new StringBuilder(String.valueOf(packageName).length() + 54).append("getCallingPackage(): Couldn't get a package name from ").append(packageName);
            AppMethodBeat.o(90321);
            return null;
        }
        AppMethodBeat.o(90321);
        return packageName;
    }

    /* Access modifiers changed, original: protected */
    public Context getContext() {
        return this.zzjp;
    }

    public PackageInfo getPackageInfo(String str, int i) {
        AppMethodBeat.i(90308);
        PackageInfo packageInfo = this.zzjp.getPackageManager().getPackageInfo(str, i);
        AppMethodBeat.o(90308);
        return packageInfo;
    }

    public String[] getPackagesForUid(int i) {
        AppMethodBeat.i(90309);
        String[] packagesForUid = this.zzjp.getPackageManager().getPackagesForUid(i);
        AppMethodBeat.o(90309);
        return packagesForUid;
    }

    public boolean isCallerInstantApp() {
        AppMethodBeat.i(90325);
        boolean isInstantApp;
        if (Binder.getCallingUid() == Process.myUid()) {
            isInstantApp = InstantApps.isInstantApp(this.zzjp);
            AppMethodBeat.o(90325);
            return isInstantApp;
        }
        if (PlatformVersion.isAtLeastO()) {
            String nameForUid = this.zzjp.getPackageManager().getNameForUid(Binder.getCallingUid());
            if (nameForUid != null) {
                isInstantApp = this.zzjp.getPackageManager().isInstantApp(nameForUid);
                AppMethodBeat.o(90325);
                return isInstantApp;
            }
        }
        AppMethodBeat.o(90325);
        return false;
    }

    public boolean isInstantAppUid(int i) {
        return false;
    }

    @TargetApi(19)
    public boolean uidHasPackageName(int i, String str) {
        AppMethodBeat.i(90311);
        if (PlatformVersion.isAtLeastKitKat()) {
            try {
                ((AppOpsManager) this.zzjp.getSystemService("appops")).checkPackage(i, str);
                AppMethodBeat.o(90311);
                return true;
            } catch (SecurityException e) {
                AppMethodBeat.o(90311);
                return false;
            }
        }
        String[] packagesForUid = this.zzjp.getPackageManager().getPackagesForUid(i);
        if (!(str == null || packagesForUid == null)) {
            for (Object equals : packagesForUid) {
                if (str.equals(equals)) {
                    AppMethodBeat.o(90311);
                    return true;
                }
            }
        }
        AppMethodBeat.o(90311);
        return false;
    }

    public int checkCallingPermissionAndAppOps(String str, String str2) {
        AppMethodBeat.i(90316);
        Context context = this.zzjp;
        if (Binder.getCallingPid() == Process.myPid()) {
            AppMethodBeat.o(90316);
            return -1;
        }
        int a = f.a(context, str, Binder.getCallingPid(), Binder.getCallingUid(), str2);
        AppMethodBeat.o(90316);
        return a;
    }

    public j<CharSequence, Drawable> getApplicationLabelAndIcon(String str) {
        AppMethodBeat.i(90324);
        ApplicationInfo applicationInfo = this.zzjp.getPackageManager().getApplicationInfo(str, 0);
        j jVar = new j(this.zzjp.getPackageManager().getApplicationLabel(applicationInfo), this.zzjp.getPackageManager().getApplicationIcon(applicationInfo));
        AppMethodBeat.o(90324);
        return jVar;
    }
}
