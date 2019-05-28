package com.tencent.p177mm.plugin.ipcall;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.plugin.ipcall.p438a.C21088i;
import com.tencent.p177mm.pluginsdk.C23256o;
import com.tencent.p177mm.pluginsdk.p1337b.C40415c;
import com.tencent.p177mm.pluginsdk.p1337b.C44040b;

/* renamed from: com.tencent.mm.plugin.ipcall.Plugin */
public class Plugin implements C40415c {
    C39265b nvj = new C39265b();

    public Plugin() {
        AppMethodBeat.m2504i(21703);
        AppMethodBeat.m2505o(21703);
    }

    public C23256o createApplication() {
        return this.nvj;
    }

    public C44040b getContactWidgetFactory() {
        return null;
    }

    public C1816at createSubCore() {
        AppMethodBeat.m2504i(21704);
        C21088i bHp = C21088i.bHp();
        AppMethodBeat.m2505o(21704);
        return bHp;
    }
}
