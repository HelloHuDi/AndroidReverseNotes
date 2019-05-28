package com.tencent.tinker.p668a.p669a;

import com.facebook.internal.Utility;
import com.tencent.tinker.p668a.p669a.C41083t.C31086a;
import com.tencent.tinker.p668a.p669a.p1365a.C46943a;
import com.tencent.tinker.p668a.p669a.p670b.C5911d;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;
import java.util.zip.Adler32;

/* renamed from: com.tencent.tinker.a.a.i */
public final class C36543i {
    static final short[] AxX = new short[0];
    public final C41083t AxY = new C41083t();
    private final C36547f AxZ = new C36547f(this, (byte) 0);
    private final C36545g Aya = new C36545g(this, (byte) 0);
    private final C36546h Ayb = new C36546h(this, (byte) 0);
    private final C24426d Ayc = new C24426d(this, (byte) 0);
    private final C24424b Ayd = new C24424b(this, (byte) 0);
    private final C24425c Aye = new C24425c(this, (byte) 0);
    private final C31084a Ayf = new C31084a(this, (byte) 0);
    private int Ayg = 0;
    public ByteBuffer aEY;
    private byte[] nTL = null;

    /* renamed from: com.tencent.tinker.a.a.i$b */
    final class C24424b extends AbstractList<C5916n> implements RandomAccess {
        private C24424b() {
        }

        /* synthetic */ C24424b(C36543i c36543i, byte b) {
            this();
        }

        public final int size() {
            return C36543i.this.AxY.Ayw.size;
        }

        public final /* synthetic */ Object get(int i) {
            C36543i.m60553hV(i, C36543i.this.AxY.Ayw.size);
            return C36543i.this.mo57796Rm(C36543i.this.AxY.Ayw.off + (i * 8)).dRz();
        }
    }

    /* renamed from: com.tencent.tinker.a.a.i$c */
    final class C24425c extends AbstractList<C16317p> implements RandomAccess {
        private C24425c() {
        }

        /* synthetic */ C24425c(C36543i c36543i, byte b) {
            this();
        }

        public final int size() {
            return C36543i.this.AxY.Ayx.size;
        }

        public final /* synthetic */ Object get(int i) {
            C36543i.m60553hV(i, C36543i.this.AxY.Ayx.size);
            return C36543i.this.mo57796Rm(C36543i.this.AxY.Ayx.off + (i * 8)).dRA();
        }
    }

    /* renamed from: com.tencent.tinker.a.a.i$d */
    final class C24426d extends AbstractList<C41359r> implements RandomAccess {
        private C24426d() {
        }

        /* synthetic */ C24426d(C36543i c36543i, byte b) {
            this();
        }

        public final int size() {
            return C36543i.this.AxY.Ayv.size;
        }

        public final /* synthetic */ Object get(int i) {
            C36543i.m60553hV(i, C36543i.this.AxY.Ayv.size);
            return C36543i.this.mo57796Rm(C36543i.this.AxY.Ayv.off + (i * 12)).dRB();
        }
    }

    /* renamed from: com.tencent.tinker.a.a.i$a */
    final class C31084a extends AbstractList<C16312f> implements RandomAccess {
        private C31084a() {
        }

        /* synthetic */ C31084a(C36543i c36543i, byte b) {
            this();
        }

        public final int size() {
            return C36543i.this.AxY.Ayy.size;
        }

        public final /* synthetic */ Object get(int i) {
            C36543i.m60553hV(i, C36543i.this.AxY.Ayy.size);
            return C36543i.this.mo57796Rm(C36543i.this.AxY.Ayy.off + (i * 32)).dRC();
        }
    }

    /* renamed from: com.tencent.tinker.a.a.i$e */
    public final class C36544e extends C46943a {
        private final String name;

        /* synthetic */ C36544e(C36543i c36543i, String str, ByteBuffer byteBuffer, byte b) {
            this(str, byteBuffer);
        }

        private C36544e(String str, ByteBuffer byteBuffer) {
            super(byteBuffer);
            this.name = str;
        }

