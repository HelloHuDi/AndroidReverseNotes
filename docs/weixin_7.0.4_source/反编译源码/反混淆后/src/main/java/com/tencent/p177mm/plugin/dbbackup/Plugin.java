package com.tencent.p177mm.plugin.dbbackup;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.pluginsdk.C23256o;
import com.tencent.p177mm.pluginsdk.p1337b.C40415c;
import com.tencent.p177mm.pluginsdk.p1337b.C44040b;

/* renamed from: com.tencent.mm.plugin.dbbackup.Plugin */
public class Plugin implements C40415c {
    public C23256o createApplication() {
        AppMethodBeat.m2504i(18967);
        C38841a c38841a = new C38841a();
        AppMethodBeat.m2505o(18967);
        return c38841a;
    }

    public C44040b getContactWidgetFactory() {
        return null;
    }

    public C1816at createSubCore() {
        AppMethodBeat.m2504i(18968);
        C11486d c11486d = new C11486d();
        AppMethodBeat.m2505o(18968);
        return c11486d;
    }
}
