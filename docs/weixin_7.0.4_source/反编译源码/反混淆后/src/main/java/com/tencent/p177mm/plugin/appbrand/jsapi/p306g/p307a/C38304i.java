package com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.widget.p1235e.C42724b;
import com.tencent.p177mm.plugin.appbrand.widget.p1235e.C45715d;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.a.i */
public final class C38304i {
    private static LinkedList<View> hOL = new LinkedList();
    private static LinkedList<C45715d> hOM = new LinkedList();
    private static LinkedList<C42724b> hON = new LinkedList();

    static {
        AppMethodBeat.m2504i(51243);
        AppMethodBeat.m2505o(51243);
    }

    public static C42724b aEe() {
        C42724b c42724b;
        AppMethodBeat.m2504i(51238);
        synchronized (hON) {
            try {
                if (hON.size() <= 0) {
                    c42724b = null;
                } else {
                    c42724b = (C42724b) hON.removeFirst();
                    C38304i.m64821cm(c42724b);
                    AppMethodBeat.m2505o(51238);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(51238);
            }
        }
        return c42724b;
    }

    /* renamed from: a */
    public static boolean m64819a(C42724b c42724b) {
        boolean z;
        AppMethodBeat.m2504i(51239);
        synchronized (hON) {
            try {
                if (hON.size() > 0) {
                    z = false;
                } else {
                    hON.push(c42724b);
                    z = true;
                    AppMethodBeat.m2505o(51239);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(51239);
            }
        }
        return z;
    }

    public static C45715d aEf() {
        C45715d c45715d;
        AppMethodBeat.m2504i(51240);
        synchronized (hOM) {
            try {
                if (hOM.size() <= 0) {
                    c45715d = null;
                } else {
                    c45715d = (C45715d) hOM.removeFirst();
                    C38304i.m64821cm(c45715d);
                    AppMethodBeat.m2505o(51240);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(51240);
            }
        }
        return c45715d;
    }

    /* renamed from: a */
    public static boolean m64820a(C45715d c45715d) {
        boolean z;
        AppMethodBeat.m2504i(51241);
        synchronized (hOM) {
            try {
                if (hOM.size() > 0) {
                    z = false;
                } else {
                    hOM.push(c45715d);
                    z = true;
                    AppMethodBeat.m2505o(51241);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(51241);
            }
        }
        return z;
    }

    /* renamed from: cm */
    private static void m64821cm(View view) {
        AppMethodBeat.m2504i(51242);
        if (view == null) {
            AppMethodBeat.m2505o(51242);
        } else if (ViewGroup.class.isInstance(view.getParent())) {
            ((ViewGroup) view.getParent()).removeView(view);
            AppMethodBeat.m2505o(51242);
        } else {
            AppMethodBeat.m2505o(51242);
        }
    }
}
