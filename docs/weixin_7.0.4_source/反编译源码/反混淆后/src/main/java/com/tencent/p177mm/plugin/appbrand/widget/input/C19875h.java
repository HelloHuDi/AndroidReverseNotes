package com.tencent.p177mm.plugin.appbrand.widget.input;

import android.util.SparseIntArray;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.page.C27221aj;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.input.h */
public final class C19875h {
    private static final C19875h jdJ = new C19875h();
    private final C11019a jdI = new C11019a();

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.h$a */
    static final class C11019a {
        final SparseIntArray jdK;

        private C11019a() {
            AppMethodBeat.m2504i(123619);
            this.jdK = new SparseIntArray();
            AppMethodBeat.m2505o(123619);
        }

        /* synthetic */ C11019a(byte b) {
            this();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: e */
        public final int mo22676e(C27221aj c27221aj) {
            AppMethodBeat.m2504i(123620);
            int i = this.jdK.get(c27221aj.hashCode(), 0);
            AppMethodBeat.m2505o(123620);
            return i;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final void mo22675a(C27221aj c27221aj, int i) {
            AppMethodBeat.m2504i(123621);
            this.jdK.put(c27221aj.hashCode(), i);
            AppMethodBeat.m2505o(123621);
        }
    }

    public C19875h() {
        AppMethodBeat.m2504i(123622);
        AppMethodBeat.m2505o(123622);
    }

    static {
        AppMethodBeat.m2504i(123626);
        AppMethodBeat.m2505o(123626);
    }

    public static C19875h aQx() {
        return jdJ;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final void mo35112b(C27221aj c27221aj) {
        AppMethodBeat.m2504i(123623);
        if (c27221aj == null) {
            AppMethodBeat.m2505o(123623);
            return;
        }
        this.jdI.jdK.delete(c27221aj.hashCode());
        try {
            c27221aj.getWrapperView().setFocusable(true);
            c27221aj.getWrapperView().setFocusableInTouchMode(true);
            c27221aj.getContentView().setFocusable(true);
            c27221aj.getContentView().setFocusableInTouchMode(true);
            AppMethodBeat.m2505o(123623);
        } catch (NullPointerException e) {
            AppMethodBeat.m2505o(123623);
        }
    }

    /* renamed from: c */
    public final void mo35113c(C27221aj c27221aj) {
        AppMethodBeat.m2504i(123624);
        if (c27221aj == null) {
            AppMethodBeat.m2505o(123624);
            return;
        }
        this.jdI.mo22675a(c27221aj, this.jdI.mo22676e(c27221aj) + 1);
        try {
            c27221aj.getWrapperView().setFocusable(false);
            c27221aj.getWrapperView().setFocusableInTouchMode(false);
            c27221aj.getContentView().setFocusable(false);
            c27221aj.getContentView().setFocusableInTouchMode(false);
            if (c27221aj.getWrapperView() instanceof ViewGroup) {
                ((ViewGroup) c27221aj.getWrapperView()).setDescendantFocusability(393216);
            }
            AppMethodBeat.m2505o(123624);
        } catch (NullPointerException e) {
            AppMethodBeat.m2505o(123624);
        }
    }

    /* renamed from: d */
    public final void mo35114d(C27221aj c27221aj) {
        AppMethodBeat.m2504i(123625);
        if (c27221aj == null) {
            AppMethodBeat.m2505o(123625);
            return;
        }
        int e = this.jdI.mo22676e(c27221aj) - 1;
        if (e <= 0) {
            mo35112b(c27221aj);
            AppMethodBeat.m2505o(123625);
            return;
        }
        this.jdI.mo22675a(c27221aj, e);
        AppMethodBeat.m2505o(123625);
    }
}
