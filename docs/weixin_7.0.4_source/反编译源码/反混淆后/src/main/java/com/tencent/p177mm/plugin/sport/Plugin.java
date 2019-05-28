package com.tencent.p177mm.plugin.sport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.plugin.sport.model.C29263o;
import com.tencent.p177mm.plugin.sport.p1030ui.p1504a.C35167b;
import com.tencent.p177mm.pluginsdk.C23256o;
import com.tencent.p177mm.pluginsdk.p1337b.C40415c;
import com.tencent.p177mm.pluginsdk.p1337b.C44040b;

/* renamed from: com.tencent.mm.plugin.sport.Plugin */
public class Plugin implements C40415c {
    public C23256o createApplication() {
        AppMethodBeat.m2504i(25133);
        C35160c c35160c = new C35160c();
        AppMethodBeat.m2505o(25133);
        return c35160c;
    }

    public C44040b getContactWidgetFactory() {
        AppMethodBeat.m2504i(25134);
        C35167b c35167b = new C35167b();
        AppMethodBeat.m2505o(25134);
        return c35167b;
    }

    public C1816at createSubCore() {
        AppMethodBeat.m2504i(25135);
        C29263o c29263o = new C29263o();
        AppMethodBeat.m2505o(25135);
        return c29263o;
    }
}
