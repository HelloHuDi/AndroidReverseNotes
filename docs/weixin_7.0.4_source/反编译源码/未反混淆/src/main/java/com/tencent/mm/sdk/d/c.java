package com.tencent.mm.sdk.d;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class c implements a {
    protected c() {
    }

    public void enter() {
    }

    public void exit() {
    }

    public boolean k(Message message) {
        return false;
    }

    public String getName() {
        AppMethodBeat.i(52447);
        String name = getClass().getName();
        name = name.substring(name.lastIndexOf(36) + 1);
        AppMethodBeat.o(52447);
        return name;
    }
}
