package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.util.SparseArray;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public final class g {
    public static final int uUv = R.layout.aj8;
    public static final int uUw = R.layout.aj7;
    public static final int uUx = R.layout.aj5;
    public SparseArray<Integer> uUy = new SparseArray();

    public g() {
        AppMethodBeat.i(27161);
        this.uUy.put(1, Integer.valueOf(uUv));
        this.uUy.put(2, Integer.valueOf(uUw));
        this.uUy.put(4, Integer.valueOf(uUw));
        this.uUy.put(3, Integer.valueOf(uUw));
        this.uUy.put(5, Integer.valueOf(uUw));
        this.uUy.put(6, Integer.valueOf(uUw));
        this.uUy.put(0, Integer.valueOf(uUw));
        this.uUy.put(-1, Integer.valueOf(uUw));
        this.uUy.put(-3, Integer.valueOf(uUx));
        this.uUy.put(-2, Integer.valueOf(uUw));
        this.uUy.put(-4, Integer.valueOf(uUw));
        this.uUy.put(20, Integer.valueOf(uUw));
        AppMethodBeat.o(27161);
    }

    public static a a(int i, View view, k kVar) {
        AppMethodBeat.i(27162);
        a jVar;
        switch (i) {
            case -4:
                jVar = new j(view, kVar);
                AppMethodBeat.o(27162);
                return jVar;
            case -3:
                jVar = new e(view, kVar);
                AppMethodBeat.o(27162);
                return jVar;
            case -2:
                jVar = new b(view, kVar);
                AppMethodBeat.o(27162);
                return jVar;
            case -1:
                jVar = new k(view, kVar);
                AppMethodBeat.o(27162);
                return jVar;
            case 0:
                jVar = new m(view, kVar);
                AppMethodBeat.o(27162);
                return jVar;
            case 1:
                jVar = new l(view, kVar);
                AppMethodBeat.o(27162);
                return jVar;
            case 2:
                jVar = new f(view, kVar);
                AppMethodBeat.o(27162);
                return jVar;
            case 3:
                jVar = new h(view, kVar);
                AppMethodBeat.o(27162);
                return jVar;
            case 4:
                jVar = new o(view, kVar);
                AppMethodBeat.o(27162);
                return jVar;
            case 5:
                jVar = new d(view, kVar);
                AppMethodBeat.o(27162);
                return jVar;
            case 6:
                jVar = new n(view, kVar);
                AppMethodBeat.o(27162);
                return jVar;
            case 20:
                jVar = new c(view, kVar);
                AppMethodBeat.o(27162);
                return jVar;
            default:
                AppMethodBeat.o(27162);
                return null;
        }
    }
}
