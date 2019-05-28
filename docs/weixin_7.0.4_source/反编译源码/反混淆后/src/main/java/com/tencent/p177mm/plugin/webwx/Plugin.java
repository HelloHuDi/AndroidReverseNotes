package com.tencent.p177mm.plugin.webwx;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.plugin.webwx.p1071a.C23163g;
import com.tencent.p177mm.pluginsdk.C23256o;
import com.tencent.p177mm.pluginsdk.p1337b.C40415c;
import com.tencent.p177mm.pluginsdk.p1337b.C44040b;

/* renamed from: com.tencent.mm.plugin.webwx.Plugin */
public final class Plugin implements C40415c {
    public final C23256o createApplication() {
        AppMethodBeat.m2504i(26478);
        C4660a c4660a = new C4660a();
        AppMethodBeat.m2505o(26478);
        return c4660a;
    }

    public final C44040b getContactWidgetFactory() {
        return null;
    }

    public final C1816at createSubCore() {
        AppMethodBeat.m2504i(26479);
        C23163g c23163g = new C23163g();
        AppMethodBeat.m2505o(26479);
        return c23163g;
    }
}
