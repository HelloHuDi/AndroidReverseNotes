package com.tencent.mm.plugin.appbrand.report;

import com.tencent.mm.sdk.d.c;
import com.tencent.mm.sdk.platformtools.ab;

public abstract class h extends c {
    public void enter() {
        super.enter();
        ab.i("MicroMsg.LoggerState", getName() + " [ENTERING]");
    }

    public void exit() {
        super.exit();
        ab.i("MicroMsg.LoggerState", getName() + " [EXITING]");
    }
}
