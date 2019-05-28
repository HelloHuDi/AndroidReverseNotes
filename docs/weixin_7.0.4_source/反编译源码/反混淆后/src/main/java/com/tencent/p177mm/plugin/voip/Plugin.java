package com.tencent.p177mm.plugin.voip;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.pluginsdk.C23256o;
import com.tencent.p177mm.pluginsdk.p1337b.C40415c;
import com.tencent.p177mm.pluginsdk.p1337b.C44040b;

/* renamed from: com.tencent.mm.plugin.voip.Plugin */
public final class Plugin implements C40415c {
    public final C23256o createApplication() {
        AppMethodBeat.m2504i(4305);
        C43728c c43728c = new C43728c();
        AppMethodBeat.m2505o(4305);
        return c43728c;
    }

    public final C44040b getContactWidgetFactory() {
        return null;
    }

    public final C1816at createSubCore() {
        AppMethodBeat.m2504i(4306);
        C43727b c43727b = new C43727b();
        AppMethodBeat.m2505o(4306);
        return c43727b;
    }
}
