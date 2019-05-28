package com.tencent.p177mm.plugin.p878a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.RandomAccessFile;

/* renamed from: com.tencent.mm.plugin.a.e */
public final class C26532e extends C37990a {
    public static final int gkf = C42258c.m74641aT("vide");
    public static final int gkg = C42258c.m74641aT("soun");
    public static final int gkh = C42258c.m74641aT("hint");
    long duration = 0;
    long gki = 0;
    long gkj = 0;
    long gkk = 0;

    static {
        AppMethodBeat.m2504i(117846);
        AppMethodBeat.m2505o(117846);
    }

    public C26532e(int i, long j, int i2) {
        super(i, j, i2, 0);
    }

    /* renamed from: a */
    public final boolean mo44318a(RandomAccessFile randomAccessFile, byte[] bArr) {
        Object obj;
        AppMethodBeat.m2504i(117845);
        Object obj2 = null;
        Object obj3 = null;
        Object obj4 = null;
        int read = randomAccessFile.read(bArr);
        while (read >= 8) {
            long j;
            int readInt = C42258c.readInt(bArr, 0);
            int readInt2 = C42258c.readInt(bArr, 4);
            if (readInt2 == C37990a.aWy) {
                byte[] bArr2 = new byte[4];
                int read2 = randomAccessFile.read(bArr2);
                if (read2 < 4) {
                    readInt2 = -1;
                } else {
                    read2 += 0;
                    if (bArr2[0] == (byte) 0) {
                        if (C42258c.m74640a(randomAccessFile, 8)) {
                            readInt2 = read2 + 8;
                            read2 = randomAccessFile.read(bArr);
                            if (read2 < 8) {
                                readInt2 = -1;
                            } else {
                                readInt2 += read2;
                                this.gki = C42258c.m74638B(bArr, 0);
                                this.duration = C42258c.m74638B(bArr, 4);
                            }
                        } else {
                            readInt2 = -1;
                        }
                    } else if (C42258c.m74640a(randomAccessFile, 16)) {
                        read2 += 16;
                        int read3 = randomAccessFile.read(bArr2);
                        if (read3 < 4) {
                            readInt2 = -1;
                        } else {
                            read2 += read3;
                            this.gki = C42258c.m74638B(bArr2, 0);
                            readInt2 = randomAccessFile.read(bArr);
                            if (readInt2 < 8) {
                                readInt2 = -1;
                            } else {
                                readInt2 += read2;
                                this.duration = C42258c.m74642af(bArr);
                            }
                        }
                    } else {
                        readInt2 = -1;
                    }
                }
                if (readInt2 <= 0) {
                    C4990ab.m7420w("MicroMsg.MdiaAtom", "handle mdhd atom error.");
                    AppMethodBeat.m2505o(117845);
                    return false;
                }
                obj2 = 1;
                j = (long) ((readInt - read) - readInt2);
                obj = obj4;
            } else if (readInt2 == C37990a.aWz) {
                if (C42258c.m74640a(randomAccessFile, 8)) {
                    readInt2 = randomAccessFile.read(bArr, 0, 4);
                    if (readInt2 < 4) {
                        readInt2 = -1;
                    } else {
                        this.gkj = (long) C42258c.readInt(bArr, 0);
                        readInt2 += 8;
                    }
                } else {
                    readInt2 = -1;
                }
                if (readInt2 <= 0) {
                    C4990ab.m7420w("MicroMsg.MdiaAtom", "handle hdlr atom error.");
                    AppMethodBeat.m2505o(117845);
                    return false;
                }
                obj3 = 1;
                j = (long) ((readInt - read) - readInt2);
                obj = obj4;
            } else if (readInt2 == C37990a.aWm) {
                this.gkk = randomAccessFile.getFilePointer() - ((long) read);
                j = (long) (readInt - read);
                readInt2 = 1;
            } else {
                j = (long) (readInt - 8);
                obj = obj4;
            }
            if (obj2 != null && r2 != null && obj != null) {
                break;
            } else if (C42258c.m74640a(randomAccessFile, j)) {
                read = randomAccessFile.read(bArr);
                obj4 = obj;
            } else {
                AppMethodBeat.m2505o(117845);
                return false;
            }
        }
        obj = obj4;
        if (obj2 == null || r2 == null || r0 == null) {
            AppMethodBeat.m2505o(117845);
            return false;
        }
        AppMethodBeat.m2505o(117845);
        return true;
    }
}
