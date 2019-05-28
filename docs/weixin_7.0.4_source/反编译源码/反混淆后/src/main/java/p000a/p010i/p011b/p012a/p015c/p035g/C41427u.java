package p000a.p010i.p011b.p012a.p015c.p035g;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;
import p000a.p010i.p011b.p012a.p015c.p035g.C31710d.C31712a;

/* renamed from: a.i.b.a.c.g.u */
final class C41427u extends C31710d {
    private static final int[] BAh;
    private final int BAi;
    private final C31710d BAj;
    private final C31710d BAk;
    private final int BAl;
    private final int BAm;
    private int puf;

    /* renamed from: a.i.b.a.c.g.u$a */
    static class C0120a {
        final Stack<C31710d> BAn;

        private C0120a() {
            AppMethodBeat.m2504i(121583);
            this.BAn = new Stack();
            AppMethodBeat.m2505o(121583);
        }

        /* synthetic */ C0120a(byte b) {
            this();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: f */
        public final void mo193f(C31710d c31710d) {
            AppMethodBeat.m2504i(121584);
            C31710d c31710d2 = c31710d;
            while (!c31710d2.ehU()) {
                if (c31710d2 instanceof C41427u) {
                    C41427u c41427u = (C41427u) c31710d2;
                    mo193f(c41427u.BAj);
                    c31710d2 = c41427u.BAk;
                } else {
                    String valueOf = String.valueOf(String.valueOf(c31710d2.getClass()));
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder(valueOf.length() + 49).append("Has a new type of ByteString been created? Found ").append(valueOf).toString());
                    AppMethodBeat.m2505o(121584);
                    throw illegalArgumentException;
                }
            }
            int UD = C0120a.m234UD(c31710d2.size());
            int i = C41427u.BAh[UD + 1];
            if (this.BAn.isEmpty() || ((C31710d) this.BAn.peek()).size() >= i) {
                this.BAn.push(c31710d2);
                AppMethodBeat.m2505o(121584);
                return;
            }
            int i2 = C41427u.BAh[UD];
            C31710d c31710d3 = (C31710d) this.BAn.pop();
            while (!this.BAn.isEmpty() && ((C31710d) this.BAn.peek()).size() < i2) {
                c31710d3 = new C41427u((C31710d) this.BAn.pop(), c31710d3, (byte) 0);
            }
            c31710d2 = new C41427u(c31710d3, c31710d2, (byte) 0);
            while (!this.BAn.isEmpty()) {
                if (((C31710d) this.BAn.peek()).size() >= C41427u.BAh[C0120a.m234UD(c31710d2.size()) + 1]) {
                    break;
                }
                c31710d2 = new C41427u((C31710d) this.BAn.pop(), c31710d2, (byte) 0);
            }
            this.BAn.push(c31710d2);
            AppMethodBeat.m2505o(121584);
        }

        /* renamed from: UD */
        private static int m234UD(int i) {
            AppMethodBeat.m2504i(121585);
            int binarySearch = Arrays.binarySearch(C41427u.BAh, i);
            if (binarySearch < 0) {
                binarySearch = (-(binarySearch + 1)) - 1;
            }
            AppMethodBeat.m2505o(121585);
            return binarySearch;
        }
    }

    /* renamed from: a.i.b.a.c.g.u$b */
    static class C8187b implements Iterator<C25162p> {
        private final Stack<C41427u> BAo;
        private C25162p BAp;

        /* synthetic */ C8187b(C31710d c31710d, byte b) {
            this(c31710d);
        }

        public final /* synthetic */ Object next() {
            AppMethodBeat.m2504i(121591);
            C25162p eiD = eiD();
            AppMethodBeat.m2505o(121591);
            return eiD;
        }

        private C8187b(C31710d c31710d) {
            AppMethodBeat.m2504i(121586);
            this.BAo = new Stack();
            this.BAp = m14448g(c31710d);
            AppMethodBeat.m2505o(121586);
        }

