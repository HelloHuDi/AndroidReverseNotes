package com.tencent.p177mm.plugin.setting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.pluginsdk.C23256o;
import com.tencent.p177mm.pluginsdk.p1337b.C40415c;
import com.tencent.p177mm.pluginsdk.p1337b.C44040b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.setting.Plugin */
public final class Plugin implements C40415c {
    public Plugin() {
        AppMethodBeat.m2504i(126820);
        C4990ab.m7416i("MicroMsg.Plugin.setting", "setting constructor " + System.currentTimeMillis());
        AppMethodBeat.m2505o(126820);
    }

    public final C23256o createApplication() {
        AppMethodBeat.m2504i(126821);
        C4990ab.m7416i("MicroMsg.Plugin.setting", "setting createApplication " + System.currentTimeMillis());
        C24824b c24824b = new C24824b();
        AppMethodBeat.m2505o(126821);
        return c24824b;
    }

    public final C44040b getContactWidgetFactory() {
        AppMethodBeat.m2504i(126822);
        C4990ab.m7416i("MicroMsg.Plugin.setting", "setting getContactWidgetFactory " + System.currentTimeMillis());
        AppMethodBeat.m2505o(126822);
        return null;
    }

    public final C1816at createSubCore() {
        AppMethodBeat.m2504i(126823);
        C4990ab.m7416i("MicroMsg.Plugin.setting", "setting createSubCore " + System.currentTimeMillis());
        C7074c c7074c = new C7074c();
        AppMethodBeat.m2505o(126823);
        return c7074c;
    }
}
