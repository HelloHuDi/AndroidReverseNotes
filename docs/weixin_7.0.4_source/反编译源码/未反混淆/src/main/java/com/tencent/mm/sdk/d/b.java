package com.tencent.mm.sdk.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.Serializable;

public class b extends c implements Serializable {
    public final String name = getClass().getSimpleName();

    public b() {
        AppMethodBeat.i(52444);
        AppMethodBeat.o(52444);
    }

    public void enter() {
        AppMethodBeat.i(52445);
        super.enter();
        ab.i("LogStateTransitionState", "entering " + this.name);
        AppMethodBeat.o(52445);
    }

    public void exit() {
        AppMethodBeat.i(52446);
        super.exit();
        ab.i("LogStateTransitionState", "exiting " + this.name);
        AppMethodBeat.o(52446);
    }
}