        /* renamed from: g */
        private C25162p m14448g(C31710d c31710d) {
            AppMethodBeat.m2504i(121587);
            C31710d c31710d2 = c31710d;
            while (c31710d2 instanceof C41427u) {
                C41427u c41427u = (C41427u) c31710d2;
                this.BAo.push(c41427u);
                c31710d2 = c41427u.BAj;
            }
            C25162p c25162p = (C25162p) c31710d2;
            AppMethodBeat.m2505o(121587);
            return c25162p;
        }

        private C25162p eiC() {
            AppMethodBeat.m2504i(121588);
            while (!this.BAo.isEmpty()) {
                Object obj;
                C25162p g = m14448g(((C41427u) this.BAo.pop()).BAk);
                if (g.size() == 0) {
                    obj = 1;
                    continue;
                } else {
                    obj = null;
                    continue;
                }
                if (obj == null) {
                    AppMethodBeat.m2505o(121588);
                    return g;
                }
            }
            AppMethodBeat.m2505o(121588);
            return null;
        }

        public final boolean hasNext() {
            return this.BAp != null;
        }

        public final C25162p eiD() {
            AppMethodBeat.m2504i(121589);
            if (this.BAp == null) {
                NoSuchElementException noSuchElementException = new NoSuchElementException();
                AppMethodBeat.m2505o(121589);
                throw noSuchElementException;
            }
            C25162p c25162p = this.BAp;
            this.BAp = eiC();
            AppMethodBeat.m2505o(121589);
            return c25162p;
        }

        public final void remove() {
            AppMethodBeat.m2504i(121590);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.m2505o(121590);
            throw unsupportedOperationException;
        }
    }

    /* renamed from: a.i.b.a.c.g.u$c */
    class C31716c implements C31712a {
        private final C8187b BAq;
        private C31712a BAr;
        int BAs;

        /* synthetic */ C31716c(C41427u c41427u, byte b) {
            this();
        }

        private C31716c() {
            AppMethodBeat.m2504i(121592);
            this.BAq = new C8187b(C41427u.this, (byte) 0);
            this.BAr = this.BAq.eiD().ehP();
            this.BAs = C41427u.this.size();
            AppMethodBeat.m2505o(121592);
        }

        public final boolean hasNext() {
            return this.BAs > 0;
        }

        public final byte nextByte() {
            AppMethodBeat.m2504i(121593);
            if (!this.BAr.hasNext()) {
                this.BAr = this.BAq.eiD().ehP();
            }
            this.BAs--;
            byte nextByte = this.BAr.nextByte();
            AppMethodBeat.m2505o(121593);
            return nextByte;
        }

        public final void remove() {
            AppMethodBeat.m2504i(121594);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.m2505o(121594);
            throw unsupportedOperationException;
        }

        public final /* synthetic */ Object next() {
            AppMethodBeat.m2504i(121595);
            Byte valueOf = Byte.valueOf(nextByte());
            AppMethodBeat.m2505o(121595);
            return valueOf;
        }
    }

    /* renamed from: a.i.b.a.c.g.u$d */
    class C31717d extends InputStream {
        private C8187b BAu;
        private C25162p BAv;
        private int BAw;
        private int BAx;
        private int BAy;
        private int mark;

        public C31717d() {
            AppMethodBeat.m2504i(121596);
            initialize();
            AppMethodBeat.m2505o(121596);
        }

        public final int read(byte[] bArr, int i, int i2) {
            AppMethodBeat.m2504i(121597);
            if (bArr == null) {
                NullPointerException nullPointerException = new NullPointerException();
                AppMethodBeat.m2505o(121597);
                throw nullPointerException;
            } else if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
                IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException();
                AppMethodBeat.m2505o(121597);
                throw indexOutOfBoundsException;
            } else {
                int B = m51342B(bArr, i, i2);
                AppMethodBeat.m2505o(121597);
                return B;
            }
        }

        public final long skip(long j) {
            AppMethodBeat.m2504i(121598);
            if (j < 0) {
                IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException();
                AppMethodBeat.m2505o(121598);
                throw indexOutOfBoundsException;
            }
            if (j > 2147483647L) {
                j = 2147483647L;
            }
            long B = (long) m51342B(null, 0, (int) j);
            AppMethodBeat.m2505o(121598);
            return B;
        }

