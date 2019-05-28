package a.i.b.a.c.g;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

final class u extends d {
    private static final int[] BAh;
    private final int BAi;
    private final d BAj;
    private final d BAk;
    private final int BAl;
    private final int BAm;
    private int puf;

    static class a {
        final Stack<d> BAn;

        private a() {
            AppMethodBeat.i(121583);
            this.BAn = new Stack();
            AppMethodBeat.o(121583);
        }

        /* synthetic */ a(byte b) {
            this();
        }

        /* Access modifiers changed, original: final */
        public final void f(d dVar) {
            AppMethodBeat.i(121584);
            d dVar2 = dVar;
            while (!dVar2.ehU()) {
                if (dVar2 instanceof u) {
                    u uVar = (u) dVar2;
                    f(uVar.BAj);
                    dVar2 = uVar.BAk;
                } else {
                    String valueOf = String.valueOf(String.valueOf(dVar2.getClass()));
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder(valueOf.length() + 49).append("Has a new type of ByteString been created? Found ").append(valueOf).toString());
                    AppMethodBeat.o(121584);
                    throw illegalArgumentException;
                }
            }
            int UD = UD(dVar2.size());
            int i = u.BAh[UD + 1];
            if (this.BAn.isEmpty() || ((d) this.BAn.peek()).size() >= i) {
                this.BAn.push(dVar2);
                AppMethodBeat.o(121584);
                return;
            }
            int i2 = u.BAh[UD];
            d dVar3 = (d) this.BAn.pop();
            while (!this.BAn.isEmpty() && ((d) this.BAn.peek()).size() < i2) {
                dVar3 = new u((d) this.BAn.pop(), dVar3, (byte) 0);
            }
            dVar2 = new u(dVar3, dVar2, (byte) 0);
            while (!this.BAn.isEmpty()) {
                if (((d) this.BAn.peek()).size() >= u.BAh[UD(dVar2.size()) + 1]) {
                    break;
                }
                dVar2 = new u((d) this.BAn.pop(), dVar2, (byte) 0);
            }
            this.BAn.push(dVar2);
            AppMethodBeat.o(121584);
        }

