package com.tencent.p177mm.plugin.clean;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.plugin.clean.p1479a.C33818a;
import com.tencent.p177mm.plugin.clean.p362c.C6826j;
import com.tencent.p177mm.pluginsdk.C23256o;
import com.tencent.p177mm.pluginsdk.p1337b.C40415c;
import com.tencent.p177mm.pluginsdk.p1337b.C44040b;

/* renamed from: com.tencent.mm.plugin.clean.Plugin */
public class Plugin implements C40415c {
    public C23256o createApplication() {
        AppMethodBeat.m2504i(18650);
        C33818a c33818a = new C33818a();
        AppMethodBeat.m2505o(18650);
        return c33818a;
    }

    public C44040b getContactWidgetFactory() {
        return null;
    }

    public C1816at createSubCore() {
        AppMethodBeat.m2504i(18651);
        C6826j bgd = C6826j.bgd();
        AppMethodBeat.m2505o(18651);
        return bgd;
    }
}