        /* renamed from: B */
        private int m51342B(byte[] bArr, int i, int i2) {
            AppMethodBeat.m2504i(121599);
            int i3 = i2;
            int i4 = i;
            while (i3 > 0) {
                eiE();
                if (this.BAv == null) {
                    if (i3 == i2) {
                        AppMethodBeat.m2505o(121599);
                        return -1;
                    }
                    i4 = i2 - i3;
                    AppMethodBeat.m2505o(121599);
                    return i4;
                }
                int min = Math.min(this.BAw - this.BAx, i3);
                if (bArr != null) {
                    this.BAv.mo51675f(bArr, this.BAx, i4, min);
                    i4 += min;
                }
                this.BAx += min;
                i3 -= min;
            }
            i4 = i2 - i3;
            AppMethodBeat.m2505o(121599);
            return i4;
        }

        public final int read() {
            AppMethodBeat.m2504i(121600);
            eiE();
            if (this.BAv == null) {
                AppMethodBeat.m2505o(121600);
                return -1;
            }
            C25162p c25162p = this.BAv;
            int i = this.BAx;
            this.BAx = i + 1;
            int Us = c25162p.mo42027Us(i) & 255;
            AppMethodBeat.m2505o(121600);
            return Us;
        }

        public final int available() {
            AppMethodBeat.m2504i(121601);
            int size = C41427u.this.size() - (this.BAy + this.BAx);
            AppMethodBeat.m2505o(121601);
            return size;
        }

        public final boolean markSupported() {
            return true;
        }

        public final void mark(int i) {
            this.mark = this.BAy + this.BAx;
        }

        public final synchronized void reset() {
            AppMethodBeat.m2504i(121602);
            initialize();
            m51342B(null, 0, this.mark);
            AppMethodBeat.m2505o(121602);
        }

        private void initialize() {
            AppMethodBeat.m2504i(121603);
            this.BAu = new C8187b(C41427u.this, (byte) 0);
            this.BAv = this.BAu.eiD();
            this.BAw = this.BAv.size();
            this.BAx = 0;
            this.BAy = 0;
            AppMethodBeat.m2505o(121603);
        }

