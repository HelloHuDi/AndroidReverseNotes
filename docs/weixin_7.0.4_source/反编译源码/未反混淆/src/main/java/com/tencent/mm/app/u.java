package com.tencent.mm.app;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.lib.e.b;
import com.tencent.tinker.lib.util.a;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import org.xmlpull.v1.XmlPullParserException;

public final class u {
    public static boolean b(StackTraceElement[] stackTraceElementArr) {
        AppMethodBeat.i(115034);
        int length = stackTraceElementArr.length;
        int i = 0;
        while (i < length) {
            String className = stackTraceElementArr[i].getClassName();
            if (className == null || !(className.contains("de.robv.android.xposed.XposedBridge") || className.contains("com.zte.heartyservice.SCC.FrameworkBridge"))) {
                i++;
            } else {
                AppMethodBeat.o(115034);
                return true;
            }
        }
        AppMethodBeat.o(115034);
        return false;
    }

    public static void f(Throwable th) {
        AppMethodBeat.i(115035);
        ApplicationLike applicationLike = b.cdV;
        if (applicationLike == null || applicationLike.getApplication() == null) {
            a.w("TinkerCrashProtect", "applicationlike is null", new Object[0]);
            AppMethodBeat.o(115035);
        } else if (b.c(applicationLike)) {
            int i = (Build.MODEL.contains("ZUK") || Build.MODEL.contains("zuk")) ? 1 : 0;
            boolean z = false;
            while (th != null) {
                boolean z2;
                if (z) {
                    z2 = z;
                } else {
                    z2 = b(th.getStackTrace());
                }
                if (z2) {
                    int i2;
                    if ((th instanceof IllegalAccessError) && th.getMessage().contains("Class ref in pre-verified class resolved to unexpected implementation")) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    if (i2 != 0) {
                        a.e("TinkerCrashProtect", "have xposed: just clean tinker", new Object[0]);
                        ShareTinkerInternals.jr(applicationLike.getApplication());
                        b.e(applicationLike);
                        ShareTinkerInternals.jm(applicationLike.getApplication());
                        AppMethodBeat.o(115035);
                        return;
                    }
                }
                if (i != 0) {
                    a.w("TinkerCrashProtect", "it is zuk model here, crash:" + th.getMessage(), new Object[0]);
                    if ((th instanceof XmlPullParserException) && th.getMessage().contains("tag requires a 'drawable' attribute or child tag defining a drawable")) {
                        a.e("TinkerCrashProtect", "have zuk parse error: just clean tinker", new Object[0]);
                        ShareTinkerInternals.jr(applicationLike.getApplication());
                        b.e(applicationLike);
                        ShareTinkerInternals.jm(applicationLike.getApplication());
                        AppMethodBeat.o(115035);
                        return;
                    }
                }
                th = th.getCause();
                z = z2;
            }
            AppMethodBeat.o(115035);
        } else {
            a.w("TinkerCrashProtect", "tinker is not loaded", new Object[0]);
            AppMethodBeat.o(115035);
        }
    }
}
