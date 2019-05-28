package com.tencent.mm.ui.statusbar;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    private static b fm(View view) {
        AppMethodBeat.i(67828);
        if (view == null) {
            AppMethodBeat.o(67828);
            return null;
        }
        View view2 = view;
        while (!(view2 instanceof b)) {
            ViewParent parent = view2.getParent();
            if (parent == null || !(parent instanceof ViewGroup)) {
                AppMethodBeat.o(67828);
                return null;
            }
            view2 = (View) parent;
        }
        b bVar = (b) view2;
        AppMethodBeat.o(67828);
        return bVar;
    }

    public static void d(View view, int i, boolean z) {
        AppMethodBeat.i(67829);
        if (view == null) {
            AppMethodBeat.o(67829);
        } else if (c.zzP) {
            b fm = fm(view);
            if (fm != null) {
                fm.K(i, z);
                AppMethodBeat.o(67829);
                return;
            }
            Activity cY = d.cY(view.getContext());
            if (cY != null) {
                cY.getWindow().setStatusBarColor(i);
                d.a(cY.getWindow(), z);
            }
            AppMethodBeat.o(67829);
        } else {
            AppMethodBeat.o(67829);
        }
    }

    public static void D(View view, boolean z) {
        AppMethodBeat.i(67830);
        b fm = fm(view);
        if (fm != null) {
            fm.qM(z);
        }
        AppMethodBeat.o(67830);
    }

    public static int ay(Activity activity) {
        AppMethodBeat.i(67831);
        if (!c.zzP) {
            AppMethodBeat.o(67831);
            return 0;
        } else if (activity == null) {
            AppMethodBeat.o(67831);
            return 0;
        } else {
            int i = c.az(activity).zzS;
            AppMethodBeat.o(67831);
            return i;
        }
    }
}
