package com.tencent.p177mm.plugin.mall;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.plugin.mall.p450a.C43288j;
import com.tencent.p177mm.pluginsdk.C23256o;
import com.tencent.p177mm.pluginsdk.p1337b.C40415c;
import com.tencent.p177mm.pluginsdk.p1337b.C44040b;

/* renamed from: com.tencent.mm.plugin.mall.Plugin */
public class Plugin implements C40415c {
    public C23256o createApplication() {
        return null;
    }

    public C44040b getContactWidgetFactory() {
        return null;
    }

    public C1816at createSubCore() {
        AppMethodBeat.m2504i(43091);
        C43288j c43288j = new C43288j();
        AppMethodBeat.m2505o(43091);
        return c43288j;
    }
}
