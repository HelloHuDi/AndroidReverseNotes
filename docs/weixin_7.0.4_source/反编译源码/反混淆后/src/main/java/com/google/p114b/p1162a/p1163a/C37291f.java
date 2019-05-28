package com.google.p114b.p1162a.p1163a;

import com.google.p114b.p801b.C8727a;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

/* renamed from: com.google.b.a.a.f */
final class C37291f {
    static final C37291f byy = new C37291f(C45059g.byC, 0, 0, 0);
    final int byA;
    final int byB;
    private final C45059g byz;
    final int mode;

    static {
        AppMethodBeat.m2504i(57303);
        AppMethodBeat.m2505o(57303);
    }

    private C37291f(C45059g c45059g, int i, int i2, int i3) {
        this.byz = c45059g;
        this.mode = i;
        this.byA = i2;
        this.byB = i3;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: bw */
    public final C37291f mo59982bw(int i, int i2) {
        C45059g by;
        AppMethodBeat.m2504i(57297);
        int i3 = this.byB;
        C45059g c45059g = this.byz;
        if (i != this.mode) {
            int i4 = C41635d.bys[this.mode][i];
            i3 += i4 >> 16;
            by = c45059g.mo72811by(CdnLogic.kBizGeneric & i4, i4 >> 16);
        } else {
            by = c45059g;
        }
        int i5 = i == 2 ? 4 : 5;
        C37291f c37291f = new C37291f(by.mo72811by(i2, i5), i, 0, i5 + i3);
        AppMethodBeat.m2505o(57297);
        return c37291f;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: bx */
    public final C37291f mo59983bx(int i, int i2) {
        int i3;
        AppMethodBeat.m2504i(57298);
        C45059g c45059g = this.byz;
        if (this.mode == 2) {
            i3 = 4;
        } else {
            i3 = 5;
        }
        C37291f c37291f = new C37291f(c45059g.mo72811by(C41635d.byu[this.mode][i], i3).mo72811by(i2, 5), this.mode, 0, (i3 + this.byB) + 5);
        AppMethodBeat.m2505o(57298);
        return c37291f;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: fA */
    public final C37291f mo59984fA(int i) {
        C37291f fB;
        AppMethodBeat.m2504i(57299);
        C45059g c45059g = this.byz;
        int i2 = this.mode;
        int i3 = this.byB;
        if (this.mode == 4 || this.mode == 2) {
            i2 = C41635d.bys[i2][0];
            c45059g = c45059g.mo72811by(CdnLogic.kBizGeneric & i2, i2 >> 16);
            i3 += i2 >> 16;
            i2 = 0;
        }
        int i4 = (this.byA == 0 || this.byA == 31) ? 18 : this.byA == 62 ? 9 : 8;
        C37291f c37291f = new C37291f(c45059g, i2, this.byA + 1, i3 + i4);
        if (c37291f.byA == 2078) {
            fB = c37291f.mo59985fB(i + 1);
        } else {
            fB = c37291f;
        }
        AppMethodBeat.m2505o(57299);
        return fB;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: fB */
    public final C37291f mo59985fB(int i) {
        AppMethodBeat.m2504i(57300);
        if (this.byA == 0) {
            AppMethodBeat.m2505o(57300);
            return this;
        }
        C37291f c37291f = new C37291f(this.byz.mo72812bz(i - this.byA, this.byA), this.mode, 0, this.byB);
        AppMethodBeat.m2505o(57300);
        return c37291f;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final boolean mo59981a(C37291f c37291f) {
        int i = this.byB + (C41635d.bys[this.mode][c37291f.mode] >> 16);
        if (c37291f.byA > 0 && (this.byA == 0 || this.byA > c37291f.byA)) {
            i += 10;
        }
        return i <= c37291f.byB;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: r */
    public final C8727a mo59986r(byte[] bArr) {
        AppMethodBeat.m2504i(57301);
        LinkedList<C45059g> linkedList = new LinkedList();
        for (Object obj = mo59985fB(bArr.length).byz; obj != null; obj = obj.byD) {
            linkedList.addFirst(obj);
        }
        C8727a c8727a = new C8727a();
        for (C45059g a : linkedList) {
            a.mo32775a(c8727a, bArr);
        }
        AppMethodBeat.m2505o(57301);
        return c8727a;
    }

    public final String toString() {
        AppMethodBeat.m2504i(57302);
        String format = String.format("%s bits=%d bytes=%d", new Object[]{C41635d.byr[this.mode], Integer.valueOf(this.byB), Integer.valueOf(this.byA)});
        AppMethodBeat.m2505o(57302);
        return format;
    }
}
