package com.tencent.tinker.p676d.p677a;

import com.tencent.mars.cdn.CdnLogic;
import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.zip.ZipException;

/* renamed from: com.tencent.tinker.d.a.h */
public final class C5935h extends FilterOutputStream {
    public static final byte[] AFA = new byte[0];
    private static final byte[] AFB = new byte[]{(byte) -1, (byte) -1, (byte) -1, (byte) -1};
    private final HashSet<String> AFC;
    private final boolean AFD;
    public byte[] AFE;
    private int AFF;
    private ByteArrayOutputStream AFG;
    private C5931f AFH;
    private byte[] AFI;
    private byte[] AFJ;
    private boolean AFK;
    /* renamed from: xb */
    private long f1677xb;

    public C5935h(OutputStream outputStream) {
        this(outputStream, (byte) 0);
    }

    private C5935h(OutputStream outputStream, byte b) {
        super(outputStream);
        this.AFC = new HashSet();
        this.AFE = AFA;
        this.AFF = 8;
        this.AFG = new ByteArrayOutputStream();
        this.f1677xb = 0;
        this.AFD = false;
    }

    /* renamed from: c */
    private static long m9247c(OutputStream outputStream, long j) {
        outputStream.write((int) (255 & j));
        outputStream.write(((int) (j >> 8)) & 255);
        outputStream.write(((int) (j >> 16)) & 255);
        outputStream.write(((int) (j >> 24)) & 255);
        return j;
    }

    /* renamed from: c */
    private static int m9246c(OutputStream outputStream, int i) {
        outputStream.write(i & 255);
        outputStream.write((i >> 8) & 255);
        return i;
    }

    public final void close() {
        if (this.out == null) {
            return;
        }
        if (this.out == null) {
            throw new IOException("Stream is closed");
        }
        if (this.AFG != null) {
            if (this.AFC.isEmpty()) {
                throw new ZipException("No entries");
            }
            if (this.AFH != null) {
                closeEntry();
            }
            int size = this.AFG.size();
            C5935h.m9247c(this.AFG, 101010256);
            C5935h.m9246c(this.AFG, 0);
            C5935h.m9246c(this.AFG, 0);
            if (this.AFK) {
                C5935h.m9246c(this.AFG, (int) CdnLogic.kBizGeneric);
                C5935h.m9246c(this.AFG, (int) CdnLogic.kBizGeneric);
                C5935h.m9247c(this.AFG, -1);
                C5935h.m9247c(this.AFG, -1);
            } else {
                C5935h.m9246c(this.AFG, this.AFC.size());
                C5935h.m9246c(this.AFG, this.AFC.size());
                C5935h.m9247c(this.AFG, (long) size);
                C5935h.m9247c(this.AFG, this.f1677xb);
            }
            C5935h.m9246c(this.AFG, this.AFE.length);
            if (this.AFE.length > 0) {
                this.AFG.write(this.AFE);
            }
            this.AFG.writeTo(this.out);
            this.AFG = null;
        }
        this.out.close();
        this.out = null;
    }

    public final void closeEntry() {
        dSw();
        if (this.AFH != null) {
            long j = 30;
            if (this.AFH.AFq != 0) {
                j = 46;
                C5935h.m9247c(this.out, 134695760);
                C5935h.m9247c(this.out, this.AFH.AFe);
                C5935h.m9247c(this.out, this.AFH.AFp);
                C5935h.m9247c(this.out, this.AFH.size);
            }
            int i = (this.AFH.AFq == 0 ? 0 : 8) | 2048;
            C5935h.m9247c(this.AFG, 33639248);
            C5935h.m9246c(this.AFG, 20);
            C5935h.m9246c(this.AFG, 20);
            C5935h.m9246c(this.AFG, i);
            C5935h.m9246c(this.AFG, this.AFH.AFq);
            C5935h.m9246c(this.AFG, this.AFH.oyB);
            C5935h.m9246c(this.AFG, this.AFH.AFr);
            C5935h.m9247c(this.AFG, this.AFH.AFe);
            if (this.AFH.AFq == 8) {
                j += this.AFH.AFp;
            } else {
                j += this.AFH.size;
            }
            C5935h.m9247c(this.AFG, this.AFH.AFp);
            C5935h.m9247c(this.AFG, this.AFH.size);
            j += (long) C5935h.m9246c(this.AFG, this.AFI.length);
            if (this.AFH.AFs != null) {
                j += (long) C5935h.m9246c(this.AFG, this.AFH.AFs.length);
            } else {
                C5935h.m9246c(this.AFG, 0);
            }
            C5935h.m9246c(this.AFG, this.AFJ.length);
            C5935h.m9246c(this.AFG, 0);
            C5935h.m9246c(this.AFG, 0);
            C5935h.m9247c(this.AFG, 0);
            C5935h.m9247c(this.AFG, this.AFH.AFt);
            this.AFG.write(this.AFI);
            this.AFI = null;
            if (this.AFH.AFs != null) {
                this.AFG.write(this.AFH.AFs);
            }
            this.f1677xb = j + this.f1677xb;
            if (this.AFJ.length > 0) {
                this.AFG.write(this.AFJ);
                this.AFJ = AFA;
            }
            this.AFH = null;
        }
    }

