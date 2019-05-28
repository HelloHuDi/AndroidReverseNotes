package com.tencent.mm.plugin.appbrand.widget.desktop.a;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.ViewParent;
import com.tencent.mm.sdk.platformtools.ab;

public abstract class b<T extends v> implements c<T> {
    public static float Q(v vVar) {
        if (vVar == null || vVar.apJ == null) {
            return 0.0f;
        }
        int[] iArr = new int[2];
        vVar.apJ.getLocationOnScreen(iArr);
        return (float) iArr[1];
    }

    public static float c(RecyclerView recyclerView, v vVar) {
        if (vVar != null) {
            try {
                if (vVar.apJ != null) {
                    float left = (float) vVar.apJ.getLeft();
                    View view = vVar.apJ;
                    ViewParent parent = view.getParent();
                    if (parent instanceof View) {
                        view = (View) parent;
                        left += (float) view.getLeft();
                    }
                    while (view != recyclerView && parent != null) {
                        parent = view.getParent();
                        if (parent instanceof View) {
                            view = (View) parent;
                            left += (float) view.getLeft();
                        }
                    }
                    return left;
                }
            } catch (Exception e) {
                ab.printErrStackTrace("alvinluo", e, "alvinluo getTransX exception", new Object[0]);
                return 0.0f;
            }
        }
        return 0.0f;
    }
}
