package com.tencent.p177mm.plugin.appbrand.widget.desktop.p338a;

import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.view.View;
import android.view.ViewParent;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.a.b */
public abstract class C33601b<T extends C41531v> implements C38576c<T> {
    /* renamed from: Q */
    public static float m54876Q(C41531v c41531v) {
        if (c41531v == null || c41531v.apJ == null) {
            return 0.0f;
        }
        int[] iArr = new int[2];
        c41531v.apJ.getLocationOnScreen(iArr);
        return (float) iArr[1];
    }

    /* renamed from: c */
    public static float m54877c(RecyclerView recyclerView, C41531v c41531v) {
        if (c41531v != null) {
            try {
                if (c41531v.apJ != null) {
                    float left = (float) c41531v.apJ.getLeft();
                    View view = c41531v.apJ;
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
                C4990ab.printErrStackTrace("alvinluo", e, "alvinluo getTransX exception", new Object[0]);
                return 0.0f;
            }
        }
        return 0.0f;
    }
}