    /* renamed from: b */
    public final void mo12619b(C5931f c5931f) {
        int i;
        if (this.AFH != null) {
            closeEntry();
        }
        int i2 = c5931f.AFq;
        if (i2 == -1) {
            i = this.AFF;
        } else {
            i = i2;
        }
        if (i == 0) {
            if (c5931f.AFp == -1) {
                c5931f.AFp = c5931f.size;
            } else if (c5931f.size == -1) {
                c5931f.setSize(c5931f.AFp);
            }
            if (c5931f.AFe == -1) {
                throw new ZipException("STORED entry missing CRC");
            } else if (c5931f.size == -1) {
                throw new ZipException("STORED entry missing size");
            } else if (c5931f.size != c5931f.AFp) {
                throw new ZipException("STORED entry size/compressed size mismatch");
            }
        }
        dSw();
        c5931f.vGv = null;
        c5931f.AFs = null;
        c5931f.oyB = 40691;
        c5931f.AFr = 18698;
        this.AFI = c5931f.name.getBytes(C5929d.UTF_8);
        C5935h.m9245G("Name", this.AFI);
        this.AFJ = AFA;
        if (c5931f.vGv != null) {
            this.AFJ = c5931f.vGv.getBytes(C5929d.UTF_8);
            C5935h.m9245G("Comment", this.AFJ);
        }
        c5931f.setMethod(i);
        this.AFH = c5931f;
        this.AFH.AFt = this.f1677xb;
        this.AFC.add(this.AFH.name);
        i2 = (i == 0 ? 0 : 8) | 2048;
        C5935h.m9247c(this.out, 67324752);
        C5935h.m9246c(this.out, 20);
        C5935h.m9246c(this.out, i2);
        C5935h.m9246c(this.out, i);
        C5935h.m9246c(this.out, this.AFH.oyB);
        C5935h.m9246c(this.out, this.AFH.AFr);
        if (i == 0) {
            C5935h.m9247c(this.out, this.AFH.AFe);
            C5935h.m9247c(this.out, this.AFH.size);
            C5935h.m9247c(this.out, this.AFH.size);
        } else {
            C5935h.m9247c(this.out, 0);
            C5935h.m9247c(this.out, 0);
            C5935h.m9247c(this.out, 0);
        }
        C5935h.m9246c(this.out, this.AFI.length);
        if (this.AFH.AFs != null) {
            C5935h.m9246c(this.out, this.AFH.AFs.length);
        } else {
            C5935h.m9246c(this.out, 0);
        }
        this.out.write(this.AFI);
        if (this.AFH.AFs != null) {
            this.out.write(this.AFH.AFs);
        }
    }

    public final void write(byte[] bArr, int i, int i2) {
        C5927a.m9235aH(bArr.length, i, i2);
        if (this.AFH == null) {
            throw new ZipException("No active entry");
        }
        this.out.write(bArr, i, i2);
    }

    private void dSw() {
        if (this.AFG == null) {
            throw new IOException("Stream is closed");
        }
    }

    /* renamed from: G */
    public static void m9245G(String str, byte[] bArr) {
        if (bArr.length > CdnLogic.kBizGeneric) {
            throw new IllegalArgumentException(str + " too long in UTF-8:" + bArr.length + " bytes");
        }
    }
}
