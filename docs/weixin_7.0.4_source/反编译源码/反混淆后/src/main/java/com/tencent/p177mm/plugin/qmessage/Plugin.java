package com.tencent.p177mm.plugin.qmessage;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.plugin.qmessage.p485ui.C24807b;
import com.tencent.p177mm.plugin.qmessage.p485ui.C46144a;
import com.tencent.p177mm.plugin.qmessage.p739a.C46142g;
import com.tencent.p177mm.pluginsdk.C23256o;
import com.tencent.p177mm.pluginsdk.p1337b.C23233a;
import com.tencent.p177mm.pluginsdk.p1337b.C40415c;
import com.tencent.p177mm.pluginsdk.p1337b.C44040b;

/* renamed from: com.tencent.mm.plugin.qmessage.Plugin */
public class Plugin implements C40415c {
    private C44040b jJC = new C433991();

    /* renamed from: com.tencent.mm.plugin.qmessage.Plugin$1 */
    class C433991 implements C44040b {
        C433991() {
        }

        /* renamed from: ac */
        public final C23233a mo6747ac(Context context, String str) {
            AppMethodBeat.m2504i(24063);
            if ("widget_type_contact".equals(str)) {
                C46144a c46144a = new C46144a(context);
                AppMethodBeat.m2505o(24063);
                return c46144a;
            }
            C23233a c24807b = new C24807b(context);
            AppMethodBeat.m2505o(24063);
            return c24807b;
        }
    }

    public Plugin() {
        AppMethodBeat.m2504i(24064);
        AppMethodBeat.m2505o(24064);
    }

    public C23256o createApplication() {
        AppMethodBeat.m2504i(24065);
        C46143a c46143a = new C46143a();
        AppMethodBeat.m2505o(24065);
        return c46143a;
    }

    public C44040b getContactWidgetFactory() {
        return this.jJC;
    }

    public C1816at createSubCore() {
        AppMethodBeat.m2504i(24066);
        C46142g c46142g = new C46142g();
        AppMethodBeat.m2505o(24066);
        return c46142g;
    }
}
