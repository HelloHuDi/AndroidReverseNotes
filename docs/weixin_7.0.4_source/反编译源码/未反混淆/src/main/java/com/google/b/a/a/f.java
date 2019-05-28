package com.google.b.a.a;

import com.google.b.b.a;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

final class f {
    static final f byy = new f(g.byC, 0, 0, 0);
    final int byA;
    final int byB;
    private final g byz;
    final int mode;

    static {
        AppMethodBeat.i(57303);
        AppMethodBeat.o(57303);
    }

    private f(g gVar, int i, int i2, int i3) {
        this.byz = gVar;
        this.mode = i;
        this.byA = i2;
        this.byB = i3;
    }

    /* Access modifiers changed, original: final */
    public final f bw(int i, int i2) {
        g by;
        AppMethodBeat.i(57297);
        int i3 = this.byB;
        g gVar = this.byz;
        if (i != this.mode) {
            int i4 = d.bys[this.mode][i];
            i3 += i4 >> 16;
            by = gVar.by(CdnLogic.kBizGeneric & i4, i4 >> 16);
        } else {
            by = gVar;
        }
        int i5 = i == 2 ? 4 : 5;
        f fVar = new f(by.by(i2, i5), i, 0, i5 + i3);
        AppMethodBeat.o(57297);
        return fVar;
    }

    /* Access modifiers changed, original: final */
    public final f bx(int i, int i2) {
        int i3;
        AppMethodBeat.i(57298);
        g gVar = this.byz;
        if (this.mode == 2) {
            i3 = 4;
        } else {
            i3 = 5;
        }
        f fVar = new f(gVar.by(d.byu[this.mode][i], i3).by(i2, 5), this.mode, 0, (i3 + this.byB) + 5);
        AppMethodBeat.o(57298);
        return fVar;
    }

    /* Access modifiers changed, original: final */
    public final f fA(int i) {
        f fB;
        AppMethodBeat.i(57299);
        g gVar = this.byz;
        int i2 = this.mode;
        int i3 = this.byB;
        if (this.mode == 4 || this.mode == 2) {
            i2 = d.bys[i2][0];
            gVar = gVar.by(CdnLogic.kBizGeneric & i2, i2 >> 16);
            i3 += i2 >> 16;
            i2 = 0;
        }
        int i4 = (this.byA == 0 || this.byA == 31) ? 18 : this.byA == 62 ? 9 : 8;
        f fVar = new f(gVar, i2, this.byA + 1, i3 + i4);
        if (fVar.byA == 2078) {
            fB = fVar.fB(i + 1);
        } else {
            fB = fVar;
        }
        AppMethodBeat.o(57299);
        return fB;
    }

    /* Access modifiers changed, original: final */
    public final f fB(int i) {
        AppMethodBeat.i(57300);
        if (this.byA == 0) {
            AppMethodBeat.o(57300);
            return this;
        }
        f fVar = new f(this.byz.bz(i - this.byA, this.byA), this.mode, 0, this.byB);
        AppMethodBeat.o(57300);
        return fVar;
    }

    /* Access modifiers changed, original: final */
    public final boolean a(f fVar) {
        int i = this.byB + (d.bys[this.mode][fVar.mode] >> 16);
        if (fVar.byA > 0 && (this.byA == 0 || this.byA > fVar.byA)) {
            i += 10;
        }
        return i <= fVar.byB;
    }

    /* Access modifiers changed, original: final */
    public final a r(byte[] bArr) {
        AppMethodBeat.i(57301);
        LinkedList<g> linkedList = new LinkedList();
        for (Object obj = fB(bArr.length).byz; obj != null; obj = obj.byD) {
            linkedList.addFirst(obj);
        }
        a aVar = new a();
        for (g a : linkedList) {
            a.a(aVar, bArr);
        }
        AppMethodBeat.o(57301);
        return aVar;
    }

    public final String toString() {
        AppMethodBeat.i(57302);
        String format = String.format("%s bits=%d bytes=%d", new Object[]{d.byr[this.mode], Integer.valueOf(this.byB), Integer.valueOf(this.byA)});
        AppMethodBeat.o(57302);
        return format;
    }
}
