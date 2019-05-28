package com.tencent.p177mm.plugin.collect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.plugin.collect.p1481a.C45815a;
import com.tencent.p177mm.pluginsdk.C23256o;
import com.tencent.p177mm.pluginsdk.p1337b.C40415c;
import com.tencent.p177mm.pluginsdk.p1337b.C44040b;

/* renamed from: com.tencent.mm.plugin.collect.Plugin */
public final class Plugin implements C40415c {
    public final C23256o createApplication() {
        return null;
    }

    public final C44040b getContactWidgetFactory() {
        return null;
    }

    public final C1816at createSubCore() {
        AppMethodBeat.m2504i(40905);
        C45815a c45815a = new C45815a();
        AppMethodBeat.m2505o(40905);
        return c45815a;
    }
}
