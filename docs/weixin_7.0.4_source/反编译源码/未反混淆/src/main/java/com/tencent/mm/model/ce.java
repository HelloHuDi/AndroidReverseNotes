package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ce {
    public static int getInt(Object obj, int i) {
        AppMethodBeat.i(77827);
        if (obj instanceof Integer) {
            try {
                i = ((Integer) obj).intValue();
                AppMethodBeat.o(77827);
            } catch (Exception e) {
            }
            return i;
        }
        AppMethodBeat.o(77827);
        return i;
    }

    public static String e(Object obj, String str) {
        if (obj instanceof String) {
            try {
                return (String) obj;
            } catch (Exception e) {
            }
        }
        return str;
    }

    public static boolean bc(Object obj) {
        AppMethodBeat.i(77828);
        if (obj instanceof Boolean) {
            try {
                boolean booleanValue = ((Boolean) obj).booleanValue();
                AppMethodBeat.o(77828);
                return booleanValue;
            } catch (Exception e) {
            }
        }
        AppMethodBeat.o(77828);
        return false;
    }
}
