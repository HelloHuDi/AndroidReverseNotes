package com.tencent.smtt.utils;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

/* renamed from: com.tencent.smtt.utils.t */
public class C30952t {
    /* renamed from: a */
    public static boolean m49581a(Context context) {
        AppMethodBeat.m2504i(65302);
        try {
            if (VERSION.SDK_INT < 21) {
                AppMethodBeat.m2505o(65302);
                return true;
            }
            File b = C30952t.m49583b(context);
            if (b == null) {
                AppMethodBeat.m2505o(65302);
                return true;
            }
            for (File file : b.listFiles(new C36445u())) {
                if (file.isFile() && file.exists()) {
                    if (C30952t.m49582a(file)) {
                        TbsLog.m80438w("TbsCheckUtils", file + " is invalid --> check failed!");
                        file.delete();
                        AppMethodBeat.m2505o(65302);
                        return false;
                    }
                    TbsLog.m80434i("TbsCheckUtils", file + " #4 check success!");
                }
            }
            TbsLog.m80434i("TbsCheckUtils", "checkTbsValidity -->#5 check ok!");
            AppMethodBeat.m2505o(65302);
            return true;
        } catch (Throwable th) {
        }
    }

    /* renamed from: a */
    private static boolean m49582a(File file) {
        AppMethodBeat.m2504i(65303);
        try {
            if (!C24278j.m37446b(file)) {
                AppMethodBeat.m2505o(65303);
                return true;
            }
        } catch (Throwable th) {
            new StringBuilder("isOatFileBroken exception: ").append(th);
        }
        AppMethodBeat.m2505o(65303);
        return false;
    }

    /* renamed from: b */
    private static File m49583b(Context context) {
        AppMethodBeat.m2504i(65301);
        File file = new File(context.getDir("tbs", 0), "core_share");
        if (file.isDirectory() && file.exists()) {
            AppMethodBeat.m2505o(65301);
            return file;
        }
        AppMethodBeat.m2505o(65301);
        return null;
    }
}
