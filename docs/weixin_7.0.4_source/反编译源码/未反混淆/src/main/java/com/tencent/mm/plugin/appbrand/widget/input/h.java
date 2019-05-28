package com.tencent.mm.plugin.appbrand.widget.input;

import android.util.SparseIntArray;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.aj;

public final class h {
    private static final h jdJ = new h();
    private final a jdI = new a();

    static final class a {
        final SparseIntArray jdK;

        private a() {
            AppMethodBeat.i(123619);
            this.jdK = new SparseIntArray();
            AppMethodBeat.o(123619);
        }

        /* synthetic */ a(byte b) {
            this();
        }

        /* Access modifiers changed, original: final */
        public final int e(aj ajVar) {
            AppMethodBeat.i(123620);
            int i = this.jdK.get(ajVar.hashCode(), 0);
            AppMethodBeat.o(123620);
            return i;
        }

        /* Access modifiers changed, original: final */
        public final void a(aj ajVar, int i) {
            AppMethodBeat.i(123621);
            this.jdK.put(ajVar.hashCode(), i);
            AppMethodBeat.o(123621);
        }
    }

    public h() {
        AppMethodBeat.i(123622);
        AppMethodBeat.o(123622);
    }

    static {
        AppMethodBeat.i(123626);
        AppMethodBeat.o(123626);
    }

    public static h aQx() {
        return jdJ;
    }

    /* Access modifiers changed, original: final */
    public final void b(aj ajVar) {
        AppMethodBeat.i(123623);
        if (ajVar == null) {
            AppMethodBeat.o(123623);
            return;
        }
        this.jdI.jdK.delete(ajVar.hashCode());
        try {
            ajVar.getWrapperView().setFocusable(true);
            ajVar.getWrapperView().setFocusableInTouchMode(true);
            ajVar.getContentView().setFocusable(true);
            ajVar.getContentView().setFocusableInTouchMode(true);
            AppMethodBeat.o(123623);
        } catch (NullPointerException e) {
            AppMethodBeat.o(123623);
        }
    }

    public final void c(aj ajVar) {
        AppMethodBeat.i(123624);
        if (ajVar == null) {
            AppMethodBeat.o(123624);
            return;
        }
        this.jdI.a(ajVar, this.jdI.e(ajVar) + 1);
        try {
            ajVar.getWrapperView().setFocusable(false);
            ajVar.getWrapperView().setFocusableInTouchMode(false);
            ajVar.getContentView().setFocusable(false);
            ajVar.getContentView().setFocusableInTouchMode(false);
            if (ajVar.getWrapperView() instanceof ViewGroup) {
                ((ViewGroup) ajVar.getWrapperView()).setDescendantFocusability(393216);
            }
            AppMethodBeat.o(123624);
        } catch (NullPointerException e) {
            AppMethodBeat.o(123624);
        }
    }

    public final void d(aj ajVar) {
        AppMethodBeat.i(123625);
        if (ajVar == null) {
            AppMethodBeat.o(123625);
            return;
        }
        int e = this.jdI.e(ajVar) - 1;
        if (e <= 0) {
            b(ajVar);
            AppMethodBeat.o(123625);
            return;
        }
        this.jdI.a(ajVar, e);
        AppMethodBeat.o(123625);
    }
}
