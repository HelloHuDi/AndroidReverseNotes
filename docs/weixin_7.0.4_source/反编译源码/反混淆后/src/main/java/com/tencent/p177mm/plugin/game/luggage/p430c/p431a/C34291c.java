package com.tencent.p177mm.plugin.game.luggage.p430c.p431a;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.plugin.game.luggage.p432d.C12140e;
import com.tencent.p177mm.plugin.webview.luggage.C24905d;
import com.tencent.p177mm.plugin.webview.p580ui.tools.game.menu.C46440b.C14617c;
import com.tencent.p177mm.plugin.webview.p580ui.tools.game.menu.C46440b.C46439b;
import com.tencent.p177mm.plugin.webview.p580ui.tools.game.menu.C46442d;
import com.tencent.p177mm.protocal.protobuf.bbb;

/* renamed from: com.tencent.mm.plugin.game.luggage.c.a.c */
public final class C34291c {
    C12140e mUm;
    C34290b mUn;
    public C46442d mUo = new C46442d(this.mUm.mContext);

    /* renamed from: com.tencent.mm.plugin.game.luggage.c.a.c$1 */
    class C209751 implements C46439b {
        C209751() {
        }

        /* renamed from: a */
        public final void mo36295a(C44273l c44273l) {
            AppMethodBeat.m2504i(135894);
            C34291c c34291c = C34291c.this;
            C34290b c34290b = c34291c.mUn;
            C24905d c24905d = c34291c.mUm;
            for (bbb bbb : c34290b.mUj) {
                if (bbb == null) {
                    c44273l.mo70068e(-1, "");
                } else {
                    C34289a c34289a = (C34289a) c34290b.mUk.get(Integer.valueOf(bbb.wkB));
                    if (c34289a != null) {
                        c34289a.mo54819a(c24905d, c44273l, bbb);
                    }
                }
            }
            AppMethodBeat.m2505o(135894);
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.luggage.c.a.c$2 */
    class C282122 implements C14617c {
        C282122() {
        }

        /* renamed from: f */
        public final void mo26874f(MenuItem menuItem) {
            AppMethodBeat.m2504i(135895);
            C34291c c34291c = C34291c.this;
            C34290b c34290b = c34291c.mUn;
            Context context = c34291c.mUm.mContext;
            C24905d c24905d = c34291c.mUm;
            C34289a c34289a = (C34289a) c34290b.mUk.get(Integer.valueOf(menuItem.getItemId()));
            for (bbb bbb : c34290b.mUj) {
                if (bbb != null && bbb.wkB == menuItem.getItemId()) {
                    break;
                }
            }
            bbb bbb2 = null;
            if (!(c34289a == null || bbb2 == null)) {
                c34289a.mo7540a(context, c24905d, bbb2);
            }
            C34291c.this.mUo.cpE();
            AppMethodBeat.m2505o(135895);
        }
    }

    public C34291c(C12140e c12140e, C34290b c34290b) {
        AppMethodBeat.m2504i(135896);
        this.mUm = c12140e;
        this.mUn = c34290b;
        this.mUo.mo74657a(new C282122());
        this.mUo.cpD();
        AppMethodBeat.m2505o(135896);
    }
}
