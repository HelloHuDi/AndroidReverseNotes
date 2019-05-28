package com.tencent.p177mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.sdk.platformtools.i */
public final class C30294i {
    public static String jvr = "]]>";
    public StringBuffer jvt = new StringBuffer();
    public String xyh = "";

    public C30294i() {
        AppMethodBeat.m2504i(51972);
        AppMethodBeat.m2505o(51972);
    }

    public C30294i(String str) {
        AppMethodBeat.m2504i(51973);
        this.xyh = str;
        m48194Fi(this.xyh);
        AppMethodBeat.m2505o(51973);
    }

    /* renamed from: Fi */
    private void m48194Fi(String str) {
        AppMethodBeat.m2504i(51974);
        this.jvt.append("<" + str + ">");
        AppMethodBeat.m2505o(51974);
    }

    /* renamed from: Fj */
    public final void mo48497Fj(String str) {
        AppMethodBeat.m2504i(51975);
        this.jvt.append("</" + str + ">");
        AppMethodBeat.m2505o(51975);
    }

    private void setText(String str) {
        AppMethodBeat.m2504i(51976);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(51976);
        } else if (str.contains(jvr)) {
            this.jvt.append("<![CDATA[" + C5046bo.ani(str) + "]]>");
            AppMethodBeat.m2505o(51976);
        } else {
            this.jvt.append("<![CDATA[" + str + "]]>");
            AppMethodBeat.m2505o(51976);
        }
    }

    /* renamed from: cY */
    public final void mo48498cY(String str, String str2) {
        AppMethodBeat.m2504i(51977);
        m48194Fi(str);
        setText(str2);
        mo48497Fj(str);
        AppMethodBeat.m2505o(51977);
    }
}
