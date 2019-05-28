package com.tencent.p177mm.plugin.wallet_payu;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.plugin.wallet_payu.p1561a.C43823d;
import com.tencent.p177mm.pluginsdk.C23256o;
import com.tencent.p177mm.pluginsdk.p1337b.C40415c;
import com.tencent.p177mm.pluginsdk.p1337b.C44040b;

/* renamed from: com.tencent.mm.plugin.wallet_payu.Plugin */
public class Plugin implements C40415c {
    public C23256o createApplication() {
        return null;
    }

    public C44040b getContactWidgetFactory() {
        return null;
    }

    public C1816at createSubCore() {
        AppMethodBeat.m2504i(48319);
        C43823d c43823d = new C43823d();
        AppMethodBeat.m2505o(48319);
        return c43823d;
    }
}
