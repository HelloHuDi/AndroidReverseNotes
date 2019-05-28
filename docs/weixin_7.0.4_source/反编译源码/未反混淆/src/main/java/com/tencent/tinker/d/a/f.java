package com.tencent.tinker.d.a;

import com.tencent.mars.cdn.CdnLogic;
import java.io.InputStream;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.zip.ZipException;

public final class f implements Cloneable {
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

    public f(String str) {
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

    public f(f fVar) {
        this.name = fVar.name;
        this.vGv = fVar.vGv;
        this.oyB = fVar.oyB;
        this.size = fVar.size;
        this.AFp = fVar.AFp;
        this.AFe = fVar.AFe;
        this.AFq = fVar.AFq;
        this.AFr = fVar.AFr;
        this.AFs = fVar.AFs;
        this.AFt = fVar.AFt;
        this.AFu = fVar.AFu;
    }

    public f(f fVar, String str) {
        this.name = str;
        this.vGv = fVar.vGv;
        this.oyB = fVar.oyB;
        this.size = fVar.size;
        this.AFp = fVar.AFp;
        this.AFe = fVar.AFe;
        this.AFq = fVar.AFq;
        this.AFr = fVar.AFr;
        this.AFs = fVar.AFs;
        this.AFt = fVar.AFt;
        this.AFu = fVar.AFu;
    }

    f(byte[] bArr, InputStream inputStream, Charset charset) {
        e.b(inputStream, bArr, 0, 46);
        b a = c.a(bArr, 46, ByteOrder.LITTLE_ENDIAN);
        int readInt = a.readInt();
        if (((long) readInt) != 33639248) {
            g.a("unknown", (long) inputStream.available(), "unknown", 0, "Central Directory Entry", readInt);
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
        e.b(inputStream, bArr2, 0, bArr2.length);
        if (cr(bArr2)) {
            throw new ZipException("Filename contains NUL byte: " + Arrays.toString(bArr2));
        }
        this.name = new String(bArr2, 0, bArr2.length, charset);
        if (readShort2 > 0) {
            this.AFs = new byte[readShort2];
            e.b(inputStream, this.AFs, 0, readShort2);
        }
        if (readShort3 > 0) {
            bArr2 = new byte[readShort3];
            e.b(inputStream, bArr2, 0, readShort3);
            this.vGv = new String(bArr2, 0, bArr2.length, charset);
        }
    }

    private static boolean cr(byte[] bArr) {
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
            f fVar = (f) super.clone();
            fVar.AFs = this.AFs != null ? (byte[]) this.AFs.clone() : null;
            return fVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final int hashCode() {
        return this.name.hashCode();
    }
}
