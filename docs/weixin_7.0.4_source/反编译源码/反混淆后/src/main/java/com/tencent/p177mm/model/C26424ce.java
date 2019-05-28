package com.tencent.p177mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.model.ce */
public final class C26424ce {
    public static int getInt(Object obj, int i) {
        AppMethodBeat.m2504i(77827);
        if (obj instanceof Integer) {
            try {
                i = ((Integer) obj).intValue();
                AppMethodBeat.m2505o(77827);
            } catch (Exception e) {
            }
            return i;
        }
        AppMethodBeat.m2505o(77827);
        return i;
    }

    /* renamed from: e */
    public static String m42081e(Object obj, String str) {
        if (obj instanceof String) {
            try {
                return (String) obj;
            } catch (Exception e) {
            }
        }
        return str;
    }

    /* renamed from: bc */
    public static boolean m42080bc(Object obj) {
        AppMethodBeat.m2504i(77828);
        if (obj instanceof Boolean) {
            try {
                boolean booleanValue = ((Boolean) obj).booleanValue();
                AppMethodBeat.m2505o(77828);
                return booleanValue;
            } catch (Exception e) {
            }
        }
        AppMethodBeat.m2505o(77828);
        return false;
    }
}
