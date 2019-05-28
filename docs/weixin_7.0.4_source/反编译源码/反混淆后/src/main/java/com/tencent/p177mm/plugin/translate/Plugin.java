package com.tencent.p177mm.plugin.translate;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.pluginsdk.C23256o;
import com.tencent.p177mm.pluginsdk.p1337b.C40415c;
import com.tencent.p177mm.pluginsdk.p1337b.C44040b;

/* renamed from: com.tencent.mm.plugin.translate.Plugin */
public class Plugin implements C40415c {
    public C23256o createApplication() {
        AppMethodBeat.m2504i(26045);
        C43716b c43716b = new C43716b();
        AppMethodBeat.m2505o(26045);
        return c43716b;
    }

    public C44040b getContactWidgetFactory() {
        return null;
    }

    public C1816at createSubCore() {
        AppMethodBeat.m2504i(26046);
        C43713a c43713a = new C43713a();
        AppMethodBeat.m2505o(26046);
        return c43713a;
    }
}
