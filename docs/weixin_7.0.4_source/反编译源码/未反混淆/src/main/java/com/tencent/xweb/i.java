package com.tencent.xweb;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView.d;
import com.tencent.xweb.c.f;
import org.xwalk.core.XWalkEnvironment;

public final class i {
    public static a AMa;
    private static String AMc = "";
    public f AMb;
    public volatile boolean iff;

    public enum a {
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
            AppMethodBeat.o(3810);
        }
    }

    public static a dTU() {
        return AMa;
    }

    public static String dTV() {
        return AMc;
    }

    public static a a(a aVar, String str, Context context) {
        AppMethodBeat.i(3811);
        m.jy(context);
        if (m.dTZ().AMA != a.RT_TYPE_AUTO) {
            aVar = m.dTZ().AMA;
            XWalkEnvironment.addXWalkInitializeLog("XWeb", "use hardcode jscore type = ".concat(String.valueOf(aVar)));
        } else if (a.auV(str) != a.RT_TYPE_AUTO) {
            aVar = a.auV(str);
            XWalkEnvironment.addXWalkInitializeLog("XWeb", "module " + str + "use cmd jscore type = " + aVar);
        }
        if (WebView.getCurWebType() == d.WV_KIND_X5) {
            if (!(a.RT_TYPE_SYS == aVar || a.RT_TYPE_X5 == aVar)) {
                aVar = a.RT_TYPE_MMV8;
            }
        } else if (WebView.getCurWebType() == d.WV_KIND_CW) {
            if (!(a.RT_TYPE_NATIVE_SCRIPT == aVar || a.RT_TYPE_J2V8 == aVar || a.RT_TYPE_SYS == aVar)) {
                aVar = a.RT_TYPE_MMV8;
            }
        } else if (WebView.getCurWebType() == d.WV_KIND_SYS && a.RT_TYPE_SYS != aVar) {
            aVar = a.RT_TYPE_MMV8;
        }
        AppMethodBeat.o(3811);
        return aVar;
    }

    public final boolean dTW() {
        AppMethodBeat.i(3812);
        boolean dTW = this.AMb.dTW();
        AppMethodBeat.o(3812);
        return dTW;
    }
}
