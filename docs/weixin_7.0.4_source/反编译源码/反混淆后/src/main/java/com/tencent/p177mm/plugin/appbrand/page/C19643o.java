package com.tencent.p177mm.plugin.appbrand.page;

import android.content.Context;
import android.graphics.Color;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.C5225ah;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.plugin.appbrand.menu.C42636n;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.page.o */
public class C19643o {
    C44709u hTn;
    C36356d irC;
    List<C42636n> irD;
    String mAppId;

    /* renamed from: com.tencent.mm.plugin.appbrand.page.o$2 */
    class C196442 implements C5279d {
        C196442() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            Object obj;
            AppMethodBeat.m2504i(87072);
            List<C42636n> list = C19643o.this.irD;
            int itemId = menuItem.getItemId();
            for (C42636n c42636n : list) {
                if (c42636n.f17185id == itemId) {
                    break;
                }
            }
            C42636n c42636n2 = null;
            Context context = C19643o.this.hTn.mContext;
            C44709u c44709u = C19643o.this.hTn;
            String str = C19643o.this.mAppId;
            if (c42636n2 == null) {
                obj = null;
            } else {
                c42636n2.imL.mo6301a(context, c44709u, str, c42636n2);
                obj = 1;
            }
            if (obj != null) {
                C19643o.this.irC.cpE();
            }
            AppMethodBeat.m2505o(87072);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.page.o$1 */
    class C196451 implements C36073c {
        C196451() {
        }

        /* renamed from: a */
        public final void mo5746a(C44273l c44273l) {
            AppMethodBeat.m2504i(87071);
            for (C42636n c42636n : C19643o.this.irD) {
                if (!(c42636n == null || c42636n.imK)) {
                    Context context = C19643o.this.hTn.mContext;
                    C44709u c44709u = C19643o.this.hTn;
                    String str = C19643o.this.mAppId;
                    if (c42636n != null) {
                        c42636n.imL.mo6300a(context, c44709u, c44273l, str);
                    }
                }
            }
            AppMethodBeat.m2505o(87071);
        }
    }

    public C19643o(C44709u c44709u, List<C42636n> list) {
        AppMethodBeat.m2504i(87073);
        this.mAppId = c44709u.getAppId();
        this.hTn = c44709u;
        this.irD = list;
        C36356d c36356d = new C36356d(c44709u.mContext);
        this.irC = c36356d;
        mo34880a(c36356d);
        AppMethodBeat.m2505o(87073);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean aJm() {
        AppMethodBeat.m2504i(87074);
        try {
            this.irC.cpD();
            AppMethodBeat.m2505o(87074);
            return true;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.AppBrandPageActionSheet", "show exception = %s", e);
            AppMethodBeat.m2505o(87074);
            return false;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean aJn() {
        AppMethodBeat.m2504i(87075);
        try {
            this.irC.cpE();
            AppMethodBeat.m2505o(87075);
            return true;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.AppBrandPageActionSheet", "hide exception = %s", e);
            AppMethodBeat.m2505o(87075);
            return false;
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo34880a(C36356d c36356d) {
        AppMethodBeat.m2504i(87076);
        View aBl = this.hTn.aBl();
        if (aBl != null) {
            this.irC.mo57234F(aBl, false);
        }
        this.irC.rBl = new C196451();
        this.irC.rBm = new C196442();
        if (this.hTn.isO) {
            C36356d c36356d2 = this.irC;
            int parseColor = Color.parseColor("#000000");
            if (c36356d2.iym != null) {
                c36356d2.iym.setBackgroundColor(parseColor);
            }
            c36356d2.zQj = Boolean.valueOf(C5225ah.m7958Nw(parseColor));
            if (c36356d2.zQj.booleanValue() && c36356d2.zQr != null) {
                c36356d2.zQr.setImageDrawable(c36356d2.mContext.getResources().getDrawable(C25738R.color.f11910lb));
            }
        }
        AppMethodBeat.m2505o(87076);
    }
}
