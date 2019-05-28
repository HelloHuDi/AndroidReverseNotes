package com.tencent.p177mm.plugin.nearlife;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.plugin.nearlife.p1494b.C34619d;
import com.tencent.p177mm.plugin.nearlife.p470a.C3551a;
import com.tencent.p177mm.pluginsdk.C23256o;
import com.tencent.p177mm.pluginsdk.p1337b.C40415c;
import com.tencent.p177mm.pluginsdk.p1337b.C44040b;

/* renamed from: com.tencent.mm.plugin.nearlife.Plugin */
public class Plugin implements C40415c {
    public C23256o createApplication() {
        AppMethodBeat.m2504i(22921);
        C3551a c3551a = new C3551a();
        AppMethodBeat.m2505o(22921);
        return c3551a;
    }

    public C44040b getContactWidgetFactory() {
        return null;
    }

    public C1816at createSubCore() {
        AppMethodBeat.m2504i(22922);
        C34619d c34619d = new C34619d();
        AppMethodBeat.m2505o(22922);
        return c34619d;
    }
}
