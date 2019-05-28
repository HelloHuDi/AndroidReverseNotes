package a.i.b.a.c.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.NoSuchElementException;

class p extends d {
    private int puf = 0;
    protected final byte[] wR;

    class a implements a.i.b.a.c.g.d.a {
        private final int limit;
        private int position;

        /* synthetic */ a(p pVar, byte b) {
            this();
        }

        private a() {
            AppMethodBeat.i(121567);
            this.position = 0;
            this.limit = p.this.size();
            AppMethodBeat.o(121567);
        }

        public final boolean hasNext() {
            return this.position < this.limit;
        }

        public final byte nextByte() {
            AppMethodBeat.i(121568);
            try {
                byte[] bArr = p.this.wR;
                int i = this.position;
                this.position = i + 1;
                byte b = bArr[i];
                AppMethodBeat.o(121568);
                return b;
            } catch (ArrayIndexOutOfBoundsException e) {
                NoSuchElementException noSuchElementException = new NoSuchElementException(e.getMessage());
                AppMethodBeat.o(121568);
                throw noSuchElementException;
            }
        }

        public final void remove() {
            AppMethodBeat.i(121569);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(121569);
            throw unsupportedOperationException;
        }

        public final /* synthetic */ Object next() {
            AppMethodBeat.i(121570);
            Byte valueOf = Byte.valueOf(nextByte());
            AppMethodBeat.o(121570);
            return valueOf;
        }
    }

    public /* synthetic */ Iterator iterator() {
        AppMethodBeat.i(121582);
        a.i.b.a.c.g.d.a ehP = ehP();
        AppMethodBeat.o(121582);
        return ehP;
    }

    p(byte[] bArr) {
        this.wR = bArr;
    }

    public byte Us(int i) {
        return this.wR[i];
    }

    public int size() {
        return this.wR.length;
    }

    /* Access modifiers changed, original: protected */
    public void g(byte[] bArr, int i, int i2, int i3) {
        AppMethodBeat.i(121571);
        System.arraycopy(this.wR, i, bArr, i2, i3);
        AppMethodBeat.o(121571);
    }

    /* Access modifiers changed, original: final */
    public final void b(OutputStream outputStream, int i, int i2) {
        AppMethodBeat.i(121572);
        outputStream.write(this.wR, ehO() + i, i2);
        AppMethodBeat.o(121572);
    }

    public final String toString(String str) {
        AppMethodBeat.i(121573);
        String str2 = new String(this.wR, ehO(), size(), str);
        AppMethodBeat.o(121573);
        return str2;
    }

    public final boolean ehQ() {
        AppMethodBeat.i(121574);
        int ehO = ehO();
        boolean C = y.C(this.wR, ehO, size() + ehO);
        AppMethodBeat.o(121574);
        return C;
    }

