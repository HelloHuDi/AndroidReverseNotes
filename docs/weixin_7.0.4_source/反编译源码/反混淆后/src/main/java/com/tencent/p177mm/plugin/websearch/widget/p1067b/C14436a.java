package com.tencent.p177mm.plugin.websearch.widget.p1067b;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;

/* renamed from: com.tencent.mm.plugin.websearch.widget.b.a */
public final class C14436a {

    /* renamed from: com.tencent.mm.plugin.websearch.widget.b.a$a */
    public interface C14435a {
        void cUT();

        void cVR();
    }

    /* renamed from: com.tencent.mm.plugin.websearch.widget.b.a$1 */
    public static class C144371 implements C36073c {
        /* renamed from: a */
        public final void mo5746a(C44273l c44273l) {
            AppMethodBeat.m2504i(91459);
            c44273l.mo70068e(0, "打开调试");
            c44273l.mo70068e(1, "切换服务提供商");
            AppMethodBeat.m2505o(91459);
        }
    }

    /* renamed from: com.tencent.mm.plugin.websearch.widget.b.a$2 */
    public static class C144382 implements C5279d {
        final /* synthetic */ C14435a udx;

        public C144382(C14435a c14435a) {
            this.udx = c14435a;
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(91460);
            if (i == 0) {
                this.udx.cVR();
                AppMethodBeat.m2505o(91460);
                return;
            }
            if (i == 1) {
                this.udx.cUT();
            }
            AppMethodBeat.m2505o(91460);
        }
    }
}
