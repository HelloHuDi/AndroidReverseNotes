package com.tencent.p177mm.plugin.welab.p1072a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.welab.p1072a.p1073a.C14714c;
import com.tencent.p177mm.plugin.welab.p1563e.C46450b;
import com.tencent.p177mm.plugin.welab.p584ui.WelabMainUI;

/* renamed from: com.tencent.mm.plugin.welab.a.c */
public final class C17001c implements C14714c {
    /* renamed from: D */
    public final void mo26978D(Context context, Intent intent) {
        AppMethodBeat.m2504i(80572);
        intent.setClass(context, WelabMainUI.class);
        String str = "para_from_with_red_point";
        int i = (ddn() || ddo()) ? 1 : 0;
        intent.putExtra(str, i);
        context.startActivity(intent);
        AppMethodBeat.m2505o(80572);
    }

    public final boolean ddn() {
        AppMethodBeat.m2504i(80573);
        C46450b.ddC();
        if (!C46450b.ddE() || ddo()) {
            AppMethodBeat.m2505o(80573);
            return false;
        }
        AppMethodBeat.m2505o(80573);
        return true;
    }

    public final boolean ddo() {
        AppMethodBeat.m2504i(80574);
        C46450b.ddC();
        if (!C46450b.ddF()) {
            C46450b.ddC();
            if (C46450b.ddE()) {
                AppMethodBeat.m2505o(80574);
                return true;
            }
        }
        AppMethodBeat.m2505o(80574);
        return false;
    }

    public final boolean ddp() {
        AppMethodBeat.m2504i(80575);
        if (ddo()) {
            AppMethodBeat.m2505o(80575);
            return false;
        }
        AppMethodBeat.m2505o(80575);
        return true;
    }
}
