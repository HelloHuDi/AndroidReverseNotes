package com.tencent.p177mm.plugin.mmsight;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.pluginsdk.C23256o;
import com.tencent.p177mm.pluginsdk.p1337b.C40415c;
import com.tencent.p177mm.pluginsdk.p1337b.C44040b;

/* renamed from: com.tencent.mm.plugin.mmsight.Plugin */
public class Plugin implements C40415c {
    public C23256o createApplication() {
        AppMethodBeat.m2504i(76425);
        C34540b c34540b = new C34540b();
        AppMethodBeat.m2505o(76425);
        return c34540b;
    }

    public C44040b getContactWidgetFactory() {
        return null;
    }

    public C1816at createSubCore() {
        return null;
    }
}
