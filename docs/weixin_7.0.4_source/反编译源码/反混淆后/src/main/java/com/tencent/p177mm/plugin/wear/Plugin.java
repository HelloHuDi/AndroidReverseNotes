package com.tencent.p177mm.plugin.wear;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.plugin.wear.model.C43841a;
import com.tencent.p177mm.pluginsdk.C23256o;
import com.tencent.p177mm.pluginsdk.p1337b.C40415c;
import com.tencent.p177mm.pluginsdk.p1337b.C44040b;

/* renamed from: com.tencent.mm.plugin.wear.Plugin */
public final class Plugin implements C40415c {
    public final C23256o createApplication() {
        return null;
    }

    public final C44040b getContactWidgetFactory() {
        return null;
    }

    public final C1816at createSubCore() {
        AppMethodBeat.m2504i(26264);
        C43841a c43841a = new C43841a();
        AppMethodBeat.m2505o(26264);
        return c43841a;
    }
}
