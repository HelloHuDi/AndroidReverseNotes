package com.tencent.p177mm.plugin.appbrand.widget.input;

import android.support.p057v4.view.C0477s;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.page.C33481y;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.input.ah */
public final class C33615ah {
    final C44719g jgO;
    boolean jgP = false;
    boolean jgQ = false;
    boolean jgR = false;
    private final C27401a<ViewGroup, C44719g> jgS = new C336161();
    final C27401a<ViewGroup, C33481y> jgT = new C336172();

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.ah$a */
    static abstract class C27401a<Source extends View, Target extends View> {
        /* renamed from: Ov */
        private Target f13681Ov;

        /* renamed from: cP */
        public abstract boolean mo45134cP(View view);

        /* renamed from: cQ */
        public abstract Target mo45135cQ(View view);

        private C27401a() {
        }

        /* synthetic */ C27401a(byte b) {
            this();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: cR */
        public final Target mo45136cR(Source source) {
            if (this.f13681Ov != null && C0477s.m930av(this.f13681Ov)) {
                return this.f13681Ov;
            }
            if (source == null || !C0477s.m930av(source)) {
                return null;
            }
            for (ViewParent parent = source.getParent(); parent instanceof View; parent = parent.getParent()) {
                if (mo45134cP((View) parent)) {
                    Target cQ = mo45135cQ((View) parent);
                    this.f13681Ov = cQ;
                    return cQ;
                }
            }
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.ah$1 */
    class C336161 extends C27401a<ViewGroup, C44719g> {
        C336161() {
            super();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: cP */
        public final boolean mo45134cP(View view) {
            AppMethodBeat.m2504i(123840);
            if (view.getId() == 2131820569) {
                AppMethodBeat.m2505o(123840);
                return true;
            }
            AppMethodBeat.m2505o(123840);
            return false;
        }

        /* Access modifiers changed, original: final|synthetic */
        /* renamed from: cQ */
        public final /* synthetic */ View mo45135cQ(View view) {
            AppMethodBeat.m2504i(123841);
            C44719g c44719g = (C44719g) view.findViewById(2131820570);
            AppMethodBeat.m2505o(123841);
            return c44719g;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.ah$2 */
    class C336172 extends C27401a<ViewGroup, C33481y> {
        C336172() {
            super();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: cP */
        public final boolean mo45134cP(View view) {
            return view instanceof C33481y;
        }

        /* Access modifiers changed, original: final|bridge|synthetic */
        /* renamed from: cQ */
        public final /* bridge */ /* synthetic */ View mo45135cQ(View view) {
            return (C33481y) view;
        }
    }

    public C33615ah(C44719g c44719g) {
        AppMethodBeat.m2504i(123842);
        this.jgO = c44719g;
        AppMethodBeat.m2505o(123842);
    }
}
