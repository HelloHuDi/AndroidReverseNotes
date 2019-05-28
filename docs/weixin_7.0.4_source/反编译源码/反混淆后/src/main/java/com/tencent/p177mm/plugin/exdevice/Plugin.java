package com.tencent.p177mm.plugin.exdevice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.plugin.exdevice.model.C45891ad;
import com.tencent.p177mm.pluginsdk.C23256o;
import com.tencent.p177mm.pluginsdk.p1337b.C40415c;
import com.tencent.p177mm.pluginsdk.p1337b.C44040b;

/* renamed from: com.tencent.mm.plugin.exdevice.Plugin */
public class Plugin implements C40415c {
    public C23256o createApplication() {
        AppMethodBeat.m2504i(19033);
        C45875a c45875a = new C45875a();
        AppMethodBeat.m2505o(19033);
        return c45875a;
    }

    public C44040b getContactWidgetFactory() {
        return null;
    }

    public C1816at createSubCore() {
        AppMethodBeat.m2504i(19034);
        C45891ad c45891ad = new C45891ad();
        AppMethodBeat.m2505o(19034);
        return c45891ad;
    }
}
