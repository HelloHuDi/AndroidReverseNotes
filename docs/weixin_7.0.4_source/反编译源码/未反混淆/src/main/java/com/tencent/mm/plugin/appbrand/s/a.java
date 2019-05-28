package com.tencent.mm.plugin.appbrand.s;

import a.f.b.j;
import a.l;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006H\u0007¨\u0006\b"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/utils/AndroidComponentUtil;", "", "()V", "isActivityHasSpecificTaskAffinity", "", "clazz", "Ljava/lang/Class;", "Landroid/app/Activity;", "plugin-appbrand-integration_release"})
public final class a {
    public static final a iRb = new a();

    static {
        AppMethodBeat.i(135218);
        AppMethodBeat.o(135218);
    }

    private a() {
    }

    /* JADX WARNING: Missing block: B:7:0x0027, code skipped:
            if (r0 == null) goto L_0x0029;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean al(Class<? extends Activity> cls) {
        Object obj;
        AppMethodBeat.i(135217);
        j.p(cls, "clazz");
        Context context = ah.getContext();
        if (context != null) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(context, cls), 128);
                if (activityInfo != null) {
                    obj = activityInfo.taskAffinity;
                }
            }
        }
        j.o(context, "appContext");
        obj = context.getPackageName();
        int j = j.j(obj, context.getPackageName()) ^ 1;
        AppMethodBeat.o(135217);
        return j;
    }
}
