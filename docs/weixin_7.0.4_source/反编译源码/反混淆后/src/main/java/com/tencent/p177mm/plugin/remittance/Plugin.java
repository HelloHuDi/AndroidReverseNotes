package com.tencent.p177mm.plugin.remittance;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.plugin.remittance.p1017a.C28850c;
import com.tencent.p177mm.pluginsdk.C23256o;
import com.tencent.p177mm.pluginsdk.p1337b.C40415c;
import com.tencent.p177mm.pluginsdk.p1337b.C44040b;

/* renamed from: com.tencent.mm.plugin.remittance.Plugin */
public final class Plugin implements C40415c {
    public final C23256o createApplication() {
        return null;
    }

    public final C44040b getContactWidgetFactory() {
        return null;
    }

    public final C1816at createSubCore() {
        AppMethodBeat.m2504i(44421);
        C28850c c28850c = new C28850c();
        AppMethodBeat.m2505o(44421);
        return c28850c;
    }
}
