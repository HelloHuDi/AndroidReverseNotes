package com.tencent.tinker.a.a;

import com.facebook.internal.Utility;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;
import java.util.zip.Adler32;

public final class i {
    static final short[] AxX = new short[0];
    public final t AxY = new t();
    private final f AxZ = new f(this, (byte) 0);
    private final g Aya = new g(this, (byte) 0);
    private final h Ayb = new h(this, (byte) 0);
    private final d Ayc = new d(this, (byte) 0);
    private final b Ayd = new b(this, (byte) 0);
    private final c Aye = new c(this, (byte) 0);
    private final a Ayf = new a(this, (byte) 0);
    private int Ayg = 0;
    public ByteBuffer aEY;
    private byte[] nTL = null;

    final class b extends AbstractList<n> implements RandomAccess {
        private b() {
        }

        /* synthetic */ b(i iVar, byte b) {
            this();
        }

        public final int size() {
            return i.this.AxY.Ayw.size;
        }

        public final /* synthetic */ Object get(int i) {
            i.hV(i, i.this.AxY.Ayw.size);
            return i.this.Rm(i.this.AxY.Ayw.off + (i * 8)).dRz();
        }
    }

    final class c extends AbstractList<p> implements RandomAccess {
        private c() {
        }

        /* synthetic */ c(i iVar, byte b) {
            this();
        }

        public final int size() {
            return i.this.AxY.Ayx.size;
        }

        public final /* synthetic */ Object get(int i) {
            i.hV(i, i.this.AxY.Ayx.size);
            return i.this.Rm(i.this.AxY.Ayx.off + (i * 8)).dRA();
        }
    }

    final class d extends AbstractList<r> implements RandomAccess {
        private d() {
        }

        /* synthetic */ d(i iVar, byte b) {
            this();
        }

        public final int size() {
            return i.this.AxY.Ayv.size;
        }

        public final /* synthetic */ Object get(int i) {
            i.hV(i, i.this.AxY.Ayv.size);
            return i.this.Rm(i.this.AxY.Ayv.off + (i * 12)).dRB();
        }
    }

    final class a extends AbstractList<f> implements RandomAccess {
        private a() {
        }

        /* synthetic */ a(i iVar, byte b) {
            this();
        }

        public final int size() {
            return i.this.AxY.Ayy.size;
        }

        public final /* synthetic */ Object get(int i) {
            i.hV(i, i.this.AxY.Ayy.size);
            return i.this.Rm(i.this.AxY.Ayy.off + (i * 32)).dRC();
        }
    }

    public final class e extends com.tencent.tinker.a.a.a.a {
        private final String name;

        /* synthetic */ e(i iVar, String str, ByteBuffer byteBuffer, byte b) {
            this(str, byteBuffer);
        }

        private e(String str, ByteBuffer byteBuffer) {
            super(byteBuffer);
            this.name = str;
        }

        public final s dRx() {
            a(i.this.AxY.AyF, false);
            return super.dRx();
        }

        public final u dRy() {
            a(i.this.AxY.AyA, false);
            return super.dRy();
        }

        public final n dRz() {
            a(i.this.AxY.Ayw, false);
            return super.dRz();
        }

        public final p dRA() {
            a(i.this.AxY.Ayx, false);
            return super.dRA();
        }

        public final r dRB() {
            a(i.this.AxY.Ayv, false);
            return super.dRB();
        }

        public final f dRC() {
            a(i.this.AxY.Ayy, false);
            return super.dRC();
        }

        public final g dRD() {
            a(i.this.AxY.AyE, false);
            return super.dRD();
        }

        public final h dRE() {
            a(i.this.AxY.AyG, false);
            return super.dRE();
        }

        public final e dRF() {
            a(i.this.AxY.AyD, false);
            return super.dRF();
        }

        public final a dRG() {
            a(i.this.AxY.AyH, false);
            return super.dRG();
        }

        public final b dRH() {
            a(i.this.AxY.AyC, false);
            return super.dRH();
        }

        public final c dRI() {
            a(i.this.AxY.AyB, false);
            return super.dRI();
        }

        public final d dRJ() {
            a(i.this.AxY.AyJ, false);
            return super.dRJ();
        }

        public final k dRK() {
            a(i.this.AxY.AyI, false);
            return super.dRK();
        }

        private void a(com.tencent.tinker.a.a.t.a aVar, boolean z) {
            if (!aVar.AyP) {
                return;
            }
            if (z) {
                dSa();
            } else {
                dRZ();
            }
        }

        public final int a(s sVar) {
            a(i.this.AxY.AyF, true);
            return super.a(sVar);
        }

        public final int a(u uVar) {
            a(i.this.AxY.AyA, true);
            return super.a(uVar);
        }

        public final int a(n nVar) {
            a(i.this.AxY.Ayw, true);
            return super.a(nVar);
        }

        public final int a(p pVar) {
            a(i.this.AxY.Ayx, true);
            return super.a(pVar);
        }

        public final int a(r rVar) {
            a(i.this.AxY.Ayv, true);
            return super.a(rVar);
        }

        public final int a(f fVar) {
            a(i.this.AxY.Ayy, true);
            return super.a(fVar);
        }

        public final int a(g gVar) {
            a(i.this.AxY.AyE, true);
            return super.a(gVar);
        }

        public final int a(h hVar) {
            a(i.this.AxY.AyG, true);
            return super.a(hVar);
        }

        public final int a(e eVar) {
            a(i.this.AxY.AyD, true);
            return super.a(eVar);
        }

        public final int a(a aVar) {
            a(i.this.AxY.AyH, true);
            return super.a(aVar);
        }

        public final int a(b bVar) {
            a(i.this.AxY.AyC, true);
            return super.a(bVar);
        }

