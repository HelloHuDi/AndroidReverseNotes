package com.tencent.p177mm.p612ui.widget.sortlist;

import android.content.Context;
import android.view.View;
import android.widget.Checkable;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.ui.widget.sortlist.c */
public final class C40912c extends C46703b implements Checkable {
    public C40912c(Context context) {
        super(context);
    }

    public final boolean isChecked() {
        AppMethodBeat.m2504i(113021);
        View childAt = getChildAt(0);
        if (childAt instanceof Checkable) {
            boolean isChecked = ((Checkable) childAt).isChecked();
            AppMethodBeat.m2505o(113021);
            return isChecked;
        }
        AppMethodBeat.m2505o(113021);
        return false;
    }

    public final void setChecked(boolean z) {
        AppMethodBeat.m2504i(113022);
        View childAt = getChildAt(0);
        if (childAt instanceof Checkable) {
            ((Checkable) childAt).setChecked(z);
        }
        AppMethodBeat.m2505o(113022);
    }

    public final void toggle() {
        AppMethodBeat.m2504i(113023);
        View childAt = getChildAt(0);
        if (childAt instanceof Checkable) {
            ((Checkable) childAt).toggle();
        }
        AppMethodBeat.m2505o(113023);
    }
}
