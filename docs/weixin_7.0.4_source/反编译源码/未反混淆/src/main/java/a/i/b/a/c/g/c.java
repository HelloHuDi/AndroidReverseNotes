package a.i.b.a.c.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class c extends p {
    final int Bzn;
    private final int Bzo;

    class a implements a.i.b.a.c.g.d.a {
        private final int limit;
        private int position;

        /* synthetic */ a(c cVar, byte b) {
            this();
        }

        private a() {
            AppMethodBeat.i(121411);
            this.position = c.this.Bzn;
            this.limit = this.position + c.this.size();
            AppMethodBeat.o(121411);
        }

        public final boolean hasNext() {
            return this.position < this.limit;
        }

        public final byte nextByte() {
            AppMethodBeat.i(121412);
            if (this.position >= this.limit) {
                NoSuchElementException noSuchElementException = new NoSuchElementException();
                AppMethodBeat.o(121412);
                throw noSuchElementException;
            }
            byte[] bArr = c.this.wR;
            int i = this.position;
            this.position = i + 1;
            byte b = bArr[i];
            AppMethodBeat.o(121412);
            return b;
        }

        public final void remove() {
            AppMethodBeat.i(121413);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(121413);
            throw unsupportedOperationException;
        }

        public final /* synthetic */ Object next() {
            AppMethodBeat.i(121414);
            Byte valueOf = Byte.valueOf(nextByte());
            AppMethodBeat.o(121414);
            return valueOf;
        }
    }

    public final /* synthetic */ Iterator iterator() {
        AppMethodBeat.i(121419);
        a.i.b.a.c.g.d.a ehP = ehP();
        AppMethodBeat.o(121419);
        return ehP;
    }

    c(byte[] bArr, int i, int i2) {
        super(bArr);
        AppMethodBeat.i(121415);
        IllegalArgumentException illegalArgumentException;
        if (i < 0) {
            illegalArgumentException = new IllegalArgumentException("Offset too small: " + i);
            AppMethodBeat.o(121415);
            throw illegalArgumentException;
        } else if (i2 < 0) {
            illegalArgumentException = new IllegalArgumentException("Length too small: " + i);
            AppMethodBeat.o(121415);
            throw illegalArgumentException;
        } else if (((long) i) + ((long) i2) > ((long) bArr.length)) {
            illegalArgumentException = new IllegalArgumentException("Offset+Length too large: " + i + "+" + i2);
            AppMethodBeat.o(121415);
            throw illegalArgumentException;
        } else {
            this.Bzn = i;
            this.Bzo = i2;
            AppMethodBeat.o(121415);
        }
    }

    public final byte Us(int i) {
        AppMethodBeat.i(121416);
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException;
        if (i < 0) {
            arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException("Index too small: " + i);
            AppMethodBeat.o(121416);
            throw arrayIndexOutOfBoundsException;
        } else if (i >= this.Bzo) {
            arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException("Index too large: " + i + ", " + this.Bzo);
            AppMethodBeat.o(121416);
            throw arrayIndexOutOfBoundsException;
        } else {
            byte b = this.wR[this.Bzn + i];
            AppMethodBeat.o(121416);
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
    public final void g(byte[] bArr, int i, int i2, int i3) {
        AppMethodBeat.i(121417);
        System.arraycopy(this.wR, this.Bzn + i, bArr, i2, i3);
        AppMethodBeat.o(121417);
    }

    public final a.i.b.a.c.g.d.a ehP() {
        AppMethodBeat.i(121418);
        a aVar = new a(this, (byte) 0);
        AppMethodBeat.o(121418);
        return aVar;
    }
}
