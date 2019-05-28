package com.tencent.mm.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.RandomAccessFile;

public final class e extends a {
    public static final int gkf = c.aT("vide");
    public static final int gkg = c.aT("soun");
    public static final int gkh = c.aT("hint");
    long duration = 0;
    long gki = 0;
    long gkj = 0;
    long gkk = 0;

    static {
        AppMethodBeat.i(117846);
        AppMethodBeat.o(117846);
    }

    public e(int i, long j, int i2) {
        super(i, j, i2, 0);
    }

    public final boolean a(RandomAccessFile randomAccessFile, byte[] bArr) {
        Object obj;
        AppMethodBeat.i(117845);
        Object obj2 = null;
        Object obj3 = null;
        Object obj4 = null;
        int read = randomAccessFile.read(bArr);
        while (read >= 8) {
            long j;
            int readInt = c.readInt(bArr, 0);
            int readInt2 = c.readInt(bArr, 4);
            if (readInt2 == a.aWy) {
                byte[] bArr2 = new byte[4];
                int read2 = randomAccessFile.read(bArr2);
                if (read2 < 4) {
                    readInt2 = -1;
                } else {
                    read2 += 0;
                    if (bArr2[0] == (byte) 0) {
                        if (c.a(randomAccessFile, 8)) {
                            readInt2 = read2 + 8;
                            read2 = randomAccessFile.read(bArr);
                            if (read2 < 8) {
                                readInt2 = -1;
                            } else {
                                readInt2 += read2;
                                this.gki = c.B(bArr, 0);
                                this.duration = c.B(bArr, 4);
                            }
                        } else {
                            readInt2 = -1;
                        }
                    } else if (c.a(randomAccessFile, 16)) {
                        read2 += 16;
                        int read3 = randomAccessFile.read(bArr2);
                        if (read3 < 4) {
                            readInt2 = -1;
                        } else {
                            read2 += read3;
                            this.gki = c.B(bArr2, 0);
                            readInt2 = randomAccessFile.read(bArr);
                            if (readInt2 < 8) {
                                readInt2 = -1;
                            } else {
                                readInt2 += read2;
                                this.duration = c.af(bArr);
                            }
                        }
                    } else {
                        readInt2 = -1;
                    }
                }
                if (readInt2 <= 0) {
                    ab.w("MicroMsg.MdiaAtom", "handle mdhd atom error.");
                    AppMethodBeat.o(117845);
                    return false;
                }
                obj2 = 1;
                j = (long) ((readInt - read) - readInt2);
                obj = obj4;
            } else if (readInt2 == a.aWz) {
                if (c.a(randomAccessFile, 8)) {
                    readInt2 = randomAccessFile.read(bArr, 0, 4);
                    if (readInt2 < 4) {
                        readInt2 = -1;
                    } else {
                        this.gkj = (long) c.readInt(bArr, 0);
                        readInt2 += 8;
                    }
                } else {
                    readInt2 = -1;
                }
                if (readInt2 <= 0) {
                    ab.w("MicroMsg.MdiaAtom", "handle hdlr atom error.");
                    AppMethodBeat.o(117845);
                    return false;
                }
                obj3 = 1;
                j = (long) ((readInt - read) - readInt2);
                obj = obj4;
            } else if (readInt2 == a.aWm) {
                this.gkk = randomAccessFile.getFilePointer() - ((long) read);
                j = (long) (readInt - read);
                readInt2 = 1;
            } else {
                j = (long) (readInt - 8);
                obj = obj4;
            }
            if (obj2 != null && r2 != null && obj != null) {
                break;
            } else if (c.a(randomAccessFile, j)) {
                read = randomAccessFile.read(bArr);
                obj4 = obj;
            } else {
                AppMethodBeat.o(117845);
                return false;
            }
        }
        obj = obj4;
        if (obj2 == null || r2 == null || r0 == null) {
            AppMethodBeat.o(117845);
            return false;
        }
        AppMethodBeat.o(117845);
        return true;
    }
}
