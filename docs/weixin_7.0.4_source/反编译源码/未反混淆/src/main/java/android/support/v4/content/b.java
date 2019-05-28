package android.support.v4.content;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.util.TypedValue;
import java.io.File;

public class b {
    private static TypedValue Gk;
    private static final Object sLock = new Object();

    public static boolean a(Context context, Intent[] intentArr) {
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

    public static File[] O(Context context) {
        if (VERSION.SDK_INT >= 19) {
            return context.getExternalFilesDirs(null);
        }
        return new File[]{context.getExternalFilesDir(null)};
    }

    public static File[] P(Context context) {
        if (VERSION.SDK_INT >= 19) {
            return context.getExternalCacheDirs();
        }
        return new File[]{context.getExternalCacheDir()};
    }

    public static Drawable g(Context context, int i) {
        if (VERSION.SDK_INT >= 21) {
            return context.getDrawable(i);
        }
        if (VERSION.SDK_INT >= 16) {
            return context.getResources().getDrawable(i);
        }
        int i2;
        synchronized (sLock) {
            if (Gk == null) {
                Gk = new TypedValue();
            }
            context.getResources().getValue(i, Gk, true);
            i2 = Gk.resourceId;
        }
        return context.getResources().getDrawable(i2);
    }

    public static ColorStateList h(Context context, int i) {
        if (VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i);
        }
        return context.getResources().getColorStateList(i);
    }

    public static int i(Context context, int i) {
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

    public static File Q(Context context) {
        if (VERSION.SDK_INT >= 21) {
            return context.getNoBackupFilesDir();
        }
        return h(new File(context.getApplicationInfo().dataDir, "no_backup"));
    }

    private static synchronized File h(File file) {
        synchronized (b.class) {
            if (!(file.exists() || file.mkdirs() || file.exists())) {
                new StringBuilder("Unable to create files subdir ").append(file.getPath());
                file = null;
            }
        }
        return file;
    }

    public static boolean R(Context context) {
        if (VERSION.SDK_INT >= 24) {
            return context.isDeviceProtectedStorage();
        }
        return false;
    }
}
