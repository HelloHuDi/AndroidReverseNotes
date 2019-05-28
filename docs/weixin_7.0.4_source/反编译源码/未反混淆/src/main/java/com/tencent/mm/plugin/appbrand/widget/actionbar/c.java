package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Iterator;

public final class c {
    HashSet<OnClickListener> iUS = new HashSet();
    HashSet<OnClickListener> iUT = new HashSet();

    public c() {
        AppMethodBeat.i(87482);
        AppMethodBeat.o(87482);
    }

    public final boolean cA(View view) {
        AppMethodBeat.i(87483);
        if (this.iUT.isEmpty()) {
            AppMethodBeat.o(87483);
            return false;
        }
        Iterator it = this.iUT.iterator();
        while (it.hasNext()) {
            ((OnClickListener) it.next()).onClick(view);
        }
        AppMethodBeat.o(87483);
        return true;
    }
}
