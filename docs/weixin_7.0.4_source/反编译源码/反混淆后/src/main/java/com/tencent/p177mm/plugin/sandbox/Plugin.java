package com.tencent.p177mm.plugin.sandbox;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.pluginsdk.C23256o;
import com.tencent.p177mm.pluginsdk.p1337b.C40415c;
import com.tencent.p177mm.pluginsdk.p1337b.C44040b;

/* renamed from: com.tencent.mm.plugin.sandbox.Plugin */
public class Plugin implements C40415c {
    public C23256o createApplication() {
        AppMethodBeat.m2504i(24379);
        C13115a c13115a = new C13115a();
        AppMethodBeat.m2505o(24379);
        return c13115a;
    }

    public C44040b getContactWidgetFactory() {
        return null;
    }

    public C1816at createSubCore() {
        AppMethodBeat.m2504i(24380);
        SubCoreSandBox subCoreSandBox = new SubCoreSandBox();
        AppMethodBeat.m2505o(24380);
        return subCoreSandBox;
    }
}
