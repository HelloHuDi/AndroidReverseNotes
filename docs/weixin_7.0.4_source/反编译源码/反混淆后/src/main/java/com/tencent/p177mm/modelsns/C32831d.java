package com.tencent.p177mm.modelsns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.modelsns.d */
public final class C32831d {
    StringBuffer fQt = new StringBuffer();
    StringBuffer fQu = new StringBuffer();
    private int index = 0;

    public C32831d() {
        AppMethodBeat.m2504i(78618);
        AppMethodBeat.m2505o(78618);
    }

    /* renamed from: k */
    public final void mo53399k(String str, Object obj) {
        AppMethodBeat.m2504i(78619);
        this.fQt.append(this.index + " " + str + "->" + obj + IOUtils.LINE_SEPARATOR_UNIX);
        this.fQu.append(obj);
        this.index++;
        AppMethodBeat.m2505o(78619);
    }

    /* renamed from: l */
    public final void mo53400l(String str, Object obj) {
        AppMethodBeat.m2504i(78620);
        this.fQt.append(str + "->" + obj + IOUtils.LINE_SEPARATOR_UNIX);
        this.fQu.append(obj);
        AppMethodBeat.m2505o(78620);
    }

    public final String toString() {
        AppMethodBeat.m2504i(78621);
        String stringBuffer = this.fQu.toString();
        AppMethodBeat.m2505o(78621);
        return stringBuffer;
    }

    /* renamed from: Fk */
    public final String mo53398Fk() {
        AppMethodBeat.m2504i(78622);
        this.index = 0;
        this.fQt.append("--end--\n\n");
        String stringBuffer = this.fQt.toString();
        AppMethodBeat.m2505o(78622);
        return stringBuffer;
    }
}
