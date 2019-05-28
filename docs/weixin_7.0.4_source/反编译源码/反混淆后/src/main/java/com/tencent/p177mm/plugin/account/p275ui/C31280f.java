package com.tencent.p177mm.plugin.account.p275ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelsimple.C6686q;
import com.tencent.p177mm.p612ui.applet.SecurityImage.C15494b;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.account.ui.f */
public final class C31280f extends C15494b {
    private static C31280f gCM = null;
    public String account = null;
    public String gCK = null;
    public int gCL = 0;
    public String guf = null;
    public byte[] gug = null;
    public String guh = null;
    public String gui = null;

    public final void apw() {
        AppMethodBeat.m2504i(125006);
        if (C5046bo.isNullOrNil(this.gCK)) {
            C1720g.m3540Rg().mo14541a(new C6686q(this.account, this.guf, this.yrX.getSecCodeType(), "", "", "", 0, "", false, false), 0);
            AppMethodBeat.m2505o(125006);
            return;
        }
        C1720g.m3540Rg().mo14541a(new C6686q(this.account, this.gCK, this.yrX.getSecCodeType(), "", "", "", 0, "", false, true), 0);
        AppMethodBeat.m2505o(125006);
    }

    /* renamed from: a */
    public static void m50502a(C31280f c31280f) {
        gCM = c31280f;
    }

    public static String ara() {
        if (gCM != null) {
            return gCM.account;
        }
        return null;
    }

    public static String arb() {
        if (gCM != null) {
            return gCM.guf;
        }
        return null;
    }
}