        private void eiE() {
            AppMethodBeat.m2504i(121604);
            if (this.BAv != null && this.BAx == this.BAw) {
                this.BAy += this.BAw;
                this.BAx = 0;
                if (this.BAu.hasNext()) {
                    this.BAv = this.BAu.eiD();
                    this.BAw = this.BAv.size();
                    AppMethodBeat.m2505o(121604);
                    return;
                }
                this.BAv = null;
                this.BAw = 0;
            }
            AppMethodBeat.m2505o(121604);
        }
    }

    /* synthetic */ C41427u(C31710d c31710d, C31710d c31710d2, byte b) {
        this(c31710d, c31710d2);
    }

    public final /* synthetic */ Iterator iterator() {
        AppMethodBeat.m2504i(121618);
        C31712a ehP = ehP();
        AppMethodBeat.m2505o(121618);
        return ehP;
    }

    static {
        int i;
        AppMethodBeat.m2504i(121619);
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
                AppMethodBeat.m2505o(121619);
                return;
            }
        }
    }

    private C41427u(C31710d c31710d, C31710d c31710d2) {
        AppMethodBeat.m2504i(121605);
        this.puf = 0;
        this.BAj = c31710d;
        this.BAk = c31710d2;
        this.BAl = c31710d.size();
        this.BAi = this.BAl + c31710d2.size();
        this.BAm = Math.max(c31710d.ehT(), c31710d2.ehT()) + 1;
        AppMethodBeat.m2505o(121605);
    }

    /* renamed from: a */
    static C31710d m72251a(C31710d c31710d, C31710d c31710d2) {
        C31710d c31710d3;
        AppMethodBeat.m2504i(121606);
        C41427u c41427u = c31710d instanceof C41427u ? (C41427u) c31710d : null;
        if (c31710d2.size() == 0) {
            c31710d3 = c31710d;
        } else if (c31710d.size() != 0) {
            int size = c31710d.size() + c31710d2.size();
            if (size < 128) {
                c31710d3 = C41427u.m72254b(c31710d, c31710d2);
            } else if (c41427u != null && c41427u.BAk.size() + c31710d2.size() < 128) {
                c31710d3 = new C41427u(c41427u.BAj, C41427u.m72254b(c41427u.BAk, c31710d2));
            } else if (c41427u == null || c41427u.BAj.ehT() <= c41427u.BAk.ehT() || c41427u.BAm <= c31710d2.ehT()) {
                if (size >= BAh[Math.max(c31710d.ehT(), c31710d2.ehT()) + 1]) {
                    c31710d3 = new C41427u(c31710d, c31710d2);
                } else {
                    C0120a c0120a = new C0120a();
                    c0120a.mo193f(c31710d);
                    c0120a.mo193f(c31710d2);
                    c31710d3 = (C31710d) c0120a.BAn.pop();
                    while (!c0120a.BAn.isEmpty()) {
                        c31710d3 = new C41427u((C31710d) c0120a.BAn.pop(), c31710d3, (byte) 0);
                    }
                }
            } else {
                c31710d3 = new C41427u(c41427u.BAj, new C41427u(c41427u.BAk, c31710d2));
            }
        } else {
            c31710d3 = c31710d2;
        }
        AppMethodBeat.m2505o(121606);
        return c31710d3;
    }

    /* renamed from: b */
    private static C25162p m72254b(C31710d c31710d, C31710d c31710d2) {
        AppMethodBeat.m2504i(121607);
        int size = c31710d.size();
        int size2 = c31710d2.size();
        byte[] bArr = new byte[(size + size2)];
        c31710d.mo51675f(bArr, 0, 0, size);
        c31710d2.mo51675f(bArr, 0, size, size2);
        C25162p c25162p = new C25162p(bArr);
        AppMethodBeat.m2505o(121607);
        return c25162p;
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
    /* renamed from: g */
    public final void mo42040g(byte[] bArr, int i, int i2, int i3) {
        AppMethodBeat.m2504i(121608);
        if (i + i3 <= this.BAl) {
            this.BAj.mo42040g(bArr, i, i2, i3);
            AppMethodBeat.m2505o(121608);
        } else if (i >= this.BAl) {
            this.BAk.mo42040g(bArr, i - this.BAl, i2, i3);
            AppMethodBeat.m2505o(121608);
        } else {
            int i4 = this.BAl - i;
            this.BAj.mo42040g(bArr, i, i2, i4);
            this.BAk.mo42040g(bArr, 0, i2 + i4, i3 - i4);
            AppMethodBeat.m2505o(121608);
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final void mo42031b(OutputStream outputStream, int i, int i2) {
        AppMethodBeat.m2504i(121609);
        if (i + i2 <= this.BAl) {
            this.BAj.mo42031b(outputStream, i, i2);
            AppMethodBeat.m2505o(121609);
        } else if (i >= this.BAl) {
            this.BAk.mo42031b(outputStream, i - this.BAl, i2);
            AppMethodBeat.m2505o(121609);
        } else {
            int i3 = this.BAl - i;
            this.BAj.mo42031b(outputStream, i, i3);
            this.BAk.mo42031b(outputStream, 0, i2 - i3);
            AppMethodBeat.m2505o(121609);
        }
    }

    public final String toString(String str) {
        AppMethodBeat.m2504i(121610);
        String str2 = new String(toByteArray(), str);
        AppMethodBeat.m2505o(121610);
        return str2;
    }

    public final boolean ehQ() {
        AppMethodBeat.m2504i(121611);
        if (this.BAk.mo42029aR(this.BAj.mo42029aR(0, 0, this.BAl), 0, this.BAk.size()) == 0) {
            AppMethodBeat.m2505o(121611);
            return true;
        }
        AppMethodBeat.m2505o(121611);
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: aR */
    public final int mo42029aR(int i, int i2, int i3) {
        AppMethodBeat.m2504i(121612);
        int aR;
        if (i2 + i3 <= this.BAl) {
            aR = this.BAj.mo42029aR(i, i2, i3);
            AppMethodBeat.m2505o(121612);
            return aR;
        } else if (i2 >= this.BAl) {
            aR = this.BAk.mo42029aR(i, i2 - this.BAl, i3);
            AppMethodBeat.m2505o(121612);
            return aR;
        } else {
            aR = this.BAl - i2;
            aR = this.BAk.mo42029aR(this.BAj.mo42029aR(i, i2, aR), 0, i3 - aR);
            AppMethodBeat.m2505o(121612);
            return aR;
        }
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(121613);
        if (obj == this) {
            AppMethodBeat.m2505o(121613);
            return true;
        } else if (obj instanceof C31710d) {
            C31710d c31710d = (C31710d) obj;
            if (this.BAi != c31710d.size()) {
                AppMethodBeat.m2505o(121613);
                return false;
            } else if (this.BAi == 0) {
                AppMethodBeat.m2505o(121613);
                return true;
            } else {
                if (this.puf != 0) {
                    int ehV = c31710d.ehV();
                    if (!(ehV == 0 || this.puf == ehV)) {
                        AppMethodBeat.m2505o(121613);
                        return false;
                    }
                }
                int i = 0;
                C8187b c8187b = new C8187b(this, (byte) 0);
                C25162p c25162p = (C25162p) c8187b.next();
                int i2 = 0;
                C8187b c8187b2 = new C8187b(c31710d, (byte) 0);
                int i3 = 0;
                C25162p c25162p2 = (C25162p) c8187b2.next();
                C25162p c25162p3 = c25162p;
                while (true) {
                    int size = c25162p3.size() - i;
                    int size2 = c25162p2.size() - i2;
                    int min = Math.min(size, size2);
                    if (i == 0 ? c25162p3.mo42028a(c25162p2, i2, min) : c25162p2.mo42028a(c25162p3, i, min)) {
                        int i4 = i3 + min;
                        if (i4 < this.BAi) {
                            if (min == size) {
                                i = 0;
                                c25162p3 = (C25162p) c8187b.next();
                            } else {
                                i += min;
                            }
                            if (min == size2) {
                                i2 = 0;
                                i3 = i4;
                                c25162p2 = (C25162p) c8187b2.next();
                            } else {
                                i3 = i4;
                                i2 += min;
                            }
                        } else if (i4 == this.BAi) {
                            AppMethodBeat.m2505o(121613);
                            return true;
                        } else {
                            IllegalStateException illegalStateException = new IllegalStateException();
                            AppMethodBeat.m2505o(121613);
                            throw illegalStateException;
                        }
                    }
                    AppMethodBeat.m2505o(121613);
                    return false;
                }
            }
        } else {
            AppMethodBeat.m2505o(121613);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(121614);
        int i = this.puf;
        if (i == 0) {
            i = mo42030aS(this.BAi, 0, this.BAi);
            if (i == 0) {
                i = 1;
            }
            this.puf = i;
        }
        AppMethodBeat.m2505o(121614);
        return i;
    }

    /* Access modifiers changed, original: protected|final */
    public final int ehV() {
        return this.puf;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: aS */
    public final int mo42030aS(int i, int i2, int i3) {
        AppMethodBeat.m2504i(121615);
        int aS;
        if (i2 + i3 <= this.BAl) {
            aS = this.BAj.mo42030aS(i, i2, i3);
            AppMethodBeat.m2505o(121615);
            return aS;
        } else if (i2 >= this.BAl) {
            aS = this.BAk.mo42030aS(i, i2 - this.BAl, i3);
            AppMethodBeat.m2505o(121615);
            return aS;
        } else {
            aS = this.BAl - i2;
            aS = this.BAk.mo42030aS(this.BAj.mo42030aS(i, i2, aS), 0, i3 - aS);
            AppMethodBeat.m2505o(121615);
            return aS;
        }
    }

    public final C31713e ehR() {
        AppMethodBeat.m2504i(121616);
        C31713e S = C31713e.m51322S(new C31717d());
        AppMethodBeat.m2505o(121616);
        return S;
    }

    public final C31712a ehP() {
        AppMethodBeat.m2504i(121617);
        C31716c c31716c = new C31716c(this, (byte) 0);
        AppMethodBeat.m2505o(121617);
        return c31716c;
    }
}
