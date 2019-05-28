package com.tencent.p177mm.plugin.notification;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.plugin.notification.p477d.C34636f;
import com.tencent.p177mm.pluginsdk.C23256o;
import com.tencent.p177mm.pluginsdk.p1337b.C40415c;
import com.tencent.p177mm.pluginsdk.p1337b.C44040b;

/* renamed from: com.tencent.mm.plugin.notification.Plugin */
public class Plugin implements C40415c {
    C34625a oVv = new C34625a();

    public Plugin() {
        AppMethodBeat.m2504i(23097);
        AppMethodBeat.m2505o(23097);
    }

    public C23256o createApplication() {
        return this.oVv;
    }

    public C44040b getContactWidgetFactory() {
        return null;
    }

    public C1816at createSubCore() {
        AppMethodBeat.m2504i(23098);
        C34636f bWP = C34636f.bWP();
        AppMethodBeat.m2505o(23098);
        return bWP;
    }
}
