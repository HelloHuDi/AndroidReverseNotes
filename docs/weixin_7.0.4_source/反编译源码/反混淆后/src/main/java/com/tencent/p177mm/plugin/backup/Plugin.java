package com.tencent.p177mm.plugin.backup;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.pluginsdk.C23256o;
import com.tencent.p177mm.pluginsdk.p1337b.C40415c;
import com.tencent.p177mm.pluginsdk.p1337b.C44040b;

/* renamed from: com.tencent.mm.plugin.backup.Plugin */
public class Plugin implements C40415c {
    public C23256o createApplication() {
        AppMethodBeat.m2504i(17111);
        C42757a c42757a = new C42757a();
        AppMethodBeat.m2505o(17111);
        return c42757a;
    }

    public C44040b getContactWidgetFactory() {
        return null;
    }

    public C1816at createSubCore() {
        return null;
    }
}
