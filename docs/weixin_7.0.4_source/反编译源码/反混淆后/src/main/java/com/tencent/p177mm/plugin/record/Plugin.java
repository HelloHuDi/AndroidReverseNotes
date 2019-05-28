package com.tencent.p177mm.plugin.record;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.plugin.record.p492b.C46165t;
import com.tencent.p177mm.pluginsdk.C23256o;
import com.tencent.p177mm.pluginsdk.p1337b.C40415c;
import com.tencent.p177mm.pluginsdk.p1337b.C44040b;

/* renamed from: com.tencent.mm.plugin.record.Plugin */
public final class Plugin implements C40415c {
    public final C23256o createApplication() {
        AppMethodBeat.m2504i(24161);
        C34793a c34793a = new C34793a();
        AppMethodBeat.m2505o(24161);
        return c34793a;
    }

    public final C44040b getContactWidgetFactory() {
        return null;
    }

    public final C1816at createSubCore() {
        AppMethodBeat.m2504i(24162);
        C46165t c46165t = new C46165t();
        AppMethodBeat.m2505o(24162);
        return c46165t;
    }
}
