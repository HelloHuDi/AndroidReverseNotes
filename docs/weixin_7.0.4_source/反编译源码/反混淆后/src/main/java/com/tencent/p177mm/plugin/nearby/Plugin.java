package com.tencent.p177mm.plugin.nearby;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.plugin.nearby.p1001a.C43335f;
import com.tencent.p177mm.plugin.nearby.p469ui.C43342a;
import com.tencent.p177mm.pluginsdk.C23256o;
import com.tencent.p177mm.pluginsdk.p1337b.C23233a;
import com.tencent.p177mm.pluginsdk.p1337b.C40415c;
import com.tencent.p177mm.pluginsdk.p1337b.C44040b;

/* renamed from: com.tencent.mm.plugin.nearby.Plugin */
public class Plugin implements C40415c {
    private C44040b jJC = new C126951();

    /* renamed from: com.tencent.mm.plugin.nearby.Plugin$1 */
    class C126951 implements C44040b {
        C126951() {
        }

        /* renamed from: ac */
        public final C23233a mo6747ac(Context context, String str) {
            AppMethodBeat.m2504i(55348);
            C43342a c43342a = new C43342a(context);
            AppMethodBeat.m2505o(55348);
            return c43342a;
        }
    }

    public Plugin() {
        AppMethodBeat.m2504i(55349);
        AppMethodBeat.m2505o(55349);
    }

    public C23256o createApplication() {
        AppMethodBeat.m2504i(55350);
        C39456a c39456a = new C39456a();
        AppMethodBeat.m2505o(55350);
        return c39456a;
    }

    public C44040b getContactWidgetFactory() {
        return this.jJC;
    }

    public C1816at createSubCore() {
        AppMethodBeat.m2504i(55351);
        C43335f c43335f = new C43335f();
        AppMethodBeat.m2505o(55351);
        return c43335f;
    }
}
