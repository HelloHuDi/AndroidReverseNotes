package com.tencent.p177mm.plugin.expt.hellhound.core.stack;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.expt.hellhound.core.stack.a */
public enum C45901a {
    CREATE(0),
    RESUME(1),
    PAUSE(2),
    STOP(3),
    DESTROY(4);
    
    int value;

    static {
        AppMethodBeat.m2505o(73357);
    }

    private C45901a(int i) {
        this.value = i;
    }
}
