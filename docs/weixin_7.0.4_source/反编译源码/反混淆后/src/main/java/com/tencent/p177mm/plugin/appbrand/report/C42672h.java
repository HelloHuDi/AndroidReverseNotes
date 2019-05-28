package com.tencent.p177mm.plugin.appbrand.report;

import com.tencent.p177mm.sdk.p602d.C7292c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.report.h */
public abstract class C42672h extends C7292c {
    public void enter() {
        super.enter();
        C4990ab.m7416i("MicroMsg.LoggerState", getName() + " [ENTERING]");
    }

    public void exit() {
        super.exit();
        C4990ab.m7416i("MicroMsg.LoggerState", getName() + " [EXITING]");
    }
}
