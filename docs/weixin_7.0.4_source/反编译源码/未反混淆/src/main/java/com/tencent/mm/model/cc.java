package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashSet;
import java.util.Set;

public final class cc {
    public Set<a> fnN = new HashSet();
    public boolean isRunning = false;

    public interface a {
        boolean aaG();
    }

    public cc() {
        AppMethodBeat.i(58142);
        AppMethodBeat.o(58142);
    }

    public final boolean a(a aVar) {
        AppMethodBeat.i(58143);
        if (this.isRunning) {
            ab.e("MicroMsg.UninitForUEH", "add , is running , forbid add");
            AppMethodBeat.o(58143);
            return false;
        }
        boolean add = this.fnN.add(aVar);
        AppMethodBeat.o(58143);
        return add;
    }

    public final boolean b(a aVar) {
        AppMethodBeat.i(58144);
        if (this.isRunning) {
            ab.e("MicroMsg.UninitForUEH", "remove , is running , forbid remove");
            AppMethodBeat.o(58144);
            return false;
        }
        boolean remove = this.fnN.remove(aVar);
        AppMethodBeat.o(58144);
        return remove;
    }
}
