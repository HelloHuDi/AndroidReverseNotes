package com.tencent.p177mm.plugin.shake;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.plugin.shake.p1019b.C28987m;
import com.tencent.p177mm.plugin.shake.p511ui.C13297a;
import com.tencent.p177mm.pluginsdk.C23256o;
import com.tencent.p177mm.pluginsdk.p1337b.C23233a;
import com.tencent.p177mm.pluginsdk.p1337b.C40415c;
import com.tencent.p177mm.pluginsdk.p1337b.C44040b;

/* renamed from: com.tencent.mm.plugin.shake.Plugin */
public class Plugin implements C40415c {
    private C44040b qrp = new C218241();

    /* renamed from: com.tencent.mm.plugin.shake.Plugin$1 */
    class C218241 implements C44040b {
        C218241() {
        }

        /* renamed from: ac */
        public final C23233a mo6747ac(Context context, String str) {
            AppMethodBeat.m2504i(24407);
            C13297a c13297a = new C13297a(context);
            AppMethodBeat.m2505o(24407);
            return c13297a;
        }
    }

    public Plugin() {
        AppMethodBeat.m2504i(24408);
        AppMethodBeat.m2505o(24408);
    }

    public C23256o createApplication() {
        AppMethodBeat.m2504i(24409);
        C46193a c46193a = new C46193a();
        AppMethodBeat.m2505o(24409);
        return c46193a;
    }

    public C44040b getContactWidgetFactory() {
        return this.qrp;
    }

    public C1816at createSubCore() {
        AppMethodBeat.m2504i(24410);
        C28987m c28987m = new C28987m();
        AppMethodBeat.m2505o(24410);
        return c28987m;
    }
}
