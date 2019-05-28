package com.tencent.p177mm.plugin.label;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.pluginsdk.C23256o;
import com.tencent.p177mm.pluginsdk.p1337b.C40415c;
import com.tencent.p177mm.pluginsdk.p1337b.C44040b;

/* renamed from: com.tencent.mm.plugin.label.Plugin */
public final class Plugin implements C40415c {
    public final C23256o createApplication() {
        AppMethodBeat.m2504i(22509);
        C43234a c43234a = new C43234a();
        AppMethodBeat.m2505o(22509);
        return c43234a;
    }

    public final C44040b getContactWidgetFactory() {
        return null;
    }

    public final C1816at createSubCore() {
        AppMethodBeat.m2504i(22510);
        C21160e c21160e = new C21160e();
        AppMethodBeat.m2505o(22510);
        return c21160e;
    }
}
