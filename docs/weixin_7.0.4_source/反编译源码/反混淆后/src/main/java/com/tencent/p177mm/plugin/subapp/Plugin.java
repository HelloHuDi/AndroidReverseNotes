package com.tencent.p177mm.plugin.subapp;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.pluginsdk.C23256o;
import com.tencent.p177mm.pluginsdk.p1337b.C40415c;
import com.tencent.p177mm.pluginsdk.p1337b.C44040b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.subapp.Plugin */
public final class Plugin implements C40415c {
    public Plugin() {
        AppMethodBeat.m2504i(25153);
        C4990ab.m7416i("MicroMsg.Plugin.subapp", "subapp constructor " + System.currentTimeMillis());
        AppMethodBeat.m2505o(25153);
    }

    public final C23256o createApplication() {
        AppMethodBeat.m2504i(25154);
        C4990ab.m7416i("MicroMsg.Plugin.subapp", "subapp createApplication " + System.currentTimeMillis());
        C24837b c24837b = new C24837b();
        AppMethodBeat.m2505o(25154);
        return c24837b;
    }

    public final C44040b getContactWidgetFactory() {
        AppMethodBeat.m2504i(25155);
        C4990ab.m7416i("MicroMsg.Plugin.subapp", "subapp getContactWidgetFactory " + System.currentTimeMillis());
        AppMethodBeat.m2505o(25155);
        return null;
    }

    public final C1816at createSubCore() {
        AppMethodBeat.m2504i(25156);
        C4990ab.m7416i("MicroMsg.Plugin.subapp", "subapp createSubCore " + System.currentTimeMillis());
        C22330a c22330a = new C22330a();
        AppMethodBeat.m2505o(25156);
        return c22330a;
    }
}
