package com.tencent.tinker.d.a;

import com.tencent.mars.cdn.CdnLogic;
import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.zip.ZipException;

public final class h extends FilterOutputStream {
    public static final byte[] AFA = new byte[0];
    private static final byte[] AFB = new byte[]{(byte) -1, (byte) -1, (byte) -1, (byte) -1};
    private final HashSet<String> AFC;
    private final boolean AFD;
    public byte[] AFE;
    private int AFF;
    private ByteArrayOutputStream AFG;
    private f AFH;
    private byte[] AFI;
    private byte[] AFJ;
    private boolean AFK;
    private long xb;

    public h(OutputStream outputStream) {
        this(outputStream, (byte) 0);
    }

    private h(OutputStream outputStream, byte b) {
        super(outputStream);
        this.AFC = new HashSet();
        this.AFE = AFA;
        this.AFF = 8;
        this.AFG = new ByteArrayOutputStream();
        this.xb = 0;
        this.AFD = false;
    }

    private static long c(OutputStream outputStream, long j) {
        outputStream.write((int) (255 & j));
        outputStream.write(((int) (j >> 8)) & 255);
        outputStream.write(((int) (j >> 16)) & 255);
        outputStream.write(((int) (j >> 24)) & 255);
        return j;
    }

    private static int c(OutputStream outputStream, int i) {
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
            c(this.AFG, 101010256);
            c(this.AFG, 0);
            c(this.AFG, 0);
            if (this.AFK) {
                c(this.AFG, (int) CdnLogic.kBizGeneric);
                c(this.AFG, (int) CdnLogic.kBizGeneric);
                c(this.AFG, -1);
                c(this.AFG, -1);
            } else {
                c(this.AFG, this.AFC.size());
                c(this.AFG, this.AFC.size());
                c(this.AFG, (long) size);
                c(this.AFG, this.xb);
            }
            c(this.AFG, this.AFE.length);
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
                c(this.out, 134695760);
                c(this.out, this.AFH.AFe);
                c(this.out, this.AFH.AFp);
                c(this.out, this.AFH.size);
            }
            int i = (this.AFH.AFq == 0 ? 0 : 8) | 2048;
            c(this.AFG, 33639248);
            c(this.AFG, 20);
            c(this.AFG, 20);
            c(this.AFG, i);
            c(this.AFG, this.AFH.AFq);
            c(this.AFG, this.AFH.oyB);
            c(this.AFG, this.AFH.AFr);
            c(this.AFG, this.AFH.AFe);
            if (this.AFH.AFq == 8) {
                j += this.AFH.AFp;
            } else {
                j += this.AFH.size;
            }
            c(this.AFG, this.AFH.AFp);
            c(this.AFG, this.AFH.size);
            j += (long) c(this.AFG, this.AFI.length);
            if (this.AFH.AFs != null) {
                j += (long) c(this.AFG, this.AFH.AFs.length);
            } else {
                c(this.AFG, 0);
            }
            c(this.AFG, this.AFJ.length);
            c(this.AFG, 0);
            c(this.AFG, 0);
            c(this.AFG, 0);
            c(this.AFG, this.AFH.AFt);
            this.AFG.write(this.AFI);
            this.AFI = null;
            if (this.AFH.AFs != null) {
                this.AFG.write(this.AFH.AFs);
            }
            this.xb = j + this.xb;
            if (this.AFJ.length > 0) {
                this.AFG.write(this.AFJ);
                this.AFJ = AFA;
            }
            this.AFH = null;
        }
    }

    public final void b(f fVar) {
        int i;
        if (this.AFH != null) {
            closeEntry();
        }
        int i2 = fVar.AFq;
        if (i2 == -1) {
            i = this.AFF;
        } else {
            i = i2;
        }
        if (i == 0) {
            if (fVar.AFp == -1) {
                fVar.AFp = fVar.size;
            } else if (fVar.size == -1) {
                fVar.setSize(fVar.AFp);
            }
            if (fVar.AFe == -1) {
                throw new ZipException("STORED entry missing CRC");
            } else if (fVar.size == -1) {
                throw new ZipException("STORED entry missing size");
            } else if (fVar.size != fVar.AFp) {
                throw new ZipException("STORED entry size/compressed size mismatch");
            }
        }
        dSw();
        fVar.vGv = null;
        fVar.AFs = null;
        fVar.oyB = 40691;
        fVar.AFr = 18698;
        this.AFI = fVar.name.getBytes(d.UTF_8);
        G("Name", this.AFI);
        this.AFJ = AFA;
        if (fVar.vGv != null) {
            this.AFJ = fVar.vGv.getBytes(d.UTF_8);
            G("Comment", this.AFJ);
        }
        fVar.setMethod(i);
        this.AFH = fVar;
        this.AFH.AFt = this.xb;
        this.AFC.add(this.AFH.name);
        i2 = (i == 0 ? 0 : 8) | 2048;
        c(this.out, 67324752);
        c(this.out, 20);
        c(this.out, i2);
        c(this.out, i);
        c(this.out, this.AFH.oyB);
        c(this.out, this.AFH.AFr);
        if (i == 0) {
            c(this.out, this.AFH.AFe);
            c(this.out, this.AFH.size);
            c(this.out, this.AFH.size);
        } else {
            c(this.out, 0);
            c(this.out, 0);
            c(this.out, 0);
        }
        c(this.out, this.AFI.length);
        if (this.AFH.AFs != null) {
            c(this.out, this.AFH.AFs.length);
        } else {
            c(this.out, 0);
        }
        this.out.write(this.AFI);
        if (this.AFH.AFs != null) {
            this.out.write(this.AFH.AFs);
        }
    }

    public final void write(byte[] bArr, int i, int i2) {
        a.aH(bArr.length, i, i2);
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

    public static void G(String str, byte[] bArr) {
        if (bArr.length > CdnLogic.kBizGeneric) {
            throw new IllegalArgumentException(str + " too long in UTF-8:" + bArr.length + " bytes");
        }
    }
}
