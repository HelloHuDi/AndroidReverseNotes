package com.tencent.tinker.p676d.p677a;

import com.tencent.mars.cdn.CdnLogic;
import java.io.InputStream;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.zip.ZipException;

/* renamed from: com.tencent.tinker.d.a.f */
public final class C5931f implements Cloneable {
    public long AFe = -1;
    long AFp = -1;
    int AFq = -1;
    int AFr = -1;
    byte[] AFs;
    long AFt = -1;
    long AFu = -1;
    public String name;
    int oyB = -1;
    long size = -1;
    String vGv;

    public C5931f(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        String str2 = "Name";
        byte[] bytes = str.getBytes(Charset.forName("UTF-8"));
        if (bytes.length > CdnLogic.kBizGeneric) {
            throw new IllegalArgumentException(str2 + " too long: " + bytes.length);
        }
        this.name = str;
    }

    public C5931f(C5931f c5931f) {
        this.name = c5931f.name;
        this.vGv = c5931f.vGv;
        this.oyB = c5931f.oyB;
        this.size = c5931f.size;
        this.AFp = c5931f.AFp;
        this.AFe = c5931f.AFe;
        this.AFq = c5931f.AFq;
        this.AFr = c5931f.AFr;
        this.AFs = c5931f.AFs;
        this.AFt = c5931f.AFt;
        this.AFu = c5931f.AFu;
    }

    public C5931f(C5931f c5931f, String str) {
        this.name = str;
        this.vGv = c5931f.vGv;
        this.oyB = c5931f.oyB;
        this.size = c5931f.size;
        this.AFp = c5931f.AFp;
        this.AFe = c5931f.AFe;
        this.AFq = c5931f.AFq;
        this.AFr = c5931f.AFr;
        this.AFs = c5931f.AFs;
        this.AFt = c5931f.AFt;
        this.AFu = c5931f.AFu;
    }

    C5931f(byte[] bArr, InputStream inputStream, Charset charset) {
        C5930e.m9237b(inputStream, bArr, 0, 46);
        C5928b a = C7393c.m12647a(bArr, 46, ByteOrder.LITTLE_ENDIAN);
        int readInt = a.readInt();
        if (((long) readInt) != 33639248) {
            C5934g.m9242a("unknown", (long) inputStream.available(), "unknown", 0, "Central Directory Entry", readInt);
        }
        a.seek(8);
        int readShort = a.readShort() & CdnLogic.kBizGeneric;
        if ((readShort & 1) != 0) {
            throw new ZipException("Invalid General Purpose Bit Flag: ".concat(String.valueOf(readShort)));
        }
        if ((readShort & 2048) != 0) {
            charset = Charset.forName("UTF-8");
        }
        this.AFq = a.readShort() & CdnLogic.kBizGeneric;
        this.oyB = a.readShort() & CdnLogic.kBizGeneric;
        this.AFr = a.readShort() & CdnLogic.kBizGeneric;
        this.AFe = ((long) a.readInt()) & 4294967295L;
        this.AFp = ((long) a.readInt()) & 4294967295L;
        this.size = ((long) a.readInt()) & 4294967295L;
        readShort = a.readShort() & CdnLogic.kBizGeneric;
        int readShort2 = a.readShort() & CdnLogic.kBizGeneric;
        int readShort3 = a.readShort() & CdnLogic.kBizGeneric;
        a.seek(42);
        this.AFt = ((long) a.readInt()) & 4294967295L;
        byte[] bArr2 = new byte[readShort];
        C5930e.m9237b(inputStream, bArr2, 0, bArr2.length);
        if (C5931f.m9238cr(bArr2)) {
            throw new ZipException("Filename contains NUL byte: " + Arrays.toString(bArr2));
        }
        this.name = new String(bArr2, 0, bArr2.length, charset);
        if (readShort2 > 0) {
            this.AFs = new byte[readShort2];
            C5930e.m9237b(inputStream, this.AFs, 0, readShort2);
        }
        if (readShort3 > 0) {
            bArr2 = new byte[readShort3];
            C5930e.m9237b(inputStream, bArr2, 0, readShort3);
            this.vGv = new String(bArr2, 0, bArr2.length, charset);
        }
    }

    /* renamed from: cr */
    private static boolean m9238cr(byte[] bArr) {
        for (byte b : bArr) {
            if (b == (byte) 0) {
                return true;
            }
        }
        return false;
    }

    public final void setMethod(int i) {
        if (i == 0 || i == 8) {
            this.AFq = i;
            return;
        }
        throw new IllegalArgumentException("Bad method: ".concat(String.valueOf(i)));
    }

    public final void setSize(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("Bad size: ".concat(String.valueOf(j)));
        }
        this.size = j;
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("name:" + this.name);
        stringBuffer.append("\ncomment:" + this.vGv);
        stringBuffer.append("\ntime:" + this.oyB);
        stringBuffer.append("\nsize:" + this.size);
        stringBuffer.append("\ncompressedSize:" + this.AFp);
        stringBuffer.append("\ncrc:" + this.AFe);
        stringBuffer.append("\ncompressionMethod:" + this.AFq);
        stringBuffer.append("\nmodDate:" + this.AFr);
        stringBuffer.append("\nextra length:" + this.AFs.length);
        stringBuffer.append("\nlocalHeaderRelOffset:" + this.AFt);
        stringBuffer.append("\ndataOffset:" + this.AFu);
        return stringBuffer.toString();
    }

    public final Object clone() {
        try {
            C5931f c5931f = (C5931f) super.clone();
            c5931f.AFs = this.AFs != null ? (byte[]) this.AFs.clone() : null;
            return c5931f;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final int hashCode() {
        return this.name.hashCode();
    }
}
