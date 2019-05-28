package p000a.p010i.p011b.p012a.p015c.p035g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.NoSuchElementException;
import p000a.p010i.p011b.p012a.p015c.p035g.C31710d.C31712a;

/* renamed from: a.i.b.a.c.g.p */
class C25162p extends C31710d {
    private int puf = 0;
    /* renamed from: wR */
    protected final byte[] f5019wR;

    /* renamed from: a.i.b.a.c.g.p$a */
    class C25161a implements C31712a {
        private final int limit;
        private int position;

        /* synthetic */ C25161a(C25162p c25162p, byte b) {
            this();
        }

        private C25161a() {
            AppMethodBeat.m2504i(121567);
            this.position = 0;
            this.limit = C25162p.this.size();
            AppMethodBeat.m2505o(121567);
        }

        public final boolean hasNext() {
            return this.position < this.limit;
        }

        public final byte nextByte() {
            AppMethodBeat.m2504i(121568);
            try {
                byte[] bArr = C25162p.this.f5019wR;
                int i = this.position;
                this.position = i + 1;
                byte b = bArr[i];
                AppMethodBeat.m2505o(121568);
                return b;
            } catch (ArrayIndexOutOfBoundsException e) {
                NoSuchElementException noSuchElementException = new NoSuchElementException(e.getMessage());
                AppMethodBeat.m2505o(121568);
                throw noSuchElementException;
            }
        }

        public final void remove() {
            AppMethodBeat.m2504i(121569);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.m2505o(121569);
            throw unsupportedOperationException;
        }

        public final /* synthetic */ Object next() {
            AppMethodBeat.m2504i(121570);
            Byte valueOf = Byte.valueOf(nextByte());
            AppMethodBeat.m2505o(121570);
            return valueOf;
        }
    }

    public /* synthetic */ Iterator iterator() {
        AppMethodBeat.m2504i(121582);
        C31712a ehP = ehP();
        AppMethodBeat.m2505o(121582);
        return ehP;
    }

    C25162p(byte[] bArr) {
        this.f5019wR = bArr;
    }

    /* renamed from: Us */
    public byte mo42027Us(int i) {
        return this.f5019wR[i];
    }

