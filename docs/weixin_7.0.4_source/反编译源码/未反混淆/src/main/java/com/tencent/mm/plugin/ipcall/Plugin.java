package com.tencent.mm.plugin.ipcall;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;

public class Plugin implements c {
    b nvj = new b();

    public Plugin() {
        AppMethodBeat.i(21703);
        AppMethodBeat.o(21703);
    }

    public o createApplication() {
        return this.nvj;
    }

    public b getContactWidgetFactory() {
        return null;
    }

    public at createSubCore() {
        AppMethodBeat.i(21704);
        i bHp = i.bHp();
        AppMethodBeat.o(21704);
        return bHp;
    }
}
