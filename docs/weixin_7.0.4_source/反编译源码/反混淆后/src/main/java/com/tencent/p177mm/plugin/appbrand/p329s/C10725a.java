package com.tencent.p177mm.plugin.appbrand.p329s;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006H\u0007¨\u0006\b"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/utils/AndroidComponentUtil;", "", "()V", "isActivityHasSpecificTaskAffinity", "", "clazz", "Ljava/lang/Class;", "Landroid/app/Activity;", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.s.a */
public final class C10725a {
    public static final C10725a iRb = new C10725a();

    static {
        AppMethodBeat.m2504i(135218);
        AppMethodBeat.m2505o(135218);
    }

    private C10725a() {
    }

    /* JADX WARNING: Missing block: B:7:0x0027, code skipped:
            if (r0 == null) goto L_0x0029;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: al */
    public static final boolean m18398al(Class<? extends Activity> cls) {
        Object obj;
        AppMethodBeat.m2504i(135217);
        C25052j.m39376p(cls, "clazz");
        Context context = C4996ah.getContext();
        if (context != null) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(context, cls), 128);
                if (activityInfo != null) {
                    obj = activityInfo.taskAffinity;
                }
            }
        }
        C25052j.m39375o(context, "appContext");
        obj = context.getPackageName();
        int j = C25052j.m39373j(obj, context.getPackageName()) ^ 1;
        AppMethodBeat.m2505o(135217);
        return j;
    }
}
