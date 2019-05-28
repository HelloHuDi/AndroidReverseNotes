package com.tencent.p177mm.plugin.location;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.plugin.location.model.C39287l;
import com.tencent.p177mm.pluginsdk.C23256o;
import com.tencent.p177mm.pluginsdk.p1337b.C40415c;
import com.tencent.p177mm.pluginsdk.p1337b.C44040b;

/* renamed from: com.tencent.mm.plugin.location.Plugin */
public class Plugin implements C40415c {
    public C23256o createApplication() {
        AppMethodBeat.m2504i(113287);
        C34406a c34406a = new C34406a();
        AppMethodBeat.m2505o(113287);
        return c34406a;
    }

    public C44040b getContactWidgetFactory() {
        return null;
    }

    public C1816at createSubCore() {
        AppMethodBeat.m2504i(113288);
        C39287l c39287l = new C39287l();
        AppMethodBeat.m2505o(113288);
        return c39287l;
    }
}
