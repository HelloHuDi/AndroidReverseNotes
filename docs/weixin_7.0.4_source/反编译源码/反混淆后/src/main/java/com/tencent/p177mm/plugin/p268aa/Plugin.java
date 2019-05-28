package com.tencent.p177mm.plugin.p268aa;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.pluginsdk.C23256o;
import com.tencent.p177mm.pluginsdk.p1337b.C40415c;
import com.tencent.p177mm.pluginsdk.p1337b.C44040b;

/* renamed from: com.tencent.mm.plugin.aa.Plugin */
public class Plugin implements C40415c {
    public C23256o createApplication() {
        AppMethodBeat.m2504i(40571);
        C38007a c38007a = new C38007a();
        AppMethodBeat.m2505o(40571);
        return c38007a;
    }

    public C44040b getContactWidgetFactory() {
        return null;
    }

    public C1816at createSubCore() {
        AppMethodBeat.m2504i(40572);
        C45488b c45488b = new C45488b();
        AppMethodBeat.m2505o(40572);
        return c45488b;
    }
}
