package com.tencent.p177mm.plugin.luckymoney;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.plugin.luckymoney.p735b.C6964a;
import com.tencent.p177mm.pluginsdk.C23256o;
import com.tencent.p177mm.pluginsdk.p1337b.C40415c;
import com.tencent.p177mm.pluginsdk.p1337b.C44040b;

/* renamed from: com.tencent.mm.plugin.luckymoney.Plugin */
public final class Plugin implements C40415c {
    public final C23256o createApplication() {
        AppMethodBeat.m2504i(41965);
        C46055a c46055a = new C46055a();
        AppMethodBeat.m2505o(41965);
        return c46055a;
    }

    public final C44040b getContactWidgetFactory() {
        return null;
    }

    public final C1816at createSubCore() {
        AppMethodBeat.m2504i(41966);
        C6964a c6964a = new C6964a();
        AppMethodBeat.m2505o(41966);
        return c6964a;
    }
}
