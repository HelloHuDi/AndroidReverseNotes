package com.tencent.d.d.a;

import com.tencent.d.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;

public final class a {
    public static boolean atP(String str) {
        AppMethodBeat.i(114501);
        if (new File(str).exists()) {
            try {
                boolean atP = com.tencent.d.d.b.a.atP(str);
                if (!atP) {
                    "BootScriptChecker found no-elf file : ".concat(String.valueOf(str));
                    h.dQG();
                }
                AppMethodBeat.o(114501);
                return atP;
            } catch (IOException e) {
                h.w(e);
                AppMethodBeat.o(114501);
                return true;
            }
        }
        AppMethodBeat.o(114501);
        return true;
    }

    public static boolean atQ(String str) {
        boolean z = true;
        AppMethodBeat.i(114502);
        File file = new File(str);
        if (!file.exists() || file.length() > 51200) {
            AppMethodBeat.o(114502);
        } else {
            try {
                String str2 = new String(com.tencent.d.d.b.a.atR(file.getAbsolutePath()));
                z = str2.contains("applypatch ");
                new StringBuilder("BootScriptChecker script (").append(str).append(") content : \n").append(str2);
                h.dQH();
                if (!z) {
                    "BootScriptChecker found unofficial file : ".concat(String.valueOf(str));
                    h.dQG();
                }
                AppMethodBeat.o(114502);
            } catch (Exception e) {
                h.w(e);
                AppMethodBeat.o(114502);
            }
        }
        return z;
    }
}
