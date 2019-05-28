package com.tencent.p177mm.plugin.ext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.pluginsdk.C23256o;
import com.tencent.p177mm.pluginsdk.p1337b.C40415c;
import com.tencent.p177mm.pluginsdk.p1337b.C44040b;

/* renamed from: com.tencent.mm.plugin.ext.Plugin */
public class Plugin implements C40415c {
    public C1816at createSubCore() {
        AppMethodBeat.m2504i(20259);
        C6875b c6875b = new C6875b();
        AppMethodBeat.m2505o(20259);
        return c6875b;
    }

    public C23256o createApplication() {
        AppMethodBeat.m2504i(20260);
        C45904a c45904a = new C45904a();
        AppMethodBeat.m2505o(20260);
        return c45904a;
    }

    public C44040b getContactWidgetFactory() {
        return null;
    }
}
