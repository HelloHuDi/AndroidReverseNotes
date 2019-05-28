package com.tencent.mm.plugin.appbrand.widget.j;

import a.l;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¨\u0006\u0004"}, dWq = {"traverseFixAccessibility", "", "parent", "Landroid/view/ViewGroup;", "plugin-appbrand-integration_release"})
public final class a {
    public static final void k(ViewGroup viewGroup) {
        AppMethodBeat.i(135269);
        if (viewGroup == null) {
            AppMethodBeat.o(135269);
            return;
        }
        int i = 0;
        int childCount = viewGroup.getChildCount();
        if (childCount >= 0) {
            while (true) {
                int i2 = i;
                View childAt = viewGroup.getChildAt(i2);
                if (childAt instanceof ViewGroup) {
                    k((ViewGroup) childAt);
                } else if (childAt instanceof RecyclerView) {
                    childAt.setAccessibilityDelegate(null);
                }
                if (i2 == childCount) {
                    break;
                }
                i = i2 + 1;
            }
        }
        AppMethodBeat.o(135269);
    }
}
