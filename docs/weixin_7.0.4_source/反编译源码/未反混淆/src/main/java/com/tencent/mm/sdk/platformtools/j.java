package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import java.io.File;
import java.io.IOException;

public final class j {
    private static String amm(String str) {
        AppMethodBeat.i(51978);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(51978);
            return null;
        } else if (str.length() <= 4) {
            AppMethodBeat.o(51978);
            return null;
        } else {
            String str2 = str.substring(0, 2) + "/" + str.substring(2, 4) + "/";
            AppMethodBeat.o(51978);
            return str2;
        }
    }

    public static boolean aih(String str) {
        AppMethodBeat.i(51979);
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
                file = new File(str + ".nomedia");
                if (!file.exists()) {
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        ab.printErrStackTrace("MicroMsg.FilePathGenerator", e, "", new Object[0]);
                    }
                }
            }
            AppMethodBeat.o(51979);
            return true;
        } catch (Exception e2) {
            AppMethodBeat.o(51979);
            return false;
        }
    }

    private static String a(String str, String str2, String str3, String str4, int i, boolean z) {
        AppMethodBeat.i(51980);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(51980);
            return null;
        } else if (str.endsWith("/")) {
            String str5 = "";
            if (i == 1) {
                str5 = amm(str3);
            } else if (i == 2) {
                if (bo.isNullOrNil(str3)) {
                    str5 = null;
                } else {
                    str5 = amm(g.x(str3.getBytes()));
                }
            }
            if (bo.isNullOrNil(str5)) {
                AppMethodBeat.o(51980);
                return null;
            }
            str5 = str + str5;
            if (!z || aih(str5)) {
                String str6 = str5 + bo.nullAsNil(str2) + str3 + bo.nullAsNil(str4);
                AppMethodBeat.o(51980);
                return str6;
            }
            AppMethodBeat.o(51980);
            return null;
        } else {
            AppMethodBeat.o(51980);
            return null;
        }
    }

    public static String b(String str, String str2, String str3, String str4, int i) {
        AppMethodBeat.i(51981);
        String a = a(str, str2, str3, str4, i, true);
        AppMethodBeat.o(51981);
        return a;
    }

    public static String b(String str, String str2, String str3, String str4, String str5, boolean z) {
        AppMethodBeat.i(51982);
        String str6 = str + str3 + str4 + str5;
        String a = a(str2, str3, str4, str5, 1, z);
        if (bo.isNullOrNil(str6) || bo.isNullOrNil(a)) {
            AppMethodBeat.o(51982);
            return null;
        }
        File file = new File(a);
        File file2 = new File(str6);
        if (file.exists()) {
            AppMethodBeat.o(51982);
            return a;
        }
        if (file2.exists()) {
            m.C(str6, a, false);
        }
        AppMethodBeat.o(51982);
        return a;
    }

    public static String g(String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(51983);
        String b = b(str, str2, str3, str4, str5, true);
        AppMethodBeat.o(51983);
        return b;
    }
}
