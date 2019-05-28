package com.tencent.p177mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C38369p;
import com.tencent.p177mm.plugin.appbrand.p281b.C45524b;

/* renamed from: com.tencent.mm.plugin.appbrand.page.j */
public final class C42647j extends C38369p {
    private static final int CTRL_INDEX = -2;
    private static final String NAME = "onAppRunningStatusChange";

    /* renamed from: com.tencent.mm.plugin.appbrand.page.j$1 */
    public static /* synthetic */ class C426461 {
        public static final /* synthetic */ int[] gWN = new int[C45524b.values().length];

        static {
            AppMethodBeat.m2504i(87066);
            try {
                gWN[C45524b.BACKGROUND.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                gWN[C45524b.FOREGROUND.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                gWN[C45524b.SUSPEND.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                gWN[C45524b.DESTROYED.ordinal()] = 4;
                AppMethodBeat.m2505o(87066);
            } catch (NoSuchFieldError e4) {
                AppMethodBeat.m2505o(87066);
            }
        }
    }
}