        public final int a(c cVar) {
            a(i.this.AxY.AyB, true);
            return super.a(cVar);
        }

        public final int a(d dVar) {
            a(i.this.AxY.AyJ, true);
            return super.a(dVar);
        }

        public final int a(k kVar) {
            a(i.this.AxY.AyI, true);
            return super.a(kVar);
        }
    }

    final class g extends AbstractList<Integer> implements RandomAccess {
        private g() {
        }

        /* synthetic */ g(i iVar, byte b) {
            this();
        }

        public final int size() {
            return i.this.AxY.Ayu.size;
        }

        public final /* synthetic */ Object get(int i) {
            return Integer.valueOf(i.this.Rn(i));
        }
    }

    final class h extends AbstractList<String> implements RandomAccess {
        private h() {
        }

        /* synthetic */ h(i iVar, byte b) {
            this();
        }

        public final int size() {
            return i.this.AxY.Ayu.size;
        }

        public final /* synthetic */ Object get(int i) {
            return i.this.AxZ.get(i.this.Rn(i));
        }
    }

    final class f extends AbstractList<String> implements RandomAccess {
        private f() {
        }

        /* synthetic */ f(i iVar, byte b) {
            this();
        }

        /* renamed from: zc */
        public final String get(int i) {
            i.hV(i, i.this.AxY.Ayt.size);
            return i.this.Rm(i.this.Rm(i.this.AxY.Ayt.off + (i * 4)).aEY.getInt()).dRx().value;
        }

        public final int size() {
            return i.this.AxY.Ayt.size;
        }
    }

    public i(int i) {
        this.aEY = ByteBuffer.wrap(new byte[i]);
        this.aEY.order(ByteOrder.LITTLE_ENDIAN);
        this.AxY.fileSize = i;
    }

    public i(InputStream inputStream) {
        int i;
        Object i2 = -1;
        this.aEY = ByteBuffer.wrap(com.tencent.tinker.a.a.b.d.c(inputStream, 0));
        this.aEY.order(ByteOrder.LITTLE_ENDIAN);
        t tVar = this.AxY;
        e a = a(tVar.Ays);
        byte[] Rr = a.Rr(8);
        if (Rr.length == 8 && Rr[0] == (byte) 100 && Rr[1] == (byte) 101 && Rr[2] == (byte) 120 && Rr[3] == (byte) 10 && Rr[7] == (byte) 0) {
            String str = ((char) Rr[4]) + ((char) Rr[5]) + ((char) Rr[6]);
            if (str.equals("036")) {
                i2 = 14;
            } else if (str.equals("035")) {
                i2 = 13;
            }
        }
        if (i2 != 13) {
            throw new j("Unexpected magic: " + Arrays.toString(Rr));
        }
        tVar.gai = a.aEY.getInt();
        tVar.nTL = a.Rr(20);
        tVar.fileSize = a.aEY.getInt();
        i2 = a.aEY.getInt();
        if (i2 != 112) {
            throw new j("Unexpected header: 0x" + Integer.toHexString(i2));
        }
        i2 = a.aEY.getInt();
        if (i2 != 305419896) {
            throw new j("Unexpected endian tag: 0x" + Integer.toHexString(i2));
        }
        tVar.AyL = a.aEY.getInt();
        tVar.AyM = a.aEY.getInt();
        tVar.Ayz.off = a.aEY.getInt();
        if (tVar.Ayz.off == 0) {
            throw new j("Cannot merge dex files that do not contain a map");
        }
        tVar.Ayt.size = a.aEY.getInt();
        tVar.Ayt.off = a.aEY.getInt();
        tVar.Ayu.size = a.aEY.getInt();
        tVar.Ayu.off = a.aEY.getInt();
        tVar.Ayv.size = a.aEY.getInt();
        tVar.Ayv.off = a.aEY.getInt();
        tVar.Ayw.size = a.aEY.getInt();
        tVar.Ayw.off = a.aEY.getInt();
        tVar.Ayx.size = a.aEY.getInt();
        tVar.Ayx.off = a.aEY.getInt();
        tVar.Ayy.size = a.aEY.getInt();
        tVar.Ayy.off = a.aEY.getInt();
        tVar.lgV = a.aEY.getInt();
        tVar.AyN = a.aEY.getInt();
        tVar.a(Rm(tVar.Ayz.off));
        tVar.dRV();
    }

    private static void hV(int i, int i2) {
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException("index:" + i + ", length=" + i2);
        }
    }

    public final e Rm(int i) {
        if (i < 0 || i >= this.aEY.capacity()) {
            throw new IllegalArgumentException("position=" + i + " length=" + this.aEY.capacity());
        }
        ByteBuffer duplicate = this.aEY.duplicate();
        duplicate.order(ByteOrder.LITTLE_ENDIAN);
        duplicate.position(i);
        duplicate.limit(this.aEY.capacity());
        return new e(this, "temp-section", duplicate, (byte) 0);
    }

    public final e a(com.tencent.tinker.a.a.t.a aVar) {
        int i = aVar.off;
        if (i < 0 || i >= this.aEY.capacity()) {
            throw new IllegalArgumentException("position=" + i + " length=" + this.aEY.capacity());
        }
        ByteBuffer duplicate = this.aEY.duplicate();
        duplicate.order(ByteOrder.LITTLE_ENDIAN);
        duplicate.position(i);
        duplicate.limit(i + aVar.byteCount);
        return new e(this, "section", duplicate, (byte) 0);
    }

    public final byte[] rs(boolean z) {
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
        Rm(12).write(rs(true));
        e Rm = Rm(8);
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

    public final int Rn(int i) {
        hV(i, this.AxY.Ayu.size);
        return this.aEY.getInt(this.AxY.Ayu.off + (i * 4));
    }
}
