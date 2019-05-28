package com.tencent.tinker.d.a;

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

public final class g implements Closeable {
    private final LinkedHashMap<String, f> AFv;
    private File AFw;
    private RandomAccessFile AFx;
    private final String filename;
    public String vGv;

    public static class a extends InputStream {
        private final RandomAccessFile AFz;
        private long bfq;
        private long xb;

        private a(RandomAccessFile randomAccessFile, long j, long j2) {
            this.AFz = randomAccessFile;
            this.xb = j;
            this.bfq = j2;
        }

        public a(RandomAccessFile randomAccessFile, long j) {
            this(randomAccessFile, j, randomAccessFile.length());
        }

        public final int available() {
            return this.xb < this.bfq ? 1 : 0;
        }

        public final int read() {
            return e.N(this);
        }

        public final int read(byte[] bArr, int i, int i2) {
            int read;
            synchronized (this.AFz) {
                long j = this.bfq - this.xb;
                if (((long) i2) > j) {
                    i2 = (int) j;
                }
                this.AFz.seek(this.xb);
                read = this.AFz.read(bArr, i, i2);
                if (read > 0) {
                    this.xb += (long) read;
                } else {
                    read = -1;
                }
            }
            return read;
        }

        public final long skip(long j) {
            if (j > this.bfq - this.xb) {
                j = this.bfq - this.xb;
            }
            this.xb += j;
            return j;
        }
    }

    public g(File file) {
        this(file, (byte) 0);
    }

    public g(String str) {
        this(new File(str), (byte) 0);
    }

    private g(File file, byte b) {
        this.AFv = new LinkedHashMap();
        this.filename = file.getPath();
        this.AFw = null;
        this.AFx = new RandomAccessFile(this.filename, "r");
        dSv();
    }

    static void a(String str, long j, String str2, long j2, String str3, int i) {
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

    public final void lO() {
        if (this.AFx == null) {
            throw new IllegalStateException("Zip file closed");
        }
    }

    public final Enumeration<? extends f> entries() {
        lO();
        final Iterator it = this.AFv.values().iterator();
        return new Enumeration<f>() {
            public final boolean hasMoreElements() {
                g.this.lO();
                return it.hasNext();
            }

            public final /* synthetic */ Object nextElement() {
                g.this.lO();
                return (f) it.next();
            }
        };
    }

    public final f auw(String str) {
        lO();
        if (str == null) {
            throw new NullPointerException("entryName == null");
        }
        f fVar = (f) this.AFv.get(str);
        if (fVar == null) {
            return (f) this.AFv.get(str + "/");
        }
        return fVar;
    }

    public final InputStream a(f fVar) {
        f auw = auw(fVar.name);
        if (auw == null) {
            return null;
        }
        InputStream aVar;
        RandomAccessFile randomAccessFile = this.AFx;
        synchronized (randomAccessFile) {
            aVar = new a(randomAccessFile, auw.AFt);
            DataInputStream dataInputStream = new DataInputStream(aVar);
            int reverseBytes = Integer.reverseBytes(dataInputStream.readInt());
            if (((long) reverseBytes) != 67324752) {
                a(this.filename, randomAccessFile.length(), auw.name, auw.AFt, "Local File Header", reverseBytes);
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
            aVar.skip((long) (reverseBytes2 + reverseBytes3));
            if (auw.AFq == 0) {
                aVar.bfq = aVar.xb + auw.size;
            } else {
                aVar.bfq = aVar.xb + auw.AFp;
            }
        }
        return aVar;
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
                b a = c.a(bArr, 18, ByteOrder.LITTLE_ENDIAN);
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
                        this.vGv = new String(bArr, 0, bArr.length, d.UTF_8);
                    }
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(new a(this.AFx, readInt), 4096);
                    byte[] bArr2 = new byte[46];
                    for (readShort5 = 0; readShort5 < readShort3; readShort5++) {
                        f fVar = new f(bArr2, bufferedInputStream, d.UTF_8);
                        if (fVar.AFt >= readInt) {
                            throw new ZipException("Local file header offset is after central directory");
                        }
                        String str = fVar.name;
                        if (this.AFv.put(str, fVar) != null) {
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