        private static int UD(int i) {
            AppMethodBeat.i(121585);
            int binarySearch = Arrays.binarySearch(u.BAh, i);
            if (binarySearch < 0) {
                binarySearch = (-(binarySearch + 1)) - 1;
            }
            AppMethodBeat.o(121585);
            return binarySearch;
        }
    }

    static class b implements Iterator<p> {
        private final Stack<u> BAo;
        private p BAp;

        /* synthetic */ b(d dVar, byte b) {
            this(dVar);
        }

        public final /* synthetic */ Object next() {
            AppMethodBeat.i(121591);
            p eiD = eiD();
            AppMethodBeat.o(121591);
            return eiD;
        }

        private b(d dVar) {
            AppMethodBeat.i(121586);
            this.BAo = new Stack();
            this.BAp = g(dVar);
            AppMethodBeat.o(121586);
        }

        private p g(d dVar) {
            AppMethodBeat.i(121587);
            d dVar2 = dVar;
            while (dVar2 instanceof u) {
                u uVar = (u) dVar2;
                this.BAo.push(uVar);
                dVar2 = uVar.BAj;
            }
            p pVar = (p) dVar2;
            AppMethodBeat.o(121587);
            return pVar;
        }

        private p eiC() {
            AppMethodBeat.i(121588);
            while (!this.BAo.isEmpty()) {
                Object obj;
                p g = g(((u) this.BAo.pop()).BAk);
                if (g.size() == 0) {
                    obj = 1;
                    continue;
                } else {
                    obj = null;
                    continue;
                }
                if (obj == null) {
                    AppMethodBeat.o(121588);
                    return g;
                }
            }
            AppMethodBeat.o(121588);
            return null;
        }

        public final boolean hasNext() {
            return this.BAp != null;
        }

        public final p eiD() {
            AppMethodBeat.i(121589);
            if (this.BAp == null) {
                NoSuchElementException noSuchElementException = new NoSuchElementException();
                AppMethodBeat.o(121589);
                throw noSuchElementException;
            }
            p pVar = this.BAp;
            this.BAp = eiC();
            AppMethodBeat.o(121589);
            return pVar;
        }

        public final void remove() {
            AppMethodBeat.i(121590);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(121590);
            throw unsupportedOperationException;
        }
    }

    class c implements a.i.b.a.c.g.d.a {
        private final b BAq;
        private a.i.b.a.c.g.d.a BAr;
        int BAs;

        /* synthetic */ c(u uVar, byte b) {
            this();
        }

        private c() {
            AppMethodBeat.i(121592);
            this.BAq = new b(u.this, (byte) 0);
            this.BAr = this.BAq.eiD().ehP();
            this.BAs = u.this.size();
            AppMethodBeat.o(121592);
        }

        public final boolean hasNext() {
            return this.BAs > 0;
        }

        public final byte nextByte() {
            AppMethodBeat.i(121593);
            if (!this.BAr.hasNext()) {
                this.BAr = this.BAq.eiD().ehP();
            }
            this.BAs--;
            byte nextByte = this.BAr.nextByte();
            AppMethodBeat.o(121593);
            return nextByte;
        }

        public final void remove() {
            AppMethodBeat.i(121594);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(121594);
            throw unsupportedOperationException;
        }

        public final /* synthetic */ Object next() {
            AppMethodBeat.i(121595);
            Byte valueOf = Byte.valueOf(nextByte());
            AppMethodBeat.o(121595);
            return valueOf;
        }
    }

    class d extends InputStream {
        private b BAu;
        private p BAv;
        private int BAw;
        private int BAx;
        private int BAy;
        private int mark;

        public d() {
            AppMethodBeat.i(121596);
            initialize();
            AppMethodBeat.o(121596);
        }

        public final int read(byte[] bArr, int i, int i2) {
            AppMethodBeat.i(121597);
            if (bArr == null) {
                NullPointerException nullPointerException = new NullPointerException();
                AppMethodBeat.o(121597);
                throw nullPointerException;
            } else if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
                IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException();
                AppMethodBeat.o(121597);
                throw indexOutOfBoundsException;
            } else {
                int B = B(bArr, i, i2);
                AppMethodBeat.o(121597);
                return B;
            }
        }

        public final long skip(long j) {
            AppMethodBeat.i(121598);
            if (j < 0) {
                IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException();
                AppMethodBeat.o(121598);
                throw indexOutOfBoundsException;
            }
            if (j > 2147483647L) {
                j = 2147483647L;
            }
            long B = (long) B(null, 0, (int) j);
            AppMethodBeat.o(121598);
            return B;
        }

        private int B(byte[] bArr, int i, int i2) {
            AppMethodBeat.i(121599);
            int i3 = i2;
            int i4 = i;
            while (i3 > 0) {
                eiE();
                if (this.BAv == null) {
                    if (i3 == i2) {
                        AppMethodBeat.o(121599);
                        return -1;
                    }
                    i4 = i2 - i3;
                    AppMethodBeat.o(121599);
                    return i4;
                }
                int min = Math.min(this.BAw - this.BAx, i3);
                if (bArr != null) {
                    this.BAv.f(bArr, this.BAx, i4, min);
                    i4 += min;
                }
                this.BAx += min;
                i3 -= min;
            }
            i4 = i2 - i3;
            AppMethodBeat.o(121599);
            return i4;
        }

        public final int read() {
            AppMethodBeat.i(121600);
            eiE();
            if (this.BAv == null) {
                AppMethodBeat.o(121600);
                return -1;
            }
            p pVar = this.BAv;
            int i = this.BAx;
            this.BAx = i + 1;
            int Us = pVar.Us(i) & 255;
            AppMethodBeat.o(121600);
            return Us;
        }

        public final int available() {
            AppMethodBeat.i(121601);
            int size = u.this.size() - (this.BAy + this.BAx);
            AppMethodBeat.o(121601);
            return size;
        }

        public final boolean markSupported() {
            return true;
        }

        public final void mark(int i) {
            this.mark = this.BAy + this.BAx;
        }

        public final synchronized void reset() {
            AppMethodBeat.i(121602);
            initialize();
            B(null, 0, this.mark);
            AppMethodBeat.o(121602);
        }

        private void initialize() {
            AppMethodBeat.i(121603);
            this.BAu = new b(u.this, (byte) 0);
            this.BAv = this.BAu.eiD();
            this.BAw = this.BAv.size();
            this.BAx = 0;
            this.BAy = 0;
            AppMethodBeat.o(121603);
        }

        private void eiE() {
            AppMethodBeat.i(121604);
            if (this.BAv != null && this.BAx == this.BAw) {
                this.BAy += this.BAw;
                this.BAx = 0;
                if (this.BAu.hasNext()) {
                    this.BAv = this.BAu.eiD();
                    this.BAw = this.BAv.size();
                    AppMethodBeat.o(121604);
                    return;
                }
                this.BAv = null;
                this.BAw = 0;
            }
            AppMethodBeat.o(121604);
        }
    }

    /* synthetic */ u(d dVar, d dVar2, byte b) {
        this(dVar, dVar2);
    }

    public final /* synthetic */ Iterator iterator() {
        AppMethodBeat.i(121618);
        a.i.b.a.c.g.d.a ehP = ehP();
        AppMethodBeat.o(121618);
        return ehP;
    }

    static {
        int i;
        AppMethodBeat.i(121619);
        ArrayList arrayList = new ArrayList();
        int i2 = 1;
        int i3 = 1;
        while (i2 > 0) {
            arrayList.add(Integer.valueOf(i2));
            i = i3 + i2;
            i3 = i2;
            i2 = i;
        }
        arrayList.add(Integer.valueOf(BaseClientBuilder.API_PRIORITY_OTHER));
        BAh = new int[arrayList.size()];
        i2 = 0;
        while (true) {
            i = i2;
            if (i < BAh.length) {
                BAh[i] = ((Integer) arrayList.get(i)).intValue();
                i2 = i + 1;
            } else {
                AppMethodBeat.o(121619);
                return;
            }
        }
    }

    private u(d dVar, d dVar2) {
        AppMethodBeat.i(121605);
        this.puf = 0;
        this.BAj = dVar;
        this.BAk = dVar2;
        this.BAl = dVar.size();
        this.BAi = this.BAl + dVar2.size();
        this.BAm = Math.max(dVar.ehT(), dVar2.ehT()) + 1;
        AppMethodBeat.o(121605);
    }

    static d a(d dVar, d dVar2) {
        d dVar3;
        AppMethodBeat.i(121606);
        u uVar = dVar instanceof u ? (u) dVar : null;
        if (dVar2.size() == 0) {
            dVar3 = dVar;
        } else if (dVar.size() != 0) {
            int size = dVar.size() + dVar2.size();
            if (size < 128) {
                dVar3 = b(dVar, dVar2);
            } else if (uVar != null && uVar.BAk.size() + dVar2.size() < 128) {
                dVar3 = new u(uVar.BAj, b(uVar.BAk, dVar2));
            } else if (uVar == null || uVar.BAj.ehT() <= uVar.BAk.ehT() || uVar.BAm <= dVar2.ehT()) {
                if (size >= BAh[Math.max(dVar.ehT(), dVar2.ehT()) + 1]) {
                    dVar3 = new u(dVar, dVar2);
                } else {
                    a aVar = new a();
                    aVar.f(dVar);
                    aVar.f(dVar2);
                    dVar3 = (d) aVar.BAn.pop();
                    while (!aVar.BAn.isEmpty()) {
                        dVar3 = new u((d) aVar.BAn.pop(), dVar3, (byte) 0);
                    }
                }
            } else {
                dVar3 = new u(uVar.BAj, new u(uVar.BAk, dVar2));
            }
        } else {
            dVar3 = dVar2;
        }
        AppMethodBeat.o(121606);
        return dVar3;
    }

    private static p b(d dVar, d dVar2) {
        AppMethodBeat.i(121607);
        int size = dVar.size();
        int size2 = dVar2.size();
        byte[] bArr = new byte[(size + size2)];
        dVar.f(bArr, 0, 0, size);
        dVar2.f(bArr, 0, size, size2);
        p pVar = new p(bArr);
        AppMethodBeat.o(121607);
        return pVar;
    }

    public final int size() {
        return this.BAi;
    }

    /* Access modifiers changed, original: protected|final */
    public final int ehT() {
        return this.BAm;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean ehU() {
        return this.BAi >= BAh[this.BAm];
    }

    /* Access modifiers changed, original: protected|final */
    public final void g(byte[] bArr, int i, int i2, int i3) {
        AppMethodBeat.i(121608);
        if (i + i3 <= this.BAl) {
            this.BAj.g(bArr, i, i2, i3);
            AppMethodBeat.o(121608);
        } else if (i >= this.BAl) {
            this.BAk.g(bArr, i - this.BAl, i2, i3);
            AppMethodBeat.o(121608);
        } else {
            int i4 = this.BAl - i;
            this.BAj.g(bArr, i, i2, i4);
            this.BAk.g(bArr, 0, i2 + i4, i3 - i4);
            AppMethodBeat.o(121608);
        }
    }

    /* Access modifiers changed, original: final */
    public final void b(OutputStream outputStream, int i, int i2) {
        AppMethodBeat.i(121609);
        if (i + i2 <= this.BAl) {
            this.BAj.b(outputStream, i, i2);
            AppMethodBeat.o(121609);
        } else if (i >= this.BAl) {
            this.BAk.b(outputStream, i - this.BAl, i2);
            AppMethodBeat.o(121609);
        } else {
            int i3 = this.BAl - i;
            this.BAj.b(outputStream, i, i3);
            this.BAk.b(outputStream, 0, i2 - i3);
            AppMethodBeat.o(121609);
        }
    }

    public final String toString(String str) {
        AppMethodBeat.i(121610);
        String str2 = new String(toByteArray(), str);
        AppMethodBeat.o(121610);
        return str2;
    }

    public final boolean ehQ() {
        AppMethodBeat.i(121611);
        if (this.BAk.aR(this.BAj.aR(0, 0, this.BAl), 0, this.BAk.size()) == 0) {
            AppMethodBeat.o(121611);
            return true;
        }
        AppMethodBeat.o(121611);
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final int aR(int i, int i2, int i3) {
        AppMethodBeat.i(121612);
        int aR;
        if (i2 + i3 <= this.BAl) {
            aR = this.BAj.aR(i, i2, i3);
            AppMethodBeat.o(121612);
            return aR;
        } else if (i2 >= this.BAl) {
            aR = this.BAk.aR(i, i2 - this.BAl, i3);
            AppMethodBeat.o(121612);
            return aR;
        } else {
            aR = this.BAl - i2;
            aR = this.BAk.aR(this.BAj.aR(i, i2, aR), 0, i3 - aR);
            AppMethodBeat.o(121612);
            return aR;
        }
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(121613);
        if (obj == this) {
            AppMethodBeat.o(121613);
            return true;
        } else if (obj instanceof d) {
            d dVar = (d) obj;
            if (this.BAi != dVar.size()) {
                AppMethodBeat.o(121613);
                return false;
            } else if (this.BAi == 0) {
                AppMethodBeat.o(121613);
                return true;
            } else {
                if (this.puf != 0) {
                    int ehV = dVar.ehV();
                    if (!(ehV == 0 || this.puf == ehV)) {
                        AppMethodBeat.o(121613);
                        return false;
                    }
                }
                int i = 0;
                b bVar = new b(this, (byte) 0);
                p pVar = (p) bVar.next();
                int i2 = 0;
                b bVar2 = new b(dVar, (byte) 0);
                int i3 = 0;
                p pVar2 = (p) bVar2.next();
                p pVar3 = pVar;
                while (true) {
                    int size = pVar3.size() - i;
                    int size2 = pVar2.size() - i2;
                    int min = Math.min(size, size2);
                    if (i == 0 ? pVar3.a(pVar2, i2, min) : pVar2.a(pVar3, i, min)) {
                        int i4 = i3 + min;
                        if (i4 < this.BAi) {
                            if (min == size) {
                                i = 0;
                                pVar3 = (p) bVar.next();
                            } else {
                                i += min;
                            }
                            if (min == size2) {
                                i2 = 0;
                                i3 = i4;
                                pVar2 = (p) bVar2.next();
                            } else {
                                i3 = i4;
                                i2 += min;
                            }
                        } else if (i4 == this.BAi) {
                            AppMethodBeat.o(121613);
                            return true;
                        } else {
                            IllegalStateException illegalStateException = new IllegalStateException();
                            AppMethodBeat.o(121613);
                            throw illegalStateException;
                        }
                    }
                    AppMethodBeat.o(121613);
                    return false;
                }
            }
        } else {
            AppMethodBeat.o(121613);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(121614);
        int i = this.puf;
        if (i == 0) {
            i = aS(this.BAi, 0, this.BAi);
            if (i == 0) {
                i = 1;
            }
            this.puf = i;
        }
        AppMethodBeat.o(121614);
        return i;
    }

    /* Access modifiers changed, original: protected|final */
    public final int ehV() {
        return this.puf;
    }

    /* Access modifiers changed, original: protected|final */
    public final int aS(int i, int i2, int i3) {
        AppMethodBeat.i(121615);
        int aS;
        if (i2 + i3 <= this.BAl) {
            aS = this.BAj.aS(i, i2, i3);
            AppMethodBeat.o(121615);
            return aS;
        } else if (i2 >= this.BAl) {
            aS = this.BAk.aS(i, i2 - this.BAl, i3);
            AppMethodBeat.o(121615);
            return aS;
        } else {
            aS = this.BAl - i2;
            aS = this.BAk.aS(this.BAj.aS(i, i2, aS), 0, i3 - aS);
            AppMethodBeat.o(121615);
            return aS;
        }
    }

    public final e ehR() {
        AppMethodBeat.i(121616);
        e S = e.S(new d());
        AppMethodBeat.o(121616);
        return S;
    }

    public final a.i.b.a.c.g.d.a ehP() {
        AppMethodBeat.i(121617);
        c cVar = new c(this, (byte) 0);
        AppMethodBeat.o(121617);
        return cVar;
    }
}
