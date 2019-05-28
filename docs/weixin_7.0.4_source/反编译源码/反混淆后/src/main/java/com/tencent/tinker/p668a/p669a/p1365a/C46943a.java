package com.tencent.tinker.p668a.p669a.p1365a;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33250az;
import com.tencent.tinker.p668a.p669a.C16311d;
import com.tencent.tinker.p668a.p669a.C16312f;
import com.tencent.tinker.p668a.p669a.C16313g;
import com.tencent.tinker.p668a.p669a.C16313g.C16314a;
import com.tencent.tinker.p668a.p669a.C16313g.C16315b;
import com.tencent.tinker.p668a.p669a.C16316o;
import com.tencent.tinker.p668a.p669a.C16317p;
import com.tencent.tinker.p668a.p669a.C31088u;
import com.tencent.tinker.p668a.p669a.C36542h;
import com.tencent.tinker.p668a.p669a.C36548j;
import com.tencent.tinker.p668a.p669a.C41358b;
import com.tencent.tinker.p668a.p669a.C41359r;
import com.tencent.tinker.p668a.p669a.C44545k;
import com.tencent.tinker.p668a.p669a.C44546s;
import com.tencent.tinker.p668a.p669a.C46808a;
import com.tencent.tinker.p668a.p669a.C46810c;
import com.tencent.tinker.p668a.p669a.C46811q;
import com.tencent.tinker.p668a.p669a.C5914e;
import com.tencent.tinker.p668a.p669a.C5914e.C5912a;
import com.tencent.tinker.p668a.p669a.C5914e.C5913b;
import com.tencent.tinker.p668a.p669a.C5915m;
import com.tencent.tinker.p668a.p669a.C5916n;
import com.tencent.tinker.p668a.p669a.p670b.C24423b;
import com.tencent.tinker.p668a.p669a.p670b.C46809a;
import java.io.ByteArrayOutputStream;
import java.io.UTFDataFormatException;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: com.tencent.tinker.a.a.a.a */
public class C46943a implements C46809a, C24423b {
    private static final short[] AxX = new short[0];
    private static final C16315b[] AyS = new C16315b[0];
    private static final C16314a[] AyT = new C16314a[0];
    private int AyU;
    private boolean AyV;
    public ByteBuffer aEY;

    public C46943a() {
        this.aEY = ByteBuffer.allocate(512);
        this.aEY.order(ByteOrder.LITTLE_ENDIAN);
        this.AyU = this.aEY.position();
        this.aEY.limit(this.aEY.capacity());
        this.AyV = true;
    }

    public C46943a(ByteBuffer byteBuffer) {
        this.aEY = byteBuffer;
        this.aEY.order(ByteOrder.LITTLE_ENDIAN);
        this.AyU = byteBuffer.limit();
        this.AyV = false;
    }

    /* renamed from: Rq */
    private void m89757Rq(int i) {
        if (this.aEY.position() + i > this.aEY.limit() && this.AyV) {
            byte[] array = this.aEY.array();
            byte[] bArr = new byte[((array.length + i) + (array.length >> 1))];
            System.arraycopy(array, 0, bArr, 0, this.aEY.position());
            int position = this.aEY.position();
            this.aEY = ByteBuffer.wrap(bArr);
            this.aEY.order(ByteOrder.LITTLE_ENDIAN);
            this.aEY.position(position);
            this.aEY.limit(this.aEY.capacity());
        }
    }

    public final byte readByte() {
        return this.aEY.get();
    }

    /* renamed from: Rr */
    public final byte[] mo76206Rr(int i) {
        byte[] bArr = new byte[i];
        this.aEY.get(bArr);
        return bArr;
    }

    /* renamed from: Rs */
    private short[] m89758Rs(int i) {
        if (i == 0) {
            return AxX;
        }
        short[] sArr = new short[i];
        for (int i2 = 0; i2 < i; i2++) {
            sArr[i2] = this.aEY.getShort();
        }
        return sArr;
    }

