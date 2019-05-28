package com.tencent.util;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.b;
import java.util.HashMap;

public final class i {
    public static boolean AIi = false;
    private static HashMap<String, Long> AIj = new HashMap();
    private static h AIk = null;

    static {
        AppMethodBeat.i(86621);
        AppMethodBeat.o(86621);
    }

    private static String dg(Object obj) {
        AppMethodBeat.i(86615);
        String str;
        if (obj == null) {
            str = "filter process";
            AppMethodBeat.o(86615);
            return str;
        } else if (obj instanceof String) {
            str = (String) obj;
            AppMethodBeat.o(86615);
            return str;
        } else {
            str = obj.getClass().getSimpleName();
            AppMethodBeat.o(86615);
            return str;
        }
    }

    public static int j(Object obj, String str) {
        AppMethodBeat.i(86616);
        if (b.AIF) {
            String dg = dg(obj);
            if (AIk != null) {
                AppMethodBeat.o(86616);
                return 0;
            } else if (b.AIF) {
                int i = Log.i(dg, str);
                AppMethodBeat.o(86616);
                return i;
            }
        }
        AppMethodBeat.o(86616);
        return 0;
    }

    public static int k(Object obj, String str) {
        AppMethodBeat.i(86617);
        if (b.AIF) {
            String dg = dg(obj);
            if (AIk != null) {
                AppMethodBeat.o(86617);
                return 0;
            } else if (b.AIF) {
                int d = Log.d(dg, str);
                AppMethodBeat.o(86617);
                return d;
            }
        }
        AppMethodBeat.o(86617);
        return 0;
    }

    public static int l(Object obj, String str) {
        AppMethodBeat.i(86618);
        if (b.AIJ) {
            String dg = dg(obj);
            if (AIk != null) {
                AppMethodBeat.o(86618);
                return 0;
            } else if (b.AIF) {
                int d = Log.d(dg, str);
                AppMethodBeat.o(86618);
                return d;
            }
        }
        AppMethodBeat.o(86618);
        return 0;
    }

    public static int m(Object obj, String str) {
        AppMethodBeat.i(86619);
        if (b.AIF) {
            String dg = dg(obj);
            if (AIk != null) {
                AppMethodBeat.o(86619);
                return 0;
            } else if (b.AIF) {
                int e = Log.e(dg, str);
                AppMethodBeat.o(86619);
                return e;
            }
        }
        AppMethodBeat.o(86619);
        return 0;
    }

    public static int a(Object obj, String str, Throwable th) {
        AppMethodBeat.i(86620);
        if (b.AIF) {
            String dg = dg(obj);
            if (AIk != null) {
                AppMethodBeat.o(86620);
                return 0;
            } else if (b.AIF) {
                int e = Log.e(dg, str, th);
                AppMethodBeat.o(86620);
                return e;
            }
        }
        AppMethodBeat.o(86620);
        return 0;
    }
}
