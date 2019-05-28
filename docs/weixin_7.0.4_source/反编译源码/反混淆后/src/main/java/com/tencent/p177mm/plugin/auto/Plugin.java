package com.tencent.p177mm.plugin.auto;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.plugin.auto.p1475a.C42754b;
import com.tencent.p177mm.pluginsdk.C23256o;
import com.tencent.p177mm.pluginsdk.p1337b.C40415c;
import com.tencent.p177mm.pluginsdk.p1337b.C44040b;

/* renamed from: com.tencent.mm.plugin.auto.Plugin */
public class Plugin implements C40415c {
    public C23256o createApplication() {
        AppMethodBeat.m2504i(17099);
        C11070a c11070a = new C11070a();
        AppMethodBeat.m2505o(17099);
        return c11070a;
    }

    public C44040b getContactWidgetFactory() {
        return null;
    }

    public C1816at createSubCore() {
        AppMethodBeat.m2504i(17100);
        C42754b c42754b = new C42754b();
        AppMethodBeat.m2505o(17100);
        return c42754b;
    }
}
