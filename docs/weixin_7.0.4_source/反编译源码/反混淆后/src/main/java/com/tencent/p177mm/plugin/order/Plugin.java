package com.tencent.p177mm.plugin.order;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.plugin.order.p1007a.C34657b;
import com.tencent.p177mm.pluginsdk.C23256o;
import com.tencent.p177mm.pluginsdk.p1337b.C40415c;
import com.tencent.p177mm.pluginsdk.p1337b.C44040b;

/* renamed from: com.tencent.mm.plugin.order.Plugin */
public class Plugin implements C40415c {
    public C23256o createApplication() {
        return null;
    }

    public C44040b getContactWidgetFactory() {
        return null;
    }

    public C1816at createSubCore() {
        AppMethodBeat.m2504i(43722);
        C34657b c34657b = new C34657b();
        AppMethodBeat.m2505o(43722);
        return c34657b;
    }
}
