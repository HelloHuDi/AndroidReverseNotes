package com.tencent.p177mm.plugin.voiceprint;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.plugin.voiceprint.model.C22446k;
import com.tencent.p177mm.plugin.voiceprint.p1508a.C35340a;
import com.tencent.p177mm.pluginsdk.C23256o;
import com.tencent.p177mm.pluginsdk.p1337b.C40415c;
import com.tencent.p177mm.pluginsdk.p1337b.C44040b;

/* renamed from: com.tencent.mm.plugin.voiceprint.Plugin */
public class Plugin implements C40415c {
    public C23256o createApplication() {
        AppMethodBeat.m2504i(26073);
        C35340a c35340a = new C35340a();
        AppMethodBeat.m2505o(26073);
        return c35340a;
    }

    public C44040b getContactWidgetFactory() {
        return null;
    }

    public C1816at createSubCore() {
        AppMethodBeat.m2504i(26074);
        C22446k c22446k = new C22446k();
        AppMethodBeat.m2505o(26074);
        return c22446k;
    }
}