        public final C44546s dRx() {
            m60559a(C36543i.this.AxY.AyF, false);
            return super.dRx();
        }

        public final C31088u dRy() {
            m60559a(C36543i.this.AxY.AyA, false);
            return super.dRy();
        }

        public final C5916n dRz() {
            m60559a(C36543i.this.AxY.Ayw, false);
            return super.dRz();
        }

        public final C16317p dRA() {
            m60559a(C36543i.this.AxY.Ayx, false);
            return super.dRA();
        }

        public final C41359r dRB() {
            m60559a(C36543i.this.AxY.Ayv, false);
            return super.dRB();
        }

        public final C16312f dRC() {
            m60559a(C36543i.this.AxY.Ayy, false);
            return super.dRC();
        }

        public final C16313g dRD() {
            m60559a(C36543i.this.AxY.AyE, false);
            return super.dRD();
        }

        public final C36542h dRE() {
            m60559a(C36543i.this.AxY.AyG, false);
            return super.dRE();
        }

        public final C5914e dRF() {
            m60559a(C36543i.this.AxY.AyD, false);
            return super.dRF();
        }

        public final C46808a dRG() {
            m60559a(C36543i.this.AxY.AyH, false);
            return super.dRG();
        }

        public final C41358b dRH() {
            m60559a(C36543i.this.AxY.AyC, false);
            return super.dRH();
        }

        public final C46810c dRI() {
            m60559a(C36543i.this.AxY.AyB, false);
            return super.dRI();
        }

        public final C16311d dRJ() {
            m60559a(C36543i.this.AxY.AyJ, false);
            return super.dRJ();
        }

        public final C44545k dRK() {
            m60559a(C36543i.this.AxY.AyI, false);
            return super.dRK();
        }

        /* renamed from: a */
        private void m60559a(C31086a c31086a, boolean z) {
            if (!c31086a.AyP) {
                return;
            }
            if (z) {
                dSa();
            } else {
                dRZ();
            }
        }

        /* renamed from: a */
        public final int mo57813a(C44546s c44546s) {
            m60559a(C36543i.this.AxY.AyF, true);
            return super.mo57813a(c44546s);
        }

        /* renamed from: a */
        public final int mo57814a(C31088u c31088u) {
            m60559a(C36543i.this.AxY.AyA, true);
            return super.mo57814a(c31088u);
        }

        /* renamed from: a */
        public final int mo57810a(C5916n c5916n) {
            m60559a(C36543i.this.AxY.Ayw, true);
            return super.mo57810a(c5916n);
        }

        /* renamed from: a */
        public final int mo57811a(C16317p c16317p) {
            m60559a(C36543i.this.AxY.Ayx, true);
            return super.mo57811a(c16317p);
        }

        /* renamed from: a */
        public final int mo57812a(C41359r c41359r) {
            m60559a(C36543i.this.AxY.Ayv, true);
            return super.mo57812a(c41359r);
        }

        /* renamed from: a */
        public final int mo57806a(C16312f c16312f) {
            m60559a(C36543i.this.AxY.Ayy, true);
            return super.mo57806a(c16312f);
        }

        /* renamed from: a */
        public final int mo57807a(C16313g c16313g) {
            m60559a(C36543i.this.AxY.AyE, true);
            return super.mo57807a(c16313g);
        }

        /* renamed from: a */
        public final int mo57808a(C36542h c36542h) {
            m60559a(C36543i.this.AxY.AyG, true);
            return super.mo57808a(c36542h);
        }

        /* renamed from: a */
        public final int mo57805a(C5914e c5914e) {
            m60559a(C36543i.this.AxY.AyD, true);
            return super.mo57805a(c5914e);
        }

        /* renamed from: a */
        public final int mo57801a(C46808a c46808a) {
            m60559a(C36543i.this.AxY.AyH, true);
            return super.mo57801a(c46808a);
        }

        /* renamed from: a */
        public final int mo57802a(C41358b c41358b) {
            m60559a(C36543i.this.AxY.AyC, true);
            return super.mo57802a(c41358b);
        }

