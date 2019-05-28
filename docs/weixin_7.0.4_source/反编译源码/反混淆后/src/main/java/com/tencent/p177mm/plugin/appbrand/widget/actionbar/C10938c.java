package com.tencent.p177mm.plugin.appbrand.widget.actionbar;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.actionbar.c */
public final class C10938c {
    HashSet<OnClickListener> iUS = new HashSet();
    HashSet<OnClickListener> iUT = new HashSet();

    public C10938c() {
        AppMethodBeat.m2504i(87482);
        AppMethodBeat.m2505o(87482);
    }

    /* renamed from: cA */
    public final boolean mo22512cA(View view) {
        AppMethodBeat.m2504i(87483);
        if (this.iUT.isEmpty()) {
            AppMethodBeat.m2505o(87483);
            return false;
        }
        Iterator it = this.iUT.iterator();
        while (it.hasNext()) {
            ((OnClickListener) it.next()).onClick(view);
        }
        AppMethodBeat.m2505o(87483);
        return true;
    }
}
