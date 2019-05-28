package com.tencent.p177mm.plugin.appbrand.widget.p340i;

import android.graphics.Bitmap;
import android.webkit.URLUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelappbrand.p873a.C37926b;
import com.tencent.p177mm.modelappbrand.p873a.C37926b.C9676i;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.p321l.C19538j;
import com.tencent.p177mm.plugin.appbrand.p321l.C38414a;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.i.g */
public final class C2554g extends C33612d {

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.i.g$1 */
    class C25551 implements C9676i {
        C25551() {
        }

        public final void abU() {
        }

        /* renamed from: x */
        public final void mo6524x(Bitmap bitmap) {
            AppMethodBeat.m2504i(87565);
            C2554g.this.mo54183I(bitmap);
            AppMethodBeat.m2505o(87565);
        }

        /* renamed from: mr */
        public final void mo6522mr() {
            AppMethodBeat.m2504i(87566);
            C2554g.this.jpv.mo6339a("Failed to load icon via network", C2554g.this);
            AppMethodBeat.m2505o(87566);
        }

        /* renamed from: wP */
        public final String mo6523wP() {
            return C2554g.this.jpu;
        }
    }

    public C2554g(String str, C33611c c33611c, C38492q c38492q) {
        super(str, c33611c, c38492q);
    }

    public final void aSg() {
        Object obj;
        AppMethodBeat.m2504i(87567);
        String str = this.jpu;
        C38414a c38414a = (C38414a) this.hwf.mo5937aa(C38414a.class);
        if (!c38414a.iof || (C19538j.m30275c(c38414a.bQF, str) && URLUtil.isHttpsUrl(str))) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            this.jpv.mo6339a("url not in domain list", this);
            AppMethodBeat.m2505o(87567);
            return;
        }
        if (this.jpu != null) {
            C37926b.abR().mo60685a(new C25551(), this.jpu, null);
        }
        AppMethodBeat.m2505o(87567);
    }
}