    private int dRW() {
        return C16316o.m25141b(this);
    }

    private int dRX() {
        return C16316o.m25141b(this) - 1;
    }

    private int dRY() {
        return C16316o.m25139a(this);
    }

    public C44546s dRx() {
        int i = 0;
        int position = this.aEY.position();
        try {
            int b = C16316o.m25141b(this);
            char[] cArr = new char[b];
            while (true) {
                char readByte = (char) (readByte() & 255);
                if (readByte == 0) {
                    String str = new String(cArr, 0, i);
                    if (str.length() == b) {
                        return new C44546s(position, str);
                    }
                    throw new C36548j("Declared length " + b + " doesn't match decoded length of " + str.length());
                }
                cArr[i] = readByte;
                int readByte2;
                int i2;
                if (readByte < 128) {
                    i++;
                } else if ((readByte & 224) == C33250az.CTRL_INDEX) {
                    readByte2 = readByte() & 255;
                    if ((readByte2 & C33250az.CTRL_INDEX) != 128) {
                        throw new UTFDataFormatException("bad second byte");
                    }
                    i2 = i + 1;
                    cArr[i] = (char) (((readByte & 31) << 6) | (readByte2 & 63));
                    i = i2;
                } else if ((readByte & 240) == 224) {
                    readByte2 = readByte() & 255;
                    int readByte3 = readByte() & 255;
                    if ((readByte2 & C33250az.CTRL_INDEX) == 128 && (readByte3 & C33250az.CTRL_INDEX) == 128) {
                        i2 = i + 1;
                        cArr[i] = (char) ((((readByte & 15) << 12) | ((readByte2 & 63) << 6)) | (readByte3 & 63));
                        i = i2;
                    }
                } else {
                    throw new UTFDataFormatException("bad byte");
                }
            }
            throw new UTFDataFormatException("bad second or third byte");
        } catch (UTFDataFormatException e) {
            throw new C36548j(e);
        }
    }

    public C31088u dRy() {
        return new C31088u(this.aEY.position(), m89758Rs(this.aEY.getInt()));
    }

    public C5916n dRz() {
        return new C5916n(this.aEY.position(), readUnsignedShort(), readUnsignedShort(), this.aEY.getInt());
    }

    public C16317p dRA() {
        return new C16317p(this.aEY.position(), readUnsignedShort(), readUnsignedShort(), this.aEY.getInt());
    }

    public C41359r dRB() {
        return new C41359r(this.aEY.position(), this.aEY.getInt(), this.aEY.getInt(), this.aEY.getInt());
    }

