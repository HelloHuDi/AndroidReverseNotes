package com.tencent.xweb;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView.C44570d;
import com.tencent.xweb.p1115c.C24525f;
import org.xwalk.core.XWalkEnvironment;

/* renamed from: com.tencent.xweb.i */
public final class C41128i {
    public static C36587a AMa;
    private static String AMc = "";
    public C24525f AMb;
    public volatile boolean iff;

    /* renamed from: com.tencent.xweb.i$a */
    public enum C36587a {
        RT_TYPE_AUTO,
        RT_TYPE_SYS,
        RT_TYPE_XWALK,
        RT_TYPE_WEB_X5,
        RT_TYPE_DUMMY,
        RT_TYPE_X5,
        RT_TYPE_J2V8,
        RT_TYPE_NATIVE_SCRIPT,
        RT_TYPE_MMV8;

        static {
            AppMethodBeat.m2505o(3810);
        }
    }

    public static C36587a dTU() {
        return AMa;
    }

    public static String dTV() {
        return AMc;
    }

    /* renamed from: a */
    public static C36587a m71556a(C36587a c36587a, String str, Context context) {
        AppMethodBeat.m2504i(3811);
        C31146m.m50231jy(context);
        if (C31146m.dTZ().AMA != C36587a.RT_TYPE_AUTO) {
            c36587a = C31146m.dTZ().AMA;
            XWalkEnvironment.addXWalkInitializeLog("XWeb", "use hardcode jscore type = ".concat(String.valueOf(c36587a)));
        } else if (C44572a.auV(str) != C36587a.RT_TYPE_AUTO) {
            c36587a = C44572a.auV(str);
            XWalkEnvironment.addXWalkInitializeLog("XWeb", "module " + str + "use cmd jscore type = " + c36587a);
        }
        if (WebView.getCurWebType() == C44570d.WV_KIND_X5) {
            if (!(C36587a.RT_TYPE_SYS == c36587a || C36587a.RT_TYPE_X5 == c36587a)) {
                c36587a = C36587a.RT_TYPE_MMV8;
            }
        } else if (WebView.getCurWebType() == C44570d.WV_KIND_CW) {
            if (!(C36587a.RT_TYPE_NATIVE_SCRIPT == c36587a || C36587a.RT_TYPE_J2V8 == c36587a || C36587a.RT_TYPE_SYS == c36587a)) {
                c36587a = C36587a.RT_TYPE_MMV8;
            }
        } else if (WebView.getCurWebType() == C44570d.WV_KIND_SYS && C36587a.RT_TYPE_SYS != c36587a) {
            c36587a = C36587a.RT_TYPE_MMV8;
        }
        AppMethodBeat.m2505o(3811);
        return c36587a;
    }

    public final boolean dTW() {
        AppMethodBeat.m2504i(3812);
        boolean dTW = this.AMb.dTW();
        AppMethodBeat.m2505o(3812);
        return dTW;
    }
}
