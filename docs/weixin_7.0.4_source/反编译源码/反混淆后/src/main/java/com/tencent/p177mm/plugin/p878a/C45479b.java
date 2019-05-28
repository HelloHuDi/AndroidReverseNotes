package com.tencent.p177mm.plugin.p878a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.tencent.mm.plugin.a.b */
public final class C45479b {
    public long gjO = -1;
    public long gjP = -1;
    public long gjQ = -1;
    public C37990a gjR = null;

    /* JADX WARNING: Removed duplicated region for block: B:57:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00d8 A:{SYNTHETIC, Splitter:B:36:0x00d8} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00f1 A:{SYNTHETIC, Splitter:B:44:0x00f1} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00d8 A:{SYNTHETIC, Splitter:B:36:0x00d8} */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0105 A:{Splitter:B:6:0x0027, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00f1 A:{SYNTHETIC, Splitter:B:44:0x00f1} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:50:0x0105, code skipped:
            r0 = th;
     */
    /* JADX WARNING: Missing block: B:55:0x010e, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:56:0x010f, code skipped:
            r1 = r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: vB */
    public final long mo73275vB(String str) {
        long j;
        long j2;
        Throwable e;
        long j3 = -1;
        AppMethodBeat.m2504i(117829);
        if (C42258c.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.AtomParsers", "calc moov atom location but filepath is null.");
            AppMethodBeat.m2505o(117829);
            return j3;
        }
        File file = new File(str);
        InputStream inputStream = null;
        InputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                this.gjQ = file.length();
                C37990a z = m83808z(fileInputStream);
                if (z == null) {
                    C4990ab.m7420w("MicroMsg.AtomParsers", "has no atom, this file may be not mp4");
                    j = j3;
                    j2 = j3;
                } else if (z.anX()) {
                    j2 = z.gjN;
                    j = z.getSize();
                } else if (z.anY()) {
                    C4990ab.m7420w("MicroMsg.AtomParsers", "it is the final atom, but can not find moov atom.");
                    j = j3;
                    j2 = j3;
                } else if (z.getSize() > 0) {
                    j2 = z.getEndPos();
                    j = j3;
                } else {
                    j = j3;
                    j2 = j3;
                }
                try {
                    fileInputStream.close();
                } catch (IOException e2) {
                    C4990ab.printErrStackTrace("MicroMsg.AtomParsers", e2, "", new Object[0]);
                }
            } catch (Exception e3) {
                e = e3;
                inputStream = fileInputStream;
                j2 = j3;
                try {
                    C4990ab.printErrStackTrace("MicroMsg.AtomParsers", e, "", new Object[0]);
                    if (inputStream != null) {
                    }
                    this.gjO = j2;
                    this.gjP = j;
                    C4990ab.m7416i("MicroMsg.AtomParsers", "calc moov atom location moovAtomLocation : " + j2 + " moovSize : " + this.gjP + " file length : " + (file.length() / 1024) + " K file path: " + str);
                    AppMethodBeat.m2505o(117829);
                    return j2;
                } catch (Throwable th) {
                    e = th;
                    fileInputStream = inputStream;
                    if (fileInputStream != null) {
                    }
                    AppMethodBeat.m2505o(117829);
                    throw e;
                }
            } catch (Throwable th2) {
            }
        } catch (Exception e4) {
            e = e4;
            j2 = j3;
            C4990ab.printErrStackTrace("MicroMsg.AtomParsers", e, "", new Object[0]);
            if (inputStream != null) {
                try {
                    inputStream.close();
                    j = j3;
                } catch (IOException e5) {
                    C4990ab.printErrStackTrace("MicroMsg.AtomParsers", e5, "", new Object[0]);
                    j = j3;
                }
            } else {
                j = j3;
            }
            this.gjO = j2;
            this.gjP = j;
            C4990ab.m7416i("MicroMsg.AtomParsers", "calc moov atom location moovAtomLocation : " + j2 + " moovSize : " + this.gjP + " file length : " + (file.length() / 1024) + " K file path: " + str);
            AppMethodBeat.m2505o(117829);
            return j2;
        } catch (Throwable th3) {
            e = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e6) {
                    C4990ab.printErrStackTrace("MicroMsg.AtomParsers", e6, "", new Object[0]);
                }
            }
            AppMethodBeat.m2505o(117829);
            throw e;
        }
        this.gjO = j2;
        this.gjP = j;
        C4990ab.m7416i("MicroMsg.AtomParsers", "calc moov atom location moovAtomLocation : " + j2 + " moovSize : " + this.gjP + " file length : " + (file.length() / 1024) + " K file path: " + str);
        AppMethodBeat.m2505o(117829);
        return j2;
    }

    /* renamed from: z */
    private C37990a m83808z(InputStream inputStream) {
        Throwable e;
        AppMethodBeat.m2504i(117830);
        if (0 < 0) {
            C4990ab.m7420w("MicroMsg.AtomParsers", "find Moov Atom, but parameter is error.");
            AppMethodBeat.m2505o(117830);
            return null;
        }
        C37990a c37990a = null;
        C37990a c37990a2;
        try {
            if (inputStream.skip(0) < 0) {
                AppMethodBeat.m2505o(117830);
                return null;
            }
            long j = 0;
            byte[] bArr = new byte[8];
            int read = inputStream.read(bArr, 0, 8);
            while (read >= 8) {
                try {
                    read = C42258c.readInt(bArr, 0);
                    int readInt = C42258c.readInt(bArr, 4);
                    long j2 = 0;
                    if (read == 1) {
                        if (inputStream.read(bArr, 0, 8) < 8) {
                            break;
                        }
                        j2 = C42258c.m74642af(bArr);
                    }
                    this.gjR = c37990a;
                    c37990a2 = new C37990a(read, j, readInt, j2);
                    try {
                        if (!c37990a2.anX() && !c37990a2.anY()) {
                            long j3;
                            if (read <= 1) {
                                if (j2 <= 0) {
                                    break;
                                }
                                j += j2;
                                j3 = (j2 - 8) - 8;
                            } else {
                                j3 = (long) (read - 8);
                                j += (long) read;
                            }
                            if (inputStream.skip(j3) < j3) {
                                break;
                            }
                            read = inputStream.read(bArr, 0, 8);
                            c37990a = c37990a2;
                        } else {
                            break;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        C4990ab.printErrStackTrace("MicroMsg.AtomParsers", e, "", new Object[0]);
                        AppMethodBeat.m2505o(117830);
                        return c37990a2;
                    }
                } catch (Exception e3) {
                    e = e3;
                    c37990a2 = c37990a;
                    C4990ab.printErrStackTrace("MicroMsg.AtomParsers", e, "", new Object[0]);
                    AppMethodBeat.m2505o(117830);
                    return c37990a2;
                }
            }
            c37990a2 = c37990a;
            AppMethodBeat.m2505o(117830);
            return c37990a2;
        } catch (Exception e4) {
            e = e4;
            c37990a2 = null;
            C4990ab.printErrStackTrace("MicroMsg.AtomParsers", e, "", new Object[0]);
            AppMethodBeat.m2505o(117830);
            return c37990a2;
        }
    }
}
