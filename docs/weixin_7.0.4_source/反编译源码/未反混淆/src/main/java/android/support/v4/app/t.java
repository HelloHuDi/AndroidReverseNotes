package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;

public final class t {
    public static Intent f(Activity activity) {
        if (VERSION.SDK_INT >= 16) {
            Intent parentActivityIntent = activity.getParentActivityIntent();
            if (parentActivityIntent != null) {
                return parentActivityIntent;
            }
        }
        String g = g(activity);
        if (g == null) {
            return null;
        }
        ComponentName componentName = new ComponentName(activity, g);
        try {
            if (b(activity, componentName) == null) {
                return Intent.makeMainActivity(componentName);
            }
            return new Intent().setComponent(componentName);
        } catch (NameNotFoundException e) {
            new StringBuilder("getParentActivityIntent: bad parentActivityName '").append(g).append("' in manifest");
            return null;
        }
    }

    public static Intent a(Context context, ComponentName componentName) {
        String b = b(context, componentName);
        if (b == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), b);
        if (b(context, componentName2) == null) {
            return Intent.makeMainActivity(componentName2);
        }
        return new Intent().setComponent(componentName2);
    }

    public static String g(Activity activity) {
        try {
            return b(activity, activity.getComponentName());
        } catch (NameNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private static String b(Context context, ComponentName componentName) {
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
