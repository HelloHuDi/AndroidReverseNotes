package android.support.p057v4.content;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Process;

/* renamed from: android.support.v4.content.f */
public final class C0384f {
    /* renamed from: a */
    public static int m654a(Context context, String str, int i, int i2, String str2) {
        if (context.checkPermission(str, i, i2) == -1) {
            return -1;
        }
        String permissionToOp;
        if (VERSION.SDK_INT >= 23) {
            permissionToOp = AppOpsManager.permissionToOp(str);
        } else {
            permissionToOp = null;
        }
        if (permissionToOp == null) {
            return 0;
        }
        int noteProxyOpNoThrow;
        if (str2 == null) {
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(i2);
            if (packagesForUid == null || packagesForUid.length <= 0) {
                return -1;
            }
            str2 = packagesForUid[0];
        }
        if (VERSION.SDK_INT >= 23) {
            noteProxyOpNoThrow = ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOpNoThrow(permissionToOp, str2);
        } else {
            noteProxyOpNoThrow = 1;
        }
        if (noteProxyOpNoThrow != 0) {
            return -2;
        }
        return 0;
    }

    public static int checkSelfPermission(Context context, String str) {
        return C0384f.m654a(context, str, Process.myPid(), Process.myUid(), context.getPackageName());
    }

    /* renamed from: f */
    public static int m655f(Context context, String str) {
        return C0384f.m654a(context, str, Binder.getCallingPid(), Binder.getCallingUid(), Binder.getCallingPid() == Process.myPid() ? context.getPackageName() : null);
    }
}
