package com.tencent.p177mm.plugin.webview.luggage;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.widget.C16001d;
import com.tencent.p177mm.plugin.webview.luggage.p1330b.C40224l;

/* renamed from: com.tencent.mm.plugin.webview.luggage.n */
public class C40246n {
    C24905d uiI;
    C40224l ujb;
    C16001d ujs = new C16001d(this.uiI.mContext, 0, false);

    /* renamed from: com.tencent.mm.plugin.webview.luggage.n$1 */
    class C45501 implements C36073c {
        C45501() {
        }

        /* renamed from: a */
        public final void mo5746a(C44273l c44273l) {
            AppMethodBeat.m2504i(6219);
            C40246n c40246n = C40246n.this;
            c40246n.ujb.mo63578b(c40246n.uiI.mContext, c40246n.uiI, c44273l);
            AppMethodBeat.m2505o(6219);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.luggage.n$2 */
    class C298082 implements C5279d {
        C298082() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(6220);
            C40246n c40246n = C40246n.this;
            c40246n.ujb.mo63575a(c40246n.uiI.mContext, c40246n.uiI, menuItem);
            C40246n.this.ujs.cpE();
            AppMethodBeat.m2505o(6220);
        }
    }

    public C40246n(C24905d c24905d, C40224l c40224l) {
        AppMethodBeat.m2504i(6221);
        this.uiI = c24905d;
        this.ujb = c40224l;
        this.ujs.cpD();
        AppMethodBeat.m2505o(6221);
    }

    public final void cXg() {
        AppMethodBeat.m2504i(6222);
        if (this.ujs != null) {
            this.ujs.cpE();
        }
        AppMethodBeat.m2505o(6222);
    }
}
