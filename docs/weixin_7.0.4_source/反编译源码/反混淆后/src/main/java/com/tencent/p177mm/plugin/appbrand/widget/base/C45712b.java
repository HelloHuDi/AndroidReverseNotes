package com.tencent.p177mm.plugin.appbrand.widget.base;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.base.b */
public final class C45712b implements Iterator<View> {
    private int counter = 0;
    private final ViewGroup eAl;

    public C45712b(ViewGroup viewGroup) {
        this.eAl = viewGroup;
    }

    public final boolean hasNext() {
        AppMethodBeat.m2504i(77397);
        if (this.counter < this.eAl.getChildCount()) {
            AppMethodBeat.m2505o(77397);
            return true;
        }
        AppMethodBeat.m2505o(77397);
        return false;
    }

    public final void remove() {
        AppMethodBeat.m2504i(77398);
        this.eAl.removeViewAt(this.counter - 1);
        AppMethodBeat.m2505o(77398);
    }

    public final /* synthetic */ Object next() {
        AppMethodBeat.m2504i(77399);
        ViewGroup viewGroup = this.eAl;
        int i = this.counter;
        this.counter = i + 1;
        View childAt = viewGroup.getChildAt(i);
        AppMethodBeat.m2505o(77399);
        return childAt;
    }
}
