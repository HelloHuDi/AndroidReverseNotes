package com.tencent.p177mm.plugin.nfc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.pluginsdk.C23256o;
import com.tencent.p177mm.pluginsdk.p1337b.C40415c;
import com.tencent.p177mm.pluginsdk.p1337b.C44040b;

/* renamed from: com.tencent.mm.plugin.nfc.Plugin */
public class Plugin implements C40415c {
    public C23256o createApplication() {
        return null;
    }

    public C44040b getContactWidgetFactory() {
        return null;
    }

    public C1816at createSubCore() {
        AppMethodBeat.m2504i(23012);
        C28610a c28610a = new C28610a();
        AppMethodBeat.m2505o(23012);
        return c28610a;
    }
}
