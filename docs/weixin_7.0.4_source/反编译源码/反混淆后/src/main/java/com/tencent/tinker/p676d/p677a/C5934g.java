package com.tencent.tinker.p676d.p677a;

import com.tencent.mars.cdn.CdnLogic;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.zip.ZipException;

/* renamed from: com.tencent.tinker.d.a.g */
public final class C5934g implements Closeable {
    private final LinkedHashMap<String, C5931f> AFv;
    private File AFw;
    private RandomAccessFile AFx;
    private final String filename;
    public String vGv;

    /* renamed from: com.tencent.tinker.d.a.g$a */
    public static class C5933a extends InputStream {
        private final RandomAccessFile AFz;
        private long bfq;
        /* renamed from: xb */
        private long f1676xb;

        private C5933a(RandomAccessFile randomAccessFile, long j, long j2) {
            this.AFz = randomAccessFile;
            this.f1676xb = j;
            this.bfq = j2;
        }

        public C5933a(RandomAccessFile randomAccessFile, long j) {
            this(randomAccessFile, j, randomAccessFile.length());
        }

        public final int available() {
            return this.f1676xb < this.bfq ? 1 : 0;
        }

        public final int read() {
            return C5930e.m9236N(this);
        }

        public final int read(byte[] bArr, int i, int i2) {
            int read;
            synchronized (this.AFz) {
                long j = this.bfq - this.f1676xb;
                if (((long) i2) > j) {
                    i2 = (int) j;
                }
                this.AFz.seek(this.f1676xb);
                read = this.AFz.read(bArr, i, i2);
                if (read > 0) {
                    this.f1676xb += (long) read;
                } else {
                    read = -1;
                }
            }
            return read;
        }

        public final long skip(long j) {
            if (j > this.bfq - this.f1676xb) {
                j = this.bfq - this.f1676xb;
            }
            this.f1676xb += j;
            return j;
        }
    }

    public C5934g(File file) {
        this(file, (byte) 0);
    }

    public C5934g(String str) {
        this(new File(str), (byte) 0);
    }

    private C5934g(File file, byte b) {
        this.AFv = new LinkedHashMap();
        this.filename = file.getPath();
        this.AFw = null;
        this.AFx = new RandomAccessFile(this.filename, "r");
        dSv();
    }

    /* renamed from: a */
    static void m9242a(String str, long j, String str2, long j2, String str3, int i) {
        throw new ZipException("file name:" + str + ", file size" + j + ", entry name:" + str2 + ", entry localHeaderRelOffset:" + j2 + ", " + str3 + " signature not found; was " + Integer.toHexString(i));
    }

    public final void close() {
        RandomAccessFile randomAccessFile = this.AFx;
        if (randomAccessFile != null) {
            synchronized (randomAccessFile) {
                this.AFx = null;
                randomAccessFile.close();
            }
            if (this.AFw != null) {
                this.AFw.delete();
                this.AFw = null;
            }
        }
    }

    /* renamed from: lO */
    public final void mo12618lO() {
        if (this.AFx == null) {
            throw new IllegalStateException("Zip file closed");
        }
    }

    public final Enumeration<? extends C5931f> entries() {
        mo12618lO();
        final Iterator it = this.AFv.values().iterator();
        return new Enumeration<C5931f>() {
            public final boolean hasMoreElements() {
                C5934g.this.mo12618lO();
                return it.hasNext();
            }

            public final /* synthetic */ Object nextElement() {
                C5934g.this.mo12618lO();
                return (C5931f) it.next();
            }
        };
    }

    public final C5931f auw(String str) {
        mo12618lO();
        if (str == null) {
            throw new NullPointerException("entryName == null");
        }
        C5931f c5931f = (C5931f) this.AFv.get(str);
        if (c5931f == null) {
            return (C5931f) this.AFv.get(str + "/");
        }
        return c5931f;
    }

