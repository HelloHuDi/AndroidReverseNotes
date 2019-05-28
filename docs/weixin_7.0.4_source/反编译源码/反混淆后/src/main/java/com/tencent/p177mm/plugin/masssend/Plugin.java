package com.tencent.p177mm.plugin.masssend;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.plugin.masssend.p452ui.C24792a;
import com.tencent.p177mm.plugin.masssend.p992a.C21270h;
import com.tencent.p177mm.pluginsdk.C23256o;
import com.tencent.p177mm.pluginsdk.p1337b.C23233a;
import com.tencent.p177mm.pluginsdk.p1337b.C40415c;
import com.tencent.p177mm.pluginsdk.p1337b.C44040b;

/* renamed from: com.tencent.mm.plugin.masssend.Plugin */
public class Plugin implements C40415c {
    private C44040b jJC = new C212681();

    /* renamed from: com.tencent.mm.plugin.masssend.Plugin$1 */
    class C212681 implements C44040b {
        C212681() {
        }

        /* renamed from: ac */
        public final C23233a mo6747ac(Context context, String str) {
            AppMethodBeat.m2504i(22717);
            C24792a c24792a = new C24792a(context);
            AppMethodBeat.m2505o(22717);
            return c24792a;
        }
    }

    public Plugin() {
        AppMethodBeat.m2504i(22718);
        AppMethodBeat.m2505o(22718);
    }

    public C23256o createApplication() {
        AppMethodBeat.m2504i(22719);
        C12490a c12490a = new C12490a();
        AppMethodBeat.m2505o(22719);
        return c12490a;
    }

    public C44040b getContactWidgetFactory() {
        return this.jJC;
    }

    public C1816at createSubCore() {
        AppMethodBeat.m2504i(22720);
        C21270h c21270h = new C21270h();
        AppMethodBeat.m2505o(22720);
        return c21270h;
    }
}
