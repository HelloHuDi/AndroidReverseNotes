package com.tencent.p177mm.app;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.lib.p679e.C5941b;
import com.tencent.tinker.lib.util.C5952a;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: com.tencent.mm.app.u */
public final class C1269u {
    /* renamed from: b */
    public static boolean m2727b(StackTraceElement[] stackTraceElementArr) {
        AppMethodBeat.m2504i(115034);
        int length = stackTraceElementArr.length;
        int i = 0;
        while (i < length) {
            String className = stackTraceElementArr[i].getClassName();
            if (className == null || !(className.contains("de.robv.android.xposed.XposedBridge") || className.contains("com.zte.heartyservice.SCC.FrameworkBridge"))) {
                i++;
            } else {
                AppMethodBeat.m2505o(115034);
                return true;
            }
        }
        AppMethodBeat.m2505o(115034);
        return false;
    }

    /* renamed from: f */
    public static void m2728f(Throwable th) {
        AppMethodBeat.m2504i(115035);
        ApplicationLike applicationLike = C1244b.cdV;
        if (applicationLike == null || applicationLike.getApplication() == null) {
            C5952a.m9285w("TinkerCrashProtect", "applicationlike is null", new Object[0]);
            AppMethodBeat.m2505o(115035);
        } else if (C5941b.m9259c(applicationLike)) {
            int i = (Build.MODEL.contains("ZUK") || Build.MODEL.contains("zuk")) ? 1 : 0;
            boolean z = false;
            while (th != null) {
                boolean z2;
                if (z) {
                    z2 = z;
                } else {
                    z2 = C1269u.m2727b(th.getStackTrace());
                }
                if (z2) {
                    int i2;
                    if ((th instanceof IllegalAccessError) && th.getMessage().contains("Class ref in pre-verified class resolved to unexpected implementation")) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    if (i2 != 0) {
                        C5952a.m9283e("TinkerCrashProtect", "have xposed: just clean tinker", new Object[0]);
                        ShareTinkerInternals.m9426jr(applicationLike.getApplication());
                        C5941b.m9261e(applicationLike);
                        ShareTinkerInternals.m9421jm(applicationLike.getApplication());
                        AppMethodBeat.m2505o(115035);
                        return;
                    }
                }
                if (i != 0) {
                    C5952a.m9285w("TinkerCrashProtect", "it is zuk model here, crash:" + th.getMessage(), new Object[0]);
                    if ((th instanceof XmlPullParserException) && th.getMessage().contains("tag requires a 'drawable' attribute or child tag defining a drawable")) {
                        C5952a.m9283e("TinkerCrashProtect", "have zuk parse error: just clean tinker", new Object[0]);
                        ShareTinkerInternals.m9426jr(applicationLike.getApplication());
                        C5941b.m9261e(applicationLike);
                        ShareTinkerInternals.m9421jm(applicationLike.getApplication());
                        AppMethodBeat.m2505o(115035);
                        return;
                    }
                }
                th = th.getCause();
                z = z2;
            }
            AppMethodBeat.m2505o(115035);
        } else {
            C5952a.m9285w("TinkerCrashProtect", "tinker is not loaded", new Object[0]);
            AppMethodBeat.m2505o(115035);
        }
    }
}
