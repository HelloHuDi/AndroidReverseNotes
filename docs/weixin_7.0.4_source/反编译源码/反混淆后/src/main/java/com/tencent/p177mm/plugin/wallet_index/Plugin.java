package com.tencent.p177mm.plugin.wallet_index;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.plugin.wallet_index.p1051a.C14340a;
import com.tencent.p177mm.pluginsdk.C23256o;
import com.tencent.p177mm.pluginsdk.p1337b.C40415c;
import com.tencent.p177mm.pluginsdk.p1337b.C44040b;

/* renamed from: com.tencent.mm.plugin.wallet_index.Plugin */
public final class Plugin implements C40415c {
    public final C23256o createApplication() {
        return null;
    }

    public final C44040b getContactWidgetFactory() {
        return null;
    }

    public final C1816at createSubCore() {
        AppMethodBeat.m2504i(48161);
        C14340a c14340a = new C14340a();
        AppMethodBeat.m2505o(48161);
        return c14340a;
    }
}