    public int size() {
        return this.f5019wR.length;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: g */
    public void mo42040g(byte[] bArr, int i, int i2, int i3) {
        AppMethodBeat.m2504i(121571);
        System.arraycopy(this.f5019wR, i, bArr, i2, i3);
        AppMethodBeat.m2505o(121571);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final void mo42031b(OutputStream outputStream, int i, int i2) {
        AppMethodBeat.m2504i(121572);
        outputStream.write(this.f5019wR, ehO() + i, i2);
        AppMethodBeat.m2505o(121572);
    }

    public final String toString(String str) {
        AppMethodBeat.m2504i(121573);
        String str2 = new String(this.f5019wR, ehO(), size(), str);
        AppMethodBeat.m2505o(121573);
        return str2;
    }

    public final boolean ehQ() {
        AppMethodBeat.m2504i(121574);
        int ehO = ehO();
        boolean C = C25164y.m39648C(this.f5019wR, ehO, size() + ehO);
        AppMethodBeat.m2505o(121574);
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
    /* renamed from: aR */
    public final int mo42029aR(int i, int i2, int i3) {
        int i4;
        AppMethodBeat.m2504i(121575);
        int ehO = ehO() + i2;
        byte[] bArr = this.f5019wR;
        int i5 = ehO + i3;
        if (i == 0) {
            i4 = ehO;
        } else if (ehO >= i5) {
            AppMethodBeat.m2505o(121575);
            return i;
        } else {
            byte b = (byte) i;
            byte b2;
            int i6;
            if (b < (byte) -32) {
                if (b >= (byte) -62) {
                    i4 = ehO + 1;
                }
                AppMethodBeat.m2505o(121575);
                return -1;
            } else if (b < (byte) -16) {
                b2 = (byte) ((i >> 8) ^ -1);
                if (b2 == (byte) 0) {
                    i6 = ehO + 1;
                    b2 = bArr[ehO];
                    if (i6 >= i5) {
                        i = C25164y.m39654iq(b, b2);
                        AppMethodBeat.m2505o(121575);
                        return i;
                    }
                    ehO = i6;
                }
                if (b2 <= (byte) -65 && ((b != (byte) -32 || b2 >= (byte) -96) && (b != (byte) -19 || b2 < (byte) -96))) {
                    i4 = ehO + 1;
                }
                AppMethodBeat.m2505o(121575);
                return -1;
            } else {
                int i7 = (byte) ((i >> 8) ^ -1);
                b2 = (byte) 0;
                if (i7 == 0) {
                    i6 = ehO + 1;
                    byte b3 = bArr[ehO];
                    if (i6 >= i5) {
                        i = C25164y.m39654iq(b, b3);
                        AppMethodBeat.m2505o(121575);
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
                        i = C25164y.m39653aT(b, i72, b2);
                        AppMethodBeat.m2505o(121575);
                        return i;
                    }
                }
                ehO = i6;
                if (i72 <= -65 && (((b << 28) + (i72 + 112)) >> 30) == 0 && r0 <= (byte) -65) {
                    i4 = ehO + 1;
                }
                AppMethodBeat.m2505o(121575);
                return -1;
            }
        }
        i = C25164y.m39649D(bArr, i4, i5);
        AppMethodBeat.m2505o(121575);
        return i;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(121576);
        boolean a;
        if (obj == this) {
            AppMethodBeat.m2505o(121576);
            return true;
        } else if (!(obj instanceof C31710d)) {
            AppMethodBeat.m2505o(121576);
            return false;
        } else if (size() != ((C31710d) obj).size()) {
            AppMethodBeat.m2505o(121576);
            return false;
        } else if (size() == 0) {
            AppMethodBeat.m2505o(121576);
            return true;
        } else if (obj instanceof C25162p) {
            a = mo42028a((C25162p) obj, 0, size());
            AppMethodBeat.m2505o(121576);
            return a;
        } else if (obj instanceof C41427u) {
            a = obj.equals(this);
            AppMethodBeat.m2505o(121576);
            return a;
        } else {
            String valueOf = String.valueOf(String.valueOf(obj.getClass()));
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder(valueOf.length() + 49).append("Has a new type of ByteString been created? Found ").append(valueOf).toString());
            AppMethodBeat.m2505o(121576);
            throw illegalArgumentException;
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final boolean mo42028a(C25162p c25162p, int i, int i2) {
        AppMethodBeat.m2504i(121577);
        IllegalArgumentException illegalArgumentException;
        if (i2 > c25162p.size()) {
            illegalArgumentException = new IllegalArgumentException("Length too large: " + i2 + size());
            AppMethodBeat.m2505o(121577);
            throw illegalArgumentException;
        } else if (i + i2 > c25162p.size()) {
            illegalArgumentException = new IllegalArgumentException("Ran off end of other: " + i + ", " + i2 + ", " + c25162p.size());
            AppMethodBeat.m2505o(121577);
            throw illegalArgumentException;
        } else {
            byte[] bArr = this.f5019wR;
            byte[] bArr2 = c25162p.f5019wR;
            int ehO = ehO() + i2;
            int ehO2 = ehO();
            int ehO3 = c25162p.ehO() + i;
            while (ehO2 < ehO) {
                if (bArr[ehO2] != bArr2[ehO3]) {
                    AppMethodBeat.m2505o(121577);
                    return false;
                }
                ehO2++;
                ehO3++;
            }
            AppMethodBeat.m2505o(121577);
            return true;
        }
    }

    public int hashCode() {
        AppMethodBeat.m2504i(121578);
        int i = this.puf;
        if (i == 0) {
            i = size();
            i = mo42030aS(i, 0, i);
            if (i == 0) {
                i = 1;
            }
            this.puf = i;
        }
        AppMethodBeat.m2505o(121578);
        return i;
    }

    /* Access modifiers changed, original: protected|final */
    public final int ehV() {
        return this.puf;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: aS */
    public final int mo42030aS(int i, int i2, int i3) {
        AppMethodBeat.m2504i(121579);
        int a = C25162p.m39636a(i, this.f5019wR, ehO() + i2, i3);
        AppMethodBeat.m2505o(121579);
        return a;
    }

    /* renamed from: a */
    private static int m39636a(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    public final C31713e ehR() {
        AppMethodBeat.m2504i(121580);
        C31713e a = C31713e.m51326a(this);
        AppMethodBeat.m2505o(121580);
        return a;
    }

    public C31712a ehP() {
        AppMethodBeat.m2504i(121581);
        C25161a c25161a = new C25161a(this, (byte) 0);
        AppMethodBeat.m2505o(121581);
        return c25161a;
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
