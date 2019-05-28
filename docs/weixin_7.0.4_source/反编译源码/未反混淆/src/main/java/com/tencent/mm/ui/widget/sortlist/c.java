package com.tencent.mm.ui.widget.sortlist;

import android.content.Context;
import android.view.View;
import android.widget.Checkable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c extends b implements Checkable {
    public c(Context context) {
        super(context);
    }

    public final boolean isChecked() {
        AppMethodBeat.i(113021);
        View childAt = getChildAt(0);
        if (childAt instanceof Checkable) {
            boolean isChecked = ((Checkable) childAt).isChecked();
            AppMethodBeat.o(113021);
            return isChecked;
        }
        AppMethodBeat.o(113021);
        return false;
    }

    public final void setChecked(boolean z) {
        AppMethodBeat.i(113022);
        View childAt = getChildAt(0);
        if (childAt instanceof Checkable) {
            ((Checkable) childAt).setChecked(z);
        }
        AppMethodBeat.o(113022);
    }

    public final void toggle() {
        AppMethodBeat.i(113023);
        View childAt = getChildAt(0);
        if (childAt instanceof Checkable) {
            ((Checkable) childAt).toggle();
        }
        AppMethodBeat.o(113023);
    }
}
