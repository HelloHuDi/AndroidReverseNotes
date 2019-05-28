package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;

class TbsLinuxToolsJni {
    private static boolean a = false;
    private static boolean b = false;

    public TbsLinuxToolsJni(Context context) {
        AppMethodBeat.i(64476);
        a(context);
        AppMethodBeat.o(64476);
    }

    private native int ChmodInner(String str, String str2);

    private void a(Context context) {
        AppMethodBeat.i(64477);
        synchronized (TbsLinuxToolsJni.class) {
            try {
                TbsLog.i("TbsLinuxToolsJni", "TbsLinuxToolsJni init mbIsInited is " + b);
                if (b) {
                    AppMethodBeat.o(64477);
                    return;
                }
                File file;
                b = true;
                if (TbsShareManager.isThirdPartyApp(context)) {
                    String a = TbsShareManager.a();
                    file = new File(a == null ? TbsShareManager.c(context) : a);
                } else {
                    file = an.a().r(context);
                }
                if (file != null) {
                    if (!(new File(file.getAbsolutePath() + File.separator + "liblinuxtoolsfortbssdk_jni.so").exists() || TbsShareManager.isThirdPartyApp(context))) {
                        file = an.a().q(context);
                    }
                    if (file != null) {
                        TbsLog.i("TbsLinuxToolsJni", "TbsLinuxToolsJni init tbsSharePath is " + file.getAbsolutePath());
                        System.load(file.getAbsolutePath() + File.separator + "liblinuxtoolsfortbssdk_jni.so");
                        a = true;
                    }
                }
                ChmodInner("/checkChmodeExists", "700");
                AppMethodBeat.o(64477);
            } catch (Throwable th) {
                AppMethodBeat.o(64477);
            }
        }
    }

    public int a(String str, String str2) {
        AppMethodBeat.i(64475);
        if (a) {
            int ChmodInner = ChmodInner(str, str2);
            AppMethodBeat.o(64475);
            return ChmodInner;
        }
        TbsLog.e("TbsLinuxToolsJni", "jni not loaded!", true);
        AppMethodBeat.o(64475);
        return -1;
    }
}
