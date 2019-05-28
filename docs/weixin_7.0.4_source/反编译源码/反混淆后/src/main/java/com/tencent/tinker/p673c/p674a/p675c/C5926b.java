package com.tencent.tinker.p673c.p674a.p675c;

import com.tencent.tinker.p668a.p669a.C36548j;
import com.tencent.tinker.p668a.p671b.p1109a.C16320d;
import com.tencent.tinker.p668a.p671b.p1109a.C31089c;
import com.tencent.tinker.p668a.p671b.p1109a.C44547f;
import com.tencent.tinker.p668a.p671b.p1109a.C44548h;
import com.tencent.tinker.p668a.p671b.p1109a.C46812e;
import com.tencent.tinker.p668a.p671b.p1109a.C46813g;
import java.io.EOFException;

/* renamed from: com.tencent.tinker.c.a.c.b */
public final class C5926b {
    final C5920a AAK;

    /* renamed from: com.tencent.tinker.c.a.c.b$a */
    final class C5925a extends C46812e {
        C5925a(C46812e c46812e) {
            super(c46812e);
        }

        /* renamed from: a */
        public final void mo12591a(int i, int i2, int i3, int i4, int i5, long j) {
            super.mo12591a(i, i2, m9226ie(i3, i4), i4, i5, j);
        }

        /* renamed from: a */
        public final void mo12592a(int i, int i2, int i3, int i4, int i5, long j, int i6) {
            super.mo12592a(i, i2, m9226ie(i3, i4), i4, i5, j, i6);
        }

        /* renamed from: a */
        public final void mo12593a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7) {
            super.mo12593a(i, i2, m9226ie(i3, i4), i4, i5, j, i6, i7);
        }

        /* renamed from: a */
        public final void mo12594a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8) {
            super.mo12594a(i, i2, m9226ie(i3, i4), i4, i5, j, i6, i7, i8);
        }

        /* renamed from: a */
        public final void mo12595a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8, int i9) {
            super.mo12595a(i, i2, m9226ie(i3, i4), i4, i5, j, i6, i7, i8, i9);
        }

        /* renamed from: a */
        public final void mo12596a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8, int i9, int i10) {
            super.mo12596a(i, i2, m9226ie(i3, i4), i4, i5, j, i6, i7, i8, i9, i10);
        }

        /* renamed from: b */
        public final void mo12597b(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7) {
            super.mo12597b(i, i2, m9226ie(i3, i4), i4, i5, j, i6, i7);
        }

        /* renamed from: ie */
        private int m9226ie(int i, int i2) {
            switch (i2) {
                case 2:
                    return C5926b.this.AAK.mo12573RM(i);
                case 3:
                    return C5926b.this.AAK.mo12572RL(i);
                case 4:
                    return C5926b.this.AAK.mo12576RP(i);
                case 5:
                    return C5926b.this.AAK.mo12575RO(i);
                default:
                    return i;
            }
        }
    }

    public C5926b(C5920a c5920a) {
        this.AAK = c5920a;
    }

    /* renamed from: a */
    public final short[] mo12598a(short[] sArr) {
        C44548h c44548h = new C44548h(sArr.length);
        C31089c c31089c = new C31089c();
        C44547f c44547f = new C44547f(c44548h, c31089c);
        C16320d c16320d = new C16320d(new C46813g(sArr));
        try {
            c16320d.mo29592a(new C5925a(c31089c));
            c16320d.mo29592a(new C5925a(c44547f));
            int i = c44548h.akp;
            if (i == c44548h.Azg.length) {
                return c44548h.Azg;
            }
            short[] sArr2 = new short[i];
            System.arraycopy(c44548h.Azg, 0, sArr2, 0, i);
            return sArr2;
        } catch (EOFException e) {
            throw new C36548j(e);
        }
    }
}
