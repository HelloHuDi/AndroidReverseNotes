package com.tencent.p177mm.p612ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.chatting.C44315r;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.viewitems.C5394d.C5404f;

/* renamed from: com.tencent.mm.ui.x */
public final class C44406x implements OnClickListener {
    C46650a yod;

    public C44406x(C46650a c46650a) {
        this.yod = c46650a;
    }

    public final void onClick(View view) {
        AppMethodBeat.m2504i(29683);
        if (view.getTag() instanceof C5404f) {
            C44315r.m80106eK(view);
            this.yod.aWv();
        }
        AppMethodBeat.m2505o(29683);
    }
}