        /* renamed from: a */
        public final int mo57803a(C46810c c46810c) {
            m60559a(C36543i.this.AxY.AyB, true);
            return super.mo57803a(c46810c);
        }

        /* renamed from: a */
        public final int mo57804a(C16311d c16311d) {
            m60559a(C36543i.this.AxY.AyJ, true);
            return super.mo57804a(c16311d);
        }

        /* renamed from: a */
        public final int mo57809a(C44545k c44545k) {
            m60559a(C36543i.this.AxY.AyI, true);
            return super.mo57809a(c44545k);
        }
    }

    /* renamed from: com.tencent.tinker.a.a.i$g */
    final class C36545g extends AbstractList<Integer> implements RandomAccess {
        private C36545g() {
        }

        /* synthetic */ C36545g(C36543i c36543i, byte b) {
            this();
        }

        public final int size() {
            return C36543i.this.AxY.Ayu.size;
        }

        public final /* synthetic */ Object get(int i) {
            return Integer.valueOf(C36543i.this.mo57797Rn(i));
        }
    }

    /* renamed from: com.tencent.tinker.a.a.i$h */
    final class C36546h extends AbstractList<String> implements RandomAccess {
        private C36546h() {
        }

        /* synthetic */ C36546h(C36543i c36543i, byte b) {
            this();
        }

        public final int size() {
            return C36543i.this.AxY.Ayu.size;
        }

        public final /* synthetic */ Object get(int i) {
            return C36543i.this.AxZ.get(C36543i.this.mo57797Rn(i));
        }
    }

    /* renamed from: com.tencent.tinker.a.a.i$f */
    final class C36547f extends AbstractList<String> implements RandomAccess {
        private C36547f() {
        }

        /* synthetic */ C36547f(C36543i c36543i, byte b) {
            this();
        }

        /* renamed from: zc */
        public final String get(int i) {
            C36543i.m60553hV(i, C36543i.this.AxY.Ayt.size);
            return C36543i.this.mo57796Rm(C36543i.this.mo57796Rm(C36543i.this.AxY.Ayt.off + (i * 4)).aEY.getInt()).dRx().value;
        }

        public final int size() {
            return C36543i.this.AxY.Ayt.size;
        }
    }

    public C36543i(int i) {
        this.aEY = ByteBuffer.wrap(new byte[i]);
        this.aEY.order(ByteOrder.LITTLE_ENDIAN);
        this.AxY.fileSize = i;
    }

    public C36543i(InputStream inputStream) {
        int i;
        Object i2 = -1;
        this.aEY = ByteBuffer.wrap(C5911d.m9197c(inputStream, 0));
        this.aEY.order(ByteOrder.LITTLE_ENDIAN);
        C41083t c41083t = this.AxY;
        C36544e a = mo57798a(c41083t.Ays);
        byte[] Rr = a.mo76206Rr(8);
        if (Rr.length == 8 && Rr[0] == (byte) 100 && Rr[1] == (byte) 101 && Rr[2] == (byte) 120 && Rr[3] == (byte) 10 && Rr[7] == (byte) 0) {
            String str = ((char) Rr[4]) + ((char) Rr[5]) + ((char) Rr[6]);
            if (str.equals("036")) {
                i2 = 14;
            } else if (str.equals("035")) {
                i2 = 13;
            }
        }
        if (i2 != 13) {
            throw new C36548j("Unexpected magic: " + Arrays.toString(Rr));
        }
        c41083t.gai = a.aEY.getInt();
        c41083t.nTL = a.mo76206Rr(20);
        c41083t.fileSize = a.aEY.getInt();
        i2 = a.aEY.getInt();
        if (i2 != 112) {
            throw new C36548j("Unexpected header: 0x" + Integer.toHexString(i2));
        }
        i2 = a.aEY.getInt();
        if (i2 != 305419896) {
            throw new C36548j("Unexpected endian tag: 0x" + Integer.toHexString(i2));
        }
        c41083t.AyL = a.aEY.getInt();
        c41083t.AyM = a.aEY.getInt();
        c41083t.Ayz.off = a.aEY.getInt();
        if (c41083t.Ayz.off == 0) {
            throw new C36548j("Cannot merge dex files that do not contain a map");
        }
        c41083t.Ayt.size = a.aEY.getInt();
        c41083t.Ayt.off = a.aEY.getInt();
        c41083t.Ayu.size = a.aEY.getInt();
        c41083t.Ayu.off = a.aEY.getInt();
        c41083t.Ayv.size = a.aEY.getInt();
        c41083t.Ayv.off = a.aEY.getInt();
        c41083t.Ayw.size = a.aEY.getInt();
        c41083t.Ayw.off = a.aEY.getInt();
        c41083t.Ayx.size = a.aEY.getInt();
        c41083t.Ayx.off = a.aEY.getInt();
        c41083t.Ayy.size = a.aEY.getInt();
        c41083t.Ayy.off = a.aEY.getInt();
        c41083t.lgV = a.aEY.getInt();
        c41083t.AyN = a.aEY.getInt();
        c41083t.mo65175a(mo57796Rm(c41083t.Ayz.off));
        c41083t.dRV();
    }

