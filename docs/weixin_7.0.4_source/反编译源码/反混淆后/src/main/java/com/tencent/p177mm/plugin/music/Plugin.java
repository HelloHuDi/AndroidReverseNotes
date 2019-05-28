package com.tencent.p177mm.plugin.music;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.plugin.music.model.C39441b;
import com.tencent.p177mm.plugin.music.model.C39445e;
import com.tencent.p177mm.pluginsdk.C23256o;
import com.tencent.p177mm.pluginsdk.p1337b.C40415c;
import com.tencent.p177mm.pluginsdk.p1337b.C44040b;

/* renamed from: com.tencent.mm.plugin.music.Plugin */
public class Plugin implements C40415c {
    public C23256o createApplication() {
        AppMethodBeat.m2504i(104807);
        C39441b c39441b = new C39441b();
        AppMethodBeat.m2505o(104807);
        return c39441b;
    }

    public C44040b getContactWidgetFactory() {
        return null;
    }

    public C1816at createSubCore() {
        AppMethodBeat.m2504i(104808);
        C39445e c39445e = new C39445e();
        AppMethodBeat.m2505o(104808);
        return c39445e;
    }
}
