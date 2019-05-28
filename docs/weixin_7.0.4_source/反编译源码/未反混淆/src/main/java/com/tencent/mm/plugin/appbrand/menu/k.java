package com.tencent.mm.plugin.appbrand.menu;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.w;

@Deprecated
public final class k extends com.tencent.mm.plugin.appbrand.menu.a.a<w> {

    public static final class a extends p {
        private static final int CTRL_INDEX = 76;
        public static final String NAME = "onMenuShareTimeline";
    }

    k() {
        super(o.ShareToTimeLine.ordinal());
        AppMethodBeat.i(132246);
        AppMethodBeat.o(132246);
    }
}
