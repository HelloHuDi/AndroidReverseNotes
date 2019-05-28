package com.tencent.p177mm.plugin.recharge;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.plugin.recharge.p1655a.C46158a;
import com.tencent.p177mm.pluginsdk.C23256o;
import com.tencent.p177mm.pluginsdk.p1337b.C40415c;
import com.tencent.p177mm.pluginsdk.p1337b.C44040b;

/* renamed from: com.tencent.mm.plugin.recharge.Plugin */
public class Plugin implements C40415c {
    public C23256o createApplication() {
        return null;
    }

    public C44040b getContactWidgetFactory() {
        return null;
    }

    public C1816at createSubCore() {
        AppMethodBeat.m2504i(44175);
        C46158a c46158a = new C46158a();
        AppMethodBeat.m2505o(44175);
        return c46158a;
    }
}
