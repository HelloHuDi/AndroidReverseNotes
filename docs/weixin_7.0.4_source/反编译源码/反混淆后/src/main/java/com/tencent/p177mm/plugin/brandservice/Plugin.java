package com.tencent.p177mm.plugin.brandservice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.pluginsdk.C23256o;
import com.tencent.p177mm.pluginsdk.p1337b.C40415c;
import com.tencent.p177mm.pluginsdk.p1337b.C44040b;

/* renamed from: com.tencent.mm.plugin.brandservice.Plugin */
public class Plugin implements C40415c {
    public C23256o createApplication() {
        AppMethodBeat.m2504i(13800);
        C33720b c33720b = new C33720b();
        AppMethodBeat.m2505o(13800);
        return c33720b;
    }

    public C44040b getContactWidgetFactory() {
        return null;
    }

    public C1816at createSubCore() {
        return null;
    }
}
