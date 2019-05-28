package p000a.p010i.p011b.p012a.p015c.p035g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;
import p000a.p010i.p011b.p012a.p015c.p035g.C31710d.C31712a;

/* renamed from: a.i.b.a.c.g.c */
final class C31709c extends C25162p {
    final int Bzn;
    private final int Bzo;

    /* renamed from: a.i.b.a.c.g.c$a */
    class C17265a implements C31712a {
        private final int limit;
        private int position;

        /* synthetic */ C17265a(C31709c c31709c, byte b) {
            this();
        }

        private C17265a() {
            AppMethodBeat.m2504i(121411);
            this.position = C31709c.this.Bzn;
            this.limit = this.position + C31709c.this.size();
            AppMethodBeat.m2505o(121411);
        }

        public final boolean hasNext() {
            return this.position < this.limit;
        }

        public final byte nextByte() {
            AppMethodBeat.m2504i(121412);
            if (this.position >= this.limit) {
                NoSuchElementException noSuchElementException = new NoSuchElementException();
                AppMethodBeat.m2505o(121412);
                throw noSuchElementException;
            }
            byte[] bArr = C31709c.this.f5019wR;
            int i = this.position;
            this.position = i + 1;
            byte b = bArr[i];
            AppMethodBeat.m2505o(121412);
            return b;
        }

        public final void remove() {
            AppMethodBeat.m2504i(121413);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.m2505o(121413);
            throw unsupportedOperationException;
        }

        public final /* synthetic */ Object next() {
            AppMethodBeat.m2504i(121414);
            Byte valueOf = Byte.valueOf(nextByte());
            AppMethodBeat.m2505o(121414);
            return valueOf;
        }
    }

    public final /* synthetic */ Iterator iterator() {
        AppMethodBeat.m2504i(121419);
        C31712a ehP = ehP();
        AppMethodBeat.m2505o(121419);
        return ehP;
    }

    C31709c(byte[] bArr, int i, int i2) {
        super(bArr);
        AppMethodBeat.m2504i(121415);
        IllegalArgumentException illegalArgumentException;
        if (i < 0) {
            illegalArgumentException = new IllegalArgumentException("Offset too small: " + i);
            AppMethodBeat.m2505o(121415);
            throw illegalArgumentException;
        } else if (i2 < 0) {
            illegalArgumentException = new IllegalArgumentException("Length too small: " + i);
            AppMethodBeat.m2505o(121415);
            throw illegalArgumentException;
        } else if (((long) i) + ((long) i2) > ((long) bArr.length)) {
            illegalArgumentException = new IllegalArgumentException("Offset+Length too large: " + i + "+" + i2);
            AppMethodBeat.m2505o(121415);
            throw illegalArgumentException;
        } else {
            this.Bzn = i;
            this.Bzo = i2;
            AppMethodBeat.m2505o(121415);
        }
    }

    /* renamed from: Us */
    public final byte mo42027Us(int i) {
        AppMethodBeat.m2504i(121416);
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException;
        if (i < 0) {
            arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException("Index too small: " + i);
            AppMethodBeat.m2505o(121416);
            throw arrayIndexOutOfBoundsException;
        } else if (i >= this.Bzo) {
            arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException("Index too large: " + i + ", " + this.Bzo);
            AppMethodBeat.m2505o(121416);
            throw arrayIndexOutOfBoundsException;
        } else {
            byte b = this.f5019wR[this.Bzn + i];
            AppMethodBeat.m2505o(121416);
            return b;
        }
    }

    public final int size() {
        return this.Bzo;
    }

    /* Access modifiers changed, original: protected|final */
    public final int ehO() {
        return this.Bzn;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: g */
    public final void mo42040g(byte[] bArr, int i, int i2, int i3) {
        AppMethodBeat.m2504i(121417);
        System.arraycopy(this.f5019wR, this.Bzn + i, bArr, i2, i3);
        AppMethodBeat.m2505o(121417);
    }

    public final C31712a ehP() {
        AppMethodBeat.m2504i(121418);
        C17265a c17265a = new C17265a(this, (byte) 0);
        AppMethodBeat.m2505o(121418);
        return c17265a;
    }
}