    public C16313g dRD() {
        C16314a[] c16314aArr;
        C16315b[] c16315bArr;
        int position = this.aEY.position();
        int readUnsignedShort = readUnsignedShort();
        int readUnsignedShort2 = readUnsignedShort();
        int readUnsignedShort3 = readUnsignedShort();
        int readUnsignedShort4 = readUnsignedShort();
        int i = this.aEY.getInt();
        short[] Rs = m89758Rs(this.aEY.getInt());
        if (readUnsignedShort4 > 0) {
            int position2;
            int a;
            if ((Rs.length & 1) == 1) {
                skip(2);
            }
            int position3 = this.aEY.position();
            skip(readUnsignedShort4 * 8);
            int position4 = this.aEY.position();
            int b = C16316o.m25141b(this);
            c16314aArr = new C16314a[b];
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= b) {
                    break;
                }
                position2 = this.aEY.position() - position4;
                a = C16316o.m25139a(this);
                int abs = Math.abs(a);
                int[] iArr = new int[abs];
                int[] iArr2 = new int[abs];
                for (i2 = 0; i2 < abs; i2++) {
                    iArr[i2] = C16316o.m25141b(this);
                    iArr2[i2] = C16316o.m25141b(this);
                }
                if (a <= 0) {
                    i2 = C16316o.m25141b(this);
                } else {
                    i2 = -1;
                }
                c16314aArr[i3] = new C16314a(iArr, iArr2, i2, position2);
                i2 = i3 + 1;
            }
            position4 = this.aEY.position();
            this.aEY.position(position3);
            c16315bArr = new C16315b[readUnsignedShort4];
            position3 = 0;
            while (position3 < readUnsignedShort4) {
                b = this.aEY.getInt();
                position2 = readUnsignedShort();
                a = readUnsignedShort();
                i2 = 0;
                while (i2 < c16314aArr.length) {
                    if (c16314aArr[i2].offset == a) {
                        c16315bArr[position3] = new C16315b(b, position2, i2);
                        position3++;
                    } else {
                        i2++;
                    }
                }
                throw new IllegalArgumentException();
            }
            this.aEY.position(position4);
        } else {
            c16315bArr = AyS;
            c16314aArr = AyT;
        }
        return new C16313g(position, readUnsignedShort, readUnsignedShort2, readUnsignedShort3, i, Rs, c16315bArr, c16314aArr);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0050 A:{SYNTHETIC, Splitter:B:20:0x0050} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C36542h dRE() {
        Throwable th;
        int position = this.aEY.position();
        int b = C16316o.m25141b(this);
        int b2 = C16316o.m25141b(this);
        int[] iArr = new int[b2];
        for (int i = 0; i < b2; i++) {
            iArr[i] = C16316o.m25141b(this) - 1;
        }
        final ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(64);
            try {
                C250131 c250131 = new C24423b() {
                    public final void writeByte(int i) {
                        byteArrayOutputStream.write(i);
                    }
                };
                while (true) {
                    byte b3 = this.aEY.get();
                    byteArrayOutputStream.write(b3);
                    switch (b3) {
                        case (byte) 0:
                            C36542h c36542h = new C36542h(position, b, iArr, byteArrayOutputStream.toByteArray());
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception e) {
                            }
                            return c36542h;
                        case (byte) 1:
                            C16316o.m25140a(c250131, dRW());
                            break;
                        case (byte) 2:
                            C16316o.m25144c(c250131, dRY());
                            break;
                        case (byte) 3:
                        case (byte) 4:
                            C16316o.m25140a(c250131, dRW());
                            C16316o.m25142b(c250131, dRX());
                            C16316o.m25142b(c250131, dRX());
                            if (b3 != (byte) 4) {
                                break;
                            }
                            C16316o.m25142b(c250131, dRX());
                            break;
                        case (byte) 5:
                        case (byte) 6:
                            C16316o.m25140a(c250131, dRW());
                            break;
                        case (byte) 9:
                            C16316o.m25142b(c250131, dRX());
                            break;
                        default:
                            break;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (byteArrayOutputStream != null) {
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (Exception e2) {
                }
            }
            throw th;
        }
    }

    public C5914e dRF() {
        return new C5914e(this.aEY.position(), m89759Rt(C16316o.m25141b(this)), m89759Rt(C16316o.m25141b(this)), m89760Ru(C16316o.m25141b(this)), m89760Ru(C16316o.m25141b(this)));
    }

    /* renamed from: Rt */
    private C5912a[] m89759Rt(int i) {
        C5912a[] c5912aArr = new C5912a[i];
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            int b = C16316o.m25141b(this) + i3;
            c5912aArr[i2] = new C5912a(b, C16316o.m25141b(this));
            i2++;
            i3 = b;
        }
        return c5912aArr;
    }

    /* renamed from: Ru */
    private C5913b[] m89760Ru(int i) {
        C5913b[] c5913bArr = new C5913b[i];
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            int b = C16316o.m25141b(this) + i3;
            c5913bArr[i2] = new C5913b(b, C16316o.m25141b(this), C16316o.m25141b(this));
            i2++;
            i3 = b;
        }
        return c5913bArr;
    }

    /* renamed from: Rv */
    private byte[] m89761Rv(int i) {
        byte[] bArr = new byte[(this.aEY.position() - i)];
        this.aEY.position(i);
        this.aEY.get(bArr);
        return bArr;
    }

    public C46808a dRG() {
        int position = this.aEY.position();
        byte b = this.aEY.get();
        int position2 = this.aEY.position();
        new C5915m((C46809a) this, 29).skipValue();
        return new C46808a(position, b, new C44545k(position2, m89761Rv(position2)));
    }

    public C41358b dRH() {
        int position = this.aEY.position();
        int i = this.aEY.getInt();
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = this.aEY.getInt();
        }
        return new C41358b(position, iArr);
    }

    public C46810c dRI() {
        int position = this.aEY.position();
        int i = this.aEY.getInt();
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = this.aEY.getInt();
        }
        return new C46810c(position, iArr);
    }

    public C16311d dRJ() {
        int i;
        int position = this.aEY.position();
        int i2 = this.aEY.getInt();
        int i3 = this.aEY.getInt();
        int i4 = this.aEY.getInt();
        int i5 = this.aEY.getInt();
        int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, new int[]{i3, 2});
        for (i = 0; i < i3; i++) {
            iArr[i][0] = this.aEY.getInt();
            iArr[i][1] = this.aEY.getInt();
        }
        int[][] iArr2 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{i4, 2});
        for (i = 0; i < i4; i++) {
            iArr2[i][0] = this.aEY.getInt();
            iArr2[i][1] = this.aEY.getInt();
        }
        int[][] iArr3 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{i5, 2});
        for (i = 0; i < i5; i++) {
            iArr3[i][0] = this.aEY.getInt();
            iArr3[i][1] = this.aEY.getInt();
        }
        return new C16311d(position, i2, iArr, iArr2, iArr3);
    }

    public C44545k dRK() {
        int position = this.aEY.position();
        new C5915m((C46809a) this, 28).skipValue();
        return new C44545k(position, m89761Rv(position));
    }

    private void skip(int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        this.aEY.position(this.aEY.position() + i);
    }

    public final void dRZ() {
        this.aEY.position((this.aEY.position() + 3) & -4);
    }

    public final void dSa() {
        m89757Rq((((this.aEY.position() + 3) & -4) - this.aEY.position()) * 1);
        while ((this.aEY.position() & 3) != 0) {
            this.aEY.put((byte) 0);
        }
        if (this.aEY.position() > this.AyU) {
            this.AyU = this.aEY.position();
        }
    }

    public final void writeByte(int i) {
        m89757Rq(1);
        this.aEY.put((byte) i);
        if (this.aEY.position() > this.AyU) {
            this.AyU = this.aEY.position();
        }
    }

    public final void writeShort(short s) {
        m89757Rq(2);
        this.aEY.putShort(s);
        if (this.aEY.position() > this.AyU) {
            this.AyU = this.aEY.position();
        }
    }

    /* renamed from: Rw */
    private void m89762Rw(int i) {
        short s = (short) i;
        if (i != (CdnLogic.kBizGeneric & s)) {
            throw new IllegalArgumentException("Expected an unsigned short: ".concat(String.valueOf(i)));
        }
        writeShort(s);
    }

    public final void writeInt(int i) {
        m89757Rq(4);
        this.aEY.putInt(i);
        if (this.aEY.position() > this.AyU) {
            this.AyU = this.aEY.position();
        }
    }

    public final void write(byte[] bArr) {
        m89757Rq(bArr.length * 1);
        this.aEY.put(bArr);
        if (this.aEY.position() > this.AyU) {
            this.AyU = this.aEY.position();
        }
    }

    /* renamed from: a */
    public int mo57813a(C44546s c44546s) {
        int position = this.aEY.position();
        try {
            C16316o.m25140a(this, c44546s.value.length());
            String str = c44546s.value;
            long j = 0;
            int length = str.length();
            int i = 0;
            while (i < length) {
                long j2;
                char charAt = str.charAt(i);
                if (charAt != 0 && charAt <= 127) {
                    j2 = 1 + j;
                } else if (charAt <= 2047) {
                    j2 = 2 + j;
                } else {
                    j2 = 3 + j;
                }
                if (j2 > 65535) {
                    throw new UTFDataFormatException("String more than 65535 UTF bytes long");
                }
                i++;
                j = j2;
            }
            byte[] bArr = new byte[((int) j)];
            C46811q.m89019c(bArr, 0, str);
            write(bArr);
            writeByte(0);
            return position;
        } catch (UTFDataFormatException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: a */
    public int mo57814a(C31088u c31088u) {
        int position = this.aEY.position();
        short[] sArr = c31088u.AyR;
        writeInt(sArr.length);
        for (short writeShort : sArr) {
            writeShort(writeShort);
        }
        return position;
    }

    /* renamed from: a */
    public int mo57810a(C5916n c5916n) {
        int position = this.aEY.position();
        m89762Rw(c5916n.Aym);
        m89762Rw(c5916n.AxA);
        writeInt(c5916n.Ayn);
        return position;
    }

    /* renamed from: a */
    public int mo57811a(C16317p c16317p) {
        int position = this.aEY.position();
        m89762Rw(c16317p.Aym);
        m89762Rw(c16317p.Ayo);
        writeInt(c16317p.Ayn);
        return position;
    }

    /* renamed from: a */
    public int mo57812a(C41359r c41359r) {
        int position = this.aEY.position();
        writeInt(c41359r.Ayp);
        writeInt(c41359r.Ayq);
        writeInt(c41359r.Ayr);
        return position;
    }

    /* renamed from: a */
    public int mo57806a(C16312f c16312f) {
        int position = this.aEY.position();
        writeInt(c16312f.AxA);
        writeInt(c16312f.Axx);
        writeInt(c16312f.AxB);
        writeInt(c16312f.AxC);
        writeInt(c16312f.AxD);
        writeInt(c16312f.AxE);
        writeInt(c16312f.AxF);
        writeInt(c16312f.AxG);
        return position;
    }

    /* renamed from: a */
    public int mo57807a(C16313g c16313g) {
        int length;
        int position;
        int i = 0;
        int position2 = this.aEY.position();
        m89762Rw(c16313g.AxH);
        m89762Rw(c16313g.AxI);
        m89762Rw(c16313g.AxJ);
        m89762Rw(c16313g.AxM.length);
        writeInt(c16313g.AxK);
        writeInt(c16313g.AxL.length);
        short[] sArr = c16313g.AxL;
        m89757Rq(sArr.length * 2);
        for (short writeShort : sArr) {
            writeShort(writeShort);
        }
        if (this.aEY.position() > this.AyU) {
            this.AyU = this.aEY.position();
        }
        if (c16313g.AxM.length > 0) {
            if ((c16313g.AxL.length & 1) == 1) {
                writeShort((short) 0);
            }
            position = this.aEY.position();
            length = c16313g.AxM.length * 8;
            m89757Rq(length * 1);
            skip(length);
            C16314a[] c16314aArr = c16313g.AxN;
            int position3 = this.aEY.position();
            C16316o.m25140a(this, c16314aArr.length);
            int[] iArr = new int[c16314aArr.length];
            for (length = 0; length < c16314aArr.length; length++) {
                iArr[length] = this.aEY.position() - position3;
                C16314a c16314a = c16314aArr[length];
                int i2 = c16314a.AxQ;
                int[] iArr2 = c16314a.AxO;
                int[] iArr3 = c16314a.AxP;
                if (i2 != -1) {
                    C16316o.m25144c(this, -iArr2.length);
                } else {
                    C16316o.m25144c(this, iArr2.length);
                }
                for (int i3 = 0; i3 < iArr2.length; i3++) {
                    C16316o.m25140a(this, iArr2[i3]);
                    C16316o.m25140a(this, iArr3[i3]);
                }
                if (i2 != -1) {
                    C16316o.m25140a(this, i2);
                }
            }
            length = this.aEY.position();
            this.aEY.position(position);
            C16315b[] c16315bArr = c16313g.AxM;
            position = c16315bArr.length;
            while (i < position) {
                C16315b c16315b = c16315bArr[i];
                writeInt(c16315b.AxR);
                m89762Rw(c16315b.AxS);
                m89762Rw(iArr[c16315b.AxT]);
                i++;
            }
            this.aEY.position(length);
        }
        return position2;
    }

    /* renamed from: a */
    public int mo57808a(C36542h c36542h) {
        int position = this.aEY.position();
        C16316o.m25140a(this, c36542h.AxU);
        C16316o.m25140a(this, r2);
        for (int i : c36542h.AxV) {
            C16316o.m25140a(this, i + 1);
        }
        write(c36542h.AxW);
        return position;
    }

    /* renamed from: a */
    public int mo57805a(C5914e c5914e) {
        int position = this.aEY.position();
        C16316o.m25140a(this, c5914e.Axs.length);
        C16316o.m25140a(this, c5914e.Axt.length);
        C16316o.m25140a(this, c5914e.Axu.length);
        C16316o.m25140a(this, c5914e.Axv.length);
        m89763a(c5914e.Axs);
        m89763a(c5914e.Axt);
        m89764a(c5914e.Axu);
        m89764a(c5914e.Axv);
        return position;
    }

    /* renamed from: a */
    private void m89763a(C5912a[] c5912aArr) {
        int length = c5912aArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            C5912a c5912a = c5912aArr[i];
            C16316o.m25140a(this, c5912a.Axw - i2);
            int i3 = c5912a.Axw;
            C16316o.m25140a(this, c5912a.Axx);
            i++;
            i2 = i3;
        }
    }

    /* renamed from: a */
    private void m89764a(C5913b[] c5913bArr) {
        int length = c5913bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            C5913b c5913b = c5913bArr[i];
            C16316o.m25140a(this, c5913b.Axy - i2);
            int i3 = c5913b.Axy;
            C16316o.m25140a(this, c5913b.Axx);
            C16316o.m25140a(this, c5913b.Axz);
            i++;
            i2 = i3;
        }
    }

    /* renamed from: a */
    public int mo57801a(C46808a c46808a) {
        int position = this.aEY.position();
        writeByte(c46808a.Axk);
        mo57809a(c46808a.Axl);
        return position;
    }

    /* renamed from: a */
    public int mo57802a(C41358b c41358b) {
        int position = this.aEY.position();
        writeInt(c41358b.Axm.length);
        for (int writeInt : c41358b.Axm) {
            writeInt(writeInt);
        }
        return position;
    }

    /* renamed from: a */
    public int mo57803a(C46810c c46810c) {
        int position = this.aEY.position();
        writeInt(c46810c.Axn.length);
        for (int writeInt : c46810c.Axn) {
            writeInt(writeInt);
        }
        return position;
    }

    /* renamed from: a */
    public int mo57804a(C16311d c16311d) {
        int position = this.aEY.position();
        writeInt(c16311d.Axo);
        writeInt(c16311d.Axp.length);
        writeInt(c16311d.Axq.length);
        writeInt(c16311d.Axr.length);
        for (int[] iArr : c16311d.Axp) {
            writeInt(iArr[0]);
            writeInt(iArr[1]);
        }
        for (int[] iArr2 : c16311d.Axq) {
            writeInt(iArr2[0]);
            writeInt(iArr2[1]);
        }
        for (int[] iArr22 : c16311d.Axr) {
            writeInt(iArr22[0]);
            writeInt(iArr22[1]);
        }
        return position;
    }

    /* renamed from: a */
    public int mo57809a(C44545k c44545k) {
        int position = this.aEY.position();
        write(c44545k.data);
        return position;
    }

    private int readUnsignedShort() {
        return this.aEY.getShort() & CdnLogic.kBizGeneric;
    }

    public C16312f dRC() {
        return new C16312f(this.aEY.position(), this.aEY.getInt(), this.aEY.getInt(), this.aEY.getInt(), this.aEY.getInt(), this.aEY.getInt(), this.aEY.getInt(), this.aEY.getInt(), this.aEY.getInt());
    }
}