    /* renamed from: hV */
    private static void m60553hV(int i, int i2) {
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException("index:" + i + ", length=" + i2);
        }
    }

    /* renamed from: Rm */
    public final C36544e mo57796Rm(int i) {
        if (i < 0 || i >= this.aEY.capacity()) {
            throw new IllegalArgumentException("position=" + i + " length=" + this.aEY.capacity());
        }
        ByteBuffer duplicate = this.aEY.duplicate();
        duplicate.order(ByteOrder.LITTLE_ENDIAN);
        duplicate.position(i);
        duplicate.limit(this.aEY.capacity());
        return new C36544e(this, "temp-section", duplicate, (byte) 0);
    }

    /* renamed from: a */
    public final C36544e mo57798a(C31086a c31086a) {
        int i = c31086a.off;
        if (i < 0 || i >= this.aEY.capacity()) {
            throw new IllegalArgumentException("position=" + i + " length=" + this.aEY.capacity());
        }
        ByteBuffer duplicate = this.aEY.duplicate();
        duplicate.order(ByteOrder.LITTLE_ENDIAN);
        duplicate.position(i);
        duplicate.limit(i + c31086a.byteCount);
        return new C36544e(this, "section", duplicate, (byte) 0);
    }

    /* renamed from: rs */
    public final byte[] mo57800rs(boolean z) {
        if (this.nTL != null && !z) {
            return this.nTL;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            byte[] bArr = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
            ByteBuffer duplicate = this.aEY.duplicate();
            duplicate.limit(duplicate.capacity());
            duplicate.position(32);
            while (duplicate.hasRemaining()) {
                int min = Math.min(Utility.DEFAULT_STREAM_BUFFER_SIZE, duplicate.remaining());
                duplicate.get(bArr, 0, min);
                instance.update(bArr, 0, min);
            }
            byte[] digest = instance.digest();
            this.nTL = digest;
            return digest;
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError();
        }
    }

    public final void dRw() {
        mo57796Rm(12).write(mo57800rs(true));
        C36544e Rm = mo57796Rm(8);
        Adler32 adler32 = new Adler32();
        byte[] bArr = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
        ByteBuffer duplicate = this.aEY.duplicate();
        duplicate.limit(duplicate.capacity());
        duplicate.position(12);
        while (duplicate.hasRemaining()) {
            int min = Math.min(Utility.DEFAULT_STREAM_BUFFER_SIZE, duplicate.remaining());
            duplicate.get(bArr, 0, min);
            adler32.update(bArr, 0, min);
        }
        Rm.writeInt((int) adler32.getValue());
    }

    /* renamed from: Rn */
    public final int mo57797Rn(int i) {
        C36543i.m60553hV(i, this.AxY.Ayu.size);
        return this.aEY.getInt(this.AxY.Ayu.off + (i * 4));
    }
}
