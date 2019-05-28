package com.tencent.tinker.a.a.a;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.tinker.a.a.b.b;
import com.tencent.tinker.a.a.c;
import com.tencent.tinker.a.a.d;
import com.tencent.tinker.a.a.e;
import com.tencent.tinker.a.a.f;
import com.tencent.tinker.a.a.g;
import com.tencent.tinker.a.a.h;
import com.tencent.tinker.a.a.j;
import com.tencent.tinker.a.a.k;
import com.tencent.tinker.a.a.m;
import com.tencent.tinker.a.a.n;
import com.tencent.tinker.a.a.o;
import com.tencent.tinker.a.a.p;
import com.tencent.tinker.a.a.q;
import com.tencent.tinker.a.a.r;
import com.tencent.tinker.a.a.s;
import com.tencent.tinker.a.a.u;
import java.io.ByteArrayOutputStream;
import java.io.UTFDataFormatException;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class a implements com.tencent.tinker.a.a.b.a, b {
    private static final short[] AxX = new short[0];
    private static final g.b[] AyS = new g.b[0];
    private static final com.tencent.tinker.a.a.g.a[] AyT = new com.tencent.tinker.a.a.g.a[0];
    private int AyU;
    private boolean AyV;
    public ByteBuffer aEY;

    public a() {
        this.aEY = ByteBuffer.allocate(512);
        this.aEY.order(ByteOrder.LITTLE_ENDIAN);
        this.AyU = this.aEY.position();
        this.aEY.limit(this.aEY.capacity());
        this.AyV = true;
    }

    public a(ByteBuffer byteBuffer) {
        this.aEY = byteBuffer;
        this.aEY.order(ByteOrder.LITTLE_ENDIAN);
        this.AyU = byteBuffer.limit();
        this.AyV = false;
    }

    private void Rq(int i) {
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

    public final byte[] Rr(int i) {
        byte[] bArr = new byte[i];
        this.aEY.get(bArr);
        return bArr;
    }

    private short[] Rs(int i) {
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
        return o.b(this);
    }

    private int dRX() {
        return o.b(this) - 1;
    }

    private int dRY() {
        return o.a(this);
    }

    public s dRx() {
        int i = 0;
        int position = this.aEY.position();
        try {
            int b = o.b(this);
            char[] cArr = new char[b];
            while (true) {
                char readByte = (char) (readByte() & 255);
                if (readByte == 0) {
                    String str = new String(cArr, 0, i);
                    if (str.length() == b) {
                        return new s(position, str);
                    }
                    throw new j("Declared length " + b + " doesn't match decoded length of " + str.length());
                }
                cArr[i] = readByte;
                int readByte2;
                int i2;
                if (readByte < 128) {
                    i++;
                } else if ((readByte & 224) == az.CTRL_INDEX) {
                    readByte2 = readByte() & 255;
                    if ((readByte2 & az.CTRL_INDEX) != 128) {
                        throw new UTFDataFormatException("bad second byte");
                    }
                    i2 = i + 1;
                    cArr[i] = (char) (((readByte & 31) << 6) | (readByte2 & 63));
                    i = i2;
                } else if ((readByte & 240) == 224) {
                    readByte2 = readByte() & 255;
                    int readByte3 = readByte() & 255;
                    if ((readByte2 & az.CTRL_INDEX) == 128 && (readByte3 & az.CTRL_INDEX) == 128) {
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
            throw new j(e);
        }
    }

    public u dRy() {
        return new u(this.aEY.position(), Rs(this.aEY.getInt()));
    }

    public n dRz() {
        return new n(this.aEY.position(), readUnsignedShort(), readUnsignedShort(), this.aEY.getInt());
    }

    public p dRA() {
        return new p(this.aEY.position(), readUnsignedShort(), readUnsignedShort(), this.aEY.getInt());
    }

    public r dRB() {
        return new r(this.aEY.position(), this.aEY.getInt(), this.aEY.getInt(), this.aEY.getInt());
    }

    public g dRD() {
        com.tencent.tinker.a.a.g.a[] aVarArr;
        g.b[] bVarArr;
        int position = this.aEY.position();
        int readUnsignedShort = readUnsignedShort();
        int readUnsignedShort2 = readUnsignedShort();
        int readUnsignedShort3 = readUnsignedShort();
        int readUnsignedShort4 = readUnsignedShort();
        int i = this.aEY.getInt();
        short[] Rs = Rs(this.aEY.getInt());
        if (readUnsignedShort4 > 0) {
            int position2;
            int a;
            if ((Rs.length & 1) == 1) {
                skip(2);
            }
            int position3 = this.aEY.position();
            skip(readUnsignedShort4 * 8);
            int position4 = this.aEY.position();
            int b = o.b(this);
            aVarArr = new com.tencent.tinker.a.a.g.a[b];
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= b) {
                    break;
                }
                position2 = this.aEY.position() - position4;
                a = o.a(this);
                int abs = Math.abs(a);
                int[] iArr = new int[abs];
                int[] iArr2 = new int[abs];
                for (i2 = 0; i2 < abs; i2++) {
                    iArr[i2] = o.b(this);
                    iArr2[i2] = o.b(this);
                }
                if (a <= 0) {
                    i2 = o.b(this);
                } else {
                    i2 = -1;
                }
                aVarArr[i3] = new com.tencent.tinker.a.a.g.a(iArr, iArr2, i2, position2);
                i2 = i3 + 1;
            }
            position4 = this.aEY.position();
            this.aEY.position(position3);
            bVarArr = new g.b[readUnsignedShort4];
            position3 = 0;
            while (position3 < readUnsignedShort4) {
                b = this.aEY.getInt();
                position2 = readUnsignedShort();
                a = readUnsignedShort();
                i2 = 0;
                while (i2 < aVarArr.length) {
                    if (aVarArr[i2].offset == a) {
                        bVarArr[position3] = new g.b(b, position2, i2);
                        position3++;
                    } else {
                        i2++;
                    }
                }
                throw new IllegalArgumentException();
            }
            this.aEY.position(position4);
        } else {
            bVarArr = AyS;
            aVarArr = AyT;
        }
        return new g(position, readUnsignedShort, readUnsignedShort2, readUnsignedShort3, i, Rs, bVarArr, aVarArr);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0050 A:{SYNTHETIC, Splitter:B:20:0x0050} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public h dRE() {
        Throwable th;
        int position = this.aEY.position();
        int b = o.b(this);
        int b2 = o.b(this);
        int[] iArr = new int[b2];
        for (int i = 0; i < b2; i++) {
            iArr[i] = o.b(this) - 1;
        }
        final ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(64);
            try {
                AnonymousClass1 anonymousClass1 = new b() {
                    public final void writeByte(int i) {
                        byteArrayOutputStream.write(i);
                    }
                };
                while (true) {
                    byte b3 = this.aEY.get();
                    byteArrayOutputStream.write(b3);
                    switch (b3) {
                        case (byte) 0:
                            h hVar = new h(position, b, iArr, byteArrayOutputStream.toByteArray());
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception e) {
                            }
                            return hVar;
                        case (byte) 1:
                            o.a(anonymousClass1, dRW());
                            break;
                        case (byte) 2:
                            o.c(anonymousClass1, dRY());
                            break;
                        case (byte) 3:
                        case (byte) 4:
                            o.a(anonymousClass1, dRW());
                            o.b(anonymousClass1, dRX());
                            o.b(anonymousClass1, dRX());
                            if (b3 != (byte) 4) {
                                break;
                            }
                            o.b(anonymousClass1, dRX());
                            break;
                        case (byte) 5:
                        case (byte) 6:
                            o.a(anonymousClass1, dRW());
                            break;
                        case (byte) 9:
                            o.b(anonymousClass1, dRX());
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

    public e dRF() {
        return new e(this.aEY.position(), Rt(o.b(this)), Rt(o.b(this)), Ru(o.b(this)), Ru(o.b(this)));
    }

    private com.tencent.tinker.a.a.e.a[] Rt(int i) {
        com.tencent.tinker.a.a.e.a[] aVarArr = new com.tencent.tinker.a.a.e.a[i];
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            int b = o.b(this) + i3;
            aVarArr[i2] = new com.tencent.tinker.a.a.e.a(b, o.b(this));
            i2++;
            i3 = b;
        }
        return aVarArr;
    }

    private e.b[] Ru(int i) {
        e.b[] bVarArr = new e.b[i];
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            int b = o.b(this) + i3;
            bVarArr[i2] = new e.b(b, o.b(this), o.b(this));
            i2++;
            i3 = b;
        }
        return bVarArr;
    }

    private byte[] Rv(int i) {
        byte[] bArr = new byte[(this.aEY.position() - i)];
        this.aEY.position(i);
        this.aEY.get(bArr);
        return bArr;
    }

    public com.tencent.tinker.a.a.a dRG() {
        int position = this.aEY.position();
        byte b = this.aEY.get();
        int position2 = this.aEY.position();
        new m((com.tencent.tinker.a.a.b.a) this, 29).skipValue();
        return new com.tencent.tinker.a.a.a(position, b, new k(position2, Rv(position2)));
    }

    public com.tencent.tinker.a.a.b dRH() {
        int position = this.aEY.position();
        int i = this.aEY.getInt();
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = this.aEY.getInt();
        }
        return new com.tencent.tinker.a.a.b(position, iArr);
    }

    public c dRI() {
        int position = this.aEY.position();
        int i = this.aEY.getInt();
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = this.aEY.getInt();
        }
        return new c(position, iArr);
    }

    public d dRJ() {
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
        return new d(position, i2, iArr, iArr2, iArr3);
    }

    public k dRK() {
        int position = this.aEY.position();
        new m((com.tencent.tinker.a.a.b.a) this, 28).skipValue();
        return new k(position, Rv(position));
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
        Rq((((this.aEY.position() + 3) & -4) - this.aEY.position()) * 1);
        while ((this.aEY.position() & 3) != 0) {
            this.aEY.put((byte) 0);
        }
        if (this.aEY.position() > this.AyU) {
            this.AyU = this.aEY.position();
        }
    }

    public final void writeByte(int i) {
        Rq(1);
        this.aEY.put((byte) i);
        if (this.aEY.position() > this.AyU) {
            this.AyU = this.aEY.position();
        }
    }

    public final void writeShort(short s) {
        Rq(2);
        this.aEY.putShort(s);
        if (this.aEY.position() > this.AyU) {
            this.AyU = this.aEY.position();
        }
    }

    private void Rw(int i) {
        short s = (short) i;
        if (i != (CdnLogic.kBizGeneric & s)) {
            throw new IllegalArgumentException("Expected an unsigned short: ".concat(String.valueOf(i)));
        }
        writeShort(s);
    }

    public final void writeInt(int i) {
        Rq(4);
        this.aEY.putInt(i);
        if (this.aEY.position() > this.AyU) {
            this.AyU = this.aEY.position();
        }
    }

    public final void write(byte[] bArr) {
        Rq(bArr.length * 1);
        this.aEY.put(bArr);
        if (this.aEY.position() > this.AyU) {
            this.AyU = this.aEY.position();
        }
    }

    public int a(s sVar) {
        int position = this.aEY.position();
        try {
            o.a(this, sVar.value.length());
            String str = sVar.value;
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
            q.c(bArr, 0, str);
            write(bArr);
            writeByte(0);
            return position;
        } catch (UTFDataFormatException e) {
            throw new AssertionError(e);
        }
    }

    public int a(u uVar) {
        int position = this.aEY.position();
        short[] sArr = uVar.AyR;
        writeInt(sArr.length);
        for (short writeShort : sArr) {
            writeShort(writeShort);
        }
        return position;
    }

    public int a(n nVar) {
        int position = this.aEY.position();
        Rw(nVar.Aym);
        Rw(nVar.AxA);
        writeInt(nVar.Ayn);
        return position;
    }

    public int a(p pVar) {
        int position = this.aEY.position();
        Rw(pVar.Aym);
        Rw(pVar.Ayo);
        writeInt(pVar.Ayn);
        return position;
    }

    public int a(r rVar) {
        int position = this.aEY.position();
        writeInt(rVar.Ayp);
        writeInt(rVar.Ayq);
        writeInt(rVar.Ayr);
        return position;
    }

    public int a(f fVar) {
        int position = this.aEY.position();
        writeInt(fVar.AxA);
        writeInt(fVar.Axx);
        writeInt(fVar.AxB);
        writeInt(fVar.AxC);
        writeInt(fVar.AxD);
        writeInt(fVar.AxE);
        writeInt(fVar.AxF);
        writeInt(fVar.AxG);
        return position;
    }

    public int a(g gVar) {
        int length;
        int position;
        int i = 0;
        int position2 = this.aEY.position();
        Rw(gVar.AxH);
        Rw(gVar.AxI);
        Rw(gVar.AxJ);
        Rw(gVar.AxM.length);
        writeInt(gVar.AxK);
        writeInt(gVar.AxL.length);
        short[] sArr = gVar.AxL;
        Rq(sArr.length * 2);
        for (short writeShort : sArr) {
            writeShort(writeShort);
        }
        if (this.aEY.position() > this.AyU) {
            this.AyU = this.aEY.position();
        }
        if (gVar.AxM.length > 0) {
            if ((gVar.AxL.length & 1) == 1) {
                writeShort((short) 0);
            }
            position = this.aEY.position();
            length = gVar.AxM.length * 8;
            Rq(length * 1);
            skip(length);
            com.tencent.tinker.a.a.g.a[] aVarArr = gVar.AxN;
            int position3 = this.aEY.position();
            o.a(this, aVarArr.length);
            int[] iArr = new int[aVarArr.length];
            for (length = 0; length < aVarArr.length; length++) {
                iArr[length] = this.aEY.position() - position3;
                com.tencent.tinker.a.a.g.a aVar = aVarArr[length];
                int i2 = aVar.AxQ;
                int[] iArr2 = aVar.AxO;
                int[] iArr3 = aVar.AxP;
                if (i2 != -1) {
                    o.c(this, -iArr2.length);
                } else {
                    o.c(this, iArr2.length);
                }
                for (int i3 = 0; i3 < iArr2.length; i3++) {
                    o.a(this, iArr2[i3]);
                    o.a(this, iArr3[i3]);
                }
                if (i2 != -1) {
                    o.a(this, i2);
                }
            }
            length = this.aEY.position();
            this.aEY.position(position);
            g.b[] bVarArr = gVar.AxM;
            position = bVarArr.length;
            while (i < position) {
                g.b bVar = bVarArr[i];
                writeInt(bVar.AxR);
                Rw(bVar.AxS);
                Rw(iArr[bVar.AxT]);
                i++;
            }
            this.aEY.position(length);
        }
        return position2;
    }

    public int a(h hVar) {
        int position = this.aEY.position();
        o.a(this, hVar.AxU);
        o.a(this, r2);
        for (int i : hVar.AxV) {
            o.a(this, i + 1);
        }
        write(hVar.AxW);
        return position;
    }

    public int a(e eVar) {
        int position = this.aEY.position();
        o.a(this, eVar.Axs.length);
        o.a(this, eVar.Axt.length);
        o.a(this, eVar.Axu.length);
        o.a(this, eVar.Axv.length);
        a(eVar.Axs);
        a(eVar.Axt);
        a(eVar.Axu);
        a(eVar.Axv);
        return position;
    }

    private void a(com.tencent.tinker.a.a.e.a[] aVarArr) {
        int length = aVarArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            com.tencent.tinker.a.a.e.a aVar = aVarArr[i];
            o.a(this, aVar.Axw - i2);
            int i3 = aVar.Axw;
            o.a(this, aVar.Axx);
            i++;
            i2 = i3;
        }
    }

    private void a(e.b[] bVarArr) {
        int length = bVarArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            e.b bVar = bVarArr[i];
            o.a(this, bVar.Axy - i2);
            int i3 = bVar.Axy;
            o.a(this, bVar.Axx);
            o.a(this, bVar.Axz);
            i++;
            i2 = i3;
        }
    }

    public int a(com.tencent.tinker.a.a.a aVar) {
        int position = this.aEY.position();
        writeByte(aVar.Axk);
        a(aVar.Axl);
        return position;
    }

    public int a(com.tencent.tinker.a.a.b bVar) {
        int position = this.aEY.position();
        writeInt(bVar.Axm.length);
        for (int writeInt : bVar.Axm) {
            writeInt(writeInt);
        }
        return position;
    }

    public int a(c cVar) {
        int position = this.aEY.position();
        writeInt(cVar.Axn.length);
        for (int writeInt : cVar.Axn) {
            writeInt(writeInt);
        }
        return position;
    }

    public int a(d dVar) {
        int position = this.aEY.position();
        writeInt(dVar.Axo);
        writeInt(dVar.Axp.length);
        writeInt(dVar.Axq.length);
        writeInt(dVar.Axr.length);
        for (int[] iArr : dVar.Axp) {
            writeInt(iArr[0]);
            writeInt(iArr[1]);
        }
        for (int[] iArr2 : dVar.Axq) {
            writeInt(iArr2[0]);
            writeInt(iArr2[1]);
        }
        for (int[] iArr22 : dVar.Axr) {
            writeInt(iArr22[0]);
            writeInt(iArr22[1]);
        }
        return position;
    }

    public int a(k kVar) {
        int position = this.aEY.position();
        write(kVar.data);
        return position;
    }

    private int readUnsignedShort() {
        return this.aEY.getShort() & CdnLogic.kBizGeneric;
    }

    public f dRC() {
        return new f(this.aEY.position(), this.aEY.getInt(), this.aEY.getInt(), this.aEY.getInt(), this.aEY.getInt(), this.aEY.getInt(), this.aEY.getInt(), this.aEY.getInt(), this.aEY.getInt());
    }
}
