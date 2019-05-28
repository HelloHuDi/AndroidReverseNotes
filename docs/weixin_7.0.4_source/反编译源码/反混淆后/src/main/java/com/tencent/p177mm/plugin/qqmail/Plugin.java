package com.tencent.p177mm.plugin.qqmail;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.plugin.qqmail.p1618a.C43401a;
import com.tencent.p177mm.plugin.qqmail.p486b.C12884ac;
import com.tencent.p177mm.pluginsdk.C23256o;
import com.tencent.p177mm.pluginsdk.p1337b.C40415c;
import com.tencent.p177mm.pluginsdk.p1337b.C44040b;

/* renamed from: com.tencent.mm.plugin.qqmail.Plugin */
public final class Plugin implements C40415c {
    private C46145a ptm = new C46145a();

    public Plugin() {
        AppMethodBeat.m2504i(67898);
        AppMethodBeat.m2505o(67898);
    }

    public final C23256o createApplication() {
        AppMethodBeat.m2504i(67899);
        C43401a c43401a = new C43401a();
        AppMethodBeat.m2505o(67899);
        return c43401a;
    }

    public final C44040b getContactWidgetFactory() {
        return this.ptm;
    }

    public final C1816at createSubCore() {
        AppMethodBeat.m2504i(67900);
        C12884ac c12884ac = new C12884ac();
        AppMethodBeat.m2505o(67900);
        return c12884ac;
    }
}
