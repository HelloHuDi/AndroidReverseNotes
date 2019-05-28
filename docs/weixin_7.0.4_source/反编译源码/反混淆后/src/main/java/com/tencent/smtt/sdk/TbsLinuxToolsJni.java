package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;

class TbsLinuxToolsJni {
    /* renamed from: a */
    private static boolean f17283a = false;
    /* renamed from: b */
    private static boolean f17284b = false;

    public TbsLinuxToolsJni(Context context) {
        AppMethodBeat.m2504i(64476);
        m80424a(context);
        AppMethodBeat.m2505o(64476);
    }

    private native int ChmodInner(String str, String str2);

    /* renamed from: a */
    private void m80424a(Context context) {
        AppMethodBeat.m2504i(64477);
        synchronized (TbsLinuxToolsJni.class) {
            try {
                TbsLog.m80434i("TbsLinuxToolsJni", "TbsLinuxToolsJni init mbIsInited is " + f17284b);
                if (f17284b) {
                    AppMethodBeat.m2505o(64477);
                    return;
                }
                File file;
                f17284b = true;
                if (TbsShareManager.isThirdPartyApp(context)) {
                    String a = TbsShareManager.m49461a();
                    file = new File(a == null ? TbsShareManager.m49467c(context) : a);
                } else {
                    file = C5813an.m8800a().mo12183r(context);
                }
                if (file != null) {
                    if (!(new File(file.getAbsolutePath() + File.separator + "liblinuxtoolsfortbssdk_jni.so").exists() || TbsShareManager.isThirdPartyApp(context))) {
                        file = C5813an.m8800a().mo12182q(context);
                    }
                    if (file != null) {
                        TbsLog.m80434i("TbsLinuxToolsJni", "TbsLinuxToolsJni init tbsSharePath is " + file.getAbsolutePath());
                        System.load(file.getAbsolutePath() + File.separator + "liblinuxtoolsfortbssdk_jni.so");
                        f17283a = true;
                    }
                }
                ChmodInner("/checkChmodeExists", "700");
                AppMethodBeat.m2505o(64477);
            } catch (Throwable th) {
                AppMethodBeat.m2505o(64477);
            }
        }
    }

    /* renamed from: a */
    public int mo70610a(String str, String str2) {
        AppMethodBeat.m2504i(64475);
        if (f17283a) {
            int ChmodInner = ChmodInner(str, str2);
            AppMethodBeat.m2505o(64475);
            return ChmodInner;
        }
        TbsLog.m80433e("TbsLinuxToolsJni", "jni not loaded!", true);
        AppMethodBeat.m2505o(64475);
        return -1;
    }
}
