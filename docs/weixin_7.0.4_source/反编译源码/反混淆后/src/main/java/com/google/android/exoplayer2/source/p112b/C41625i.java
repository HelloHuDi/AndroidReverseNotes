package com.google.android.exoplayer2.source.p112b;

import com.google.android.exoplayer2.C8692k;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p100b.C32022e;
import com.google.android.exoplayer2.source.C17688l;
import com.google.android.exoplayer2.source.C25560k;
import com.google.android.exoplayer2.source.C37271a.C8705a;
import com.google.android.exoplayer2.source.C37271a.C8705a.C87105;
import com.google.android.exoplayer2.source.C37282j;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.android.exoplayer2.source.b.i */
final class C41625i implements C17688l {
    public final int bjl;
    private final C41626j bjm;

    public C41625i(C41626j c41626j, int i) {
        this.bjm = c41626j;
        this.bjl = i;
    }

    public final boolean isReady() {
        AppMethodBeat.m2504i(125937);
        C41626j c41626j = this.bjm;
        int i = this.bjl;
        if (c41626j.bhc || (!c41626j.mo66760sd() && c41626j.bgO[i].bhG.mo59540sk())) {
            AppMethodBeat.m2505o(125937);
            return true;
        }
        AppMethodBeat.m2505o(125937);
        return false;
    }

    /* renamed from: rW */
    public final void mo19295rW() {
        AppMethodBeat.m2504i(125938);
        this.bjm.bjo.mo59520rW();
        AppMethodBeat.m2505o(125938);
    }

    /* renamed from: b */
    public final int mo19293b(C8692k c8692k, C32022e c32022e, boolean z) {
        AppMethodBeat.m2504i(125939);
        C41626j c41626j = this.bjm;
        int i = this.bjl;
        if (c41626j.mo66760sd()) {
            AppMethodBeat.m2505o(125939);
            return -3;
        }
        int i2;
        if (!c41626j.bjr.isEmpty()) {
            int i3;
            while (c41626j.bjr.size() > 1) {
                Object obj;
                i3 = ((C25556f) c41626j.bjr.getFirst()).uid;
                for (i2 = 0; i2 < c41626j.bgO.length; i2++) {
                    if (c41626j.bjw[i2]) {
                        int i4;
                        C37282j c37282j = c41626j.bgO[i2].bhG;
                        int ep = c37282j.mo59531ep(c37282j.bhy);
                        if (c37282j.mo59540sk()) {
                            i4 = c37282j.bht[ep];
                        } else {
                            i4 = c37282j.bhE;
                        }
                        if (i4 == i3) {
                            obj = null;
                            break;
                        }
                    }
                }
                i2 = 1;
                if (obj == null) {
                    break;
                }
                c41626j.bjr.removeFirst();
            }
            C25556f c25556f = (C25556f) c41626j.bjr.getFirst();
            Format format = c25556f.bic;
            if (!format.equals(c41626j.bjs)) {
                C8705a c8705a = c41626j.bjc;
                int i5 = c41626j.aMr;
                i3 = c25556f.bid;
                Object obj2 = c25556f.bie;
                long j = c25556f.bif;
                if (c8705a.bfZ != null) {
                    c8705a.handler.post(new C87105(i5, format, i3, obj2, j));
                }
            }
            c41626j.bjs = format;
        }
        i2 = c41626j.bgO[i].mo42833a(c8692k, c32022e, z, c41626j.bhc, c41626j.bgZ);
        AppMethodBeat.m2505o(125939);
        return i2;
    }

    /* renamed from: Z */
    public final void mo19292Z(long j) {
        AppMethodBeat.m2504i(125940);
        C41626j c41626j = this.bjm;
        C25560k c25560k = c41626j.bgO[this.bjl];
        if (!c41626j.bhc || j <= c25560k.bhG.mo59537sc()) {
            c25560k.mo42837g(j, true);
            AppMethodBeat.m2505o(125940);
            return;
        }
        c25560k.bhG.mo59542sm();
        AppMethodBeat.m2505o(125940);
    }
}
