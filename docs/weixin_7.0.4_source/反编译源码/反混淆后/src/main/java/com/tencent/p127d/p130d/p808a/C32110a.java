package com.tencent.p127d.p130d.p808a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p127d.p130d.p131b.C37317a;
import com.tencent.p127d.p135f.C45085h;
import java.io.File;
import java.io.IOException;

/* renamed from: com.tencent.d.d.a.a */
public final class C32110a {
    public static boolean atP(String str) {
        AppMethodBeat.m2504i(114501);
        if (new File(str).exists()) {
            try {
                boolean atP = C37317a.atP(str);
                if (!atP) {
                    "BootScriptChecker found no-elf file : ".concat(String.valueOf(str));
                    C45085h.dQG();
                }
                AppMethodBeat.m2505o(114501);
                return atP;
            } catch (IOException e) {
                C45085h.m82713w(e);
                AppMethodBeat.m2505o(114501);
                return true;
            }
        }
        AppMethodBeat.m2505o(114501);
        return true;
    }

    public static boolean atQ(String str) {
        boolean z = true;
        AppMethodBeat.m2504i(114502);
        File file = new File(str);
        if (!file.exists() || file.length() > 51200) {
            AppMethodBeat.m2505o(114502);
        } else {
            try {
                String str2 = new String(C37317a.atR(file.getAbsolutePath()));
                z = str2.contains("applypatch ");
                new StringBuilder("BootScriptChecker script (").append(str).append(") content : \n").append(str2);
                C45085h.dQH();
                if (!z) {
                    "BootScriptChecker found unofficial file : ".concat(String.valueOf(str));
                    C45085h.dQG();
                }
                AppMethodBeat.m2505o(114502);
            } catch (Exception e) {
                C45085h.m82713w(e);
                AppMethodBeat.m2505o(114502);
            }
        }
        return z;
    }
}
