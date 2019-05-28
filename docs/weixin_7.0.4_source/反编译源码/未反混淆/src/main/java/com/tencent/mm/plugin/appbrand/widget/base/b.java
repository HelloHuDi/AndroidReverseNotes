package com.tencent.mm.plugin.appbrand.widget.base;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

public final class b implements Iterator<View> {
    private int counter = 0;
    private final ViewGroup eAl;

    public b(ViewGroup viewGroup) {
        this.eAl = viewGroup;
    }

    public final boolean hasNext() {
        AppMethodBeat.i(77397);
        if (this.counter < this.eAl.getChildCount()) {
            AppMethodBeat.o(77397);
            return true;
        }
        AppMethodBeat.o(77397);
        return false;
    }

    public final void remove() {
        AppMethodBeat.i(77398);
        this.eAl.removeViewAt(this.counter - 1);
        AppMethodBeat.o(77398);
    }

    public final /* synthetic */ Object next() {
        AppMethodBeat.i(77399);
        ViewGroup viewGroup = this.eAl;
        int i = this.counter;
        this.counter = i + 1;
        View childAt = viewGroup.getChildAt(i);
        AppMethodBeat.o(77399);
        return childAt;
    }
}
