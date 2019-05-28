package com.tencent.p177mm.plugin.extqlauncher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.pluginsdk.C23256o;
import com.tencent.p177mm.pluginsdk.p1337b.C40415c;
import com.tencent.p177mm.pluginsdk.p1337b.C44040b;

/* renamed from: com.tencent.mm.plugin.extqlauncher.Plugin */
public class Plugin implements C40415c {
    public C1816at createSubCore() {
        AppMethodBeat.m2504i(20471);
        C45910b c45910b = new C45910b();
        AppMethodBeat.m2505o(20471);
        return c45910b;
    }

    public C23256o createApplication() {
        AppMethodBeat.m2504i(20472);
        C38999a c38999a = new C38999a();
        AppMethodBeat.m2505o(20472);
        return c38999a;
    }

    public C44040b getContactWidgetFactory() {
        return null;
    }
}
