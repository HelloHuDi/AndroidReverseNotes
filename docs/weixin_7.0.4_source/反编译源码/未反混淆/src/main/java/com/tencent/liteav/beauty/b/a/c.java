package com.tencent.liteav.beauty.b.a;

import com.tencent.liteav.basic.e.g;
import com.tencent.liteav.beauty.NativeLoad;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class c extends g {
    public boolean a() {
        AppMethodBeat.i(66950);
        NativeLoad.getInstance();
        this.a = NativeLoad.nativeLoadGLProgram(6);
        if (this.a == 0 || !b()) {
            this.g = false;
        } else {
            this.g = true;
        }
        c();
        boolean z = this.g;
        AppMethodBeat.o(66950);
        return z;
    }
}
