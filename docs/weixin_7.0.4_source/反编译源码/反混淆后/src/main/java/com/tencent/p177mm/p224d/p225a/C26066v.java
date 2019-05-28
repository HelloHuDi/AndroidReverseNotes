package com.tencent.p177mm.p224d.p225a;

import com.eclipsesource.p097v8.MultiContextV8;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.d.a.v */
public class C26066v extends C46876a {
    private MultiContextV8 chm;

    C26066v(String str, byte[] bArr) {
        super(str, bArr);
    }

    /* renamed from: CD */
    static C26066v m41604CD() {
        AppMethodBeat.m2504i(113900);
        C26066v c26066v = new C26066v(null, null);
        AppMethodBeat.m2505o(113900);
        return c26066v;
    }

    /* renamed from: k */
    static C26066v m41605k(String str, byte[] bArr) {
        AppMethodBeat.m2504i(113901);
        C26066v c26066v = new C26066v(str, bArr);
        AppMethodBeat.m2505o(113901);
        return c26066v;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: Co */
    public final MultiContextV8 mo43932Co() {
        AppMethodBeat.m2504i(113902);
        this.chm = MultiContextV8.createMultiContextV8(this.chs, this.cht);
        this.cht = null;
        MultiContextV8 multiContextV8 = this.chm;
        AppMethodBeat.m2505o(113902);
        return multiContextV8;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: Cp */
    public C9254d mo43933Cp() {
        AppMethodBeat.m2504i(113903);
        C16537w CE = C16537w.m25411CE();
        AppMethodBeat.m2505o(113903);
        return CE;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: Cq */
    public final void mo43934Cq() {
        AppMethodBeat.m2504i(113904);
        try {
            this.chm.release();
            AppMethodBeat.m2505o(113904);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.V8JSRuntime", "commonCleanUp exp = %s", e);
            AppMethodBeat.m2505o(113904);
        }
    }
}
