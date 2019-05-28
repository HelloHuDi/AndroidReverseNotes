package com.google.android.exoplayer2.p101c.p104f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p101c.C32041m;
import com.google.android.exoplayer2.p101c.C8662g;
import com.google.android.exoplayer2.p101c.p104f.C37245v.C8661d;
import com.google.android.exoplayer2.p105f.p798a.C45031g;
import com.google.android.exoplayer2.p111i.C32065l;
import com.google.android.exoplayer2.p111i.C45039a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.c.f.s */
final class C17643s {
    private final List<Format> bbD;
    private final C32041m[] bbG;

    public C17643s(List<Format> list) {
        AppMethodBeat.m2504i(95160);
        this.bbD = list;
        this.bbG = new C32041m[list.size()];
        AppMethodBeat.m2505o(95160);
    }

    /* renamed from: a */
    public final void mo32327a(C8662g c8662g, C8661d c8661d) {
        AppMethodBeat.m2504i(95161);
        for (int i = 0; i < this.bbG.length; i++) {
            boolean z;
            c8661d.mo19155rz();
            C32041m dM = c8662g.mo19157dM(c8661d.mo19153rA());
            Format format = (Format) this.bbD.get(i);
            String str = format.aOd;
            if ("application/cea-608".equals(str) || "application/cea-708".equals(str)) {
                z = true;
            } else {
                z = false;
            }
            C45039a.checkArgument(z, "Invalid closed caption mime type provided: ".concat(String.valueOf(str)));
            dM.mo42836f(Format.m15275a(format.f2431id != null ? format.f2431id : c8661d.mo19154rB(), str, format.aOs, format.aOt, format.aOu));
            this.bbG[i] = dM;
        }
        AppMethodBeat.m2505o(95161);
    }

    /* renamed from: a */
    public final void mo32326a(long j, C32065l c32065l) {
        AppMethodBeat.m2504i(95162);
        C45031g.m82526a(j, c32065l, this.bbG);
        AppMethodBeat.m2505o(95162);
    }
}
