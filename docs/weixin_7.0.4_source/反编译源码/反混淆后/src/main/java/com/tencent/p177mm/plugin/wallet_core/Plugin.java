package com.tencent.p177mm.plugin.wallet_core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.p1560a.C40091a;
import com.tencent.p177mm.pluginsdk.C23256o;
import com.tencent.p177mm.pluginsdk.p1337b.C40415c;
import com.tencent.p177mm.pluginsdk.p1337b.C44040b;

/* renamed from: com.tencent.mm.plugin.wallet_core.Plugin */
public class Plugin implements C40415c {
    public C23256o createApplication() {
        AppMethodBeat.m2504i(46465);
        C40091a c40091a = new C40091a();
        AppMethodBeat.m2505o(46465);
        return c40091a;
    }

    public C44040b getContactWidgetFactory() {
        return null;
    }

    public C1816at createSubCore() {
        AppMethodBeat.m2504i(46466);
        C14241r c14241r = new C14241r();
        AppMethodBeat.m2505o(46466);
        return c14241r;
    }
}
