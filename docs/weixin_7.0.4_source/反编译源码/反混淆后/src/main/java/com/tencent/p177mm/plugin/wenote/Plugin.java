package com.tencent.p177mm.plugin.wenote;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.plugin.wenote.model.C46453c;
import com.tencent.p177mm.pluginsdk.C23256o;
import com.tencent.p177mm.pluginsdk.p1337b.C40415c;
import com.tencent.p177mm.pluginsdk.p1337b.C44040b;

/* renamed from: com.tencent.mm.plugin.wenote.Plugin */
public final class Plugin implements C40415c {
    public final C23256o createApplication() {
        AppMethodBeat.m2504i(26583);
        C43998a c43998a = new C43998a();
        AppMethodBeat.m2505o(26583);
        return c43998a;
    }

    public final C44040b getContactWidgetFactory() {
        return null;
    }

    public final C1816at createSubCore() {
        AppMethodBeat.m2504i(26584);
        C46453c c46453c = new C46453c();
        AppMethodBeat.m2505o(26584);
        return c46453c;
    }
}
