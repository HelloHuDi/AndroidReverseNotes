package a.i.b.a.c.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public abstract class d implements Iterable<Byte> {
    static final /* synthetic */ boolean $assertionsDisabled;
    public static final d Bzq = new p(new byte[0]);

    public static final class b extends OutputStream {
        private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
        private final int Bzr = 128;
        private final ArrayList<d> Bzs = new ArrayList();
        private int Bzt;
        private byte[] buffer = new byte[128];
        private int bxm;

        b() {
            AppMethodBeat.i(121420);
            AppMethodBeat.o(121420);
        }

        public final synchronized void write(int i) {
            AppMethodBeat.i(121421);
            if (this.bxm == this.buffer.length) {
                Ut(1);
            }
            byte[] bArr = this.buffer;
            int i2 = this.bxm;
            this.bxm = i2 + 1;
            bArr[i2] = (byte) i;
            AppMethodBeat.o(121421);
        }

        public final synchronized void write(byte[] bArr, int i, int i2) {
            AppMethodBeat.i(121422);
            if (i2 <= this.buffer.length - this.bxm) {
                System.arraycopy(bArr, i, this.buffer, this.bxm, i2);
                this.bxm += i2;
                AppMethodBeat.o(121422);
            } else {
                int length = this.buffer.length - this.bxm;
                System.arraycopy(bArr, i, this.buffer, this.bxm, length);
                int i3 = i + length;
                length = i2 - length;
                Ut(length);
                System.arraycopy(bArr, i3, this.buffer, 0, length);
                this.bxm = length;
                AppMethodBeat.o(121422);
            }
        }

        private synchronized int size() {
            return this.Bzt + this.bxm;
        }

        public final String toString() {
            AppMethodBeat.i(121424);
            String format = String.format("<ByteString.Output@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
            AppMethodBeat.o(121424);
            return format;
        }

        private void Ut(int i) {
            AppMethodBeat.i(121425);
            this.Bzs.add(new p(this.buffer));
            this.Bzt += this.buffer.length;
            this.buffer = new byte[Math.max(this.Bzr, Math.max(i, this.Bzt >>> 1))];
            this.bxm = 0;
            AppMethodBeat.o(121425);
        }

        public final synchronized d ehW() {
            d w;
            AppMethodBeat.i(121423);
            if (this.bxm >= this.buffer.length) {
                this.Bzs.add(new p(this.buffer));
                this.buffer = EMPTY_BYTE_ARRAY;
            } else if (this.bxm > 0) {
                byte[] bArr = this.buffer;
                int i = this.bxm;
                byte[] bArr2 = new byte[i];
                System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, i));
                this.Bzs.add(new p(bArr2));
            }
            this.Bzt += this.bxm;
            this.bxm = 0;
            w = d.w(this.Bzs);
            AppMethodBeat.o(121423);
            return w;
        }
    }

    public interface a extends Iterator<Byte> {
        byte nextByte();
    }

    public abstract int aR(int i, int i2, int i3);

    public abstract int aS(int i, int i2, int i3);

    public abstract void b(OutputStream outputStream, int i, int i2);

    /* renamed from: ehP */
    public abstract a iterator();

    public abstract boolean ehQ();

    public abstract e ehR();

    public abstract int ehT();

    public abstract boolean ehU();

    public abstract int ehV();

    public abstract void g(byte[] bArr, int i, int i2, int i3);

    public abstract int size();

    public abstract String toString(String str);

    static {
        boolean z;
        if (d.class.desiredAssertionStatus()) {
            z = false;
        } else {
            z = true;
        }
        $assertionsDisabled = z;
    }

    d() {
    }

    public static d A(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new p(bArr2);
    }

    public static d cx(byte[] bArr) {
        return A(bArr, 0, bArr.length);
    }

    public static d awc(String str) {
        try {
            return new p(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported?", e);
        }
    }

    public final d a(d dVar) {
        int size = size();
        int size2 = dVar.size();
        if (((long) size) + ((long) size2) < 2147483647L) {
            return u.a(this, dVar);
        }
        throw new IllegalArgumentException("ByteString would be too long: " + size + "+" + size2);
    }

    public static d w(Iterable<d> iterable) {
        Collection collection;
        if (iterable instanceof Collection) {
            collection = (Collection) iterable;
        } else {
            ArrayList arrayList = new ArrayList();
            for (d add : iterable) {
                arrayList.add(add);
            }
            collection = arrayList;
        }
        if (collection.isEmpty()) {
            return Bzq;
        }
        return a(collection.iterator(), collection.size());
    }

    private static d a(Iterator<d> it, int i) {
        if (!$assertionsDisabled && i <= 0) {
            throw new AssertionError();
        } else if (i == 1) {
            return (d) it.next();
        } else {
            int i2 = i >>> 1;
            return a(it, i2).a(a(it, i - i2));
        }
    }

    public final void f(byte[] bArr, int i, int i2, int i3) {
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
            g(bArr, i, i2, i3);
        }
    }

    public final byte[] toByteArray() {
        int size = size();
        if (size == 0) {
            return j.EMPTY_BYTE_ARRAY;
        }
        byte[] bArr = new byte[size];
        g(bArr, 0, 0, size);
        return bArr;
    }

    /* Access modifiers changed, original: final */
    public final void a(OutputStream outputStream, int i, int i2) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("Source offset < 0: " + i);
        } else if (i2 < 0) {
            throw new IndexOutOfBoundsException("Length < 0: " + i2);
        } else if (i + i2 > size()) {
            throw new IndexOutOfBoundsException("Source end offset exceeded: " + (i + i2));
        } else if (i2 > 0) {
            b(outputStream, i, i2);
        }
    }

    public final String dlY() {
        try {
            return toString("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported?", e);
        }
    }

    public static b ehS() {
        return new b();
    }

    public String toString() {
        return String.format("<ByteString@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
    }
}
