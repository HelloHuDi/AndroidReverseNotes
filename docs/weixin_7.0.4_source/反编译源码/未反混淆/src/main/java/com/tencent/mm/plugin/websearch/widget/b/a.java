package com.tencent.mm.plugin.websearch.widget.b;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.n.d;

public final class a {

    public interface a {
        void cUT();

        void cVR();
    }

    /* renamed from: com.tencent.mm.plugin.websearch.widget.b.a$2 */
    public static class AnonymousClass2 implements d {
        final /* synthetic */ a udx;

        public AnonymousClass2(a aVar) {
            this.udx = aVar;
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.i(91460);
            if (i == 0) {
                this.udx.cVR();
                AppMethodBeat.o(91460);
                return;
            }
            if (i == 1) {
                this.udx.cUT();
            }
            AppMethodBeat.o(91460);
        }
    }
}