    /* renamed from: a */
    public final InputStream mo12614a(C5931f c5931f) {
        C5931f auw = auw(c5931f.name);
        if (auw == null) {
            return null;
        }
        InputStream c5933a;
        RandomAccessFile randomAccessFile = this.AFx;
        synchronized (randomAccessFile) {
            c5933a = new C5933a(randomAccessFile, auw.AFt);
            DataInputStream dataInputStream = new DataInputStream(c5933a);
            int reverseBytes = Integer.reverseBytes(dataInputStream.readInt());
            if (((long) reverseBytes) != 67324752) {
                C5934g.m9242a(this.filename, randomAccessFile.length(), auw.name, auw.AFt, "Local File Header", reverseBytes);
            }
            dataInputStream.skipBytes(2);
            int reverseBytes2 = Short.reverseBytes(dataInputStream.readShort()) & CdnLogic.kBizGeneric;
            if ((reverseBytes2 & 1) != 0) {
                throw new ZipException("Invalid General Purpose Bit Flag: ".concat(String.valueOf(reverseBytes2)));
            }
            dataInputStream.skipBytes(18);
            reverseBytes2 = Short.reverseBytes(dataInputStream.readShort()) & CdnLogic.kBizGeneric;
            int reverseBytes3 = Short.reverseBytes(dataInputStream.readShort()) & CdnLogic.kBizGeneric;
            dataInputStream.close();
            c5933a.skip((long) (reverseBytes2 + reverseBytes3));
            if (auw.AFq == 0) {
                c5933a.bfq = c5933a.f1676xb + auw.size;
            } else {
                c5933a.bfq = c5933a.f1676xb + auw.AFp;
            }
        }
        return c5933a;
    }

    private void dSv() {
        long j = 0;
        long length = this.AFx.length() - 22;
        if (length < 0) {
            throw new ZipException("File too short to be a zip file: " + this.AFx.length());
        }
        this.AFx.seek(0);
        if (((long) Integer.reverseBytes(this.AFx.readInt())) != 67324752) {
            throw new ZipException("Not a zip archive");
        }
        long j2 = length - 65536;
        if (j2 >= 0) {
            j = j2;
        }
        while (true) {
            this.AFx.seek(length);
            if (((long) Integer.reverseBytes(this.AFx.readInt())) != 101010256) {
                j2 = length - 1;
                if (j2 < j) {
                    throw new ZipException("End Of Central Directory signature not found");
                }
                length = j2;
            } else {
                byte[] bArr = new byte[18];
                this.AFx.readFully(bArr);
                C5928b a = C7393c.m12647a(bArr, 18, ByteOrder.LITTLE_ENDIAN);
                int readShort = a.readShort() & CdnLogic.kBizGeneric;
                int readShort2 = a.readShort() & CdnLogic.kBizGeneric;
                int readShort3 = a.readShort() & CdnLogic.kBizGeneric;
                int readShort4 = a.readShort() & CdnLogic.kBizGeneric;
                a.dSu();
                long readInt = ((long) a.readInt()) & 4294967295L;
                int readShort5 = a.readShort() & CdnLogic.kBizGeneric;
                if (readShort3 == readShort4 && readShort == 0 && readShort2 == 0) {
                    if (readShort5 > 0) {
                        bArr = new byte[readShort5];
                        this.AFx.readFully(bArr);
                        this.vGv = new String(bArr, 0, bArr.length, C5929d.UTF_8);
                    }
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(new C5933a(this.AFx, readInt), 4096);
                    byte[] bArr2 = new byte[46];
                    for (readShort5 = 0; readShort5 < readShort3; readShort5++) {
                        C5931f c5931f = new C5931f(bArr2, bufferedInputStream, C5929d.UTF_8);
                        if (c5931f.AFt >= readInt) {
                            throw new ZipException("Local file header offset is after central directory");
                        }
                        String str = c5931f.name;
                        if (this.AFv.put(str, c5931f) != null) {
                            throw new ZipException("Duplicate entry name: ".concat(String.valueOf(str)));
                        }
                    }
                    return;
                }
                throw new ZipException("Spanned archives not supported");
            }
        }
    }
}
