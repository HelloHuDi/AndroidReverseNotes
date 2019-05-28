package com.tencent.p177mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1178g;
import java.io.File;
import java.io.IOException;

/* renamed from: com.tencent.mm.sdk.platformtools.j */
public final class C15428j {
    private static String amm(String str) {
        AppMethodBeat.m2504i(51978);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(51978);
            return null;
        } else if (str.length() <= 4) {
            AppMethodBeat.m2505o(51978);
            return null;
        } else {
            String str2 = str.substring(0, 2) + "/" + str.substring(2, 4) + "/";
            AppMethodBeat.m2505o(51978);
            return str2;
        }
    }

    public static boolean aih(String str) {
        AppMethodBeat.m2504i(51979);
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
                file = new File(str + ".nomedia");
                if (!file.exists()) {
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        C4990ab.printErrStackTrace("MicroMsg.FilePathGenerator", e, "", new Object[0]);
                    }
                }
            }
            AppMethodBeat.m2505o(51979);
            return true;
        } catch (Exception e2) {
            AppMethodBeat.m2505o(51979);
            return false;
        }
    }

    /* renamed from: a */
    private static String m23708a(String str, String str2, String str3, String str4, int i, boolean z) {
        AppMethodBeat.m2504i(51980);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(51980);
            return null;
        } else if (str.endsWith("/")) {
            String str5 = "";
            if (i == 1) {
                str5 = C15428j.amm(str3);
            } else if (i == 2) {
                if (C5046bo.isNullOrNil(str3)) {
                    str5 = null;
                } else {
                    str5 = C15428j.amm(C1178g.m2591x(str3.getBytes()));
                }
            }
            if (C5046bo.isNullOrNil(str5)) {
                AppMethodBeat.m2505o(51980);
                return null;
            }
            str5 = str + str5;
            if (!z || C15428j.aih(str5)) {
                String str6 = str5 + C5046bo.nullAsNil(str2) + str3 + C5046bo.nullAsNil(str4);
                AppMethodBeat.m2505o(51980);
                return str6;
            }
            AppMethodBeat.m2505o(51980);
            return null;
        } else {
            AppMethodBeat.m2505o(51980);
            return null;
        }
    }

    /* renamed from: b */
    public static String m23709b(String str, String str2, String str3, String str4, int i) {
        AppMethodBeat.m2504i(51981);
        String a = C15428j.m23708a(str, str2, str3, str4, i, true);
        AppMethodBeat.m2505o(51981);
        return a;
    }

    /* renamed from: b */
    public static String m23710b(String str, String str2, String str3, String str4, String str5, boolean z) {
        AppMethodBeat.m2504i(51982);
        String str6 = str + str3 + str4 + str5;
        String a = C15428j.m23708a(str2, str3, str4, str5, 1, z);
        if (C5046bo.isNullOrNil(str6) || C5046bo.isNullOrNil(a)) {
            AppMethodBeat.m2505o(51982);
            return null;
        }
        File file = new File(a);
        File file2 = new File(str6);
        if (file.exists()) {
            AppMethodBeat.m2505o(51982);
            return a;
        }
        if (file2.exists()) {
            C40616m.m70056C(str6, a, false);
        }
        AppMethodBeat.m2505o(51982);
        return a;
    }

    /* renamed from: g */
    public static String m23711g(String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.m2504i(51983);
        String b = C15428j.m23710b(str, str2, str3, str4, str5, true);
        AppMethodBeat.m2505o(51983);
        return b;
    }
}
