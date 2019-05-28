package android.support.p057v4.content;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.util.TypedValue;
import java.io.File;

/* renamed from: android.support.v4.content.b */
public class C0380b {
    /* renamed from: Gk */
    private static TypedValue f428Gk;
    private static final Object sLock = new Object();

    /* renamed from: a */
    public static boolean m648a(Context context, Intent[] intentArr) {
        if (VERSION.SDK_INT >= 16) {
            context.startActivities(intentArr, null);
        } else {
            context.startActivities(intentArr);
        }
        return true;
    }

    public static void startActivity(Context context, Intent intent, Bundle bundle) {
        if (VERSION.SDK_INT >= 16) {
            context.startActivity(intent, bundle);
        } else {
            context.startActivity(intent);
        }
    }

    /* renamed from: O */
    public static File[] m644O(Context context) {
        if (VERSION.SDK_INT >= 19) {
            return context.getExternalFilesDirs(null);
        }
        return new File[]{context.getExternalFilesDir(null)};
    }

    /* renamed from: P */
    public static File[] m645P(Context context) {
        if (VERSION.SDK_INT >= 19) {
            return context.getExternalCacheDirs();
        }
        return new File[]{context.getExternalCacheDir()};
    }

    /* renamed from: g */
    public static Drawable m649g(Context context, int i) {
        if (VERSION.SDK_INT >= 21) {
            return context.getDrawable(i);
        }
        if (VERSION.SDK_INT >= 16) {
            return context.getResources().getDrawable(i);
        }
        int i2;
        synchronized (sLock) {
            if (f428Gk == null) {
                f428Gk = new TypedValue();
            }
            context.getResources().getValue(i, f428Gk, true);
            i2 = f428Gk.resourceId;
        }
        return context.getResources().getDrawable(i2);
    }

    /* renamed from: h */
    public static ColorStateList m650h(Context context, int i) {
        if (VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i);
        }
        return context.getResources().getColorStateList(i);
    }

    /* renamed from: i */
    public static int m652i(Context context, int i) {
        if (VERSION.SDK_INT >= 23) {
            return context.getColor(i);
        }
        return context.getResources().getColor(i);
    }

    public static int checkSelfPermission(Context context, String str) {
        if (str != null) {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        throw new IllegalArgumentException("permission is null");
    }

    /* renamed from: Q */
    public static File m646Q(Context context) {
        if (VERSION.SDK_INT >= 21) {
            return context.getNoBackupFilesDir();
        }
        return C0380b.m651h(new File(context.getApplicationInfo().dataDir, "no_backup"));
    }

    /* renamed from: h */
    private static synchronized File m651h(File file) {
        synchronized (C0380b.class) {
            if (!(file.exists() || file.mkdirs() || file.exists())) {
                new StringBuilder("Unable to create files subdir ").append(file.getPath());
                file = null;
            }
        }
        return file;
    }

    /* renamed from: R */
    public static boolean m647R(Context context) {
        if (VERSION.SDK_INT >= 24) {
            return context.isDeviceProtectedStorage();
        }
        return false;
    }
}
