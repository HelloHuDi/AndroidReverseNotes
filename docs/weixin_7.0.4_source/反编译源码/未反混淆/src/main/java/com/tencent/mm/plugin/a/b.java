package com.tencent.mm.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class b {
    public long gjO = -1;
    public long gjP = -1;
    public long gjQ = -1;
    public a gjR = null;

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
    public final long vB(String str) {
        long j;
        long j2;
        Throwable e;
        long j3 = -1;
        AppMethodBeat.i(117829);
        if (c.isNullOrNil(str)) {
            ab.w("MicroMsg.AtomParsers", "calc moov atom location but filepath is null.");
            AppMethodBeat.o(117829);
            return j3;
        }
        File file = new File(str);
        InputStream inputStream = null;
        InputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                this.gjQ = file.length();
                a z = z(fileInputStream);
                if (z == null) {
                    ab.w("MicroMsg.AtomParsers", "has no atom, this file may be not mp4");
                    j = j3;
                    j2 = j3;
                } else if (z.anX()) {
                    j2 = z.gjN;
                    j = z.getSize();
                } else if (z.anY()) {
                    ab.w("MicroMsg.AtomParsers", "it is the final atom, but can not find moov atom.");
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
                    ab.printErrStackTrace("MicroMsg.AtomParsers", e2, "", new Object[0]);
                }
            } catch (Exception e3) {
                e = e3;
                inputStream = fileInputStream;
                j2 = j3;
                try {
                    ab.printErrStackTrace("MicroMsg.AtomParsers", e, "", new Object[0]);
                    if (inputStream != null) {
                    }
                    this.gjO = j2;
                    this.gjP = j;
                    ab.i("MicroMsg.AtomParsers", "calc moov atom location moovAtomLocation : " + j2 + " moovSize : " + this.gjP + " file length : " + (file.length() / 1024) + " K file path: " + str);
                    AppMethodBeat.o(117829);
                    return j2;
                } catch (Throwable th) {
                    e = th;
                    fileInputStream = inputStream;
                    if (fileInputStream != null) {
                    }
                    AppMethodBeat.o(117829);
                    throw e;
                }
            } catch (Throwable th2) {
            }
        } catch (Exception e4) {
            e = e4;
            j2 = j3;
            ab.printErrStackTrace("MicroMsg.AtomParsers", e, "", new Object[0]);
            if (inputStream != null) {
                try {
                    inputStream.close();
                    j = j3;
                } catch (IOException e5) {
                    ab.printErrStackTrace("MicroMsg.AtomParsers", e5, "", new Object[0]);
                    j = j3;
                }
            } else {
                j = j3;
            }
            this.gjO = j2;
            this.gjP = j;
            ab.i("MicroMsg.AtomParsers", "calc moov atom location moovAtomLocation : " + j2 + " moovSize : " + this.gjP + " file length : " + (file.length() / 1024) + " K file path: " + str);
            AppMethodBeat.o(117829);
            return j2;
        } catch (Throwable th3) {
            e = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e6) {
                    ab.printErrStackTrace("MicroMsg.AtomParsers", e6, "", new Object[0]);
                }
            }
            AppMethodBeat.o(117829);
            throw e;
        }
        this.gjO = j2;
        this.gjP = j;
        ab.i("MicroMsg.AtomParsers", "calc moov atom location moovAtomLocation : " + j2 + " moovSize : " + this.gjP + " file length : " + (file.length() / 1024) + " K file path: " + str);
        AppMethodBeat.o(117829);
        return j2;
    }

    private a z(InputStream inputStream) {
        Throwable e;
        AppMethodBeat.i(117830);
        if (0 < 0) {
            ab.w("MicroMsg.AtomParsers", "find Moov Atom, but parameter is error.");
            AppMethodBeat.o(117830);
            return null;
        }
        a aVar = null;
        a aVar2;
        try {
            if (inputStream.skip(0) < 0) {
                AppMethodBeat.o(117830);
                return null;
            }
            long j = 0;
            byte[] bArr = new byte[8];
            int read = inputStream.read(bArr, 0, 8);
            while (read >= 8) {
                try {
                    read = c.readInt(bArr, 0);
                    int readInt = c.readInt(bArr, 4);
                    long j2 = 0;
                    if (read == 1) {
                        if (inputStream.read(bArr, 0, 8) < 8) {
                            break;
                        }
                        j2 = c.af(bArr);
                    }
                    this.gjR = aVar;
                    aVar2 = new a(read, j, readInt, j2);
                    try {
                        if (!aVar2.anX() && !aVar2.anY()) {
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
                            aVar = aVar2;
                        } else {
                            break;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        ab.printErrStackTrace("MicroMsg.AtomParsers", e, "", new Object[0]);
                        AppMethodBeat.o(117830);
                        return aVar2;
                    }
                } catch (Exception e3) {
                    e = e3;
                    aVar2 = aVar;
                    ab.printErrStackTrace("MicroMsg.AtomParsers", e, "", new Object[0]);
                    AppMethodBeat.o(117830);
                    return aVar2;
                }
            }
            aVar2 = aVar;
            AppMethodBeat.o(117830);
            return aVar2;
        } catch (Exception e4) {
            e = e4;
            aVar2 = null;
            ab.printErrStackTrace("MicroMsg.AtomParsers", e, "", new Object[0]);
            AppMethodBeat.o(117830);
            return aVar2;
        }
    }
}
