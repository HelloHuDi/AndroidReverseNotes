package com.tencent.p177mm.p612ui.statusbar;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.ui.statusbar.a */
public final class C5540a {
    /* renamed from: fm */
    private static C7355b m8361fm(View view) {
        AppMethodBeat.m2504i(67828);
        if (view == null) {
            AppMethodBeat.m2505o(67828);
            return null;
        }
        View view2 = view;
        while (!(view2 instanceof C7355b)) {
            ViewParent parent = view2.getParent();
            if (parent == null || !(parent instanceof ViewGroup)) {
                AppMethodBeat.m2505o(67828);
                return null;
            }
            view2 = (View) parent;
        }
        C7355b c7355b = (C7355b) view2;
        AppMethodBeat.m2505o(67828);
        return c7355b;
    }

    /* renamed from: d */
    public static void m8360d(View view, int i, boolean z) {
        AppMethodBeat.m2504i(67829);
        if (view == null) {
            AppMethodBeat.m2505o(67829);
        } else if (C5544c.zzP) {
            C7355b fm = C5540a.m8361fm(view);
            if (fm != null) {
                fm.mo15851K(i, z);
                AppMethodBeat.m2505o(67829);
                return;
            }
            Activity cY = C5546d.m8371cY(view.getContext());
            if (cY != null) {
                cY.getWindow().setStatusBarColor(i);
                C5546d.m8369a(cY.getWindow(), z);
            }
            AppMethodBeat.m2505o(67829);
        } else {
            AppMethodBeat.m2505o(67829);
        }
    }

    /* renamed from: D */
    public static void m8358D(View view, boolean z) {
        AppMethodBeat.m2504i(67830);
        C7355b fm = C5540a.m8361fm(view);
        if (fm != null) {
            fm.mo15854qM(z);
        }
        AppMethodBeat.m2505o(67830);
    }

    /* renamed from: ay */
    public static int m8359ay(Activity activity) {
        AppMethodBeat.m2504i(67831);
        if (!C5544c.zzP) {
            AppMethodBeat.m2505o(67831);
            return 0;
        } else if (activity == null) {
            AppMethodBeat.m2505o(67831);
            return 0;
        } else {
            int i = C5544c.m8364az(activity).zzS;
            AppMethodBeat.m2505o(67831);
            return i;
        }
    }
}
