package com.tencent.mm.plugin.appbrand.widget.input.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public final class d {
    private static int am(Class cls) {
        AppMethodBeat.i(77453);
        if (cls.isEnum()) {
            int i = 0;
            for (Object obj : cls.getEnumConstants()) {
                i = Math.max(((Enum) obj).name().length(), i);
            }
            AppMethodBeat.o(77453);
            return i;
        }
        AppMethodBeat.o(77453);
        return 0;
    }

    static <T extends Enum> T f(String str, Class<T> cls) {
        AppMethodBeat.i(77454);
        int am = am(cls);
        if (bo.isNullOrNil(str) || str.length() > am) {
            AppMethodBeat.o(77454);
            return null;
        }
        String toUpperCase = str.toUpperCase();
        for (Enum enumR : (Enum[]) cls.getEnumConstants()) {
            Enum enumR2;
            if (toUpperCase.equals(enumR2.name())) {
                enumR2 = enumR2;
                AppMethodBeat.o(77454);
                return enumR2;
            }
        }
        AppMethodBeat.o(77454);
        return null;
    }

    public static Integer bv(Object obj) {
        AppMethodBeat.i(77455);
        Integer num;
        if (obj == null) {
            AppMethodBeat.o(77455);
            return null;
        } else if (obj instanceof Integer) {
            num = (Integer) obj;
            AppMethodBeat.o(77455);
            return num;
        } else if (obj instanceof Number) {
            num = Integer.valueOf(((Number) obj).intValue());
            AppMethodBeat.o(77455);
            return num;
        } else {
            if (obj instanceof String) {
                try {
                    num = Integer.valueOf((int) Double.parseDouble((String) obj));
                    AppMethodBeat.o(77455);
                    return num;
                } catch (NumberFormatException e) {
                }
            }
            AppMethodBeat.o(77455);
            return null;
        }
    }
}
