package com.tencent.p177mm.plugin.search;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.plugin.search.p1292a.C28925b;
import com.tencent.p177mm.pluginsdk.C23256o;
import com.tencent.p177mm.pluginsdk.p1337b.C40415c;
import com.tencent.p177mm.pluginsdk.p1337b.C44040b;

/* renamed from: com.tencent.mm.plugin.search.Plugin */
public final class Plugin implements C40415c {
    public final C23256o createApplication() {
        AppMethodBeat.m2504i(24398);
        C28926a c28926a = new C28926a();
        AppMethodBeat.m2505o(24398);
        return c28926a;
    }

    public final C1816at createSubCore() {
        AppMethodBeat.m2504i(24399);
        C28925b c28925b = new C28925b();
        AppMethodBeat.m2505o(24399);
        return c28925b;
    }

    public final C44040b getContactWidgetFactory() {
        return null;
    }
}
