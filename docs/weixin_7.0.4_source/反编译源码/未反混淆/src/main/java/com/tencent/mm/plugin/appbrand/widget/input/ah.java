package com.tencent.mm.plugin.appbrand.widget.input;

import android.support.v4.view.s;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.page.y;

public final class ah {
    final g jgO;
    boolean jgP = false;
    boolean jgQ = false;
    boolean jgR = false;
    private final a<ViewGroup, g> jgS = new a<ViewGroup, g>() {
        /* Access modifiers changed, original: final */
        public final boolean cP(View view) {
            AppMethodBeat.i(123840);
            if (view.getId() == R.id.z) {
                AppMethodBeat.o(123840);
                return true;
            }
            AppMethodBeat.o(123840);
            return false;
        }

        /* Access modifiers changed, original: final|synthetic */
        public final /* synthetic */ View cQ(View view) {
            AppMethodBeat.i(123841);
            g gVar = (g) view.findViewById(R.id.a0);
            AppMethodBeat.o(123841);
            return gVar;
        }
    };
    final a<ViewGroup, y> jgT = new a<ViewGroup, y>() {
        /* Access modifiers changed, original: final */
        public final boolean cP(View view) {
            return view instanceof y;
        }

        /* Access modifiers changed, original: final|bridge|synthetic */
        public final /* bridge */ /* synthetic */ View cQ(View view) {
            return (y) view;
        }
    };

    static abstract class a<Source extends View, Target extends View> {
        private Target Ov;

        public abstract boolean cP(View view);

        public abstract Target cQ(View view);

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        /* Access modifiers changed, original: final */
        public final Target cR(Source source) {
            if (this.Ov != null && s.av(this.Ov)) {
                return this.Ov;
            }
            if (source == null || !s.av(source)) {
                return null;
            }
            for (ViewParent parent = source.getParent(); parent instanceof View; parent = parent.getParent()) {
                if (cP((View) parent)) {
                    Target cQ = cQ((View) parent);
                    this.Ov = cQ;
                    return cQ;
                }
            }
            return null;
        }
    }

    public ah(g gVar) {
        AppMethodBeat.i(123842);
        this.jgO = gVar;
        AppMethodBeat.o(123842);
    }
}
