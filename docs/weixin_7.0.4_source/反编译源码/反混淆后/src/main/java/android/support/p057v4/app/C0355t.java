package android.support.p057v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;

/* renamed from: android.support.v4.app.t */
public final class C0355t {
    /* renamed from: f */
    public static Intent m584f(Activity activity) {
        if (VERSION.SDK_INT >= 16) {
            Intent parentActivityIntent = activity.getParentActivityIntent();
            if (parentActivityIntent != null) {
                return parentActivityIntent;
            }
        }
        String g = C0355t.m585g(activity);
        if (g == null) {
            return null;
        }
        ComponentName componentName = new ComponentName(activity, g);
        try {
            if (C0355t.m583b(activity, componentName) == null) {
                return Intent.makeMainActivity(componentName);
            }
            return new Intent().setComponent(componentName);
        } catch (NameNotFoundException e) {
            new StringBuilder("getParentActivityIntent: bad parentActivityName '").append(g).append("' in manifest");
            return null;
        }
    }

    /* renamed from: a */
    public static Intent m582a(Context context, ComponentName componentName) {
        String b = C0355t.m583b(context, componentName);
        if (b == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), b);
        if (C0355t.m583b(context, componentName2) == null) {
            return Intent.makeMainActivity(componentName2);
        }
        return new Intent().setComponent(componentName2);
    }

    /* renamed from: g */
    public static String m585g(Activity activity) {
        try {
            return C0355t.m583b(activity, activity.getComponentName());
        } catch (NameNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /* renamed from: b */
    private static String m583b(Context context, ComponentName componentName) {
        String str;
        ActivityInfo activityInfo = context.getPackageManager().getActivityInfo(componentName, 128);
        if (VERSION.SDK_INT >= 16) {
            str = activityInfo.parentActivityName;
            if (str != null) {
                return str;
            }
        }
        if (activityInfo.metaData == null) {
            return null;
        }
        str = activityInfo.metaData.getString("android.support.PARENT_ACTIVITY");
        if (str == null) {
            return null;
        }
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        }
        return str;
    }
}
