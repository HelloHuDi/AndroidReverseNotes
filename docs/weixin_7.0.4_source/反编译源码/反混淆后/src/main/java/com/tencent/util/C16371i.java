package com.tencent.util;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.C44569b;
import java.util.HashMap;

/* renamed from: com.tencent.util.i */
public final class C16371i {
    public static boolean AIi = false;
    private static HashMap<String, Long> AIj = new HashMap();
    private static C16370h AIk = null;

    static {
        AppMethodBeat.m2504i(86621);
        AppMethodBeat.m2505o(86621);
    }

    /* renamed from: dg */
    private static String m25184dg(Object obj) {
        AppMethodBeat.m2504i(86615);
        String str;
        if (obj == null) {
            str = "filter process";
            AppMethodBeat.m2505o(86615);
            return str;
        } else if (obj instanceof String) {
            str = (String) obj;
            AppMethodBeat.m2505o(86615);
            return str;
        } else {
            str = obj.getClass().getSimpleName();
            AppMethodBeat.m2505o(86615);
            return str;
        }
    }

    /* renamed from: j */
    public static int m25185j(Object obj, String str) {
        AppMethodBeat.m2504i(86616);
        if (C44569b.AIF) {
            String dg = C16371i.m25184dg(obj);
            if (AIk != null) {
                AppMethodBeat.m2505o(86616);
                return 0;
            } else if (C44569b.AIF) {
                int i = Log.i(dg, str);
                AppMethodBeat.m2505o(86616);
                return i;
            }
        }
        AppMethodBeat.m2505o(86616);
        return 0;
    }

    /* renamed from: k */
    public static int m25186k(Object obj, String str) {
        AppMethodBeat.m2504i(86617);
        if (C44569b.AIF) {
            String dg = C16371i.m25184dg(obj);
            if (AIk != null) {
                AppMethodBeat.m2505o(86617);
                return 0;
            } else if (C44569b.AIF) {
                int d = Log.d(dg, str);
                AppMethodBeat.m2505o(86617);
                return d;
            }
        }
        AppMethodBeat.m2505o(86617);
        return 0;
    }

    /* renamed from: l */
    public static int m25187l(Object obj, String str) {
        AppMethodBeat.m2504i(86618);
        if (C44569b.AIJ) {
            String dg = C16371i.m25184dg(obj);
            if (AIk != null) {
                AppMethodBeat.m2505o(86618);
                return 0;
            } else if (C44569b.AIF) {
                int d = Log.d(dg, str);
                AppMethodBeat.m2505o(86618);
                return d;
            }
        }
        AppMethodBeat.m2505o(86618);
        return 0;
    }

    /* renamed from: m */
    public static int m25188m(Object obj, String str) {
        AppMethodBeat.m2504i(86619);
        if (C44569b.AIF) {
            String dg = C16371i.m25184dg(obj);
            if (AIk != null) {
                AppMethodBeat.m2505o(86619);
                return 0;
            } else if (C44569b.AIF) {
                int e = Log.e(dg, str);
                AppMethodBeat.m2505o(86619);
                return e;
            }
        }
        AppMethodBeat.m2505o(86619);
        return 0;
    }

    /* renamed from: a */
    public static int m25183a(Object obj, String str, Throwable th) {
        AppMethodBeat.m2504i(86620);
        if (C44569b.AIF) {
            String dg = C16371i.m25184dg(obj);
            if (AIk != null) {
                AppMethodBeat.m2505o(86620);
                return 0;
            } else if (C44569b.AIF) {
                int e = Log.e(dg, str, th);
                AppMethodBeat.m2505o(86620);
                return e;
            }
        }
        AppMethodBeat.m2505o(86620);
        return 0;
    }
}