    /* Access modifiers changed, original: protected|final */
    /* JADX WARNING: Missing block: B:9:0x002a, code skipped:
            if (r5[r1] > (byte) -65) goto L_0x002c;
     */
    /* JADX WARNING: Missing block: B:26:0x005b, code skipped:
            if (r5[r1] > (byte) -65) goto L_0x005d;
     */
    /* JADX WARNING: Missing block: B:44:0x009e, code skipped:
            if (r5[r1] > (byte) -65) goto L_0x00a0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int aR(int i, int i2, int i3) {
        int i4;
        AppMethodBeat.i(121575);
        int ehO = ehO() + i2;
        byte[] bArr = this.wR;
        int i5 = ehO + i3;
        if (i == 0) {
            i4 = ehO;
        } else if (ehO >= i5) {
            AppMethodBeat.o(121575);
            return i;
        } else {
            byte b = (byte) i;
            byte b2;
            int i6;
            if (b < (byte) -32) {
                if (b >= (byte) -62) {
                    i4 = ehO + 1;
                }
                AppMethodBeat.o(121575);
                return -1;
            } else if (b < (byte) -16) {
                b2 = (byte) ((i >> 8) ^ -1);
                if (b2 == (byte) 0) {
                    i6 = ehO + 1;
                    b2 = bArr[ehO];
                    if (i6 >= i5) {
                        i = y.iq(b, b2);
                        AppMethodBeat.o(121575);
                        return i;
                    }
                    ehO = i6;
                }
                if (b2 <= (byte) -65 && ((b != (byte) -32 || b2 >= (byte) -96) && (b != (byte) -19 || b2 < (byte) -96))) {
                    i4 = ehO + 1;
                }
                AppMethodBeat.o(121575);
                return -1;
            } else {
                int i7 = (byte) ((i >> 8) ^ -1);
                b2 = (byte) 0;
                if (i7 == 0) {
                    i6 = ehO + 1;
                    byte b3 = bArr[ehO];
                    if (i6 >= i5) {
                        i = y.iq(b, b3);
                        AppMethodBeat.o(121575);
                        return i;
                    }
                    byte i72 = b3;
                } else {
                    b2 = (byte) (i >> 16);
                    i6 = ehO;
                }
                if (b2 == (byte) 0) {
                    ehO = i6 + 1;
                    b2 = bArr[i6];
                    if (ehO >= i5) {
                        i = y.aT(b, i72, b2);
                        AppMethodBeat.o(121575);
                        return i;
                    }
                }
                ehO = i6;
                if (i72 <= -65 && (((b << 28) + (i72 + 112)) >> 30) == 0 && r0 <= (byte) -65) {
                    i4 = ehO + 1;
                }
                AppMethodBeat.o(121575);
                return -1;
            }
        }
        i = y.D(bArr, i4, i5);
        AppMethodBeat.o(121575);
        return i;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(121576);
        boolean a;
        if (obj == this) {
            AppMethodBeat.o(121576);
            return true;
        } else if (!(obj instanceof d)) {
            AppMethodBeat.o(121576);
            return false;
        } else if (size() != ((d) obj).size()) {
            AppMethodBeat.o(121576);
            return false;
        } else if (size() == 0) {
            AppMethodBeat.o(121576);
            return true;
        } else if (obj instanceof p) {
            a = a((p) obj, 0, size());
            AppMethodBeat.o(121576);
            return a;
        } else if (obj instanceof u) {
            a = obj.equals(this);
            AppMethodBeat.o(121576);
            return a;
        } else {
            String valueOf = String.valueOf(String.valueOf(obj.getClass()));
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder(valueOf.length() + 49).append("Has a new type of ByteString been created? Found ").append(valueOf).toString());
            AppMethodBeat.o(121576);
            throw illegalArgumentException;
        }
    }

    /* Access modifiers changed, original: final */
    public final boolean a(p pVar, int i, int i2) {
        AppMethodBeat.i(121577);
        IllegalArgumentException illegalArgumentException;
        if (i2 > pVar.size()) {
            illegalArgumentException = new IllegalArgumentException("Length too large: " + i2 + size());
            AppMethodBeat.o(121577);
            throw illegalArgumentException;
        } else if (i + i2 > pVar.size()) {
            illegalArgumentException = new IllegalArgumentException("Ran off end of other: " + i + ", " + i2 + ", " + pVar.size());
            AppMethodBeat.o(121577);
            throw illegalArgumentException;
        } else {
            byte[] bArr = this.wR;
            byte[] bArr2 = pVar.wR;
            int ehO = ehO() + i2;
            int ehO2 = ehO();
            int ehO3 = pVar.ehO() + i;
            while (ehO2 < ehO) {
                if (bArr[ehO2] != bArr2[ehO3]) {
                    AppMethodBeat.o(121577);
                    return false;
                }
                ehO2++;
                ehO3++;
            }
            AppMethodBeat.o(121577);
            return true;
        }
    }

    public int hashCode() {
        AppMethodBeat.i(121578);
        int i = this.puf;
        if (i == 0) {
            i = size();
            i = aS(i, 0, i);
            if (i == 0) {
                i = 1;
            }
            this.puf = i;
        }
        AppMethodBeat.o(121578);
        return i;
    }

    /* Access modifiers changed, original: protected|final */
    public final int ehV() {
        return this.puf;
    }

    /* Access modifiers changed, original: protected|final */
    public final int aS(int i, int i2, int i3) {
        AppMethodBeat.i(121579);
        int a = a(i, this.wR, ehO() + i2, i3);
        AppMethodBeat.o(121579);
        return a;
    }

    private static int a(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    public final e ehR() {
        AppMethodBeat.i(121580);
        e a = e.a(this);
        AppMethodBeat.o(121580);
        return a;
    }

    public a.i.b.a.c.g.d.a ehP() {
        AppMethodBeat.i(121581);
        a aVar = new a(this, (byte) 0);
        AppMethodBeat.o(121581);
        return aVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final int ehT() {
        return 0;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean ehU() {
        return true;
    }

    /* Access modifiers changed, original: protected */
    public int ehO() {
        return 0;
    }
}
