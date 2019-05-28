package com.tencent.p177mm.plugin.appbrand.menu;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C38369p;
import com.tencent.p177mm.plugin.appbrand.menu.p909a.C10642a;
import com.tencent.p177mm.plugin.appbrand.page.C27242w;

@Deprecated
/* renamed from: com.tencent.mm.plugin.appbrand.menu.k */
public final class C27208k extends C10642a<C27242w> {

    /* renamed from: com.tencent.mm.plugin.appbrand.menu.k$a */
    public static final class C27207a extends C38369p {
        private static final int CTRL_INDEX = 76;
        public static final String NAME = "onMenuShareTimeline";
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.menu.k$1 */
    static class C272091 implements OnClickListener {
        C272091() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(132245);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(132245);
        }
    }

    C27208k() {
        super(C38449o.ShareToTimeLine.ordinal());
        AppMethodBeat.m2504i(132246);
        AppMethodBeat.m2505o(132246);
    }
}
