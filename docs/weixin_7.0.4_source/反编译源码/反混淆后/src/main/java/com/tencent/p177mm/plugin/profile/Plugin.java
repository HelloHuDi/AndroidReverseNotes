package com.tencent.p177mm.plugin.profile;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.pluginsdk.C23256o;
import com.tencent.p177mm.pluginsdk.p1337b.C40415c;
import com.tencent.p177mm.pluginsdk.p1337b.C44040b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.profile.Plugin */
public final class Plugin implements C40415c {
    public Plugin() {
        AppMethodBeat.m2504i(23239);
        C4990ab.m7416i("MicroMsg.Plugin.profile", "profile constructor " + System.currentTimeMillis());
        AppMethodBeat.m2505o(23239);
    }

    public final C23256o createApplication() {
        AppMethodBeat.m2504i(23240);
        C4990ab.m7416i("MicroMsg.Plugin.profile", "profile createApplication " + System.currentTimeMillis());
        C39503b c39503b = new C39503b();
        AppMethodBeat.m2505o(23240);
        return c39503b;
    }

    public final C44040b getContactWidgetFactory() {
        AppMethodBeat.m2504i(23241);
        C4990ab.m7416i("MicroMsg.Plugin.profile", "profile getContactWidgetFactory " + System.currentTimeMillis());
        AppMethodBeat.m2505o(23241);
        return null;
    }

    public final C1816at createSubCore() {
        AppMethodBeat.m2504i(23242);
        C4990ab.m7416i("MicroMsg.Plugin.profile", "profile createSubCore " + System.currentTimeMillis());
        C34696c c34696c = new C34696c();
        AppMethodBeat.m2505o(23242);
        return c34696c;
    }
}
