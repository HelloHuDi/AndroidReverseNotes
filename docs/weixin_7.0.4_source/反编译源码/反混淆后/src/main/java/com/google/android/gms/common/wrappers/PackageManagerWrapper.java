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
import android.support.p057v4.content.C0384f;
import android.support.p057v4.p065f.C0415j;
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
        AppMethodBeat.m2504i(90326);
        if (isCallerInstantApp()) {
            SecurityException securityException = new SecurityException("This operation is not supported for instant apps.");
            AppMethodBeat.m2505o(90326);
            throw securityException;
        }
        AppMethodBeat.m2505o(90326);
    }

    public int checkCallingOrSelfPermission(String str) {
        AppMethodBeat.m2504i(90317);
        int checkCallingOrSelfPermission = this.zzjp.checkCallingOrSelfPermission(str);
        AppMethodBeat.m2505o(90317);
        return checkCallingOrSelfPermission;
    }

    public int checkCallingOrSelfPermissionAndAppOps(String str) {
        AppMethodBeat.m2504i(90318);
        int f = C0384f.m655f(this.zzjp, str);
        AppMethodBeat.m2505o(90318);
        return f;
    }

    public int checkCallingPermission(String str) {
        AppMethodBeat.m2504i(90315);
        int checkCallingPermission = this.zzjp.checkCallingPermission(str);
        AppMethodBeat.m2505o(90315);
        return checkCallingPermission;
    }

    @Deprecated
    public int checkCallingPermission(String str, String str2) {
        AppMethodBeat.m2504i(90319);
        int checkPermission = checkPermission(str, str2);
        AppMethodBeat.m2505o(90319);
        return checkPermission;
    }

    public void checkPackage(int i, String str) {
        AppMethodBeat.m2504i(90310);
        if (uidHasPackageName(i, str)) {
            AppMethodBeat.m2505o(90310);
            return;
        }
        SecurityException securityException = new SecurityException(new StringBuilder(String.valueOf(str).length() + 39).append("Package ").append(str).append(" does not belong to ").append(i).toString());
        AppMethodBeat.m2505o(90310);
        throw securityException;
    }

    public int checkPermission(String str, int i, int i2) {
        AppMethodBeat.m2504i(90312);
        int checkPermission = this.zzjp.checkPermission(str, i, i2);
        AppMethodBeat.m2505o(90312);
        return checkPermission;
    }

    @Deprecated
    public int checkPermission(String str, int i, int i2, String str2) {
        AppMethodBeat.m2504i(90313);
        int checkPermission = checkPermission(str, i, i2);
        AppMethodBeat.m2505o(90313);
        return checkPermission;
    }

    public int checkPermission(String str, String str2) {
        AppMethodBeat.m2504i(90320);
        int checkPermission = this.zzjp.getPackageManager().checkPermission(str, str2);
        AppMethodBeat.m2505o(90320);
        return checkPermission;
    }

    public int checkPermissionAndAppOps(String str, int i, int i2, String str2) {
        AppMethodBeat.m2504i(90314);
        int a = C0384f.m654a(this.zzjp, str, i, i2, str2);
        AppMethodBeat.m2505o(90314);
        return a;
    }

    public ApplicationInfo getApplicationInfo(String str, int i) {
        AppMethodBeat.m2504i(90307);
        ApplicationInfo applicationInfo = this.zzjp.getPackageManager().getApplicationInfo(str, i);
        AppMethodBeat.m2505o(90307);
        return applicationInfo;
    }

    public CharSequence getApplicationLabel(String str) {
        AppMethodBeat.m2504i(90323);
        CharSequence applicationLabel = this.zzjp.getPackageManager().getApplicationLabel(this.zzjp.getPackageManager().getApplicationInfo(str, 0));
        AppMethodBeat.m2505o(90323);
        return applicationLabel;
    }

    public ComponentName getCallingActivity(Activity activity) {
        AppMethodBeat.m2504i(90322);
        ComponentName callingActivity = activity.getCallingActivity();
        AppMethodBeat.m2505o(90322);
        return callingActivity;
    }

    public String getCallingPackage(Activity activity) {
        AppMethodBeat.m2504i(90321);
        ComponentName callingActivity = activity.getCallingActivity();
        if (callingActivity == null) {
            AppMethodBeat.m2505o(90321);
            return null;
        }
        String packageName = callingActivity.getPackageName();
        if (packageName == null) {
            packageName = String.valueOf(callingActivity);
            new StringBuilder(String.valueOf(packageName).length() + 54).append("getCallingPackage(): Couldn't get a package name from ").append(packageName);
            AppMethodBeat.m2505o(90321);
            return null;
        }
        AppMethodBeat.m2505o(90321);
        return packageName;
    }

    /* Access modifiers changed, original: protected */
    public Context getContext() {
        return this.zzjp;
    }

    public PackageInfo getPackageInfo(String str, int i) {
        AppMethodBeat.m2504i(90308);
        PackageInfo packageInfo = this.zzjp.getPackageManager().getPackageInfo(str, i);
        AppMethodBeat.m2505o(90308);
        return packageInfo;
    }

    public String[] getPackagesForUid(int i) {
        AppMethodBeat.m2504i(90309);
        String[] packagesForUid = this.zzjp.getPackageManager().getPackagesForUid(i);
        AppMethodBeat.m2505o(90309);
        return packagesForUid;
    }

    public boolean isCallerInstantApp() {
        AppMethodBeat.m2504i(90325);
        boolean isInstantApp;
        if (Binder.getCallingUid() == Process.myUid()) {
            isInstantApp = InstantApps.isInstantApp(this.zzjp);
            AppMethodBeat.m2505o(90325);
            return isInstantApp;
        }
        if (PlatformVersion.isAtLeastO()) {
            String nameForUid = this.zzjp.getPackageManager().getNameForUid(Binder.getCallingUid());
            if (nameForUid != null) {
                isInstantApp = this.zzjp.getPackageManager().isInstantApp(nameForUid);
                AppMethodBeat.m2505o(90325);
                return isInstantApp;
            }
        }
        AppMethodBeat.m2505o(90325);
        return false;
    }

    public boolean isInstantAppUid(int i) {
        return false;
    }

    @TargetApi(19)
    public boolean uidHasPackageName(int i, String str) {
        AppMethodBeat.m2504i(90311);
        if (PlatformVersion.isAtLeastKitKat()) {
            try {
                ((AppOpsManager) this.zzjp.getSystemService("appops")).checkPackage(i, str);
                AppMethodBeat.m2505o(90311);
                return true;
            } catch (SecurityException e) {
                AppMethodBeat.m2505o(90311);
                return false;
            }
        }
        String[] packagesForUid = this.zzjp.getPackageManager().getPackagesForUid(i);
        if (!(str == null || packagesForUid == null)) {
            for (Object equals : packagesForUid) {
                if (str.equals(equals)) {
                    AppMethodBeat.m2505o(90311);
                    return true;
                }
            }
        }
        AppMethodBeat.m2505o(90311);
        return false;
    }

    public int checkCallingPermissionAndAppOps(String str, String str2) {
        AppMethodBeat.m2504i(90316);
        Context context = this.zzjp;
        if (Binder.getCallingPid() == Process.myPid()) {
            AppMethodBeat.m2505o(90316);
            return -1;
        }
        int a = C0384f.m654a(context, str, Binder.getCallingPid(), Binder.getCallingUid(), str2);
        AppMethodBeat.m2505o(90316);
        return a;
    }

    public C0415j<CharSequence, Drawable> getApplicationLabelAndIcon(String str) {
        AppMethodBeat.m2504i(90324);
        ApplicationInfo applicationInfo = this.zzjp.getPackageManager().getApplicationInfo(str, 0);
        C0415j c0415j = new C0415j(this.zzjp.getPackageManager().getApplicationLabel(applicationInfo), this.zzjp.getPackageManager().getApplicationIcon(applicationInfo));
        AppMethodBeat.m2505o(90324);
        return c0415j;
    }
}
