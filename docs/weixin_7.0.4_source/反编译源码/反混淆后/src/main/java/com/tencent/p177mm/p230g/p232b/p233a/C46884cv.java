package com.tencent.p177mm.p230g.p232b.p233a;

import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.cv */
public final class C46884cv extends C46180a {
    public long cTl = 0;
    private String cYD = "";
    public long dim = 0;

    public final int getId() {
        return 15776;
    }

    /* renamed from: hL */
    public final C46884cv mo76077hL(String str) {
        AppMethodBeat.m2504i(61714);
        this.cYD = mo74169t(SearchIntents.EXTRA_QUERY, str, true);
        AppMethodBeat.m2505o(61714);
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(61715);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.dim);
        stringBuffer.append(str);
        stringBuffer.append(this.cTl);
        stringBuffer.append(str);
        stringBuffer.append(this.cYD);
        str = stringBuffer.toString();
        mo74164VX(str);
        AppMethodBeat.m2505o(61715);
        return str;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(61716);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("actionScene:").append(this.dim);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("action:").append(this.cTl);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("query:").append(this.cYD);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(61716);
        return stringBuffer2;
    }
}
