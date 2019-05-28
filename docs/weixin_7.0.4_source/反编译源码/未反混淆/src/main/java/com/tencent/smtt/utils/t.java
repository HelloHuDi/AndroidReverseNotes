package com.tencent.smtt.utils;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public class t {
    public static boolean a(Context context) {
        AppMethodBeat.i(65302);
        try {
            if (VERSION.SDK_INT < 21) {
                AppMethodBeat.o(65302);
                return true;
            }
            File b = b(context);
            if (b == null) {
                AppMethodBeat.o(65302);
                return true;
            }
            for (File file : b.listFiles(new u())) {
                if (file.isFile() && file.exists()) {
                    if (a(file)) {
                        TbsLog.w("TbsCheckUtils", file + " is invalid --> check failed!");
                        file.delete();
                        AppMethodBeat.o(65302);
                        return false;
                    }
                    TbsLog.i("TbsCheckUtils", file + " #4 check success!");
                }
            }
            TbsLog.i("TbsCheckUtils", "checkTbsValidity -->#5 check ok!");
            AppMethodBeat.o(65302);
            return true;
        } catch (Throwable th) {
        }
    }

    private static boolean a(File file) {
        AppMethodBeat.i(65303);
        try {
            if (!j.b(file)) {
                AppMethodBeat.o(65303);
                return true;
            }
        } catch (Throwable th) {
            new StringBuilder("isOatFileBroken exception: ").append(th);
        }
        AppMethodBeat.o(65303);
        return false;
    }

    private static File b(Context context) {
        AppMethodBeat.i(65301);
        File file = new File(context.getDir("tbs", 0), "core_share");
        if (file.isDirectory() && file.exists()) {
            AppMethodBeat.o(65301);
            return file;
        }
        AppMethodBeat.o(65301);
        return null;
    }
}
