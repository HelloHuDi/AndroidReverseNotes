package com.tencent.p177mm.plugin.bottle;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.plugin.bottle.p924a.C45759d;
import com.tencent.p177mm.pluginsdk.C23256o;
import com.tencent.p177mm.pluginsdk.p1337b.C23233a;
import com.tencent.p177mm.pluginsdk.p1337b.C40415c;
import com.tencent.p177mm.pluginsdk.p1337b.C44040b;

/* renamed from: com.tencent.mm.plugin.bottle.Plugin */
public final class Plugin implements C40415c {
    private C44040b jJC = new C26801();

    /* renamed from: com.tencent.mm.plugin.bottle.Plugin$1 */
    class C26801 implements C44040b {
        C26801() {
        }

        /* renamed from: ac */
        public final C23233a mo6747ac(Context context, String str) {
            return null;
        }
    }

    public Plugin() {
        AppMethodBeat.m2504i(18529);
        AppMethodBeat.m2505o(18529);
    }

    public final C23256o createApplication() {
        AppMethodBeat.m2504i(18530);
        C24727a c24727a = new C24727a();
        AppMethodBeat.m2505o(18530);
        return c24727a;
    }

    public final C1816at createSubCore() {
        AppMethodBeat.m2504i(18531);
        C45759d c45759d = new C45759d();
        AppMethodBeat.m2505o(18531);
        return c45759d;
    }

    public final C44040b getContactWidgetFactory() {
        return this.jJC;
    }
}
