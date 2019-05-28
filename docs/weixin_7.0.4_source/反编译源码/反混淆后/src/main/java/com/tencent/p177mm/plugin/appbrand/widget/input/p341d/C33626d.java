package com.tencent.p177mm.plugin.appbrand.widget.input.p341d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.input.d.d */
public final class C33626d {
    /* renamed from: am */
    private static int m54897am(Class cls) {
        AppMethodBeat.m2504i(77453);
        if (cls.isEnum()) {
            int i = 0;
            for (Object obj : cls.getEnumConstants()) {
                i = Math.max(((Enum) obj).name().length(), i);
            }
            AppMethodBeat.m2505o(77453);
            return i;
        }
        AppMethodBeat.m2505o(77453);
        return 0;
    }

    /* renamed from: f */
    static <T extends Enum> T m54899f(String str, Class<T> cls) {
        AppMethodBeat.m2504i(77454);
        int am = C33626d.m54897am(cls);
        if (C5046bo.isNullOrNil(str) || str.length() > am) {
            AppMethodBeat.m2505o(77454);
            return null;
        }
        String toUpperCase = str.toUpperCase();
        for (Enum enumR : (Enum[]) cls.getEnumConstants()) {
            Enum enumR2;
            if (toUpperCase.equals(enumR2.name())) {
                enumR2 = enumR2;
                AppMethodBeat.m2505o(77454);
                return enumR2;
            }
        }
        AppMethodBeat.m2505o(77454);
        return null;
    }

    /* renamed from: bv */
    public static Integer m54898bv(Object obj) {
        AppMethodBeat.m2504i(77455);
        Integer num;
        if (obj == null) {
            AppMethodBeat.m2505o(77455);
            return null;
        } else if (obj instanceof Integer) {
            num = (Integer) obj;
            AppMethodBeat.m2505o(77455);
            return num;
        } else if (obj instanceof Number) {
            num = Integer.valueOf(((Number) obj).intValue());
            AppMethodBeat.m2505o(77455);
            return num;
        } else {
            if (obj instanceof String) {
                try {
                    num = Integer.valueOf((int) Double.parseDouble((String) obj));
                    AppMethodBeat.m2505o(77455);
                    return num;
                } catch (NumberFormatException e) {
                }
            }
            AppMethodBeat.m2505o(77455);
            return null;
        }
    }
}
