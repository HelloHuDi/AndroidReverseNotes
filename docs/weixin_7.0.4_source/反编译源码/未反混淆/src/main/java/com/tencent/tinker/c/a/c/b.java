package com.tencent.tinker.c.a.c;

import com.tencent.tinker.a.a.j;
import com.tencent.tinker.a.b.a.c;
import com.tencent.tinker.a.b.a.d;
import com.tencent.tinker.a.b.a.e;
import com.tencent.tinker.a.b.a.f;
import com.tencent.tinker.a.b.a.g;
import com.tencent.tinker.a.b.a.h;
import java.io.EOFException;

public final class b {
    final a AAK;

    final class a extends e {
        a(e eVar) {
            super(eVar);
        }

        public final void a(int i, int i2, int i3, int i4, int i5, long j) {
            super.a(i, i2, ie(i3, i4), i4, i5, j);
        }

        public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6) {
            super.a(i, i2, ie(i3, i4), i4, i5, j, i6);
        }

        public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7) {
            super.a(i, i2, ie(i3, i4), i4, i5, j, i6, i7);
        }

        public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8) {
            super.a(i, i2, ie(i3, i4), i4, i5, j, i6, i7, i8);
        }

        public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8, int i9) {
            super.a(i, i2, ie(i3, i4), i4, i5, j, i6, i7, i8, i9);
        }

        public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8, int i9, int i10) {
            super.a(i, i2, ie(i3, i4), i4, i5, j, i6, i7, i8, i9, i10);
        }

        public final void b(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7) {
            super.b(i, i2, ie(i3, i4), i4, i5, j, i6, i7);
        }

        private int ie(int i, int i2) {
            switch (i2) {
                case 2:
                    return b.this.AAK.RM(i);
                case 3:
                    return b.this.AAK.RL(i);
                case 4:
                    return b.this.AAK.RP(i);
                case 5:
                    return b.this.AAK.RO(i);
                default:
                    return i;
            }
        }
    }

    public b(a aVar) {
        this.AAK = aVar;
    }

    public final short[] a(short[] sArr) {
        h hVar = new h(sArr.length);
        c cVar = new c();
        f fVar = new f(hVar, cVar);
        d dVar = new d(new g(sArr));
        try {
            dVar.a(new a(cVar));
            dVar.a(new a(fVar));
            int i = hVar.akp;
            if (i == hVar.Azg.length) {
                return hVar.Azg;
            }
            short[] sArr2 = new short[i];
            System.arraycopy(hVar.Azg, 0, sArr2, 0, i);
            return sArr2;
        } catch (EOFException e) {
            throw new j(e);
        }
    }
}
