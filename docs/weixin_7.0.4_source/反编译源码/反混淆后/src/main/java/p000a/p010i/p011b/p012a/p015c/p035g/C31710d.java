package p000a.p010i.p011b.p012a.p015c.p035g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* renamed from: a.i.b.a.c.g.d */
public abstract class C31710d implements Iterable<Byte> {
    static final /* synthetic */ boolean $assertionsDisabled;
    public static final C31710d Bzq = new C25162p(new byte[0]);

    /* renamed from: a.i.b.a.c.g.d$b */
    public static final class C31711b extends OutputStream {
        private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
        private final int Bzr = 128;
        private final ArrayList<C31710d> Bzs = new ArrayList();
        private int Bzt;
        private byte[] buffer = new byte[128];
        private int bxm;

        C31711b() {
            AppMethodBeat.m2504i(121420);
            AppMethodBeat.m2505o(121420);
        }

        public final synchronized void write(int i) {
            AppMethodBeat.m2504i(121421);
            if (this.bxm == this.buffer.length) {
                m51321Ut(1);
            }
            byte[] bArr = this.buffer;
            int i2 = this.bxm;
            this.bxm = i2 + 1;
            bArr[i2] = (byte) i;
            AppMethodBeat.m2505o(121421);
        }

        public final synchronized void write(byte[] bArr, int i, int i2) {
            AppMethodBeat.m2504i(121422);
            if (i2 <= this.buffer.length - this.bxm) {
                System.arraycopy(bArr, i, this.buffer, this.bxm, i2);
                this.bxm += i2;
                AppMethodBeat.m2505o(121422);
            } else {
                int length = this.buffer.length - this.bxm;
                System.arraycopy(bArr, i, this.buffer, this.bxm, length);
                int i3 = i + length;
                length = i2 - length;
                m51321Ut(length);
                System.arraycopy(bArr, i3, this.buffer, 0, length);
                this.bxm = length;
                AppMethodBeat.m2505o(121422);
            }
        }

        private synchronized int size() {
            return this.Bzt + this.bxm;
        }

        public final String toString() {
            AppMethodBeat.m2504i(121424);
            String format = String.format("<ByteString.Output@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
            AppMethodBeat.m2505o(121424);
            return format;
        }

        /* renamed from: Ut */
        private void m51321Ut(int i) {
            AppMethodBeat.m2504i(121425);
            this.Bzs.add(new C25162p(this.buffer));
            this.Bzt += this.buffer.length;
            this.buffer = new byte[Math.max(this.Bzr, Math.max(i, this.Bzt >>> 1))];
            this.bxm = 0;
            AppMethodBeat.m2505o(121425);
        }

        public final synchronized C31710d ehW() {
            C31710d w;
            AppMethodBeat.m2504i(121423);
            if (this.bxm >= this.buffer.length) {
                this.Bzs.add(new C25162p(this.buffer));
                this.buffer = EMPTY_BYTE_ARRAY;
            } else if (this.bxm > 0) {
                byte[] bArr = this.buffer;
                int i = this.bxm;
                byte[] bArr2 = new byte[i];
                System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, i));
                this.Bzs.add(new C25162p(bArr2));
            }
            this.Bzt += this.bxm;
            this.bxm = 0;
            w = C31710d.m51313w(this.Bzs);
            AppMethodBeat.m2505o(121423);
            return w;
        }
    }

    /* renamed from: a.i.b.a.c.g.d$a */
    public interface C31712a extends Iterator<Byte> {
        byte nextByte();
    }

    /* renamed from: aR */
    public abstract int mo42029aR(int i, int i2, int i3);

    /* renamed from: aS */
    public abstract int mo42030aS(int i, int i2, int i3);

    /* renamed from: b */
    public abstract void mo42031b(OutputStream outputStream, int i, int i2);

    /* renamed from: ehP */
    public abstract C31712a iterator();

    public abstract boolean ehQ();

    public abstract C31713e ehR();

    public abstract int ehT();

    public abstract boolean ehU();

    public abstract int ehV();

    /* renamed from: g */
    public abstract void mo42040g(byte[] bArr, int i, int i2, int i3);

    public abstract int size();

    public abstract String toString(String str);

    static {
        boolean z;
        if (C31710d.class.desiredAssertionStatus()) {
            z = false;
        } else {
            z = true;
        }
        $assertionsDisabled = z;
    }

    C31710d() {
    }

    /* renamed from: A */
    public static C31710d m51310A(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new C25162p(bArr2);
    }

    /* renamed from: cx */
    public static C31710d m51312cx(byte[] bArr) {
        return C31710d.m51310A(bArr, 0, bArr.length);
    }

    public static C31710d awc(String str) {
        try {
            return new C25162p(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported?", e);
        }
    }

    /* renamed from: a */
    public final C31710d mo51672a(C31710d c31710d) {
        int size = size();
        int size2 = c31710d.size();
        if (((long) size) + ((long) size2) < 2147483647L) {
            return C41427u.m72251a(this, c31710d);
        }
        throw new IllegalArgumentException("ByteString would be too long: " + size + "+" + size2);
    }

    /* renamed from: w */
    public static C31710d m51313w(Iterable<C31710d> iterable) {
        Collection collection;
        if (iterable instanceof Collection) {
            collection = (Collection) iterable;
        } else {
            ArrayList arrayList = new ArrayList();
            for (C31710d add : iterable) {
                arrayList.add(add);
            }
            collection = arrayList;
        }
        if (collection.isEmpty()) {
            return Bzq;
        }
        return C31710d.m51311a(collection.iterator(), collection.size());
    }

    /* renamed from: a */
    private static C31710d m51311a(Iterator<C31710d> it, int i) {
        if (!$assertionsDisabled && i <= 0) {
            throw new AssertionError();
        } else if (i == 1) {
            return (C31710d) it.next();
        } else {
            int i2 = i >>> 1;
            return C31710d.m51311a(it, i2).mo51672a(C31710d.m51311a(it, i - i2));
        }
    }

    /* renamed from: f */
    public final void mo51675f(byte[] bArr, int i, int i2, int i3) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("Source offset < 0: " + i);
        } else if (i2 < 0) {
            throw new IndexOutOfBoundsException("Target offset < 0: " + i2);
        } else if (i3 < 0) {
            throw new IndexOutOfBoundsException("Length < 0: " + i3);
        } else if (i + i3 > size()) {
            throw new IndexOutOfBoundsException("Source end offset < 0: " + (i + i3));
        } else if (i2 + i3 > bArr.length) {
            throw new IndexOutOfBoundsException("Target end offset < 0: " + (i2 + i3));
        } else if (i3 > 0) {
            mo42040g(bArr, i, i2, i3);
        }
    }

    public final byte[] toByteArray() {
        int size = size();
        if (size == 0) {
            return C8181j.EMPTY_BYTE_ARRAY;
        }
        byte[] bArr = new byte[size];
        mo42040g(bArr, 0, 0, size);
        return bArr;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo51673a(OutputStream outputStream, int i, int i2) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("Source offset < 0: " + i);
        } else if (i2 < 0) {
            throw new IndexOutOfBoundsException("Length < 0: " + i2);
        } else if (i + i2 > size()) {
            throw new IndexOutOfBoundsException("Source end offset exceeded: " + (i + i2));
        } else if (i2 > 0) {
            mo42031b(outputStream, i, i2);
        }
    }

    public final String dlY() {
        try {
            return toString("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported?", e);
        }
    }

    public static C31711b ehS() {
        return new C31711b();
    }

    public String toString() {
        return String.format("<ByteString@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
    }
}
