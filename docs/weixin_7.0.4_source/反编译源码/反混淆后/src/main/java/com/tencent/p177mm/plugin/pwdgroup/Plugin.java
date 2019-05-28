package com.tencent.p177mm.plugin.pwdgroup;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.pluginsdk.C23256o;
import com.tencent.p177mm.pluginsdk.p1337b.C40415c;
import com.tencent.p177mm.pluginsdk.p1337b.C44040b;

/* renamed from: com.tencent.mm.plugin.pwdgroup.Plugin */
public final class Plugin implements C40415c {
    public final C23256o createApplication() {
        AppMethodBeat.m2504i(23972);
        C12867a c12867a = new C12867a();
        AppMethodBeat.m2505o(23972);
        return c12867a;
    }

    public final C44040b getContactWidgetFactory() {
        return null;
    }

    public final C1816at createSubCore() {
        AppMethodBeat.m2504i(23973);
        C34743c c34743c = new C34743c();
        AppMethodBeat.m2505o(23973);
        return c34743c;
    }
}
