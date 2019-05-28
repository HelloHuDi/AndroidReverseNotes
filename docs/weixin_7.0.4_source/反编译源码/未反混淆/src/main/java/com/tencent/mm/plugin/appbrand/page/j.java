package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.p;

public final class j extends p {
    private static final int CTRL_INDEX = -2;
    private static final String NAME = "onAppRunningStatusChange";

    /* renamed from: com.tencent.mm.plugin.appbrand.page.j$1 */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] gWN = new int[b.values().length];

        static {
            AppMethodBeat.i(87066);
            try {
                gWN[b.BACKGROUND.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                gWN[b.FOREGROUND.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                gWN[b.SUSPEND.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                gWN[b.DESTROYED.ordinal()] = 4;
                AppMethodBeat.o(87066);
            } catch (NoSuchFieldError e4) {
                AppMethodBeat.o(87066);
            }
        }
    }
}
