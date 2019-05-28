package com.tencent.mm.plugin.appbrand.jsapi.g.a;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.e.b;
import com.tencent.mm.plugin.appbrand.widget.e.d;
import java.util.LinkedList;

public final class i {
    private static LinkedList<View> hOL = new LinkedList();
    private static LinkedList<d> hOM = new LinkedList();
    private static LinkedList<b> hON = new LinkedList();

    static {
        AppMethodBeat.i(51243);
        AppMethodBeat.o(51243);
    }

    public static b aEe() {
        b bVar;
        AppMethodBeat.i(51238);
        synchronized (hON) {
            try {
                if (hON.size() <= 0) {
                    bVar = null;
                } else {
                    bVar = (b) hON.removeFirst();
                    cm(bVar);
                    AppMethodBeat.o(51238);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(51238);
            }
        }
        return bVar;
    }

    public static boolean a(b bVar) {
        boolean z;
        AppMethodBeat.i(51239);
        synchronized (hON) {
            try {
                if (hON.size() > 0) {
                    z = false;
                } else {
                    hON.push(bVar);
                    z = true;
                    AppMethodBeat.o(51239);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(51239);
            }
        }
        return z;
    }

    public static d aEf() {
        d dVar;
        AppMethodBeat.i(51240);
        synchronized (hOM) {
            try {
                if (hOM.size() <= 0) {
                    dVar = null;
                } else {
                    dVar = (d) hOM.removeFirst();
                    cm(dVar);
                    AppMethodBeat.o(51240);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(51240);
            }
        }
        return dVar;
    }

    public static boolean a(d dVar) {
        boolean z;
        AppMethodBeat.i(51241);
        synchronized (hOM) {
            try {
                if (hOM.size() > 0) {
                    z = false;
                } else {
                    hOM.push(dVar);
                    z = true;
                    AppMethodBeat.o(51241);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(51241);
            }
        }
        return z;
    }

    private static void cm(View view) {
        AppMethodBeat.i(51242);
        if (view == null) {
            AppMethodBeat.o(51242);
        } else if (ViewGroup.class.isInstance(view.getParent())) {
            ((ViewGroup) view.getParent()).removeView(view);
            AppMethodBeat.o(51242);
        } else {
            AppMethodBeat.o(51242);
        }
    }
}
